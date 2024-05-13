package com.cod.mvc.controller;

import com.cod.mvc.model.Coche;

/**
 * Otro observador que se suscribe a los cambios de velocidad de un coche
 */
public class ObserverLimite implements Observer {
    // velocidad máxima
    final static int LIMITE = 120;
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
        }
    }
}
