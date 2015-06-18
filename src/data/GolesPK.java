/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Antonio
 */
@Embeddable
public class GolesPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_equipo_casa")
    private int idEquipoCasa;
    @Basic(optional = false)
    @Column(name = "id_equipo_fuera")
    private int idEquipoFuera;
    @Basic(optional = false)
    @Column(name = "minuto")
    @Temporal(TemporalType.TIME)
    private Date minuto;

    public GolesPK() {
    }

    public GolesPK(int idEquipoCasa, int idEquipoFuera, Date minuto) {
        this.idEquipoCasa = idEquipoCasa;
        this.idEquipoFuera = idEquipoFuera;
        this.minuto = minuto;
    }

    public int getIdEquipoCasa() {
        return idEquipoCasa;
    }

    public void setIdEquipoCasa(int idEquipoCasa) {
        this.idEquipoCasa = idEquipoCasa;
    }

    public int getIdEquipoFuera() {
        return idEquipoFuera;
    }

    public void setIdEquipoFuera(int idEquipoFuera) {
        this.idEquipoFuera = idEquipoFuera;
    }

    public Date getMinuto() {
        return minuto;
    }

    public void setMinuto(Date minuto) {
        this.minuto = minuto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEquipoCasa;
        hash += (int) idEquipoFuera;
        hash += (minuto != null ? minuto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GolesPK)) {
            return false;
        }
        GolesPK other = (GolesPK) object;
        if (this.idEquipoCasa != other.idEquipoCasa) {
            return false;
        }
        if (this.idEquipoFuera != other.idEquipoFuera) {
            return false;
        }
        if ((this.minuto == null && other.minuto != null) || (this.minuto != null && !this.minuto.equals(other.minuto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.GolesPK[ idEquipoCasa=" + idEquipoCasa + ", idEquipoFuera=" + idEquipoFuera + ", minuto=" + minuto + " ]";
    }
    
}
