package com.example.yunus.trakyadepo.Fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yunus.trakyadepo.Adapter.RecyclerAdapter;
import com.example.yunus.trakyadepo.Infrastructure.IOPosts;
import com.example.yunus.trakyadepo.Infrastructure.IOauth;
import com.example.yunus.trakyadepo.Infrastructure.IOgetValue;
import com.example.yunus.trakyadepo.Infrastructure.Mainapp;
import com.example.yunus.trakyadepo.Infrastructure.UserPrefs;
import com.example.yunus.trakyadepo.Infrastructure.userControllerfilter;
import com.example.yunus.trakyadepo.Infrastructure.ws;
import com.example.yunus.trakyadepo.MainActivity;
import com.example.yunus.trakyadepo.Model.Gonderi;
import com.example.yunus.trakyadepo.Model.Soru;
import com.example.yunus.trakyadepo.Model.modelauth;
import com.example.yunus.trakyadepo.R;
import com.example.yunus.trakyadepo.etkinlikActivity;
import com.example.yunus.trakyadepo.newpostActivity;
import com.example.yunus.trakyadepo.soruActivity;
import com.lacronicus.easydatastorelib.DatastoreBuilder;

import java.security.spec.PSSParameterSpec;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by yunus on 11.01.2016.
 */
public class onefragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private View view;
    private ImageView image;
    private String title;//String for tab title
    private ArrayList<Soru> a;
    private static RecyclerView recyclerView;
    List<String> control;
    ProgressDialog progress;
    Context context;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    TextView t2;
    private List<Gonderi> pliste= new ArrayList<>();
    SwipeRefreshLayout swipeLayout;
    @Bind(R.id.fabGonderi)
    FloatingActionButton fabgonderi;
    public onefragment() {
        image.setImageResource(R.drawable.trakya);
    }

    public onefragment(String title) {
        this.title = title;//Setting tab title
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ButterKnife.bind(this.getActivity());
        progress = ProgressDialog.show(getActivity(), "", "Bilgiler Alınıyor...", true);
        IOgetValue service= ws.getwsValue();
        view = inflater.inflate(R.layout.onefragment, container, false);
        swipeLayout = (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh);
        swipeLayout.setOnRefreshListener(this);

        ButterKnife.bind(this, view);
        Call<List<Gonderi>> control = service.gonderileriListele(Mainapp.UserPrefs.LogedInUser().get().getUserID());
        control.enqueue(new Callback<List<Gonderi>>() {
            @Override
            public void onResponse(Response<List<Gonderi>> response) {

                pliste = response.body();
                setRecyclerView();

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });


        progress.dismiss();



        return view;

    }

    //Setting recycler view
    private void setRecyclerView() {

        recyclerView = (RecyclerView) view
                .findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView
                .setLayoutManager(new LinearLayoutManager(getActivity()));//Linear Items




        RecyclerAdapter adapter = new RecyclerAdapter(getActivity(), pliste);
        recyclerView.setAdapter(adapter);// set adapter on recyclerview

    }

  @OnClick(R.id.fabGonderi)
    public void submit(View view) {
                Intent intt = new Intent(getActivity(), newpostActivity.class);
                startActivity(intt);
    }

    @Override
    public void onRefresh() {
        IOgetValue service= ws.getwsValue();
        Call<List<Gonderi>> control = service.gonderileriListele(Mainapp.UserPrefs.LogedInUser().get().getUserID());
        control.enqueue(new Callback<List<Gonderi>>() {
            @Override
            public void onResponse(Response<List<Gonderi>> response) {

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