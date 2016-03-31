package de.berndclaasen.datenmonster.frontend.generic;

import de.berndclaasen.datenmonster.backend.model.generic.PersistObject;

public abstract class AbstractPresenter<V extends IView, T extends PersistObject> implements IPresenter {
	
	public V view;

	public abstract V getView();

}
