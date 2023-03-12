package com.example.proyect;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
public class HelloApplication extends Application {


    // variables para el control de la posicion
    private double xOffset = 0.0;
    private double yOffset = 0.0;


        /*
        |
        |
        |
        |
       \*/


    // Metodo start
    @Override
    public void start(Stage stage) throws Exception { // esta funcion llama al satage principal e inicia el programa

        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));

        root.setOnMousePressed(new EventHandler<MouseEvent>() { // esto es para que la pantalla se reposiciones cuando se esta moviento con el mause
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() { // esta es para que cuando suelte la pantalla se reposicione
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });

        stage.initStyle(StageStyle.TRANSPARENT); // para que la barra superior sea transparente
        stage.setTitle("PYME WAVE");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("images/icons8-wave-96.png")));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT); // para que la escena de fondo sea transparente
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        launch();
    }
}