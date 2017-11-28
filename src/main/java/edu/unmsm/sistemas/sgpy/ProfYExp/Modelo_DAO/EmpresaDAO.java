/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.ProfYExp.Modelo_DAO;

import edu.unmsm.sistemas.sgpy.ProfYExp.Conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;
/**
 *
 * @author Casa
 */
public class EmpresaDAO {
     
    Connection connection;
      
    public ResultSet gerenteCumple(String fecha) throws SQLException{
        connection=Conexion.getConnection();
        ResultSet rs=null;
        CallableStatement ps = connection.prepareCall("{CALL EMPRESA.CUMPLE(?,?)}");
        ps.setString(1, fecha);
        ps.registerOutParameter(2, OracleTypes.CURSOR);
        ps.execute();
        rs=((OracleCallableStatement)ps).getCursor(2);
        return rs;
    }
}
