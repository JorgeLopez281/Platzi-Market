package com.platzi.market.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.platzi.market.domain.ProductDomain;
import com.platzi.market.domain.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping("/all")
	public List<ProductDomain> getAll(){
		return productService.getAll();
	}

	@GetMapping("/{id}")
	public Optional<ProductDomain> getProduct(@PathVariable("id") int productId){
		return productService.getProduct(productId);
	}

	@GetMapping("/category/{categoryId}")
	public Optional<List<ProductDomain>> getByCategory(@PathVariable("categoryId") int categoryId){
		return productService.getByCategory(categoryId);
	}

	@PostMapping("/save")
	public ProductDomain save(@RequestBody ProductDomain productD) {
		return productService.save(productD);
	}

	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable("id") int productId) {
		return productService.delete(productId);
	}

}
