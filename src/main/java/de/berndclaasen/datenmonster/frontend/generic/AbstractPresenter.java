package de.berndclaasen.datenmonster.frontend.generic;

import de.berndclaasen.datenmonster.backend.model.generic.PersistObject;


public abstract class AbstractPresenter<T extends PersistObject, V extends IOverView> {

	public V view;
	
	public AbstractPresenter() {
		initView();
	}
	
	private void initView() {
		createView();
		initComponents();
	}
	
	protected abstract void initComponents();
	
	protected abstract void createView();	

	public V getView() {
		return view;
	}
}
