
package com.example.e_commerce.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_commerce.R;
import com.example.e_commerce.databinding.ItemProductBinding;
import com.example.e_commerce.models.response.Home.ProductsItem;
import com.example.e_commerce.ui.fragments.IFavorites;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.Holder> {

    List<ProductsItem>productsItems ;
    IFavorites iFavorites ;
    private int lastFavoritePosition = -1;
    public ProductsAdapter(List<ProductsItem> productsItems, IFavorites iFavorites) {
        this.productsItems = productsItems;
        this.iFavorites = iFavorites;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(ItemProductBinding.inflate(LayoutInflater.from(parent.getContext()), parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        ProductsItem product = productsItems.get(position);
        holder.binding.tvProductName.setText(product.getName());
        holder.binding.tvDiscountPrice.setText(String.valueOf(product.getOldPrice()));
        holder.binding.tvCurrentPrice.setText(String.valueOf(product.getPrice()));
        holder.binding.tvDiscount.setText(String.valueOf(product.getDiscount()));
        //  holder.binding.tvDiscount.setText(productsItem.getDiscount());

        Picasso.get().load(product.getImage())
                .into(holder.binding.ivProduct);

        if (product.isInFavorites()){

            holder.binding.ivFavorite.setImageResource(R.drawable.baseline_favorite_24);

        }
        else
        {
            holder.binding.ivFavorite.setImageResource(R.drawable.baseline_favorite_border_24);
        }
        holder.binding.ivFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastFavoritePosition = holder.getAdapterPosition() ;
                iFavorites.onFavoriteClick(product.getId());
            }
        });

    }

    @Override
    public int getItemCount() {
        return productsItems.size();
    }

    public void notifyProductFavorite() {
        boolean favorite = ! productsItems.get(lastFavoritePosition).isInFavorites();

        productsItems.get(lastFavoritePosition).setInFavorites(favorite);
        notifyItemChanged(lastFavoritePosition);

    }

    class Holder extends RecyclerView.ViewHolder{
        ItemProductBinding binding;

        public Holder(@NonNull ItemProductBinding binding) {
            super(binding.getRoot());
            this.binding = binding ;

        }
    }
}