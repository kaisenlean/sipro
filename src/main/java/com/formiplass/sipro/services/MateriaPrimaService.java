package com.formiplass.sipro.services;

import java.util.List;

import com.formiplass.sipro.model.MateriaPrima;

public interface MateriaPrimaService extends GenericService<MateriaPrima	,Integer>{

	
	
	/**
	 * @param filter
	 * @param sortBy
	 * @param sortOrder
	 * @param start
	 * @param end
	 * @return
	 */
	List<MateriaPrima> findByCriteria(String filter ,String sortBy,String sortOrder,int start ,int end);
	
	
	
	
	/**
	 * @param filter
	 * @return
	 */
	int countByCriteria(String filter);
}
