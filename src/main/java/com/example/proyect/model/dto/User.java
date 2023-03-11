package com.example.proyect.model.dto;

import java.util.Objects;

public abstract class User {
    private String user;
    private String password;
    private String email;
    private String phone;

    public User(String user, String password, String email, String phone){
        this.user=user;
        this.password=password;
        this.email=email;
        this.phone=phone;
    }

    public User(String user, String email) {
        this.user=user;
        this.email=email;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user1)) return false;
        return Objects.equals(getUser(), user1.getUser()) && Objects.equals(getPassword(), user1.getPassword()) && Objects.equals(getEmail(), user1.getEmail()) && Objects.equals(getPhone(), user1.getPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser(), getPassword(), getEmail(), getPhone());
    }
}
