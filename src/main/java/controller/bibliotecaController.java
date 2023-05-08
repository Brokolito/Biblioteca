package controller;

import model.Biblioteca;
import model.Libro;
import views.LibrosEncontradosView;

import java.util.ArrayList;

public class bibliotecaController {
    public boolean agregarLibro(Libro libro){
        Biblioteca biblioteca=new Biblioteca(
                "Biblioteca Universidad De La Frontera",
                "Av.Uruguay #1314,Temuco",
                "8:30-19:00");

        return biblioteca.agregarLibro(libro);
    }
    public boolean buscarLibroAutor(Libro libro,boolean estado){
        Biblioteca biblioteca=new Biblioteca(
                "Biblioteca Universidad De La Frontera",
                "Av.Uruguay #1314,Temuco",
                "8:30-19:00");
        new LibrosEncontradosView(biblioteca.buscarLibroAutor(libro,estado));
        return  true;
    }
    public boolean eliminarLibro(Libro libro, boolean estado){
        Biblioteca biblioteca=new Biblioteca(
                "Biblioteca Universidad De La Frontera",
                "Av.Uruguay #1314,Temuco",
                "8:30-19:00");
        return biblioteca.eliminarLibro(libro,estado);
    }
    public ArrayList<Libro> obtenerLibros(boolean estado){
        Biblioteca biblioteca=new Biblioteca(
                "Biblioteca Universidad De La Frontera",
                "Av.Uruguay #1314,Temuco",
                "8:30-19:00");
        return biblioteca.obtenerLibros(estado);
    }
}
