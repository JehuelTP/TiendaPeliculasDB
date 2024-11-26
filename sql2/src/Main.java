import controlador.ClienteControlador;
import controlador.PeliculaControlador;
import controlador.VentaControlador;
import database.ConexionDB;
import modelo.ClienteDAO;
import modelo.PeliculaDAO;
import modelo.VentaDAO;
import vista.ClienteVista;
import vista.PeliculaVista;
import vista.VentaVista;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conexion = ConexionDB.getConnection();
            ClienteDAO clienteDAO = new ClienteDAO(conexion);
            ClienteVista clienteVista = new ClienteVista();
            ClienteControlador clienteControlador = new ClienteControlador(clienteDAO, clienteVista);
            PeliculaDAO peliculaDAO = new PeliculaDAO(conexion);
            PeliculaVista peliculaVista = new PeliculaVista();
            PeliculaControlador peliculaControlador = new PeliculaControlador(peliculaDAO, peliculaVista);
            VentaDAO ventaDAO = new VentaDAO(conexion);
            VentaVista ventaVista = new VentaVista();
            VentaControlador ventaControlador = new VentaControlador(ventaDAO, ventaVista);
            Scanner scanner = new Scanner(System.in);
            int opcion;
            do {
                System.out.println("\n === Menú de Gestión ===");
                System.out.println("1. Gestión de Clientes");
                System.out.println("2. Gestión de Películas");
                System.out.println("3. Gestión de Ventas");
                System.out.println("0. Salir");
                System.out.print("Selecciona una opción: ");
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        int opcionCliente;
                        do {
                            System.out.println("\n === Menú de Gestión de Clientes ===");
                            System.out.println("1. Mostrar clientes");
                            System.out.println("2. Agregar cliente");
                            System.out.println("3. Actualizar cliente");
                            System.out.println("4. Borrar cliente");
                            System.out.println("0. Regresar");
                            System.out.print("Selecciona una opción: ");
                            opcionCliente = scanner.nextInt();
                            switch (opcionCliente) {
                                case 1:
                                    clienteControlador.listarClientes();
                                    break;
                                case 2:
                                    clienteControlador.agregarCliente();
                                    break;
                                case 3:
                                    clienteControlador.actualizarCliente();
                                    break;
                                case 4:
                                    clienteControlador.borrarCliente();
                                    break;
                                case 0:
                                    break;
                                default:
                                    System.out.println("Opción no válida. Intente de nuevo.");
                                    break;
                            }
                        } while (opcionCliente != 0);
                        break;
                    case 2:
                        int opcionPelicula;
                        do {
                            System.out.println("\n === Menú de Gestión de Películas ===");
                            System.out.println("1. Mostrar películas");
                            System.out.println("2. Agregar película");
                            System.out.println("3. Actualizar película");
                            System.out.println("4. Añadir stock");
                            System.out.println("5. Borrar película");
                            System.out.println("0. Regresar");
                            System.out.print("Selecciona una opción: ");
                            opcionPelicula = scanner.nextInt();
                            switch (opcionPelicula) {
                                case 1:
                                    peliculaControlador.listarPeliculas();
                                    break;
                                case 2:
                                    peliculaControlador.agregarPelicula();
                                    break;
                                case 3:
                                    peliculaControlador.actualizarPelicula();
                                    break;
                                case 4:
                                    peliculaControlador.añadirStock();
                                    break;
                                case 5:
                                    peliculaControlador.borrarPelicula();
                                    break;
                                case 0:
                                    break;
                                default:
                                    System.out.println("Opción no válida. Intente de nuevo.");
                                    break;
                            }
                        } while (opcionPelicula != 0);
                        break;
                    case 3:
                        int opcionVenta;
                        do {
                            System.out.println("\n === Menú de Gestión de Ventas ===");
                            System.out.println("1. Mostrar ventas");
                            System.out.println("2. Agregar venta");
                            System.out.println("3. Actualizar venta");
                            System.out.println("4. Eliminar venta");
                            System.out.println("0. Regresar");
                            System.out.print("Selecciona una opción: ");
                            opcionVenta = scanner.nextInt();
                            switch (opcionVenta) {
                                case 1:
                                    ventaControlador.listarVentas();
                                    break;
                                case 2:
                                    ventaControlador.agregarVenta();
                                    break;
                                case 3:
                                    ventaControlador.actualizarVenta();
                                    break;
                                case 4:
                                    ventaControlador.eliminarVenta();
                                    break;
                                case 0:
                                    break;
                                default:
                                    System.out.println("Opción no válida. Intente de nuevo.");
                                    break;
                            }
                        } while (opcionVenta != 0);
                        break;
                    case 0:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        break;
                }
            } while (opcion != 0);
            ConexionDB.cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
