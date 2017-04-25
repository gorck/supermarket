package br.unisc.supermarket.model;

import br.unisc.supermarket.model.Aluno;
import br.unisc.supermarket.model.Disciplina;
import br.unisc.supermarket.model.Schedule;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-24T21:55:12")
@StaticMetamodel(RegistroPresenca.class)
public class RegistroPresenca_ { 

    public static volatile SingularAttribute<RegistroPresenca, Disciplina> disciplina;
    public static volatile SingularAttribute<RegistroPresenca, Integer> idRegistroPresenca;
    public static volatile SingularAttribute<RegistroPresenca, Date> dtPresenca;
    public static volatile SingularAttribute<RegistroPresenca, Schedule> idSchedule;
    public static volatile SingularAttribute<RegistroPresenca, Aluno> idAluno;

}