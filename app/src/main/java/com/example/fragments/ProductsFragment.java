package com.example.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductsFragment extends Fragment {
    private MyAdapter myAdapter;

    private RecyclerView recyclerView;
     private ArrayList<Product> products;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_products,container,false);
        addData();
        recyclerView = (RecyclerView)   view.findViewById(R.id.recyclerView);
        myAdapter = new MyAdapter(products);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapter);
        TextView textView =    view.findViewById(R.id.textView);
        textView.setText("Количество продуктов: "+Integer.toString(products.size()));
        return view;
    }

    void addData(){
        products = new ArrayList<>();
        products.add(new Product(R.drawable.ic_food, "Пицца", "Пицца Маргарита d30см", 1000));
        products.add(new Product(R.drawable.ic_food, "Коктейль", "Молочный коктейль", 500));
        products.add(new Product(R.drawable.ic_food, "Мороженное", "Сливочное мороженное", 300));
    }

}