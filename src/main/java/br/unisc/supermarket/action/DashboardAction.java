package br.unisc.supermarket.action;

import com.opensymphony.xwork2.ActionSupport;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jose
 */
public class DashboardAction extends ActionSupport {

    public String index() {
        return "index";
    }

//    public EntityManagerFactory getEntityManager() {
//        return Persistence.createEntityManagerFactory("supermarket");
//    }

}
