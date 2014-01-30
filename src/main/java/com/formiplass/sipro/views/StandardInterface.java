/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.formiplass.sipro.views;

import javax.annotation.PostConstruct;

/**
 * 
 * @author ejody
 */
public interface StandardInterface<T,PK> {

	@PostConstruct
	void init();

	// public abstract AbstractFacade<T > getFacade();
	void renderizarItem(T objeto, boolean showForm);

	void eliminarItem(T objeto);

	void verForm();

	void verFormNuevo(boolean showForm);

	String aceptar();

	void buscarrPorCriterio();

}
