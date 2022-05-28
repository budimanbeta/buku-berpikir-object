package com.latihan.myapp.ui.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.latihan.myapp.facade.FacadeException;
import com.latihan.myapp.facade.PlaceOrderFacade;
import com.latihan.myapp.ui.viewmodel.CartView;
import com.latihan.myapp.ui.viewmodel.ItemView;


@WebServlet("/cart.do")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public CartController() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		CartView cartView = (CartView) request.getSession().getAttribute("cart");
		if(cartView == null) {
			cartView = new CartView();
			request.getSession().setAttribute("cart", cartView);
		}
		
		if("item-form-view".equals(action)) {
			request.getRequestDispatcher("item-form.jsp").forward(request, response);
			
		}else {
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CartView cartView = (CartView) request.getSession().getAttribute("cart");
		
		String action = request.getParameter("action");
		
		if("add-new-item".equals(action)) {
			ItemView itemView = new ItemView();
			itemView.setCode(request.getParameter("code"));
			itemView.setName(request.getParameter("name"));
			itemView.setType(request.getParameter("type"));
			itemView.setPrice(request.getParameter("price"));
			itemView.setQuantity(request.getParameter("quantity"));
			
			cartView.addItem(itemView);
			
		}else if("place-order".equals(action)) {
			PlaceOrderFacade placeOrderFacade = new PlaceOrderFacade("1", cartView);
			try {
				
				placeOrderFacade.process();
				request.getSession().setAttribute("cart", null);
				
			} catch (FacadeException e) {
				
			}
			
		}
		
		response.sendRedirect("cart.do");
		
	}

}
