/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisc.supermarket.controller;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import br.unisc.supermarket.model.Disciplina;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author jose
 */
public class DisciplinaController implements Serializable {

    public DisciplinaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void save(Disciplina disciplina) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            if (disciplina.getIdDisciplina() != null) {
                em.merge(disciplina);
            } else {
                em.persist(disciplina);
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
//            Disciplina disciplina;
//            try {
//                disciplina = em.getReference(Disciplina.class, id);
//                disciplina.getIdDisciplina();
//            } catch (EntityNotFoundException enfe) {
//                throw new NonexistentEntityException("The disciplina with id " + id + " no longer exists.", enfe);
//            }
//            em.remove(disciplina);
//            em.getTransaction().commit();
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//    }

    public Disciplina findDisciplina(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Disciplina.class, id);
        } finally {
            em.close();
        }
    }

    public Disciplina findById(Integer id) {
        EntityManager em = getEntityManager();
        Query q = em.createNativeQuery("SELECT * FROM disciplina WHERE id_disciplina = " + id, Disciplina.class);
        return (Disciplina) q.getSingleResult();
    }

    public List<Disciplina> findAll() {

        EntityManager em = getEntityManager();
        Query q = em.createNativeQuery("SELECT * FROM disciplina "
                + "ORDER BY nm_disciplina ", Disciplina.class);
        return q.getResultList();
    }
    
}
