
package renderer;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;


public class RendererImagen extends DefaultTableCellRenderer{

      public void imagenRenderer() {
        setHorizontalAlignment(SwingConstants.CENTER);
    }
 
    @Override
    public void setValue(Object aValue) {
 
        if ((aValue != null) && (aValue instanceof String)) {
            String rutaimagen = String.valueOf(aValue);
            setIcon(new ImageIcon(getClass().getResource(rutaimagen)));
        }
    }
}
