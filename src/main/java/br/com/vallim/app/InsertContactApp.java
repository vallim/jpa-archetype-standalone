package br.com.vallim.app;


import br.com.vallim.model.Task;
import br.com.vallim.persistence.PersistenceManager;

import javax.persistence.EntityManager;

/**
 * Shows how to use JPA to persist an entity in the database.
 */
public class InsertContactApp {

    public static void main(String[] args) {

        EntityManager entityManager = PersistenceManager.getEntityManager();
        entityManager.getTransaction().begin();

        Task task = new Task();
        task.setDescription("Change the color of the save button.");

        entityManager.persist(task);
        entityManager.getTransaction().commit();
        entityManager.close();

        PersistenceManager.close(); //closes the EntityManagerFactory
    }
}
