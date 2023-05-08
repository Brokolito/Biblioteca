package views;

import controller.bibliotecaController;
import model.Libro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;


public class eliminarLibroView extends JFrame {
    private JButton cancelarButton;
    private JComboBox comboBox1;
    private JButton eliminarButton;
    private JPanel panel;

    public eliminarLibroView(){

        setSize(900,600);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(panel);
        setTitle("Eliminar libro");
        ActionListeners();
        iniciarComboBox();
    }
    public void ActionListeners(){
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String [] data= Objects.requireNonNull(comboBox1.getSelectedItem()).toString().split("/");
                bibliotecaController bibliotecaController=new bibliotecaController();
                boolean result= bibliotecaController.eliminarLibro(
                        new Libro(data[0],data[1],data[2],""),true);
                if(result){
                    JOptionPane.showMessageDialog(
                            null,
                            "Se ha eliminado correctamente"
                    );
                }
            }

        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new paginaPrincipalView();
                dispose();
            }
        });
    }
    public void iniciarComboBox(){
        ArrayList<Libro> librosEncontrados=new bibliotecaController().obtenerLibros(true);
        for(Libro libro:librosEncontrados){
            comboBox1.addItem(
                    libro.getTitulo()+"/"+libro.getAutor()+"/"+libro.getFechaPublicacion());
        }
    }
}
