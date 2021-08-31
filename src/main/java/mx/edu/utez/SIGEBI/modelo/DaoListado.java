package mx.edu.utez.SIGEBI.modelo;

import mx.edu.utez.SIGEBI.util.ConnectionMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoListado {
    public List<BeanListado> listadoSolictudes(int tipoBeca) {
        List<BeanListado> solicitudesLista = new ArrayList<>();
        try (Connection con = ConnectionMySQL.getConnection();
             Statement stm = con.createStatement();
             PreparedStatement pstm = con.prepareStatement("Select * from solicitudes_especificas where id_convocatoria = ? ;");) {
            pstm.setInt(1, tipoBeca);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                BeanListado listado = new BeanListado();
                listado.setId_solicitud(rs.getInt("id_solicitud"));
                listado.setFechaSolicitud(rs.getString("fecha_solicitud"));
                listado.setEstado(rs.getString("estado"));
                listado.setComentario(rs.getString("comentario"));
                listado.setVerdicto(rs.getString("veredicto"));
                listado.setPorcentaje(rs.getInt("porcentaje"));
                listado.setMatriculaSolicitud(rs.getString("matricula"));
                listado.setConvocatoria(rs.getInt("id_convocatoria"));
                listado.setComite(rs.getInt("id_comite"));
                listado.setNombre(rs.getString("nombre"));
                solicitudesLista.add(listado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return solicitudesLista;
    }

    public boolean saveResultadosListas(BeanListado listado) {
        try (Connection con = ConnectionMySQL.getConnection();) {
            try (PreparedStatement pstm = con.prepareStatement("update solicitud_alumnos set comentario = ?, veredicto=?, porcentaje=? WHERE id_solicitud=?;");) {
                pstm.setString(1, listado.getComentario());
                pstm.setString(2, listado.getVerdicto());
                pstm.setInt(3, listado.getPorcentaje());
                pstm.setInt(4,listado.getId_solicitud());
                return pstm.executeUpdate() == 1;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }
    // Consulta especifica
    public List<BeanListado> findByBecaAcademica(int tipo_Beca){
        List<BeanListado> listaSolicitudesAcademica= new ArrayList<>();
        try(Connection con = ConnectionMySQL.getConnection()){
            try(PreparedStatement pstm = con.prepareStatement("select * from solicitudes_especificas where id_convocatoria=1;")){
                ResultSet rs= pstm.executeQuery();
                while(rs.next()){
                    BeanListado listado = new BeanListado();
                    listado.setId_solicitud(rs.getInt("id_solicitud"));
                    listado.setFechaSolicitud(rs.getString("fecha_solicitud"));
                    listado.setEstado(rs.getString("estado"));
                    listado.setComentario(rs.getString("comentario"));
                    listado.setVerdicto(rs.getString("veredicto"));
                    listado.setPorcentaje(rs.getInt("porcentaje"));
                    listado.setMatriculaSolicitud(rs.getString("matricula"));
                    listado.setConvocatoria(rs.getInt("id_convocatoria"));
                    listado.setComite(rs.getInt("id_comite"));
                    listado.setNombre(rs.getString("nombre"));
                    listaSolicitudesAcademica.add(listado);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listaSolicitudesAcademica;
    }

    //Consulta especifica para beca madres Solteras
    public List<BeanListado> findBecaMadres(int convocatoria){
        List<BeanListado> listaSolicitudesMadres = new ArrayList<>();
        try(Connection con = ConnectionMySQL.getConnection()){
            try(
                    PreparedStatement pstm = con.prepareStatement("select * from solicitudes_especificas where id_convocatoria=2;")){
                ResultSet rs= pstm.executeQuery();
                while(rs.next()){
                    BeanListado listado = new BeanListado();
                    listado.setId_solicitud(rs.getInt("id_solicitud"));
                    listado.setFechaSolicitud(rs.getString("fecha_solicitud"));
                    listado.setEstado(rs.getString("estado"));
                    listado.setComentario(rs.getString("comentario"));
                    listado.setVerdicto(rs.getString("veredicto"));
                    listado.setPorcentaje(rs.getInt("porcentaje"));
                    listado.setMatriculaSolicitud(rs.getString("matricula"));
                    listado.setConvocatoria(rs.getInt("id_convocatoria"));
                    listado.setComite(rs.getInt("id_comite"));
                    listado.setNombre(rs.getString("nombre"));
                    listaSolicitudesMadres.add(listado);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listaSolicitudesMadres;
    }

    //Consulta especifica para Becas personal Amdin
    public List<BeanListado> findByBecasAdmin(int convocatoria){
        List<BeanListado>listaSolicitudesAdmin= new ArrayList<>();
        try(Connection con = ConnectionMySQL.getConnection()){
            try(
                    PreparedStatement pstm = con.prepareStatement("select * from solicitudes_especificas where id_convocatoria=4;")){
                ResultSet rs= pstm.executeQuery();
                while(rs.next()){
                    BeanListado listado = new BeanListado();
                    listado.setId_solicitud(rs.getInt("id_solicitud"));
                    listado.setFechaSolicitud(rs.getString("fecha_solicitud"));
                    listado.setEstado(rs.getString("estado"));
                    listado.setComentario(rs.getString("comentario"));
                    listado.setVerdicto(rs.getString("veredicto"));
                    listado.setPorcentaje(rs.getInt("porcentaje"));
                    listado.setMatriculaSolicitud(rs.getString("matricula"));
                    listado.setConvocatoria(rs.getInt("id_convocatoria"));
                    listado.setComite(rs.getInt("id_comite"));
                    listado.setNombre(rs.getString("nombre"));
                    listaSolicitudesAdmin.add(listado);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listaSolicitudesAdmin;
    }

    //Consulta especifica para becas Discapacidad y comunidad hinidgenas
    public List<BeanListado> findByBecasDiscapacidad(int convocatoria){
        List<BeanListado> listaSolicitudesDiscapacidades= new ArrayList<>();
        try(Connection con = ConnectionMySQL.getConnection()){
            try(
                    PreparedStatement pstm = con.prepareStatement("select * from solicitudes_especificas where id_convocatoria=5;")){
                ResultSet rs= pstm.executeQuery();
                while(rs.next()){
                    BeanListado listado = new BeanListado();
                    listado.setId_solicitud(rs.getInt("id_solicitud"));
                    listado.setFechaSolicitud(rs.getString("fecha_solicitud"));
                    listado.setEstado(rs.getString("estado"));
                    listado.setComentario(rs.getString("comentario"));
                    listado.setVerdicto(rs.getString("veredicto"));
                    listado.setPorcentaje(rs.getInt("porcentaje"));
                    listado.setMatriculaSolicitud(rs.getString("matricula"));
                    listado.setConvocatoria(rs.getInt("id_convocatoria"));
                    listado.setComite(rs.getInt("id_comite"));
                    listado.setNombre(rs.getString("nombre"));
                    listaSolicitudesDiscapacidades.add(listado);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listaSolicitudesDiscapacidades;
    }

    //Consulta especifica para Beca actividades extracurriculares
    public List<BeanListado> findByBecasextra(int convocatoria){
        List<BeanListado> listaSolicitudesActividades = new ArrayList<>();
        try(Connection con = ConnectionMySQL.getConnection()){
            try(
                    PreparedStatement pstm = con.prepareStatement("select * from solicitudes_especificas where id_convocatoria=3;")){
                ResultSet rs= pstm.executeQuery();
                while(rs.next()){
                    BeanListado listado = new BeanListado();
                    listado.setId_solicitud(rs.getInt("id_solicitud"));
                    listado.setFechaSolicitud(rs.getString("fecha_solicitud"));
                    listado.setEstado(rs.getString("estado"));
                    listado.setComentario(rs.getString("comentario"));
                    listado.setVerdicto(rs.getString("veredicto"));
                    listado.setPorcentaje(rs.getInt("porcentaje"));
                    listado.setMatriculaSolicitud(rs.getString("matricula"));
                    listado.setConvocatoria(rs.getInt("id_convocatoria"));
                    listado.setComite(rs.getInt("id_comite"));
                    listado.setNombre(rs.getString("nombre"));
                    listaSolicitudesActividades.add(listado);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listaSolicitudesActividades;
    }
}
