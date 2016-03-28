package de.berndclaasen.datenmonster.backend.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import de.berndclaasen.datenmonster.backend.model.generic.PersistObject;

public interface GenericMongoRepository<T extends PersistObject> extends MongoRepository<T, String> {

}
