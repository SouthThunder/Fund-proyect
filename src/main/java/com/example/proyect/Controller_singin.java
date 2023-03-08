package com.example.proyect;


import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

public class Controller_singin extends Encrypt implements Initializable {


    @FXML
    private TextField txtUsuarioSingin ;
    @FXML
    private PasswordField txtpasswordSingin;
    @FXML
    private TextField txtpasswordSinginMask;
    @FXML
    private CheckBox checkViewpasswordSingin;
    @FXML
    private Button btnSingin;




    @Override
    public void initialize(URL url, ResourceBundle rb){


        maskPassword(txtpasswordSingin,txtpasswordSinginMask,checkViewpasswordSingin);

        restrictionSpaces();



    }

    public void sinIngUser(){
        textFieldEmptySingin();

    }


    public void restrictionSpaces(){ //método para la restricción de espacios
        txtUsuarioSingin.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCharacter().equals(" ")){
                    event.consume();
                }
            }
        });

        txtpasswordSingin.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCharacter().equals(" ")){
                    event.consume();
                }
            }
        });

        txtpasswordSinginMask.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCharacter().equals(" ")){
                    event.consume();
                }
            }
        });
    }

    public void maskPassword(PasswordField pass,TextField text,CheckBox check){ // método para que se pueda visualizar u ocultar la contraseña

        text.setVisible(false);
        text.setManaged(false);

        text.managedProperty().bind(check.selectedProperty());
        text.visibleProperty().bind(check.selectedProperty());

        text.textProperty().bindBidirectional(pass.textProperty());
    }

    public void onSingUpButtonClicked() throws NoSuchAlgorithmException {
        checkPass(txtpasswordSinginMask.getText());
    }

    public void checkPass(String input) throws NoSuchAlgorithmException {
        if(input==(super.hashString(input))){
            System.out.println("Log-in success");
        }

    }

    public void textFieldEmptySingin(){ // metodo para verificar que ningun Textfield quede vacio
        // si este llega a estar vacio sale la advertencia

        if(txtpasswordSinginMask.getText().isEmpty() ||
            txtpasswordSingin.getText().isEmpty() ||
            txtUsuarioSingin.getText().isEmpty()){


            //System.out.println("Mi rey tienes que llenar todos los espacios");

            // Crear una ventana emergente de advertencia
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Espacios vacios");
            //alert.initStyle(StageStyle.TRANSPARENT);
            alert.setHeaderText("Por favor asegúrese de que todos los espacios estén llenos");
            //alert.setContentText("Por favor, tenga cuidado al realizar esta acción.");

            // Mostrar la ventana emergente y esperar a que se cierre
            alert.showAndWait();
        }

    }


}

