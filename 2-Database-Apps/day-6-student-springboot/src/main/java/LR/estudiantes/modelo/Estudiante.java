package LR.estudiantes.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

@Entity
//boilerplate - codigo repetitivo(setter, getter...)
@Data // get, set
@NoArgsConstructor //constructor vacio
@AllArgsConstructor //constructor con todos los argumentos
@ToString


public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstudiante;

    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
}
