package com.latihan.myapp.ui.viewmodel;

import java.text.DecimalFormat;

public class ItemView {
	private String code;
	private String name;
	private String type;
	private String price;
	private String quantity;
	private String totalPrice;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getPriceFmt() {
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(Double.parseDouble(price));
	}
	public void setPriceFmt(String price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public String getTotalPriceFmt() {
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(Double.parseDouble(totalPrice));
	}
	public void setTotalPriceFmt(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
