package com.platzi.market.persistence.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "compras")
public class Purchase {
	
	/*
	 * Propiedades de la entidad en PostgreSQL:
	 *  
	 * id_compra 
	 * id_cliente 
	 * fecha
	 * medio_pago 
	 * comentario
	 * estado
	 * 
	 */

	@Id
	@Column(name = "id_compra")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPurchase;

	@Column(name = "id_cliente")
	private String idClient;

	@Column(name = "fecha")
	private LocalDateTime date;

	@Column(name = "medio_pago")
	private String paymentMethod;

	@Column(name = "comentario")
	private String commentary;

	@Column(name = "estado")
	private String status;
	
	/*Relacion que tiene la tabla compras con la tabla clientes*/
	@ManyToOne
	@JoinColumn(name = "id_cliente", insertable = false, nullable = false)
	private Client client;
	
	/*Relacion que tiene la tabla compras con la tabla compras_productos*/
	@OneToMany(mappedBy = "purchase")
	private List<PurchasesProducts> purchasesProducts;

	public Integer getIdPurchase() {
		return idPurchase;
	}

	public void setIdPurchase(Integer idPurchase) {
		this.idPurchase = idPurchase;
	}

	public String getIdClient() {
		return idClient;
	}

	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
