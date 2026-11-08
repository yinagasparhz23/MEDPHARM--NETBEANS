package com.mycompany.medpharm.controller;

import com.mycompany.medpharm.model.Inventario;
import java.util.ArrayList;
import java.util.List;

public class InventarioController {
    private List<Inventario> listaInventario;

    public InventarioController() {
        listaInventario = new ArrayList<>();
    }

    public void agregarInventario(Inventario inventario) {
        listaInventario.add(inventario);
    }

    public List<Inventario> listarInventario() {
        return listaInventario;
    }

    public List<Inventario> listarStockBajo() {
        List<Inventario> stockBajo = new ArrayList<>();
        for (Inventario inv : listaInventario) {
            if (inv.esStockBajo()) {
                stockBajo.add(inv);
            }
        }
        return stockBajo;
    }

    public Inventario buscarPorId(int id) {
        for (Inventario inv : listaInventario) {
            if (inv.getIdInventario() == id) {
                return inv;
            }
        }
        return null;
    }

    public boolean actualizarInventario(int id, Inventario nuevo) {
        Inventario inv = buscarPorId(id);
        if (inv != null) {
            int pos = listaInventario.indexOf(inv);
            listaInventario.set(pos, nuevo);
            return true;
        }
        return false;
    }

    public boolean eliminarInventario(int id) {
        Inventario inv = buscarPorId(id);
        if (inv != null) {
            listaInventario.remove(inv);
            return true;
        }
        return false;
    }
}
