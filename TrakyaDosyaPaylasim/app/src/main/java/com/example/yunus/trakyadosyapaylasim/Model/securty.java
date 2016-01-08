package com.example.yunus.trakyadosyapaylasim.Model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by yunus on 2.01.2016.
 */
@Table(name = "securty")
public class securty extends Model {

    // Notice how we specifie-d the name of our column here
    @Column(name = "Kullanici_adi")
    public String kullanici_adi;

    // Notice how we specified the name of our column here
    @Column(name = "sifre")
    public int sifre;

    public securty() {
        // Notice how super() has been called to perform default initialization
        // of our Model subclass
        super();
    }

    public securty(String Kullanici_adi, int sifre) {
        super();

        this.kullanici_adi = Kullanici_adi;
        this.sifre = sifre;
    }
}
