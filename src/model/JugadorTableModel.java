package model;

import javax.swing.table.AbstractTableModel;
import data.JugadorContenedor;
import data.Jugadores;
import java.text.DateFormat;

public class JugadorTableModel extends AbstractTableModel {

    @Override
    public int getRowCount() {
        return JugadorContenedor.getListaJugador().size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DateFormat formato = DateFormat.getDateInstance();
        Jugadores jugador = JugadorContenedor.getJugador(rowIndex);
        switch (columnIndex) {
            case 0:
                return jugador.getNombre();
            case 1:
                return jugador.getApellidos();
            case 2:
                return jugador.getNacionalidad();
            case 3:
                return formato.format(jugador.getFechaNac());
            case 4:
                return jugador.getPosicion();
            case 5:
                return jugador.getIdEquipo().getNombre();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {

        switch (column) {
            case 0:
                return "Nombre";
            case 1:
                return "Apellidos";
            case 2:
                return "Nacionalidad";
            case 3:
                return "Fecha";
            case 4:
                return "Posicion";
            case 5:
                return "club";
            default:
                return null;
        }

    }

}
