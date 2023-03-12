package com.example.proyect.model.dao.impl;

import com.example.proyect.model.dao.NaturalDAO;
import com.example.proyect.model.dto.NaturalDTO;
import com.example.proyect.util.MySql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NaturalDAOImpl implements NaturalDAO {

    private final MySql mySql;

    public NaturalDAOImpl() {
        this.mySql = new MySql();
    }

    @Override
    public NaturalDTO create(NaturalDTO login) throws SQLException {
        this.mySql.conectar();
        String query="Insert into usuario(correo, telefono,username,contraseña) values(" + "'" +login.getEmail()+"','"+login.getPhone()+"','"+login.getUser()+"','"+login.getPassword()+"')";
        Statement stmt =this.mySql.getConnection().createStatement();
        int code =stmt.executeUpdate(query);
        this.mySql.desconectar();
        switch (code){
            case 1:{
                System.out.println("Se creo el usuario");
                return findByUser(login.getUser());
            }
            default:
                return null;
        }
    }

    @Override
    public Boolean encontrarUser_E(NaturalDTO login) {
        Boolean res=false;
        try {
            this.mySql.conectar();
            String query= "SELECT * FROM usuario WHERE correo= '" + login.getEmail() + "'";
            Statement stmt =this.mySql.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs= stmt.executeQuery(query);
            if(rs.first()){
                NaturalDTO log = new NaturalDTO(rs.getString("username"),rs.getString("correo"));
                rs.close();
                stmt.close();
                if(login.getEmail().equals(log.getEmail()))
                    res=true;
            }else {
                rs.close();
                stmt.close();
            }
        } catch (SQLException e) {
            Logger.getLogger(NaturalDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
        return res;
    }

    @Override
    public Boolean encontrarUser_U(NaturalDTO login) {
        Boolean res=false;
        try {
            this.mySql.conectar();
            String query= "SELECT * FROM usuario WHERE username= '" + login.getUser() + "'";
            Statement stmt =this.mySql.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs= stmt.executeQuery(query);
            if(rs.first()){
                NaturalDTO log = new NaturalDTO(rs.getString("username"),rs.getString("correo"));
                rs.close();
                stmt.close();
                if(login.getUser().equals(log.getUser()))
                    res=true;
            }else {
                rs.close();
                stmt.close();
            }
        } catch (SQLException e) {
            Logger.getLogger(NaturalDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
        return res;
    }

    @Override
    public NaturalDTO findByUser(String user) {
        try {
            this.mySql.conectar();
            String query= "SELECT * FROM usuario WHERE correo= '" + user +"'";
            Statement stmt = this.mySql.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(query);
            if (rs.first()) {
                NaturalDTO log = new NaturalDTO(rs.getString("username"),rs.getString("contraseña"), rs.getString("correo"), rs.getString("telefono"), rs.getString("nombre"), rs.getString("apellidos"));
                rs.close();
                stmt.close();
                if(user.equals(log.getEmail()))
                    return log;
                else
                    return null;
            } else {
                rs.close();
                stmt.close();
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NaturalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public Boolean encontrar_G(NaturalDTO login){
        if(encontrarUser_E(login)==encontrarUser_U(login)){
            return encontrarUser_E(login);
        }
        else{
            return true;
        }
    }

    @Override
    public void delete(String user) throws SQLException {
        String query= "DELETE FROM usuario WHERE correo= '"+user+"'";
        System.out.println(query);
        Statement stmt=this.mySql.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs= stmt.executeQuery(query);
        rs.close();
        stmt.close();
    }
}
