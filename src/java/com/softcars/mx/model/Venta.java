package com.softcars.mx.model;

import java.sql.Date;

/**
 * @author DarkAlekxx20
 * @Desc: Clase modelo de ventas
 * @Date: 03/09/2024
 */
public class Venta {

    private int idVenta;
    private Compra idCompra;
    private Usuario idUsuario;
    public Date fechaVenta;
    public double precioVenta;
    public double ganancia;

    public Venta() {
    }

    public Venta(int idVenta, Compra idCompra, Usuario idUsuario, Date fechaVenta, double precioVenta, double ganancia) {
        this.idVenta = idVenta;
        this.idCompra = idCompra;
        this.idUsuario = idUsuario;
        this.fechaVenta = fechaVenta;
        this.precioVenta = precioVenta;
        this.ganancia = ganancia;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Compra getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Compra idCompra) {
        this.idCompra = idCompra;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getGanancia() {
        return ganancia;
    }

    public void setGanancia(double ganancia) {
        this.ganancia = ganancia;
    }

    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", idCompra=" + idCompra + ", idUsuario=" + idUsuario + ", fechaVenta=" + fechaVenta + ", precioVenta=" + precioVenta + ", ganancia=" + ganancia + '}';
    }

}
