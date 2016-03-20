package de.berndclaasen.datenmonster.frontend.generic;

import de.berndclaasen.datenmonster.backend.model.generic.PersistObject;


public abstract class AbstractPresenter<T extends PersistObject, V extends IView> {

	public AbstractPresenter() {
		initViewAndModel();
	}
	
	private void initViewAndModel() {
		createView();
		createModel();
	}
	
	protected abstract void createView();
	protected abstract void createModel();
}
