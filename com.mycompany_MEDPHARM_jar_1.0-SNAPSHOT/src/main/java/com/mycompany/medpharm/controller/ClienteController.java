package com.mycompany.medpharm.controller;

import com.mycompany.medpharm.model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    private List<Cliente> listaClientes;

    public ClienteController() {
        listaClientes = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public List<Cliente> listarClientes() {
        return listaClientes;
    }

    public Cliente buscarPorId(int id) {
        for (Cliente c : listaClientes) {
            if (c.getIdCliente() == id) {
                return c;
            }
        }
        return null;
    }

    public boolean actualizarCliente(int id, Cliente nuevo) {
        Cliente c = buscarPorId(id);
        if (c != null) {
            int pos = listaClientes.indexOf(c);
            listaClientes.set(pos, nuevo);
            return true;
        }
        return false;
    }

    public boolean eliminarCliente(int id) {
        Cliente c = buscarPorId(id);
        if (c != null) {
            listaClientes.remove(c);
            return true;
        }
        return false;
    }
}
