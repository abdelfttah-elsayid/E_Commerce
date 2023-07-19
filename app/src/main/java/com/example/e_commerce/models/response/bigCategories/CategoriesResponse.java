package com.example.e_commerce.models.response.bigCategories;

import com.google.gson.annotations.SerializedName;

public class CategoriesResponse{

	@SerializedName("data")
	private CategoryData categoryData;

	@SerializedName("message")
	private Object message;

	@SerializedName("status")
	private boolean status;

	public void setData(CategoryData categoryData){
		this.categoryData = categoryData;
	}

	public CategoryData getData(){
		return categoryData;
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
			"CategoriesResponse{" + 
			"data = '" + categoryData + '\'' +
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}