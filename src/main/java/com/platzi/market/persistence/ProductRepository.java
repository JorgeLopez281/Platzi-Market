package com.platzi.market.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.platzi.market.domain.ProductDomain;
import com.platzi.market.domain.repository.IProductRepository;
import com.platzi.market.persistence.crud.ProductCrudRepository;
import com.platzi.market.persistence.entity.Product;
import com.platzi.market.persistence.mapper.ProductMapper;

@Repository
public class ProductRepository implements IProductRepository{
	
	/**
	 * Repositorio Orientado al Dominio
	 */
	@Autowired
	private ProductCrudRepository productCrudRepository;
	@Autowired
	private ProductMapper mapper;
	
	@Override
	public List<ProductDomain> getAll(){
		List<Product> productos = (List<Product>) productCrudRepository.findAll();
		return mapper.toProductsD(productos);
	}
	
	@Override
	public Optional<List<ProductDomain>> getByCategory(int categoryId) {
		List<Product> productos = productCrudRepository.findByIdCategoryOrderByNameAsc(categoryId);
		return Optional.of(mapper.toProductsD(productos));
	}
	
	@Override
	public Optional<List<ProductDomain>> getScarseProducts(int quantity) {
		Optional<List<Product>> productos = productCrudRepository.findByStockQuantityLessThanAndStatus(quantity, true);
		return productos.map(prods -> mapper.toProductsD(prods));
	}
	
	@Override
	public Optional<ProductDomain> getProduct(int productId){
		return productCrudRepository.findById(productId).map(product -> mapper.toProductD(product));
	}
	
	@Override
	public ProductDomain save(ProductDomain product) {
		Product producto = mapper.toProduct(product);
		return mapper.toProductD(productCrudRepository.save(producto));
	}
	
	@Override
	public void delete(int productId) {
		productCrudRepository.deleteById(productId);
		
	}
}
