package modelo;

import java.util.Date;

public class Venta {
    private int ventaID;
    private int clienteID;
    private Date fechaVenta;
    private double montoTotal;
    private String metodoPago;

    public Venta(int ventaID, int clienteID, Date fechaVenta, double montoTotal, String metodoPago) {
        this.ventaID = ventaID;
        this.clienteID = clienteID;
        this.fechaVenta = fechaVenta;
        this.montoTotal = montoTotal;
        this.metodoPago = metodoPago;
    }


    public int getVentaID() {
        return ventaID;
    }

    public void setVentaID(int ventaID) {
        this.ventaID = ventaID;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
}
