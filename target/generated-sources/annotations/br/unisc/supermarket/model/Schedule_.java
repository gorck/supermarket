package br.unisc.supermarket.model;

import br.unisc.supermarket.model.Disciplina;
import br.unisc.supermarket.model.RegistroPresenca;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-24T21:55:12")
@StaticMetamodel(Schedule.class)
public class Schedule_ { 

    public static volatile SingularAttribute<Schedule, Integer> dtDiaSemana;
    public static volatile SingularAttribute<Schedule, Disciplina> disciplina;
    public static volatile SingularAttribute<Schedule, Integer> idSchedule;
    public static volatile ListAttribute<Schedule, RegistroPresenca> registroPresencaList;
    public static volatile SingularAttribute<Schedule, Date> dtSchedule;

}