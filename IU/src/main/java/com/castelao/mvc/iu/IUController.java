package com.castelao.mvc.iu;

import com.castelao.mvc.app.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class IUController {

    @FXML
    private Label msgText;
    @FXML
    private TextField modeloText;
    @FXML
    private TextField matriculaText;

    public void mostrarMensaje(String mensaje) {
        msgText.setText(mensaje);
    }

    @FXML
    protected void onCrearCocheClick(ActionEvent actionEvent) {
        msgText.setText("Creando coche");
        Controller.crearCoche(modeloText.getText(),matriculaText.getText());
    }
}
