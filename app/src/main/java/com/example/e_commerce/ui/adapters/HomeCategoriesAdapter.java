package com.example.e_commerce.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_commerce.databinding.ItemHomeCategoryBinding;
import com.example.e_commerce.databinding.ItemProductBinding;
import com.example.e_commerce.models.response.bigCategories.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeCategoriesAdapter extends RecyclerView.Adapter<HomeCategoriesAdapter.Holder> {

List<Category> categoryList ;
    public HomeCategoriesAdapter(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(ItemHomeCategoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Category category = categoryList.get(position);
        holder.binding.tvCategoryName.setText(category.getName());
        Picasso.get().load(category.getImage())
                .into(holder.binding.ivCategory);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        ItemHomeCategoryBinding binding;

        public Holder(@NonNull ItemHomeCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding ;

        }
    }


}
