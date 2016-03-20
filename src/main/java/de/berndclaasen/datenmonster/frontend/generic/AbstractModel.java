package de.berndclaasen.datenmonster.frontend.generic;

import java.util.List;

import de.berndclaasen.datenmonster.backend.model.generic.PersistObject;

public abstract class AbstractModel<T extends PersistObject> {

	T entity;
	List<T> entityList;
	public T getEntity() {
		return entity;
	}
	public void setEntity(T entity) {
		this.entity = entity;
	}
	public List<T> getEntityList() {
		return entityList;
	}
	public void setEntityList(List<T> entityList) {
		this.entityList = entityList;
	}
	

	
}
