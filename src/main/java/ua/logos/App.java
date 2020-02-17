package ua.logos;

import ua.logos.entity.TeacherEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {

        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("logos");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

//        TeacherEntity teacherEntity = new TeacherEntity();
//        teacherEntity.setFirstName("John");
//        teacherEntity.setLastName("Doe");
//        teacherEntity.setEmail("john.doe@gmail.com");
//        em.persist(teacherEntity);

        TeacherEntity teacherEntity =
                em.createQuery("SELECT t FROM TeacherEntity t WHERE t.id = :tId", TeacherEntity.class)
                    .setParameter("tId", 1L)
                        .getSingleResult();
        System.out.println(teacherEntity);

        em.getTransaction().commit();
        em.close();
        factory.close();
    }
}
