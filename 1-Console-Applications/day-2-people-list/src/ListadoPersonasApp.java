import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonasApp {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        //Definimos la lista uera del ciclo while
        List<Persona> personas = new ArrayList<>();

        //Menu
        var salir = false;
        while (!salir){
            mostrarMenu();
            try {
                salir = ejecutarOperacion(consola, personas);
            } catch (Exception e) {
                System.out.println("Ocurrio un error: " + e.getMessage());
            }
            System.out.println();

        }
    }

    private static void mostrarMenu(){
        System.out.println("""
                ****Listados Personas App****
                1. Agregar
                2. Listar
                3. Salir
                """);
        System.out.print("Proporciona una opcion: ");
    }

    private static boolean ejecutarOperacion(Scanner consola, List<Persona> personas){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        // Revisamos la opcion
        switch (opcion){
            case 1 ->{ //agregar persona
                System.out.print("Proporciona el nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Proporciona el telefono: ");
                var tel = consola.nextLine();
                System.out.print("Proporciona el email: ");
                var email = consola.nextLine();

                //constructor-objeto Persona
                var persona = new Persona(nombre, tel, email);

                //agragar a la lista
                personas.add(persona);
                System.out.println("La lista tiene: " + personas.size() + "elementos");
            }//fin caso 1
            case 2 ->{// Listar personas
                System.out.println("Listado de Personas: ");
                //Mejora usando lamba y metodo de referencia
                //personas.forEach((persona) -> System.out.println(persona));
                personas.forEach(System.out::println);
            }
            case 3 ->{
                System.out.println("Hasta Pronto...");
                salir = true;
            }
            default -> System.out.println("Opcon erronea: " + opcion);
        }// fin switch
        return salir;
    }
}