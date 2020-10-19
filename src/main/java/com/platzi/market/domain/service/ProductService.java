package com.platzi.market.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platzi.market.domain.ProductDomain;
import com.platzi.market.domain.repository.IProductRepository;
import com.platzi.market.persistence.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private IProductRepository iProductRepository;
	
	public List<ProductDomain> getAll(){
		return iProductRepository.getAll();
	}
	
	public Optional<ProductDomain> getProduct(int productId){
		return iProductRepository.getProduct(productId);
	}
	
	public Optional<List<ProductDomain>> getByCategory(int categoryId){
		return iProductRepository.getByCategory(categoryId);
	}
	
	public ProductDomain save(ProductDomain productD) {
		return iProductRepository.save(productD);
	}
	
	public boolean delete(int productId) {
		return getProduct(productId).map(product -> {
			iProductRepository.delete(productId);
			return true;
		}).orElse(false);
		
//		if (getProduct(productId).isPresent()) {
//			iProductRepository.delete(productId);
//			return true;
//		}else {
//			return false;
//		}
		
	}

}
