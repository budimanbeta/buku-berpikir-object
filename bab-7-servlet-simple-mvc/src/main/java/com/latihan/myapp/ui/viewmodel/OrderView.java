package com.latihan.myapp.ui.viewmodel;

import java.util.ArrayList;
import java.util.List;

public class OrderView {
	private List<ItemView> items = new ArrayList<ItemView>();
	private String totalPrice;
	private String orderNumber;
	private String orderDate;
	
	public List<ItemView> getItems() {
		return items;
	}
	public void setItems(List<ItemView> items) {
		this.items = items;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	
}
