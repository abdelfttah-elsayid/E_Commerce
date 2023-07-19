package com.example.e_commerce.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.e_commerce.data.source.local.MyShared;
import com.example.e_commerce.data.source.local.SharedKeys;
import com.example.e_commerce.data.source.network.MyRetrofit;
import com.example.e_commerce.databinding.FragmentFavoritesBinding;
import com.example.e_commerce.models.response.Home.ProductsItem;
import com.example.e_commerce.models.response.favorites.FavoriteProduct;
import com.example.e_commerce.models.response.favorites.FavoritesResponse;
import com.example.e_commerce.models.response.favorites.add_with_id.AddFavoritesWithIdResponse;
import com.example.e_commerce.models.response.seacrh.SearchResponse;
import com.example.e_commerce.ui.adapters.FavoritesAdapter;
import com.example.e_commerce.ui.adapters.ProductsAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FavoritesFragment extends Fragment {
    FragmentFavoritesBinding binding ;
    FavoritesAdapter productsAdapter ;

    private static final String TAG = "FavoritesFragment";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFavoritesBinding.inflate(inflater , container , false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       // FavoritesAdapter favoritesAdapter = new FavoritesAdapter( FavoriteProduct , iFavorites);
        //binding.rvFavorites.setAdapter(favoritesAdapter);

           // binding.rvFavorites.setAdapter(productsAdapter);
       // RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        //binding.rvFavorites.setLayoutManager(layoutManager);
        //binding.rvFavorites.setAdapter(productsAdapter);


        getFavorites();
    }
    IFavorites iFavorites = new IFavorites() {
        @Override
        public void onFavoriteClick(int productId) {



            productsAdapter.removeProduct();

            productsAdapter.notifyProductRemoved();

            MyRetrofit.getApis().addDeleteFavorite( productId , MyShared.getString(SharedKeys.apiToken))
                    .enqueue(new Callback<AddFavoritesWithIdResponse>() {
                        @Override
                        public void onResponse(Call<AddFavoritesWithIdResponse> call, Response<AddFavoritesWithIdResponse> response) {

                            if(response.isSuccessful()){
                                //productsAdapter.notifyProductUnRemoved();

                            }
                            else {
                                productsAdapter.notifyProductUnRemoved();

                            }

                        }

                        @Override
                        public void onFailure(Call<AddFavoritesWithIdResponse> call, Throwable t) {
                            productsAdapter.notifyProductUnRemoved();


                        }
                    });
        }
    };
    private void getFavorites(){
        MyRetrofit.getApis().getFavorites
                (MyShared.getString(SharedKeys.apiToken))
                .enqueue(new Callback<FavoritesResponse>() {
                    @Override
                    public void onResponse(Call<FavoritesResponse> call, Response<FavoritesResponse> response) {
                        if(response.isSuccessful()){

            List<FavoriteProduct> productsItems = response.body().getData().getData();
                            productsAdapter = new FavoritesAdapter(productsItems , iFavorites);
                            binding.rvFavorites.setAdapter(productsAdapter);

                        }
                    }

                    @Override
                    public void onFailure(Call<FavoritesResponse> call, Throwable t) {
                        Toast.makeText(requireContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null ;
    }
}