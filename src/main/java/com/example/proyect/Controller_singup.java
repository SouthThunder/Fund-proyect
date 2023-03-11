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


    }



}
