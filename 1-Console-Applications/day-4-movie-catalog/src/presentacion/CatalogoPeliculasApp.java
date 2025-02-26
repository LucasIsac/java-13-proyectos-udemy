package presentacion;

import Servicio.IServicioPeliculas;
import Servicio.ServicioPeliculaLista;
import Servicio.ServicioPeliculasArchivo;
import dominio.Pelicula;

import java.util.Scanner;


public class CatalogoPeliculasApp {
    public static void main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);

        //agregamos la implementacion del servicio
        //IServicioPeliculas servicioPeliculas = new ServicioPeliculaLista();
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasArchivo();

        while (!salir){
            try{
                mostrarMenu();
                salir = ejecutarOpciones( consola, servicioPeliculas);
            } catch (Exception e) {
                System.out.println("Ocurrio un error: " + e.getMessage());
            }
            System.out.println();
        }//Fin while

    }

    private static void mostrarMenu(){
        System.out.println("""
                ****Catalogo de Peliculas****
                1. Agregar Pelicula
                2. Listar Peliculas
                3. Busar Pelicula
                4. Salir
                """);
    }

    private static boolean ejecutarOpciones(Scanner consola,
                                            IServicioPeliculas servicioPeliculas){
        System.out.println("Selecciona una opcion: ");
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;

        switch (opcion){
            case 1 ->{
                System.out.println("Introduce el nombre de la pelicula: ");
                var nombrePelcula = consola.nextLine();
                servicioPeliculas.agregarPelicula(new Pelicula(nombrePelcula));
            }
            case 2 -> servicioPeliculas.listarPeliculas();
            case 3 ->{
                System.out.println("Introduce la pelicula a buscar: ");
                var buscar = consola.nextLine();
                servicioPeliculas.buscarPelicula(new Pelicula(buscar));
            }
            case 4 ->{
                System.out.println("Hasta pronto...");
                salir = true;
            }
            default -> System.out.println("Opcion incorrecta: " + opcion);
        }
        return salir;
    }
}