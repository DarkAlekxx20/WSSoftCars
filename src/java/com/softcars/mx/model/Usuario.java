package com.softcars.mx.model;

/**
 * @author DarkAlekxx20
 * @Desc: Clase modelo de los usuarios
 * @Date: 04/09/2024
 */
public class Usuario {

    private int idUsuario;
    public String username;
    public String password;
    public int estatus;

    public Usuario() {
    }

    public Usuario(int idUsuario, String username, String password, int estatus) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.estatus = estatus;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "idUsuario=" + idUsuario + ", username=" + username + ", password=" + password + ", estatus=" + estatus + '}';
    }

}