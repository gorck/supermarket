package br.unisc.supermarket.model;

import br.unisc.supermarket.model.Aluno;
import br.unisc.supermarket.model.Disciplina;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-24T21:55:12")
@StaticMetamodel(AlunoDisciplina.class)
public class AlunoDisciplina_ { 

    public static volatile SingularAttribute<AlunoDisciplina, Integer> idAlunoDisciplina;
    public static volatile SingularAttribute<AlunoDisciplina, Aluno> idAluno;
    public static volatile SingularAttribute<AlunoDisciplina, Disciplina> idDisciplina;

}