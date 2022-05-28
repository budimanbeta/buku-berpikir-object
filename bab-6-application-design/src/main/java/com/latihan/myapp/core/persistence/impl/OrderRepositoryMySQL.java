package com.latihan.myapp.core.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.latihan.myapp.core.domain.Order;
import com.latihan.myapp.core.domain.OrderItem;
import com.latihan.myapp.core.persistence.OrderRepository;
import com.latihan.myapp.core.persistence.exception.PersistenceException;

public class OrderRepositoryMySQL implements OrderRepository{
	private Connection connection;
	
	public OrderRepositoryMySQL(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Order> findByCustomerId(int customerId) throws PersistenceException {
		List<Order> orderList = new ArrayList<Order>();
		
		String sql = "SELECT o.order_number, o.order_date, o.customer_id, i.code, p.name, p.type, p.price, i.quantity"
				+ " FROM order_tbl o join order_item_tbl i on o.order_number=i.order_number"
				+ "	join product_tbl p on p.code = i.code"
				+ " WHERE o.customer_id = ?";
		
		Map<String, Order> orderMap = new HashMap<String, Order>();
		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setInt(1, customerId);
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				Order order = new Order(rs.getInt("customer_id"), rs.getString("order_number"));
				orderMap.put(rs.getString("order_number"), order);
				orderItemList.add(new OrderItem( rs.getString("order_number"), rs.getString("code"),
										rs.getString("type"), rs.getString("name"), 
										rs.getDouble("price"),rs.getInt("quantity") ));
			}
			
			Iterator<String> it = orderMap.keySet().iterator();
			while(it.hasNext()) {
				String orderNum = it.next();
				Order order = orderMap.get(orderNum);
				for(OrderItem item : orderItemList) {
					if(orderNum.equals(item.getOrderNumber())) {
						order.addItem(item);
					}
				}
				orderList.add(order);
			}
		
		} catch (SQLException e) {
			throw new PersistenceException("Failed getting orders");
		}
		return orderList;
	}

	@Override
	public Order findByOrderNumber(String orderNumber) throws PersistenceException {
		Order order =  null;
		
		String sql = "SELECT o.order_number, o.order_date, o.customer_id, i.code, p.name, p.type, p.price, i.quantity"
				+ " FROM order_tbl o join order_item_tbl i on o.order_number=i.order_number"
				+ "	join product_tbl p on p.code = i.code"
				+" WHERE o.order_number = ?";
		
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, orderNumber);
			
			ResultSet rs = stm.executeQuery();
			
			int i = 1;
			while(rs.next()) {
				if(i == 1) {
					order = new Order(rs.getInt("customer_id"), rs.getString("order_number"));
				}
				if(order != null) {
					order.addItem(new OrderItem( rs.getString("order_number"), rs.getString("code"),
										rs.getString("type"), rs.getString("name"), 
										rs.getDouble("price"),rs.getInt("quantity") ));
				}else {
					throw new PersistenceException("No data found");
				}
				i++;
			}
			
			
		} catch (SQLException e) {
			throw new PersistenceException("No data found");
		}
		return order;
	}

	@Override
	public void save(Order order) throws PersistenceException {
		String sqlInsertOrder = "INSERT INTO order_tbl(order_number, order_date, customer_id) VALUES(?,?,?)";
		String sqlInsertItem = "INSERT INTO order_item_tbl(code, quantity, order_number) VALUES(?,?,?)";
		try {
			PreparedStatement stm = connection.prepareStatement(sqlInsertOrder);
			stm.setString(1, order.getOrderNumber());
			stm.setDate(2, new java.sql.Date(order.getOrderDate().getTime()));
			stm.setInt(3, order.getCustomerId());
			
			stm.executeUpdate();
			
			for(OrderItem item : order.getItems()) {
				PreparedStatement insertItemStm = connection.prepareStatement(sqlInsertItem);
				insertItemStm.setString(1, item.getCode());
				insertItemStm.setInt(2, item.getQuantity());
				insertItemStm.setString(3, item.getOrderNumber());
				
				insertItemStm.executeUpdate();
				
			}
			
		} catch (SQLException e) {
			throw new PersistenceException("Failed saving order");
		}
		
	}

}
