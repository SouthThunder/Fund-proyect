package com.example.proyect;


import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller_singin implements Initializable {


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
    @FXML
    private Button btnClean;





    @Override
    public void initialize(URL url, ResourceBundle rb){


        maskPassword(txtpasswordSingin,txtpasswordSinginMask,checkViewpasswordSingin);

        //imgola.setVisible(true);
        //imgola.setManaged(true);

        // metodos para restringir el uso de espacios en contraseñas y usuario
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


    public void maskPassword(PasswordField pass,TextField text,CheckBox check){

        text.setVisible(false);
        text.setManaged(false);

        text.managedProperty().bind(check.selectedProperty());
        text.visibleProperty().bind(check.selectedProperty());

        text.textProperty().bindBidirectional(pass.textProperty());


    }

}

