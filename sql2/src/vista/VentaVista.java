package vista;

import modelo.Venta;
import java.util.List;

public class VentaVista {
    public void mostrarVentas(List<Venta> ventas) {
        System.out.println("\n *** Lista de Ventas ***");
        if (ventas.isEmpty()) {
            System.out.println("No hay ventas registradas.");
        } else {
            System.out.printf("%5s %15s %15s %15s %15s\n", "ID", "ClienteID", "Fecha", "Monto", "Método");
            for (Venta venta : ventas) {
                System.out.printf("%5s %15s %15s %15s %15s\n",
                        venta.getVentaID(),
                        venta.getClienteID(),
                        venta.getFechaVenta(),
                        venta.getMontoTotal(),
                        venta.getMetodoPago());
            }
        }
    }
}
