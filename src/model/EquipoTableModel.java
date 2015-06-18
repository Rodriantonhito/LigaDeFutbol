
package model;

import javax.swing.table.AbstractTableModel;
import data.Equipos;
import data.EquipoContenedor;


public class EquipoTableModel extends AbstractTableModel{

  
    
    @Override
    public int getRowCount() {
        if (EquipoContenedor.getListaEquipo()==null)
            return 0;
        return EquipoContenedor.getListaEquipo().size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Equipos equipo =(Equipos) EquipoContenedor.getListaEquipo().get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return equipo.getNombre();
            case 1:
                return equipo.getEstadio();
            case 2:
                return String.valueOf(equipo.getAforo());
            case 3:
                return equipo.getCiudad();
            default:
                return null;
                  
        }
        
        
    
    }

    @Override
    public String getColumnName(int column) {
        
        switch(column){
            case 0:
                return "Nombre";
            case 1:
                return "Estadio";
            case 2:
                return "Aforo";
            case 3:
                return "Ciudad";
            default:
                return null;
        
        }
    }
    
}
