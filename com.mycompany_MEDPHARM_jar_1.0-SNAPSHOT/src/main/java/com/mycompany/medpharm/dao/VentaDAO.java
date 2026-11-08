package com.mycompany.medpharm.DAO;

import com.mycompany.medpharm.model.Venta;
import Util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VentaDAO {

    private Connection conexion;

    // ✅ Agregar venta
    public boolean agregar(Venta venta) {
        String sql = "INSERT INTO ventas (fechaVenta, total, idCliente, idUsuario) VALUES (?, ?, ?, ?)";
        try {
            conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setDate(1, new java.sql.Date(venta.getFechaVenta().getTime()));
            ps.setDouble(2, venta.getTotal());

            ps.setInt(3, venta.getCliente().getIdCliente());
            ps.setInt(4, venta.getUsuario().getIdUsuario());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al agregar venta: " + e.getMessage());
            return false;
        } finally {
            ConexionBD.desconectar(conexion);
        }
    }

    // ✅ Listar todas
    public List<Venta> listar() {
        List<Venta> lista = new ArrayList<>();
        String sql = "SELECT * FROM ventas";

        try {
            conexion = ConexionBD.conectar();
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Venta v = new Venta();
                v.setIdVenta(rs.getInt("id"));
                v.setFechaVenta(rs.getDate("fechaVenta"));
                v.setTotal(rs.getDouble("total"));

                // Si solo guardas FK en ventas, aquí podrías dejarlos nulos
                // (si quieres, luego te lo armo con JOIN para cargar Cliente/Usuario completos).
                v.setCliente(null);
                v.setUsuario(null);

                lista.add(v);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar ventas: " + e.getMessage());
        } finally {
            ConexionBD.desconectar(conexion);
        }

        return lista;
    }

    // ✅ Buscar por ID
    public Venta buscar(int id) {
        String sql = "SELECT * FROM ventas WHERE id = ?";
        Venta v = null;

        try {
            conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                v = new Venta();
                v.setIdVenta(rs.getInt("id"));
                v.setFechaVenta(rs.getDate("fechaVenta"));
                v.setTotal(rs.getDouble("total"));

                v.setCliente(null);
                v.setUsuario(null);
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar venta: " + e.getMessage());
        } finally {
            ConexionBD.desconectar(conexion);
        }

        return v;
    }

    // ✅ Actualizar
    public boolean actualizar(Venta venta) {
        String sql = "UPDATE ventas SET fechaVenta=?, total=?, idCliente=?, idUsuario=? WHERE id=?";

        try {
            conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setDate(1, new java.sql.Date(venta.getFechaVenta().getTime()));
            ps.setDouble(2, venta.getTotal());

            ps.setInt(3, venta.getCliente().getIdCliente());
            ps.setInt(4, venta.getUsuario().getIdUsuario());

            ps.setInt(5, venta.getIdVenta());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar venta: " + e.getMessage());
            return false;
        } finally {
            ConexionBD.desconectar(conexion);
        }
    }

    // ✅ Eliminar
    public boolean eliminar(int id) {
        String sql = "DELETE FROM ventas WHERE id = ?";

        try {
            conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar venta: " + e.getMessage());
            return false;
        } finally {
            ConexionBD.desconectar(conexion);
        }
    }
}
