package com.formiplass.sipro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tiempo_fabricacion")
public class TiempoFabricacion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "referencia")
	private Item referencia;

	@Column(name = "tipo_operacion")
	private String tipoOperacion;

	@Column
	private String actividad;

	@Column
	private Integer unidad;

	@Column(name = "numeros_colaboradores")
	private Integer numerosColaboradores;

	public TiempoFabricacion() {

	}

	public Item getReferencia() {
		return referencia;
	}

	public void setReferencia(Item referencia) {
		this.referencia = referencia;
	}

	public String getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public Integer getUnidad() {
		return unidad;
	}

	public void setUnidad(Integer unidad) {
		this.unidad = unidad;
	}

	public Integer getNumerosColaboradores() {
		return numerosColaboradores;
	}

	public void setNumerosColaboradores(Integer numerosColaboradores) {
		this.numerosColaboradores = numerosColaboradores;
	}
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

}
