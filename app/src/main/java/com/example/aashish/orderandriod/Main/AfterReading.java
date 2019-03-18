package com.example.aashish.orderandriod.Main;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.aashish.orderandriod.Adapter.MenuAdapter;
import com.example.aashish.orderandriod.Data.Categorypull;
import com.example.aashish.orderandriod.R;
import com.example.aashish.orderandriod.Utilities.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AfterReading extends AppCompatActivity {


    RecyclerView recyclerView;
    List<Categorypull> categorypullList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_reading);

        final ProgressDialog progressDialog = new ProgressDialog(AfterReading.this);

        progressDialog.setTitle("Fetching Menu");
        progressDialog.setMessage("Please wait while we get the best menu for you");
        progressDialog.show();

        recyclerView = findViewById(R.id.recycleviewres);
        categorypullList = new ArrayList<>();



        Call<List<Categorypull>> callmenu = RetrofitClient.getmInstance().getApi().getCatRes();

        callmenu.enqueue(new Callback<List<Categorypull>>() {
            @Override
            public void onResponse(Call<List<Categorypull>> call, Response<List<Categorypull>> response) {
                progressDialog.dismiss();

                List<Categorypull> docs = response.body();
                Toast.makeText(AfterReading.this,"Working"+docs.toString(),Toast.LENGTH_LONG);

                MenuAdapter menuAdapter = new MenuAdapter(docs,this,null);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(menuAdapter);
            }

            @Override
            public void onFailure(Call<List<Categorypull>> call, Throwable t) {
                Toast.makeText(AfterReading.this,"Not Working",Toast.LENGTH_SHORT).show();

            }
        });


    }




}
