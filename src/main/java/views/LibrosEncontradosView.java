package views;

import model.Libro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class LibrosEncontradosView  extends JFrame{
    private JTable table1;
    private JPanel panel;
    private ArrayList<Libro> librosEncontrados;
    public LibrosEncontradosView(ArrayList<Libro> librosEncontrados){
        this.librosEncontrados=librosEncontrados;
        setSize(900,600);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(panel);
        setTitle("Libros encontrados");
        crearTabla();
    }
    public void crearTabla(){
        Object[][] datos = new Object[librosEncontrados.size()][4];
        for (int i = 0; i <librosEncontrados.size(); i++) {
            Libro libro=librosEncontrados.get(i);
            datos[i][0]=libro.getAutor();
            datos[i][1]=libro.getTitulo();
            datos[i][2]=libro.getFechaPublicacion();
            datos[i][3]=libro.getGenero();
        }
        table1.setModel(new DefaultTableModel(
                datos,
                new String[]{"Autor","Titulo","Fecha de publicacion","Genero"}
        ));
    }
}
