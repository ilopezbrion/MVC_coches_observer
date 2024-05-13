package com.cod.mvc.controller;

import com.cod.mvc.model.Model;

public class Controller{

    // definimos la instancia del modelo
    private final Model miModel;

    /**
     * Constructor. Inicializamos el controller
     * Creamos los observadores que necesitamos
     * @param miModel
     */
    public Controller(Model miModel){
        this.miModel = miModel;

        // instanciamos al observador de la velocidad
        ObserverVelocidad observoVelocidad = new ObserverVelocidad();
        miModel.addObserver(observoVelocidad);

        // instanciamos un segundo observador para el limite de velocidad
        ObserverLimite observoLimite = new ObserverLimite();
        miModel.addObserver(observoLimite);
    }

    public void crearCoche(String nombre, String matricula){
        miModel.crearCoche(nombre, matricula);
    }

    public void cambiarVelocidad(String matricula, int velocidad){
        miModel.cambiarVelocidad(matricula, velocidad);
    }





}