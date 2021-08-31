package mx.edu.utez.SIGEBI.modelo;

import com.mysql.cj.protocol.Resultset;
import mx.edu.utez.SIGEBI.util.ConnectionMySQL;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoConvocatorias {

    public static List<BeanConvocatorias> findConvocatorias() {
        List<BeanConvocatorias> convocatorias = new ArrayList<>();
        try(Connection con = ConnectionMySQL.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from convocatorias_completas;");
        ){
            while (rs.next()){
                BeanConvocatorias unaConvocatoria = new BeanConvocatorias();
                unaConvocatoria.setFechaInicio(rs.getString("fecha_inicio_publicacion"));


                unaConvocatoria.setFechaFin(rs.getString("fecha_fin_publicacion"));


                unaConvocatoria.setTipoBeca(rs.getString("tipo_beca"));


                unaConvocatoria.setIdBeca(rs.getInt("id_beca"));


                unaConvocatoria.setIdConvocatoria(rs.getInt("id_convocatoria"));


                convocatorias.add(unaConvocatoria);
            }
        }catch( SQLException ex){
            ex.printStackTrace();
        }
        return convocatorias;
    }

    public List<BeanConvocatorias> listar(){
        List<BeanConvocatorias> listaConvocatorias = new ArrayList<>();

        try (Connection con = ConnectionMySQL.getConnection();
             Statement stm = con.createStatement();
             ResultSet rs = stm.executeQuery("SELECT * FROM convocatorias")
        ){
            while(rs.next()){
                //Se almacenan las variables en Convocatoria crenado un objeto
                BeanConvocatorias Convocatoria = new BeanConvocatorias();
                Convocatoria.setIdConvocatoria(rs.getInt("id_convocatoria"));
                Convocatoria.setFechaInicio(rs.getString("fecha_inicio_publicacion"));
                Convocatoria.setFechaFin(rs.getString("fecha_fin_publicacion"));
                Convocatoria.setEstado(rs.getString("estado"));
                Convocatoria.setIdBeca2(rs.getInt("id_beca"));
                Convocatoria.setIdUsuario(rs.getInt("id_admin"));

                System.out.println(Convocatoria.getIdConvocatoria());
                System.out.println(Convocatoria.getFechaInicio());
                System.out.println(Convocatoria.getFechaFin());
                System.out.println(Convocatoria.getEstado());
                System.out.println(Convocatoria.getIdBeca2());
                System.out.println(Convocatoria.getIdUsuario());

                listaConvocatorias.add(Convocatoria);
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return listaConvocatorias;
    }

    public List<BeanConvocatorias> listar2(){
        List<BeanConvocatorias> listaadmin = new ArrayList<>();

        try (Connection con = ConnectionMySQL.getConnection();
             Statement stm = con.createStatement();
             ResultSet rs = stm.executeQuery("SELECT * FROM usuarios where tipo_rol = 1")
        ){
            while(rs.next()){

                BeanConvocatorias admin = new BeanConvocatorias();
                admin.setIdUsuario(rs.getInt("id_usuario"));
                admin.setNombre(rs.getString("nombre"));
                admin.setPrimer(rs.getString("primer_apellido"));
                admin.setSegundo(rs.getString("segundo_apellido"));
                admin.setCorreo(rs.getString("correo"));
                admin.setClave(rs.getString("clave"));
                admin.setIdDivision(rs.getInt("id_division"));
                admin.setTiporol(rs.getInt("tipo_rol"));

                System.out.println(admin.getIdUsuario());
                System.out.println(admin.getNombre());
                System.out.println(admin.getPrimer());
                System.out.println(admin.getSegundo());
                System.out.println(admin.getCorreo());
                System.out.println(admin.getClave());
                System.out.println(admin.getIdDivision());
                System.out.println(admin.getTiporol());

                listaadmin.add(admin);
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return listaadmin;
    }

    public List<BeanConvocatorias> listar3(){
        List<BeanConvocatorias> listaBecas = new ArrayList<>();

        try (Connection con = ConnectionMySQL.getConnection();
             Statement stm = con.createStatement();
             ResultSet rs = stm.executeQuery("SELECT * FROM becas")
        ){
            while (rs.next()){
                BeanConvocatorias beca = new BeanConvocatorias();
                beca.setIdBeca2(rs.getInt("id_beca"));
                beca.setTipoBeca(rs.getString("tipo_beca"));
                beca.setEstado2(rs.getString("estado"));

                System.out.println(beca.getIdBeca2());
                System.out.println(beca.getTipoBeca());
                System.out.println(beca.getEstado2());

                listaBecas.add(beca);
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return listaBecas;
    }


    public BeanConvocatorias encontrarporId(int idConvocatoria) {
        BeanConvocatorias convocatoria = new BeanConvocatorias();
        try (Connection con = new ConnectionMySQL().getConnection()){
            try(PreparedStatement pstm = con.prepareStatement(
                    "SELECT * FROM convocatorias where id_convocatoria = ? ")){
                pstm.setInt(1, idConvocatoria);
                ResultSet rs = pstm.executeQuery();
                if (rs.next()){
                    convocatoria.setIdConvocatoria(rs.getInt("id_convocatoria"));
                    convocatoria.setFechaInicio(rs.getString("fecha_inicio_publicacion"));
                    convocatoria.setFechaFin(rs.getString("fecha_fin_publicacion"));
                    convocatoria.setEstado(rs.getString("estado"));
                    convocatoria.setIdBeca2(rs.getInt("id_beca"));
                    convocatoria.setIdUsuario(rs.getInt("id_admin"));
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return convocatoria ;
    }

    public boolean insertar (BeanConvocatorias beanConvocatoria){
        System.out.println("Entro al metodo insertar");
        try (Connection con = new ConnectionMySQL().getConnection()){
            try(PreparedStatement pstm = con.prepareStatement(
                    "INSERT INTO convocatorias (fecha_inicio_publicacion,fecha_fin_publicacion, estado, id_beca, id_admin) values (?,?,?,?,?)")){
                pstm.setString(1, beanConvocatoria.getFechaInicio());
                pstm.setString(2, beanConvocatoria.getFechaFin()) ;
                pstm.setString(3, beanConvocatoria.getEstado());
                pstm.setInt(4, beanConvocatoria.getIdBeca2());
                pstm.setInt(5, beanConvocatoria.getIdUsuario());
                return pstm.executeUpdate() == 1;
            }catch (SQLException ex){
                ex.printStackTrace();
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }

    public boolean actualizar (BeanConvocatorias actualizarConvocatoria) {
        try (Connection con = ConnectionMySQL.getConnection()){
            try(PreparedStatement pstm = con.prepareStatement(
                    "UPDATE convocatorias SET fecha_inicio_publicacion = ?,fecha_fin_publicacion = ?, estado = ? where id_convocatoria = ?")){
                pstm.setString(1, actualizarConvocatoria.getFechaInicio());
                pstm.setString(2, actualizarConvocatoria.getFechaFin());
                pstm.setString(3, actualizarConvocatoria.getEstado());
                pstm.setInt(4, actualizarConvocatoria.getIdConvocatoria());
                return pstm.executeUpdate() == 1;
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }

    public boolean eliminar (int idConvocatorias){
        try (Connection con = new ConnectionMySQL().getConnection()){
            try(PreparedStatement pstm = con.prepareStatement("DELETE FROM convocatorias WHERE id_convocatoria = ?")){
                pstm.setInt(1, idConvocatorias);
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