package de.berndclaasen.datenmonster.frontend.generic;

import de.berndclaasen.datenmonster.backend.model.generic.PersistObject;


public abstract class AbstractOverviewPresenter<T extends PersistObject, V extends IOverView> {

	public V view;
	private Class<V> clazz;
	
	public AbstractOverviewPresenter(Class<V> clazz) {
		this.clazz=clazz;
		initView();
		initComponents();
	}

	private void initView() {
		createView();	
	}
	
	protected abstract void initComponents();
	
	protected void createView() {
		try {
			view=clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	};	

	public V getView() {
		return view;
	}
}
