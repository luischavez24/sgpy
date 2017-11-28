/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.ProfYExp.Modelo_DAO;


import edu.unmsm.sistemas.sgpy.ProfYExp.Conexion.Conexion;
import static edu.unmsm.sistemas.sgpy.ProfYExp.Conexion.Conexion.getConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;


public class PersonaDAO {
    Connection connection;
    
     public ResultSet listarPersonaCliente() throws SQLException {
        connection=Conexion.getConnection();
        ResultSet rs=null;
         try {
            CallableStatement csp = getConnection().prepareCall("{CALL PACKAGE_PERSONA.LISTAR_PERSONACLIENTE(?)}");
            csp.registerOutParameter(1, OracleTypes.CURSOR);
            csp.execute();
            rs=((OracleCallableStatement)csp).getCursor(1);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return rs;
    }
     
    public ResultSet listarPersonaProfesional() throws SQLException {
        connection=Conexion.getConnection();
         ResultSet rs=null;
         try {
            CallableStatement csp = getConnection().prepareCall("{CALL PACKAGE_PERSONA.LISTAR_PERSONAPROFESIONAL(?)}");
            csp.registerOutParameter(1, OracleTypes.CURSOR);
            csp.execute();
            rs=((OracleCallableStatement)csp).getCursor(1);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
