package com.example.e_commerce.models.response.favorites.add_with_id;

import com.google.gson.annotations.SerializedName;

public class AddFavoritesWithIdResponse{

	@SerializedName("data")
	private AddFavoriteWithIdData addFavoriteWithIdData;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setData(AddFavoriteWithIdData addFavoriteWithIdData){
		this.addFavoriteWithIdData = addFavoriteWithIdData;
	}

	public AddFavoriteWithIdData getData(){
		return addFavoriteWithIdData;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
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
			"AddFavoritesWithIdResponse{" + 
			"data = '" + addFavoriteWithIdData + '\'' +
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}