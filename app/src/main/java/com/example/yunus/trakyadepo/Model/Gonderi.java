package com.example.yunus.trakyadepo.Model;

/**
 * Created by yunus on 13.04.2016.
 */
public class Gonderi {


    /**
     * $id : 1
     * id : 0
     * Baslik : bütünleme takvimi
     * İcerik : bütünleme takvimi açıklanmış
     * link : asdasd
     * UserID : 0
     * DersID : 0
     * ders_adi : Web Programlama
     * Kullanıcı_Adi : Kemal
     * Ders : null
     * User : null
     */


    private int id;
    private String Baslik;
    private String İcerik;
    private String link;
    private int UserID;
    private int DersID;
    private String ders_adi;
    private String Kullanıcı_Adi;

    public String getPost_Resim() {
        return Post_Resim;
    }

    public void setPost_Resim(String post_Resim) {
        Post_Resim = post_Resim;
    }

    private String Post_Resim;

    public int getİd() {
        return id;
    }

    public void setİd(int id) {
        this.id = id;
    }

    public String getBaslik() {
        return Baslik;
    }

    public void setBaslik(String Baslik) {
        this.Baslik = Baslik;
    }

    public String getİcerik() {
        return İcerik;
    }

    public void setİcerik(String İcerik) {
        this.İcerik = İcerik;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getDersID() {
        return DersID;
    }

    public void setDersID(int DersID) {
        this.DersID = DersID;
    }

    public String getDers_adi() {
        return ders_adi;
    }

    public void setDers_adi(String ders_adi) {
        this.ders_adi = ders_adi;
    }

    public String getKullanıcı_Adi() {
        return Kullanıcı_Adi;
    }

    public void setKullanıcı_Adi(String Kullanıcı_Adi) {
        this.Kullanıcı_Adi = Kullanıcı_Adi;
    }


}
