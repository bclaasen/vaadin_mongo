package de.berndclaasen.datenmonster.backend.model;

import de.berndclaasen.datenmonster.backend.model.generic.PersistObject;

public class Good extends PersistObject {

	String name;
	String shortname;
	
	public Good() {
		// TODO Auto-generated constructor stub
	}
	
	public Good(String name, String shortname) {
		super();
		this.name = name;
		this.shortname = shortname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	
	
}
