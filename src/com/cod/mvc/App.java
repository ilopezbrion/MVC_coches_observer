package com.cod.mvc;

import com.cod.mvc.view.View;

public class App {
    /**
     * Este es el punto inicial de nuestra aplicación
     * Las tareas iniciales estarían en este método
     * @param args no usadas
     */
    public static void main(String[] args) {
        // inicializamos la vista
        View.crearVentana();
        // debug
        System.out.println("[App] fin del main");
    }
}
