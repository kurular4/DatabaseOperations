package com.example.okurular.database.RestApi;

import com.example.okurular.database.Models.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RestApi {

    @FormUrlEncoded
    @POST("add.php")
    Call<Result> addUser(@Field("name") String name, @Field("lastname") String surname);

    @GET("list.php")
    Call<List<Result>> getUsers();

    @FormUrlEncoded
    @POST("delete.php")
    Call<Result> deleteUser(@Field("id") int id);
}
