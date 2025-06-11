package com.cod.mvc;

public class View {

    /**
     * Muestra la velocidad
     * @param matricula
     * @param v
     * @return
     */
    public static boolean muestraVelocidad(String matricula, Integer v){
        System.out.println("[View] " + matricula + ": " + v + "km/hr");
        return true;
    }

    /**
     * Muestra una alarma de infracción
     * @param matricula
     * @param v
     *
     */
    public static boolean alarmaInfraccion(String matricula, Integer v) {
        System.out.println("[View] INFRACCION: " + matricula + " a " + v + "km/hr");
        return true;
    }
}
