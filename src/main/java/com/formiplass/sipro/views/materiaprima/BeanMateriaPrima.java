package com.formiplass.sipro.views.materiaprima;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.SortOrder;

import com.formiplass.sipro.model.MateriaPrima;
import com.formiplass.sipro.services.GenericService;
import com.formiplass.sipro.services.ItemService;
import com.formiplass.sipro.services.MateriaPrimaService;
import com.formiplass.sipro.services.UnidadMedidaService;
import com.formiplass.sipro.views.StandardAbm;
import com.formiplass.sipro.views.components.autocomplete.AutocompletarItem;
import com.formiplass.sipro.views.components.autocomplete.AutocompletarItem2;

@ManagedBean
@ViewScoped
public class BeanMateriaPrima extends StandardAbm<MateriaPrima, Integer>
		implements Serializable {

	private static final String REGLA_NAVEGACION = "/paginas/configuracion/materiaPrima/index.jsf";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{materiaPrimaService}")
	private MateriaPrimaService materiaPrimaService;
	@ManagedProperty(value = "#{itemService}")
	private ItemService itemService;
	
	@ManagedProperty(value="#{unidadMedidaService}")
	private UnidadMedidaService unidadMedidaService;
	
	
	private Integer selMateriaPrima;

	private AutocompletarItem autocompletarItem;
	
	
	private AutocompletarItem2 autocompletarItem2;

	@Override
	public GenericService<MateriaPrima, Integer> getFacade() {
		return materiaPrimaService;
	}

	@Override
	public MateriaPrima getInstancia() {
		return new MateriaPrima();
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
	public List<MateriaPrima> customSearch(int startingAt, int maxPerPage,
			String globalFilter, String sortField, SortOrder sortOrder) {
		return null;
	}

	@Override
	public MateriaPrima getObjeto() {
		return obtenerObjeto();
	}

	@Override
	public List<MateriaPrima> getListado() {
		return obtenerListado();
	}

	
	@Override
	public void initialize() {
		autocompletarItem = new AutocompletarItem() {

			private static final long serialVersionUID = 1L;

			@Override
			public ItemService getService() {
				return itemService;
			}
		};
		autocompletarItem2= new AutocompletarItem2() {
			
			
			private static final long serialVersionUID = 1L;

			@Override
			public ItemService getService() {
				return itemService;
			}
		};
	}
	
	@Override
	public void preRenderizarItem() {

	selMateriaPrima= getObjeto().getUnidadMedida()==null?0:getObjeto().getUnidadMedida().getCodigo();
	autocompletarItem.setSeleccionado(getObjeto().getReferencia());
	autocompletarItem2.setSeleccionado(getObjeto().getMaterial());
	}
	@Override
	public boolean preAction() {
		
		getObjeto().setReferencia(autocompletarItem.getSeleccionado());
		getObjeto().setMaterial(autocompletarItem2.getSeleccionado());
		
		if (selMateriaPrima==null) {
			mensajeError(" Selecciona una unidad de medida");
			return false;
		}
		getObjeto().setUnidadMedida(unidadMedidaService.findById(selMateriaPrima));
		
		return true;
	}

	public void setMateriaPrimaService(MateriaPrimaService materiaPrimaService) {
		this.materiaPrimaService = materiaPrimaService;
	}

	public AutocompletarItem getAutocompletarItem() {
		return autocompletarItem;
	}

	public void setAutocompletarItem(AutocompletarItem autocompletarItem) {
		this.autocompletarItem = autocompletarItem;
	}
	
	
	public AutocompletarItem2 getAutocompletarItem2() {
		return autocompletarItem2;
	}
	
	public void setAutocompletarItem2(AutocompletarItem2 autocompletarItem2) {
		this.autocompletarItem2 = autocompletarItem2;
	}
	
	public Integer getSelMateriaPrima() {
		return selMateriaPrima;
	}
	
	public void setSelMateriaPrima(Integer selMateriaPrima) {
		this.selMateriaPrima = selMateriaPrima;
	}
	
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
	public void setUnidadMedidaService(UnidadMedidaService unidadMedidaService) {
		this.unidadMedidaService = unidadMedidaService;
	}
}
