package LR.tienda_libros.servicio;

import LR.tienda_libros.modelo.Libro;

import java.util.List;

public interface ILibroServicio {
    public List<Libro> listarLibros();
    public Libro buscarLibroPorId(Integer idLibro);
    public void guardarLibro(Libro libro);
    public void eliminarLibro(Libro libro);
}
