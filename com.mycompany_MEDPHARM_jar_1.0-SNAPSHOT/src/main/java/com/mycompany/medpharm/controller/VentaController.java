package com.mycompany.medpharm.controller;

import com.mycompany.medpharm.model.Venta;
import com.mycompany.medpharm.model.DetalleVenta;
import java.util.ArrayList;
import java.util.List;

public class VentaController {
    private List<Venta> listaVentas;

    public VentaController() {
        listaVentas = new ArrayList<>();
    }

    public void registrarVenta(Venta venta) {
        listaVentas.add(venta);
    }

    public List<Venta> listarVentas() {
        return listaVentas;
    }

    public Venta buscarPorId(int id) {
        for (Venta v : listaVentas) {
            if (v.getIdVenta() == id) {
                return v;
            }
        }
        return null;
    }

    public boolean eliminarVenta(int id) {
        Venta v = buscarPorId(id);
        if (v != null) {
            listaVentas.remove(v);
            return true;
        }
        return false;
    }
}
