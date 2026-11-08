package com.mycompany.medpharm.dao;

import com.mycompany.medpharm.model.Producto;
import Util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    private Connection conexion;

    public boolean agregar(Producto producto) {
        String sql = "INSERT INTO productos (nombreProducto, descripcion, precioCompra, precioVenta, stockActual, stockMinimo, codigoBarra) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecioCompra());
            ps.setDouble(4, producto.getPrecioVenta());
            ps.setInt(5, producto.getStockActual());
            ps.setInt(6, producto.getStockMinimo());
            ps.setString(7, producto.getCodigoBarra());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al agregar producto: " + e.getMessage());
            return false;
        } finally {
            ConexionBD.desconectar(conexion);
        }
    }

    public List<Producto> listar() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos";

        try {
            conexion = ConexionBD.conectar();
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Producto p = new Producto();
                p.setIdProducto(rs.getInt("idProducto"));
                p.setNombreProducto(rs.getString("nombreProducto"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecioCompra(rs.getDouble("precioCompra"));
                p.setPrecioVenta(rs.getDouble("precioVenta"));
                p.setStockActual(rs.getInt("stockActual"));
                p.setStockMinimo(rs.getInt("stockMinimo"));
                p.setCodigoBarra(rs.getString("codigoBarra"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar productos: " + e.getMessage());
        } finally {
            ConexionBD.desconectar(conexion);
        }
        return lista;
    }

    public Producto buscar(int id) {
        String sql = "SELECT * FROM productos WHERE idProducto = ?";
        Producto p = null;

        try {
            conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p = new Producto();
                p.setIdProducto(rs.getInt("idProducto"));
                p.setNombreProducto(rs.getString("nombreProducto"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecioCompra(rs.getDouble("precioCompra"));
                p.setPrecioVenta(rs.getDouble("precioVenta"));
                p.setStockActual(rs.getInt("stockActual"));
                p.setStockMinimo(rs.getInt("stockMinimo"));
                p.setCodigoBarra(rs.getString("codigoBarra"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar producto: " + e.getMessage());
        } finally {
            ConexionBD.desconectar(conexion);
        }
        return p;
    }

    public boolean actualizar(Producto producto) {
        String sql = "UPDATE productos SET nombreProducto=?, descripcion=?, precioCompra=?, precioVenta=?, stockActual=?, stockMinimo=?, codigoBarra=? WHERE idProducto=?";
        try {
            conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecioCompra());
            ps.setDouble(4, producto.getPrecioVenta());
            ps.setInt(5, producto.getStockActual());
            ps.setInt(6, producto.getStockMinimo());
            ps.setString(7, producto.getCodigoBarra());
            ps.setInt(8, producto.getIdProducto());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar producto: " + e.getMessage());
            return false;
        } finally {
            ConexionBD.desconectar(conexion);
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM productos WHERE idProducto = ?";
        try {
            conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " + e.getMessage());
            return false;
        } finally {
            ConexionBD.desconectar(conexion);
        }
    }
}