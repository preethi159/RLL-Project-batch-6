package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Food {
	@Id
	
	private int id;
	private String name;
	private float price;
	private int offer;
    private String description;
   private String url;
   private Integer fid;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public int getOffer() {
	return offer;
}
public void setOffer(int offer) {
	this.offer = offer;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}


public Integer getFid() {
	return fid;
}
public void setFid(Integer fid) {
	this.fid = fid;
}
@Override
public String toString() {
	return "Food [id=" + id + ", name=" + name + ", price=" + price + ", offer=" + offer + ", description="
			+ description + ", url=" + url + ", fid=" + fid + "]";
}


}
