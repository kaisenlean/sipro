package com.formiplass.sipro.services;

import java.io.Serializable;

import com.formiplass.sipro.repositories.GenericRepository;

/**
 * 
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class GenericService
 * @date 22/10/2013
 * 
 */
public interface GenericService<C, PK extends Serializable> extends
		GenericRepository<C, PK> {

}
