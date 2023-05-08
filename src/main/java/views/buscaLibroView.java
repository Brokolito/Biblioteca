package views;

import controller.bibliotecaController;
import model.Libro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class buscaLibroView extends JFrame{
    private JTextField autorTextField;
    private JButton buscarButton;
    private JButton cancelarButton;
    private JPanel panel;

    public buscaLibroView(){
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,600);
        setContentPane(panel);
        setTitle("Buscar Libro");
        setLocationRelativeTo(null);
        ActionListeners();
    }
    public void ActionListeners(){
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String autor= autorTextField.getText();
                if(!autor.isEmpty() ){
                    bibliotecaController bibliotecaController=new bibliotecaController();

                    bibliotecaController.buscarLibroAutor(new Libro("",autor,"",""),true);
                }else{
                    JOptionPane.showMessageDialog(
                            null,
                            "Ingrese correctamente todos parametros");
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
}
