/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package renderer;
 

import data.Equipos;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
 

public class ComboBox extends DefaultListCellRenderer {
     
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        
// Hacemos un casting a la variable value y la convertimos en un equipo.
        Equipos e = (Equipos) value;
           
        // Si value es distinto de nulo.
        if (value != null) {
            // Mostramos el nombre del equipo
            setText(e.getNombre());
            if(isSelected) {
                setBackground(Color.BLUE);
                setForeground(Color.WHITE);
            } else {
                setBackground(Color.WHITE);
                setForeground(Color.BLACK);
            }
        } else {
            setText("");
        }
        return this;
    }
}