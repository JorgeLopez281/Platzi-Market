package com.platzi.market.persistence.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Client {
	
	/*
	 * Propiedades de la entidad en PostgreSQL: 
	 * 
	 * id 
	 * nombre 
	 * apellidos
	 * celular
	 * direccion
	 * correo_electronico
	 * 
	 */

	@Id
	private String id;

	@Column(name = "nombre")
	private String name;

	@Column(name = "apellidos")
	private String surnames;

	@Column(name = "celular")
	private Integer cellPhone;

	@Column(name = "direccion")
	private String direction;

	@Column(name = "correo_electronico")
	private String email;
	
	/*Relacion que existe de la tabla categoria hacia productos,
	 * el mappedBy hace referencia al atributo con el que tiene
	 * la relacion en la entidad purchase.
	 * 
	 * Cuando la relacion entre dos tablas es de una a muchos
	 * (@OneToMany) se refiere a que una entidad puede tener 
	 * muchos elementos de la otra entidad entonces se deben 
	 * representar como listas (List<> en Java).*/
	@OneToMany(mappedBy = "client")
	private List<Purchase> purchases;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurnames() {
		return surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	public Integer getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(Integer cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
