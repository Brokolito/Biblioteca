package controller;

import model.Biblioteca;
import model.Libro;

public class bibliotecaController {
    public boolean agregarLibro(Libro libro){
        Biblioteca biblioteca=new Biblioteca(
                "Biblioteca Universidad De La Frontera",
                "Av.Uruguay #1314,Temuco",
                "8:30-19:00");
        return true;
    }
}
