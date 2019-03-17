package com.example.aashish.orderandriod.Utilities;

import com.example.aashish.orderandriod.Data.Categorypull;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    @GET("restaurantMenu/getCategory")
    Call<List<Categorypull>> getCatRes();
}
