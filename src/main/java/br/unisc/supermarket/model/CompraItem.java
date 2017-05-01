package br.unisc.supermarket.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe que representa a entidade do banco do objeto CompraItem
 *
 * @author gorck
 */
@Entity
@Table(name = "compra_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompraItem.findAll", query = "SELECT c FROM CompraItem c"),
    @NamedQuery(name = "CompraItem.findByIdCompraItem", query = "SELECT c FROM CompraItem c WHERE c.idCompraItem = :idCompraItem")})
public class CompraItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_compra_item", nullable = false)
    private Integer idCompraItem;
    @Column(name = "qt_itens_compra", nullable = false)
    private BigDecimal qtItensCompra;
    @JoinColumn(name = "id_item", referencedColumnName = "id_item", nullable = false)
    @ManyToOne(optional = false)
    private Item idItem;
    @JoinColumn(name = "id_compra", referencedColumnName = "id_compra", nullable = false)
    @ManyToOne(optional = false)
    private Compra idCompra;

    public CompraItem() {
    }

    public CompraItem(Integer idCompraItem) {
        this.idCompraItem = idCompraItem;
    }

    public CompraItem(Integer idCompraItem, BigDecimal qtItensCompra) {
        this.idCompraItem = idCompraItem;
        this.qtItensCompra = qtItensCompra;
    }

    public Integer getIdCompraItem() {
        return idCompraItem;
    }

    public void setIdCompraItem(Integer idCompraItem) {
        this.idCompraItem = idCompraItem;
    }

    public BigDecimal getQtItensCompra() {
        return qtItensCompra;
    }

    public void setQtItensCompra(BigDecimal qtItensCompra) {
        this.qtItensCompra = qtItensCompra;
    }

    public Item getIdItem() {
        return idItem;
    }

    public void setIdItem(Item idItem) {
        this.idItem = idItem;
    }

    public Compra getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Compra idCompra) {
        this.idCompra = idCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompraItem != null ? idCompraItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompraItem)) {
            return false;
        }
        CompraItem other = (CompraItem) object;
        if ((this.idCompraItem == null && other.idCompraItem != null) || (this.idCompraItem != null && !this.idCompraItem.equals(other.idCompraItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.unisc.supermarketweb.Model.CompraItem[ idCompraItem=" + idCompraItem + " ]";
    }

}
