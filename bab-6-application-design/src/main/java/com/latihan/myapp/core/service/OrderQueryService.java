package com.latihan.myapp.core.service;

import java.sql.Connection;
import java.util.List;

import com.latihan.myapp.core.domain.Order;
import com.latihan.myapp.core.persistence.DatabaseHelper;
import com.latihan.myapp.core.persistence.OrderRepository;
import com.latihan.myapp.core.persistence.RepositoryFactory;
import com.latihan.myapp.core.persistence.exception.DatabaseException;
import com.latihan.myapp.core.persistence.exception.PersistenceException;
import com.latihan.myapp.core.persistence.impl.OrderRepositoryMySQL;
import com.latihan.myapp.core.service.exception.BusinessServiceException;

public class OrderQueryService {
	public List<Order> findOrderHistoryForCustomerBy(int customerId) throws BusinessServiceException{
		Connection conn = null;
		List<Order> orderList = null;
		try {
			conn = DatabaseHelper.getConnection();
			OrderRepository orderRepo = RepositoryFactory
										.withThisConnection(conn)
										.getOrderRepository();
			
			orderList = orderRepo.findByCustomerId(customerId);
		} catch (DatabaseException e) {
			throw new BusinessServiceException(e.getMessage());
		} catch (PersistenceException e) {
			throw new BusinessServiceException(e.getMessage());
		}
		
		return orderList;
	}
	
	public Order findOrderByOrderNumber(String orderNumber) throws BusinessServiceException {
		Connection conn = null;
		Order order = null;
		try {
			conn = DatabaseHelper.getConnection();
			OrderRepository orderRepo = RepositoryFactory
										.withThisConnection(conn)
										.getOrderRepository();
			
			order = orderRepo.findByOrderNumber(orderNumber);
		} catch (DatabaseException e) {
			throw new BusinessServiceException(e.getMessage());
		} catch (PersistenceException e) {
			throw new BusinessServiceException(e.getMessage());
		}
		
		return order;
	}
}
