package com.softcars.mx.model;

import java.sql.Date;

/**
 * @author DarkAlekxx20
 * @Desc: Clase modelo de automoviles
 * @Date: 03/09/2024
 */
public class Automovil {

    private int idAutomovil;
    public String marca;
    public Date modelo;
    public int color;

    public Automovil() {}

    public Automovil(int idAutomovil, String marca, Date modelo, int color) {
        this.idAutomovil = idAutomovil;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
    }

    public int getIdAutomovil() {
        return idAutomovil;
    }

    public void setIdAutomovil(int idAutomovil) {
        this.idAutomovil = idAutomovil;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Date getModelo() {
        return modelo;
    }

    public void setModelo(Date modelo) {
        this.modelo = modelo;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Automovil{" + "idAutomovil=" + idAutomovil + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color + '}';
    }

}