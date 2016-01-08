package com.example.yunus.trakyadosyapaylasim.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yunus.trakyadosyapaylasim.R;

/**
 * Created by yunus on 18.12.2015.
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    TextView tv1,tv2,tv3,tv4;
    ImageView imageView;

    public RecyclerViewHolder(View itemView) {
        super(itemView);


        tv1= (TextView) itemView.findViewById(R.id.AdSoyadbar);
        tv2= (TextView) itemView.findViewById(R.id.GonderimTarihi);
        tv3= (TextView) itemView.findViewById(R.id.icerikbar);
        tv4= (TextView) itemView.findViewById(R.id.detayTxt);

    }
}