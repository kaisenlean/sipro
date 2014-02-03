package com.formiplass.sipro.services.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formiplass.sipro.model.TiempoFabricacion;
import com.formiplass.sipro.repositories.GenericRepository;
import com.formiplass.sipro.repositories.TiempoFabricacionDao;
import com.formiplass.sipro.services.TiempoFabricacionService;

@Service("tiempoFabricacionService")
public class TiempoFabricacionServiceImpl extends GenericServiceImpl<TiempoFabricacion, Integer> implements Serializable,TiempoFabricacionService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private TiempoFabricacionDao tiempoFabricacionDao;
	@Override
	public GenericRepository<TiempoFabricacion, Integer> getDao() {
		return tiempoFabricacionDao;
	}

}
