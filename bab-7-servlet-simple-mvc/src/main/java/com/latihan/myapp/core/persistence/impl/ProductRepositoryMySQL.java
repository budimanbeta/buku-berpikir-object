package com.latihan.myapp.core.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.latihan.myapp.core.domain.Product;
import com.latihan.myapp.core.persistence.ProductRepository;
import com.latihan.myapp.core.persistence.exception.PersistenceException;

public class ProductRepositoryMySQL implements ProductRepository{
	private Connection connection;
	
	public ProductRepositoryMySQL(Connection connection) {
		this.connection = connection;
	}
	@Override
	public List<Product> findAll() throws PersistenceException {
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM product_tbl";
		
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				Product product = new Product(rs.getString("code"), rs.getString("name"),
						   rs.getString("type"), rs.getDouble("price"));
				products.add(product);
			}
		} catch (SQLException e) {
			throw new PersistenceException("Failed getting products");
		}
		
		return products;
	}

}
