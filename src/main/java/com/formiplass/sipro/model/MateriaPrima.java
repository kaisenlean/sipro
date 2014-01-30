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
@Table(name = "materia_prima")
public class MateriaPrima implements Serializable {

	/**
	 * CREATE TABLE materia_prima (codigo INT (11) PRIMARY KEY , referencia
	 * VARCHAR(100) , material VARCHAR(255),unidad_medida INT(11),cantidad
	 * DOUBLE(10,2),talla VARCHAR(100));
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@JoinColumn(name="referencia")
	private Item referencia;

	@Column
	private String material;

	@ManyToOne
	@JoinColumn(name = "unidad_medida")
	private UnidadMedida unidadMedida;

	public MateriaPrima() {

	}

	@Column
	private Double cantidad;

	@Column
	private String talla;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Item getReferencia() {
		return referencia;
	}

	public void setReferencia(Item referencia) {
		this.referencia = referencia;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public UnidadMedida getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(UnidadMedida unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

}
