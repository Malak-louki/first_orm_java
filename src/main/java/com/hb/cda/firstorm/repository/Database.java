package com.hb.cda.firstorm.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Database {
    private static EntityManagerFactory factory;

    public static EntityManager getManager() {
        if(factory == null) {
            factory = Persistence
                .createEntityManagerFactory("main");
        }

        return factory.createEntityManager();
    }
}
