package com.castelao.mvc.iu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Aplicación básica javafx
 */
public class IU extends Application{
    /**
     * Controlador de la IU
     * Lo necesitará nuestra View para comunicarse con la IU
     */
    private static IUController iuController;


    /**
     * Método que inicializa el entorno gráfico
     */
    @Override
    public void start(Stage stage) throws IOException {
        // cargamos el layout
        FXMLLoader fxmlLoader = new FXMLLoader(IU.class.getResource("IU.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        // obtenemos el controlador
        iuController = fxmlLoader.getController();
        stage.setTitle("App Coches");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * punto de entrada principal de una app javafx
     */
    public static void main() {
        launch();
        // este hilo no se cierra
        // no se ejecuta nada a partir de aqui
    }

    /**
     * Devuelve el controlador
     * Cada vez que lo necesitemos en View.java
     * lo podemos obtener con este método
     * @return controldor de la IU
     */
    public static IUController getIUController(){
        return iuController;
    }
}