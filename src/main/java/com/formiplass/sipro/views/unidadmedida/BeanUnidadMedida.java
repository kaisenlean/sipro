package com.formiplass.sipro.views.unidadmedida;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.SortOrder;

import com.formiplass.sipro.model.UnidadMedida;
import com.formiplass.sipro.services.GenericService;
import com.formiplass.sipro.services.UnidadMedidaService;
import com.formiplass.sipro.views.StandardAbm;

@ManagedBean
@ViewScoped
public class BeanUnidadMedida extends StandardAbm<UnidadMedida, Integer>
		implements Serializable {

	private static final String REGLA_NAVEGACION = "/paginas/configuracion/unidadmedida/index.jsf";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{unidadMedidaService}")
	private UnidadMedidaService unidadMedidaService;

	@Override
	public GenericService<UnidadMedida, Integer> getFacade() {
		return unidadMedidaService;
	}

	@Override
	public UnidadMedida getInstancia() {
		return new UnidadMedida();
	}

	@Override
	public boolean preAction() {
		if (getObjeto().getValor() == null) {
			mensajeError("Digita un valor");
			return false;
		}
		return true;
	}

	@Override
	public String reglaNavegacion() {
		return REGLA_NAVEGACION;
	}

	@Override
	public Integer custoCountBySearch(String globalFilter) {
		return null;
	}

	@Override
	public List<UnidadMedida> customSearch(int startingAt, int maxPerPage,
			String globalFilter, String sortField, SortOrder sortOrder) {
		return null;
	}

	@Override
	public UnidadMedida getObjeto() {
		return obtenerObjeto();
	}

	@Override
	public List<UnidadMedida> getListado() {
		return obtenerListado();
	}

	@Override
	public void initialize() {

	}

	public void setUnidadMedidaService(UnidadMedidaService unidadMedidaService) {
		this.unidadMedidaService = unidadMedidaService;
	}
}
