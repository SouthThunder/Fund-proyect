package com.example.proyect;


import com.example.proyect.model.dao.EmpresaDAO;
import com.example.proyect.model.dao.NaturalDAO;
import com.example.proyect.model.dao.impl.EmpresaDAOImpl;
import com.example.proyect.model.dao.impl.NaturalDAOImpl;
import com.example.proyect.model.dto.EmpresaDTO;
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
import java.util.regex.Pattern;


public class Controller_singup implements Initializable {

    // atributos para operaciones
    private Boolean registrationAuthorization = false;
    private Encrypt hash= new Encrypt();



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



        /*
        |
        |
        |
        |
       \*/


    // Metodo inicializador
    @Override
    public void initialize(URL url, ResourceBundle rb){

        anchPanePerna.setVisible(false); // lo vuelve invisible
        anchPanePerna.setManaged(false); // le quita el espacio asignado


        restrictionSpacesFormEmp(); //llamada de m??todo para restringir espacios

        restrictionSpacesForPerna(); //llamada de m??todo para restringir espacios

    }


        /*
        |
        |
        |
        |
       \*/


    // Verificacion y restricciones de registro en empresas

    public void registerEmp() throws NoSuchAlgorithmException {

        textFieldEmptyEmp();

    }

    public void textFieldEmptyEmp(){ // metodo para verificar que ningun Textfield quede vacio
                                     // si este llega a estar vacio sale la advertencia
        boolean llen  = false;
        boolean equals = false;

        if(txtEmailSingup.getText().isEmpty() ||
                txtPassword.getText().isEmpty() ||
                txtUserName.getText().isEmpty() ||
                txtNumeroSingup.getText().isEmpty() ||
                txtConfirmPassword.getText().isEmpty() ||
                txtNumeroID.getText().isEmpty()){


            // Crea una ventana emergente de advertencia
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Espacios vacios");
            alert.setHeaderText("Por favor aseg??rese de que todos los espacios est??n llenos");

            // Muestra la ventana emergente y espera hasta que se cierre
            alert.showAndWait();

            llen = false;
        }else {
            llen = true;
        }

        if (llen == true){// llama a la funcion de igualdad de contrase??as, pero primero pregunta si estan llenos los espacios

            if (equalPasswordsEmp() == true){ // pregunta si se lanzo la advertencia de contrase??as iguales
                equals = false;               // si la saco no puede continuar con la validacion de contrase??a
            }
            else {
                equals = true;
            }
        }

        if (equals == true){ // pregunta si la advertencia de que las contrase??as son iguales, si no la lanzo significa que puede empezar
            // con la validacion de la contrase??a y lanzar sus respectivas advertencias
            passwordValidationEmp(); // funcion para validar las especificaciones de la contrase??a (tama??o, caracteres v??lidos y necesarios) y autorizar el registro de datos a la base de datos
        }
    }

    public boolean equalPasswordsEmp(){ // esta funcion revisa que las contrase??as sean iguales, si no es asi envia la advertencia

        String pas = txtPassword.getText();
        String con = txtConfirmPassword.getText();
        boolean state = false;

        if(pas.equals(con)){
            state = true;
        } else if(!pas.equals(con)){
            state = false;
        }

        if (state == false ){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Las contrase??as no coinciden");
            alert.setHeaderText("Por favor aseg??rese de que las contrase??as sean iguales");

            // Mostrar la ventana emergente y esperar a que se cierre
            alert.showAndWait();
            return true;
        }

        return false;
    }

    public void passwordValidationEmp() { // esta funcion verifica el tama??o y la composicion de la contrase??a

        int numdig = txtPassword.getLength();
        String contra = txtPassword.getText();
        registrationAuthorization = false;

        if (numdig < 8){ // verificacion de que tenga m??s de 8 digitos la contrase??a
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Las contrase??a tiene menos de ocho digitos");
            alert.setHeaderText("Por favor aseg??rese de que la contrase??a cuente con mas de ocho digitos");

            // Mostrar la ventana emergente y esperar a que se cierre
            alert.showAndWait();

        }else if (numdig >= 8){ // si la contrase??a cuenta con 8 o mas caracteres puesde hacer la validacion de caracteres

            var regex ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=-_!~|?,.<>/*()]).+$"; // la exprecion regular indica las condiciones de validacion

            Pattern pattern = Pattern.compile(regex);

            if (pattern.matches(regex,contra) == false){ // revisa si las contrase??as no cumplen con la condicion de caracteres
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("La contrase??a no cumple con los requisitos minimos");
                alert.setHeaderText("Recuerde que la contrase??a debe de contar con almenos una mayuscula, minuscula, numero y simbolo ");

                // Mostrar la ventana emergente y esperar a que se cierre
                alert.showAndWait();
            }else{
                registrationAuthorization = true;
            }
        }
    }


        /*
        |
        |
        |
        |
       \*/


    // Verificacion y restricciones de registro en persona natural

    public void registerPerna(){

        textFieldEmptyPerna();

    }


    public void textFieldEmptyPerna(){ // metodo para verificar que ningun Textfield quede vacio
                                       // si este llega a estar vacio sale la advertencia
        boolean llen  = false;
        boolean equals = false;

        if(txtEmailSingupPerNa.getText().isEmpty() ||
                txtPasswordPerna.getText().isEmpty() ||
                txtUserNamePerna.getText().isEmpty() ||
                txtNumeroSingupPerna.getText().isEmpty() ||
                txtConfirmPasswordPerna.getText().isEmpty()){


            // Crea una ventana emergente de advertencia
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Espacios vacios");
            alert.setHeaderText("Por favor aseg??rese de que todos los espacios est??n llenos");

            // Muestra la ventana emergente y espera hasta que se cierre
            alert.showAndWait();

            llen = false;
        }else {
            llen = true;
        }

        if (llen == true){// llama a la funcion de igualdad de contrase??as, pero primero pregunta si estan llenos los espacios

            if (equalPasswordsPerna() == true){ // pregunta si se lanzo la advertencia de contrase??as iguales
                equals = false;               // si la saco no puede continuar con la validacion de contrase??a
            }
            else {
                equals = true;
            }
        }

        if (equals == true){ // pregunta si la advertencia de que las contrase??as son iguales, si no la lanzo significa que puede empezar
            // con la validacion de la contrase??a y lanzar sus respectivas advertencias
            passwordValidationPerna(); // funcion para validar las especificaciones de la contrase??a (tama??o, caracteres v??lidos y necesarios) y autorizar el registro de datos a la base de datos
        }
    }

    public boolean equalPasswordsPerna(){ // esta funcion revisa que las contrase??as sean iguales, si no es asi envia la advertencia

        String pas = txtPasswordPerna.getText();
        String con = txtConfirmPasswordPerna.getText();
        boolean state = false;

        if(pas.equals(con)){
            state = true;
        } else if(!pas.equals(con)){
            state = false;
        }

        if (state == false ){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Las contrase??as no coinciden");
            alert.setHeaderText("Por favor aseg??rese de que las contrase??as sean iguales");

            // Mostrar la ventana emergente y esperar a que se cierre
            alert.showAndWait();
            return true;
        }

        return false;
    }

    public void passwordValidationPerna() { // esta funcion verifica el tama??o y la composicion de la contrase??a

        int numdig = txtPasswordPerna.getLength();
        String contra = txtPasswordPerna.getText();
        registrationAuthorization = false;

        if (numdig < 8){ // verificacion de que tenga m??s de 8 digitos la contrase??a
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Las contrase??a tiene menos de ocho digitos");
            alert.setHeaderText("Por favor aseg??rese de que la contrase??a cuente con mas de ocho digitos");

            // Mostrar la ventana emergente y esperar a que se cierre
            alert.showAndWait();

        }else if (numdig >= 8){ // si la contrase??a cuenta con 8 o mas caracteres puesde hacer la validacion de caracteres

            var regex ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=-_!~|?,.<>/*()]).+$"; // la exprecion regular indica las condiciones de validacion

            Pattern pattern = Pattern.compile(regex);

            if (pattern.matches(regex,contra) == false){ // revisa si las contrase??as no cumplen con la condicion de caracteres
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("La contrase??a no cumple con los requisitos minimos");
                alert.setHeaderText("Recuerde que la contrase??a debe de contar con almenos una mayuscula, minuscula, numero y simbolo ");

                // Mostrar la ventana emergente y esperar a que se cierre
                alert.showAndWait();
            }else{
                registrationAuthorization = true;
            }
        }
    }


        /*
        |
        |
        |
        |
       \*/


    // Envio de datos a la base de datos para el formulario de persona natural

    public void registerFormEmp() throws NoSuchAlgorithmException, SQLException { // funcion hace el hash de contrase??as, envio datos, y la verificacion de usuario
        if (registrationAuthorization == true){
            EmpresaDTO ndto= new EmpresaDTO(txtUserName.getText(),hash.hashString(txtPassword.getText()),txtEmailSingup.getText(),txtNumeroSingup.getText(),txtNumeroID.getText(), false);
            EmpresaDAO ndao=new EmpresaDAOImpl();
            Boolean checkuser=ndao.encontrar_G(ndto);
            if(checkuser) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Usuario en existencia");
                alert.setHeaderText("Trate de registrarse con un nombre de usuario distinto");

                // Mostrar la ventana emergente y esperar a que se cierre
                alert.showAndWait();
            }else{
                ndao.create(ndto);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Creacion de cunta exitosa");
                alert.setHeaderText("Su cuenta ha sido registrada con exito");

                // Mostrar la ventana emergente y esperar a que se cierre
                alert.showAndWait();
            }
        }
    }


        /*
        |
        |
        |
        |
       \*/


    // Envio de datos a la base de datos para el formulario de persona natural

    public void registerFormPerna() throws NoSuchAlgorithmException, SQLException { // funcion hace el hash de contrase??as, envio datos, y la verificacion de usuario

        if (registrationAuthorization == true){
            NaturalDTO ndto= new NaturalDTO(txtUserNamePerna.getText(),hash.hashString(txtPasswordPerna.getText()),txtEmailSingupPerNa.getText(),txtNumeroSingupPerna.getText(), null, null);
            NaturalDAO ndao=new NaturalDAOImpl();
            Boolean checkuser=ndao.encontrar_G(ndto);
            if(checkuser){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Usuario en existencia");
                alert.setHeaderText("Trate de registrarse con un nombre de usuario distinto");

                // Mostrar la ventana emergente y esperar a que se cierre
                alert.showAndWait();
            }
            else{
                ndao.create(ndto);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Creacion de cunta exitosa");
                alert.setHeaderText("Su cuenta ha sido registrada con exito");

                // Mostrar la ventana emergente y esperar a que se cierre
                alert.showAndWait();
            }
        }
    }

    public void delete_account() throws SQLException{

    }


        /*
        |
        |
        |
        |
       \*/


    // Activacion de formulario segun perfil (empresa,persona)

    public void activeFormEm(Event event){

        // se gestiona la visibilidad del formulario de para empresas
        anchPaneEmp.setVisible(true);
        anchPaneEmp.setManaged(true);
        anchPanePerna.setVisible(false);
        anchPanePerna.setManaged(false);

        // si estaba en persona natural y llega a pasar a empresa se borra lo que tenia escrito en persona natural
        txtPasswordPerna.setText("");
        txtConfirmPasswordPerna.setText("");
        txtNumeroSingupPerna.setText("");
        txtUserNamePerna.setText("");
        txtEmailSingupPerNa.setText("");

    }




    public void activeFormPerna(Event event){

        // se gestiona la visibilidad del formulario para persona natural
        anchPaneEmp.setVisible(false);
        anchPaneEmp.setManaged(false);
        anchPanePerna.setVisible(true);
        anchPanePerna.setManaged(true);

        // si estaba en empresa y llega a pasar a persona natural se borra lo que tenia escrito en empresa
        txtPassword.setText("");
        txtConfirmPassword.setText("");
        txtNumeroSingup.setText("");
        txtUserName.setText("");
        txtEmailSingup.setText("");
        txtNumeroID.setText("");

    }


        /*
        |
        |
        |
        |
       \*/


    // restricciones gramaticales

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





}





