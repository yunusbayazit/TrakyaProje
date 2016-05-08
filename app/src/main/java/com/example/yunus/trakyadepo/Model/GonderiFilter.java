package com.example.yunus.trakyadepo.Model;

/**
 * Created by yunus on 14.04.2016.
 */
public class GonderiFilter {
    public String  Ders_Adi;
    public int User_ID ;
    public  String  Baslik;
    public  String  İcerik;
    public String  link ;

    public String getDers_Adi() {
        return Ders_Adi;
    }

    public void setDers_Adi(String ders_Adi) {
        Ders_Adi = ders_Adi;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    public String getBaslik() {
        return Baslik;
    }

    public void setBaslik(String baslik) {
        Baslik = baslik;
    }

    public String getIcerik() {
        return İcerik;
    }

    public void setIcerik(String icerik) {
        İcerik = icerik;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public GonderiFilter(String ders_Adi, int user_ID, String baslik, String icerik, String link) {
        Ders_Adi = ders_Adi;
        User_ID = user_ID;
        Baslik = baslik;
        İcerik = icerik;
        this.link = link;
    }
}
