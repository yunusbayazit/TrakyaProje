package com.example.yunus.trakyadepo.Model;

import com.google.gson.annotations.Expose;

/**
 * Created by yunus on 17.03.2016.
 */
public class modelauth {


    /**
     * UserID : 2
     * UserName : Umut
     * UserPassword : 1234
     * UserType : 2120203363
     * UserImage : umut.jpg
     */
    @Expose
    private int UserID;
    @Expose
    private String UserName;
    @Expose
    private String UserPassword;
    @Expose
    private String UserType;
    @Expose
    private String UserImage;

    public modelauth(int User_ID,String User_Name,String User_Password,String User_Type,String User_Image){

        this.UserID=User_ID;
        this.UserName=User_Name;
        this.UserPassword=User_Password;
        this.UserType=User_Type;
        this.UserImage=User_Image;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String UserPassword) {
        this.UserPassword = UserPassword;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String UserType) {
        this.UserType = UserType;
    }

    public String getUserImage() {
        return UserImage;
    }

    public void setUserImage(String UserImage) {
        this.UserImage = UserImage;
    }
}