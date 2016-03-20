package de.berndclaasen.datenmonster.backend.model.generic;

import org.springframework.data.annotation.Id;

public abstract class PersistObject {
	@Id
    protected String id;
	
}
