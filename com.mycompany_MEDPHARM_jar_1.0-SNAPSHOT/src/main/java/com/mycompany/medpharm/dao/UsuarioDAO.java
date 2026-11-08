package com.mycompany.medpharm.dao;

import com.mycompany.medpharm.model.Usuario;
import Util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private Connection conexion;

    // ✅ Agregar usuario
    public boolean agregar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, apellido, correo, contrasena, telefono, rol) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getCorreo());
            ps.setString(4, usuario.getContrasena());
            ps.setString(5, usuario.getTelefono());
            ps.setString(6, usuario.getRol());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al agregar usuario: " + e.getMessage());
            return false;
        } finally {
            ConexionBD.desconectar(conexion);
        }
    }

    // ✅ Listar todos
    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try {
            conexion = ConexionBD.conectar();
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));
                u.setApellido(rs.getString("apellido"));
                u.setCorreo(rs.getString("correo"));
                u.setContrasena(rs.getString("contrasena"));
                u.setTelefono(rs.getString("telefono"));
                u.setRol(rs.getString("rol"));
                lista.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar usuarios: " + e.getMessage());
        } finally {
            ConexionBD.desconectar(conexion);
        }

        return lista;
    }

    // ✅ Buscar por ID
    public Usuario buscar(int id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        Usuario u = null;

        try {
            conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u = new Usuario();
                u.setIdUsuario(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));
                u.setApellido(rs.getString("apellido"));
                u.setCorreo(rs.getString("correo"));
                u.setContrasena(rs.getString("contrasena"));
                u.setTelefono(rs.getString("telefono"));
                u.setRol(rs.getString("rol"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar usuario: " + e.getMessage());
        } finally {
            ConexionBD.desconectar(conexion);
        }

        return u;
    }

    // ✅ Actualizar
    public boolean actualizar(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombre=?, apellido=?, correo=?, contrasena=?, telefono=?, rol=? WHERE id=?";
        try {
            conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getCorreo());
            ps.setString(4, usuario.getContrasena());
            ps.setString(5, usuario.getTelefono());
            ps.setString(6, usuario.getRol());
            ps.setInt(7, usuario.getIdUsuario());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario: " + e.getMessage());
            return false;
        } finally {
            ConexionBD.desconectar(conexion);
        }
    }

    // ✅ Eliminar
    public boolean eliminar(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try {
            conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
            return false;
        } finally {
            ConexionBD.desconectar(conexion);
        }
    }

    // ✅ Iniciar sesión (por correo y contraseña)
    public Usuario iniciarSesion(String correo, String contrasena) {
        String sql = "SELECT * FROM usuarios WHERE correo = ? AND contrasena = ?";
        Usuario u = null;

        try {
            conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, contrasena);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u = new Usuario();
                u.setIdUsuario(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));
                u.setApellido(rs.getString("apellido"));
                u.setCorreo(rs.getString("correo"));
                u.setContrasena(rs.getString("contrasena"));
                u.setTelefono(rs.getString("telefono"));
                u.setRol(rs.getString("rol"));
            }
        } catch (SQLException e) {
            System.out.println("Error al iniciar sesión: " + e.getMessage());
        } finally {
            ConexionBD.desconectar(conexion);
        }

        return u;
    }
}
