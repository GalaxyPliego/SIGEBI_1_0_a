package mx.edu.utez.SIGEBI.modelo;

import mx.edu.utez.SIGEBI.util.ConnectionMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoBecas {

    public List<BeanBecas> listar(){
        List<BeanBecas> listaBecas = new ArrayList<>();

        try (Connection con = ConnectionMySQL.getConnection();
             Statement stm = con.createStatement();
             ResultSet rs = stm.executeQuery("SELECT * FROM becas")
        ){
            while (rs.next()){
                BeanBecas beanBecas = new BeanBecas();
                beanBecas.setIdBeca(rs.getInt("id_beca"));
                beanBecas.setTipoBeca(rs.getString("tipo_beca"));
                beanBecas.setEstado(rs.getString("estado"));

                listaBecas.add(beanBecas);
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return listaBecas;
    }

    public BeanBecas encontrarporId(int idBeca) {
        BeanBecas beanbeca = new BeanBecas();
        try (Connection con = new ConnectionMySQL().getConnection()){
            try(PreparedStatement pstm = con.prepareStatement("SELECT * FROM becas where id_beca = ? ")){
                pstm.setInt(1, idBeca);
                ResultSet rs = pstm.executeQuery();
                if (rs.next()){
                    beanbeca.setIdBeca (rs.getInt("id_beca"));
                    beanbeca.setTipoBeca(rs.getString("tipo_beca"));
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return beanbeca ;
    }

    public boolean actualizar (BeanBecas beanBecas) {
        try (Connection con = ConnectionMySQL.getConnection()){
            try(PreparedStatement pstm = con.prepareStatement(
                    "UPDATE becas SET tipo_beca = ?, estado = ? where id_beca = ?")){
                pstm.setString(1, beanBecas.getTipoBeca());
                pstm.setString(2, beanBecas.getEstado());
                pstm.setInt(3, beanBecas.getIdBeca());
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
