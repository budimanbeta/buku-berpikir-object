package com.latihan.myapp.core.domain;

public class OrderItem {
	private int id;
	private String code;
	private String name;
	private String type;
	private double price;
	private int quantity;
	private String orderNumber;
	
	public OrderItem(String orderNumber, String code, int quantity) {
		this.orderNumber = orderNumber;
		this.code = code;
		this.quantity = quantity;
		
	}
	public OrderItem(String orderNumber, String code, String type,String name, double price, int quantity) {
		this.orderNumber = orderNumber;
		this.code = code; 
		this.name = name;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
		
	}
	
	public int getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}

	public double getPrice() {
		return price;
	}

	public String getOrderNumber() {
		return orderNumber;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double totalPrice() {
		return this.price * quantity;
	}
	

}
