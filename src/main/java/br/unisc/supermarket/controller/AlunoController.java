/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisc.supermarket.controller;
//
//import br.unisc.trabalho.controller.exceptions.IllegalOrphanException;
//import br.unisc.trabalho.controller.exceptions.NonexistentEntityException;
import br.unisc.supermarket.model.Aluno;
import br.unisc.supermarket.model.Disciplina;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author jose
 */
public class AlunoController implements Serializable {

    public AlunoController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Aluno aluno) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            if (aluno.getIdAluno() != null) {
                em.merge(aluno);
            } else {
                em.persist(aluno);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
//
//    public void save(Integer id) throws IllegalOrphanException, NonexistentEntityException {
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            Aluno aluno;
//            try {
//                aluno = em.getReference(Aluno.class, id);
//                aluno.getIdAluno();
//            } catch (EntityNotFoundException enfe) {
//                throw new NonexistentEntityException("The aluno with id " + id + " no longer exists.", enfe);
//            }
//            List<String> illegalOrphanMessages = null;
//            if (illegalOrphanMessages != null) {
//                throw new IllegalOrphanException(illegalOrphanMessages);
//            }
//            em.remove(aluno);
//            em.getTransaction().commit();
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//    }

    public List<Aluno> findAll() {
        EntityManager em = getEntityManager();
        Query q = em.createNativeQuery("SELECT * FROM aluno ORDER BY nm_aluno", Aluno.class);
        return q.getResultList();
    }

    public List<Aluno> findAllMatriculados() {
        EntityManager em = getEntityManager();
        Query q = em.createNativeQuery("SELECT * FROM aluno a JOIN aluno_disciplina ad ON a.id_aluno = ad.id_aluno "
                + "WHERE a.fg_ativo IS TRUE AND ad.id_disciplina IS NOT NULL "
                + "ORDER BY a.nm_aluno", Aluno.class);
        return q.getResultList();
    }

    public List<Aluno> findAllMatriculadosByDisciplina(Integer idDisciplina) {
        EntityManager em = getEntityManager();
        Query q = em.createNativeQuery("SELECT * FROM aluno a JOIN aluno_disciplina ad ON a.id_aluno = ad.id_aluno "
                + "JOIN disciplina d ON d.id_disciplina = ad.id_disciplina "
                + "WHERE a.fg_ativo IS TRUE AND ad.id_disciplina = " + idDisciplina + " "
                + "ORDER BY a.nm_aluno", Aluno.class);
        return q.getResultList();
    }

    public Aluno findAluno(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Aluno.class, id);
        } finally {
            em.close();
        }
    }

    public Disciplina findAlunoMatriculadoByTag(String tag) {
        try {
            Date date = new Date();
            DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

            EntityManager em = getEntityManager();
            String sql = "SELECT * FROM aluno a JOIN aluno_disciplina ad ON a.id_aluno= ad.id_aluno "
                    + "JOIN disciplina d ON d.id_disciplina = ad.id_disciplina "
                    + "JOIN turno_disciplina t ON d.id_turno_disciplina = t.id_turno_disciplina "
                    + "JOIN schedule s ON s.id_disciplina = d.id_disciplina "
                    + "WHERE a.tag_rfid = '" + tag + "' "
                    + "AND s.dt_schedule = '" + formatter.format(date) + "' "
                    + "AND t.hr_fim <= current_time "
                    + "AND t.hr_inicio >= current_time "
                    + "AND a.fg_ativo IS TRUE ";
            Query q = em.createNativeQuery(sql, Disciplina.class);
            return (Disciplina) q.getResultList().get(0);

        } catch (Exception e) {
            return null;
        }
    }

//    public Aluno findAlunoByTag(String tag) {
//        try {
//            String data;
//            Date date = new Date();
//            DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
//
//            EntityManager em = getEntityManager();
//            String sql = "SELECT * FROM aluno a JOIN aluno_disciplina ad ON a.id_aluno= ad.id_aluno "
//                    + "JOIN disciplina d ON d.id_disciplina = ad.id_disciplina "
//                    + "JOIN turno_disciplina t ON d.id_turno_disciplina = t.id_turno_disciplina "
//                    + "JOIN schedule s ON s.id_disciplina = d.id_disciplina "
//                    + "WHERE a.tag_rfid = '" + tag + "' AND s.dt_schedule = '" + formatter.format(date) + "' "
//                    + "AND t.hr_fim <= current_time "
//                    + "AND t.hr_inicio >= current_time "
//                    + "AND fg_ativo IS TRUE ";
//            Query q = em.createNativeQuery(sql, Aluno.class);
//            return (Aluno) q.getResultList().get(0);
//
//        } catch (Exception e) {
//            return null;
//        }
//    }
    public List<Aluno> findAlunoNaoMatriculadosByDisciplina(Integer idDisciplina) {

        String sql = " SELECT DISTINCT a.* FROM aluno a LEFT JOIN aluno_disciplina ad ON a.id_aluno = ad.id_aluno "
                + " WHERE ad.id_disciplina <> " + idDisciplina + " OR ad.id_disciplina IS NULL AND a.fg_ativo IS TRUE "
                + " ORDER BY a.nm_aluno ";
        EntityManager em = getEntityManager();
        Query q = em.createNativeQuery(sql, Aluno.class);

        return q.getResultList();
    }

    public Aluno findAlunoByTag(String tag) {
        String sql = " SELECT DISTINCT a.* FROM aluno a "
                + "WHERE a.tag_rfid = '" + tag + "' ";
        
        EntityManager em = getEntityManager();
        Query q = em.createNativeQuery(sql, Aluno.class);
        return (Aluno) q.getSingleResult();
    }

}
