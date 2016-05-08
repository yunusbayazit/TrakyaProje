package com.example.yunus.trakyadepo.Model;

/**
 * Created by yunus on 14.04.2016.
 */
public class Etkinlik {
    /**
     * UserID : 1
     * EtkinlikBaslik : dadam
     * BaslangicTrh : 2012-11-25T00:00:00
     * BitisTrh : 2012-12-25T00:00:00
     * icerik : asdasdasdsadas
     * DersID : 0
     * Kullanıcı_Adı : Umut Can Çoban
     * Ders_Adı : Bilgisayar Mühendisliğine Giriş
     * Post_Resim : umut.jpg
     */

    private int UserID;
    private String EtkinlikBaslik;
    private String BaslangicTrh;
    private String BitisTrh;
    private String icerik;
    private int DersID;
    private String Kullanıcı_Adı;
    private String Ders_Adı;

    public Etkinlik(String etkinlikBaslik, String baslangicTrh, String bitisTrh, String icerik, int dersID, int userID) {
        EtkinlikBaslik = etkinlikBaslik;
        BaslangicTrh = baslangicTrh;
        BitisTrh = bitisTrh;
        this.icerik = icerik;
        DersID = dersID;
        UserID = userID;
    }

    private String Post_Resim;

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getEtkinlikBaslik() {
        return EtkinlikBaslik;
    }

    public void setEtkinlikBaslik(String EtkinlikBaslik) {
        this.EtkinlikBaslik = EtkinlikBaslik;
    }

    public String getBaslangicTrh() {
        return BaslangicTrh;
    }

    public void setBaslangicTrh(String BaslangicTrh) {
        this.BaslangicTrh = BaslangicTrh;
    }

    public String getBitisTrh() {
        return BitisTrh;
    }

    public void setBitisTrh(String BitisTrh) {
        this.BitisTrh = BitisTrh;
    }

    public String getİcerik() {
        return icerik;
    }

    public void setİcerik(String icerik) {
        this.icerik = icerik;
    }

    public int getDersID() {
        return DersID;
    }

    public void setDersID(int DersID) {
        this.DersID = DersID;
    }

    public String getKullanıcı_Adı() {
        return Kullanıcı_Adı;
    }

    public void setKullanıcı_Adı(String Kullanıcı_Adı) {
        this.Kullanıcı_Adı = Kullanıcı_Adı;
    }

    public String getDers_Adı() {
        return Ders_Adı;
    }

    public void setDers_Adı(String Ders_Adı) {
        this.Ders_Adı = Ders_Adı;
    }

    public String getPost_Resim() {
        return Post_Resim;
    }

    public void setPost_Resim(String Post_Resim) {
        this.Post_Resim = Post_Resim;
    }
}
