package com.example.yunus.trakyadosyapaylasim;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.activeandroid.Model;
import com.activeandroid.query.Select;
import com.example.yunus.trakyadosyapaylasim.Model.Auth;
import com.example.yunus.trakyadosyapaylasim.Model.securty;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends Activity {
    @Bind(R.id.GirisButton)
    Button buttonGiris;

@Bind(R.id.lgnchck)
    CheckBox lgnchck;

    @Bind(R.id.Kullanıcı_Adi)
    EditText Kullanıcı_Adı;

    @Bind(R.id.Sifre)
    EditText Sifre;

    @Bind(R.id.KayitButton)
    Button buttonKayit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        new BackgroundTask().execute();


    }

    @OnClick(R.id.KayitButton)
    public void Kayit_Click(Button button) {


        Intent intent = new Intent(getBaseContext(), kayitOl.class).addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);

    }

    @OnClick(R.id.GirisButton)
    public void Giris_Click(Button button) {

        if (lgnchck.isChecked()) {
            if (Kullanıcı_Adı.getText().toString().equals("Yannis") && (Sifre.getText().toString().equals("123"))) {

                String Kullanıcı_adı = Kullanıcı_Adı.getText().toString();
                int Sifree = Integer.parseInt(Sifre.getText().toString());

                securty person = new securty(Kullanıcı_adı, Sifree);
                person.save();

                Intent intent = new Intent(getBaseContext(), MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            } else {

                Toast toast = Toast.makeText(getApplicationContext(), "Hatalı Kullanıcı Adı veya Sifre Girdiniz", Toast.LENGTH_SHORT);
                toast.show();

            }
        }
        else{

            if (Kullanıcı_Adı.getText().toString().equals("Yannis") && (Sifre.getText().toString().equals("123"))) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

                startActivity(intent);
        }
            else {

                Toast toast = Toast.makeText(getApplicationContext(), "Hatalı Kullanıcı Adı veya Sifre Girdiniz", Toast.LENGTH_SHORT);
                toast.show();

            }
    }
    }
    public class BackgroundTask extends AsyncTask<Void, Void, Void> {

        ProgressDialog pg =new ProgressDialog(LoginActivity.this);
        @Override
        protected void onPreExecute() {

        pg.setMessage("Lütfen Bekleyiniz...");
        pg.show();
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            securty item = new Select().from(securty.class).where("ID = ?", "1").executeSingle();

            if (item != null)
            {
                Intent intent = new Intent(getBaseContext(), MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

                startActivity(intent);
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            pg.dismiss();
            super.onPostExecute(result);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onCancelled(Void result) {
            super.onCancelled(result);
        }

    }
}