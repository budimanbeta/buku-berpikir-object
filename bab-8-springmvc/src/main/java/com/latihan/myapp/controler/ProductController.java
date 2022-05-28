package com.latihan.myapp.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.latihan.myapp.entity.Product;
import com.latihan.myapp.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/product-list")
	public String productList(Model m) {
				
		m.addAttribute("listProduct", productService.findAllProduct());		
		return "product-list";

	}
	
	@GetMapping("/product-form")
	public String formProduct(Model m) {
		m.addAttribute("newProduct", new Product());
		return "new-product-form";
	}
	
	@PostMapping("/save-product")
	public String saveProduct(@ModelAttribute("newProduct") Product product) {
			productService.save(product);
			return "redirect:/product-list";
	}
}
