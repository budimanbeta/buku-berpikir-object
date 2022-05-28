package com.latihan.myapp.ui.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.latihan.myapp.facade.FacadeException;
import com.latihan.myapp.facade.OrderHistoryFacade;
import com.latihan.myapp.ui.viewmodel.OrderView;

/**
 * Servlet implementation class OrderHistoryController
 */
@WebServlet("/orders.do")
public class OrderHistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public OrderHistoryController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderHistoryFacade facade = new OrderHistoryFacade();
		try {
			List<OrderView> orderViewList = facade.findOrderHistoryByCustomerId(1);
			request.setAttribute("orders", orderViewList);
			request.getRequestDispatcher("order-history.jsp").forward(request, response);
		} catch (FacadeException e) {
		
		}
	}

}
