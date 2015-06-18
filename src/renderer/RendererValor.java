
package renderer;

import java.text.NumberFormat;
import javax.swing.table.DefaultTableCellRenderer;


public class RendererValor extends DefaultTableCellRenderer{

    @Override
    protected void setValue(Object value) {
        System.out.print(value);
        NumberFormat formato = NumberFormat.getCurrencyInstance();
        
        //Dar el formato a la columna que seleccionemos por parametro.
        setText(formato.format(value));
    }
    
    
}
