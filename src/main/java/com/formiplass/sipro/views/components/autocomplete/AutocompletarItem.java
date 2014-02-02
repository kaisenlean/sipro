package com.formiplass.sipro.views.components.autocomplete;

import java.io.Serializable;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.primefaces.event.SelectEvent;

import com.formiplass.sipro.model.Item;
import com.formiplass.sipro.model.TipoInventarioEnum;
import com.formiplass.sipro.services.ItemService;

public abstract class AutocompletarItem extends Autocompletar<Item> implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public abstract ItemService getService();

	@Override
	public List<Item> completarBusqueda(String query) {
		return getService().findByCriterio(query,TipoInventarioEnum.PRODUCTO_TERMINADO.ordinal()+1);
	}

	@Override
	public void seleccionar(SelectEvent evt) {

		seleccionado = (Item) evt.getObject();
		query=seleccionado.toString();
	}

	public Converter getConversorItems() {
		return new Converter() {
			@Override
			public Object getAsObject(FacesContext context,
					UIComponent component, String value) {
				if (value.trim().equals("") || value == null) {
					return null;
				}

				Item c = getService().findById(value);
				seleccionado = c;
				return c;
			}

			@Override
			public String getAsString(FacesContext context,
					UIComponent component, Object value) {
				if (value == null || value.equals("")) {
					return "";
				} else {
					return ((Item) value).getReferencia();
				}
			}
		};

	}

}
