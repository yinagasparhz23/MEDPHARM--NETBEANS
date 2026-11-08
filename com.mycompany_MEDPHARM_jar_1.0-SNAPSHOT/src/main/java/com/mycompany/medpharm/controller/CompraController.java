package com.mycompany.medpharm.controller;

import com.mycompany.medpharm.model.Compra;
import com.mycompany.medpharm.model.DetalleCompra;
import java.util.ArrayList;
import java.util.List;

public class CompraController {
    private List<Compra> listaCompras;

    public CompraController() {
        listaCompras = new ArrayList<>();
    }

    public void registrarCompra(Compra compra) {
        listaCompras.add(compra);
    }

    public List<Compra> listarCompras() {
        return listaCompras;
    }

    public Compra buscarPorId(int id) {
        for (Compra c : listaCompras) {
            if (c.getIdCompra() == id) {
                return c;
            }
        }
        return null;
    }

    public boolean eliminarCompra(int id) {
        Compra c = buscarPorId(id);
        if (c != null) {
            listaCompras.remove(c);
            return true;
        }
        return false;
    }
}