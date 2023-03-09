package com.example.proyect;


import com.example.proyect.model.dao.NaturalDAO;
import com.example.proyect.model.dao.impl.NaturalDAOImpl;
import com.example.proyect.model.dto.NaturalDTO;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.StageStyle;

import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller_singup implements Initializable {

    // atributos para cambiar entre formularios

    @FXML
    private Button checkEmpre;
    @FXML
    private Button checkPerna;


    // atributos para el formulario de empresa

    @FXML
    private AnchorPane anchPaneEmp;  // contenedor del formulario empresas
    @FXML
    private TextField txtEmailSingup;
    @FXML
    private TextField txtNumeroSingup;
    @FXML
    private TextField txtNumeroID;
    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtConfirmPassword;

    @FXML
    private Button btnSingUp;
    @FXML
    private Button btnCleanSingUp;


    // atributos para formulario persona natural

    @FXML
    private AnchorPane anchPanePerna;
    @FXML
    private TextField txtEmailSingupPerNa;
    @FXML
    private TextField txtNumeroSingupPerna;
    @FXML
    private TextField txtUserNamePerna;
    @FXML
    private TextField txtPasswordPerna;
    @FXML
    private TextField txtConfirmPasswordPerna;
    @FXML
    private Button btnSingUpPerna;
    @FXML
    private Button btnCleanSingUpPerna;



    @Override
    public void initialize(URL url, ResourceBundle rb){

        anchPanePerna.setVisible(false); // lo vuelve invisible
        anchPanePerna.setManaged(false); // le quita el espacio asignado
        //checkEmpre.setSelected(true);


        restrictionSpacesFormEmp(); //llamada de método para restringir espacios

        restrictionSpacesForPerna(); //llamada de método para restringir espacios


    }



    public void registerEmp(){

        textFieldEmptyEmp();

    }

    public void registerPerna(){

        textFieldEmptyPerna();

    }



    public void textFieldEmptyEmp(){ // metodo para verificar que ningun Textfield quede vacio
                                     // si este llega a estar vacio sale la advertencia

        if(txtEmailSingup.getText().isEmpty() ||
            txtPassword.getText().isEmpty() ||
            txtUserName.getText().isEmpty() ||
            txtNumeroSingup.getText().isEmpty() ||
            txtConfirmPassword.getText().isEmpty() ||
            txtNumeroID.getText().isEmpty()){


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

    public Boolean checkDataEntry(){
        if(txtEmailSingupPerNa.getText().isEmpty() ||
                txtPasswordPerna.getText().isEmpty() ||
                txtUserNamePerna.getText().isEmpty() ||
                txtNumeroSingupPerna.getText().isEmpty() ||
                txtConfirmPasswordPerna.getText().isEmpty()) {
            return true; //retorno true cuando algo esta empty
        }else{
            return false;
        }
    }

    public void textFieldEmptyPerna(){ // metodo para verificar que ningun Textfield quede vacio
                                     // si este llega a estar vacio sale la advertencia
            if(checkDataEntry()){
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




    public void activeFormEm(Event event){
            // se gestiona la visibilidad del formulario
            anchPaneEmp.setVisible(true);
            anchPaneEmp.setManaged(true);
            anchPanePerna.setVisible(false);
            anchPanePerna.setManaged(false);

    }


    public void restrictionSpacesFormEmp(){
        txtPassword.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCharacter().equals(" ")){
                    event.consume();
                }
            }
        });
        txtConfirmPassword.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCharacter().equals(" ")){
                    event.consume();
                }
            }
        });
        txtEmailSingup.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCharacter().equals(" ")){
                    event.consume();
                }
            }
        });
        txtNumeroSingup.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCharacter().equals(" ")){
                    event.consume();
                }
            }
        });
        txtNumeroID.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCharacter().equals(" ")){
                    event.consume();
                }
            }
        });
        txtUserName.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCharacter().equals(" ")){
                    event.consume();
                }
            }
        });

    }

    public void restrictionSpacesForPerna(){

        txtConfirmPasswordPerna.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCharacter().equals(" ")){
                    event.consume();
                }
            }
        });

        txtEmailSingupPerNa.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCharacter().equals(" ")){
                    event.consume();
                }
            }
        });

        txtNumeroSingupPerna.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCharacter().equals(" ")){
                    event.consume();
                }
            }
        });

        txtPasswordPerna.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCharacter().equals(" ")){
                    event.consume();
                }
            }
        });

        txtUserNamePerna.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCharacter().equals(" ")){
                    event.consume();
                }
            }
        });

    }

    public void activeFormPerna(Event event){

            // se gestiona la visibilidad del formulario
            anchPaneEmp.setVisible(false);
            anchPaneEmp.setManaged(false);
            anchPanePerna.setVisible(true);
            anchPanePerna.setManaged(true);

    }

    public Boolean passwordVerification(){
        if((txtPassword.getText()).compareTo(txtConfirmPassword.getText())==0){
            return true;
        }
        return false;
    }



    public void delete_account() throws SQLException{

    }
}
