package mx.edu.utez.SIGEBI.modelo;

import mx.edu.utez.SIGEBI.util.ConnectionMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoHistorial {
    public List<BeanListado> listadoSolictudes() {
        List<BeanListado> solicitudesLista = new ArrayList<>();
        try (Connection con = ConnectionMySQL.getConnection();
             Statement stm = con.createStatement();
             ResultSet rs = stm.executeQuery("Select*from solicitudes_especificas;");
        ) {
            //ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                BeanListado listado = new BeanListado();
                listado.setMatriculaSolicitud(rs.getString("matricula"));
                listado.setNombre(rs.getString("nombre"));
                listado.setVerdicto(rs.getString("veredicto"));
                listado.setPorcentaje(rs.getInt("porcentaje"));
                solicitudesLista.add(listado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return solicitudesLista;
    }

    public List<BeanListado> findByConvocatorias(int tipo_Beca) {
        List<BeanListado> historial_solicitudes = new ArrayList<>();
        try (Connection con = ConnectionMySQL.getConnection()) {
            try (
                    PreparedStatement pstm = con.prepareStatement("select * from solicitudes_especificas where id_convocatoria=?;")) {
                pstm.setInt(1, tipo_Beca);
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
                    historial_solicitudes.add(listado);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return historial_solicitudes;
    }


    public BeanRequisitos findRequisitos(int id_solicitud) {
        BeanRequisitos requisitosAlumno = new BeanRequisitos();
        try (Connection con = ConnectionMySQL.getConnection()) {
            try (PreparedStatement pstm = con.prepareStatement("select * from requisitos_becas where id_solicitud=?;")) {
                pstm.setInt(1, id_solicitud);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    requisitosAlumno.setIdRequisitos(rs.getInt("id_requisito"));
                    requisitosAlumno.setCuatrimestreActual(rs.getInt("cuatrimestre_actual"));
                    requisitosAlumno.setCuatrimestreAnterior(rs.getInt("cuatrimestre_anterior"));
                    requisitosAlumno.setPromedio(rs.getInt("promedio"));
                    requisitosAlumno.setBoleta(rs.getBlob("boleta"));
                    requisitosAlumno.setMotivos(rs.getString("motivos"));
                    System.out.println(rs.getString("motivos"));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return requisitosAlumno;
    }

    public Blob getBoleta(int idSolicitud) {
        Blob boleta = null;
        try (Connection con = ConnectionMySQL.getConnection()) {
            try (PreparedStatement pstm = con.prepareStatement("select * from requisitos_becas where id_solicitud=?;")) {
                pstm.setInt(1, idSolicitud);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    boleta = (rs.getBlob("boleta"));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return boleta;
    }

    public Blob getActaHijo(int idRequisitos) {
        Blob acta = null;
        try (Connection con = ConnectionMySQL.getConnection()) {
            try (PreparedStatement pstm = con.prepareStatement("select * from beca_madres_solteras where id_madres_solteras=?;")) {
                pstm.setInt(1, idRequisitos);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    acta = (rs.getBlob("acta_nacimiento_hijos"));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return acta;
    }

    public Blob getActMadre(int idRequisitos) {
        Blob actaMadre = null;
        try (Connection con = ConnectionMySQL.getConnection()) {
            try (PreparedStatement pstm = con.prepareStatement("select * from beca_madres_solteras where id_madres_solteras=?;")) {
                pstm.setInt(1, idRequisitos);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    actaMadre = (rs.getBlob("acta_nacimiento_madre"));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return actaMadre;
    }

    public BeanExtracurricular requisitosExtra(int idRequisitos) {
        BeanExtracurricular requisitosAlumnoExtracurricular = new BeanExtracurricular();
        try (Connection con = ConnectionMySQL.getConnection()) {
            try (PreparedStatement pstm = con.prepareStatement("select * from beca_extracurricular where id_extracurricular=?;")) {
                pstm.setInt(1, idRequisitos);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    requisitosAlumnoExtracurricular.setId_extracurricular(rs.getInt("id_extracurricular"));
                    requisitosAlumnoExtracurricular.setTaller_proyecto(rs.getString("taller_proyecto"));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return requisitosAlumnoExtracurricular;
    }


    public BeanPersonalAdmin findRequisitosPersonal(int idRequisitos) {
        BeanPersonalAdmin requisitosPersonalAdmin = new BeanPersonalAdmin();
        try (Connection con = ConnectionMySQL.getConnection()) {
            try (PreparedStatement pstm = con.prepareStatement("select * from beca_personal_admin where id_personal_admin=?;")) {
                pstm.setInt(1, idRequisitos);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    requisitosPersonalAdmin.setParentesco(rs.getString("parentesco"));
                    requisitosPersonalAdmin.setNombre_completoFamiliar(rs.getString("nombre_completo_familiar"));
                    requisitosPersonalAdmin.setArea_trabajo(rs.getString("area_trabajo"));
                    requisitosPersonalAdmin.setTrabajador(rs.getString("trabajador"));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return requisitosPersonalAdmin;
    }

    public Blob constancia(int idRequisitos) {
        Blob constancia = null;
        try (Connection con = ConnectionMySQL.getConnection()) {
            try (PreparedStatement pstm = con.prepareStatement("select * from beca_discapacidad_comunidad_indigenas where id_dis_com_ind=?;")) {
                pstm.setInt(1, idRequisitos);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    constancia = (rs.getBlob("constancia"));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return constancia;
    }

}
