package com.cod.mvc;

public class Controller{

    /**
     * Crea un coche
     * @param nombre del coche
     * @param matricula del coche
     */
    public static void crearCoche(String nombre, String matricula){
        Model.crearCoche(nombre, matricula);
    }

    /**
     * Cambia la velocidad de un coche
     * LLama a la View para mostrarla
     * @param matricula del coche
     * @param velocidad nueva
     */
    public static void cambiarVelocidad(String matricula, Integer velocidad){
        Integer nuevaVelocidad = Model.cambiarVelocidad(matricula, velocidad);
        View.muestraVelocidad(matricula, nuevaVelocidad);
    }





}