package com.example.proyect.model.dao.impl;

import com.example.proyect.model.dao.EmpresaDAO;
import com.example.proyect.model.dto.EmpresaDTO;
import com.example.proyect.model.dto.NaturalDTO;
import com.example.proyect.util.MySql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmpresaDAOImpl implements EmpresaDAO {
    private final MySql mySql;


    public EmpresaDAOImpl() {
        this.mySql = new MySql();
    }

    @Override
    public EmpresaDTO create(EmpresaDTO login) throws SQLException {
        this.mySql.conectar();
        String query="Insert into empresa(correo, telefono,nombre_empresa,contraseña,rut,estado_suscripcion) values(" + "'" +login.getEmail()+"','"+login.getPhone()+"','"+login.getUser()+"','"+login.getPassword()+ "','"+login.getRUT()+ "','"+0+"')";
        Statement stmt =this.mySql.getConnection().createStatement();
        int code =stmt.executeUpdate(query);
        this.mySql.desconectar();
        switch (code){
            case 1:{
                System.out.println("Se creo la empresa");
                return findByUser(login.getUser());
            }
            default:
                return null;
        }
    }

    @Override
    public Boolean encontrarUser_E(EmpresaDTO login) {
        Boolean res=false;
        try {
            this.mySql.conectar();
            String query= "SELECT * FROM empresa WHERE correo= '" + login.getEmail() + "'";
            Statement stmt =this.mySql.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs= stmt.executeQuery(query);
            if(rs.first()){
                EmpresaDTO log = new EmpresaDTO(rs.getString("nombre_empresa"),rs.getString("correo"));
                rs.close();
                stmt.close();
                if(login.getEmail().equals(log.getEmail()))
                    res=true;
            }else {
                rs.close();
                stmt.close();
            }
        } catch (SQLException e) {
            Logger.getLogger(EmpresaDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
        return res;
    }

    @Override
    public Boolean encontrarUser_U(EmpresaDTO login) {
        Boolean res=false;
        try {
            this.mySql.conectar();
            String query= "SELECT * FROM empresa WHERE nombre_empresa= '" + login.getUser() + "'";
            Statement stmt =this.mySql.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs= stmt.executeQuery(query);
            if(rs.first()){
                EmpresaDTO log = new EmpresaDTO(rs.getString("nombre_empresa"),rs.getString("correo"));
                rs.close();
                stmt.close();
                if(login.getUser().equals(log.getUser()))
                    res=true;
            }else {
                rs.close();
                stmt.close();
            }
        } catch (SQLException e) {
            Logger.getLogger(EmpresaDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
        return res;
    }

    @Override
    public EmpresaDTO findByUser(String user) {
        try {
            this.mySql.conectar();
            String query= "SELECT * FROM empresa WHERE correo= '" + user +"'";
            Statement stmt = this.mySql.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(query);
            if (rs.first()) {
                EmpresaDTO log = new EmpresaDTO(rs.getString("nombre_empresa"),rs.getString("contraseña"), rs.getString("correo"), rs.getString("telefono"), rs.getString("rut"), rs.getBoolean("estado_suscripcion"));
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
            Logger.getLogger(EmpresaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public Boolean encontrar_G(EmpresaDTO login){
        if(encontrarUser_E(login)==encontrarUser_U(login)){
            return encontrarUser_E(login);
        }
        else{
            return true;
        }
    }

    @Override
    public void delete(String user) throws SQLException {
        String query= "DELETE FROM empresa WHERE correo= '"+user+"'";
        System.out.println(query);
        Statement stmt=this.mySql.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs= stmt.executeQuery(query);
        rs.close();
        stmt.close();
    }
}
