package controlador;

import modelo.Pelicula;
import modelo.PeliculaDAO;
import vista.PeliculaVista;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PeliculaControlador {
    private PeliculaDAO peliculaDAO;
    private PeliculaVista peliculaVista;

    public PeliculaControlador(PeliculaDAO peliculaDAO, PeliculaVista peliculaVista) {
        this.peliculaDAO = peliculaDAO;
        this.peliculaVista = peliculaVista;
    }

    public void listarPeliculas() {
        List<Pelicula> peliculas = peliculaDAO.obtenerPeliculas();
        peliculaVista.mostrarPeliculas(peliculas);
    }

    public void agregarPelicula() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el título de la película: ");
        String titulo = sc.nextLine();
        System.out.print("Ingrese el género: ");
        String genero = sc.nextLine();
        System.out.print("Ingrese el año de lanzamiento: ");
        int anioLanzamiento = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese la clasificación: ");
        String clasificacion = sc.nextLine();
        System.out.print("Ingrese la duración: ");
        int duracion = sc.nextInt();
        System.out.print("Ingrese el precio de venta: ");
        double precioVenta = sc.nextDouble();
        System.out.print("Ingrese el stock: ");
        int stock = sc.nextInt();
        peliculaDAO.agregarPelicula(titulo, genero, anioLanzamiento, clasificacion, duracion, precioVenta, stock);
        System.out.println("Película agregada con éxito.");
    }

    public void actualizarPelicula() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el ID de la película a actualizar: ");
        int peliculaID = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese el nuevo título: ");
        String titulo = sc.nextLine();
        System.out.print("Ingrese el nuevo género: ");
        String genero = sc.nextLine();
        System.out.print("Ingrese el nuevo año de lanzamiento: ");
        int anioLanzamiento = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese la nueva clasificación: ");
        String clasificacion = sc.nextLine();
        System.out.print("Ingrese la nueva duración: ");
        int duracion = sc.nextInt();
        System.out.print("Ingrese el nuevo precio de venta: ");
        double precioVenta = sc.nextDouble();
        System.out.print("Ingrese el nuevo stock: ");
        int stock = sc.nextInt();
        peliculaDAO.actualizarPelicula(peliculaID, titulo, genero, anioLanzamiento, clasificacion, duracion, precioVenta, stock);
        System.out.println("Película actualizada con éxito.");
    }


    public void añadirStock() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el ID de la película para añadir stock: ");
        int peliculaID = sc.nextInt();
        System.out.print("Ingrese la cantidad a añadir: ");
        int cantidad = sc.nextInt();
        peliculaDAO.añadirStock(peliculaID, cantidad);
        System.out.println("Stock añadido con éxito.");
    }

    public void borrarPelicula() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el ID de la película a borrar: ");
        int peliculaID = sc.nextInt();
        peliculaDAO.borrarPelicula(peliculaID);
        System.out.println("Película borrada con éxito.");
    }
}