package Servicio;

import dominio.Pelicula;

import java.io.*;

public class ServicioPeliculasArchivo implements IServicioPeliculas{

    private final String NOMBRE_ARCHIVO =  "Peliculas.txt";

    //contructor
    public ServicioPeliculasArchivo(){
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            //Si ya existe el archivo No se vuelve a crear
            if (archivo.exists()){
                System.out.println("El archivo ya existe");
            }
            else {
                //Si no existe se lo crea
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se ha creado el archivo");
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error al abrir el archivo: " + e.getMessage());
        }
    }


    @Override
    public void listarPeliculas() {
        // Volvemos a abrir el archivo
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            System.out.println("***Listado de Peliculas***");
            //Abrimos el archivo
            var entrada = new BufferedReader(new FileReader(archivo));
            //Leemos linea a linea el archivo
            String linea;
            linea = entrada.readLine();
            //Leemos todas las lineas disponibles
            while (linea!=null){
                var pelicula = new Pelicula(linea);
                System.out.println(pelicula);
                //Antes de terminar el ciclo volvemos a leer la sigueinte linea
                linea = entrada.readLine();
            }
            //cerra el archivo
            entrada.close();
        } catch (Exception e) {
            System.out.println("Ocurrio un error: " + e.getMessage());
        }
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        boolean anexar=false;
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            //Revisamos si existe archivo
            anexar=archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            //Agregar pelicula
            salida.println(pelicula);
            salida.close();
            System.out.println("Se agrego al archivo el nombre de la pelicula");
        } catch (Exception e) {
            System.out.println("Ocurrio un error al agregar pelicula: " + e.getMessage());
        }
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            //Abrimos el archivo para lectura linea a linea
            var entrada = new BufferedReader(new FileReader(archivo));
            String lineaTexto;
            lineaTexto = entrada.readLine();
            var indice = 1;
            boolean encontrada = false;
            var peliculaBuscar = pelicula.getNombre();

            while (lineaTexto != null){
             //Buscamo sin impportar mayusculas o minusculas
             if(peliculaBuscar != null && peliculaBuscar.equalsIgnoreCase(lineaTexto)){
                 encontrada = true;
                 break;
             }
             else {//Leemos la sigueinte linea antes de la sigueinte interacion
                lineaTexto = entrada.readLine();
                indice++;
             }
            }
            //Imprimimos los valores del resultado
            if(encontrada){
                System.out.println("Pelicula " + lineaTexto + " que se encuentra en " + indice);
            }else {
                System.out.println("No se encontro la pelicula " + pelicula.getNombre());
            }
            entrada.close();
        } catch (Exception e) {
            System.out.println("Ocurrio un error al buscar la pelicula: " + e.getMessage());
        }
    }
}
