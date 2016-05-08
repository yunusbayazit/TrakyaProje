package com.example.yunus.trakyadepo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yunus.trakyadepo.Infrastructure.IOPosts;
import com.example.yunus.trakyadepo.Infrastructure.IOauth;
import com.example.yunus.trakyadepo.Infrastructure.Mainapp;
import com.example.yunus.trakyadepo.Infrastructure.UserPrefs;
import com.example.yunus.trakyadepo.Infrastructure.userControllerfilter;
import com.example.yunus.trakyadepo.Infrastructure.ws;

import com.example.yunus.trakyadepo.Model.Soru;
import com.example.yunus.trakyadepo.Model.errorType;
import com.example.yunus.trakyadepo.Model.modelauth;
import com.lacronicus.easydatastorelib.DatastoreBuilder;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

/**
 * Created by yunus on 9.03.2016.
 */
public class soruActivity extends AppCompatActivity {
Context context;
    @Bind(R.id.icerikedttxt)
    EditText icerikedttxt;

    @Bind(R.id.SoruBasliktxt)
    EditText SoruBasliktxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.soruactivity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);
        context=this;
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
                // Launch settings activity
                IOPosts service= ws.getwsPost();

                Call<errorType> control = service.insert_question(new Soru("",Mainapp.UserPrefs.LogedInUser().get().getUserID(),"",SoruBasliktxt.getText().toString(),icerikedttxt.getText().toString()));

                control.enqueue(new Callback<errorType>() {
                    @Override
                    public void onResponse(Response<errorType> response) {

                        Toast.makeText(context,"Soru eklendi..",Toast.LENGTH_SHORT).show();
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
}