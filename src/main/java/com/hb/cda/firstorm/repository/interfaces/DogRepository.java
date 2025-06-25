package com.hb.cda.firstorm.repository.interfaces;

import java.util.List;
import java.util.Optional;

import com.hb.cda.firstorm.entity.Dog;

public interface DogRepository {

    List<Dog> findAll();
    Optional<Dog> findById(int id);
    boolean persist(Dog dog);
    boolean delete(Dog dog);
    boolean update(Dog dog);
}


