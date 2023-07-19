package com.example.e_commerce.models.response.favorites;

import com.google.gson.annotations.SerializedName;

public class FavoritesResponse{

	@SerializedName("data")
	private FavoriteData favoriteData;

	@SerializedName("message")
	private Object message;

	@SerializedName("status")
	private boolean status;

	public void setData(FavoriteData favoriteData){
		this.favoriteData = favoriteData;
	}

	public FavoriteData getData(){
		return favoriteData;
	}

	public void setMessage(Object message){
		this.message = message;
	}

	public Object getMessage(){
		return message;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"FavoritesResponse{" + 
			"data = '" + favoriteData + '\'' +
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}