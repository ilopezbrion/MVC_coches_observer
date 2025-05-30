package com.cod.mvc;

/**
 * Observador que recibe a los cambios de velocidad de un coche
 * Comprueba si la velocidad del coche supera un límite
 * y avisa a la vista si es así.
 */
public class ObserverLimite {
    // velocidad máxima
    final static int LIMITE = 120;

    /**
     * Este es el observador de limite de velocidad
     * @param coche Coche al que se le actualizó la velocidad
     */
    public static void update(Coche coche) {
        // verificamos veloidad máxima
        if (coche.velocidad > LIMITE) {
            // avisamos de una infracción
            View.alarmaInfraccion(coche.matricula, coche.velocidad);
        }
    }
}
