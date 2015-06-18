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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "partidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partidos.findAll", query = "SELECT p FROM Partidos p"),
    @NamedQuery(name = "Partidos.findByIdEquipoCasa", query = "SELECT p FROM Partidos p WHERE p.partidosPK.idEquipoCasa = :idEquipoCasa"),
    @NamedQuery(name = "Partidos.findByIdEquipoFuera", query = "SELECT p FROM Partidos p WHERE p.partidosPK.idEquipoFuera = :idEquipoFuera"),
    @NamedQuery(name = "Partidos.findByFecha", query = "SELECT p FROM Partidos p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "Partidos.findByGolesCasa", query = "SELECT p FROM Partidos p WHERE p.golesCasa = :golesCasa"),
    @NamedQuery(name = "Partidos.findByGolesFuera", query = "SELECT p FROM Partidos p WHERE p.golesFuera = :golesFuera")})
public class Partidos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PartidosPK partidosPK;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "goles_casa")
    private Integer golesCasa;
    @Column(name = "goles_fuera")
    private Integer golesFuera;
    @Lob
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "id_equipo_casa", referencedColumnName = "id_equipo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Equipos equipos;
    @JoinColumn(name = "id_equipo_fuera", referencedColumnName = "id_equipo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Equipos equipos1;

    public Partidos() {
    }

    public Partidos(PartidosPK partidosPK) {
        this.partidosPK = partidosPK;
    }

    public Partidos(int idEquipoCasa, int idEquipoFuera) {
        this.partidosPK = new PartidosPK(idEquipoCasa, idEquipoFuera);
    }

    public PartidosPK getPartidosPK() {
        return partidosPK;
    }

    public void setPartidosPK(PartidosPK partidosPK) {
        this.partidosPK = partidosPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getGolesCasa() {
        return golesCasa;
    }

    public void setGolesCasa(Integer golesCasa) {
        this.golesCasa = golesCasa;
    }

    public Integer getGolesFuera() {
        return golesFuera;
    }

    public void setGolesFuera(Integer golesFuera) {
        this.golesFuera = golesFuera;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (partidosPK != null ? partidosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partidos)) {
            return false;
        }
        Partidos other = (Partidos) object;
        if ((this.partidosPK == null && other.partidosPK != null) || (this.partidosPK != null && !this.partidosPK.equals(other.partidosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Partidos[ partidosPK=" + partidosPK + " ]";
    }
    
}
