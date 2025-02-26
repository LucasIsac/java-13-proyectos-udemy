package Servicio;

import dominio.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ServicioPeliculaLista implements IServicioPeliculas{

    private final List<Pelicula> peliculas;

    //constructor
    public ServicioPeliculaLista(){
        this.peliculas = new ArrayList<>();
    }

    @Override
    public void listarPeliculas() {
        System.out.println("Listado de Peliculas...");
        peliculas.forEach(System.out::println);
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Se agrego la pelicula: " + pelicula);
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        // Regresa el indice de la pelicula encontrada en la lista
        var indice = peliculas.indexOf(pelicula);
        if(indice==-1)
            System.out.println("No se encontro la pelicula: " + pelicula);
        else
            System.out.println("Pelicula encontrada en el indice: " + indice);
    }

    public static void main(String[] args) {
        var pelicula1 = new Pelicula("Batman");
        var pelicula2 = new Pelicula("Superman");
        // Creamos el servicio (patron de disenio service)
        IServicioPeliculas servicioPeliculas = new ServicioPeliculaLista();
        //  Agregamos las peliculas a las listas
        servicioPeliculas.agregarPelicula(pelicula1);
        servicioPeliculas.agregarPelicula(pelicula2);
        // Listamos als peliculas
        servicioPeliculas.listarPeliculas();
        // Buscamos una pelicula
        // se debe implementar el metodo de equals y hashcode
        servicioPeliculas.buscarPelicula(pelicula1);
    }
}
