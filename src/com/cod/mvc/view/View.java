package com.cod.mvc.view;

public class View {
    public static boolean muestraVelocidad(String matricula, Integer v){
        System.out.println("[View] " + matricula + ": " + v + "km/hr");
        return true;
    }
}
