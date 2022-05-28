package com.latihan.myapp.core.persistence;

import java.util.List;

import com.latihan.myapp.core.domain.Order;
import com.latihan.myapp.core.persistence.exception.PersistenceException;

public interface OrderRepository {
	public List<Order> findByCustomerId(int customerId) throws PersistenceException;
	public Order findByOrderNumber(String orderNumber) throws PersistenceException;
	public void save(Order order) throws PersistenceException;
}
