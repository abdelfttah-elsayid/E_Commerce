package com.example.e_commerce.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.e_commerce.data.source.local.MyShared;
import com.example.e_commerce.data.source.local.SharedKeys;
import com.example.e_commerce.data.source.network.MyRetrofit;
import com.example.e_commerce.databinding.FragmentCategoriesBinding;
import com.example.e_commerce.models.response.bigCategories.CategoriesResponse;
import com.example.e_commerce.models.response.bigCategories.Category;
import com.example.e_commerce.ui.adapters.BigCategoriesAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CategoriesFragment extends Fragment {
     FragmentCategoriesBinding binding ;

    List<Category> categoryList ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCategoriesBinding.inflate(inflater , container , false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
getCategories();
    }
    private void getCategories(){
        MyRetrofit.getApis().categories(MyShared.getString(SharedKeys.apiToken))
                .enqueue(new Callback<CategoriesResponse>() {
                    @Override
                    public void onResponse(Call<CategoriesResponse> call, Response<CategoriesResponse> response) {
                        if (response.isSuccessful())
                        {

                        categoryList =  response.body().getData().getData();
                        BigCategoriesAdapter bigCategoriesAdapter = new BigCategoriesAdapter(categoryList);
                        binding.rvBigCategories.setAdapter(bigCategoriesAdapter);


                        }
                        else
                            Toast.makeText(requireContext(), response.message(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<CategoriesResponse> call, Throwable t) {

                    }
                });

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}