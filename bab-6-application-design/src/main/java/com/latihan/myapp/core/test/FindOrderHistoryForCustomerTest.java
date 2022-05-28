package com.latihan.myapp.core.test;

import com.latihan.myapp.core.domain.Order;
import com.latihan.myapp.core.domain.OrderItem;
import com.latihan.myapp.core.service.OrderQueryService;
import com.latihan.myapp.core.service.exception.BusinessServiceException;

public class FindOrderHistoryForCustomerTest {

	public static void main(String[] args) {
		
		OrderQueryService orderQueryService = new OrderQueryService();
		
		try {
			
			for(Order order : orderQueryService.findOrderHistoryForCustomerBy(1)) {
				System.out.println(order.getOrderNumber());
				for(OrderItem item : order.getItems()) {
					System.out.println(item.getName() + " - "+ item.getPrice()
										+" - " + item.getQuantity());
					System.out.println("item total price : " + item.totalPrice());
				}
				System.out.println("Order total price :" + order.totalPrice());
			}
			
			
		} catch (BusinessServiceException e) {
			System.out.println(e.getMessage());
		} 
	
	}

}
