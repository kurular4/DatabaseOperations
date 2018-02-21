package com.example.okurular.database.RestApi;

import com.example.okurular.database.Models.Result;

import java.util.List;

import retrofit2.Call;


public class ManagerAll extends BaseManager {

    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance(){
        return ourInstance;
    }

    public Call<Result> ekle(String isim, String soyad){
        Call<Result> call = getRestApiClient().addUser(isim, soyad);
        return call;
    }

    public Call<List<Result>> getUsers() {
        Call<List<Result>> call = getRestApiClient().getUsers();
        return call;
    }

    public Call<Result> sil(int id) {
        Call<Result> call = getRestApiClient().deleteUser(id);
        return call;
    }

}
