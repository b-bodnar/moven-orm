package ua.logos.dao;

import ua.logos.entity.TeacherEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class TeacherDAO {

    private EntityManager em;

    public TeacherDAO(EntityManager em) {
        this.em = em;
    }

    public List<TeacherEntity> findAllTeachers() {
        List<TeacherEntity> teachers =
                em.createQuery("select t from TeacherEntity t", TeacherEntity.class)
                        .getResultList();
        return teachers;
    }

    public TeacherEntity findTeacherById(Long id) {
        TeacherEntity teacher =
                em.createQuery("select t from TeacherEntity t" +
                        " where t.id = :tId", TeacherEntity.class)
                        .setParameter("tId", id)
                        .getSingleResult();
        return teacher;
    }
}
