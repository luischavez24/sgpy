package edu.unmsm.sistemas.sgpy.repository;


import java.sql.*;
import javax.sql.DataSource;

public class DAOConnection {

    private final static DAOConnection CONNECTION;
    private Connection miConexion;
    
    static {
        CONNECTION = new DAOConnection();
    }
    
    private DAOConnection() {
        miConexion = null;
    }

    public static DAOConnection getInstance() {
        return CONNECTION;
    }

    public Connection getConexion(DataSource source) {
        try {
            miConexion = source.getConnection();
        } catch (SQLException e) {
             System.err.printf("A ocurrido el siguiente error en la aplicacion: %s\n",e.getMessage());
        }
        return miConexion;
    }
    
    public Connection getConexion(String database, String user, String password) {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:" + database;
            miConexion = DriverManager.getConnection(url, user, password);

        } catch(ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return miConexion;
    }

    public int close() {
        int error = 0;
        try {
            miConexion.close();
        } catch (SQLException e) {
            error = 1;
        }

        return error;
    }
}
