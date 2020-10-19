package com.platzi.market.persistence.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "compras_productos")
public class PurchasesProducts {

	@EmbeddedId
	private PurchasesProductsPK id;

	@Column(name = "cantidad")
	private Integer cantity;

	private Double total;

	@Column(name = "estado")
	private Boolean status;
	
	/*Relacion con la tabla PurchasesProducts con la tabla product, nullable y updatable, siginifica que por medio
	 * de esta relacion no se podra actualizar ni borrar un producto si se requiere
	 * debe hacerce directamente con su entidad.*/
	@ManyToOne
	@JoinColumn(name = "id_producto", nullable = false, updatable = false)
	private Product product;
	
	/*Relacion con la tabla PurchasesProducts con la tabla purchase, nullable y updatable, siginifica que por medio
	 * de esta relacion no se podra actualizar ni borrar una compra si se requiere
	 * debe hacerce directamente con su entidad.*/
	@ManyToOne
	@JoinColumn(name = "id_compra", nullable = false, updatable = false)
	private Purchase purchase;

	public PurchasesProductsPK getId() {
		return id;
	}

	public void setId(PurchasesProductsPK id) {
		this.id = id;
	}

	public Integer getCantity() {
		return cantity;
	}

	public void setCantity(Integer cantity) {
		this.cantity = cantity;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
