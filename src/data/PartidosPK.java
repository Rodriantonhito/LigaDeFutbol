/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Antonio
 */
@Embeddable
public class PartidosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_equipo_casa")
    private int idEquipoCasa;
    @Basic(optional = false)
    @Column(name = "id_equipo_fuera")
    private int idEquipoFuera;

    public PartidosPK() {
    }

    public PartidosPK(int idEquipoCasa, int idEquipoFuera) {
        this.idEquipoCasa = idEquipoCasa;
        this.idEquipoFuera = idEquipoFuera;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEquipoCasa;
        hash += (int) idEquipoFuera;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PartidosPK)) {
            return false;
        }
        PartidosPK other = (PartidosPK) object;
        if (this.idEquipoCasa != other.idEquipoCasa) {
            return false;
        }
        if (this.idEquipoFuera != other.idEquipoFuera) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.PartidosPK[ idEquipoCasa=" + idEquipoCasa + ", idEquipoFuera=" + idEquipoFuera + " ]";
    }
    
}
