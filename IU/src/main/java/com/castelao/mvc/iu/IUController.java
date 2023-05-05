package com.castelao.mvc.iu;

import com.castelao.mvc.app.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Controlador de la IU
 */
public class IUController {
    // diferentes elementos del layout
    @FXML
    private Label msgText;
    @FXML
    private TextField modeloText;
    @FXML
    private TextField matriculaText;

    /**
     * Actualiza la label
     * @param mensaje a mostrar
     */
    public void mostrarMensaje(String mensaje) {
        msgText.setText(mensaje);
    }

    /**
     * Listener del botón
     * @param actionEvent
     */
    @FXML
    protected void onCrearCocheClick(ActionEvent actionEvent) {
        msgText.setText("Creando coche");
        // comunica al Controller que el usuario quiere crear un coche
        Controller.crearCoche(modeloText.getText(),matriculaText.getText());
    }
}
