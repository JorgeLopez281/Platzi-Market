package com.platzi.market.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.market.domain.ProductDomain;
import com.platzi.market.domain.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	public List<ProductDomain> getAll(){
		return productService.getAll();
	}
	
	public Optional<ProductDomain> getProduct(int productId){
		return productService.getProduct(productId);
	}
	
	public Optional<List<ProductDomain>> getByCategory(int categoryId){
		return productService.getByCategory(categoryId);
	}
	
	public ProductDomain save(ProductDomain productD) {
		return productService.save(productD);
	}
	
	public boolean delete(int productId) {
		return productService.delete(productId);
	}

}
