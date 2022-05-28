package com.latihan.myapp.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.latihan.myapp.entity.Product;
import com.latihan.myapp.repository.ProductRepository;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Product> findAllProduct() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Product").getResultList();
	}

	public Product getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		return session.get(Product.class, id);
	}

	public void save(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.save(product);
		
	}

}
