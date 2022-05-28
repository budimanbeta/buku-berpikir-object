package com.latihan.myapp.dto;

public class OrderItemDto {
	private int id;
	private String code;
	private String name;
	private int price;
	private int quantity;
	private int totalPrice;
	
	public OrderItemDto() {
		
	}
	public OrderItemDto(int productId, String code, String productName, int quantity, int price) {
		this.id = productId;
		this.code = code;
		this.name = productName;
		this.quantity = quantity;
		this.price = price;
	}

	public int getTotalPrice() {
		return quantity * price;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
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
	
	
}
