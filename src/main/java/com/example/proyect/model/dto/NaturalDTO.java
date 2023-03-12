package com.example.proyect.model.dto;

import java.util.ArrayList;

public class NaturalDTO extends User{
    private String nombre;
    private String apellido;

    public NaturalDTO(String user, String password, String email, String phone) {
        super(user, password, email, phone);
    }

    public NaturalDTO(String user, String email){super(user,email);};

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
