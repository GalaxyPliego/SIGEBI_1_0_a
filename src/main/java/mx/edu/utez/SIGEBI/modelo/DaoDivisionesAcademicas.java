package mx.edu.utez.SIGEBI.modelo;

import mx.edu.utez.SIGEBI.util.ConnectionMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoDivisionesAcademicas {

    public List<BeanDivisionesAcademicas> listar(){
        List<BeanDivisionesAcademicas> listaDivisiones = new ArrayList<>();

        try (Connection con = ConnectionMySQL.getConnection();
             Statement stm = con.createStatement();
             ResultSet rs = stm.executeQuery("SELECT * FROM divisiones_academicas");
        ){
            while(rs.next()){
                //Se almacenan las variables en divisionesAcademicas crenado un objeto
                BeanDivisionesAcademicas divisionAcademica = new BeanDivisionesAcademicas();
                divisionAcademica.setIdDivisionAcademica(rs.getInt("id_division_academica"));
                divisionAcademica.setNombreDivisionAcademica(rs.getString("nombre_division"));
                divisionAcademica.setEstado(rs.getString("estado"));

                System.out.println(divisionAcademica.getIdDivisionAcademica());
                System.out.println(divisionAcademica.getNombreDivisionAcademica());
                System.out.println(divisionAcademica.getEstado());

                listaDivisiones.add(divisionAcademica);
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return listaDivisiones;
    }

    public List<BeanDivisionesAcademicas> listaBuscador(String buscador){
        List<BeanDivisionesAcademicas> listaBuscador = new ArrayList<>();
        System.out.println("Entro al Dao.listarBuscador");
        System.out.println(buscador);
        String sql = "SELECT * FROM divisiones_academicas WHERE nombre_division LIKE '%"+buscador+"%' or id_division_academica LIKE '%"+buscador+"%'";
        try (Connection con = new ConnectionMySQL().getConnection()){
             PreparedStatement pstm = con.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery();
             System.out.println(pstm);

            while(rs.next()){
                //Se almacenan las variables en divisionesAcademicas crenado un objeto
                BeanDivisionesAcademicas beanDivisionAcademica = new BeanDivisionesAcademicas();
                beanDivisionAcademica.setIdDivisionAcademica(rs.getInt("id_division_academica"));
                beanDivisionAcademica.setNombreDivisionAcademica(rs.getString("nombre_division"));
                beanDivisionAcademica.setEstado(rs.getString("estado"));

                System.out.println(beanDivisionAcademica.getIdDivisionAcademica());
                System.out.println(beanDivisionAcademica.getNombreDivisionAcademica());
                System.out.println(beanDivisionAcademica.getEstado());

                listaBuscador.add(beanDivisionAcademica);
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return listaBuscador;
    }


    public List<BeanCarreras> listarCarreras(){
        List<BeanCarreras> listaCarreras = new ArrayList<>();

        try (Connection con = ConnectionMySQL.getConnection();
             Statement stm = con.createStatement();
             ResultSet rs = stm.executeQuery("SELECT * FROM carreras");
        ){
            while(rs.next()){
                //Se almacenan las variables en divisionesAcademicas crenado un objeto
                BeanCarreras beanCarreras = new BeanCarreras();
                beanCarreras.setIdCarrera(rs.getInt("id_carrera"));
                beanCarreras.setNombreCarrera(rs.getString("nombre_carrera"));
                beanCarreras.setEstado(rs.getString("estado"));
                beanCarreras.setIdDivisionAcademica(rs.getInt("id_division_academica"));

                System.out.println(beanCarreras.getIdCarrera());
                System.out.println(beanCarreras.getNombreCarrera());
                System.out.println(beanCarreras.getEstado());
                System.out.println(beanCarreras.getIdDivisionAcademica());

                listaCarreras.add(beanCarreras);
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return listaCarreras;
    }

    public BeanDivisionesAcademicas encontrarporId(int idDivisionAcademica) {
        BeanDivisionesAcademicas division = new BeanDivisionesAcademicas();
        try (Connection con = new ConnectionMySQL().getConnection();){
            try(PreparedStatement pstm = con.prepareStatement("SELECT * FROM divisiones_academicas where id_division_academica = ? ");){
                pstm.setInt(1, idDivisionAcademica);
                ResultSet rs = pstm.executeQuery();
                if (rs.next()){
                    division.setIdDivisionAcademica(rs.getInt("id_division_academica"));
                    division.setNombreDivisionAcademica(rs.getString("nombre_division"));
                    division.setEstado(rs.getString("estado"));
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return division ;
    }

    public boolean insertar (BeanDivisionesAcademicas beanDivision){
        System.out.println("Entro al metodo insertar");
        try (Connection con = new ConnectionMySQL().getConnection();){
            try(PreparedStatement pstm = con.prepareStatement("INSERT INTO divisiones_academicas (nombre_division, estado) values (?,?)");){
                pstm.setString(1, beanDivision.getNombreDivisionAcademica());
                pstm.setString(2, beanDivision.getEstado());
                return pstm.executeUpdate() == 1;
            }catch (SQLException ex){
                ex.printStackTrace();
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }

    public boolean actualizar (BeanDivisionesAcademicas actualizarDivision) {
        try (Connection con = ConnectionMySQL.getConnection()){
            try(PreparedStatement pstm = con.prepareStatement(
                    "UPDATE divisiones_academicas SET nombre_division = ?, estado = ? where id_division_academica = ?");){
                pstm.setString(1, actualizarDivision.getNombreDivisionAcademica());
                pstm.setString(2, actualizarDivision.getEstado());
                pstm.setInt(3, actualizarDivision.getIdDivisionAcademica());
                return pstm.executeUpdate() == 1;
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }

    public boolean eliminar (int idDivision){
        try (Connection con = new ConnectionMySQL().getConnection();){
            try(PreparedStatement pstm = con.prepareStatement("DELETE FROM divisiones_academicas WHERE id_division_academica = ?");){
                pstm.setInt(1, idDivision);
                return pstm.executeUpdate() == 1;
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }
}
