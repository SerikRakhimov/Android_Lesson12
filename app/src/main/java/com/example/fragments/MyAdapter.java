package com.example.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<Product> products;

    public MyAdapter(ArrayList<Product> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Product product = products.get(position);

        holder.food.setImageResource(product.getFoodResId());
        holder.name.setText(product.getName());
        holder.description.setText(product.getDescription());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView food;
        public TextView name, description;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            food = itemView.findViewById(R.id.productFoodImageView);
            name = itemView.findViewById(R.id.productNameTextView);
            description = itemView.findViewById(R.id.productDescriptionTextView);
        }
    }

}
