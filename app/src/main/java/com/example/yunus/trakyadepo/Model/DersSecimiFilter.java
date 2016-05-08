package com.example.yunus.trakyadepo.Model;

/**
 * Created by yunus on 27.04.2016.
 */
public class DersSecimiFilter {

    /**
     * UserId : 1
     * DersId : 2
     */

    private int UserId;
    private int DersId;


    public DersSecimiFilter(int userId, int dersId) {
        UserId = userId;
        DersId = dersId;
    }



    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public int getDersId() {
        return DersId;
    }

    public void setDersId(int DersId) {
        this.DersId = DersId;
    }
}
