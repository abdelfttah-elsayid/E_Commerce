package com.example.e_commerce.models.response.Home;

import com.google.gson.annotations.SerializedName;

public class HomeResponse{

	@SerializedName("data")
	private HomeData homeData;

	@SerializedName("message")
	private Object message;

	@SerializedName("status")
	private boolean status;

	public void setData(HomeData homeData){
		this.homeData = homeData;
	}

	public HomeData getData(){
		return homeData;
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
			"HomeResponse{" + 
			"data = '" + homeData + '\'' +
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}