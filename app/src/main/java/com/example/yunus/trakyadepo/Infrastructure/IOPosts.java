package com.example.yunus.trakyadepo.Infrastructure;

import com.example.yunus.trakyadepo.Model.Etkinlik;
import com.example.yunus.trakyadepo.Model.Soru;
import com.example.yunus.trakyadepo.Model.Uye;
import com.example.yunus.trakyadepo.Model.errorType;
import com.example.yunus.trakyadepo.Model.modelauth;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;

/**
 * Created by yunus on 17.03.2016.
 */

public interface IOPosts {

    @POST("Post/Insert_Question")
    Call<errorType> insert_question(@Body Soru filter);

    @POST("Uye/AddStudent")
    Call<errorType> addStudent(@Body Uye Uye );

    @GET("Etkinlik/etkinlik_listele/{id}")
    Call <List<Etkinlik>> etkinlik_listele(@Path("id") int value);
}
