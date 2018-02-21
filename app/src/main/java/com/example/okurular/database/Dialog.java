package com.example.okurular.database;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.okurular.database.Adapters.ResultAdapter;
import com.example.okurular.database.Models.Result;
import com.example.okurular.database.RestApi.ManagerAll;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Dialog {
    Activity activity;
    Context context;
    int id;
    AlertDialog alertDialog;

    public void goster() {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.deletedialog, null);
        Button sil = view.findViewById(R.id.sil);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(view);
        builder.setCancelable(true);
        alertDialog = builder.create();
        sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sil();
            }
        });

        alertDialog.show();
    }

    public Dialog(Activity activity, Context context, int id) {
        this.activity = activity;
        this.context = context;
        this.id = id;
    }

    public void sil() {
        Call<Result> x = ManagerAll.getInstance().deleteUser(id);
        x.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Toast.makeText(context, "Kayit basariyla silindi", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });
        alertDialog.cancel();
    }


}
