package com.mycompany.medpharm.dao;

import com.mycompany.medpharm.model.Compra;
import Util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompraDAO {
    
    private Connection conexion;

    // ✅ Insertar
    public boolean insertar(Compra compra) {
        String sql = "INSERT INTO compra (fechaCompra, total, idProveedor) VALUES (?, ?, ?)";
        try {
            conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(compra.getFechaCompra().getTime()));
            ps.setDouble(2, compra.getTotal());
            ps.setInt(3, compra.getProveedor().getIdProveedor());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar compra: " + e.getMessage());
            return false;
        } finally {
            ConexionBD.desconectar(conexion);
        }
    }

    // ✅ Listar todos
    public List<Compra> listar() {
        List<Compra> lista = new ArrayList<>();
        String sql = "SELECT * FROM compra";
        try {
            conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Compra c = new Compra();
                c.setIdCompra(rs.getInt("idCompra"));
                
                // ⚠️ Aquí necesitas crear un objeto Proveedor
                com.mycompany.medpharm.model.Proveedor p = new com.mycompany.medpharm.model.Proveedor();
                p.setIdProveedor(rs.getInt("idProveedor"));
                c.setProveedor(p);
                
                c.setFechaCompra(rs.getDate("fechaCompra"));
                c.setTotal(rs.getDouble("total"));
                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar compras: " + e.getMessage());
        } finally {
            ConexionBD.desconectar(conexion);
        }
        return lista;
    }

    // ✅ Actualizar
    public boolean actualizar(Compra compra) {
        String sql = "UPDATE compra SET fechaCompra=?, total=?, idProveedor=? WHERE idCompra=?";
        try {
            conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(compra.getFechaCompra().getTime()));
            ps.setDouble(2, compra.getTotal());
            ps.setInt(3, compra.getProveedor().getIdProveedor());
            ps.setInt(4, compra.getIdCompra());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar compra: " + e.getMessage());
            return false;
        } finally {
            ConexionBD.desconectar(conexion);
        }
    }

    // ✅ Eliminar
    public boolean eliminar(int idCompra) {
        String sql = "DELETE FROM compra WHERE idCompra=?";
        try {
            conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idCompra);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar compra: " + e.getMessage());
            return false;
        } finally {
            ConexionBD.desconectar(conexion);
        }
    }
}