package com.latihan.myapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.latihan.myapp.entity.Order;
import com.latihan.myapp.repository.OrderRepository;
import com.latihan.myapp.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository ordersRepo;
	
	public List<Order> findAllOrders() {
		
		return ordersRepo.findAll();
	}

	public Order getById(int id) {

		return ordersRepo.getById(id);
	}

	public void save(Order orders) {
		ordersRepo.save(orders);
	}

}
