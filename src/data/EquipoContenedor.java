package data;

import java.util.List;



/**
 *
 * @author Antonio
 */
public class EquipoContenedor {

    private static List<Equipos> listaEquipo;

    public static List getListaEquipo() {
        return listaEquipo;
    }
    public static void setDataList(List<Equipos> E){
        listaEquipo= E;
    }

}
