package com.example.e_commerce.ui.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_commerce.R;
import com.example.e_commerce.databinding.ItemProductBinding;
import com.example.e_commerce.models.response.Home.ProductsItem;
import com.example.e_commerce.models.response.favorites.FavoriteProduct;
import com.example.e_commerce.models.response.favorites.Product;
import com.example.e_commerce.ui.fragments.IFavorites;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.Holder> {
    private static final String TAG="FavoritesAdapter";

    List<FavoriteProduct>productsItems ;
    IFavorites iFavorites ;
    private int lastFavoritePosition = -1;

    private FavoriteProduct favoriteProduct ;
    public FavoritesAdapter(List<FavoriteProduct> productsItems, IFavorites iFavorites) {
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
        Product product = productsItems.get(position).getProduct();
        holder.binding.tvProductName.setText(product.getName());
        holder.binding.tvDiscountPrice.setText(String.valueOf(product.getOldPrice()));
        holder.binding.tvCurrentPrice.setText(String.valueOf(product.getPrice()));
        holder.binding.tvDiscount.setText(String.valueOf(product.getDiscount()));

        Picasso.get().load(product.getImage()).into(holder.binding.ivProduct);

        holder.binding.ivFavorite.setImageResource(R.drawable.baseline_favorite_24);

       /* if (product.isInFavorites()){
            holder.binding.ivFavorite.setImageResource(R.drawable.baseline_favorite_24);        }
        else
        {
            holder.binding.ivFavorite.setImageResource(R.drawable.baseline_favorite_border_24);
        }*/

        holder.binding.ivFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favoriteProduct = productsItems.get(holder.getAdapterPosition());
            Log.i(TAG, "onBindViewHolder "+ holder.getAdapterPosition());
                lastFavoritePosition = holder.getAdapterPosition() ;
                iFavorites.onFavoriteClick(product.getId());
            }
        });

    }

    @Override
    public int getItemCount() {
        return productsItems.size();
    }

    public void removeProduct() {

        productsItems.remove(lastFavoritePosition);

    }
    public  void notifyProductRemoved(){
        notifyItemRemoved(lastFavoritePosition);

    }
    public void notifyProductUnRemoved(){
        productsItems.add(favoriteProduct);
        notifyDataSetChanged();
    }


    class Holder extends RecyclerView.ViewHolder{
        ItemProductBinding binding;

        public Holder(@NonNull ItemProductBinding binding) {
            super(binding.getRoot());
            this.binding = binding ;

        }
    }


}
