package com.mycompany.medpharm.model;

import java.util.Date;

public class Venta {
    private int idVenta;
    private Cliente cliente;
    private Usuario usuario;
    private Date fechaVenta;
    private double total;

    public Venta() {
    }

    public Venta(int idVenta, Cliente cliente, Usuario usuario, Date fechaVenta, double total) {
        this.idVenta = idVenta;
        this.cliente = cliente;
        this.usuario = usuario;
        this.fechaVenta = fechaVenta;
        this.total = total;
    }

    public int getIdVenta() { return idVenta; }
    public void setIdVenta(int idVenta) { this.idVenta = idVenta; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Date getFechaVenta() { return fechaVenta; }
    public void setFechaVenta(Date fechaVenta) { this.fechaVenta = fechaVenta; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
}
