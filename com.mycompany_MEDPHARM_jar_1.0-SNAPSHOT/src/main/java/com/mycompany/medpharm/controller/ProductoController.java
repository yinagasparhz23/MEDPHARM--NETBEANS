package com.mycompany.medpharm.controller;

import com.mycompany.medpharm.model.Producto;
import java.util.ArrayList;
import java.util.List;

public class ProductoController {
    private List<Producto> listaProductos;

    public ProductoController() {
        listaProductos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }

    public List<Producto> listarProductos() {
        return listaProductos;
    }

    public Producto buscarPorId(int id) {
        for (Producto p : listaProductos) {
            if (p.getIdProducto() == id) {
                return p;
            }
        }
        return null;
    }

    public boolean actualizarProducto(int id, Producto nuevo) {
        Producto p = buscarPorId(id);
        if (p != null) {
            int pos = listaProductos.indexOf(p);
            listaProductos.set(pos, nuevo);
            return true;
        }
        return false;
    }

    public boolean eliminarProducto(int id) {
        Producto p = buscarPorId(id);
        if (p != null) {
            listaProductos.remove(p);
            return true;
        }
        return false;
    }
}
