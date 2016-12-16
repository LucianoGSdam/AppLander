/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garsan_modelos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luciano
 */
@Entity
@Table(name = "partida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partida.findAll", query = "SELECT p FROM Partida p")
    , @NamedQuery(name = "Partida.findByIdPartida", query = "SELECT p FROM Partida p WHERE p.idPartida = :idPartida")
    , @NamedQuery(name = "Partida.findByDateBegin", query = "SELECT p FROM Partida p WHERE p.dateBegin = :dateBegin")
    , @NamedQuery(name = "Partida.findByDateFinish", query = "SELECT p FROM Partida p WHERE p.dateFinish = :dateFinish")
    , @NamedQuery(name = "Partida.findByScore", query = "SELECT p FROM Partida p WHERE p.score = :score")
    , @NamedQuery(name = "Partida.findByIdUsuarioFk", query = "SELECT p FROM Partida p WHERE p.idUsuarioFk = :idUsuarioFk")})
public class Partida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_partida")
    private Integer idPartida;
    @Column(name = "date_begin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateBegin;
    @Basic(optional = false)
    @Column(name = "date_finish")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFinish;
    @Column(name = "score")
    private Integer score;
    @Column(name = "id_usuario_fk")
    private String idUsuarioFk;

    public Partida() {
    }

    public Partida(Integer idPartida) {
        this.idPartida = idPartida;
    }

    public Partida(Integer idPartida, Date dateFinish) {
        this.idPartida = idPartida;
        this.dateFinish = dateFinish;
    }

    public Integer getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(Integer idPartida) {
        this.idPartida = idPartida;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getIdUsuarioFk() {
        return idUsuarioFk;
    }

    public void setIdUsuarioFk(String idUsuarioFk) {
        this.idUsuarioFk = idUsuarioFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPartida != null ? idPartida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partida)) {
            return false;
        }
        Partida other = (Partida) object;
        if ((this.idPartida == null && other.idPartida != null) || (this.idPartida != null && !this.idPartida.equals(other.idPartida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "garsan_modelos.Partida[ idPartida=" + idPartida + " ]";
    }
    
}
