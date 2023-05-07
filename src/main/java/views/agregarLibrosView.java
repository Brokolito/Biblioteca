package views;

import controller.bibliotecaController;
import model.Libro;
import org.jooq.impl.QOM;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class agregarLibrosView extends JFrame{
    private JTextField tituloTextField;
    private JTextField autorTextField;
    private JComboBox generoComboBox;
    private JButton registrarButton;
    private JButton cancelarButton;
    private JPanel panel;
    private JTextField diaTextField;
    private JTextField mesTextField;
    private JTextField yearTextField;

    public agregarLibrosView(){
        setSize(900,600);
        setContentPane(panel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Agregar Libros");
        actionListener();
    }
    public void actionListener(){
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo=tituloTextField.getText();
                String autor=autorTextField.getText();
                String genero= Objects.requireNonNull(generoComboBox.getSelectedItem()).toString();
                int dia=Integer.parseInt(
                        (!diaTextField.getText().matches("[0-9]+]") || diaTextField.getText().length()>2)
                                ?"":diaTextField.getText()
                );
                int mes=Integer.parseInt(
                        (!mesTextField.getText().matches("[0-9]+") ||mesTextField.getText().length()>2)
                        ?"":diaTextField.getText()
                );
                int year= Integer.parseInt(
                        (!yearTextField.getText().matches("[0-9]+") || yearTextField.getText().length()!=4)
                        ?"":yearTextField.getText()
                );
                if(!titulo.isEmpty() && !autor.isEmpty() && !genero.isEmpty() && dia!=0 && year!=0 && mes!=0){
                    String fecha=year+"-"+mes+"-"+dia;
                    bibliotecaController bibliotecaController=new bibliotecaController();
                    boolean result =bibliotecaController.agregarLibro(new Libro(
                            titulo,autor,fecha,genero
                    ));
                    if(result){
                        JOptionPane.showMessageDialog(
                                null,
                                "Se ha ingresado correctamente");
                    }else{
                        JOptionPane.showMessageDialog(
                                null,
                                "El libro ya ha sido ingresado anteriormente"
                        );
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Rellena todos los parametros");
                }
            }
        });
    }
}
