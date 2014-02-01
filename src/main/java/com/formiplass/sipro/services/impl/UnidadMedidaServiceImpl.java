package com.formiplass.sipro.services.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formiplass.sipro.model.UnidadMedida;
import com.formiplass.sipro.repositories.GenericRepository;
import com.formiplass.sipro.repositories.UnidadMedidaDao;
import com.formiplass.sipro.services.UnidadMedidaService;

@Service("unidadMedidaService")
public class UnidadMedidaServiceImpl extends GenericServiceImpl<UnidadMedida, Integer> implements Serializable,UnidadMedidaService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private UnidadMedidaDao unidadMedidaDao;
	@Override
	public GenericRepository<UnidadMedida, Integer> getDao() {
		return unidadMedidaDao;
	}

}
