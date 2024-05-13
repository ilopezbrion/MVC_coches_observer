package com.cod.mvc.controller;

import com.cod.mvc.model.Coche;
import com.cod.mvc.model.Model;

public class Controller{
    static Model miModelo;

    public static void main(String[] args) {

        // el patron Observer en java nos exige instanciar la clase observable
        miModelo = new Model();

        // instanciamos al observador
        ObserverVelocidad observoVelocidad = new ObserverVelocidad();
        miModelo.addObserver(observoVelocidad);

        // instanciamos un segundo observador
        ObserverOtro otroObservador = new ObserverOtro();
        miModelo.addObserver(otroObservador);

        // Crear tres coches

        miModelo.crearCoche("LaFerrari", "SBC 1234");
        miModelo.crearCoche("Alpine", "HYU 4567");
        miModelo.crearCoche("Aston Martin", "FGH 3333");

        Coche ferrari = Model.getCoche("SBC 1234");
        // modifica la velocidad
        miModelo.cambiarVelocidad("SBC 1234", 30);

        // otro cambio de velocidad
        miModelo.cambiarVelocidad("HYU 4567", 100);

        // (ya no es necesario, lo hace el observador)
        // recoje la velocidad y la muestra (tarea de la com.cod.mvc.view.View)
        // boolean hecho = com.cod.mvc.view.View.muestraVelocidad("SBC 1234", com.cod.mvc.model.Model.getVelocidad("SBC 1234"));
        // System.out.println(hecho);
    }

}