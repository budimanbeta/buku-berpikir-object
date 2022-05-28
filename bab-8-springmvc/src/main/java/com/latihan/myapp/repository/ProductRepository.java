package com.latihan.myapp.repository;

import java.util.List;

import com.latihan.myapp.entity.Product;

public interface ProductRepository {

	public List<Product> findAllProduct();
	public Product getById(int id);
	public void save(Product product);
}
