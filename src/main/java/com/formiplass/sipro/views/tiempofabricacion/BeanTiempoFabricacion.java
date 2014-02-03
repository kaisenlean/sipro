package com.formiplass.sipro.views.tiempofabricacion;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.SortOrder;

import com.formiplass.sipro.model.TiempoFabricacion;
import com.formiplass.sipro.services.GenericService;
import com.formiplass.sipro.services.ItemService;
import com.formiplass.sipro.services.TiempoFabricacionService;
import com.formiplass.sipro.views.StandardAbm;
import com.formiplass.sipro.views.components.autocomplete.AutocompletarItem;

@ManagedBean
@ViewScoped
public class BeanTiempoFabricacion extends
		StandardAbm<TiempoFabricacion, Integer> implements Serializable {

	private static final String REGLA_NAVEGACION = "/paginas/configuracion/tiempofabricacion/index.jsf";
	@ManagedProperty(value = "#{tiempoFabricacionService}")
	private TiempoFabricacionService tiempoFabricacionService;

	@ManagedProperty(value = "#{itemService}")
	private ItemService itemService;

	private AutocompletarItem autocompletarItem;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public GenericService<TiempoFabricacion, Integer> getFacade() {
		return tiempoFabricacionService;
	}

	@Override
	public TiempoFabricacion getInstancia() {
		return new TiempoFabricacion();
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
	public List<TiempoFabricacion> customSearch(int startingAt, int maxPerPage,
			String globalFilter, String sortField, SortOrder sortOrder) {
		return null;
	}

	@Override
	public TiempoFabricacion getObjeto() {
		return obtenerObjeto();
	}

	@Override
	public List<TiempoFabricacion> getListado() {
		return obtenerListado();
	}

	@Override
	public void initialize() {
		autocompletarItem = new AutocompletarItem() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public ItemService getService() {
				return itemService;
			}
		};
	}

	@Override
	public boolean preAction() {

		getObjeto().setReferencia(autocompletarItem.getSeleccionado());
		return true;
	}

	@Override
	public void preRenderizarItem() {
		autocompletarItem.setSeleccionado(getObjeto().getReferencia());
		autocompletarItem
				.setQuery(getObjeto().getReferencia() != null ? getObjeto()
						.getReferencia().toString() : "");

	}

	public void setTiempoFabricacionService(
			TiempoFabricacionService tiempoFabricacionService) {
		this.tiempoFabricacionService = tiempoFabricacionService;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	public AutocompletarItem getAutocompletarItem() {
		return autocompletarItem;
	}

	public void setAutocompletarItem(AutocompletarItem autocompletarItem) {
		this.autocompletarItem = autocompletarItem;
	}
}
