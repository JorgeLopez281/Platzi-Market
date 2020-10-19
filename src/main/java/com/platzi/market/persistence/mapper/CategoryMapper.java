package com.platzi.market.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.platzi.market.domain.CategoryDomain;
import com.platzi.market.persistence.entity.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
	
	/*
	 * Si los atributos son los mismos se puede omitir estos mappings pero la
	 * idea es que la clase dominio tenga menos, recordar que esto es para
	 * una aplicacion orientada en terminos de dominio.
	 * 
	 * Source -> La entidad
	 * Target -> Clase Dominio
	 */
	@Mappings({
		@Mapping(source = "idCategory", target = "categoryId"),
		@Mapping(source = "description", target = "category"),
		@Mapping(source = "status", target = "active")
	})
	CategoryDomain toCategoryD(Category category);
	
	//Anotacion para definirle que es el mapeo inverso.
	@InheritInverseConfiguration
	@Mapping(target = "products", ignore = true)
	Category toCategory(CategoryDomain categoryDomain);

}
