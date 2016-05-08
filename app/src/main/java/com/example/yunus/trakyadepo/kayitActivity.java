package com.example.yunus.trakyadepo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.ArrayRes;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.yunus.trakyadepo.Infrastructure.IOPosts;
import com.example.yunus.trakyadepo.Infrastructure.IOgetValue;
import com.example.yunus.trakyadepo.Infrastructure.Mainapp;
import com.example.yunus.trakyadepo.Infrastructure.ws;
import com.example.yunus.trakyadepo.Model.Soru;
import com.example.yunus.trakyadepo.Model.Uye;
import com.example.yunus.trakyadepo.Model.errorType;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

/**
 * Created by yunus on 11.01.2016.
 */
public class kayitActivity extends AppCompatActivity {

    @Bind(R.id.txtOgrenciAdi)
    EditText txtOgrenciAdi;

    @Bind(R.id.txtOgrenciSoyadi)
    EditText txtOgrenciSoyadı;

    @Bind(R.id.txtEmail)
    EditText txtEmail;

    @Bind(R.id.txtParola)
    EditText txtParola;

    @Bind(R.id.txtAdres)
    EditText txtAdres;

    @Bind(R.id.SpinnerFakulteler)
    Spinner SpinnerFakulte;

    @Bind(R.id.SpinnerSınıf)
    Spinner SpinnerSınıf;
    @Bind(R.id.Cinsiyet)
    Spinner SpinnerCinsiyet;
    ProgressDialog progress;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kayit_activity);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        spinnerDoldur(SpinnerFakulte, R.array.Fakulteler);
        spinnerDoldur(SpinnerSınıf, R.array.Sınıflar);
        spinnerDoldur(SpinnerCinsiyet, R.array.Cinsiyetler);


    }

    private void spinnerDoldur(Spinner spinner,@ArrayRes int array) {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

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
                if(txtOgrenciAdi.getText().toString().matches("")){
                    txtOgrenciAdi.setError("Adınızı Giriniz.");
                }
                else
                if (txtOgrenciSoyadı.getText().toString().matches("")) {
                    txtOgrenciSoyadı.setError("Soyadınızı Giriniz.");
                }
                else
                if(!checkEmail(txtEmail.getText().toString())) {

                    txtEmail.setError("Sadece trakya.edu.tr uzantılı E-Mailler ile Kayıt Olabilirsiniz.");
                }
                else

                if (txtParola.getText().toString().matches("")) {
                    txtParola.setError("Parola giriniz.");
                }
                else

                    kayitOl();

        }

        return true;}

    public static final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@trakya.edu.tr"

    );

    private boolean checkEmail(String email) {
        return EMAIL_ADDRESS_PATTERN.matcher(email).matches();
    }

    private void kayitOl() {
        progress = ProgressDialog.show(this,"",
                "Lütfen bekleyiniz...", true);
        IOPosts service= ws.getwsPost();

        Call<errorType> control = service.addStudent(new Uye(txtOgrenciAdi.getText().toString()
                ,txtOgrenciSoyadı.getText().toString()
                ,txtAdres.getText().toString(),txtEmail.getText().toString(), txtParola.getText().toString(),"Edirne",2,1));

        control.enqueue(new Callback<errorType>() {
            @Override
            public void onResponse(Response<errorType> response) {

                Toast.makeText(getApplicationContext(), "Kayıt işlemi başarılı...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                progress.dismiss();
            }

            @Override
            public void onFailure(Throwable t) {

                Toast.makeText(getApplicationContext(), "Bağlantı yok", Toast.LENGTH_SHORT).show();
                progress.dismiss();
            }
        });


    }

}