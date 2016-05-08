package com.example.yunus.trakyadepo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.ArrayRes;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.yunus.trakyadepo.Adapter.SpinnerAdapter;
import com.example.yunus.trakyadepo.Infrastructure.IOPosts;
import com.example.yunus.trakyadepo.Infrastructure.IOgetValue;
import com.example.yunus.trakyadepo.Infrastructure.Mainapp;
import com.example.yunus.trakyadepo.Infrastructure.ws;
import com.example.yunus.trakyadepo.Model.Ders;
import com.example.yunus.trakyadepo.Model.Gonderi;
import com.example.yunus.trakyadepo.Model.GonderiFilter;
import com.example.yunus.trakyadepo.Model.Soru;
import com.example.yunus.trakyadepo.Model.Uye;
import com.example.yunus.trakyadepo.Model.errorType;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

/**
 * Created by yunus on 9.03.2016.
 */
public class newpostActivity extends AppCompatActivity {
    private List<Ders> dersler= new ArrayList<>();
    @Bind(R.id.Gonderibasliks)
    EditText basliks;
    @Bind(R.id.link)
    EditText link;
    @Bind(R.id.icerikGonderi)
    EditText icerik;
    @Bind(R.id.spinnerderssec)
    Spinner derssec;
    private SpinnerAdapter adapter;
    Context context;
    private String secilen_ders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.newpost);
        ButterKnife.bind(this);
        spinner_verisi();
        context=this;
        derssec.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                // Here you get the current item (a User object) that is selected by its position
                Ders user = adapter.getItem(position);
                // Here you can do the action you want to...

                  secilen_ders=user.getDersAdi().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapter) {  }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.newpost, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_plus:
                IOgetValue service= ws.getwsValue();

                Call<errorType> control = service.gonderi_ekle(new GonderiFilter(secilen_ders,Mainapp.UserPrefs.LogedInUser().get().getUserID(),basliks.getText().toString(),icerik.getText().toString(),link.getText().toString()));

                control.enqueue(new Callback<errorType>() {
                    @Override
                    public void onResponse(Response<errorType> response) {

                        Toast.makeText(context,"Gonderi eklendi..",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(context,MainActivity.class));
                    }
                    @Override
                    public void onFailure(Throwable t) {
                        Toast.makeText(context,"Bağlantı yok",Toast.LENGTH_SHORT).show();
                    }
                });

        break;

        // more code...
    }
        return true;
    }

    private  void spinner_verisi(){
        IOgetValue service= ws.getwsValue();

        Call<List<Ders>> control = service.dersleri_listele(Mainapp.UserPrefs.LogedInUser().get().getUserID());

        control.enqueue(new Callback<List<Ders>>() {
            @Override
            public void onResponse(Response<List<Ders>> response) {
                dersler=response.body();
                adapter = new SpinnerAdapter(getBaseContext(),
                        android.R.layout.simple_spinner_item,dersler
                        );
                derssec.setAdapter(adapter);
            }

            @Override
            public void onFailure(Throwable t) {

                Toast.makeText(getApplicationContext(), "Bağlantı yok", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
