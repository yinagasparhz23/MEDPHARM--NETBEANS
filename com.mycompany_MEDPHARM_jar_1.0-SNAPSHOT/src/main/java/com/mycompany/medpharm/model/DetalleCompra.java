package com.mycompany.medpharm.model;

public class DetalleCompra {
    private int idDetalle;
    private Compra compra;
    private Producto producto;
    private int cantidad;
    private double precioCosto;
    private double subtotal;

    public DetalleCompra() {
    }

    public DetalleCompra(int idDetalle, Compra compra, Producto producto, int cantidad, double precioCosto) {
        this.idDetalle = idDetalle;
        this.compra = compra;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioCosto = precioCosto;
        this.subtotal = cantidad * precioCosto;
    }

    public int getIdDetalle() { return idDetalle; }
    public void setIdDetalle(int idDetalle) { this.idDetalle = idDetalle; }

    public Compra getCompra() { return compra; }
    public void setCompra(Compra compra) { this.compra = compra; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        this.subtotal = this.cantidad * this.precioCosto;
    }

    public double getPrecioCosto() { return precioCosto; }
    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
        this.subtotal = this.cantidad * this.precioCosto;
    }

    public double getSubtotal() { return subtotal; }
}
