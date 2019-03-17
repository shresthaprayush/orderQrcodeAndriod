package com.example.aashish.orderandriod.Data;

//listing all the data that are to be taken by API

public class Categorypull {

    // The name on the api should be same

    private String name;
    private String price;
    private String category;


    public Categorypull(String name, String price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;


    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}
