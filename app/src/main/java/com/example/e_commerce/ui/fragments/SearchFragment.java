package com.example.e_commerce.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.example.e_commerce.R;
import com.example.e_commerce.data.source.local.MyShared;
import com.example.e_commerce.data.source.local.SharedKeys;
import com.example.e_commerce.data.source.network.MyRetrofit;
import com.example.e_commerce.databinding.FragmentHomeBinding;
import com.example.e_commerce.databinding.FragmentSearchBinding;
import com.example.e_commerce.models.response.seacrh.SearchResponse;
import com.example.e_commerce.ui.adapters.ProductsSearchAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends Fragment {

         FragmentSearchBinding binding;
    private static final String TAG = "SearchFragment";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = FragmentSearchBinding.inflate(inflater , container , false);

        return binding.getRoot();
        // Inflate the layout for this fragment
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                //search
                String searchKey = v.getText() .toString();
                search(searchKey);
                Log.i(TAG, "onEditorAction: "+v.getText());

                return false;
            }
        });

    }

    private void search(String searchKey) {
        MyRetrofit.getApis().search(searchKey , MyShared.getString(SharedKeys.apiToken))
                .enqueue(new Callback<SearchResponse>() {
                    @Override
                    public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                       if (getView()== null)return;
                        if (response.isSuccessful()){
                            ProductsSearchAdapter productsSearchAdapter = new ProductsSearchAdapter(response.body().getData().getData());
                            binding.rvProductSearch.setAdapter(productsSearchAdapter);

                        }

                    }

                    @Override
                    public void onFailure(Call<SearchResponse> call, Throwable t) {

                    }
                });
    }


}
