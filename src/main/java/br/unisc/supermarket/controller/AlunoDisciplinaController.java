/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisc.supermarket.controller;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.unisc.supermarket.model.Aluno;
import br.unisc.supermarket.model.AlunoDisciplina;
import br.unisc.supermarket.model.Disciplina;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author jose
 */
public class AlunoDisciplinaController implements Serializable {

    public AlunoDisciplinaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void save(AlunoDisciplina alunoDisciplina) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            if (alunoDisciplina.getIdAlunoDisciplina() != null) {
                em.merge(alunoDisciplina);
            } else {
                em.persist(alunoDisciplina);
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
//            AlunoDisciplina alunoDisciplina;
//            try {
//                alunoDisciplina = em.getReference(AlunoDisciplina.class, id);
//                alunoDisciplina.getIdAlunoDisciplina();
//            } catch (EntityNotFoundException enfe) {
//                throw new NonexistentEntityException("The alunoDisciplina with id " + id + " no longer exists.", enfe);
//            }
//            Aluno idAluno = alunoDisciplina.getIdAluno();
//            em.remove(alunoDisciplina);
//            em.getTransaction().commit();
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//    }

    public AlunoDisciplina findAlunoDisciplina(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AlunoDisciplina.class, id);
        } finally {
            em.close();
        }
    }
    
     public List<AlunoDisciplina> findAllAlunoDisciplina() {

        EntityManager em = getEntityManager();
        Query q = em.createNativeQuery("SELECT * FROM aluno a JOIN aluno_disciplina ad ON a.id_aluno = ad.id_aluno "
                + "WHERE a.fg_ativo IS TRUE AND ad.id_disciplina IS NOT NULL "
                + "ORDER BY a.nm_aluno", AlunoDisciplina.class);
        return q.getResultList();
    }
     
    public AlunoDisciplina findAlunoDisciplinaByDisciplinaAndIdAluno(Integer idDisciplina, Integer idAluno) {
        EntityManager em = getEntityManager();
        Query q = em.createNativeQuery("SELECT * FROM aluno a JOIN aluno_disciplina ad ON a.id_aluno = ad.id_aluno "
                + "JOIN disciplina d ON d.id_disciplina = ad.id_disciplina "
                + "WHERE ad.id_aluno = " + idAluno + " AND ad.id_disciplina = " + idDisciplina + " "
                + "ORDER BY d.nm_disciplina, a.nm_aluno", AlunoDisciplina.class);

        return (AlunoDisciplina) q.getResultList().get(0);
    }

}
