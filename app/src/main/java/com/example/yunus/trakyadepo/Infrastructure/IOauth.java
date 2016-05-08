package com.example.yunus.trakyadepo.Infrastructure;

import com.example.yunus.trakyadepo.Model.Ders;
import com.example.yunus.trakyadepo.Model.DersSecimiFilter;
import com.example.yunus.trakyadepo.Model.errorType;
import com.example.yunus.trakyadepo.Model.modelauth;

import java.util.List;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by yunus on 17.03.2016.
 */
public interface IOauth {

    @POST("Uye/login")
    Call<modelauth> login(@Body userControllerfilter filter);


}