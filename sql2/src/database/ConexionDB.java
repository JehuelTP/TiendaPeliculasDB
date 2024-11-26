package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/TiendaPeliculasDB";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection conexion = null;

    // Obtener conexion
    public static Connection getConnection() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            try {
                conexion = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexion establecida.");
            } catch (SQLException e) {
                System.out.println("Error al conectar con la base de datos");
                throw e;
            }
        }
        return conexion;
    }

    // Metodo para cerrar la conexion
    public static void cerrarConexion() throws SQLException {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexion cerrada");
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexion");
                throw e;
            }
        }
    }
}
