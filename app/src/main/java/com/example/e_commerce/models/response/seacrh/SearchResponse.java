package com.example.e_commerce.models.response.seacrh;

import com.google.gson.annotations.SerializedName;

public class SearchResponse{

	@SerializedName("data")
	private SearchData searchData;

	@SerializedName("message")
	private Object message;

	@SerializedName("status")
	private boolean status;

	public void setData(SearchData searchData){
		this.searchData = searchData;
	}

	public SearchData getData(){
		return searchData;
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
			"SearchResponse{" + 
			"data = '" + searchData + '\'' +
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}