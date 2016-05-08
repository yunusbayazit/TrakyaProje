package com.example.yunus.trakyadepo.Fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.yunus.trakyadepo.Adapter.RecyclerAdapter;
import com.example.yunus.trakyadepo.Infrastructure.IOgetValue;
import com.example.yunus.trakyadepo.Infrastructure.Mainapp;
import com.example.yunus.trakyadepo.Infrastructure.ws;
import com.example.yunus.trakyadepo.MainActivity;
import com.example.yunus.trakyadepo.Model.Soru;
import com.example.yunus.trakyadepo.R;
import com.example.yunus.trakyadepo.etkinlikActivity;
import com.example.yunus.trakyadepo.newpostActivity;
import com.example.yunus.trakyadepo.soruActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

/**
 * Created by yunus on 11.01.2016.
 */
public class twofragment extends Fragment {

    private View view;

    private String title;//String for tab title
   /*

    private ImageView image;

    private ArrayList<Soru> a;
    private static RecyclerView recyclerView;
    List<String> control;
  //  ProgressDialog progress;
    Context context;
  //  private List<Soru> pliste= new ArrayList<>();
*/
    public twofragment() {
       // image.setImageResource(R.drawable.trakya);
    }

    public twofragment(String title) {
        this.title = title;//Setting tab title
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // progress = ProgressDialog.show(getActivity(), "", "Bilgiler Alınıyor...", true);

        view = inflater.inflate(R.layout.twofragment, container, false);


/*
        setRecyclerView();

        IOgetValue service= ws.getwsValue();
        Call<List<Soru>> control = service.groupList(Mainapp.UserPrefs.LogedInUser().get().getUserID());
        control.enqueue(new Callback<List<Soru>>() {
            @Override
            public void onResponse(Response<List<Soru>> response) {

                pliste = response.body();
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
        progress.dismiss();
        */
        return view;
    }
    //Setting recycler view
    private void setRecyclerView() {
/*
        recyclerView = (RecyclerView) view
                .findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView
                .setLayoutManager(new LinearLayoutManager(getActivity()));//Linear Items




        ERecyclerAdapter adapter = new RecyclerAdapter(getActivity(), pliste);
        recyclerView.setAdapter(adapter);// set adapter on recyclerview

    }
*/
        /*
    @OnClick(R.id.fab)
    public void submit(View view) {
        //Implementing tab selected listener over tablayout
        int a;

        a = MainActivity.viewPager.getCurrentItem();
        switch (a) {
            case 0:
                Intent intt = new Intent(getActivity(), newpostActivity.class);
                startActivity(intt);
                break;
            case 1:
                Intent inlt = new Intent(getActivity(), soruActivity.class);
                startActivity(inlt);
                break;
            case 2:
                Intent inlst = new Intent(getActivity(), etkinlikActivity.class);
                startActivity(inlst);
                break;
        }*/
    }
}