package com.hb.cda.repository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hb.cda.firstorm.entity.Dog;
import com.hb.cda.firstorm.repository.Database;
import com.hb.cda.firstorm.repository.DogRepositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;


public class DogRepositoryImplTest {
    @BeforeEach
    void setUp(){
        Dog dog1 = new Dog("test1","test1",10);
        Dog dog2 = new Dog("test2","test2",10);
        
        EntityManager em = Database.getManager();
        em.getTransaction().begin();
    
        em.persist(dog1);
        em.persist(dog2);
        em.getTransaction().commit();
    }
    @Test
    void shouldPassAssertion(){
        int result = 2+2;
        assertEquals(4, result);
    }

    @Test
    void shouldFindAllDogs() {
        DogRepositoryImpl repo = new DogRepositoryImpl();

        List<Dog> results = repo.findAll();
        assertEquals(10, results.size());
        assertEquals("test1", results.get(0).getName());
        assertEquals("test1", results.get(0).getBreed());
        assertEquals(10, results.get(0).getAge());
    }

    @Test
    void shouldFindAllDogsBis(){
        DogRepositoryImpl repo = new DogRepositoryImpl();
        List<Dog> results = repo.findAll();
        assertEquals(14, results.size());
    }

       @Test
    void findByIDShouldReturnOneDog() {

    }

     @Test
     void findByIDShouldReturnEmptyOptionnalIfNoDogMatch() {}

     @Test
     void persistShouldAddDogInDatabase() {}

     @Test
     void deleteShouldRemoveDogFromDatabase() {}

     @Test
     void deleteShouldDoNothingIfDogDontExist() {}

     @Test
     void updateShouldUpdateDogOnDatabase() {}

}

