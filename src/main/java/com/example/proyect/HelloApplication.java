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

    private double xOffset = 0.0;
    private double yOffset = 0.0;

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
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

        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load());
        //stage.setTitle("PYME WAVE");
        //stage.setScene(scene);

        //stage.initStyle(StageStyle.TRANSPARENT);

    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        launch();
    }
}