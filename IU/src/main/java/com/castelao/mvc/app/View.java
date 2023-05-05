package com.castelao.mvc.app;

import com.castelao.mvc.iu.IU;
import com.castelao.mvc.iu.IUController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class View {
    /**
     * Controlador de la IU lo implementa javafx
     */
    static IUController iuController;

    /**
     * Inicializamos la ventana
     */
    static void crearVentana(){
        // llamada a la app javafx
        IU.main();
        // a partir de aqui no se ejecuta nada
    }
    /**
     * Muestra la velocidad
     * @param matricula del coche
     * @param v velocidad que ueremos mostrar
     * @return true si todo bien
     */
    static boolean mostrarVelocidad(String matricula, Integer v){
        // controlador de la IU javafx
        IUController iuController = IU.getIUController();
        // construimos el mensaje
        String mensaje = "Coche " + matricula + " velocidad: " + v + "km/h";
        // debug por consola
        System.out.println(mensaje);
        // enviamos el mensaje a la IU
        // como javafx trabaja con su propio controlador, lo usamos
        iuController.mostrarMensaje(mensaje);
        return true;
    }
}
