package controlador;

import modelo.Cliente;
import modelo.ClienteDAO;
import vista.ClienteVista;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ClienteControlador {
    private ClienteDAO clienteDAO;
    private ClienteVista clienteVista;

    public ClienteControlador(ClienteDAO clienteDAO, ClienteVista clienteVista) {
        this.clienteDAO = clienteDAO;
        this.clienteVista = clienteVista;
    }

    public void listarClientes() {
        List<Cliente> clientes = clienteDAO.obtenerClientes();
        clienteVista.mostrarClientes(clientes);
    }

    public void agregarCliente() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Ingrese el email: ");
        String email = sc.nextLine();
        System.out.print("Ingrese el teléfono: ");
        String telefono = sc.nextLine();
        System.out.print("Ingrese la dirección: ");
        String direccion = sc.nextLine();
        clienteDAO.agregarCliente(nombre, apellido, email, telefono, direccion);
        System.out.println("Cliente agregado con éxito.");
    }

    public void actualizarCliente() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el ID del cliente a actualizar: ");
        int clienteID = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese el nuevo nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el nuevo apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Ingrese el nuevo email: ");
        String email = sc.nextLine();
        System.out.print("Ingrese el nuevo teléfono: ");
        String telefono = sc.nextLine();
        System.out.print("Ingrese la nueva dirección: ");
        String direccion = sc.nextLine();
        clienteDAO.actualizarCliente(clienteID, nombre, apellido, email, telefono, direccion);
        System.out.println("Cliente actualizado con éxito.");
    }

    public void borrarCliente() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el ID del cliente a borrar: ");
        int clienteID = sc.nextInt();
        clienteDAO.borrarCliente(clienteID);
        System.out.println("Cliente borrado con éxito.");
    }
}
