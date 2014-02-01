package com.formiplass.sipro.repositories.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.formiplass.sipro.model.Item;
import com.formiplass.sipro.repositories.ItemDao;

@Repository("itemDao")
public class ItemDaoImpl extends GenericJpaRepository<Item	, String> implements Serializable,ItemDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
