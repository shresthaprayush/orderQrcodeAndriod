package com.example.aashish.orderandriod;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import retrofit2.Callback;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuviewHolder> {

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
        View view ;
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        view = layoutInflater.inflate(R.layout.card_menu,viewGroup,false);

        return new MenuviewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.MenuviewHolder menuviewHolder, int i) {

        final Categorypull categorypull = documentsList.get(i);
       menuviewHolder.Itemname.setText(categorypull.getName());
        menuviewHolder.Price.setText(categorypull.getPrice());

    }

    @Override
    public int getItemCount() {
        return documentsList.size();
    }


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
