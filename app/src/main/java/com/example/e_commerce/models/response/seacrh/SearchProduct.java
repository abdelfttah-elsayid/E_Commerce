package com.example.e_commerce.models.response.seacrh;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SearchProduct {

	@SerializedName("image")
	private String image;

	@SerializedName("images")
	private List<String> images;

	@SerializedName("price")
	private Object price;

	@SerializedName("in_cart")
	private boolean inCart;

	@SerializedName("in_favorites")
	private boolean inFavorites;

	@SerializedName("name")
	private String name;

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

	public void setPrice(Object price){
		this.price = price;
	}

	public Object getPrice(){
		return price;
	}

	public void setInCart(boolean inCart){
		this.inCart = inCart;
	}

	public boolean isInCart(){
		return inCart;
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
			"DataItem{" + 
			"image = '" + image + '\'' + 
			",images = '" + images + '\'' + 
			",price = '" + price + '\'' + 
			",in_cart = '" + inCart + '\'' + 
			",in_favorites = '" + inFavorites + '\'' + 
			",name = '" + name + '\'' + 
			",description = '" + description + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}