package com.platzi.market.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Product {

	/*
	 * Propiedades de la entidad en PostgreSQL:
	 * 
	 * id_producto 
	 * nombre 
	 * id_categoria 
	 * codigo_barras 
	 * precio_venta 
	 * cantidad_stock
	 * estado
	 * 
	 * Solo aprovecho para mencionar a todos aquellos que estan aprendiendo Java en
	 * este curso, que aunque para este ejemplo esta bien, para un aplicativo real,
	 * no se deberian usar atributos de tipo Float o Double para almacenar datos
	 * monetarios (precios, totales, intereses, impuestos, etc.) sino el tipo de
	 * dato BigDecimal.
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto", nullable = false)
	private Integer idProduct;

	@Column(name = "nombre", length = 45)
	private String name;

	@Column(name = "id_categoria")
	private Integer idCategory;

	@Column(name = "codigo_barras", length = 150)
	private String barCode;

	@Column(name = "precio_venta", length = 16)
	private Double price;

	@Column(name = "cantidad_stock")
	private Integer stockQuantity;

	@Column(name = "estado")
	private Boolean status;

	/*
	 * Relacion con la tabla Category, insertable y updatable, siginifica que por
	 * medio de esta relacion no se podra actualizar ni borrar una categoria si se
	 * requiere debe hacerce directamente con su entidad.
	 */

	@ManyToOne
	@JoinColumn(name = "id_categoria", insertable = false, updatable = false)
	private Category category;

	public Integer getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(Integer stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
