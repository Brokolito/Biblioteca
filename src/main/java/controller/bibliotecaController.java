package controller;

import model.Biblioteca;
import model.Libro;
import views.LibrosEncontradosView;

public class bibliotecaController {
    public boolean agregarLibro(Libro libro){
        Biblioteca biblioteca=new Biblioteca(
                "Biblioteca Universidad De La Frontera",
                "Av.Uruguay #1314,Temuco",
                "8:30-19:00");

        return biblioteca.agregarLibro(libro);
    }
    public boolean buscarLibros(Libro libro,boolean estado){
        Biblioteca biblioteca=new Biblioteca(
                "Biblioteca Universidad De La Frontera",
                "Av.Uruguay #1314,Temuco",
                "8:30-19:00");
        new LibrosEncontradosView(biblioteca.buscarLibros(libro,estado));
        return  true;
    }
}
