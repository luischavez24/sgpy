package edu.unmsm.sistemas.sgpy.repository;

import edu.unmsm.sistemas.sgpy.constants.BDConstants;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import oracle.jdbc.pool.OracleDataSource;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

public class DAOConnection {
    
    private final static Log LOG = LogFactory.getLog(DAOConnection.class);
    
    private final static DAOConnection CONNECTION = new DAOConnection();
    private OracleDataSource datasource;
    private Connection miConexion;

    private DAOConnection() {
        try {
            miConexion = null;
            
            LOG.info("Obteniendo un Oracle DataSource");
            
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
            LOG.info("Conectando a la BD");
            
            miConexion = source.getConnection();
            
            LOG.info("Conexion exitosa a la BD");
            
        } catch (SQLException e) {
            LOG.error("A ocurrido el siguiente error en la aplicacion: " + e.getMessage());
        }
        return miConexion;
    }


    public Connection getConexion() {
        try {
            
            LOG.info("Conectando a la BD ...");
            LOG.info("Datos del servidor: URL=" + BDConstants.URL);
            
            Class.forName("oracle.jdbc.driver.OracleDriver");

            datasource.setURL(BDConstants.URL);
            datasource.setUser(BDConstants.USER);
            datasource.setPassword(BDConstants.PASSWORD);
            datasource.setLoginTimeout(5000);
            
            miConexion = datasource.getConnection();
            
            LOG.info("Conexion exitosa a la BD");
        } catch (ClassNotFoundException | SQLException ex) {
            
            LOG.error("A ocurrido el siguiente error en la aplicacion: " + ex.getMessage());
            
        }
        return miConexion;
    }

    public int close() {
        
        int error = 0;
        try {
            
            LOG.info("Cerrando conexion ...");
            
            miConexion.close();
            
            LOG.info("Conexion cerrada ");
            
        } catch (SQLException ex) {
            LOG.error("A ocurrido el siguiente error en la aplicacion: " + ex.getMessage());
            
            error = 1;
        }

        return error;
    }
}
