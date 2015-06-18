
package data;


import java.util.List;


public class JugadorContenedor {


    private static List<Jugadores> listaJugador;
    
    public static List getListaJugador(){
        return listaJugador;
    }
    public static void setDataList(List<Jugadores> L){
        listaJugador= L;
    }
    
    public static Jugadores getJugador(int x){
        return listaJugador.get(x);
    }
}
