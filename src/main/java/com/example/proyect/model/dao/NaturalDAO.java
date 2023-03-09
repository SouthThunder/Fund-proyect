package com.example.proyect.model.dao;

import com.example.proyect.model.dto.NaturalDTO;

import java.sql.SQLException;

public interface NaturalDAO {
    public NaturalDTO create (NaturalDTO login) throws SQLException;
    public Boolean encontrarUser_E(NaturalDTO login);
    public Boolean encontrarUser_U(NaturalDTO login);
    public NaturalDTO findByUser(String user);

    public Boolean encontrar_G(NaturalDTO login);
    public void delete(String user) throws SQLException;
}
