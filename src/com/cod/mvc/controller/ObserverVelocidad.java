package com.cod.mvc.controller;

import com.cod.mvc.controller.Observer;
import com.cod.mvc.model.Coche;
import com.cod.mvc.view.View;

public class ObserverVelocidad implements Observer {
    /**
     * Este método es llamado siempre que hay un cambio
     * El observable cuando hace el notifyObservers
     * 'dispara' todos los update de los Observers
     *
     * @param arg el argumento pasado por el observable, el coche actualizado
     */
    @Override
    public void update(Coche arg) {
        System.out.println("Se ha cambiado la velocidad: " + String.valueOf(arg.velocidad));
        // le comunicamos a la vista que muestre la velocidad
        View.muestraVelocidad(arg.matricula, arg.velocidad);

        // tambien tenemos acceso al observable en este método,
        // es decir el com.cod.mvc.model.Model
        // por lo tanto tenemos acceso a 'parking'
        /*for (Coche coche : ((com.cod.mvc.model.Model) o).parking) {
            System.out.println(coche.matricula);
        }*/

    }
}
