package com.mycompany.medpharm.controller;

import com.mycompany.medpharm.model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioController {
    private List<Usuario> listaUsuarios;

    public UsuarioController() {
        listaUsuarios = new ArrayList<>();
    }

    public void agregarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return listaUsuarios;
    }

    public Usuario buscarPorId(int id) {
        for (Usuario u : listaUsuarios) {
            if (u.getIdUsuario() == id) {
                return u;
            }
        }
        return null;
    }

    public boolean actualizarUsuario(int id, Usuario nuevo) {
        Usuario u = buscarPorId(id);
        if (u != null) {
            int pos = listaUsuarios.indexOf(u);
            listaUsuarios.set(pos, nuevo);
            return true;
        }
        return false;
    }

    public boolean eliminarUsuario(int id) {
        Usuario u = buscarPorId(id);
        if (u != null) {
            listaUsuarios.remove(u);
            return true;
        }
        return false;
    }
}
