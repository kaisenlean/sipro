package com.formiplass.sipro.views.components.selector;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import com.formiplass.sipro.model.UnidadMedida;
import com.formiplass.sipro.services.GenericService;
import com.formiplass.sipro.services.UnidadMedidaService;

@ManagedBean
@RequestScoped
public class SelectorUnidadMedida extends SelectorBase<UnidadMedida	, Integer> {

	
	@ManagedProperty(value="#{unidadMedidaService}")
	private UnidadMedidaService unidadMedidaService;
	
	
	@PostConstruct
	public void init(){
		cargarLista();
		
	}
	@Override
	public void cargarLista() {
		List<UnidadMedida> listado = unidadMedidaService.findAll();
		setLista(new ArrayList<SelectItem>());
		for (UnidadMedida unidadMedida : listado) {
			getLista().add(new SelectItem(unidadMedida.getCodigo(), unidadMedida.getValor()));
			
		}
	}

	@Override
	public GenericService<UnidadMedida, Integer> getService() {
		return unidadMedidaService;
	}

	public void setUnidadMedidaService(UnidadMedidaService unidadMedidaService) {
		this.unidadMedidaService = unidadMedidaService;
	}
}
