package com.formiplass.sipro.views.components.selector;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.SelectItem;

import com.formiplass.sipro.services.GenericService;

public abstract class SelectorBase<T ,PK extends Serializable> {

	private List<SelectItem> lista;
	
	
	public abstract void  cargarLista();
	
	public abstract GenericService<T, PK>  getService();
	
	
	public List<SelectItem> getLista() {
		return lista;
	}
	
	public void setLista(List<SelectItem> lista) {
		this.lista = lista;
	}
}
