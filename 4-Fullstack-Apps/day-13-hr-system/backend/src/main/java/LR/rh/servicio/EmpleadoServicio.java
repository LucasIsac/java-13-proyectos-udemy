package LR.rh.servicio;

import LR.rh.modelo.Empleado;
import LR.rh.repositorio.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServicio implements IEmpleadoServicio{
    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;

    @Override
    public List<Empleado> listarEmpleados() {
        return this.empleadoRepositorio.findAll();
    }

    @Override
    public Empleado buscarEmpleadoPorId(Integer idEmpleado) {
        Empleado empleado = this.empleadoRepositorio.findById(idEmpleado).orElse(null);
        return empleado;
    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepositorio.save(empleado);
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        this.empleadoRepositorio.delete(empleado);
    }
}
