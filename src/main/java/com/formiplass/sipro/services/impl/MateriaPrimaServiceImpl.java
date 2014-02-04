package com.formiplass.sipro.services.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formiplass.sipro.model.MateriaPrima;
import com.formiplass.sipro.repositories.GenericRepository;
import com.formiplass.sipro.repositories.MateriaPrimaDao;
import com.formiplass.sipro.services.MateriaPrimaService;

@Service("materiaPrimaService")
public class MateriaPrimaServiceImpl extends GenericServiceImpl<MateriaPrima, Integer> implements Serializable,MateriaPrimaService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private MateriaPrimaDao materiaPrimaDao;
	@Override
	public GenericRepository<MateriaPrima, Integer> getDao() {
		return materiaPrimaDao;
	}
	@Override
	public List<MateriaPrima> findByCriteria(String filter, String sortBy,
			String sortOrder, int start, int end) {
		
		return materiaPrimaDao.findByCriteria(filter, sortBy, sortOrder, start, end);
	}
	@Override
	public int countByCriteria(String filter) {
		return materiaPrimaDao.countByCriteria(filter);
	}

}
