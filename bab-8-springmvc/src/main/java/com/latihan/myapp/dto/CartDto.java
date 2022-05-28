package com.latihan.myapp.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

public class CartDto {
	
	private List<OrderItemDto> orderItemsDto = new ArrayList<OrderItemDto>();
	private int totalPrice;
	
	public List<OrderItemDto> getOrderItemsDto() {
		return orderItemsDto;
	}
	public void setOrderItemsDto(List<OrderItemDto> orderItemsDto) {
		
		 this.orderItemsDto = orderItemsDto;
	}
	
	public void addItemDto(OrderItemDto itemDto) {
		if (CollectionUtils.isEmpty(this.orderItemsDto)) {
			 orderItemsDto = new ArrayList<OrderItemDto>();
		}
		
		OrderItemDto itemFound = findItem(itemDto);
		if(itemFound != null) {
			itemDto.setQuantity(itemDto.getQuantity() + itemFound.getQuantity());
			orderItemsDto.remove(itemFound);
		}	
		
		orderItemsDto.add(itemDto);
		
		
	}
	
	private OrderItemDto findItem(OrderItemDto itemDto) {
		for(OrderItemDto item : orderItemsDto) {
			if(itemDto.getId() == item.getId()) {
				return item;
			}
		}
		return null;
	}
	public int getTotalPrice() {
		int total = 0;
		for(OrderItemDto item : orderItemsDto) {
			total = total + item.getTotalPrice();
		}
		return total;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
