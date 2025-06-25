package com.hb.cda.firstorm;

import com.hb.cda.firstorm.entity.Dog;
import com.hb.cda.firstorm.repository.DogRepositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManager em = Persistence
        .createEntityManagerFactory("main")
        .createEntityManager();

        Dog dog = new Dog();
        dog.setName("Fido");
        dog.setBreed("Corgi");
        dog.setAge(5);
        
        em.getTransaction().begin();

        em.persist(dog);
        em.flush();
        em.getTransaction().commit();


        DogRepositoryImpl repo = new DogRepositoryImpl();

        System.out.println(repo.findAll());
    }
}
