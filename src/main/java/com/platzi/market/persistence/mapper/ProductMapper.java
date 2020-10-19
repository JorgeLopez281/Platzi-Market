package com.platzi.market.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.platzi.market.domain.ProductDomain;
import com.platzi.market.persistence.entity.Product;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
	
	/*
	 * Si los atributos son los mismos se puede omitir estos mappings pero la
	 * idea es que la clase dominio tenga menos, recordar que esto es para
	 * una aplicacion orientada en terminos de dominio.
	 * 
	 * Source -> La entidad
	 * Target -> Clase Dominio
	 */
	@Mappings({
		@Mapping(source = "idProduct", target = "productId"),
		@Mapping(source = "name", target = "name"),
		@Mapping(source = "idCategory", target = "categoryId"),
		@Mapping(source = "price", target = "price"),
		@Mapping(source = "stockQuantity", target = "stock"),
		@Mapping(source = "status", target = "active"),
		@Mapping(source = "category", target = "category")
	})
	ProductDomain toProductD(Product product);
	
	List<ProductDomain> toProductsD(List<Product> products);
	
	@InheritInverseConfiguration
	@Mapping(target = "barCode", ignore = true)
	Product toProduct(ProductDomain productDomain);

}
