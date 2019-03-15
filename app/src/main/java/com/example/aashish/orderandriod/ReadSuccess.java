package com.example.aashish.orderandriod;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReadSuccess extends AppCompatActivity{
    RecyclerView recyclerView;
    List<Categorypull> categorypullList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.read);

        recyclerView = findViewById(R.id.recycleviewres);
        categorypullList = new ArrayList<>();



        Call<List<Categorypull>> callmenu = RetrofitClient.getmInstance().getApi().getCatRes();

        callmenu.enqueue(new Callback<List<Categorypull>>() {
            @Override
            public void onResponse(Call<List<Categorypull>> call, Response<List<Categorypull>> response) {

                List<Categorypull> docs = response.body();

                MenuAdapter menuAdapter = new MenuAdapter(docs,this,null);
               recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(menuAdapter);
            }

            @Override
            public void onFailure(Call<List<Categorypull>> call, Throwable t) {
                Toast.makeText(ReadSuccess.this,"NOt Working",Toast.LENGTH_SHORT).show();

            }
        });


    }









}


