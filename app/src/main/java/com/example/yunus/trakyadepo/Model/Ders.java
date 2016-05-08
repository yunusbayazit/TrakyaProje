package com.example.yunus.trakyadepo.Model;

/**
 * Created by yunus on 14.04.2016.
 */
public class Ders {

    /**
     * DersID : 1
     * DersAdi : Bilgisayar Mühendisliğine Giriş
     * Donem :
     */

    private int DersID;
    private String DersAdi;
    private String Donem;
    private boolean Selected;

    public Ders(String dersAdi, boolean selected) {
        DersAdi = dersAdi;
        Selected = selected;
    }

    public int getValue() {
        return value;
    }
    public boolean isSelected() {
        return Selected;
    }

    public void setSelected(boolean isSelected) {
        this.Selected = isSelected;
    }
    public void setValue(int value) {
        this.value = value;
    }

    int value; /* 0 -&gt; checkbox disable, 1 -&gt; checkbox enable */

    public int getDersID() {
        return DersID;
    }

    public void setDersID(int DersID) {
        this.DersID = DersID;
    }

    public String getDersAdi() {
        return DersAdi;
    }

    public void setDersAdi(String DersAdi) {
        this.DersAdi = DersAdi;
    }

    public String getDonem() {
        return Donem;
    }

    public void setDonem(String Donem) {
        this.Donem = Donem;
    }
}
