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
import javax.persistence.Id;
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
@Table(name = "turno_disciplina")
@NamedQueries({
    @NamedQuery(name = "TurnoDisciplina.findAll", query = "SELECT t FROM TurnoDisciplina t")})
public class TurnoDisciplina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "hr_inicio")
    @Temporal(TemporalType.TIME)
    private Date hrInicio;
    @Column(name = "hr_fim")
    @Temporal(TemporalType.TIME)
    private Date hrFim;
    @Column(name = "ds_turno_disciplina", length = 255)
    private String dsTurnoDisciplina;
    @Id
    @Column(name = "id_turno_disciplina", nullable = false)
    private Integer idTurnoDisciplina;
  

    public TurnoDisciplina() {
    }

    public TurnoDisciplina(Integer idTurnoDisciplina) {
        this.idTurnoDisciplina = idTurnoDisciplina;
    }

    public Date getHrInicio() {
        return hrInicio;
    }

    public void setHrInicio(Date hrInicio) {
        this.hrInicio = hrInicio;
    }

    public Date getHrFim() {
        return hrFim;
    }

    public void setHrFim(Date hrFim) {
        this.hrFim = hrFim;
    }

    public String getDsTurnoDisciplina() {
        return dsTurnoDisciplina;
    }

    public void setDsTurnoDisciplina(String dsTurnoDisciplina) {
        this.dsTurnoDisciplina = dsTurnoDisciplina;
    }

    public Integer getIdTurnoDisciplina() {
        return idTurnoDisciplina;
    }

    public void setIdTurnoDisciplina(Integer idTurnoDisciplina) {
        this.idTurnoDisciplina = idTurnoDisciplina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTurnoDisciplina != null ? idTurnoDisciplina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TurnoDisciplina)) {
            return false;
        }
        TurnoDisciplina other = (TurnoDisciplina) object;
        if ((this.idTurnoDisciplina == null && other.idTurnoDisciplina != null) || (this.idTurnoDisciplina != null && !this.idTurnoDisciplina.equals(other.idTurnoDisciplina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.TurnoDisciplina[ idTurnoDisciplina=" + idTurnoDisciplina + " ]";
    }

}
