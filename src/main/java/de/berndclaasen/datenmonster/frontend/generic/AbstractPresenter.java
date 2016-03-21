package de.berndclaasen.datenmonster.frontend.generic;

import de.berndclaasen.datenmonster.backend.model.generic.PersistObject;


public abstract class AbstractPresenter<T extends PersistObject, V extends IOverView> {

	public V view;
	
	public AbstractPresenter() {
		initView();
		initComponents();
	}
	
	private void initView() {
		createView();
	}
	
	protected abstract void createView();
	
	protected abstract void initComponents();
	
	public V getView() {
		return view;
	}
}
