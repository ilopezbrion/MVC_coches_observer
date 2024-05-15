package com.cod.mvc.view;

import com.cod.mvc.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Entorno gráfico - Interfaz de Usuario
 */
public class IU {
    private JButton crearCoche;
    public JPanel panel;
    private JTextField modelo;
    private JTextField matricula;

    /**
     * Constructor del entorno gráfico
     * tendrá los listener de la interfaz gráfica
     */
    public IU() {
        // añadimos listener al boton
        crearCoche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // debug
                System.out.println("[IU Listener] creando coche");
                // le decimos al controlador que cree un coche
                Controller.crearCoche(modelo.getText(), matricula.getText());
            }
        });
    }

    /**
     * Inicializa la Interfaz del Usuario
     * Lo llamaremos en el constructor de la vista
     */
    public static void crearVentana(JPanel botonera) {
        JFrame jframe = new JFrame("App MVC");
        JPanel mainPanel = new JPanel(new BorderLayout());
        IU iu = new IU();


        // agragamos los paneles al panel principal
        mainPanel.add(iu.panel, BorderLayout.NORTH);
        mainPanel.add(botonera, BorderLayout.SOUTH);

        // Configuramos el JFrame
        jframe.setContentPane(mainPanel);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLocation(500, 500);
        jframe.pack();
        jframe.setVisible(true);
        }
}
