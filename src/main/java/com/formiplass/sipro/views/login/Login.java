package com.formiplass.sipro.views.login;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import com.formiplass.sipro.exception.BaseException;
import com.formiplass.sipro.model.Usuario;
import com.formiplass.sipro.services.UsuarioService;
import com.formiplass.sipro.views.BaseBean;


@ManagedBean
@SessionScoped
public class Login extends BaseBean  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{usuarioService}")
	private UsuarioService usuarioService;
	
	
	private String user;
	private String password;
	
	
	private Usuario usuario =null;
	

	public void entrar(){
		try {
			usuario=usuarioService.login(user, password);
			if (usuario==null) {
				mensajeError("Credenciales inválidas");
				return;
			}
			goTo("inicio.jsf");
		} catch (BaseException e) {
		mensajeError("Credenciales inválidas");
		}
		
	}
	
	public void validateSesion(){
		if (usuario==null) {
			goTo("index.jsf");
		}
		
	}
	
	public void validateSesionLOgin(){
		if (usuario!=null) {
			goTo("/inicio.jsf");
		}
		
	}	
	
	
	/**
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 22/07/2013
	 */
	public void logOut() {
		ExternalContext ctx = FacesContext.getCurrentInstance()
				.getExternalContext();
		 String ctxPath = ((ServletContext)
		 ctx.getContext()).getContextPath();

		try {
			// Usar el contexto de JSF para invalidar la sesión,
			// NO EL DE SERVLETS (nada de HttpServletRequest)
			((HttpSession) ctx.getSession(false)).invalidate();
			
	

			// Redirección de nuevo con el contexto de JSF,
			// si se usa una HttpServletResponse fallará.
			// Sin embargo, como ya está fuera del ciclo de vida
			// de JSF se debe usar la ruta completa -_-U
			 ctx.redirect(ctxPath + "/");
		} catch (Exception ex) {
			mensaje("Error", ex.toString());
		}
	}
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
