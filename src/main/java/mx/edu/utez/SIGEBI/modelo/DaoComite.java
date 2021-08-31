package mx.edu.utez.SIGEBI.modelo;
import mx.edu.utez.SIGEBI.util.ConnectionMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoComite {
    public List<BeanComite> findAll() {
        List<BeanComite> comiteList= new ArrayList<>();
        try (
                Connection con = ConnectionMySQL.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery("select * from usuarios where tipo_rol=3");
        ) {
            while (rs.next()) {
                BeanComite beanComite = new BeanComite();
                beanComite.setIdUsuario(rs.getInt("id_usuario"));
                beanComite.setNombre(rs.getString("nombre"));
                beanComite.setPrimerApellido(rs.getString("primer_apellido"));
                beanComite.setSegundoApellido(rs.getString("segundo_apellido"));
                beanComite.setCorreo(rs.getString("correo"));
                beanComite.setClave(rs.getString("clave"));
                beanComite.setEstado(rs.getString("estado"));
                beanComite.setIdDivisionAcademica(rs.getInt("id_division"));
                beanComite.setRol(rs.getInt("tipo_rol"));
                comiteList.add(beanComite);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return comiteList;
    }
    public boolean saveCuentaComite(BeanComite beanComite) {
        try (Connection con = ConnectionMySQL.getConnection();) {
            try (
                    PreparedStatement pstm = con.prepareStatement("insert into usuarios (nombre, primer_apellido, segundo_apellido,correo,estado, id_division, tipo_rol ) values (?,?,?,?,?,?,?);");) {
                pstm.setString(1, beanComite.getNombre());
                pstm.setString(2, beanComite.getPrimerApellido());
                pstm.setString(3, beanComite.getSegundoApellido());
                pstm.setString(4, beanComite.getCorreo());
                pstm.setString(5, beanComite.getEstado());
                pstm.setInt(6, beanComite.getIdDivisionAcademica());
                pstm.setInt(7, beanComite.getRol());
                return pstm.executeUpdate() == 1;
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public BeanComite findById(int idUser) {
        BeanComite beanComite = new BeanComite();
        try (Connection con = ConnectionMySQL.getConnection()) {
            try (
                    PreparedStatement pstm = con.prepareStatement("select * from usuarios where id_usuario = ?;");) {
                pstm.setInt(1, idUser);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    beanComite.setIdUsuario(rs.getInt("id_usuario"));
                    beanComite.setNombre(rs.getString("nombre"));
                    beanComite.setPrimerApellido(rs.getString("primer_apellido"));
                    beanComite.setSegundoApellido(rs.getString("segundo_apellido"));
                    beanComite.setCorreo(rs.getString("correo"));
                    beanComite.setClave(rs.getString("clave"));
                    beanComite.setEstado(rs.getString("estado"));
                    beanComite.setIdDivisionAcademica(rs.getInt("id_division"));
                    beanComite.setRol(rs.getInt("tipo_rol"));
                    System.out.println(beanComite);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return beanComite;
    }
    //Este metodo actualiza tanto para la vista del administrador como el comité
    public boolean update(BeanComite usuariosUpdate) {
        try(Connection con = ConnectionMySQL.getConnection();){
            try(
                    PreparedStatement pstm = con.prepareStatement("update usuarios set nombre = ?, primer_apellido = ?, segundo_apellido = ?, correo = ?, clave = ?, estado = ?, id_division = ? where id_usuario = ?");) {
                pstm.setString(1, usuariosUpdate.getNombre());
                pstm.setString(2, usuariosUpdate.getPrimerApellido());
                pstm.setString(3, usuariosUpdate.getSegundoApellido());
                pstm.setString(4, usuariosUpdate.getCorreo());
                pstm.setString(5, usuariosUpdate.getClave());
                pstm.setString(6, usuariosUpdate.getEstado());
                pstm.setInt(7, usuariosUpdate.getIdDivisionAcademica());
                pstm.setInt(8, usuariosUpdate.getIdUsuario());
                System.out.println(pstm);
                return pstm.executeUpdate() == 1;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean delete(BeanComite usuariosDelete) {
        try(Connection con = new ConnectionMySQL().getConnection();) {
            try (PreparedStatement pstm= con.prepareStatement("delete from usuarios where id_usuario=?;")){
                pstm.setInt(1, usuariosDelete.getIdUsuario());
                System.out.println(pstm);
                return pstm.executeUpdate()==1;
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    public List<BeanComite> buscadorList(String buscador){
        List<BeanComite> buscadorList= new ArrayList<>();
        String sql = "select * from usuarios where id_usuario LIKE '%"+ buscador+"%' or nombre LIKE '%"+ buscador+"%' or primer_apellido LIKE '%"+buscador+"%' or segundo_apellido LIKE '%"+buscador+"%' or correo LIKE '%"+buscador+"%'or clave LIKE '%"+buscador+"%' or id_division LIKE '%"+ buscador+"%'or tipo_rol LIKE '%"+buscador+"%'";
        System.out.println("Entro al buscador");
        System.out.println(buscador);
        try(Connection con = new ConnectionMySQL().getConnection()){
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            System.out.println(pstm);
            while (rs.next()){
                BeanComite beanComite = new BeanComite(buscador);
                beanComite.setIdUsuario(rs.getInt("id_usuario"));
                beanComite.setNombre(rs.getString("nombre"));
                beanComite.setPrimerApellido(rs.getString("primer_apellido"));
                beanComite.setSegundoApellido(rs.getString("segundo_apellido"));
                beanComite.setCorreo(rs.getString("correo"));
                beanComite.setClave(rs.getString("clave"));
                beanComite.setEstado(rs.getString("estado"));
                beanComite.setIdDivisionAcademica(rs.getInt("id_division"));
                buscadorList.add(beanComite);
                System.out.println(buscadorList);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return buscadorList;
    }

}
