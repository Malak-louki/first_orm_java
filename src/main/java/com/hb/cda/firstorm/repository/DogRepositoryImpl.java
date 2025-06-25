package com.hb.cda.firstorm.repository;
import java.util.List;
import java.util.Optional;

import com.hb.cda.firstorm.entity.Dog;
import com.hb.cda.firstorm.repository.interfaces.DogRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;

public class DogRepositoryImpl implements DogRepository {

    @Override
    public List<Dog> findAll() {
        try (EntityManager em = Database.getManager()) {

            return em.createQuery("FROM Dog", Dog.class).getResultList();
        } catch (PersistenceException e) {
            System.err.println(e);

        }
        return null;
    }

    @Override
    public Optional<Dog> findById(int id) {
        try (EntityManager em = Database.getManager()) {

            Dog dog = em.find(Dog.class, id);
            if (dog != null) {
                return Optional.of(dog);
            }
        } catch (PersistenceException e) {
            System.err.println(e);

        }
        return Optional.empty();

        // Ou bien en une seule ligne avec le ofNullable
        // return Optional.ofNullable(em.find(Dog.class, id));
    }

    @Override
    public boolean persist(Dog dog) {
        try(EntityManager em = Database.getManager()) {
            em.getTransaction().begin();
            em.persist(dog);

            em.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            System.err.println(e);

        }
        return false;
    }

    @Override
    public boolean delete(Dog dog) {
        try(EntityManager em = Database.getManager()) {
            em.getTransaction().begin();
            Dog merged = em.merge(dog);
            em.remove(merged);

            em.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            System.err.println(e);

            

        }
        return false;
    }

    @Override
    public boolean update(Dog dog) {
        try(EntityManager em = Database.getManager()) {
            em.getTransaction().begin();
            em.merge(dog);

            em.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            System.err.println(e);

        }
        return false;
    }

}

