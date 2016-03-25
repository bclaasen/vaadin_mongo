package de.berndclaasen.datenmonster.frontend.generic;

import de.berndclaasen.datenmonster.backend.model.generic.PersistObject;

public abstract class AbstractPresenter<T extends PersistObject, V extends IView> {

	public V view;
	
	public abstract V getView();
}
