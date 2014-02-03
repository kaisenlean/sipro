package com.formiplass.sipro.repositories;

import java.util.List;

import com.formiplass.sipro.exception.BaseException;
import com.formiplass.sipro.model.Usuario;

/**
* @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
* @project rentavoz-3
* @class UsuarioDao
* @date 12/01/2014
*
*/
public interface UsuarioDao extends GenericRepository<Usuario, String> {

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 12/01/2014
	* @return
	* @throws BaseException
	*/
	Usuario login(String login , String contrasena) throws BaseException;
	
	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 3/02/2014
	* @param query
	* @return
	*/
	List<Usuario> findByCriterio(String query);
}
