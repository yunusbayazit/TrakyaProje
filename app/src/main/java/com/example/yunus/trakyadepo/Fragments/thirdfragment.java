package com.example.yunus.trakyadepo.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yunus.trakyadepo.Adapter.RecyclerAdapter;
import com.example.yunus.trakyadepo.Adapter.etkinlikRecyclerAdapter;
import com.example.yunus.trakyadepo.Infrastructure.IOPosts;
import com.example.yunus.trakyadepo.Infrastructure.Mainapp;
import com.example.yunus.trakyadepo.Infrastructure.ws;
import com.example.yunus.trakyadepo.MainActivity;
import com.example.yunus.trakyadepo.Model.Etkinlik;
import com.example.yunus.trakyadepo.R;
import com.example.yunus.trakyadepo.etkinlikActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

/**
 * Created by yunus on 13.04.2016.
 */
public class thirdfragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private View view;

    private String title;//String for tab title
    private  RecyclerView recyclerView;
    SwipeRefreshLayout swipeLayout;

     private ImageView image;

     private ArrayList<Etkinlik> a;

     List<String> control;
   //  ProgressDialog progress;
     Context context;
   private List<Etkinlik> pliste= new ArrayList<>();

    public thirdfragment() {
        // image.setImageResource(R.drawable.trakya);
    }

    public thirdfragment(String title) {
        this.title = title;//Setting tab title
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // progress = ProgressDialog.show(getActivity(), "", "Bilgiler Alınıyor...", true);

        view = inflater.inflate(R.layout.thirdfragment, container, false);

        swipeLayout = (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh);
        swipeLayout.setOnRefreshListener(this);

        ButterKnife.bind(this, view);



        IOPosts service= ws.getwsPost();
        Call<List<Etkinlik>> control = service.etkinlik_listele(Mainapp.UserPrefs.LogedInUser().get().getUserID());
        control.enqueue(new Callback<List<Etkinlik>>() {
            @Override
            public void onResponse(Response<List<Etkinlik>> response) {

                pliste = response.body();
                setRecyclerView();

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

       return view;
    }
    //Setting recycler view

    private void setRecyclerView() {

        recyclerView = (RecyclerView) view
                .findViewById(R.id.recyclerViewEtkinlik);
        recyclerView.setHasFixedSize(true);
        recyclerView
                .setLayoutManager(new LinearLayoutManager(getActivity()));//Linear Items
        etkinlikRecyclerAdapter adapter = new etkinlikRecyclerAdapter(getActivity(), pliste);
        recyclerView.setAdapter(adapter);// set adapter on recyclerview

    }

    @Override
    public void onRefresh() {
        IOPosts service= ws.getwsPost();
        Call<List<Etkinlik>> control = service.etkinlik_listele(Mainapp.UserPrefs.LogedInUser().get().getUserID());
        control.enqueue(new Callback<List<Etkinlik>>() {
            @Override
            public void onResponse(Response<List<Etkinlik>> response) {

                pliste = response.body();
                setRecyclerView();
                swipeLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Throwable t) {
                swipeLayout.setRefreshing(false);
            }
        });
    }
}
