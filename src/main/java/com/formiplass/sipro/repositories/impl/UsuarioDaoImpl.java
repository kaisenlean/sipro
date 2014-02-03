package com.formiplass.sipro.repositories.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.formiplass.sipro.exception.BaseException;
import com.formiplass.sipro.model.Usuario;
import com.formiplass.sipro.repositories.UsuarioDao;

@Repository(UsuarioDaoImpl.NAME_DAO)
public class UsuarioDaoImpl extends GenericJpaRepository<Usuario, String> implements UsuarioDao{

	static final String NAME_DAO = "usuarioDao";

	/** (non-Javadoc)
	 * @see co.innovate.rentavoz.repositories.usuario.UsuarioDao#login(java.lang.String, java.lang.String)
	 */
	@Override
	public Usuario login(String login, String contrasena) throws BaseException {
		Criterion criteria = Restrictions.conjunction().add(Restrictions.eq("usuario",login)).add( Restrictions.eq("contrasena",contrasena));
		
		
		List<Usuario> usuarios= findByCriteria(criteria);
		
		if (usuarios.isEmpty()) {
			return null;
		}
		
		return usuarios.get(0);
	}

	/* (non-Javadoc)
	 * @see co.innovate.rentavoz.repositories.usuario.UsuarioDao#findByCriterio(java.lang.String)
	 */
	@Override
	public List<Usuario> findByCriterio(String query) {
		Criterion criterion =Restrictions.like("usuario", query,MatchMode.ANYWHERE);
		return findByCriteria(criterion);
	}

}
