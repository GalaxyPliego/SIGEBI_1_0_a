package mx.edu.utez.SIGEBI.modelo;

import mx.edu.utez.SIGEBI.util.ConnectionMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoCarreras {
    public boolean insertar (BeanCarreras beanCarreras){
        System.out.println("Entro al metodo insertar");
        try (Connection con = new ConnectionMySQL().getConnection()){
            try(PreparedStatement pstm = con.prepareStatement("INSERT INTO carreras (nombre_carrera, estado, id_division_academica) values (?, ?, ?)")){
                pstm.setString(1, beanCarreras.getNombreCarrera());
                pstm.setString(2, beanCarreras.getEstado());
                pstm.setInt(3, beanCarreras.getIdDivisionAcademica());
                return pstm.executeUpdate() == 1;
            }catch (SQLException ex){
                ex.printStackTrace();
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }

    public BeanCarreras encontrarporId(int idCarrera) {
        BeanCarreras beanCarrera = new BeanCarreras();
        try (Connection con = new ConnectionMySQL().getConnection()){
            try(PreparedStatement pstm = con.prepareStatement("SELECT * FROM carreras where id_carrera = ? ")){
                pstm.setInt(1, idCarrera);
                ResultSet rs = pstm.executeQuery();
                if (rs.next()){
                    beanCarrera.setIdCarrera (rs.getInt("id_carrera"));
                    beanCarrera.setNombreCarrera(rs.getString("nombre_carrera"));
                    beanCarrera.setEstado(rs.getString("estado"));
                    beanCarrera.setIdDivisionAcademica(rs.getInt("id_division_academica"));
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return beanCarrera ;
    }

    public List<BeanCarreras> listaBuscador(String buscador){
        List<BeanCarreras> listaBuscador = new ArrayList<>();
        System.out.println("Entro al Dao.listarBuscador");
        System.out.println(buscador);
        String sql = "SELECT * FROM carreras WHERE id_carrera LIKE '%"+buscador+"%' or nombre_carrera LIKE '%"+buscador+"%'";
        try (Connection con = new ConnectionMySQL().getConnection()){
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            System.out.println(pstm);

            while(rs.next()){
                //Se almacenan las variables en divisionesAcademicas crenado un objeto
                BeanCarreras beanCarreras = new BeanCarreras();
                beanCarreras.setIdCarrera(rs.getInt("id_carrera"));
                beanCarreras.setNombreCarrera(rs.getString("nombre_carrera"));
                beanCarreras.setEstado(rs.getString("estado"));

                System.out.println(beanCarreras.getIdCarrera());
                System.out.println(beanCarreras.getNombreCarrera());
                System.out.println(beanCarreras.getEstado());

                listaBuscador.add(beanCarreras);
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
             ResultSet rs = stm.executeQuery("SELECT * FROM carreras")
        ){
            while(rs.next()){
                //Se almacenan las variables en divisionesAcademicas crenado un objeto
                BeanCarreras beanCarreras = new BeanCarreras();
                beanCarreras.setIdDivisionAcademica(rs.getInt("id_carrera"));
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

    public boolean eliminar (int idCarrera){
        try (Connection con = new ConnectionMySQL().getConnection()){
            try(PreparedStatement pstm = con.prepareStatement("DELETE FROM carreras WHERE id_carrera = ?")){
                pstm.setInt(1, idCarrera);
                return pstm.executeUpdate() == 1;
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }

    public boolean actualizar (BeanCarreras beanCarreras) {
        try (Connection con = ConnectionMySQL.getConnection()){
            try(PreparedStatement pstm = con.prepareStatement(
                    "UPDATE carreras SET nombre_carrera = ?, estado = ?, id_division_academica = ? where id_carrera = ?")){
                pstm.setString(1, beanCarreras.getNombreCarrera());
                pstm.setString(2, beanCarreras.getEstado());
                pstm.setInt(3, beanCarreras.getIdDivisionAcademica());
                pstm.setInt(4, beanCarreras.getIdCarrera());
                System.out.println(pstm);
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
