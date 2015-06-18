/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "equipos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipos.findAll", query = "SELECT e FROM Equipos e"),
    @NamedQuery(name = "Equipos.findByIdEquipo", query = "SELECT e FROM Equipos e WHERE e.idEquipo = :idEquipo"),
    @NamedQuery(name = "Equipos.findByNombre", query = "SELECT e FROM Equipos e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Equipos.findByEstadio", query = "SELECT e FROM Equipos e WHERE e.estadio = :estadio"),
    @NamedQuery(name = "Equipos.findByAforo", query = "SELECT e FROM Equipos e WHERE e.aforo = :aforo"),
    @NamedQuery(name = "Equipos.findByAnoFundacion", query = "SELECT e FROM Equipos e WHERE e.anoFundacion = :anoFundacion"),
    @NamedQuery(name = "Equipos.findByCiudad", query = "SELECT e FROM Equipos e WHERE e.ciudad = :ciudad")})
public class Equipos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_equipo")
    private Integer idEquipo;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "estadio")
    private String estadio;
    @Column(name = "aforo")
    private Integer aforo;
    @Column(name = "ano_fundacion")
    private Integer anoFundacion;
    @Column(name = "ciudad")
    private String ciudad;
    @OneToMany(mappedBy = "idEquipo")
    private Collection<Jugadores> jugadoresCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipos")
    private Collection<Goles> golesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipos1")
    private Collection<Goles> golesCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipos")
    private Collection<Partidos> partidosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipos1")
    private Collection<Partidos> partidosCollection1;

    public Equipos() {
    }

    public Equipos(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Equipos(Integer idEquipo, String nombre, String estadio) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.estadio = estadio;
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public Integer getAforo() {
        return aforo;
    }

    public void setAforo(Integer aforo) {
        this.aforo = aforo;
    }

    public Integer getAnoFundacion() {
        return anoFundacion;
    }

    public void setAnoFundacion(Integer anoFundacion) {
        this.anoFundacion = anoFundacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @XmlTransient
    public Collection<Jugadores> getJugadoresCollection() {
        return jugadoresCollection;
    }

    public void setJugadoresCollection(Collection<Jugadores> jugadoresCollection) {
        this.jugadoresCollection = jugadoresCollection;
    }

    @XmlTransient
    public Collection<Goles> getGolesCollection() {
        return golesCollection;
    }

    public void setGolesCollection(Collection<Goles> golesCollection) {
        this.golesCollection = golesCollection;
    }

    @XmlTransient
    public Collection<Goles> getGolesCollection1() {
        return golesCollection1;
    }

    public void setGolesCollection1(Collection<Goles> golesCollection1) {
        this.golesCollection1 = golesCollection1;
    }

    @XmlTransient
    public Collection<Partidos> getPartidosCollection() {
        return partidosCollection;
    }

    public void setPartidosCollection(Collection<Partidos> partidosCollection) {
        this.partidosCollection = partidosCollection;
    }

    @XmlTransient
    public Collection<Partidos> getPartidosCollection1() {
        return partidosCollection1;
    }

    public void setPartidosCollection1(Collection<Partidos> partidosCollection1) {
        this.partidosCollection1 = partidosCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipo != null ? idEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipos)) {
            return false;
        }
        Equipos other = (Equipos) object;
        if ((this.idEquipo == null && other.idEquipo != null) || (this.idEquipo != null && !this.idEquipo.equals(other.idEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Equipos[ idEquipo=" + idEquipo + " ]";
    }
    
}
