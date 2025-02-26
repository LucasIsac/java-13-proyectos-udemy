package org.LR.datos;

import org.LR.conexion.Conexion;
import org.LR.dominio.Estudiante;
import static org.LR.conexion.Conexion.getConexion;

//import java.lang.classfile.attribute.ExceptionsAttribute;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO {
    //Listar estudiantes
    public List<Estudiante> listarEstudiantes(){
        List<Estudiante> estudiantes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM estudiante ORDER BY id_estudiante";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                var estudiante = new Estudiante();
                estudiante.setIdEstudiante(rs.getInt("id_estudiante"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                estudiantes.add(estudiante);
            }
        } catch (SQLException e) {
            System.out.println("Ocuriio un error al seleccionar datos: " + e.getMessage());
        }
        finally {
            try{
                con.close();
            } catch (Exception e) {
                System.out.println("Ocurrio un error al cerrar la conexion: " + e.getMessage());
            }
        }
        return estudiantes;
    }

    //Buscar Estudiante
    public boolean buscarEstudiantePorId(Estudiante estudiante){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM estudiante WHERE id_estudiante = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            rs = ps.executeQuery();
            if(rs.next()){
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                return true;
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error: " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Ocurrio un error al cerrar conexion: " + e.getMessage());
            }
        }
        return false;

    }

    //Agregar estudiante
    public boolean agregarEstuiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "INSERT INTO estudiante (nombre, apellido, telefono, email)" + "VALUES(?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al agregar estudiante: " + e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return false;

    }

    //Modificar estudiante
    public boolean modificarEstudinate(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConexion();
        ResultSet rs;
        String sql = "UPDATE estudiante SET nombre=?, apellido=?, telefono=?, email=? WHERE id_estudiante = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.setInt(5,estudiante.getIdEstudiante());
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("Error el modificar estudiante: " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Ocurrio un error al cerrar la conexion: " + e.getMessage());
            }
        }
        return false;
    }

    //Eliminar
    public boolean eliminarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "DELETE FROM estudiante WHERE id_estudiante=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Ocurrion un error al eliminar al estudiante: " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Ocurrio un error al cerrar la conexion: " + e.getMessage());
            }
        }
        return false;

    }

    public static void main(String[] args) {

        var estudianteDao = new EstudianteDAO();
       //Agregar estudiante
//        var nuevoEstudiante = new Estudiante("Carlos", "LAra", "343521", "carlos@gamil.com");
//        var agregado = estudianteDao.agregarEstuiante(nuevoEstudiante);
//        if (agregado)
//            System.out.println("Estudiante agregado: " + nuevoEstudiante);
//        else
//            System.out.println("No se pudo agregar el estudiante: " + nuevoEstudiante);
//
//        System.out.println();


        //Modificar
//        var estudianteModificar = new Estudiante(1, "Juan Carlos", "Juares", "34355325542", "juares@gmail.com");
//        var modificado = estudianteDao.modificarEstudinate(estudianteModificar);
//        if (modificado)
//            System.out.println("Estudiante modificado: " + estudianteModificar);
//        else
//            System.out.println("No se logro modificar el estudiante: " + estudianteModificar.getIdEstudiante());

        //Eliminar estudiante - id(3)
        var estudianteEliminar = new Estudiante(3);
        var eliminar = estudianteDao.eliminarEstudiante(estudianteEliminar);
        if(eliminar)
            System.out.println("El estudiante " + estudianteEliminar.getIdEstudiante() + " se ha eliminado");
        else
            System.out.println("El estudiante " + estudianteEliminar.getIdEstudiante() + "´no se pudo eliminar");

        System.out.println();

        //listamos los estudiantes
        System.out.println("Listado");
        List<Estudiante> estudiantes = estudianteDao.listarEstudiantes();
        estudiantes.forEach(System.out::println);

        // Buscar por Id
        var estudiante1 = new Estudiante(2);
        System.out.println("Estudiante antes de la busqueda: " + estudiante1);
        var encontrado = estudianteDao.buscarEstudiantePorId(estudiante1);
        if(encontrado)
            System.out.println("Estudinate encontrado: " + estudiante1);
        else
            System.out.println("Estudiante no encontrado: " +estudiante1.getIdEstudiante());
    }
}
