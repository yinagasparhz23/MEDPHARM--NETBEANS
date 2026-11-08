package com.mycompany.medpharm.model;

public class Inventario {
    private int idInventario;
    private Producto producto;
    private int cantidadStock;
    private int stockMinimo;

    public Inventario() {
    }

    public Inventario(int idInventario, Producto producto, int cantidadStock, int stockMinimo) {
        this.idInventario = idInventario;
        this.producto = producto;
        this.cantidadStock = cantidadStock;
        this.stockMinimo = stockMinimo;
    }

    public int getIdInventario() { return idInventario; }
    public void setIdInventario(int idInventario) { this.idInventario = idInventario; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }

    public int getCantidadStock() { return cantidadStock; }
    public void setCantidadStock(int cantidadStock) { this.cantidadStock = cantidadStock; }

    public int getStockMinimo() { return stockMinimo; }
    public void setStockMinimo(int stockMinimo) { this.stockMinimo = stockMinimo; }
    
    public boolean esStockBajo() {
        return this.cantidadStock < this.stockMinimo;
    }
}