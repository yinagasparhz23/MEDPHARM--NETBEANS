package com.mycompany.medpharm.model;

import java.util.Date;

public class Compra {
    private int idCompra;
    private Proveedor proveedor;
    private Date fechaCompra;
    private double total;

    public Compra() {
    }

    public Compra(int idCompra, Proveedor proveedor, Date fechaCompra, double total) {
        this.idCompra = idCompra;
        this.proveedor = proveedor;
        this.fechaCompra = fechaCompra;
        this.total = total;
    }

    public int getIdCompra() { return idCompra; }
    public void setIdCompra(int idCompra) { this.idCompra = idCompra; }

    public Proveedor getProveedor() { return proveedor; }
    public void setProveedor(Proveedor proveedor) { this.proveedor = proveedor; }

    public Date getFechaCompra() { return fechaCompra; }
    public void setFechaCompra(Date fechaCompra) { this.fechaCompra = fechaCompra; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
}