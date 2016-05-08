package com.example.yunus.trakyadepo.Infrastructure;

import com.google.gson.annotations.Expose;

/**
 * Created by yunus on 17.03.2016.
 */
public class userControllerfilter {

    public userControllerfilter(String email, String password) {
        Email = email;
        Password = password;
    }


    @Expose
    private String Email;
    @Expose
    private String Password;


    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }


    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }
}

