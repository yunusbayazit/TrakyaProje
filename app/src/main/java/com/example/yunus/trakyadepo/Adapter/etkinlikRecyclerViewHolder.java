package com.example.yunus.trakyadepo.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yunus.trakyadepo.R;

/**
 * Created by yunus on 14.04.2016.
 */
public class etkinlikRecyclerViewHolder extends RecyclerView.ViewHolder {

    TextView baslik;
    TextView Ad;
    ImageView image;
    TextView icerik;
    TextView Ders_Adı;
    TextView Baslangic;
    TextView Bitis;

    public etkinlikRecyclerViewHolder(View itemView) {
        super(itemView);
        this.Ad = (TextView) itemView.findViewById(R.id.PostIsimEtkinlik);
        this.baslik = (TextView) itemView.findViewById(R.id.EtkinlikBasliks);
        this.image = (ImageView) itemView.findViewById(R.id.person_photoEtkinlik);
        this.icerik=(TextView) itemView.findViewById(R.id.Etkinlikiceriks);
        this.Baslangic=(TextView) itemView.findViewById(R.id.BaslangıcText);
        this.Bitis=(TextView) itemView.findViewById(R.id.BitisText);
        this.Ders_Adı=(TextView) itemView.findViewById(R.id.BitisText);
    }
}