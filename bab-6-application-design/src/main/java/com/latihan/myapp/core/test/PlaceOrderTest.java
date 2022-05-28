package com.latihan.myapp.core.test;

import java.sql.Connection;

import com.latihan.myapp.core.domain.Customer;
import com.latihan.myapp.core.domain.Order;
import com.latihan.myapp.core.domain.OrderItem;
import com.latihan.myapp.core.persistence.OrderRepository;
import com.latihan.myapp.core.persistence.exception.PersistenceException;
import com.latihan.myapp.core.persistence.impl.OrderRepositoryMySQL;
import com.latihan.myapp.core.service.PlaceOrderService;
import com.latihan.myapp.core.service.exception.BusinessServiceException;

public class PlaceOrderTest {

	public static void main(String[] args) {
		
		Customer customer = new Customer(1, "Erich Gamma");
		Order order = new Order(1, "ORD002");
		order.addItem(new OrderItem("ORD002", "101", 1));
		order.addItem(new OrderItem("ORD002", "102", 2));
		
		PlaceOrderService placeOrderService = new PlaceOrderService(customer, order);
		try {
			placeOrderService.execute();
		} catch (BusinessServiceException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
