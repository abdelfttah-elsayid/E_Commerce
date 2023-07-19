package com.example.e_commerce.models.response.Home;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ProductsItem{

	@SerializedName("image")
	private String image;

	@SerializedName("images")
	private List<String> images;

	@SerializedName("price")
	private double price;

	@SerializedName("in_cart")
	private boolean inCart;

	@SerializedName("old_price")
	private double oldPrice;

	@SerializedName("in_favorites")
	private boolean inFavorites;

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

	public void setImages(List<String> images){
		this.images = images;
	}

	public List<String> getImages(){
		return images;
	}

	public void setPrice(double price){
		this.price = price;
	}

	public double getPrice(){
		return price;
	}

	public void setInCart(boolean inCart){
		this.inCart = inCart;
	}

	public boolean isInCart(){
		return inCart;
	}

	public void setOldPrice(double oldPrice){
		this.oldPrice = oldPrice;
	}

	public double getOldPrice(){
		return oldPrice;
	}

	public void setInFavorites(boolean inFavorites){
		this.inFavorites = inFavorites;
	}

	public boolean isInFavorites(){
		return inFavorites;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDiscount(double discount){
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
			"ProductsItem{" +
			"image = '" + image + '\'' +
			",images = '" + images + '\'' +
			",price = '" + price + '\'' +
			",in_cart = '" + inCart + '\'' +
			",old_price = '" + oldPrice + '\'' +
			",in_favorites = '" + inFavorites + '\'' +
			",name = '" + name + '\'' +
			",discount = '" + discount + '\'' +
			",description = '" + description + '\'' +
			",id = '" + id + '\'' +
			"}";
		}
}