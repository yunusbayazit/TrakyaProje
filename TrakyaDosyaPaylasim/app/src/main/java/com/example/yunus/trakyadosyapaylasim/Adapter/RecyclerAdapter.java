package com.example.yunus.trakyadosyapaylasim.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.yunus.trakyadosyapaylasim.R;

/**
 * Created by yunus on 18.12.2015.
 */
public class RecyclerAdapter extends  RecyclerView.Adapter<RecyclerViewHolder> {

    String[] name = {"Yunus Emre Bayazıt", "Stackoverflow", "Developer Android", "AndroidHive",
            "Slidenerd", "TheNewBoston", "Slidenerd", "TheNewBoston", "Slidenerd", "TheNewBoston", "Slidenerd", "TheNewBoston", "Truiton", "HmkCode", "JavaTpoint", "Javapeper"};
    String[] tarih = {"1 gün önce", "1 gün önce", "1 gün önce ", "1 gün önce",
            "1 gün önce", "1 gün önce", "1 gün önce", "1 gün önce", "1 gün önce", "1 gün önce", "1 gün önce", "1 gün önce", "1 gün önce", "1 gün önce", "1 gün önce", "1 gün önce"};
    String[] icerik = {"Yunus Emre Bayazıt", "Stackoverflow", "Developer Android", "AndroidHive",
            "Slidenerd", "TheNewBoston", "Slidenerd", "TheNewBoston", "Slidenerd", "TheNewBoston", "Slidenerd", "TheNewBoston", "Truiton", "HmkCode", "JavaTpoint", "Javapeper"};


    Context context;
    LayoutInflater inflater;

    public RecyclerAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.list, parent, false);

        RecyclerViewHolder viewHolder = new RecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        holder.tv1.setText(name[position]);
        holder.tv4.setOnClickListener(clickListener);
        holder.tv2.setText(tarih[position]);
        holder.tv3.setText(icerik[position]);

    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            RecyclerViewHolder vholder = (RecyclerViewHolder) v.getTag();
            int position = vholder.getLayoutPosition();

            Toast.makeText(context, "This is position " + position, Toast.LENGTH_LONG).show();

        }
    };


    @Override
    public int getItemCount() {
        return name.length;
    }
}