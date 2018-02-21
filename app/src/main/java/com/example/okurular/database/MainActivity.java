package com.example.okurular.database;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.okurular.database.Adapters.ResultAdapter;
import com.example.okurular.database.Models.Result;
import com.example.okurular.database.RestApi.ManagerAll;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button register, refresh;
    EditText name, surname;
    ListView listView;
    ResultAdapter resultAdapter;
    List<Result> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        register = findViewById(R.id.register);
        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        listView = findViewById(R.id.listview);
        refresh = findViewById(R.id.refresh);
        listele();
        registerButtonClick();
        refreshButtonClick();
    }

    public void registerButtonClick() {
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ekle();
                name.setText("");
                surname.setText("");
            }
        });
    }

    public void refreshButtonClick() {
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listele();
            }
        });
    }

    public void ekle() {
        Call<Result> x = ManagerAll.getInstance().addUser(name.getText().toString(), surname.getText().toString());
        x.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Toast.makeText(getApplicationContext(), "successful", Toast.LENGTH_LONG).show();
                listele();
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });
    }

    public void listele() {
        Call<List<Result>> x = ManagerAll.getInstance().getUsers();
        x.enqueue(new Callback<List<Result>>() {
            @Override
            public void onResponse(Call<List<Result>> call, Response<List<Result>> response) {
                resultAdapter = new ResultAdapter(response.body(), getApplicationContext(), MainActivity.this);
                list = response.body();
                listView.setAdapter(resultAdapter);
            }

            @Override
            public void onFailure(Call<List<Result>> call, Throwable t) {

            }
        });
    }


}
