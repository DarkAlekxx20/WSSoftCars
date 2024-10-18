package com.softcars.mx.model;

import java.sql.Date;

/**
 * @author DarkAlekxx20
 * @Desc: Clase modelo de Compras
 * @Date: 03/09/2024
 */
public class Compra {

    private int idCompra;
    private Automovil idAutomovil;
    private Usuario idUsuario;
    public Date fechaCompra;
    public double precioCompra;
    public double gastos;
    public int estatus;

    public Compra() {
    }

    public Compra(int idCompra, Automovil idAutomovil, Usuario idUsuario, Date fechaCompra, double precioCompra, double gastos, int estatus) {
        this.idCompra = idCompra;
        this.idAutomovil = idAutomovil;
        this.idUsuario = idUsuario;
        this.fechaCompra = fechaCompra;
        this.precioCompra = precioCompra;
        this.gastos = gastos;
        this.estatus = estatus;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Automovil getIdAutomovil() {
        return idAutomovil;
    }

    public void setIdAutomovil(Automovil idAutomovil) {
        this.idAutomovil = idAutomovil;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getGastos() {
        return gastos;
    }

    public void setGastos(double gastos) {
        this.gastos = gastos;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "Compra{" + "idCompra=" + idCompra + ", idAutomovil=" + idAutomovil + ", idUsuario=" + idUsuario + ", fechaCompra=" + fechaCompra + ", precioCompra=" + precioCompra + ", gastos=" + gastos + ", estatus=" + estatus + '}';
    }

}
