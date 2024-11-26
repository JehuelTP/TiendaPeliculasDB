package modelo;

public class Pelicula {
    private int peliculaID;
    private String titulo;
    private String genero;
    private int añoLanzamiento;
    private String clasificacion;
    private int duracion;
    private double precioVenta;
    private int stock;

    public Pelicula(int peliculaID, String titulo, String genero, int añoLanzamiento, String clasificacion, int duracion, double precioVenta, int stock) {
        this.peliculaID = peliculaID;
        this.titulo = titulo;
        this.genero = genero;
        this.añoLanzamiento = añoLanzamiento;
        this.clasificacion = clasificacion;
        this.duracion = duracion;
        this.precioVenta = precioVenta;
        this.stock = stock;
    }


    public int getPeliculaID() {
        return peliculaID;
    }

    public void setPeliculaID(int peliculaID) {
        this.peliculaID = peliculaID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAñoLanzamiento() {
        return añoLanzamiento;
    }

    public void setAñoLanzamiento(int añoLanzamiento) {
        this.añoLanzamiento = añoLanzamiento;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}