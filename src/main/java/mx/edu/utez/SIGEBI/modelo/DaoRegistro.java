package mx.edu.utez.SIGEBI.modelo;

import mx.edu.utez.SIGEBI.util.ConnectionMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoRegistro {

    public static boolean registrar(String nombre, String primerApellido, String segundoApellido, String correo, String estado, int idDivision, int tipoRol) {

        try (Connection con = ConnectionMySQL.getConnection();){
            try(PreparedStatement pstm = con.prepareStatement("Insert into usuarios (nombre, primer_apellido, segundo_apellido, clave, correo, estado, id_division, tipo_rol) values (?, ?, ?, substring(MD5(RAND()),1,7), ?, ?, ?, ?); ");) {
                pstm.setString(1, nombre);
                pstm.setString(2, primerApellido);
                pstm.setString(3, segundoApellido);
                pstm.setString(4, correo);
                pstm.setString(5, estado);
                pstm.setInt(6, tipoRol);
                pstm.setInt(7, idDivision);
                return pstm.executeUpdate() == 1;
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }



    public static boolean registrarAlumno(int idUsuario, String matricula, String fechaNacimiento, String telefono, String celular, String curp, String nivelAcademico, String carrera, String turno, String sexo, String nacionalidad, String colonia, String numeroInt, String numeroExt, String entidadFederativa, String delegacion, String codigoPostal, String calle, int idDivision ) {

        try (Connection con = ConnectionMySQL.getConnection();){
            try(PreparedStatement pstm = con.prepareStatement(
                    "Insert into alumnos (matricula, id_alumno, fecha_nacimiento, telefono, celular, curp, nivel_academico, carrera, turno, sexo, nacionalidad, colonia, num_interior, num_exterior, entidad_federativa, delegacion, codigo_postal, calle, id_division) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ");) {
                pstm.setString(1, matricula);
                pstm.setInt(2, idUsuario);
                pstm.setString(3, fechaNacimiento);
                pstm.setString(4, telefono);
                pstm.setString(5, celular);
                pstm.setString(6, curp);
                pstm.setString(7, nivelAcademico);
                pstm.setString(8, carrera);
                pstm.setString(9, turno);
                pstm.setString(10, sexo);
                pstm.setString(11, nacionalidad);
                pstm.setString(12, colonia);
                pstm.setString(13, numeroInt);
                pstm.setString(14, numeroExt);
                pstm.setString(15, entidadFederativa);
                pstm.setString(16, delegacion);
                pstm.setString(17, codigoPostal);
                pstm.setString(18, calle);
                pstm.setInt(19, idDivision);


                return pstm.executeUpdate() == 1;
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }

    public BeanUsuarios obtenerUsuario(String correo) {
        BeanUsuarios datosUsuario = new BeanUsuarios();

        try (Connection con = ConnectionMySQL.getConnection();){
            try(PreparedStatement pstm = con.prepareStatement("SELECT * FROM usuarios where correo = ?; ");) {
                pstm.setString(1, correo);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()){
                    datosUsuario.setIdUsuario(rs.getInt("id_usuario"));
                    System.out.println("Id_usuario: " + rs.getInt("id_usuario"));

                    datosUsuario.setCorreo(rs.getString("correo"));
                    System.out.println("Correo: " + rs.getString("correo"));

                    datosUsuario.setClave(rs.getString("clave"));
                    System.out.println("Clave: " + rs.getString("clave"));

                    datosUsuario.setNombre(rs.getString("nombre"));
                    System.out.println("Nombre: " + rs.getString("nombre"));

                    datosUsuario.setRol(rs.getInt("tipo_rol"));
                    System.out.println("Tipo rol: " + rs.getInt("tipo_rol"));

                    datosUsuario.setIdDivisionAcademica(rs.getInt("id_division"));
                    System.out.println("Division: " + rs.getInt("id_division"));
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return  datosUsuario;
    }
}
