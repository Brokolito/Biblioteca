package model;

import java.util.ArrayList;

public class Biblioteca {
    private String nombre;
    private String direccion;
    private String horarios;
    private ArrayList<Libro> librosBiblioteca;

    public Biblioteca(String nombre, String direccion, String horarios) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horarios = horarios;
    }
}
