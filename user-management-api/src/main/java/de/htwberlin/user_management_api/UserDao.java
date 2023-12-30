package de.htwberlin.user_management_api;

import javax.persistence.EntityManager;

public class UserDao {

    private EntityManager entityManager;

    public UserDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    // Weitere CRUD-Methoden
}
