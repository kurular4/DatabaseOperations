package com.example.okurular.database.Adapters;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.okurular.database.Dialog;
import com.example.okurular.database.MainActivity;
import com.example.okurular.database.Models.Result;
import com.example.okurular.database.R;
import com.example.okurular.database.RestApi.ManagerAll;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ResultAdapter extends BaseAdapter {

    List<Result> list;
    Context context;
    Activity activity;

    public ResultAdapter(List<Result> list, Context context, Activity activity) {
        this.list = list;
        this.context = context;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.listview, viewGroup, false);

        TextView id = view.findViewById(R.id.id);
        TextView name = view.findViewById(R.id.name);
        TextView surname = view.findViewById(R.id.surname);
        LinearLayout linearLayout = view.findViewById(R.id.listviewelement);

        id.setText(list.get(i).getId() + "");
        name.setText(list.get(i).getIsim() + "");
        surname.setText(list.get(i).getSoyad() + "");

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(activity, context, Integer.parseInt(list.get(i).getId().toString()));
                dialog.goster();
            }
        });
        return view;
    }


}
