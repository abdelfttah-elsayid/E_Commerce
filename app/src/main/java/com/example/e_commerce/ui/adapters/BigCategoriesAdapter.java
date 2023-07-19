package com.example.e_commerce.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_commerce.databinding.ItemBigCategoryBinding;
import com.example.e_commerce.models.response.bigCategories.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;

public class BigCategoriesAdapter extends RecyclerView.Adapter<BigCategoriesAdapter.Holder> {

    List<Category> categoryList ;
    public BigCategoriesAdapter(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(ItemBigCategoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
       Category category =  categoryList.get(position);

       holder.binding.teCategoryName.setText(category.getName());
        Picasso.get().load(category.getImage())
                .into(holder.binding.ivBigCategories);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        ItemBigCategoryBinding binding;

        public Holder(@NonNull ItemBigCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding ;

        }
    }


}
