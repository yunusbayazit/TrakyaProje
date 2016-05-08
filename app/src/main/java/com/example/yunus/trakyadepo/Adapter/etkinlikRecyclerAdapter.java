package com.example.yunus.trakyadepo.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.yunus.trakyadepo.Model.Etkinlik;
import com.example.yunus.trakyadepo.Model.Gonderi;
import com.example.yunus.trakyadepo.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by yunus on 14.04.2016.
 */
public class etkinlikRecyclerAdapter extends  RecyclerView.Adapter<etkinlikRecyclerViewHolder> {

    private List<Etkinlik> arrayList;
    private Context context;


    public etkinlikRecyclerAdapter(Context context,
                           List<Etkinlik> arrayList){
        this.context = context;
        this.arrayList = arrayList;

    }


    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);

    }

    @Override
    public void onBindViewHolder(etkinlikRecyclerViewHolder holder,
                                 final int position) {
        final etkinlikRecyclerViewHolder mainHolder = (etkinlikRecyclerViewHolder) holder;
        //Setting text over textview
        Context context=mainHolder.image.getContext();
        Picasso.with(context).load("http://trakyaservice.yunusbayazit.com/img/"+arrayList.get(position).getPost_Resim().toString()).placeholder(R.mipmap.ic_launcher).resize(115, 115).centerCrop().into(mainHolder.image);
        mainHolder.Ad.setText(arrayList.get(position).getKullanıcı_Adı());
        mainHolder.baslik.setText(arrayList.get(position).getEtkinlikBaslik());
        mainHolder.icerik.setText(arrayList.get(position).getİcerik());
        mainHolder.Baslangic.setText(arrayList.get(position).getBaslangicTrh());
        mainHolder.Bitis.setText(arrayList.get(position).getBitisTrh());
        mainHolder.Ders_Adı.setText(arrayList.get(position).getDers_Adı());
    }

    @Override
    public etkinlikRecyclerViewHolder onCreateViewHolder(
            ViewGroup viewGroup, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(viewGroup.getContext());

        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(
                R.layout.etkinlik_list, viewGroup, false);
        etkinlikRecyclerViewHolder mainHolder = new etkinlikRecyclerViewHolder(mainGroup) {
            @Override
            public String toString() {
                return super.toString();
            }
        };


        return mainHolder;

    }
}