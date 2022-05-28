package com.latihan.myapp.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.latihan.myapp.entity.Order;
import com.latihan.myapp.repository.OrderRepository;

@Repository
public class OrderRepositoryImpl implements OrderRepository{

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Order> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Orders").getResultList();
	}

	public Order getById(int id) {
		Session session = sessionFactory.getCurrentSession();		
		return session.get(Order.class, id);
	}

	public void save(Order orders) {
		Session session = sessionFactory.getCurrentSession();
		session.save(orders);
	}

}
