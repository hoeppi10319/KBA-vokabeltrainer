/*
package de.htwberlin.user_management_api;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import de.htwberlin.user_management_api.User;
import de.htwberlin.user_management_api.UserDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserDaoTest {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private UserDao userDao;

    @BeforeEach
    public void setUp() {
        // Verwenden Sie die TestPersistenceUnit für den Test
        entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistenceUnit");
        entityManager = entityManagerFactory.createEntityManager();
        userDao = new UserDao(entityManager);
    }

    @AfterEach
    public void tearDown() {
        if (entityManager != null) {
            entityManager.close();
        }
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }

    @Test
    public void testSaveUser() {
        User user = new User("TestUser");
        userDao.save(user);

        User foundUser = entityManager.find(User.class, user.getId());
        assertNotNull(foundUser, "Der gespeicherte User sollte nicht null sein");
        assertEquals("TestUser", foundUser.getName(), "Der Name des Users sollte übereinstimmen");
    }
}
*/

