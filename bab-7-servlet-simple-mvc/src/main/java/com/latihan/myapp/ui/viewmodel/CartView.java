package com.latihan.myapp.ui.viewmodel;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CartView {
	private List<ItemView> items = new ArrayList<ItemView>();
	private String totalPrice;
	
	public void addItem(ItemView item) {
		ItemView itemView = findItem(item.getCode());
		if(itemView != null) {
			int prevQuantity = Integer.parseInt(itemView.getQuantity());
			int newQuantity = Integer.parseInt(item.getQuantity());
			int quantity = prevQuantity + newQuantity;
			itemView.setQuantity(String.valueOf(quantity));
			double totalPrice = quantity * Double.parseDouble(itemView.getPrice());
			itemView.setTotalPrice(String.valueOf(totalPrice));
		}else {
			int quantity = Integer.parseInt(item.getQuantity());
			double totalPrice = quantity * Double.parseDouble(item.getPrice());
			item.setTotalPrice(String.valueOf(totalPrice));
			items.add(item);
		}
		
	}
	
	private ItemView findItem(String code) {
		for(ItemView item : items) {
			if(code.equals(item.getCode())) {
				return item;
			}
		}
		
		return null;
	}
	
	public void removeItem(String code) {
		ItemView itemView = findItem(code);
		if(itemView != null) {
			this.items.remove(itemView);
		}
	}

	public String getTotalPrice() {
		
		double totalPrice = 0;
		for(ItemView item : this.items) {
			totalPrice = totalPrice + (Double.parseDouble(item.getPrice()) * Integer.parseInt(item.getQuantity()));
		}
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(totalPrice);
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<ItemView> getItems() {
		return items;
	}

	public void setItems(List<ItemView> items) {
		this.items = items;
	}
	
	
}
