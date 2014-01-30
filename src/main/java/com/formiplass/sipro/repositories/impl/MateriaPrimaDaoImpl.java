package com.formiplass.sipro.repositories.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.formiplass.sipro.model.MateriaPrima;
import com.formiplass.sipro.repositories.MateriaPrimaDao;

@Repository("materiaPrimaDao")
public class MateriaPrimaDaoImpl extends GenericJpaRepository<MateriaPrima, Integer> implements Serializable,MateriaPrimaDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
