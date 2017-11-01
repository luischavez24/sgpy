package edu.unmsm.sistemas.sgpy.repository;

import edu.unmsm.sistemas.sgpy.constants.BDConstants;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import oracle.jdbc.pool.OracleDataSource;

public class DAOConnection {

    private final static DAOConnection CONNECTION = new DAOConnection();
    private OracleDataSource datasource;
    private Connection miConexion;

    private DAOConnection() {
        try {
            miConexion = null;
            datasource = new OracleDataSource();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
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

            datasource.setURL(BDConstants.URL);
            datasource.setUser(BDConstants.USER);
            datasource.setPassword(BDConstants.PASSWORD);
            datasource.setLoginTimeout(5000);
            miConexion = datasource.getConnection();
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
