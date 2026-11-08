package com.mycompany.medpharm.controller;

import com.mycompany.medpharm.model.Proveedor;
import java.util.ArrayList;
import java.util.List;

public class ProveedorController {
    private List<Proveedor> listaProveedores;

    public ProveedorController() {
        listaProveedores = new ArrayList<>();
    }

    public void agregarProveedor(Proveedor proveedor) {
        listaProveedores.add(proveedor);
    }

    public List<Proveedor> listarProveedores() {
        return listaProveedores;
    }

    public Proveedor buscarPorId(int id) {
        for (Proveedor p : listaProveedores) {
            if (p.getIdProveedor() == id) {
                return p;
            }
        }
        return null;
    }

    public boolean actualizarProveedor(int id, Proveedor nuevo) {
        Proveedor p = buscarPorId(id);
        if (p != null) {
            int pos = listaProveedores.indexOf(p);
            listaProveedores.set(pos, nuevo);
            return true;
        }
        return false;
    }

    public boolean eliminarProveedor(int id) {
        Proveedor p = buscarPorId(id);
        if (p != null) {
            listaProveedores.remove(p);
            return true;
        }
        return false;
    }
}