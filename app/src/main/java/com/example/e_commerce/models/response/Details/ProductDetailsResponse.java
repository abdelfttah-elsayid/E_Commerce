package com.example.e_commerce.models.response.Details;

import com.google.gson.annotations.SerializedName;

public class ProductDetailsResponse{

	@SerializedName("data")
	private DetailsData detailsData;

	@SerializedName("message")
	private Object message;

	@SerializedName("status")
	private boolean status;

	public void setData(DetailsData detailsData){
		this.detailsData = detailsData;
	}

	public DetailsData getData(){
		return detailsData;
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
			"ProductDetailsResponse{" + 
			"data = '" + detailsData + '\'' +
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}