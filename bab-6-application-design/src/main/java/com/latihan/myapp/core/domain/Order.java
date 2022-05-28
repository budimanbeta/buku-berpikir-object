package com.latihan.myapp.core.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Order {
	private String orderNumber;
	private Date orderDate;
	private List<OrderItem> items;
	private int customerId;
	
	public Order(String orderNumber) {
		this.orderNumber = orderNumber;
		this.orderDate = new Date();
		this.items = new ArrayList<OrderItem>();
	}
	public Order(int customerId, String orderNumber) {
		this.customerId = customerId;
		this.orderNumber = orderNumber;
		this.orderDate = new Date();
		this.items = new ArrayList<OrderItem>();
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public String getOrderNumber() {
		return orderNumber;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}

	public void addItem(OrderItem item)
	{
		if(item == null) {
			throw new IllegalArgumentException("item should't be null");
		}
		this.items.add(item);
	}
	
	public List<OrderItem> getItems(){
		return Collections.unmodifiableList(this.items);
	}
	
	public double totalPrice() {
		double totalPrice = 0.0;
		for(OrderItem item : this.items) {
			totalPrice = totalPrice + item.totalPrice();
		}
		
		return totalPrice;
	}
}
