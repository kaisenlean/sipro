package com.formiplass.sipro.repositories;

import java.util.List;

import com.formiplass.sipro.model.Item;

public interface ItemDao extends GenericRepository<Item	, String> {

	
	
	/**
	 * Método que consulta los items por criterio de referencia y nombre
	 * @param parametro
	 * @return
	 */
	List<Item> findByCriterio(String parametro,Integer tipoInventario);
}
