package com.example.proyect.model.dao;

import com.example.proyect.model.dto.EmpresaDTO;
import com.example.proyect.model.dto.NaturalDTO;

import java.sql.SQLException;

public interface EmpresaDAO {
    public EmpresaDTO create (EmpresaDTO login) throws SQLException;
    public Boolean encontrarUser_E(EmpresaDTO login);
    public Boolean encontrarUser_U(EmpresaDTO login);
    public EmpresaDTO findByUser(String user);

    public Boolean encontrar_G(EmpresaDTO login);
    public void delete(String user) throws SQLException;
}
