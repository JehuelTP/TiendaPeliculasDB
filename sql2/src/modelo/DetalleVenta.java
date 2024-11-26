package modelo;

public class DetalleVenta {
    private int detalleVentaID;
    private int ventaID;
    private int peliculaID;
    private int cantidad;
    private double precioUnitario;

    public DetalleVenta(int detalleVentaID, int ventaID, int peliculaID, int cantidad, double precioUnitario) {
        this.detalleVentaID = detalleVentaID;
        this.ventaID = ventaID;
        this.peliculaID = peliculaID;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public int getDetalleVentaID() {
        return detalleVentaID;
    }

    public void setDetalleVentaID(int detalleVentaID) {
        this.detalleVentaID = detalleVentaID;
    }

    public int getVentaID() {
        return ventaID;
    }

    public void setVentaID(int ventaID) {
        this.ventaID = ventaID;
    }

    public int getPeliculaID() {
        return peliculaID;
    }

    public void setPeliculaID(int peliculaID) {
        this.peliculaID = peliculaID;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}
