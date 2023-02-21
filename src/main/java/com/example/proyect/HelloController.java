package com.example.proyect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

    private VBox singInForm;
    private VBox singUpForm;




    //metodos
    @FXML
    public void actionEvent(ActionEvent event){

        Object evt = event.getSource();

        if(evt.equals(btnSingin)){    //condicional para saber que elemnto se acciono

            singInForm.setVisible(true);
            singUpForm.setVisible(false);

        } else if (evt.equals(btnSingup)) {
            singInForm.setVisible(false);
            singUpForm.setVisible(true);
        }

    }

    public void onSingUpButtonClicked(MouseEvent event){

        singInForm.setVisible(false);
        singUpForm.setVisible(true);

    }


    // merodo para obtener las escenas VBox
    private VBox loadForm(String url) throws IOException{

        return (VBox) FXMLLoader.load(getClass().getResource(url));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            singInForm = loadForm("Singin.fxml");
            singUpForm = loadForm("Singup.fxml");
            containerForm.getChildren().addAll(singInForm,singUpForm);
            singInForm.setVisible(true);
            singUpForm.setVisible(false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }








    /*
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

     */


}