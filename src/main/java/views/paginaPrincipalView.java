package views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class paginaPrincipalView extends JFrame{
    private JButton registrarLibroButton;
    private JButton eliminarLibroButton;
    private JButton buscarLibroButton;
    private JButton prestarLibroButton;
    private JButton devolverLibroButton;
    private JPanel panel;

    public paginaPrincipalView(){
        setSize(900,600);
        setContentPane(panel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Pagina principal");
        actionListener();
    }
    public void  actionListener(){
        registrarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new agregarLibrosView();
                dispose();
            }
        });
        buscarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new buscaLibroView();
                dispose();
            }
        });
        eliminarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new eliminarLibroView();
                dispose();
            }
        });
    }
}
