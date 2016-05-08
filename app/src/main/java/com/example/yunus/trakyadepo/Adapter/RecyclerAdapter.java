package com.example.yunus.trakyadepo.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.example.yunus.trakyadepo.Infrastructure.Mainapp;
import com.example.yunus.trakyadepo.Model.Gonderi;
import com.example.yunus.trakyadepo.Model.Soru;
import com.example.yunus.trakyadepo.R;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yunus on 14.01.2016.
 */
public class RecyclerAdapter extends  RecyclerView.Adapter<RecyclerViewHolder> {

    private List<Gonderi> arrayList;
    private Context context;
    public static ImageView navbarimage;
    private Bitmap bmp;

    public RecyclerAdapter(Context context,
                                List<Gonderi> arrayList){
        this.context = context;
        this.arrayList = arrayList;

    }


    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);

    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder,
                                 final int position) {
        final RecyclerViewHolder mainHolder = (RecyclerViewHolder) holder;
        //Setting text over textview
        Context context=mainHolder.image.getContext();
        mainHolder.Ad.setText(arrayList.get(position).getKullanıcı_Adi());
        mainHolder.title.setText(arrayList.get(position).getBaslik());
        mainHolder.content.setText(arrayList.get(position).getİcerik());
        Picasso.with(context).load("http://trakyaservice.yunusbayazit.com/img/"+arrayList.get(position).getPost_Resim().toString()).placeholder(R.mipmap.ic_launcher).resize(115, 115).centerCrop().into(mainHolder.image);
        mainHolder.Ders_Adı.setText(arrayList.get(position).getDers_adi());
        mainHolder.LinkTxt.setText(arrayList.get(position).getLink());
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(
            ViewGroup viewGroup, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(viewGroup.getContext());

        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(
                R.layout.list, viewGroup, false);
        RecyclerViewHolder mainHolder = new RecyclerViewHolder(mainGroup) {
            @Override
            public String toString() {
                return super.toString();
            }
        };


        return mainHolder;

    }
}