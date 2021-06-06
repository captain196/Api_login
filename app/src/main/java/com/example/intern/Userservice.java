package com.example.intern;

import model.ReaObj;
import model.frontobj;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Userservice {

    @FormUrlEncoded
    @POST("api/login")
    Call<ReaObj> login(
            @Field("email")String username,
            @Field("password")String password
    );




}
