package com.cod.mvc.view;

import com.cod.mvc.controller.Controller;

import javax.swing.*;

public class Botonera {

    public JPanel panel;
    private JTextField text_matricula;
    private JLabel label_matricula;
    private JLabel label_cambiar;
    private JTextField text_cambiar;
    private JButton button_cambiar;

    /**
     * Constructor de la clase Botonera
     * tendrá los listener de la interfaz gráfica
     */
    public Botonera() {
        // el panel se inicializa en el 'form' al asignarlo
        // panel = new JPanel();

        button_cambiar.addActionListener(e -> {
            // debug
            System.out.println("[Botonera Listener] cambiando velocidad");
            // le decimos al controlador que cambie la velocidad segun matricula
            Controller.cambiarVelocidad(text_matricula.getText(), Integer.valueOf(text_cambiar.getText()));
        });
    }

    /**
     * Inicializa Botonera para cambiar velocidad
     *
     * @return JPanel con los elementos de la botonera
     */

    public static JPanel crearBotonera() {
        return new Botonera().panel;
    }


}