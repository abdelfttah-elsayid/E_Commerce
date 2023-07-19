package com.example.e_commerce.models.response.favorites.add_with_id;

import com.example.e_commerce.models.response.favorites.FavoriteProduct;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AddFavoriteWithIdData {

	@SerializedName("product")
	private Product product;

	@SerializedName("id")
	private int id;

	public void setProduct(Product product){
		this.product = product;
	}

	public Product getProduct(){
		return product;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"RegisterData{" +
			"product = '" + product + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}

}