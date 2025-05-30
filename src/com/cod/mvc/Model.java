package com.cod.mvc;

import java.util.ArrayList;


/**
 * El Model será el encargado de notificar a los observadores
 */
public class Model {
    // array de coches
    static ArrayList<Coche> parking = new ArrayList<>();

    /**
     * Notifica a los observadores
     * Se ejecutara el método update() de cada observador
     * @param coche
     */
    public static void notifyObservers(Coche coche) {
            ObserverLimite.update(coche);
    }


    /**
     * Crea un coche y lo mete en el parking
     * @param modelo del coche
     * @param matricula identificador unico
     * @return el coche creado
     */
    public static Coche crearCoche(String modelo, String matricula){
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }

    /**
     * Busca coche segun matricula
     * @param matricula a buscar
     * @return chche o null si no existe
     */
    public static Coche getCoche(String matricula){
        Coche aux = null;
        // recorre el array buscando por matricula
        for (Coche e: parking) {
            if (e.matricula.equals(matricula)) {
                aux = e;
            }
        }
        return aux;
    }

    /**
     * Método que cambia la velocidad, por lo tanto
     * tendrá que avisar al observador de limite del controlador que ha cambiado
     *
     * @param matricula identificador del coche
     * @param v         nueva velocidad
     * @return
     */
    public static Integer cambiarVelocidad(String matricula, Integer v) {
        // busca el coche
        getCoche(matricula).velocidad = v;

        // lo notificamos a todos los observadores
        notifyObservers(getCoche(matricula));

        return getCoche(matricula).velocidad;
    }

    /**
     * Devuelve la velocidad según la matrícula
     * @param matricula identificador del coche
     * @return velocidad del coche actual
     */
    public Integer getVelocidad(String matricula) {
        return getCoche(matricula).velocidad;
    }
}
