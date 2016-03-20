package de.berndclaasen.datenmonster.backend.service;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import de.berndclaasen.datenmonster.backend.model.Good;

public interface GoodRepository extends MongoRepository<Good, String> {

   public List<Good> findByName(String name);

}
