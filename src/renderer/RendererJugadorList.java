
package renderer;


import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import data.Jugadores;

public class RendererJugadorList extends DefaultListCellRenderer{

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        
        Jugadores jugador = (Jugadores)value;
        setText(jugador.getNombre());
        if(isSelected){
            this.setBackground(Color.red);
        }else{
            this.setBackground(Color.white);
        }
        return this;
    }
    
}
