package com.example.proyect;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;




import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {


    // variables
    @FXML
    private Button btnSingin;
    @FXML
    private Button btnSingup;
    @FXML
    private StackPane containerForm;
    @FXML
    private ImageView img_ola;

    private VBox singInForm;
    private VBox singUpForm;

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {


    }


}