package com.example.e_commerce.models.response.favorites;

import com.google.gson.annotations.SerializedName;

public class FavoriteProduct {

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
			"DataItem{" + 
			"product = '" + product + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}