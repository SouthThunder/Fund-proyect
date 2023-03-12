package com.example.proyect;

import com.example.proyect.util.MySql;
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

   //definicon de atributos, los cuales no estan dentro del fxml
    private VBox singInForm;
    private VBox singUpForm;
    private MySql mySql= new MySql();


    public HelloController(){ // coneccion a la base de datos
        this.mySql.conectar();
    }


        /*
        |
        |
        |
        |
       \*/


    //cambio de estado (singIN, singUp)
    @FXML
    public void actionEvent(ActionEvent event){ // cambia al estado sinIn

        Object evt = event.getSource();

        if(evt.equals(btnSingin)){    //condicional para saber que elemnto se acciono

            singInForm.setVisible(true);
            singUpForm.setVisible(false);

        } else if (evt.equals(btnSingup)) {
            singInForm.setVisible(false);
            singUpForm.setVisible(true);
        }

    }

    public void onSingUpButtonClicked(MouseEvent event){ // cambio de estado a singup

        singInForm.setVisible(false);
        singUpForm.setVisible(true);

    }


    // metodo para obtener las escenas VBox
    private VBox loadForm(String url) throws IOException{

        return (VBox) FXMLLoader.load(getClass().getResource(url));
    }


        /*
        |
        |
        |
        |
       \*/


    // Metodo inicializador
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        String hola = "";

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
        |
        |
        |
        |
       \*/


    // salida de programa
    public void onExitButtonClicked(){ // evento que al darle click se salga del promgrama
        // este metodo esta implementado  a la imagen de salida, para que cuando se le de click se salga del programa
        mySql.desconectar();   //esta funcion genera error por lo que no se puede conectar a la base de datos
        Platform.exit();
        System.exit(0);
    }


}