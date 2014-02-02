package com.formiplass.sipro.repositories.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.formiplass.sipro.model.Item;
import com.formiplass.sipro.repositories.ItemDao;

@Repository("itemDao")
public class ItemDaoImpl extends GenericJpaRepository<Item	, String> implements Serializable,ItemDao {

	private static final String TIPO_INVENTARIO = "tipoInventario";
	private static final String REFERENCIA = "referencia";
	private static final String NOMBRE = "nombre";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<Item> findByCriterio(String parametro,Integer tipoInventario) {
		Criterion criterion= Restrictions.disjunction().add(Restrictions.like(REFERENCIA, parametro,MatchMode.ANYWHERE)).add(Restrictions.like(NOMBRE, parametro,MatchMode.ANYWHERE));
		Criterion criterion2 = Restrictions.eq(TIPO_INVENTARIO, tipoInventario);
		return findByCriteria(criterion,criterion2);
	}

}
