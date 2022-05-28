package com.latihan.myapp.facade;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.latihan.myapp.core.domain.Order;
import com.latihan.myapp.core.domain.OrderItem;
import com.latihan.myapp.core.service.OrderQueryService;
import com.latihan.myapp.core.service.exception.BusinessServiceException;
import com.latihan.myapp.ui.viewmodel.ItemView;
import com.latihan.myapp.ui.viewmodel.OrderView;

public class OrderHistoryFacade {
	private OrderQueryService orderQueryService;
	
	public OrderHistoryFacade() {
		orderQueryService = new OrderQueryService();
	}
	
	public List<OrderView> findOrderHistoryByCustomerId(int customerId) throws FacadeException{
		List<OrderView> orderViewList = null;
		try {
			List<Order> orders = orderQueryService.findOrderHistoryForCustomerBy(customerId);
			orderViewList = this.mappingOrdersToOrderViewList(orders);
		} catch (BusinessServiceException e) {
			throw new FacadeException(e.getMessage());
		}
		
		return orderViewList;
	}

	private List<OrderView> mappingOrdersToOrderViewList(List<Order> orders) {
		List<OrderView> orderViewList = new ArrayList<>();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#.00");
		for(Order order : orders) {
			OrderView orderView = new OrderView();
			orderView.setOrderNumber(order.getOrderNumber());
			orderView.setOrderDate(formatter.format(order.getOrderDate()));
			orderView.setTotalPrice(df.format(order.totalPrice()));
			
			List<ItemView> itemViewList = new ArrayList<>();
			for(OrderItem item : order.getItems()) {
				ItemView itemView = new ItemView();
				itemView.setCode(item.getCode());
				itemView.setName(item.getName());
				itemView.setType(item.getType());
				itemView.setPrice(df.format(item.getPrice()));
				itemView.setQuantity(String.valueOf(item.getQuantity()));
				itemView.setTotalPrice(df.format(item.totalPrice()));
				
				itemViewList.add(itemView);
			}
			
			orderView.setItems(itemViewList);
			orderViewList.add(orderView);
		}
		return orderViewList;
		
	}
}
