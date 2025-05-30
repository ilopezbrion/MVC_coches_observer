package com.cod.mvc;

/**
 * Clase principal
 */
public class App {

    public static void main(String[] args) {

        // Crear tres coches
        Controller.crearCoche("LaFerrari", "SBC 1234");
        Controller.crearCoche("Alpine", "HYU 4567");
        Controller.crearCoche("Aston Martin", "FGH 3333");

        // Cambiar la velocidad de un coche
        Controller.cambiarVelocidad("SBC 1234", 30);

        // otro cambio de velocidad
        // sobrepasando la velocidad máxima
        Controller.cambiarVelocidad("HYU 4567", 150);

    }
}
