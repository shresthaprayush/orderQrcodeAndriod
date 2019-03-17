package com.example.aashish.orderandriod.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aashish.orderandriod.Data.Categorypull;
import com.example.aashish.orderandriod.R;

import java.util.List;

import retrofit2.Callback;

//Menu Adapter is used to populate the data in card view and show that data in the recycle view.

//This is step 2 passing the class MenuviewHolder as a pramater of MenuAdapter Class.

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuviewHolder> {

    //This is step 3 Initialize all the necessary variable and create constructer

    private List<Categorypull> documentsList;
    private Callback<List<Categorypull>> mContext;
    private Context context;

    public MenuAdapter(List<Categorypull> documentsList, Callback<List<Categorypull>> mContext, Context context) {
        this.documentsList = documentsList;
        this.mContext = mContext;
        this.context = context;
    }



    @NonNull
    @Override
    public MenuAdapter.MenuviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //Step 4 inflate the card layout
        View view ;
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        view = layoutInflater.inflate(R.layout.card_menu,viewGroup,false);

        return new MenuviewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.MenuviewHolder menuviewHolder, int i) {

        //Step 5 set what you want to get.

        final Categorypull categorypull = documentsList.get(i);
       menuviewHolder.Itemname.setText(categorypull.getName());
        menuviewHolder.Price.setText(categorypull.getPrice());

    }

    @Override
    public int getItemCount() {
        return documentsList.size();
    }


    // The step no 1 is to create A class to intitialize the card view items.

    public class MenuviewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView Itemname,Price;



        public MenuviewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardviewdocscat_id);
            Itemname = itemView.findViewById(R.id.docscategory_title);
            Price = itemView.findViewById(R.id.docscategorydesc);


        }
    }
}
