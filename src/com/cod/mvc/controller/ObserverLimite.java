package com.cod.mvc.controller;

import com.cod.mvc.model.Coche;
import com.cod.mvc.model.Model;

/**
 * Otro observador que se suscribe a los cambios de velocidad de un coche
 */
public class ObserverLimite implements Observer {
    // velocidad máxima
    final static int LIMITE = 120;
    private final Model miModel;

    /**
     * Constructor
     * @param miModel el modelo para poder hacer cambios
     */
    public ObserverLimite(Model miModel) {
        this.miModel = miModel;
    }

    /**
     * Este es el observador de limite de velocidad
     * @param coche Coche al que se le actualizó la velocidad
     */
    @Override
    public void update(Coche coche) {
        // verificamos veloidad máxima
        if (coche.velocidad > LIMITE) {
            // avisamos de una infracción
            System.out.println("[ObserverLimite] INFRACCION");
            // bajamos la velocidad 10 km/hr
            miModel.cambiarVelocidad(coche.matricula, coche.velocidad - 10);
        }
    }
}
