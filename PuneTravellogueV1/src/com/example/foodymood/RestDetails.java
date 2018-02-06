package com.example.foodymood;

public class RestDetails {

	int imgid;
	String name;
	String cuisine;
	String timing;
	String details;
	public RestDetails(int imgid, String name, String cuisine, String timing,
			String details) {
		super();
		this.imgid = imgid;
		this.name = name;
		this.cuisine = cuisine;
		this.timing = timing;
		this.details = details;
	}
	
	
	
	@Override
	public String toString() {
		return "RestDetails [imgid=" + imgid + ", name=" + name + ", cuisine="
				+ cuisine + ", timing=" + timing + ", details=" + details + "]";
	}



	public int getImgid() {
		return imgid;
	}
	public void setImgid(int imgid) {
		this.imgid = imgid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public String getTiming() {
		return timing;
	}
	public void setTiming(String timing) {
		this.timing = timing;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
}
