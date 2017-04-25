/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisc.supermarket.controller;

import java.io.Serializable;
import br.unisc.supermarket.model.CompraItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author gorck
 */
public class CompraItemController implements Serializable {

    public CompraItemController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public CompraItem save(CompraItem compraItem) {
        EntityManager em = getEntityManager();
        try {
            if (compraItem.getIdCompraItem() == null) {
                em.persist(compraItem);
                em.flush();
                return compraItem;
            } else {
                return em.merge(compraItem);
            }
        } finally {
            em.close();
        }
    }

    public void destroy(Integer id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            try {
                CompraItem compraItem = em.getReference(CompraItem.class, id);
                compraItem.getIdCompraItem();
                em.remove(compraItem);
                em.getTransaction().commit();
            } catch (Exception ex) {

            }
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public CompraItem findCompraItem(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CompraItem.class, id);
        } finally {
            em.close();
        }
    }

}
