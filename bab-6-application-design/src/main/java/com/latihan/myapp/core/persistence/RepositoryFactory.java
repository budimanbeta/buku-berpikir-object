package com.latihan.myapp.core.persistence;

import java.sql.Connection;

import com.latihan.myapp.core.persistence.impl.OrderRepositoryMySQL;

public class RepositoryFactory {
	
	private Connection conn;
	private static RepositoryFactory factory;
	
	private RepositoryFactory() {
	}
	
	public static RepositoryFactory withThisConnection(Connection conn) {
		factory = new RepositoryFactory();
		factory.conn = conn;
		return factory;
	}
	
	public OrderRepository getOrderRepository() {
		return new OrderRepositoryMySQL(factory.conn);
	}
	
	public OrderRepository getOrderRepository2() {
		return new OrderRepositoryMySQL(factory.conn);
	}
	
	
}
