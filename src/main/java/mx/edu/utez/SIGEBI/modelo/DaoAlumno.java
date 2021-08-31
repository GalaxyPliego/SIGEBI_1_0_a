package mx.edu.utez.SIGEBI.modelo;

import mx.edu.utez.SIGEBI.util.ConnectionMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoAlumno {

    public BeanAlumnos getAlumnoData(int id_alumno) {
        BeanAlumnos alumnoInformacion = new BeanAlumnos();


        try(Connection con = ConnectionMySQL.getConnection();){
            try(PreparedStatement pstm = con.prepareStatement("select * from alumnos where id_alumno = ?;");){
                pstm.setInt(1, id_alumno);
                ResultSet rs = pstm.executeQuery();

                if(rs.next()){
                    alumnoInformacion.setIdAlumno(rs.getInt("id_alumno"));
                    alumnoInformacion.setMatricula(rs.getString("matricula"));

                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return alumnoInformacion;
    }

    public List<BeanAlumnos> listAlumnos(){
        List<BeanAlumnos> listaAlumnos = new ArrayList<>();
        try (Connection con = ConnectionMySQL.getConnection();
             Statement stm = con.createStatement();
             ResultSet rs = stm.executeQuery("SELECT * FROM alumnos JOIN usuarios WHERE id_alumno = id_usuario;")
        ){
            while (rs.next()){
                BeanAlumnos beanAlumno = new BeanAlumnos();
                beanAlumno.setMatricula(rs.getString("matricula"));
                beanAlumno.setIdAlumno(rs.getInt("id_alumno"));
                beanAlumno.setFechaNacimiento(rs.getString("fecha_nacimiento"));
                beanAlumno.setTelefono(rs.getString("telefono"));
                beanAlumno.setCelular(rs.getString("celular"));
                beanAlumno.setCurp(rs.getString("curp"));
                beanAlumno.setNivelAcademico(rs.getString("nivel_academico"));
                beanAlumno.setIdCarrera(rs.getInt("carrera"));
                beanAlumno.setTurno(rs.getString("turno"));
                beanAlumno.setSexo(rs.getString("sexo"));
                beanAlumno.setNacionalidad(rs.getString("nacionalidad"));
                beanAlumno.setColonia(rs.getString("colonia"));
                beanAlumno.setNumInterior(rs.getString("num_interior"));
                beanAlumno.setNumExterior(rs.getString("num_exterior"));
                beanAlumno.setEntidadFederativa(rs.getString("entidad_federativa"));
                beanAlumno.setDelegacion(rs.getString("delegacion"));
                beanAlumno.setCodigoPostal(rs.getString("codigo_postal"));
                beanAlumno.setCalle(rs.getString("calle"));
                beanAlumno.setIdDivisionAcademica(rs.getInt("id_division"));

                beanAlumno.setNombre(rs.getString("nombre"));
                beanAlumno.setPrimerApellido(rs.getString("primer_apellido"));
                beanAlumno.setSegundoApellido(rs.getString("segundo_apellido"));
                beanAlumno.setEstado(rs.getString("estado"));

                listaAlumnos.add(beanAlumno);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return listaAlumnos;
    }

    public BeanAlumnos encontrarporId(int idAlumno) {
        BeanAlumnos alumno = new BeanAlumnos();
        try (Connection con = new ConnectionMySQL().getConnection();){
            try(PreparedStatement pstm = con.prepareStatement("SELECT * FROM alumnos JOIN usuarios WHERE id_alumno = ? AND id_usuario = ?;")){
                pstm.setInt(1, idAlumno);
                pstm.setInt(2, idAlumno);
                ResultSet rs = pstm.executeQuery();
                if (rs.next()){
                    alumno.setMatricula(rs.getString("matricula"));
                    alumno.setIdAlumno(rs.getInt("id_alumno"));
                    alumno.setFechaNacimiento(rs.getString("fecha_nacimiento"));
                    alumno.setTelefono(rs.getString("telefono"));
                    alumno.setCelular(rs.getString("celular"));
                    alumno.setCurp(rs.getString("curp"));
                    alumno.setNivelAcademico(rs.getString("nivel_academico"));
                    alumno.setIdCarrera(rs.getInt("carrera"));
                    System.out.println(alumno.getIdCarrera());
                    alumno.setTurno(rs.getString("turno"));
                    alumno.setSexo(rs.getString("sexo"));
                    alumno.setNacionalidad(rs.getString("nacionalidad"));
                    alumno.setColonia(rs.getString("colonia"));
                    alumno.setNumInterior(rs.getString("num_interior"));
                    alumno.setNumExterior(rs.getString("num_exterior"));
                    alumno.setEntidadFederativa(rs.getString("entidad_federativa"));
                    alumno.setDelegacion(rs.getString("delegacion"));
                    alumno.setCodigoPostal(rs.getString("codigo_postal"));
                    alumno.setCalle(rs.getString("calle"));
                    alumno.setIdDivisionAcademica(rs.getInt("id_division"));
                    System.out.println("Id división academica" + rs.getInt("id_division"));
                    System.out.println("Id division bean -->  " + alumno.getIdDivisionAcademica());

                    alumno.setNombre(rs.getString("nombre"));
                    alumno.setPrimerApellido(rs.getString("primer_apellido"));
                    alumno.setSegundoApellido(rs.getString("segundo_apellido"));
                    alumno.setCorreo(rs.getString("correo"));
                    alumno.setEstado(rs.getString("estado"));

                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return alumno;
    }

    public boolean actualizar (BeanAlumnos actualizarAlumno) {
        try (Connection con = ConnectionMySQL.getConnection()){
            try(PreparedStatement pstm = con.prepareStatement(
                    "UPDATE usuarios SET estado = ? where id_usuario = ?");){
                pstm.setString(1, actualizarAlumno.getEstado());
                pstm.setInt(2, actualizarAlumno.getIdAlumno());
                return pstm.executeUpdate() == 1;
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }


    public BeanAlumnos findById(int idAlumno) {

        BeanAlumnos unAlumno = new BeanAlumnos();
        try (Connection con = ConnectionMySQL.getConnection()) {
            try(PreparedStatement pstm = con.prepareStatement("select * from alumnos where id_alumno = ?;");){
                pstm.setInt(1,idAlumno);
                ResultSet rs = pstm.executeQuery();
                while(rs.next()){
                    unAlumno.setIdAlumno(rs.getInt("id_alumno"));
                    unAlumno.setMatricula(rs.getString("matricula"));
                    unAlumno.setFechaNacimiento(rs.getString("fecha_nacimiento"));
                    unAlumno.setTelefono(rs.getString("telefono"));
                    unAlumno.setCelular(rs.getString("celular"));
                    unAlumno.setCurp(rs.getString("curp"));
                    unAlumno.setNivelAcademico(rs.getString("nivel_academico"));
                    unAlumno.setIdCarrera(rs.getInt("carrera"));
                    unAlumno.setTurno(rs.getString("turno"));
                    unAlumno.setSexo(rs.getString("sexo"));
                    unAlumno.setNacionalidad(rs.getString("nacionalidad"));
                    unAlumno.setColonia(rs.getString("colonia"));
                    unAlumno.setNumInterior(rs.getString("num_interior"));
                    unAlumno.setNumExterior(rs.getString("num_exterior"));
                    unAlumno.setEntidadFederativa(rs.getString("entidad_federativa"));
                    unAlumno.setDelegacion(rs.getString("delegacion"));
                    unAlumno.setCodigoPostal(rs.getString("codigo_postal"));
                    unAlumno.setCalle(rs.getString("calle"));
                    unAlumno.setIdDivisionAcademica(rs.getInt("id_division"));
                }

            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return unAlumno;
    }

    public List<BeanUsuarios> findAll() {

        List<BeanUsuarios> alumnoLista = new ArrayList<>();
        try(
                Connection con = ConnectionMySQL.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery("select * from usuarios;");

        ){
            while (rs.next()){
                BeanUsuarios unAlumno = new BeanUsuarios();
                unAlumno.setIdUsuario(rs.getInt("id_usuario"));
                unAlumno.setCorreo(rs.getString("correo"));
                alumnoLista.add(unAlumno);

            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return alumnoLista;
    }

    public boolean update(BeanAlumnos alumnoUpdate) {

        try (Connection con = ConnectionMySQL.getConnection();) {
            try(PreparedStatement pstm = con.prepareStatement("update alumnos set fecha_nacimiento = ?, telefono=? ,celular=?,curp=?,sexo=?,nacionalidad=?,colonia=?,num_interior=?,num_exterior=?,entidad_federativa=?,delegacion=?,codigo_postal=?,calle=? where id_alumno = ? ;");){
                pstm.setString(1,alumnoUpdate.getFechaNacimiento());
                pstm.setString(2,alumnoUpdate.getTelefono());
                pstm.setString(3, alumnoUpdate.getCelular());
                pstm.setString(4,alumnoUpdate.getCurp());
                pstm.setString(5,alumnoUpdate.getSexo());
                pstm.setString(6,alumnoUpdate.getNacionalidad());
                pstm.setString(7,alumnoUpdate.getColonia());
                pstm.setString(8,alumnoUpdate.getNumInterior());
                pstm.setString(9,alumnoUpdate.getNumExterior());
                pstm.setString(10,alumnoUpdate.getEntidadFederativa());
                pstm.setString(11,alumnoUpdate.getDelegacion());
                pstm.setString(12,alumnoUpdate.getCodigoPostal());
                pstm.setString(13,alumnoUpdate.getCalle());
                pstm.setInt(14,alumnoUpdate.getIdAlumno());
                return pstm.executeUpdate()==1;

            }catch (SQLException ex){
                System.out.println("acutalizacion fallo");
                ex.printStackTrace();
            }
        }catch (SQLException ex) {
            System.out.println("acutalizacion fallo");
            ex.printStackTrace();
        }
        System.out.println("acutalizacion fallo");
        return false;

    }

    public BeanAlumnos findBeca(String matricula) {
        BeanAlumnos alumnoBeca = new BeanAlumnos();
        try (Connection con = ConnectionMySQL.getConnection()) {
            try(PreparedStatement pstm = con.prepareStatement("select * from solicitud_alumnos join becas where matricula_solicitud = ? AND solicitud_alumnos.estado ='Activo' AND id_convocatoria = id_beca; ");){
                pstm.setString(1,matricula);
                ResultSet rs = pstm.executeQuery();

                while(rs.next()){
                    alumnoBeca.setMatricula(rs.getString("matricula_solicitud"));
                    alumnoBeca.setFecha_solicitud(rs.getString("fecha_solicitud"));
                    alumnoBeca.setEstado(rs.getString("estado"));
                    alumnoBeca.setVeredicto(rs.getString("veredicto"));
                    alumnoBeca.setPorcentaje(rs.getString("porcentaje"));
                    alumnoBeca.setNombreBeca(rs.getString("tipo_beca"));
                }

            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return alumnoBeca;
    }




    public List<BeanAlumnos> findBecaPasada(String matricula) {
        List<BeanAlumnos> listaHistorial = new ArrayList<>();


        try (Connection con = ConnectionMySQL.getConnection()) {
            try(PreparedStatement pstm = con.prepareStatement("select * from solicitud_alumnos join becas where matricula_solicitud = ? AND solicitud_alumnos.estado ='Inactivo' AND id_convocatoria = id_beca;");){
                pstm.setString(1,matricula);
                ResultSet rs = pstm.executeQuery();

                while(rs.next()){
                    BeanAlumnos alumnoBeca = new BeanAlumnos();
                    alumnoBeca.setMatricula(rs.getString("matricula_solicitud"));
                    alumnoBeca.setFecha_solicitud(rs.getString("fecha_solicitud"));
                    alumnoBeca.setEstado(rs.getString("estado"));
                    alumnoBeca.setVeredicto(rs.getString("veredicto"));
                    alumnoBeca.setPorcentaje(rs.getString("porcentaje"));
                    alumnoBeca.setNombreBeca(rs.getString("tipo_beca"));

                    listaHistorial.add(alumnoBeca);
                }

            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaHistorial;
    }


















/*
    public List<BeanAlumnos> listaBuscador(String buscador){
        List<BeanAlumnos> listaBuscador = new ArrayList<>();
        System.out.println("Entro al Dao.listarBuscador");
        System.out.println(buscador);
        String sql = "SELECT * FROM alumnos WHERE matricula LIKE '%"+buscador+"%'";
        try (Connection con = new ConnectionMySQL().getConnection()){
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            System.out.println(pstm);

            while(rs.next()){
                BeanAlumnos beanAlumnos = new BeanAlumnos();
                beanAlumnos.setMatricula(rs.getString("matricula"));
                beanAlumnos.setEstado(rs.getString("estado"));
                beanAlumnos.setNombre(rs.getString("nombre"));
                beanAlumnos.setIdAlumno(rs.getInt("id_alumno"));

                listaBuscador.add(beanAlumnos);
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return listaBuscador;
    }
    */
}