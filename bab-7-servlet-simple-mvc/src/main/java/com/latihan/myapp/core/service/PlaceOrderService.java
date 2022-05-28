package com.latihan.myapp.core.service;

import java.sql.Connection;

import com.latihan.myapp.core.domain.Customer;
import com.latihan.myapp.core.domain.Order;
import com.latihan.myapp.core.persistence.DatabaseHelper;
import com.latihan.myapp.core.persistence.OrderRepository;
import com.latihan.myapp.core.persistence.RepositoryFactory;
import com.latihan.myapp.core.persistence.exception.DatabaseException;
import com.latihan.myapp.core.persistence.exception.PersistenceException;
import com.latihan.myapp.core.service.exception.BusinessServiceException;

public class PlaceOrderService implements Command{
	private Customer customer;
	private Order order;
	
	public PlaceOrderService(Customer customer, Order order) {
		this.customer = customer;
		this.order = order;
	}
	
	public void execute() throws BusinessServiceException{
		Connection conn = null;
		try {
			conn = DatabaseHelper.getConnection();
			OrderRepository orderRepo =  RepositoryFactory
											.withThisConnection(conn)
											.getOrderRepository();
			DatabaseHelper.beginTransaction(conn);
			
			order.setCustomerId(customer.getId());
			orderRepo.save(order);
			
			DatabaseHelper.commitTransaction(conn);

		} catch (DatabaseException e) {
			throw new BusinessServiceException(e.getMessage());
		} catch (PersistenceException e) {
			try {
				DatabaseHelper.rollbackTransaction(conn);
				throw new BusinessServiceException("Failed saving transaction");
			} catch (DatabaseException e1) {
				throw new BusinessServiceException(e.getMessage());
			}
			
		}
	}
}
