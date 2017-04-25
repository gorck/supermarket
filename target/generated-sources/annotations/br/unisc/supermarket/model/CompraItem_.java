package br.unisc.supermarket.model;

import br.unisc.supermarket.model.Compra;
import br.unisc.supermarket.model.Item;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-24T21:55:12")
@StaticMetamodel(CompraItem.class)
public class CompraItem_ { 

    public static volatile SingularAttribute<CompraItem, BigDecimal> qtItensCompra;
    public static volatile SingularAttribute<CompraItem, Item> idItem;
    public static volatile SingularAttribute<CompraItem, Integer> idCompraItem;
    public static volatile SingularAttribute<CompraItem, Compra> idCompra;

}