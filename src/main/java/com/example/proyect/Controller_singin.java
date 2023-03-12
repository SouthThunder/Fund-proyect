package com.example.proyect;


import com.example.proyect.model.dao.EmpresaDAO;
import com.example.proyect.model.dao.NaturalDAO;
import com.example.proyect.model.dao.impl.EmpresaDAOImpl;
import com.example.proyect.model.dao.impl.NaturalDAOImpl;
import com.example.proyect.model.dto.EmpresaDTO;
import com.example.proyect.model.dto.NaturalDTO;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

public class Controller_singin extends Encrypt implements Initializable {

    // definicion de atributos
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


        /*
        |
        |
        |
        |
       \*/


    // Metodo inicializador
    @Override
    public void initialize(URL url, ResourceBundle rb){


        maskPassword(txtpasswordSingin,txtpasswordSinginMask,checkViewpasswordSingin);

        restrictionSpaces();



    }


        /*
        |
        |
        |
        |
       \*/


    // Verificacion y restricciones de registro en persona natural
    public void sinIngUser(){
        textFieldEmptySingin();

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


        /*
        |
        |
        |
        |
       \*/


    // Confirmacion de logIn y entrada a home
    public void onSingIpButtonClicked() throws NoSuchAlgorithmException{
        if(sign_in())
            access();
    }

    public void access() throws NoSuchAlgorithmException{ // si el acceso se hizo correctamente abre la otra ventana
            try {
                // Obtiene la escena actual
                Scene scene = btnSingin.getScene();
                // Carga la nueva pantalla en una nueva escena
                Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
                Scene newScene = new Scene(root);
                // Obtiene el stage actual y establece la nueva escena
                Stage primaryStage = (Stage) scene.getWindow();
                primaryStage.setScene(newScene);
                // Cierra la escena anterior
                primaryStage.close();
            }catch (IOException exp){
                System.out.println(exp);
            }
    }


        /*
        |
        |
        |
        |
       \*/


    // Enmascaramiento de contraseña
    public void maskPassword(PasswordField pass,TextField text,CheckBox check){ // método para que se pueda visualizar u ocultar la contraseña

        text.setVisible(false);
        text.setManaged(false);

        text.managedProperty().bind(check.selectedProperty());
        text.visibleProperty().bind(check.selectedProperty());

        text.textProperty().bindBidirectional(pass.textProperty());
    }


        /*
        |
        |
        |
        |
       \*/


    // Resticciones gramaticales
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

    public Boolean sign_in() throws NoSuchAlgorithmException {
        Encrypt hash= new Encrypt();
        NaturalDAO auxn= new NaturalDAOImpl();
        EmpresaDAO auxe= new EmpresaDAOImpl();
        NaturalDTO persona= auxn.findByUser(txtUsuarioSingin.getText());
        EmpresaDTO empresa= auxe.findByUser(txtUsuarioSingin.getText());
        if(persona==null && empresa==null){
            System.out.println("Usuario no encontrado");
        }else if(empresa!=null){
            if(empresa.getPassword().equals(hash.hashString(txtpasswordSingin.getText()))){
                System.out.println("Log-in successfull, welcome " + empresa.getUser());
                return true;
            }
            else{
                System.out.println("Las credenciales no coinciden, porfavor revise los datos");
            }
        }else if(persona!=null){
            if(persona.getPassword().equals(hash.hashString(txtpasswordSingin.getText()))){
                System.out.println("Log-in successfull, welcome " + persona.getUser());
                return true;
            }
            else{
                System.out.println("Las credenciales no coinciden, porfavor revise los datos");
            }
        }
        return false;
    }


}