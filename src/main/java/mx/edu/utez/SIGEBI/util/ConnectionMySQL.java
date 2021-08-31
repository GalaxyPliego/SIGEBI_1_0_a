package mx.edu.utez.SIGEBI.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.sql.ResultSet;


public class ConnectionMySQL {
    public static Connection getConnection() throws SQLException{
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sigebi1_0_a?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root",
                "clave"
        );
    }

    /*
        public static void main (String args[]) {
            try {
                Connection con = ConnectionMySQL.getConnection();
                System.out.println("Conexion establecida");
                con.close();
                System.out.println("Cerrando conexion");
            } catch (Exception ex) {
                System.out.println("Error de conexion");
                ex.printStackTrace();
            }
        */
    /*
    public static Connection getConnection() throws SQLException {
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://52.207.184.220/sigebi?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root";
        String pass = "utez.$SIGEBI}123";
        System.setProperty(driver, "");
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception e) {
            System.out.println(e);
        }
        con = DriverManager.getConnection (url, user, pass);
        return con;
    }*/
/*
    public static Connection getConnection() throws SQLException {
        String host = "127.0.0.1";
        String port = "3306";
        String database = "sigebi";
        String useSSL = "false";
        String timezone = "UTC";
        String url = String.format("jdbc:mysql://%s:%s/%s?useSSL=%s&serverTimezone=%s", host, port, database, useSSL, timezone);
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        return DriverManager.getConnection(url, "root", "utez.${SIGEBI}123");

    }
    public static void closeConnections(Connection con, CallableStatement cstm, ResultSet rs){
        try{
            if(rs != null){ rs.close(); }

            if(cstm != null){ cstm.close(); }

            if(con != null){ con.close(); }

        }catch(SQLException e){ }
    }

    public static void closeConnections(Connection con, CallableStatement cstm){
        try{
            if(cstm != null){ cstm.close(); }

            if(con != null){ con.close(); }

        }catch(SQLException e){ }
    }*/
    // public static void main(String[] args) {
    //  try {
    //   Connection e = ConectionMySql.getConnection();
    // System.out.println("Ok");
    // e.close();
    // } catch(SQLException e){
    //    System.out.println("Error: " +e.getMessage());
    // }
    //}
}
