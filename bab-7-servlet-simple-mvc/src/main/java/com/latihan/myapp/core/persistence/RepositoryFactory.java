package com.latihan.myapp.core.persistence;

import java.sql.Connection;

import com.latihan.myapp.core.persistence.impl.OrderRepositoryMySQL;
import com.latihan.myapp.core.persistence.impl.ProductRepositoryMySQL;

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
	
	public ProductRepository getProductRepository() {
		return new ProductRepositoryMySQL(factory.conn);
	}
	
	
}
