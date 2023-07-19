package com.example.e_commerce.models.response.favorites;

import com.google.gson.annotations.SerializedName;

public class Product{

	@SerializedName("image")
	private String image;

	@SerializedName("price")
	private double price;

	@SerializedName("old_price")
	private double oldPrice;

	@SerializedName("name")
	private String name;

	@SerializedName("discount")
	private double discount;

	@SerializedName("description")
	private String description;

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

	public double getPrice(){
		return price;
	}

	public void setOldPrice(int oldPrice){
		this.oldPrice = oldPrice;
	}

	public double getOldPrice(){
		return oldPrice;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDiscount(int discount){
		this.discount = discount;
	}

	public double getDiscount(){
		return discount;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
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
			",name = '" + name + '\'' + 
			",discount = '" + discount + '\'' + 
			",description = '" + description + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}