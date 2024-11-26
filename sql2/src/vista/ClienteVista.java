package vista;

import modelo.Cliente;
import java.util.List;

public class ClienteVista {
    public void mostrarClientes(List<Cliente> clientes) {
        System.out.println("\n *** Lista de Clientes ***");
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            System.out.printf("%5s %20s %20s %30s %15s %25s %20s\n", "ID", "NOMBRE", "APELLIDO", "EMAIL", "TELEFONO", "DIRECCION", "FECHA REGISTRO");
            for (Cliente cliente : clientes) {
                System.out.printf("%5d %20s %20s %30s %15s %25s %20s\n",
                        cliente.getClienteID(), cliente.getNombre(), cliente.getApellido(),
                        cliente.getEmail(), cliente.getTelefono(), cliente.getDireccion(),
                        cliente.getFechaRegistro());
            }
        }
    }
}
