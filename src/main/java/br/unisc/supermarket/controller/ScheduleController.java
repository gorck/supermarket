/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisc.supermarket.controller;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import br.unisc.supermarket.model.RegistroPresenca;
import br.unisc.supermarket.model.Schedule;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author jose
 */
public class ScheduleController implements Serializable {

    public ScheduleController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void save(Schedule schedule) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            if (schedule.getIdSchedule()!= null) {
                em.merge(schedule);
            } else {
                em.persist(schedule);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

//    public void destroy(Integer id) throws NonexistentEntityException {
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            Schedule schedule;
//            try {
//                schedule = em.getReference(Schedule.class, id);
//                schedule.getIdSchedule();
//            } catch (EntityNotFoundException enfe) {
//                throw new NonexistentEntityException("The schedule with id " + id + " no longer exists.", enfe);
//            }
//            List<RegistroPresenca> registroPresencaList = schedule.getRegistroPresencaList();
//            for (RegistroPresenca registroPresencaListRegistroPresenca : registroPresencaList) {
//                registroPresencaListRegistroPresenca.setIdSchedule(null);
//                registroPresencaListRegistroPresenca = em.merge(registroPresencaListRegistroPresenca);
//            }
//            em.remove(schedule);
//            em.getTransaction().commit();
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//    }

    public List<Schedule> findByIdDiscipina(int id) {

        EntityManager em = getEntityManager();
        Query q = em.createNativeQuery("SELECT * FROM schedule s JOIN disciplina d ON d.id_disciplina = s.id_disciplina "
                + "WHERE d.id_disciplina = " + id, Schedule.class);
        if (q.getResultList() == null) {
            return new ArrayList<Schedule>();
        }
        return q.getResultList();
    }

    public Schedule findByIdAlunoAndDate(int id) {
        Date date = new Date();
        DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        EntityManager em = getEntityManager();
        Query q = em.createNativeQuery(""
                + "SELECT s.* FROM aluno a JOIN aluno_disciplina ad ON a.id_aluno= ad.id_aluno "
                + "JOIN disciplina d ON d.id_disciplina = ad.id_disciplina "
                + "JOIN turno_disciplina t ON d.id_turno_disciplina = t.id_turno_disciplina "
                + "JOIN schedule s ON s.id_disciplina = d.id_disciplina "
                + "WHERE a.id_aluno = " + id + " AND s.dt_schedule = '" + formatter.format(date) + "' ", Schedule.class
        );

        if (q.getResultList() == null) {
            return null;
        }
        return (Schedule) q.getResultList().get(0);
    }

}
