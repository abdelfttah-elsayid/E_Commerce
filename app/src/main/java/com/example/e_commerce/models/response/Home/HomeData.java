package com.example.e_commerce.models.response.Home;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class HomeData {

	@SerializedName("ad")
	private String ad;

	@SerializedName("banners")
	private List<BannersItem> banners;

	@SerializedName("products")
	private List<ProductsItem> products;

	public void setAd(String ad){
		this.ad = ad;
	}

	public String getAd(){
		return ad;
	}

	public void setBanners(List<BannersItem> banners){
		this.banners = banners;
	}

	public List<BannersItem> getBanners(){
		return banners;
	}

	public void setProducts(List<ProductsItem> products){
		this.products = products;
	}

	public List<ProductsItem> getProducts(){
		return products;
	}

	@Override
 	public String toString(){
		return 
			"RegisterData{" +
			"ad = '" + ad + '\'' + 
			",banners = '" + banners + '\'' + 
			",products = '" + products + '\'' + 
			"}";
		}
}