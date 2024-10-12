package dao;

import Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TaskDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("task-managerPU");

    public void create(Task task) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(task);
        em.getTransaction().commit();
        em.close();
    }

    public List<Task> getAll() {
        EntityManager em = emf.createEntityManager();
        List<Task> tasks = em.createQuery("from Task", Task.class).getResultList();
        em.close();
        return tasks;
    }

    public Task getById(Long id) {
        EntityManager em = emf.createEntityManager();
        Task task = em.find(Task.class, id);
        em.close();
        return task;
    }

    public void update(Task task) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(task); 
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Task task = em.find(Task.class, id);
        if (task != null) {
            em.remove(task);
        }
        em.getTransaction().commit();
        em.close();
    }

    public List<Task> getByStatus(boolean completed) {
        EntityManager em = emf.createEntityManager();
        List<Task> tasks = em.createQuery("SELECT t FROM Task t WHERE t.completed = :completed", Task.class)
                .setParameter("completed", completed)
                .getResultList();
        em.close();
        return tasks;
    }
}
