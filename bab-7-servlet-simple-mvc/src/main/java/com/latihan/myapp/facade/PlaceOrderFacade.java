package com.latihan.myapp.facade;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.latihan.myapp.core.domain.Customer;
import com.latihan.myapp.core.domain.Order;
import com.latihan.myapp.core.domain.OrderItem;
import com.latihan.myapp.core.service.PlaceOrderService;
import com.latihan.myapp.core.service.exception.BusinessServiceException;
import com.latihan.myapp.ui.viewmodel.CartView;
import com.latihan.myapp.ui.viewmodel.ItemView;

public class PlaceOrderFacade {
	private int customerId;
	private CartView cartView;
	
	public PlaceOrderFacade(String customerId, CartView cartView) {
		this.customerId = Integer.parseInt(customerId);
		this.cartView = cartView;
	}
	
	public void process() throws FacadeException{
		Order order = mappingCartViewToOrder(cartView);
		Customer customer = new Customer(customerId, "BUDIMAN");//find customer by id
		PlaceOrderService placeOrderService = new PlaceOrderService(customer, order);
		try {
			placeOrderService.execute();
			
		} catch (BusinessServiceException e) {
			throw new FacadeException(e.getMessage());
		}
	}

	private Order mappingCartViewToOrder(CartView cartView) {
		Order order = new Order(generateOrderNumber());
		for(ItemView itemView : cartView.getItems()) {
			int quantity = Integer.parseInt(itemView.getQuantity());
			OrderItem orderItem = new OrderItem(order.getOrderNumber(), itemView.getCode(), quantity);
			order.addItem(orderItem);
		}
		return order;
	}

	private String generateOrderNumber() {
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyhhmmss");
		return customerId +"#" +formatter.format(new Date());
	}
}
