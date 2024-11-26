package controlador;

import modelo.Venta;
import modelo.VentaDAO;
import vista.VentaVista;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class VentaControlador {
    private VentaDAO ventaDAO;
    private VentaVista ventaVista;

    public VentaControlador(VentaDAO ventaDAO, VentaVista ventaVista) {
        this.ventaDAO = ventaDAO;
        this.ventaVista = ventaVista;
    }

    public void listarVentas() {
        List<Venta> ventas = ventaDAO.obtenerVentas();
        ventaVista.mostrarVentas(ventas);
    }

    public void agregarVenta() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el ID del cliente: ");
        int clienteID = sc.nextInt();
        System.out.print("Ingrese la fecha de venta (YYYY-MM-DD): ");
        String fechaStr = sc.next();
        Date fechaVenta = java.sql.Date.valueOf(fechaStr);
        System.out.print("Ingrese el monto total: ");
        double montoTotal = sc.nextDouble();
        System.out.print("Ingrese el método de pago: ");
        String metodoPago = sc.next();
        ventaDAO.agregarVenta(clienteID, fechaVenta, montoTotal, metodoPago);
        System.out.println("Venta agregada con éxito.");
    }

    public void actualizarVenta() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el ID de la venta a actualizar: ");
        int ventaID = sc.nextInt();
        System.out.print("Ingrese el nuevo ID del cliente: ");
        int clienteID = sc.nextInt();
        System.out.print("Ingrese la nueva fecha de venta (YYYY-MM-DD): ");
        String fechaStr = sc.next();
        Date fechaVenta = java.sql.Date.valueOf(fechaStr);
        System.out.print("Ingrese el nuevo monto total: ");
        double montoTotal = sc.nextDouble();
        System.out.print("Ingrese el nuevo método de pago: ");
        String metodoPago = sc.next();
        ventaDAO.actualizarVenta(ventaID, clienteID, fechaVenta, montoTotal, metodoPago);
        System.out.println("Venta actualizada con éxito.");
    }

    public void eliminarVenta() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el ID de la venta a eliminar: ");
        int ventaID = sc.nextInt();
        ventaDAO.eliminarVenta(ventaID);
        System.out.println("Venta eliminada con éxito.");
    }
}