package com.example.e_commerce.models.response.Home;

import com.google.gson.annotations.SerializedName;

public class BannersItem{

	@SerializedName("image")
	private String image;

	@SerializedName("product")
	private Object product;

	@SerializedName("id")
	private int id;

	@SerializedName("category")
	private Object category;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setProduct(Object product){
		this.product = product;
	}

	public Object getProduct(){
		return product;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setCategory(Object category){
		this.category = category;
	}

	public Object getCategory(){
		return category;
	}

	@Override
 	public String toString(){
		return 
			"BannersItem{" + 
			"image = '" + image + '\'' + 
			",product = '" + product + '\'' + 
			",id = '" + id + '\'' + 
			",category = '" + category + '\'' + 
			"}";
		}
}