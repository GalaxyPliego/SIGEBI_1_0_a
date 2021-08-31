package mx.edu.utez.SIGEBI.modelo;

import mx.edu.utez.SIGEBI.util.ConnectionMySQL;

import javax.servlet.http.Part;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoGuardarSolicitud {
    public boolean guardarSolicitud(String fecha, String matricula, int idConvocatoria) {
        try(Connection con = ConnectionMySQL.getConnection();){
            try(PreparedStatement pstm = con.prepareStatement("insert into solicitud_alumnos(fecha_solicitud, estado, matricula_solicitud, id_convocatoria) values(?, 'Activo',?,?)");){
                pstm.setString(1,fecha);
                pstm.setString(2,matricula);
                pstm.setInt(3, idConvocatoria);
                return pstm.executeUpdate() == 1;
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }

    public boolean guardarRequisitos(int cuatrimestreAnterior, int cuatrimestreActual, float promedio, InputStream boleta, String motivos, int id_solicitud, int tipo_beca) {
        try(Connection con = ConnectionMySQL.getConnection();){
            try(PreparedStatement pstm = con.prepareStatement("insert into requisitos_becas(cuatrimestre_anterior, cuatrimestre_actual, promedio, boleta, motivos, id_solicitud, tipo_beca) values(?,?,?,?,?,?,?)");){
                pstm.setInt(1, cuatrimestreAnterior);
                pstm.setInt(2, cuatrimestreActual);
                pstm.setFloat(3, promedio);
                pstm.setBlob(4, boleta);
                pstm.setString(5, motivos);
                pstm.setInt(6, id_solicitud);
                pstm.setInt(7, tipo_beca);
                return pstm.executeUpdate() == 1;
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return false;
    }

    public int obtenerIdSolicitud(String matricula, String fecha) {
        int idSolicitud = 0;
        try(Connection con = ConnectionMySQL.getConnection();){
            try(PreparedStatement pstm = con.prepareStatement("Select * from solicitud_alumnos where matricula_solicitud = ? and fecha_solicitud = ?;");){
                pstm.setString(1, matricula);
                pstm.setString(2, fecha);
                ResultSet rs = pstm.executeQuery();
                if (rs.next()){
                    idSolicitud =  (rs.getInt("id_solicitud"));
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return idSolicitud;
    }

    public boolean guardarBecaMadres(int idRequisitos,InputStream actaHijo, InputStream actaMadre) {
        try(Connection con = ConnectionMySQL.getConnection();){
            try(PreparedStatement pstm = con.prepareStatement("insert into beca_madres_solteras values(?, ?, ?)");){
                pstm.setInt(1, idRequisitos);
                pstm.setBlob(2, actaHijo);
                pstm.setBlob(3, actaMadre);
                return pstm.executeUpdate() == 1;
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }

    public int obtenerIdRequisistos(int idSolicitud) {
        int idRequisitos = 0;
        try(Connection con = ConnectionMySQL.getConnection();){
            try(PreparedStatement pstm = con.prepareStatement("Select * from requisitos_becas where id_solicitud = ?;");){
                pstm.setInt(1, idSolicitud);
                ResultSet rs = pstm.executeQuery();
                if (rs.next()){
                    idRequisitos =  (rs.getInt("id_requisito"));
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return idRequisitos;
    }

    public boolean guardarBecaActExtra(int idRequisitos, String nombreTaller) {
        try(Connection con = ConnectionMySQL.getConnection();){
            try(PreparedStatement pstm = con.prepareStatement("insert into beca_extracurricular values(?, ?)");){
                pstm.setInt(1, idRequisitos);
                pstm.setString(2, nombreTaller);
                return pstm.executeUpdate() == 1;
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return false;
    }

    public boolean guardarPersonalAdmin(int idRequisitos, String nombreFamiliar, String parentesco, String areaTrabajoPersonal, String areaTrabajo) {
        try(Connection con = ConnectionMySQL.getConnection();){
            try(PreparedStatement pstm = con.prepareStatement("insert into beca_personal_admin values(?, ?, ?, ?, ?)");){
                pstm.setInt(1, idRequisitos);
                pstm.setString(2, parentesco);
                pstm.setString(3, nombreFamiliar);
                pstm.setString(4, areaTrabajo);
                pstm.setString(5, areaTrabajoPersonal);
                return pstm.executeUpdate() == 1;
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return false;
    }

    public boolean guardarComunDisc(int idRequisitos, InputStream constancia) {
        try(Connection con = ConnectionMySQL.getConnection();){
            try(PreparedStatement pstm = con.prepareStatement("insert into beca_discapacidad_comunidad_indigenas values(?, ?);");){
                pstm.setInt(1, idRequisitos);
                pstm.setBlob(2, constancia);

                return pstm.executeUpdate() == 1;
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return false;
    }
    public List<BeanListado> listadoSolicitudes(){
        List<BeanListado> listSolicitud = new ArrayList<>();
        try( Connection con = ConnectionMySQL.getConnection();
             Statement stm = con.createStatement();
             ResultSet rs = stm.executeQuery("Select*from solicitud_alumnos where estado='Pendiente';");
        ) {
            while(rs.next()){
                BeanListado listado = new BeanListado();
                listado.setId_solicitud(rs.getInt("id_solicitud"));
                listado.setFechaSolicitud(rs.getString("fecha_solicitud"));
                listado.setEstado(rs.getString("estado"));
                listado.setComentario(rs.getString("comentario"));
                listado.setVerdicto(rs.getString("veredicto"));
                listado.setPorcentaje(rs.getInt("porcentaje"));
                listado.setMatriculaSolicitud(rs.getString("matricula_solicitud"));
                listado.setConvocatoria(rs.getInt("id_convocatoria"));
                listado.setComite(rs.getInt("id_comite"));
                listSolicitud.add(listado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSolicitud;

    }

    public List<BeanListado> listadoSolicitudesporId(int convocatoria){
        List<BeanListado> listSolicitud = new ArrayList<>();
        try(Connection con = ConnectionMySQL.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("Select*from solicitud_alumnos WHERE id_convocatoria = ?")
        ) {
            while(rs.next()){
                BeanListado listado = new BeanListado();
                listado.setId_solicitud(rs.getInt("id_solicitud"));
                listado.setFechaSolicitud(rs.getString("fecha_solicitud"));
                listado.setEstado(rs.getString("estado"));
                listado.setComentario(rs.getString("comentario"));
                listado.setVerdicto(rs.getString("veredicto"));
                listado.setPorcentaje(rs.getInt("porcentaje"));
                listado.setMatriculaSolicitud(rs.getString("matricula_solicitud"));
                listado.setConvocatoria(rs.getInt("id_convocatoria"));
                listado.setComite(rs.getInt("id_comite"));
                listSolicitud.add(listado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSolicitud;

    }

    public boolean saveResultadosListas(BeanListado listado) throws SQLException {
        try(Connection con = ConnectionMySQL.getConnection()){
            try(PreparedStatement pstm= con.prepareStatement("insert into solicitud_alumnos (comentario, veredicto,porcentaje) values(?,?,?);");){
                pstm.setString(1,listado.getComentario());
                pstm.setString(2,listado.getVerdicto());
                pstm.setInt(3,listado.getPorcentaje());
            }

            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return false;

        }
    }
}
