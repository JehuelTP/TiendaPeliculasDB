package vista;

import modelo.Pelicula;
import java.util.List;

public class PeliculaVista {
    public void mostrarPeliculas(List<Pelicula> peliculas) {
        System.out.println("\n *** Lista de Películas ***");
        if (peliculas.isEmpty()) {
            System.out.println("No hay películas registradas.");
        } else {
            System.out.printf("%5s %20s %15s %15s %15s %10s %10s %10s\n", "ID", "TITULO", "GENERO", "AÑO", "CLASIFICACION", "DURACION", "PRECIO", "STOCK");
            for (Pelicula pelicula : peliculas) {
                System.out.printf("%5d %20s %15s %15d %15s %10d %10.2f %10d\n",
                        pelicula.getPeliculaID(), pelicula.getTitulo(), pelicula.getGenero(),
                        pelicula.getAñoLanzamiento(), pelicula.getClasificacion(), pelicula.getDuracion(),
                        pelicula.getPrecioVenta(), pelicula.getStock());
            }
        }
    }
}
