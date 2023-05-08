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
    public ArrayList<Libro> buscarLibroAutor(Libro libro, boolean estado){
        Connection connection= DBConnector.connection("biblioteca","root","");
        DSLContext query= DSL.using(connection);
        return new bibliotecaDAO().buscarLibroAutor(query,libro,estado);
    }

    public boolean eliminarLibro(Libro libro, boolean estado) {
        Connection connection= DBConnector.connection("biblioteca","root","");
        DSLContext query= DSL.using(connection);
        return new bibliotecaDAO().eliminarLibro(query,libro,estado);
    }
    public ArrayList<Libro> obtenerLibros(boolean estado) {
        Connection connection = DBConnector.connection("biblioteca", "root", "");
        DSLContext query = DSL.using(connection);
        return new bibliotecaDAO().obtenerLibros(query, estado);
    }

    public boolean prestarLibro(Libro libro,boolean estado) {
        Connection connection = DBConnector.connection("biblioteca", "root", "");
        DSLContext query = DSL.using(connection);
        return new bibliotecaDAO().prestarLibro(libro,query, estado);
    }

    public boolean devolverLibro(Libro libro, boolean estado) {
        Connection connection = DBConnector.connection("biblioteca", "root", "");
        DSLContext query = DSL.using(connection);
        return new bibliotecaDAO().devolverLibro(libro,query, estado);
    }
}

