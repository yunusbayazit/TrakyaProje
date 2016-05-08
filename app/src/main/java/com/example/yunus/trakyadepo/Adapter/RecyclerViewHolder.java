package com.example.yunus.trakyadepo.Adapter;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yunus.trakyadepo.R;

/**
 * Created by yunus on 14.01.2016.
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    TextView title;
    TextView Ad;
    ImageView image;
    TextView content;
    TextView Ders_Adı;
    TextView LinkTxt;
    public RecyclerViewHolder(View itemView) {
        super(itemView);
        this.Ad = (TextView) itemView.findViewById(R.id.PostIsim);
        this.title = (TextView) itemView.findViewById(R.id.SoruBasliks);
        this.image = (ImageView) itemView.findViewById(R.id.person_photo);
        this.content=(TextView) itemView.findViewById(R.id.Soruiceriks);
        this.Ders_Adı=(TextView) itemView.findViewById(R.id.Ders_Adı);
        this.LinkTxt=(TextView) itemView.findViewById(R.id.LinkText);
    }
}