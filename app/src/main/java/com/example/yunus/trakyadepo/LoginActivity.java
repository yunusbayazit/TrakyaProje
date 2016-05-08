package com.example.yunus.trakyadepo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.activeandroid.query.Select;
import com.example.yunus.trakyadepo.Infrastructure.IOPosts;
import com.example.yunus.trakyadepo.Infrastructure.IOauth;
import com.example.yunus.trakyadepo.Infrastructure.Mainapp;
import com.example.yunus.trakyadepo.Infrastructure.UserPrefs;
import com.example.yunus.trakyadepo.Infrastructure.userControllerfilter;
import com.example.yunus.trakyadepo.Infrastructure.ws;
import com.example.yunus.trakyadepo.Model.Auth;
import com.example.yunus.trakyadepo.Model.modelauth;
import com.lacronicus.easydatastorelib.DatastoreBuilder;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity {

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    Context context;

    @Bind(R.id.btngiris)
    Button buttonGiris;

    @Bind(R.id.email)
    EditText Kullanıcı_Adı;

    @Bind(R.id.password)
    EditText Sifre;

    @Bind(R.id.kytbtn)
    Button buttonKayit;
    private String userName;
    private String password;

    ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        ButterKnife.bind(this);
       // new UserLoginTask().execute();
        context=this;

    }


    /**
     * Set up the {@link android.app.ActionBar}, if the API is available.
     */



    @OnClick(R.id.btngiris)
    public void Giris_Click(Button button) {
        progress = ProgressDialog.show(this,"",
                "Lütfen bekleyiniz...", true);

        IOauth service= ws.getws();

        Call<modelauth> control = service.login(new userControllerfilter(Kullanıcı_Adı.getText().toString(),Sifre.getText().toString()));

        control.enqueue(new Callback<modelauth>() {
            @Override
            public void onResponse(Response<modelauth> response) {

                if (response.body()==null){
                    Toast.makeText(context,"Hatalı Kullanıcı Adı veya Şifre Girdiniz",Toast.LENGTH_SHORT).show();
                }else
                {
                    Mainapp.UserPrefs = new DatastoreBuilder(PreferenceManager.getDefaultSharedPreferences(context))
                            .create(UserPrefs.class);
                    Mainapp.UserPrefs.LogedInUser().put(response.body());
                    startActivity(new Intent(context,MainActivity.class));
                }

                progress.dismiss();


            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(context,"bağlantı başarısız...",Toast.LENGTH_SHORT).show();
                progress.dismiss();

            }
        });

         /*   if (Kullanıcı_Adı.getText().toString().equals("Yannis") && (Sifre.getText().toString().equals("123"))) {

                String Kullanıcı_adı = Kullanıcı_Adı.getText().toString();
                int Sifree = Integer.parseInt(Sifre.getText().toString());

                Auth person = new Auth(Kullanıcı_adı, Sifree);
                person.save();

                Intent intent = new Intent(getBaseContext(), MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            } else {

                Toast toast = Toast.makeText(getApplicationContext(), "Hatalı Kullanıcı Adı veya Sifre Girdiniz", Toast.LENGTH_SHORT);
                toast.show();

            } */
    }



    @OnClick(R.id.kytbtn)
    public void Kayit_Click(Button button) {
        // This is how you execute a query
      //  Select select = new Select();

        // Call select.all() to select all rows from our table which is
        // represented by Person.class and execute the query.

        // It returns an ArrayList of our Person objects where each object
        // contains data corresponding to a row of our database.

       // List<Auth> people = select.all().from(Auth.class).execute();

        // Iterate through the ArrayList to get all our data. We ll simply add
        // all the data to our StringBuilder to display it inside a Toast.

      /*  StringBuilder builder = new StringBuilder();
        for (Auth person : people) {
            builder.append("Name: ")
                    .append(person.kullanici_adi)
                    .append(" Age: ")
                    .append(person.sifre)
                    .append("\n");
        }

        Toast.makeText(this, builder.toString(), Toast.LENGTH_SHORT).show();

        /**/
        Intent intent = new Intent(getBaseContext(), kayitActivity.class).addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);

    }


   /* @Override
    protected void onRestart() {
        new UserLoginTask().execute();
        super.onRestart();
    }
    */

  /*  public class UserLoginTask extends AsyncTask<Void, Void, Void> {


        ProgressDialog pg = new ProgressDialog(LoginActivity.this);

        @Override
        protected void onPreExecute() {

            pg.setMessage("Lütfen Bekleyiniz...");
            pg.show();
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            List<Auth> allAuthors = new Select().all().from(Auth.class).execute();
            if (!allAuthors.isEmpty()) {
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



*/
  public String getPassword() {
      return Sifre.getText().toString();
  }

    public void setPassword(String password) {
        this.password = password;
        Sifre.setText(password);
    }

    public String getUserName() {
        return Kullanıcı_Adı.getText().toString();
    }

    public void setUserName(String userName) {
        this.userName = userName;
        Kullanıcı_Adı.setText(userName);
    }
}

