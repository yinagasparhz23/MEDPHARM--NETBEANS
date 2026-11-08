package com.mycompany.medpharm.dao;

import com.mycompany.medpharm.model.Cliente;
import Util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO  {
    
    private Connection conexion;

    // ✅ Insertar
    public boolean insertar(Cliente cliente) {
        String sql = "INSERT INTO cliente (nombre, direccion, telefono, correo) VALUES (?, ?, ?, ?)";
        try {
            conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getDireccion());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getCorreo());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar cliente: " + e.getMessage());
            return false;
        } finally {
            ConexionBD.desconectar(conexion);
        }
    }

    // ✅ Listar todos
    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try {
            conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setDireccion(rs.getString("direccion"));
                c.setTelefono(rs.getString("telefono"));
                c.setCorreo(rs.getString("correo"));
                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar clientes: " + e.getMessage());
        } finally {
            ConexionBD.desconectar(conexion);
        }
        return lista;
    }

    // ✅ Actualizar
    public boolean actualizar(Cliente cliente) {
        String sql = "UPDATE cliente SET nombre=?, direccion=?, telefono=?, correo=? WHERE id=?";
        try {
            conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getDireccion());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getCorreo());
            ps.setInt(5, cliente.getIdCliente());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente: " + e.getMessage());
            return false;
        } finally {
            ConexionBD.desconectar(conexion);
        }
    }

    // ✅ Eliminar
    public boolean eliminar(int id) {
        String sql = "DELETE FROM cliente WHERE id=?";
        try {
            conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
            return false;
        } finally {
            ConexionBD.desconectar(conexion);
        }
    }
}