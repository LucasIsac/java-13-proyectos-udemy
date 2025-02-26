
import java.util.Scanner;

public class CalculaoraApp {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);

        while (true) {
            System.out.println("*** Aplicacion Calculadora ***");
            //Menu
            mostrarMenu();
            try {
                var operacion = Integer.parseInt(consola.nextLine());

                //revisar operacion seleccionada
                if (operacion >= 1 && operacion <= 4) {
                    //Ejecutar operacion deseada
                    ejecutarOperacion(operacion, consola);
                } else if (operacion == 5) {//Salir
                    System.out.println("Hasta Pronto...");
                    break;
                } else {
                    System.out.println("Opcion erronea: " + operacion);
                }
                System.out.println();
            } catch (Exception e){
                System.out.println("Ocurrio un error" + e.getMessage());
            }
        }//fin de while
    }

    private static void mostrarMenu(){
        //Menu
        System.out.println("""
                    1. Suma
                    2. Resta
                    3. Multiplicacion
                    4. Division
                    5. Salir
                    """);

        System.out.print("Operacion a realizar: ");
    }

    private static void ejecutarOperacion(int operacion, Scanner consola){

            System.out.print("Proporcione el valor del operando 1: ");
            var operando1 = Double.parseDouble(consola.nextLine());
            System.out.print("Proporcione el valor del operando 2: ");
            var operadno2 = Double.parseDouble(consola.nextLine());
            double resultado;
            switch (operacion) {
                case 1 -> {//Suma
                    resultado = operando1 + operadno2;
                    System.out.println("La Suma es: " + resultado);
                }
                case 2 -> {//Resta
                    resultado = operando1 - operadno2;
                    System.out.println("La Resta es: " + resultado);
                }
                case 3 -> {//Multiplicacion
                    resultado = operando1 * operadno2;
                    System.out.println("La Mltiplicacion es: " + resultado);
                }
                case 4 -> {//Division
                    resultado = operando1 / operadno2;
                    System.out.println("La Division es: " + resultado);
                }
                default -> System.out.println("Operacion erronea: " + operacion);

            }
    }
}
