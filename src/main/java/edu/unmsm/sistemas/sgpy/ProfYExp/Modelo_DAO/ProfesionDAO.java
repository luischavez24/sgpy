/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.ProfYExp.Modelo_DAO;

import edu.unmsm.sistemas.sgpy.ProfYExp.Conexion.Conexion;
import static edu.unmsm.sistemas.sgpy.ProfYExp.Conexion.Conexion.getConnection;
import edu.unmsm.sistemas.sgpy.ProfYExp.Modelo.Profesion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;


/**
 *
 * @author Casa
 */
public class ProfesionDAO {

    Connection connection;

     public void insertar(Profesion pr) {
        try {
            CallableStatement csp = getConnection().prepareCall("{CALL PACKAGE_PROFESION.registrar_profesion(?,?,?,?)}");
            csp.setInt(1,pr.getCodigo_Profesion());
            csp.setString(2, pr.getGrado_Profesion());
            csp.setString(3, pr.getNombre_Profesion()+"/"+pr.getArea());
            csp.setString(4,pr.getVigente());
            csp.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfesionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
   /* public ResultSet listarProfesion() throws Exception{
          connection=Conexion.getConnection();
          PreparedStatement ps = connection.prepareStatement("Select * from PROFESIONES");
          ResultSet rs= ps.executeQuery();
          return rs;
    }*/
    
    
     
    public ResultSet listarPorVigencia(String vig) throws SQLException{
        connection=Conexion.getConnection();
        ResultSet rs=null;
        CallableStatement ps = connection.prepareCall("{CALL PACKAGE_PROFESION.listar_profesiones(?,?)}");
        ps.setString(1, vig);
        ps.registerOutParameter(2, OracleTypes.CURSOR);
        ps.execute();
        rs=((OracleCallableStatement)ps).getCursor(2);
        
        return rs;
    }
    
     public void Modificar(Profesion pr) {
        try {
            CallableStatement csp = getConnection().prepareCall("{CALL PACKAGE_PROFESION.modificar_profesion(?,?,?,?)}");
            csp.setInt(1,pr.getCodigo_Profesion());
            csp.setString(2, pr.getGrado_Profesion());
            csp.setString(3, pr.getNombre_Profesion()+"/"+pr.getGrado_Profesion());
            csp.setString(4,pr.getVigente() );
            csp.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfesionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
}
