package com.platzi.market.domain.repository;

import java.util.List;
import java.util.Optional;

import com.platzi.market.domain.ProductDomain;

public interface IProductRepository {
	
	List<ProductDomain> getAll();
	Optional<List<ProductDomain>> getByCategory(int categoryId);
	Optional<List<ProductDomain>> getScarseProducts(int quantity);
	Optional<ProductDomain> getProduct(int productId);
	ProductDomain save(ProductDomain product);
	void delete(int productId);

}
