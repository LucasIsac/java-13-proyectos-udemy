package org.LR.presentacion;

import org.LR.datos.EstudianteDAO;
import org.LR.dominio.Estudiante;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class SistemaEstudiantesApp {
    public static void main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);
        var estudianteDao = new EstudianteDAO();
        while (!salir){
            mostraMenu();
            try{
                salir = ejecutarOperacion(consola, estudianteDao);
            }catch (Exception e){
                System.out.println("No se pudo relaizar la operacion: " + e.getMessage());
            }
            System.out.println();
        }

    }

    private static void mostraMenu(){
        System.out.println("""
                ****Lista de Opciones
                1.Listar Estudiantes
                2.Buscar Estudiante
                3.Agregar Estudiante
                4.Modificar Estudiante
                5.Eliminar Estudiante
                6.salir
                """);
        System.out.print("Proporciona la operacion: ");
    }

    private static boolean ejecutarOperacion(Scanner consola, EstudianteDAO estudianteDAO){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;

        switch (opcion){
            case 1 ->{
                System.out.println("****Listado de Estudiantes****");
                var estudiantes = estudianteDAO.listarEstudiantes();
                estudiantes.forEach(System.out::println);
            }
            case 2 ->{
                System.out.println("****Buscar Estudiante****");
                System.out.print("Proporcione el id del estudiante: ");
                var estudianteBuscar = new Estudiante(Integer.parseInt(consola.nextLine()));
                var encontrado = estudianteDAO.buscarEstudiantePorId(estudianteBuscar);
                if (encontrado)
                    System.out.println("El estudiante es: " + estudianteBuscar);
                else
                    System.out.println("El estudiante no se ha encontrado");
            }
            case 3 ->{
                System.out.println("****Agregar Estudiante****");
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Telefono: ");
                var telefono = consola.nextLine();
                System.out.print("Email: ");
                var email = consola.nextLine();

                var nuevoEstudiante = new Estudiante(nombre, apellido, telefono, email);
                var agregar = estudianteDAO.agregarEstuiante(nuevoEstudiante);
                if (agregar)
                    System.out.println("El estudiante se agrego: " + nuevoEstudiante);
                else
                    System.out.println("Ocurrio un prblema al agregar el estudiante");

            }
            case 4 ->{

                System.out.println("****Ingrese los valores para Modificar****");
                System.out.print("ID:");
                var id = Integer.parseInt(consola.nextLine());
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Telefono: ");
                var telefono = consola.nextLine();
                System.out.print("Email: ");
                var email = consola.nextLine();

                var estudianteModificar = new Estudiante(id, nombre, apellido, telefono, email);
                var modificado = estudianteDAO.modificarEstudinate(estudianteModificar);
                if(modificado)
                    System.out.println("El estudiante se ha modificado: " + estudianteModificar);
                else
                    System.out.println("Error al modificar estudiante");
            }
            case 5 ->{
                System.out.println("****Eliminar Estudiante****");
                System.out.print("Ingrese el ID del estudiante: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());

                var estudianteEliminar = new Estudiante(idEstudiante);
                var eliminar = estudianteDAO.eliminarEstudiante(estudianteEliminar);
                if (eliminar)
                    System.out.println("El estudiante se ha eliminado corectamente");
                else
                    System.out.println("Error al eliminar al estudiante de id: " + idEstudiante);
            }
            case 6 ->{
                salir=true;
                System.out.println("Hasta Pronto...");
            }
            default -> System.out.println("Ocurrio un error");
        }
        return salir;
    }
}