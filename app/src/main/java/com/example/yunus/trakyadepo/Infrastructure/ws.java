package com.example.yunus.trakyadepo.Infrastructure;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by yunus on 17.03.2016.
 */
public class ws {
    public static IOauth getws(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://trakyaservice.yunusbayazit.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return  retrofit.create(IOauth.class);
    }

    public static IOPosts getwsPost(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://trakyaservice.yunusbayazit.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return  retrofit.create(IOPosts.class);
    }

    public static IOgetValue getwsValue(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://trakyaservice.yunusbayazit.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return  retrofit.create(IOgetValue.class);
    }
}
