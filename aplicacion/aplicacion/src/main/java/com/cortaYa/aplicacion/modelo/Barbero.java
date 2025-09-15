package com.cortaYa.aplicacion.modelo;

public class Barbero {
    private String nombre;
    private int rating;
    private String foto;

    public Barbero(String nombre, int rating, String foto) {
        this.nombre = nombre;
        this.rating = rating;
        this.foto = foto;
    }

   
    public String getNombre() {
        return nombre;
    }

    public int getRating() {
        return rating;
    }

    public String getFoto() {
        return foto;
    }
}
