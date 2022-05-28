package com.latihan.myapp.repository;

import java.util.List;

import com.latihan.myapp.entity.Order;

public interface OrderRepository {

	public List<Order> findAll();
	public Order getById(int id);
	public void save(Order orders);
	
}
