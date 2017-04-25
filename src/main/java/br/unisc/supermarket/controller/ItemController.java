/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisc.supermarket.controller;

import java.io.Serializable;
import br.unisc.supermarket.model.Item;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author gorck
 */
public class ItemController implements Serializable {

    public ItemController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManager em;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Item save(Item item) {
        em = getEntityManager();
        try {

            em.getTransaction().begin();
            if (item.getIdItem() != null) {
                em.merge(item);
            } else {
                em.persist(item);
            }
            em.getTransaction().commit();
            return item;
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) {
        try {
            em = getEntityManager();
            try {
                em.getTransaction().begin();
                Item item = em.find(Item.class, id);
                em.remove(item);
                em.getTransaction().commit();
            } catch (Exception e) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Item findItem(Integer id) {
        em = getEntityManager();
        try {
            return em.find(Item.class, id);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Integer getNextId() {
        return (Integer) (emf.createEntityManager().createNativeQuery("SELECT MAX(id_item) FROM item").getSingleResult());
    }

    public List<Item> findAll() {
        return (emf.createEntityManager().createNamedQuery("Item.findAll").getResultList());
    }
}
