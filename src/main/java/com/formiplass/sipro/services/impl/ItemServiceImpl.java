package com.formiplass.sipro.services.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formiplass.sipro.model.Item;
import com.formiplass.sipro.repositories.GenericRepository;
import com.formiplass.sipro.repositories.ItemDao;
import com.formiplass.sipro.services.ItemService;

@Service("itemService")
public class ItemServiceImpl extends GenericServiceImpl<Item, String> implements Serializable,ItemService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ItemDao itemDao;
	@Override
	public GenericRepository<Item, String> getDao() {
		return itemDao;
	}
	@Override
	public List<Item> findByCriterio(String parametro,Integer tipoInventario) {
		return itemDao.findByCriterio(parametro,tipoInventario);
	}

}
