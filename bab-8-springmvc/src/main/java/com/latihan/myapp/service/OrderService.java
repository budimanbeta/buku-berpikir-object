package com.latihan.myapp.service;

import java.util.List;

import com.latihan.myapp.entity.Order;

public interface OrderService {
	public List<Order> findAllOrders();
	public Order getById(int id);
	public void save(Order order);
}
