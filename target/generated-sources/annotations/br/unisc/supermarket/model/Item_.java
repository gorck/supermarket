package br.unisc.supermarket.model;

import br.unisc.supermarket.model.CompraItem;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-01T15:35:12")
@StaticMetamodel(Item.class)
public class Item_ { 

    public static volatile SingularAttribute<Item, String> tagRfid;
    public static volatile SingularAttribute<Item, BigDecimal> valor;
    public static volatile SingularAttribute<Item, Integer> idItem;
    public static volatile ListAttribute<Item, CompraItem> compraItemList;
    public static volatile SingularAttribute<Item, String> descricao;
    public static volatile SingularAttribute<Item, BigDecimal> qtEstoque;

}