package com.latihan.myapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.latihan.myapp.entity.Product;
import com.latihan.myapp.repository.ProductRepository;
import com.latihan.myapp.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepo;
	
	public List<Product> findAllProduct() {		
		return productRepo.findAllProduct();
	}

	public Product getById(int id) {		
		return productRepo.getById(id);
	}

	public void save(Product product) {
		productRepo.save(product);
	}

	 
	
}
