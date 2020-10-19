package com.platzi.market.persistence.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.platzi.market.persistence.entity.Product;

public interface ProductCrudRepository extends CrudRepository<Product, Integer>{
	
	public List<Product> findByIdCategoryOrderByNameAsc(int idCategory);
	
	Optional<List<Product>> findByStockQuantityLessThanAndStatus(int stockQuantity, boolean status);

}
