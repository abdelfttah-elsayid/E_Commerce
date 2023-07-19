package com.example.e_commerce.models.request;

import com.google.gson.annotations.SerializedName;

public class UpdateProfileRequest{

	public UpdateProfileRequest( String phone, String name, String email) {
		this.phone = phone;
		this.name = name;
		this.email = email;
	}



	@SerializedName("phone")
	private String phone;

	@SerializedName("name")
	private String name;

	@SerializedName("email")
	private String email;



	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"UpdateProfileRequest{" + 
			",phone = '" + phone + '\'' +
			",name = '" + name + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}