package com.example.e_commerce.ui.fragments;

import static android.content.ContentValues.TAG;

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
import com.example.e_commerce.databinding.FragmentHomeBinding;
import com.example.e_commerce.models.response.Home.BannersItem;
import com.example.e_commerce.models.response.Home.HomeResponse;
import com.example.e_commerce.models.response.Home.ProductsItem;
import com.example.e_commerce.models.response.bigCategories.CategoriesResponse;
import com.example.e_commerce.models.response.bigCategories.Category;
import com.example.e_commerce.models.response.favorites.add_with_id.AddFavoritesWithIdResponse;
import com.example.e_commerce.ui.adapters.HomeCategoriesAdapter;
import com.example.e_commerce.ui.adapters.ProductsAdapter;
import com.example.e_commerce.ui.adapters.SliderAdapter;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {
    List<Category> categoryList ;
    //   List <ProductsItem> productsItems ;
    //   List <BannersItem> bannersItems;
    FragmentHomeBinding binding;
    ProductsAdapter productsAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(inflater , container , false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


       /* imagesUrls.add("https://student.valuxapps.com/storage/uploads/banners/1680057346A0jc4.41.PNG");
        imagesUrls.add("https://student.valuxapps.com/storage/uploads/banners/1680057283HBnq8.40.PNG");
        imagesUrls.add("https://student.valuxapps.com/storage/uploads/banners/1680056998oqIZP.38.PNG");
        imagesUrls.add( "https://student.valuxapps.com/storage/uploads/banners/16800568607rdVd.fitness gym.png");
        imagesUrls.add("https://student.valuxapps.com/storage/uploads/banners/1680056644YpLvd.White Modern Gym Fitness Banner Landscape.png");
        imagesUrls.add( "https://student.valuxapps.com/storage/uploads/banners/1680055989g181K.37.PNG");
        imagesUrls.add("https://student.valuxapps.com/storage/uploads/banners/1680055803aDUjo.36.PNG");
        imagesUrls.add("https://student.valuxapps.com/storage/uploads/banners/1680055176jJA1U.Gold Black White Elegant Minimalist Christmas Thanksgiving Food Month Banner.png");
       */


        getCategories();
        getHomeData();





    /*  binding.imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        binding.imageSlider.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        binding.imageSlider.setIndicatorSelectedColor(Color.WHITE);
        binding.imageSlider.setIndicatorUnselectedColor(Color.GRAY);
        binding.imageSlider.setScrollTimeInSec(4); //set scroll delay in seconds :
        binding.imageSlider.startAutoCycle();*/



    }
    private void getCategories(){
        MyRetrofit.getApis().categories(MyShared.getString(SharedKeys.apiToken))
                .enqueue(new Callback<CategoriesResponse>() {
                    @Override
                    public void onResponse(Call<CategoriesResponse> call, Response<CategoriesResponse> response) {
                        if (response.isSuccessful()){
                            if (getView() ==null )return;
                            categoryList =  response.body().getData().getData();
                            HomeCategoriesAdapter homeCategoriesAdapter = new HomeCategoriesAdapter(categoryList);
                            binding.rvCategories.setAdapter(homeCategoriesAdapter);


                        }
                        else
                            Toast.makeText(requireContext(), response.message(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<CategoriesResponse> call, Throwable t) {

                    }
                });

    }
    IFavorites iFavorites = new IFavorites() {
        @Override
        public void onFavoriteClick(int productId) {
            productsAdapter.notifyProductFavorite();

            MyRetrofit.getApis().addDeleteFavorite( productId , MyShared.getString(SharedKeys.apiToken))
                    .enqueue(new Callback<AddFavoritesWithIdResponse>() {
                        @Override
                        public void onResponse(Call<AddFavoritesWithIdResponse> call, Response<AddFavoritesWithIdResponse> response) {

                            if(response.isSuccessful()){
                     /*     System.out.println("code//////////////////////////"+response.code());
                          Log.i(TAG, "onResponse: "+response.code());*/
                                //  getHomeData();
                                // call product adapter and notify it


                            }
                            else
                            {
                                productsAdapter.notifyProductFavorite();
                            }

                        }

                        @Override
                        public void onFailure(Call<AddFavoritesWithIdResponse> call, Throwable t) {
                            productsAdapter.notifyProductFavorite();

                        }
                    });
        }
    };



    private void getHomeData() {
        MyRetrofit.getApis().getHome(MyShared.getString(SharedKeys.apiToken)).enqueue(new Callback<HomeResponse>() {
            @Override
            public void onResponse(Call<HomeResponse> call, Response<HomeResponse> response) {
                if (response.isSuccessful()) {
                    if (getView() == null) return;

                    List<ProductsItem> productsItems = response.body().getData().getProducts();
                    productsAdapter = new ProductsAdapter(productsItems, iFavorites);
                    binding.rvProducts.setAdapter(productsAdapter);
                    List<BannersItem> bannersItems = response.body().getData().getBanners();

                    List<String> imagesUrls = new ArrayList<>();
                    for (BannersItem bannersItem : bannersItems) {
                        imagesUrls.add(bannersItem.getImage());

                    }
                    SliderAdapter adapter = new SliderAdapter(imagesUrls);
                    binding.imageSlider.setIndicatorAnimation(IndicatorAnimationType.DROP); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
                    binding.imageSlider.setSliderAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<HomeResponse> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}