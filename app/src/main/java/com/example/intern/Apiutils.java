package com.example.intern;

import retrofit2.Retrofit;

public class Apiutils {

    private  static final String BASE_URL="https://reqres.in/";

    public static Userservice getUserServices(){
        return retrofitclient.getClient(BASE_URL).create(Userservice.class);
    }


}
