package com.latihan.myapp.service;

import java.util.List;

import com.latihan.myapp.entity.Product;

public interface ProductService {

	public List<Product> findAllProduct();
	public Product getById(int id);
	public void save(Product product);
}
