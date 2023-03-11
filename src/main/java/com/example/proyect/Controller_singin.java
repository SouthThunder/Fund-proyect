package com.example.proyect;


import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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

    }

}

