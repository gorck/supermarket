package br.unisc.supermarket.model;

import br.unisc.supermarket.model.CompraItem;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-24T21:55:12")
@StaticMetamodel(Compra.class)
public class Compra_ { 

    public static volatile SingularAttribute<Compra, Float> total;
    public static volatile SingularAttribute<Compra, Date> data;
    public static volatile ListAttribute<Compra, CompraItem> compraItemList;
    public static volatile SingularAttribute<Compra, Integer> idCompra;

}