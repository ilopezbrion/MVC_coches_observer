package com.castelao.mvc.app;

import com.castelao.mvc.iu.IU;
import com.castelao.mvc.iu.IUController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class View {

    static IUController iuController;
    static void crearVentana(){
        IU.main();
        // a partir de aqui no se ejecuta
    }
    /**
     * Muestra la velocidad
     * @param matricula del coche
     * @param v velocidad que ueremos mostrar
     * @return true si todo bien
     */
    static boolean mostrarVelocidad(String matricula, Integer v){
    IUController iuController = IU.getIUController();
        String mensaje = "Coche " + matricula + " velocidad: " + v + "km/h";
        System.out.println(mensaje);
        // TODO resolver mostrar
        iuController.mostrarMensaje(mensaje);
        return true;
    }
}
