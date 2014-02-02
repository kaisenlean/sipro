package com.formiplass.sipro.services;

import java.util.List;

import com.formiplass.sipro.model.Item;

public interface ItemService extends GenericService<Item	,String>{

	
	/**
	 * Método que consulta los items por criterio de referencia y nombre
	 * @param parametro
	 * @return
	 */
	List<Item> findByCriterio(String parametro,Integer tipoInventario);
}
