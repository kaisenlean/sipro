package com.formiplass.sipro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column
	private String referencia;
	
	@Column
	private Double id;
	
	@Column 
	private String nombre;
	

	@Column(name="tipoinventario")
	private  Integer tipoInventario;
	
	
	public Item() {
	}


	public String getReferencia() {
		return referencia;
	}


	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}


	public Double getId() {
		return id;
	}


	public void setId(Double id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getTipoInventario() {
		return tipoInventario;
	}
	
	public void setTipoInventario(Integer tipoInventario) {
		this.tipoInventario = tipoInventario;
	}
	
	
@Override
public String toString() {
	return nombre+"["+referencia+"]";
}
}
