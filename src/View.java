import javax.swing.*;

public class View {

    public View(){
        // creamos la ventana
        IU.crearVentana();
    }

    /**
     * Muestra la velocidad
     * @param matricula del coche
     * @param v velocidad que ueremos mostrar
     * @return true si todo bien
     */
    boolean muestraVelocidad(String matricula, Integer v){
        System.out.println(matricula + ": " + v + "km/hr");
        return true;
    }
}
