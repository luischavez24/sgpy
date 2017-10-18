package edu.unmsm.sistemas.sgpy.repository;

import edu.unmsm.sistemas.sgpy.constants.BDConstants;
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
            System.err.printf("A ocurrido el siguiente error en la aplicacion: %s\n", e.getMessage());
        }
        return miConexion;
    }


    public Connection getConexion() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //String url = "jdbc:oracle:thin:@localhost:1521:" + database;
           
            String url = "jdbc:oracle:thin:@192.168.1.48:1521:" + BDConstants.SID;
            miConexion = DriverManager.getConnection(url, BDConstants.USER, BDConstants.PASSWORD);

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Aqui esta el error");
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
