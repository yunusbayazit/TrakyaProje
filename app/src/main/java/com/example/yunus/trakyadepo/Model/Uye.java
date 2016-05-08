package com.example.yunus.trakyadepo.Model;

import com.google.gson.annotations.Expose;

/**
 * Created by yunus on 6.04.2016.
 */
public class Uye {


    /**
     * Ad : Yannis
     * Soyad : bayazıt
     * Adres : ssa
     * Email : yunusbayazit@outlook.com
     * Sehir : İstanbul
     * Sinif : 4
     * BolumID : 2
     */
    @Expose
    private int UserID;
    @Expose
    private int OgrenciID;
    @Expose
    private String Ad;
    @Expose
    private String Soyad;
    @Expose
    private String Adres;
    @Expose
    private String Email;
    @Expose
    private String Sehir;
    @Expose
    private int Sinif;
    @Expose
    private int BolumID;
    @Expose
    public int SoruID;

    public String getSifre() {
        return Sifre;
    }

    public void setSifre(String sifre) {
        Sifre = sifre;
    }

    @Expose
    public String Sifre;

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public int getOgrenciID() {
        return OgrenciID;
    }

    public void setOgrenciID(int ogrenciID) {
        OgrenciID = ogrenciID;
    }

    public int getSoruID() {
        return SoruID;
    }

    public void setSoruID(int soruID) {
        SoruID = soruID;
    }

    public int getYorumID() {
        return YorumID;
    }

    public void setYorumID(int yorumID) {
        YorumID = yorumID;
    }

    @Expose
    public int YorumID;

    public Uye(String ad, String soyad, String adres, String email,String Sifre, String sehir, int sinif, int bolumID) {
        Ad = ad;
        Soyad = soyad;
        Adres = adres;
        Email = email;
        Sehir = sehir;
        Sinif = sinif;
        BolumID = bolumID;
        this.Sifre=Sifre;
    }

    public String getAd() {
        return Ad;
    }

    public void setAd(String Ad) {
        this.Ad = Ad;
    }

    public String getSoyad() {
        return Soyad;
    }

    public void setSoyad(String Soyad) {
        this.Soyad = Soyad;
    }

    public String getAdres() {
        return Adres;
    }

    public void setAdres(String Adres) {
        this.Adres = Adres;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSehir() {
        return Sehir;
    }

    public void setSehir(String Sehir) {
        this.Sehir = Sehir;
    }

    public int getSinif() {
        return Sinif;
    }

    public void setSinif(int Sinif) {
        this.Sinif = Sinif;
    }

    public int getBolumID() {
        return BolumID;
    }

    public void setBolumID(int BolumID) {
        this.BolumID = BolumID;
    }
}
