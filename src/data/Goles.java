/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "goles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Goles.findAll", query = "SELECT g FROM Goles g"),
    @NamedQuery(name = "Goles.findByIdEquipoCasa", query = "SELECT g FROM Goles g WHERE g.golesPK.idEquipoCasa = :idEquipoCasa"),
    @NamedQuery(name = "Goles.findByIdEquipoFuera", query = "SELECT g FROM Goles g WHERE g.golesPK.idEquipoFuera = :idEquipoFuera"),
    @NamedQuery(name = "Goles.findByMinuto", query = "SELECT g FROM Goles g WHERE g.golesPK.minuto = :minuto")})
public class Goles implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GolesPK golesPK;
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "id_equipo_casa", referencedColumnName = "id_equipo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Equipos equipos;
    @JoinColumn(name = "id_equipo_fuera", referencedColumnName = "id_equipo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Equipos equipos1;
    @JoinColumn(name = "id_jugador", referencedColumnName = "id_jugador")
    @ManyToOne
    private Jugadores idJugador;

    public Goles() {
    }

    public Goles(GolesPK golesPK) {
        this.golesPK = golesPK;
    }

    public Goles(int idEquipoCasa, int idEquipoFuera, Date minuto) {
        this.golesPK = new GolesPK(idEquipoCasa, idEquipoFuera, minuto);
    }

    public GolesPK getGolesPK() {
        return golesPK;
    }

    public void setGolesPK(GolesPK golesPK) {
        this.golesPK = golesPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Equipos getEquipos() {
        return equipos;
    }

    public void setEquipos(Equipos equipos) {
        this.equipos = equipos;
    }

    public Equipos getEquipos1() {
        return equipos1;
    }

    public void setEquipos1(Equipos equipos1) {
        this.equipos1 = equipos1;
    }

    public Jugadores getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Jugadores idJugador) {
        this.idJugador = idJugador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (golesPK != null ? golesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Goles)) {
            return false;
        }
        Goles other = (Goles) object;
        if ((this.golesPK == null && other.golesPK != null) || (this.golesPK != null && !this.golesPK.equals(other.golesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Goles[ golesPK=" + golesPK + " ]";
    }
    
}
