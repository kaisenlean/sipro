package com.formiplass.sipro.repositories.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.formiplass.sipro.model.UnidadMedida;
import com.formiplass.sipro.repositories.UnidadMedidaDao;

@Repository("unidadMedidaDao")
public class UnidadMedidaDaoImpl extends GenericJpaRepository<UnidadMedida	, Integer> implements Serializable,UnidadMedidaDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
