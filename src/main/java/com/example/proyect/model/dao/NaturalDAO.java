package com.example.proyect.model.dao;

public interface NaturalDAO {
    public NaturalDAO create (NaturalDAO login);
    public Boolean encontrarUser(String user, NaturalDAO login);
    public NaturalDAO findByUser(String user);
}
