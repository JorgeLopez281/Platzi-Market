package com.platzi.market.persistence.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Category {

	/*
	 * Propiedades de la entidad en PostgreSQL:
	 * 
	 * id_categoria descripcion estado
	 * 
	 */

	@Id
	@Column(name = "id_categoria")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCategory;

	@Column(name = "descripcion")
	private String description;

	@Column(name = "estado")
	private Boolean status;

	/*
	 * Relacion que existe de la tabla categoria hacia productos, el mappedBy hace
	 * referencia al atributo con el que tiene la relacion en la entidad products.
	 * 
	 * Cuando la relacion entre dos tablas es de una a muchos (@OneToMany) se
	 * refiere a que una entidad puede tener muchos elementos de la otra entidad
	 * entonces se deben representar como listas (List<> en Java).
	 */

	@OneToMany(mappedBy = "category")
	private List<Product> products;

	public Integer getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
