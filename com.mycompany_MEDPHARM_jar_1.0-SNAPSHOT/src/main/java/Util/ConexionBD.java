package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/inventariomedpharm";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "";

    public static Connection conectar() {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            System.out.println("✅ Conexión exitosa a la base de datos");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("❌ Error de conexión: " + e.getMessage());
        }
        return conexion;
    }

    public static void desconectar(Connection conexion) {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("🔌 Conexión cerrada");
            }
        } catch (SQLException e) {
            System.out.println("⚠️ Error al cerrar: " + e.getMessage());
        }
    }
}
