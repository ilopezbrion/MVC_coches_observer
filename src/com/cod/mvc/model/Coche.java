package com.cod.mvc.model;

public class Coche {
    public String matricula;
    String modelo;
    public int velocidad;

    public Coche(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.velocidad = 0;
    }
}
