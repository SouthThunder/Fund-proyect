package com.example.proyect.model.dao.impl;

import com.example.proyect.model.dao.NaturalDAO;
import com.example.proyect.util.MySql;

public class NaturalDAOImpl implements NaturalDAO {

    private final MySql mySql;

    public NaturalDAOImpl(MySql mySql) {
        this.mySql = new MySql();
    }

    @Override
    public NaturalDAO create(NaturalDAO login) {
        /*try{
            this.mySql.conectar();
            String query="Insert into usuario()";
        }*/
        return null;cd
    }

    @Override
    public Boolean encontrarUser(String user, NaturalDAO login) {
        return null;
    }

    @Override
    public NaturalDAO findByUser(String user) {
        return null;
    }
}
