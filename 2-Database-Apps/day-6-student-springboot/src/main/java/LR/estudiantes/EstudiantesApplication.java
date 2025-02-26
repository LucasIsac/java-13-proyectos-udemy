package LR.estudiantes;

import LR.estudiantes.modelo.Estudiante;

import LR.estudiantes.servicio.EstudianteServicio;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class EstudiantesApplication implements CommandLineRunner {
	@Autowired
	private EstudianteServicio estudianteServicio;
	private static Logger logger = LoggerFactory.getLogger(EstudiantesApplication.class);

	String nl = System.lineSeparator();
	public static void main(String[] args) {
		logger.info("Iniciando la aplicacion...");
		// Levantar la fabrica de spring
		SpringApplication.run(EstudiantesApplication.class, args);
		logger.info("Aplicacion finalizada!");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(nl + "Ejecuntando metodo run de Spring...." + nl);
		var salir = false;
		var consola = new Scanner(System.in);
		while (!salir){
			mostrarMenu();
			salir = ejecutarOperacion(consola);
			logger.info(nl);
		}
	}

	private void mostrarMenu(){
		logger.info(nl);
		logger.info("""
                ****Lista de Opciones
                1.Listar Estudiantes
                2.Buscar Estudiante
                3.Agregar Estudiante
                4.Modificar Estudiante
                5.Eliminar Estudiante
                6.salir
                """);
		logger.info("Proporciona la operacion: ");
	}

	private boolean ejecutarOperacion(Scanner consola){
		var opcion = Integer.parseInt(consola.nextLine());
		var  salir = false;
		switch (opcion){
			case 1 ->{//Listar
				logger.info(nl + "****Listado de Estudiantes****" + nl);
				List<Estudiante> estudiantes = estudianteServicio.listarEstudiantes();
				estudiantes.forEach(estudiante -> logger.info(estudiante.toString() + nl));
			}
			case 2->{//Buscar
				logger.info(nl + "****Buscar Estdiante**** " + nl);
				logger.info("Introduce el id del estudiante a buscar: ");
				var idEstudiante = Integer.parseInt(consola.nextLine());
				Estudiante estudiante = estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if ( estudiante != null)
					logger.info("Se encontro el estudiante: " + estudiante);
				else
					logger.info("No se logro encontrar al estudiante de id: " + idEstudiante);
			}
			case 3 ->{// Agregar
				logger.info(nl + "****Agregar Estudiante****" + nl);
				logger.info("Nombre: ");
				var nombre = consola.nextLine();
				logger.info("Apellido: ");
				var apellido = consola.nextLine();
				logger.info("Telefono: ");
				var telefono = consola.nextLine();
				logger.info("Email: ");
				var email = consola.nextLine();
				//constructor vacio
				var estudiante = new Estudiante();
				estudiante.setNombre(nombre);
				estudiante.setApellido(apellido);
				estudiante.setTelefono(telefono);
				estudiante.setEmail(email);
				estudianteServicio.guardarEstudiante(estudiante);

				logger.info("Se logro agregar al estudiante:  " + estudiante + nl);

			}
			case 4 ->{//Modificar
				logger.info(nl + "****Modificar Estudiante****" + nl);
				logger.info("Ingrese el ID: ");
				var idEstudiante = Integer.parseInt(consola.nextLine());
				Estudiante estudiante = estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if (estudiante != null){
					logger.info("Nombre: ");
					var nombre = consola.nextLine();
					logger.info("Apellido: ");
					var apellido = consola.nextLine();
					logger.info("Telefono: ");
					var telefono = consola.nextLine();
					logger.info("Email: ");
					var email = consola.nextLine();
					estudiante.setNombre(nombre);
					estudiante.setApellido(apellido);
					estudiante.setTelefono(telefono);
					estudiante.setEmail(email);
					estudianteServicio.guardarEstudiante(estudiante);
					logger.info("Estudiante modificado: " + estudiante + nl);
				}else {
					logger.info("Estudiante no encontrado con ID: " + idEstudiante +nl);
				}
			}
			case 5 ->{//Elimniar
				logger.info(nl + "****Eliminar Estudiante****" + nl);
				logger.info("Ingres el ID: ");
				var idEstudiante = Integer.parseInt(consola.nextLine());
				//Buscar el estudiante por ir
				var estudiante = estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if (estudiante != null){
					estudianteServicio.eliminarEstudiante(estudiante);
					logger.info("Estudiante eliminado: " + estudiante +nl);
				}else {
					logger.info("Estudiante no encontrado con ID: " + idEstudiante);
				}
			}
			case 6->{
				salir=true;
				logger.info("Hasta Pronto..." +nl+nl);
			}
			default -> logger.info("Opcion no reconocida: " +opcion + nl);
		}
		return salir;
	}
}
