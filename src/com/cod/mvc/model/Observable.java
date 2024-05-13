package com.cod.mvc.model;

import com.cod.mvc.controller.Observer;
import com.cod.mvc.model.Coche;

/**
 * Interfaz Observable
 */
public interface Observable {
    // añade un observador
    void addObserver(Observer observer);
    // elimina un observador
    void removeObserver(Observer observer);
    // notifica a los observadores
    void notifyObservers(Coche coche);
}

