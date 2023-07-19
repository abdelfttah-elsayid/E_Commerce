package com.example.e_commerce.data.source.network;

import com.example.e_commerce.models.request.UpdateProfileRequest;
import com.example.e_commerce.models.response.Details.ProductDetailsResponse;
import com.example.e_commerce.models.response.Home.HomeResponse;
import com.example.e_commerce.models.response.bigCategories.CategoriesResponse;
import com.example.e_commerce.models.response.favorites.FavoritesResponse;
import com.example.e_commerce.models.response.favorites.add_with_id.AddFavoritesWithIdResponse;
import com.example.e_commerce.models.response.login.LoginResponse;
import com.example.e_commerce.models.response.register.RegisterResponse;
import com.example.e_commerce.models.response.seacrh.SearchResponse;
import com.example.e_commerce.models.response.settings.SettingsResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface Apis {


    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> login(

            @Field("email") String email ,
            @Field("password") String password
    );
    @FormUrlEncoded
    @POST("register")
    Call <RegisterResponse> register(
            @Field("email") String email ,
            @Field("name") String name ,
            @Field("phone") String phone ,

            @Field("password") String password

    );

    @PUT("update-profile")
   Call<SettingsResponse> updateProfile(
            @Body UpdateProfileRequest updateProfileRequest,
            @Header("Authorization") String apiToken
            );
    @FormUrlEncoded
    @POST("products/search")
    Call<SearchResponse> search(
            @Field("text") String text ,
            @Header("Authorization") String apiToken

    );

    @GET ("categories")
    Call<CategoriesResponse> categories (
            @Header("Authorization") String apiToken

    );
    @GET ("home")
    Call<HomeResponse> getHome (
                    @Header("Authorization") String apiToken

            );

    @GET ("favorites")
    Call<FavoritesResponse> getFavorites (
            @Header("Authorization") String apiToken

    );

    @FormUrlEncoded
    @POST ("favorites")
    Call<AddFavoritesWithIdResponse> addDeleteFavorite (
            @Field("product_id") int productId,
            @Header("Authorization") String apiToken

    );
    @GET("products")
    Call<ProductDetailsResponse> getDetails(
            @Query("product_id") int productId,
            @Header("Authorization") String apiToken
    );


}
