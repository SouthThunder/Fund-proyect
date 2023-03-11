package com.example.proyect.model.dto;

public class EmpresaDTO extends User{

    private String RUT;
    private Boolean estado_suscripcion;

    public EmpresaDTO(String user, String password, String email, String phone, String RUT){
        super(user, password, email, phone);
        this.RUT=RUT;
    }

    public EmpresaDTO(String user, String email){
        super(user,email);
    };

    public String getRUT() {
        return RUT;
    }

    public void setRUT(String RUT) {
        this.RUT = RUT;
    }

    public Boolean getEstado_suscripcion() {
        return estado_suscripcion;
    }

    public void setEstado_suscripcion(Boolean estado_suscripcion) {
        this.estado_suscripcion = estado_suscripcion;
    }
}
