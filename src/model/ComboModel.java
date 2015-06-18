
package model;
 
import data.EquipoContenedor;
import data.Equipos;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
/**
 *
 * @author Antonio
 */
public class ComboModel extends AbstractListModel implements ComboBoxModel {
 
    private Equipos e;
 
    public ComboModel() {
        e = null;
    }
   
    @Override
    public int getSize() {
       return EquipoContenedor.getListaEquipo().size();
    }
 
    @Override
    public Object getElementAt(int index) {
        return EquipoContenedor.getListaEquipo().get(index);
    }
 
    @Override
    public void setSelectedItem(Object anItem) {
        e = (Equipos) anItem;
    }
 
    @Override
    public Object getSelectedItem() {
        return e;
    }
}
