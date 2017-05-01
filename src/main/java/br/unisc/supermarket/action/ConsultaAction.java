package br.unisc.supermarket.action;

import br.unisc.supermarket.controller.ItemController;
import br.unisc.supermarket.model.Item;
import com.opensymphony.xwork2.ActionSupport;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jose
 */
public class ConsultaAction extends ActionSupport {

    private Item item;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("supermarket");

    public String index() {
        item = new ItemController(emf).findItem(2);
        return "index";
    }

    public EntityManagerFactory getEntityManager() {
        return Persistence.createEntityManagerFactory("supermarket");
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

}
