package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private Connection conexion;

    public ClienteDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public List<Cliente> obtenerClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT ClienteID, Nombre, Apellido, Email, Telefono, Direccion, FechaRegistro FROM Cliente";
        try (PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int clienteID = resultSet.getInt("ClienteID");
                String nombre = resultSet.getString("Nombre");
                String apellido = resultSet.getString("Apellido");
                String email = resultSet.getString("Email");
                String telefono = resultSet.getString("Telefono");
                String direccion = resultSet.getString("Direccion");
                String fechaRegistro = resultSet.getString("FechaRegistro");
                Cliente cliente = new Cliente(clienteID, nombre, apellido, email, telefono, direccion, fechaRegistro);
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public void agregarCliente(String nombre, String apellido, String email, String telefono, String direccion) throws SQLException {
        String sql = "INSERT INTO Cliente(Nombre, Apellido, Email, Telefono, Direccion) VALUES(?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, apellido);
            stmt.setString(3, email);
            stmt.setString(4, telefono);
            stmt.setString(5, direccion);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarCliente(int clienteID, String nombre, String apellido, String email, String telefono, String direccion) throws SQLException {
        String sql = "UPDATE Cliente SET Nombre = ?, Apellido = ?, Email = ?, Telefono = ?, Direccion = ? WHERE ClienteID = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, apellido);
            stmt.setString(3, email);
            stmt.setString(4, telefono);
            stmt.setString(5, direccion);
            stmt.setInt(6, clienteID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void borrarCliente(int clienteID) throws SQLException {
        String sql = "DELETE FROM Cliente WHERE ClienteID = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, clienteID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}