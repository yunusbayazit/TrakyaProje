package com.example.yunus.trakyadepo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yunus.trakyadepo.Adapter.SpinnerAdapter;
import com.example.yunus.trakyadepo.Infrastructure.IOgetValue;
import com.example.yunus.trakyadepo.Infrastructure.Mainapp;
import com.example.yunus.trakyadepo.Infrastructure.ws;
import com.example.yunus.trakyadepo.Model.Ders;
import com.example.yunus.trakyadepo.Model.DersSecimiFilter;
import com.example.yunus.trakyadepo.Model.Gonderi;
import com.example.yunus.trakyadepo.Model.errorType;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

/**
 * Created by yunus on 27.04.2016.
 */
public class DersSecimi extends Activity {

    List<Ders> pliste = new ArrayList<>();
    private List<Ders> dersler= new ArrayList<>();
    MyCustomAdapter dataAdapter = null;
    static Context context;
    int id;
    CheckBox cb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.ders_secimi);
        //Generate list View from ArrayList
context=this;

        id=Mainapp.UserPrefs.LogedInUser().get().getUserID();
        secili_dersler();
       IOgetValue service = ws.getwsValue();

        final Call<List<Ders>> control = service.bolum_dersleri_listele(Mainapp.UserPrefs.LogedInUser().get().getUserID());

        control.enqueue(new Callback<List<Ders>>() {
            @Override
            public void onResponse(Response<List<Ders>> response) {
                pliste = response.body();

                for (int i = 0; i < pliste.size(); i++) {
                    for (int j = 0; j < dersler.size(); j++) {
                        if (pliste.get(i).getDersID() == dersler.get(j).getDersID()) {
                            pliste.get(i).setSelected(true);
                            break;
                        }
                    }
                }
                displayListView();
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(getApplicationContext(), "Bağlantı yok", Toast.LENGTH_SHORT).show();
            }
        });

    }


        private void secili_dersler() {
            IOgetValue service= ws.getwsValue();

            Call<List<Ders>> control = service.dersleri_listele(id);

            control.enqueue(new Callback<List<Ders>>() {
                @Override
                public void onResponse(Response<List<Ders>> response) {
                    dersler=response.body();
                }

                @Override
                public void onFailure(Throwable t) {

                    Toast.makeText(getApplicationContext(), "Bağlantı yok", Toast.LENGTH_SHORT).show();
                }
            });

        }



    private void displayListView() {
        //create an ArrayAdaptar from the String Array
        dataAdapter = new MyCustomAdapter(this.getBaseContext(),
                R.layout.ders_secimi_listcview, pliste);
        ListView listView = (ListView) findViewById(R.id.listView1);
        // Assign adapter to ListView
       listView.setAdapter(dataAdapter);
    }
    private class MyCustomAdapter extends ArrayAdapter<Ders> {

        private List<Ders> countryList;

        public MyCustomAdapter(Context context, int textViewResourceId,
                               List<Ders> countryList) {
            super(context, textViewResourceId, countryList);
            this.countryList = new ArrayList<>();
            this.countryList.addAll(countryList);
        }

        private class ViewHolder {
            CheckBox chck;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            Log.v("ConvertView", String.valueOf(position));

            if (convertView == null) {
                LayoutInflater vi = (LayoutInflater) getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.ders_secimi_listcview, null);

                holder = new ViewHolder();
                holder.chck = (CheckBox) convertView.findViewById(R.id.chck);
                convertView.setTag(holder);

                holder.chck.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        cb = (CheckBox) v;
                        final Ders country = (Ders) cb.getTag();
                        if (cb.isChecked()==true ){
                            new AlertDialog.Builder(context).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Uyarı")
                                .setMessage(cb.getText()+" Adlı dersi takip etmek istiyormusunuz?")
                                .setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        int i=country.getDersID();
                                        yeniabone(new DersSecimiFilter(Mainapp.UserPrefs.LogedInUser().get().getUserID(), country.getDersID()));
Toast.makeText(context," Ders başarılı bir şekilde eklendi",Toast.LENGTH_SHORT);

                                    }
                                }).setNegativeButton("Hayır",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {

                                    cb.setChecked(false);
                                    dialog.dismiss();
                                }
                            }).show();
                        }
                        else {
                            new AlertDialog.Builder(context).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Uyarı")
                                .setMessage(cb.getText()+" Adlı dersi takipden çıkarmak istiyormusun?")
                                .setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        int i=country.getDersID();
                                        abonecıkar(new DersSecimiFilter(Mainapp.UserPrefs.LogedInUser().get().getUserID(), country.getDersID()));
                                        Toast.makeText(context,"Ders başarılı bir şekilde eklendi",Toast.LENGTH_SHORT);
                                    }
                                }).setNegativeButton("Hayır",new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        cb.setChecked(true);
                                        dialog.dismiss();
                                    }
                                }).show();
                        }
                    }
                });
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            Ders country = countryList.get(position);

            holder.chck.setText(country.getDersAdi());
            holder.chck.setChecked(country.isSelected());
            holder.chck.setTag(country);

            return convertView;
        }

        private void abonecıkar(DersSecimiFilter ders) {
            IOgetValue service = ws.getwsValue();

            final Call<errorType> control1 = service.abone_cıkar(ders);

            control1.enqueue(new Callback<errorType>() {
                @Override
                public void onResponse(Response<errorType> response) {
                    Toast toast = Toast.makeText(context, "Ders Cıkarıldı", Toast.LENGTH_SHORT);
                    toast.show();                }

                @Override
                public void onFailure(Throwable t) {
                    Toast.makeText(getApplicationContext(), "Bağlantı yok", Toast.LENGTH_SHORT).show();
                }
            });

        }

        private void yeniabone(DersSecimiFilter ders) {
            IOgetValue service = ws.getwsValue();

            final Call<errorType> control1 = service.yeni_abone(ders);

            control1.enqueue(new Callback<errorType>() {
                @Override
                public void onResponse(Response<errorType> response) {
                    Toast toast = Toast.makeText(context, "Ders Eklendi", Toast.LENGTH_SHORT);
                    toast.show();                }

                @Override
                public void onFailure(Throwable t) {
                    Toast.makeText(getApplicationContext(), "Bağlantı yok", Toast.LENGTH_SHORT).show();
                }
            });

        }

    }

    }