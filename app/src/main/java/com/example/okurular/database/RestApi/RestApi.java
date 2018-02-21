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
    @POST("ekle.php")
    Call<Result> addUser(@Field("isim") String isim, @Field("soyad") String soyad);

    @GET("listele.php")
    Call<List<Result>> getUsers();

    @FormUrlEncoded
    @POST("sil.php")
    Call<Result> deleteUser(@Field("id") int id);
}
