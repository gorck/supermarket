/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisc.supermarket.controller;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import br.unisc.supermarket.model.Aluno;
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
public class RegistroPresencaController implements Serializable {

    public RegistroPresencaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void save(RegistroPresenca registroPresenca) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            if (registroPresenca.getIdRegistroPresenca() != null) {
                em.merge(registroPresenca);
            } else {
                em.persist(registroPresenca);
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
//            RegistroPresenca registroPresenca;
//            try {
//                registroPresenca = em.getReference(RegistroPresenca.class, id);
//                registroPresenca.getIdRegistroPresenca();
//            } catch (EntityNotFoundException enfe) {
//                throw new NonexistentEntityException("The registroPresenca with id " + id + " no longer exists.", enfe);
//            }
//            em.remove(registroPresenca);
//            em.getTransaction().commit();
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//    }

    public List<Aluno> findByIdScheduleAndIdDisciplina(int idSchedule, int idDisciplina) {

        try {
            EntityManager em = getEntityManager();
            Query q = em.createNativeQuery("SELECT a.* FROM aluno a JOIN registro_presenca rp ON a.id_aluno = rp.id_aluno "
                    + "JOIN schedule s ON rp.id_schedule = s.id_schedule "
                    + "JOIN disciplina d ON d.id_disciplina = s.id_disciplina  "
                    + "WHERE d.id_disciplina = " + idDisciplina + " "
                    + "AND s.id_schedule = " + idSchedule + " "
                    + "ORDER BY a.nm_aluno", Aluno.class);
            return q.getResultList();
        } catch (Exception e) {

        }
        return new ArrayList<>();
    }

    public Boolean findByregistro(int idAluno, int idDisciplina) {
        try {
            Date date = new Date();
            DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            EntityManager em = getEntityManager();
            Query q = em.createNativeQuery("SELECT * FROM registro_presenca "
                    + "WHERE id_aluno = " + idAluno + " AND "
                    + "id_disciplina = " + idDisciplina + " "
                    + "AND dt_presenca = '" + formatter.format(date) + "' "
                    + " ", Schedule.class);
            if (q.getResultList().size() > 0) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

}
