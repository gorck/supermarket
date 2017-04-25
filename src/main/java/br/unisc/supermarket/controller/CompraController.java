package br.unisc.supermarket.controller;

import br.unisc.supermarket.model.Compra;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author gorck
 */
public class CompraController implements Serializable {

    public CompraController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Compra save(Compra compra) {
        EntityManager em = getEntityManager();
        try {
            if (compra.getIdCompra() == null) {
                em.persist(compra);
                em.flush();
                return compra;
            } else {
                return em.merge(compra);
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
            Compra compra;
            try {
                compra = em.getReference(Compra.class, id);
                compra.getIdCompra();
                em.remove(compra);
            } catch (Exception ex) {

            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Compra findCompra(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Compra.class, id);
        } finally {
            em.close();
        }
    }

}
