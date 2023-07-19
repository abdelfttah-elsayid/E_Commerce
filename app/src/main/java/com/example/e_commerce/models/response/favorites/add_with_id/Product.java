package com.example.e_commerce.models.response.favorites.add_with_id;

import com.google.gson.annotations.SerializedName;

public class Product{

	@SerializedName("image")
	private String image;

	@SerializedName("price")
	private int price;

	@SerializedName("old_price")
	private int oldPrice;

	@SerializedName("discount")
	private int discount;

	@SerializedName("id")
	private int id;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setPrice(int price){
		this.price = price;
	}

	public int getPrice(){
		return price;
	}

	public void setOldPrice(int oldPrice){
		this.oldPrice = oldPrice;
	}

	public int getOldPrice(){
		return oldPrice;
	}

	public void setDiscount(int discount){
		this.discount = discount;
	}

	public int getDiscount(){
		return discount;
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
			"Product{" + 
			"image = '" + image + '\'' + 
			",price = '" + price + '\'' + 
			",old_price = '" + oldPrice + '\'' + 
			",discount = '" + discount + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}