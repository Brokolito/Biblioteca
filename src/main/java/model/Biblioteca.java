package model;

import model.data.DBConnector;
import model.data.dao.bibliotecaDAO;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.sql.Connection;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public ArrayList<Libro> getLibrosBiblioteca() {
        return librosBiblioteca;
    }

    public void setLibrosBiblioteca(ArrayList<Libro> librosBiblioteca) {
        this.librosBiblioteca = librosBiblioteca;
    }
    public boolean agregarLibro(Libro libro){
        bibliotecaDAO libroDAO= new bibliotecaDAO();
        Connection connection= DBConnector.connection("biblioteca","root","");
        DSLContext query= DSL.using(connection);
        return libroDAO.agregarLibro(query, libro);
    }
    public ArrayList<Libro> buscarLibros(Libro libro, boolean estado){
        Connection connection= DBConnector.connection("biblioteca","root","");
        DSLContext query= DSL.using(connection);
        return new bibliotecaDAO().buscarLibros(query,libro,estado);
    }
}
