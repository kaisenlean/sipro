package com.formiplass.sipro.repositories.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.formiplass.sipro.model.MateriaPrima;
import com.formiplass.sipro.repositories.MateriaPrimaDao;

@Repository("materiaPrimaDao")
public class MateriaPrimaDaoImpl extends GenericJpaRepository<MateriaPrima, Integer> implements Serializable,MateriaPrimaDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<MateriaPrima> findByCriteria(String filter, String sortBy,
			String sortOrder, int start, int end) {
		
		Session session = getEntityManager().unwrap(Session.class);
		Criteria crit = session.createCriteria(getEntityClass());
		crit.createAlias("referencia", "ref");
		Criterion criterion = Restrictions.disjunction().add(Restrictions.like("ref.referencia", filter,MatchMode.ANYWHERE)).add(Restrictions.like("ref.nombre", filter,MatchMode.ANYWHERE));
		crit.add(criterion);
		crit.setMaxResults(end);
		crit.setFirstResult(start);
		
		if (sortBy.equals(StringUtils.EMPTY)) {
			sortBy="codigo";
		}
		
		if (sortOrder.equals("ASC")) {
			crit.addOrder(Order.asc(sortBy));
		}
		if (sortOrder.equals("DESC")) {
			crit.addOrder(Order.desc(sortBy));
		}
		
		return crit.list();
	}

	@Override
	public int countByCriteria(String filter) {
		Session session = getEntityManager().unwrap(Session.class);
		Criteria crit = session.createCriteria(getEntityClass());
		crit.createAlias("referencia", "ref");
		Criterion criterion = Restrictions.disjunction().add(Restrictions.like("ref.referencia", filter,MatchMode.ANYWHERE)).add(Restrictions.like("ref.nombre", filter,MatchMode.ANYWHERE));
		crit.add(criterion);
		crit.setProjection(Projections.count("codigo"));
		return Long.valueOf( crit.list().get(0).toString()).intValue();
	}

}
