/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisc.supermarket.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "schedule")
@NamedQueries({
    @NamedQuery(name = "Schedule.findAll", query = "SELECT s FROM Schedule s")})
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_schedule", nullable = false)
    private Integer idSchedule;
    @Column(name = "dt_dia_semana")
    private Integer dtDiaSemana;
    @Column(name = "dt_schedule")
    @Temporal(TemporalType.DATE)
    private Date dtSchedule;
    @OneToMany(mappedBy = "idSchedule")
    private List<RegistroPresenca> registroPresencaList;
    @JoinColumn(name = "id_disciplina", referencedColumnName = "id_disciplina")
    @ManyToOne
    private Disciplina disciplina;

    public Schedule() {
    }

    public Schedule(Integer idSchedule) {
        this.idSchedule = idSchedule;
    }

    public Integer getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(Integer idSchedule) {
        this.idSchedule = idSchedule;
    }

    public Integer getDtDiaSemana() {
        return dtDiaSemana;
    }

    public void setDtDiaSemana(Integer dtDiaSemana) {
        this.dtDiaSemana = dtDiaSemana;
    }

    public Date getDtSchedule() {
        return dtSchedule;
    }

    public void setDtSchedule(Date dtSchedule) {
        this.dtSchedule = dtSchedule;
    }

    public List<RegistroPresenca> getRegistroPresencaList() {
        return registroPresencaList;
    }

    public void setRegistroPresencaList(List<RegistroPresenca> registroPresencaList) {
        this.registroPresencaList = registroPresencaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSchedule != null ? idSchedule.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Schedule)) {
            return false;
        }
        Schedule other = (Schedule) object;
        if ((this.idSchedule == null && other.idSchedule != null) || (this.idSchedule != null && !this.idSchedule.equals(other.idSchedule))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Schedule[ idSchedule=" + idSchedule + " ]";
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
    public String getDiaString() {
        if(dtDiaSemana==1){
            return "Segunda-Feira";
        }
        if(dtDiaSemana==2){
            return "Terça-Feira";
        }
        if(dtDiaSemana==3){
            return "Quarta-Feira";
        }
        if(dtDiaSemana==4){
            return "Quinta-Feira";
        }
        if(dtDiaSemana==5){
            return "Sexta-Feira";
        }
        return "";
    }

}
