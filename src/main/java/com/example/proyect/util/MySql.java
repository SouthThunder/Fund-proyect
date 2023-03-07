package com.example.proyect.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySql {
    private final String URL;
    private final String user;
    private final String pass;
    private Connection connection;

    public MySql(){
        this.URL= "jdbc:mysql://localhost:3306/PymeWave";
        this.user= "root";
        this.pass= "Aerochord-razihel1";
        this.connection = null;
    }

    public void conectar(){
        try{
            System.out.println(URL);
            this.connection= DriverManager.getConnection(URL,user,pass);
            System.out.println("Conexion exitosa");
        } catch (SQLException ex) {
            System.out.println("No se conecto");
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            this.connection=null;
        }catch(Exception ex){
            System.out.println("No se conecto");
            System.out.println("Exception: " + ex.getMessage());
            this.connection=null;
        }
    }

    public void desconectar() {
        try {
            this.connection.close();
            System.out.println("Se desconecto");
        } catch (SQLException ex) {
            System.out.println("No se desconecto");
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        this.connection = null;
    }

    public Connection getConnection() {
        return connection;
    }

}
