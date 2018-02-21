package com.example.okurular.database.RestApi;

import com.example.okurular.database.Models.Result;

import java.util.List;

import retrofit2.Call;


public class ManagerAll extends BaseManager {

    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance(){
        return ourInstance;
    }

    public Call<Result> addUser(String name, String surname){
        Call<Result> call = getRestApiClient().addUser(name, surname);
        return call;
    }

    public Call<List<Result>> getUsers() {
        Call<List<Result>> call = getRestApiClient().getUsers();
        return call;
    }

    public Call<Result> deleteUser(int id) {
        Call<Result> call = getRestApiClient().deleteUser(id);
        return call;
    }

}
