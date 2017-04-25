package br.unisc.supermarket.action;

import br.unisc.supermarket.controller.ItemController;
import br.unisc.supermarket.model.Item;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

/**
 *
 * @author jose
 */
@Results({
    @Result(name = "success", type = "redirectAction", params = {"actionName", "item"}),
    @Result(name = "novo", type = "redirectAction", params = {"actionName", "encomenda/%{encomenda.idEncomenda}/edit"}),
    @Result(name = "show", type = "redirectAction", params = {"actionName", "novo"})
})
public class ItemAction extends ActionSupport {

    private List<Item> itemList;
    private Item item;
//    private EntityManagerFactory emf;
    private Integer id;
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("supermarket");
//

    public String index() {
        try {
            itemList = new ItemController(emf).findAll();
        } catch (Exception e) {
            System.err.println("Erro :" + e);
        } finally {
            if (emf.isOpen()) {
                emf.close();
            }
        }
        return "index";
    }

    public String novo() {
        try {
            item = new Item();
            if (id != null) {
                item = new ItemController(emf).findItem(id);
            }
        } catch (Exception e) {
            System.err.println("Erro :" + e);
        } finally {
            if (emf.isOpen()) {
                emf.close();
            }
        }
        return "edicao";
    }

    public String editNew() {
        item = new Item();
        return "editNew";
    }

    public String edit() {
        try {
            item = new Item();
            if (id != null) {
                item = new ItemController(emf).findItem(id);
            }
        } catch (Exception e) {
            System.err.println("Erro :" + e);
        } finally {
            if (emf.isOpen()) {
                emf.close();
            }
        }
        return "edit";
    }

    public String salvar() {
        try {
            ItemController itemController = new ItemController(emf);
            if (item != null) {
                item = itemController.save(item);
            }
        } catch (Exception e) {
            System.err.println("Erro :" + e);
        } finally {
            if (emf.isOpen()) {
                emf.close();
            }
        }
        return SUCCESS;
    }

    public String excluir() {
        try {
            ItemController itemController = new ItemController(emf);
            if (id != null) {
                itemController.destroy(id);
            }
        } catch (Exception e) {
            System.err.println("Erro :" + e);
        } finally {
            if (emf.isOpen()) {
                emf.close();
            }
        }
        return SUCCESS;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
