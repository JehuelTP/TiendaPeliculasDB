package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDAO {
    private Connection conexion;

    public PeliculaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public List<Pelicula> obtenerPeliculas() {
        List<Pelicula> peliculas = new ArrayList<>();
        String sql = "SELECT PeliculaID, Titulo, Genero, AñoLanzamiento, Clasificación, Duracion, PrecioVenta, Stock FROM Pelicula";
        try (PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int peliculaID = resultSet.getInt("PeliculaID");
                String titulo = resultSet.getString("Titulo");
                String genero = resultSet.getString("Genero");
                int añoLanzamiento = resultSet.getInt("AñoLanzamiento");
                String clasificacion = resultSet.getString("Clasificación");
                int duracion = resultSet.getInt("Duracion");
                double precioVenta = resultSet.getDouble("PrecioVenta");
                int stock = resultSet.getInt("Stock");
                Pelicula pelicula = new Pelicula(peliculaID, titulo, genero, añoLanzamiento, clasificacion, duracion, precioVenta, stock);
                peliculas.add(pelicula);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peliculas;
    }

    public void agregarPelicula(String titulo, String genero, int anioLanzamiento, String clasificacion, int duracion, double precioVenta, int stock) throws SQLException {
        String sql = "INSERT INTO Pelicula(Titulo, Genero, AñoLanzamiento, Clasificación, Duracion, PrecioVenta, Stock) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, titulo);
            stmt.setString(2, genero);
            stmt.setInt(3, anioLanzamiento);
            stmt.setString(4, clasificacion);
            stmt.setInt(5, duracion);
            stmt.setDouble(6, precioVenta);
            stmt.setInt(7, stock);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarPelicula(int peliculaID, String titulo, String genero, int anioLanzamiento, String clasificacion, int duracion, double precioVenta, int stock) throws SQLException {
        String sql = "UPDATE Pelicula SET Titulo = ?, Genero = ?, AñoLanzamiento = ?, Clasificación = ?, Duracion = ?, PrecioVenta = ?, Stock = ? WHERE PeliculaID = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, titulo);
            stmt.setString(2, genero);
            stmt.setInt(3, anioLanzamiento);
            stmt.setString(4, clasificacion);
            stmt.setInt(5, duracion);
            stmt.setDouble(6, precioVenta);
            stmt.setInt(7, stock);
            stmt.setInt(8, peliculaID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void añadirStock(int peliculaID, int cantidad) throws SQLException {
        String sql = "UPDATE Pelicula SET Stock = Stock + ? WHERE PeliculaID = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, cantidad);
            stmt.setInt(2, peliculaID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void borrarPelicula(int peliculaID) throws SQLException {
        String sql = "DELETE FROM Pelicula WHERE PeliculaID = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, peliculaID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}