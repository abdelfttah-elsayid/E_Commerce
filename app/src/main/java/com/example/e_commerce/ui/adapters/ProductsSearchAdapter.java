package com.example.e_commerce.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_commerce.databinding.ItemProductBinding;
import com.example.e_commerce.databinding.ItemSearchProductBinding;
import com.example.e_commerce.models.response.seacrh.SearchProduct;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductsSearchAdapter extends RecyclerView.Adapter<ProductsSearchAdapter.Holder> {

List<SearchProduct>list;
    public ProductsSearchAdapter(List<SearchProduct> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(ItemSearchProductBinding.inflate(LayoutInflater.from(parent.getContext()), parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        SearchProduct product = list.get(position);
        holder.binding.tvProductName.setText(product.getName());
        holder.binding.tvCurrentPrice.setText(String.valueOf(product.getPrice()));

        Picasso.get().load(product.getImage())
                .into(holder.binding.ivProduct);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        ItemSearchProductBinding binding;

        public Holder(@NonNull ItemSearchProductBinding binding) {
            super(binding.getRoot());
            this.binding = binding ;

        }
    }


}
