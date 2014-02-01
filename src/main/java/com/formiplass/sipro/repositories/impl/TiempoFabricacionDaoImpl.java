package com.formiplass.sipro.repositories.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.formiplass.sipro.model.TiempoFabricacion;
import com.formiplass.sipro.repositories.TiempoFabricacionDao;

@Repository("tiempoFabricacionDao")
public class TiempoFabricacionDaoImpl extends GenericJpaRepository<TiempoFabricacion	, Integer> implements Serializable,TiempoFabricacionDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
