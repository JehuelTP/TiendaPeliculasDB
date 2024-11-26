package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetalleVentaDAO {
    private Connection conexion;

    public DetalleVentaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public void agregarDetalleVenta(int ventaID, int peliculaID, int cantidad, double precioUnitario) throws SQLException {
        String sql = "INSERT INTO DetalleVenta(VentaID, PeliculaID, Cantidad, PrecioUnitario) VALUES(?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, ventaID);
            stmt.setInt(2, peliculaID);
            stmt.setInt(3, cantidad);
            stmt.setDouble(4, precioUnitario);
            stmt.executeUpdate();
        }
    }

    public List<DetalleVenta> obtenerDetallesVenta() {
        List<DetalleVenta> detalles = new ArrayList<>();
        String sql = "SELECT DetalleVentaID, VentaID, PeliculaID, Cantidad, PrecioUnitario FROM DetalleVenta";
        try (PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int detalleVentaID = resultSet.getInt("DetalleVentaID");
                int ventaID = resultSet.getInt("VentaID");
                int peliculaID = resultSet.getInt("PeliculaID");
                int cantidad = resultSet.getInt("Cantidad");
                double precioUnitario = resultSet.getDouble("PrecioUnitario");
                DetalleVenta detalle = new DetalleVenta(detalleVentaID, ventaID, peliculaID, cantidad, precioUnitario);
                detalles.add(detalle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detalles;
    }
}