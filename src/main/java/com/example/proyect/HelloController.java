package com.example.proyect;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private Button button_Vista2;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void abrirVista2(MouseEvent event){

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Vista2.fxml"));

            Parent root = loader.load();

            Controller_Vista2 controller = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL); // para que cunado se abra la nueva ventana no se pueda acceder a la anetrior
            stage.setScene(scene);
            stage.show();


        }catch (IOException e) {
            // Manejo de la excepción
            System.err.println("Error");
        }

    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}