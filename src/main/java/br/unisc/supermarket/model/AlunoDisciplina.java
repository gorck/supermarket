/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisc.supermarket.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "aluno_disciplina")
@NamedQueries({
    @NamedQuery(name = "AlunoDisciplina.findAll", query = "SELECT a FROM AlunoDisciplina a")})
public class AlunoDisciplina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluno_disciplina", nullable = false)
    private Integer idAlunoDisciplina;
    @JoinColumn(name = "id_aluno", referencedColumnName = "id_aluno")
    @ManyToOne
    private Aluno idAluno;
    @JoinColumn(name = "id_disciplina", referencedColumnName = "id_disciplina")
    @ManyToOne
    private Disciplina idDisciplina;

    public AlunoDisciplina() {
    }

    public AlunoDisciplina(Integer idAlunoDisciplina) {
        this.idAlunoDisciplina = idAlunoDisciplina;
    }

    public Integer getIdAlunoDisciplina() {
        return idAlunoDisciplina;
    }

    public void setIdAlunoDisciplina(Integer idAlunoDisciplina) {
        this.idAlunoDisciplina = idAlunoDisciplina;
    }

    public Aluno getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Aluno idAluno) {
        this.idAluno = idAluno;
    }

    public Disciplina getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Disciplina idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlunoDisciplina != null ? idAlunoDisciplina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlunoDisciplina)) {
            return false;
        }
        AlunoDisciplina other = (AlunoDisciplina) object;
        if ((this.idAlunoDisciplina == null && other.idAlunoDisciplina != null) || (this.idAlunoDisciplina != null && !this.idAlunoDisciplina.equals(other.idAlunoDisciplina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.AlunoDisciplina[ idAlunoDisciplina=" + idAlunoDisciplina + " ]";
    }
    
}
