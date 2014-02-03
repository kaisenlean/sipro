package com.formiplass.sipro.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formiplass.sipro.exception.BaseException;
import com.formiplass.sipro.model.Usuario;
import com.formiplass.sipro.repositories.GenericRepository;
import com.formiplass.sipro.repositories.UsuarioDao;
import com.formiplass.sipro.services.UsuarioService;

/**
* @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
* @project rentavoz-3
* @class UsuarioServiceImpl
* @date 12/01/2014
*
*/
@Service(UsuarioServiceImpl.NAME_SERVICE)
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, String> implements UsuarioService {

	static final String NAME_SERVICE = "usuarioService";
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Override
	public GenericRepository<Usuario, String> getDao() {
		return usuarioDao;
	}

	/** (non-Javadoc)
	 * @see co.innovate.rentavoz.services.usuario.UsuarioService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public Usuario login(String login, String contrasena) throws BaseException {
		return usuarioDao.login(login, contrasena);
	}

	/* (non-Javadoc)
	 * @see co.innovate.rentavoz.services.usuario.UsuarioService#findByCriterio(java.lang.String)
	 */
	@Override
	public List<Usuario> findByCriterio(String query) {
		return usuarioDao.findByCriterio(query);
	}

}
