package LR.rh.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecursoNoEnocontradoExcepcion extends RuntimeException {
    public RecursoNoEnocontradoExcepcion(String mensaje){
        super(mensaje);
    }
}
