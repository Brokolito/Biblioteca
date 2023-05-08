package views;

import controller.bibliotecaController;
import model.Libro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class pedirLibroView extends JFrame{
    private JButton cancelarButton;
    private JComboBox comboBox1;
    private JButton prestarLibroButton;
    private JPanel panel;

    public pedirLibroView(){
        setContentPane(panel);
        setVisible(true);
        setSize(900,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Prestar Libro");
        ActionListeners();
        iniciarComboBox();
    }
    public void ActionListeners(){
        prestarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String [] data= Objects.requireNonNull(comboBox1.getSelectedItem()).toString().split("/");
                bibliotecaController bibliotecaController=new bibliotecaController();
                boolean result= bibliotecaController.prestarLibro(
                        new Libro(data[0],data[1],data[2],""),true);
                if(result){
                    JOptionPane.showMessageDialog(
                            null,
                            "Ya esta registrado que se presto el libro"
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
