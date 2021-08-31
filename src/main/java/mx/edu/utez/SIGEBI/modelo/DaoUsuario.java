package mx.edu.utez.SIGEBI.modelo;

import mx.edu.utez.SIGEBI.util.ConnectionMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//Dao para la validación de inicio de sesión//

public class DaoUsuario {
    public BeanUsuarios login (String correo, String clave){
        BeanUsuarios unUsuario = new BeanUsuarios();

        try (Connection con = ConnectionMySQL.getConnection();){
            try(PreparedStatement pstm =
                        con.prepareStatement("SELECT * FROM usuarios WHERE correo = ? and clave = ?;");) {
                pstm.setString(1, correo);
                pstm.setString(2, clave);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    unUsuario.setIdUsuario(rs.getInt("id_usuario"));
                    System.out.println("Id_usuario: " + rs.getInt("id_usuario"));

                    unUsuario.setCorreo(rs.getString("correo"));
                    System.out.println("Correo: " + rs.getString("correo"));

                    unUsuario.setClave(rs.getString("clave"));
                    System.out.println("Clave: " + rs.getString("clave"));

                    unUsuario.setNombre(rs.getString("nombre"));
                    System.out.println("Nombre: " + rs.getString("nombre"));

                    unUsuario.setPrimerApeliido(rs.getString("primer_apellido"));
                    unUsuario.setSegundoApellido(rs.getString("segundo_apellido"));

                    unUsuario.setRol(rs.getInt("tipo_rol"));
                    System.out.println("Tipo rol: " + rs.getInt("tipo_rol"));
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return unUsuario;
    }
    public List<BeanUsuarios> findAll(){
        List<BeanUsuarios> comiteList=new ArrayList<>();
        try(
                Connection con = ConnectionMySQL.getConnection();
                Statement stm =con.createStatement();
                ResultSet rs = stm.executeQuery("select*from usuarios");
        ){
            while (rs.next()){
                BeanUsuarios unUsuario=new BeanUsuarios();
                unUsuario.setIdUsuario(rs.getInt("idUsuario"));
                unUsuario.setCorreo(rs.getString("correo"));
                comiteList.add(unUsuario);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return comiteList;
    }

    public boolean saveUsers(BeanUsuarios unUsuario) {
        return true;
    }


    public boolean update(BeanUsuarios usuarioUpdate) {

        try (Connection con = ConnectionMySQL.getConnection();) {
            try(PreparedStatement pstm = con.prepareStatement("update usuarios set nombre = ? , primer_apellido = ?," +
                    "segundo_apellido = ? where id_usuario = ?");){
                pstm.setString(1,usuarioUpdate.getNombre());
                pstm.setString(2,usuarioUpdate.getPrimerApellido());
                pstm.setString(3,usuarioUpdate.getSegundoApellido());
                pstm.setInt(4,usuarioUpdate.getIdUsuario());
                return pstm.executeUpdate()==1;
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;

    }

    public BeanUsuarios findByEmail (String correo){
        BeanUsuarios unUsuario = new BeanUsuarios();

        try (Connection con = ConnectionMySQL.getConnection()){
            try(PreparedStatement pstm =
                        con.prepareStatement("SELECT * FROM usuarios WHERE correo = ?;")) {
                pstm.setString(1, correo);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    unUsuario.setCorreo(rs.getString("correo"));
                    System.out.println("Correo: " + rs.getString("correo"));

                    unUsuario.setClave(rs.getString("clave"));
                    System.out.println("Clave: " + rs.getString("clave"));

                    unUsuario.setIdUsuario(rs.getInt("id_usuario"));
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return unUsuario;
    }

    public boolean findEmail (String correo){

        try (Connection con = ConnectionMySQL.getConnection();){
            try(PreparedStatement pstm =
                        con.prepareStatement("SELECT * FROM usuarios WHERE correo = ?")) {
                pstm.setString(1, correo);
                ResultSet rs = pstm.executeQuery();
                System.out.println(rs);
                System.out.println(pstm);
                return pstm.execute();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }

    public boolean actualizarClave (int idUsuario){

        try (Connection con = ConnectionMySQL.getConnection();){
            try(PreparedStatement pstm =
                        con.prepareStatement("UPDATE usuarios SET clave = substring(MD5(RAND()),1,7)  WHERE id_usuario = ? ")) {
                pstm.setInt(1, idUsuario);
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

