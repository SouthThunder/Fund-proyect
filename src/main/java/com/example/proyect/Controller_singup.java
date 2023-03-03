package com.example.proyect;


import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller_singup implements Initializable {


    // atributos para cambiar entre formularios

    @FXML
    private CheckBox checkEmpre;
    @FXML
    private CheckBox checkPerna;


    // atributos para el formulario de empresa

    @FXML
    private AnchorPane anchPaneEmp;
    @FXML
    private TextField txtEmailSingup;
    @FXML
    private TextField txtNumeroSingup;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtConfirmPassword;
    @FXML
    private ComboBox<String> combBoxTipoDoc;
    @FXML
    private Button btnSingUp;
    @FXML
    private Button btnCleanSingUp;


    // atributos para formulario persona natural

    @FXML
    private AnchorPane anchPanePerna;


    @Override
    public void initialize(URL url, ResourceBundle rb){

        anchPanePerna.setVisible(false); // lo vuelve invisible
        anchPanePerna.setManaged(false); // le quita el espacio asignado
        checkEmpre.setSelected(true);

        combBoxTipoDoc.getItems().addAll("C.C","NIT");



        // metodos para restringir el uso de espacios en contraseñas y usuario
        txtPassword.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCharacter().equals(" ")){
                    event.consume();
                }
            }
        });
        txtConfirmPassword.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCharacter().equals(" ")){
                    event.consume();
                }
            }
        });
        txtEmailSingup.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCharacter().equals(" ")){
                    event.consume();
                }
            }
        });
        txtNumeroSingup.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCharacter().equals(" ")){
                    event.consume();
                }
            }
        });



    }

    public void activeFormEm(Event event){

        if(checkEmpre.isSelected() == true){

            // se gestiona la visibilidad del formulario
            checkPerna.setSelected(false);
            anchPaneEmp.setVisible(true);
            anchPaneEmp.setManaged(true);
            anchPanePerna.setVisible(false);
            anchPanePerna.setManaged(false);
        }

    }

    public void activeFormPerna(Event event){

        if(checkPerna.isSelected() == true){

            // se gestiona la visibilidad del formulario
            checkEmpre.setSelected(false);
            anchPaneEmp.setVisible(false);
            anchPaneEmp.setManaged(false);
            anchPanePerna.setVisible(true);
            anchPanePerna.setManaged(true);
        }

    }

    public void onSignUpbtnclick(){
        if((txtPassword.getText()).compareTo(txtConfirmPassword.getText())==0)
            System.out.println("idk");



    }


}
