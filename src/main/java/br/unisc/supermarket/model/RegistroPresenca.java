/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisc.supermarket.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "registro_presenca")
@NamedQueries({
    @NamedQuery(name = "RegistroPresenca.findAll", query = "SELECT r FROM RegistroPresenca r")})
public class RegistroPresenca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro_presenca", nullable = false)
    private Integer idRegistroPresenca;
    @Column(name = "dt_presenca",nullable = false )
    @Temporal(TemporalType.DATE)
    private Date dtPresenca;
    @JoinColumn(name = "id_aluno", referencedColumnName = "id_aluno", nullable = false)
    private Aluno idAluno;
    @JoinColumn(name = "id_disciplina", referencedColumnName = "id_disciplina", nullable = false)
    private Disciplina disciplina;
    @JoinColumn(name = "id_schedule", referencedColumnName = "id_schedule", nullable = false)
    private Schedule idSchedule;

    public RegistroPresenca() {
    }

    public RegistroPresenca(Integer idRegistroPresenca) {
        this.idRegistroPresenca = idRegistroPresenca;
    }

    public RegistroPresenca(Integer idRegistroPresenca, Date dtPresenca) {
        this.idRegistroPresenca = idRegistroPresenca;
        this.dtPresenca = dtPresenca;
    }

    public Integer getIdRegistroPresenca() {
        return idRegistroPresenca;
    }

    public void setIdRegistroPresenca(Integer idRegistroPresenca) {
        this.idRegistroPresenca = idRegistroPresenca;
    }

    public Date getDtPresenca() {
        return dtPresenca;
    }

    public void setDtPresenca(Date dtPresenca) {
        this.dtPresenca = dtPresenca;
    }

    public Aluno getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Aluno idAluno) {
        this.idAluno = idAluno;
    }

    public Schedule getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(Schedule idSchedule) {
        this.idSchedule = idSchedule;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegistroPresenca != null ? idRegistroPresenca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroPresenca)) {
            return false;
        }
        RegistroPresenca other = (RegistroPresenca) object;
        return !((this.idRegistroPresenca == null && other.idRegistroPresenca != null) || (this.idRegistroPresenca != null && !this.idRegistroPresenca.equals(other.idRegistroPresenca)));
    }

    @Override
    public String toString() {
        return "Model.RegistroPresenca[ idRegistroPresenca=" + idRegistroPresenca + " ]";
    }
    
}
