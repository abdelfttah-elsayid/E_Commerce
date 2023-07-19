package com.example.e_commerce.models.response.settings;

import com.google.gson.annotations.SerializedName;

public class SettingsResponse{

	@SerializedName("data")
	private UserData userData;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setData(UserData userData){
		this.userData = userData;
	}

	public UserData getData(){
		return userData;
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
			"SettingsResponse{" + 
			"data = '" + userData + '\'' +
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}