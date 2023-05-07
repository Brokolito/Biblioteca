package model;

public class Libro {
    private String titulo;
    private String autor;
    private String fechaPublicacion;
    private String genero;

    public Libro(String titulo, String autor, String fechaPublicacion, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.genero = genero;
    }
}
