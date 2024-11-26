package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VentaDAO {
    private Connection conexion;

    public VentaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public void agregarVenta(int clienteID, Date fechaVenta, double montoTotal, String metodoPago) throws SQLException {
        String sql = "INSERT INTO Venta(ClienteID, FechaVenta, MontoTotal, MetodoPago) VALUES(?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, clienteID);
            stmt.setDate(2, new java.sql.Date(fechaVenta.getTime()));
            stmt.setDouble(3, montoTotal);
            stmt.setString(4, metodoPago);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Venta> obtenerVentas() {
        List<Venta> ventas = new ArrayList<>();
        String sql = "SELECT VentaID, ClienteID, FechaVenta, MontoTotal, MetodoPago FROM Venta";
        try (PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int ventaID = resultSet.getInt("VentaID");
                int clienteID = resultSet.getInt("ClienteID");
                Date fechaVenta = resultSet.getDate("FechaVenta");
                double montoTotal = resultSet.getDouble("MontoTotal");
                String metodoPago = resultSet.getString("MetodoPago");
                Venta venta = new Venta(ventaID, clienteID, fechaVenta, montoTotal, metodoPago);
                ventas.add(venta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ventas;
    }

    public void actualizarVenta(int ventaID, int clienteID, Date fechaVenta, double montoTotal, String metodoPago) throws SQLException {
        String sql = "UPDATE Venta SET ClienteID = ?, FechaVenta = ?, MontoTotal = ?, MetodoPago = ? WHERE VentaID = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, clienteID);
            stmt.setDate(2, new java.sql.Date(fechaVenta.getTime()));
            stmt.setDouble(3, montoTotal);
            stmt.setString(4, metodoPago);
            stmt.setInt(5, ventaID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarVenta(int ventaID) throws SQLException {
        String sql = "DELETE FROM Venta WHERE VentaID = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, ventaID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}