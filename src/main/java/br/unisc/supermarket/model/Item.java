/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisc.supermarket.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gorck
 */
@Entity
@Table(name = "item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i ORDER BY i.idItem"),
    @NamedQuery(name = "Item.findByIdItem", query = "SELECT i FROM Item i WHERE i.idItem = :idItem"),
    @NamedQuery(name = "Item.findByTagRfid", query = "SELECT i FROM Item i WHERE i.tagRfid = :tagRfid"),
    @NamedQuery(name = "Item.findByValor", query = "SELECT i FROM Item i WHERE i.valor = :valor"),
    @NamedQuery(name = "Item.findByQtEstoque", query = "SELECT i FROM Item i WHERE i.qtEstoque = :qtEstoque")})
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "ItemSeq")
    @SequenceGenerator(name = "ItemSeq", sequenceName = "item_seq", allocationSize = 1)
    @Column(name = "id_item")
    private Integer idItem;
    @Basic(optional = false)
    @Column(name = "tag_rfid", nullable = false, length = 255)
    private String tagRfid;
    @Column(name = "descricao", length = 255)
    private String descricao;
//    @Column(name = "nm_item",length = 255)
//    private String nmItem;
    @Column(name = "valor", nullable = false)
    private BigDecimal valor;
    @Column(name = "qt_estoque")
    private BigDecimal qtEstoque;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idItem")
    private List<CompraItem> compraItemList;

    public Item() {
    }

    public Item(Integer idItem) {
        this.idItem = idItem;
    }

    public Item(Integer idItem, String tagRfid, String descricao, BigDecimal valor,
            BigDecimal qtEstoque) {
        this.idItem = idItem;
        this.tagRfid = tagRfid;
        this.descricao = descricao;
        this.valor = valor;
        this.qtEstoque = qtEstoque;
//        this.nmItem = nmItem;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public String getTagRfid() {
        return tagRfid;
    }

    public void setTagRfid(String tagRfid) {
        this.tagRfid = tagRfid;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getQtEstoque() {
        return qtEstoque;
    }

    public void setQtEstoque(BigDecimal qtEstoque) {
        this.qtEstoque = qtEstoque;
    }

    @XmlTransient
    public List<CompraItem> getCompraItemList() {
        return compraItemList;
    }

    public void setCompraItemList(List<CompraItem> compraItemList) {
        this.compraItemList = compraItemList;
    }

//    public String getNmItem() {
//        return nmItem;
//    }
//
//    public void setNmItem(String nmItem) {
//        this.nmItem = nmItem;
//    }
//    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItem != null ? idItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.idItem == null && other.idItem != null) || (this.idItem != null && !this.idItem.equals(other.idItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.unisc.supermarketweb.Model.Item[ idItem=" + idItem + " ]";
    }

}
