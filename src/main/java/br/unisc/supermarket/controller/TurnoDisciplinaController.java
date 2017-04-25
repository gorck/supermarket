/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisc.supermarket.controller;

import br.unisc.supermarket.model.TurnoDisciplina;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author jose
 */
public class TurnoDisciplinaController implements Serializable {

    public TurnoDisciplinaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

//    public void save(TurnoDisciplina turnoDisciplina) throws PreexistingEntityException, Exception {
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            if (turnoDisciplina.getIdTurnoDisciplina()!= null) {
//                em.merge(turnoDisciplina);
//            } else {
//                em.persist(turnoDisciplina);
//            }
//            em.getTransaction().commit();
//        } catch (Exception ex) {
//            if (findTurnoDisciplina(turnoDisciplina.getIdTurnoDisciplina()) != null) {
//                throw new PreexistingEntityException("TurnoDisciplina " + turnoDisciplina + " already exists.", ex);
//            }
//            throw ex;
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//    }
//
//    public void destroy(Integer id) throws NonexistentEntityException {
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            TurnoDisciplina turnoDisciplina;
//            try {
//                turnoDisciplina = em.getReference(TurnoDisciplina.class, id);
//                turnoDisciplina.getIdTurnoDisciplina();
//            } catch (EntityNotFoundException enfe) {
//                throw new NonexistentEntityException("The turnoDisciplina with id " + id + " no longer exists.", enfe);
//            }
//            em.remove(turnoDisciplina);
//            em.getTransaction().commit();
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//    }

    public TurnoDisciplina findTurnoDisciplina(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TurnoDisciplina.class, id);
        } finally {
            em.close();
        }
    }

    public List<TurnoDisciplina> findAll() {
        EntityManager em = getEntityManager();
        Query q = em.createNativeQuery("SELECT * FROM turno_disciplina", TurnoDisciplina.class);
        return q.getResultList();
    }

}
