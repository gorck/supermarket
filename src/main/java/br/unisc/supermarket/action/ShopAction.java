package br.unisc.supermarket.action;

import br.unisc.supermarket.controller.CompraController;
import br.unisc.supermarket.model.Compra;
import br.unisc.supermarket.model.Item;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jose
 */
public class ShopAction extends ActionSupport {

    private List<Compra> compraList;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("supermarket");

    public String index() {
        return "index";
    }

    public List<Compra> getCompraList() {
        return compraList;
    }

    public void setCompraList(List<Compra> compraList) {
        this.compraList = compraList;
    }

}
