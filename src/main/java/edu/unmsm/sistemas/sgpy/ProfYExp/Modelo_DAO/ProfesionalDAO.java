
package edu.unmsm.sistemas.sgpy.ProfYExp.Modelo_DAO;

import edu.unmsm.sistemas.sgpy.ProfYExp.Conexion.Conexion;
import static edu.unmsm.sistemas.sgpy.ProfYExp.Conexion.Conexion.getConnection;
import edu.unmsm.sistemas.sgpy.ProfYExp.Modelo.Profesional;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class ProfesionalDAO {
    
    Connection connection;

    public void Insertar(Profesional pr) {
        try {
            CallableStatement csp = getConnection().prepareCall("{CALL PACKAGE_PROFESIONAL.INSERTAR_PROFESIONAL(?,?,?,?,?,?)}");
            csp.setString(1,pr.getNomPers());
            csp.setString(2, pr.getNomEmpresa());
            csp.setString(3, pr.getDesProf());
            csp.setString(4,pr.getNroCIP());
            csp.setString(5,pr.getUniversidad());
            csp.setString(6,pr.getVigente());
            csp.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfesionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Modificar(Profesional pr) {
        try {
            CallableStatement csp = getConnection().prepareCall("{CALL PACKAGE_PROFESIONAL.MODIFICAR_PROFESIONAL(?,?,?,?,?)}");
            csp.setString(1,pr.getNomPers());
            csp.setString(2, pr.getDesProf());
            csp.setString(3,pr.getNroCIP());
            csp.setString(4,pr.getUniversidad());
            csp.setString(5,pr.getVigente());
            csp.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void Eliminar(Profesional pr) {
        try {
            CallableStatement csp = getConnection().prepareCall("{CALL PACKAGE_PROFESIONAL.ELIMINAR_EMPLEADO(?,?)}");
            csp.setString(1,pr.getNomPers());
            csp.setString(2,  pr.getNomEmpresa());
            csp.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfesionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet BuscarProfesional(String codigo) throws Exception {
        connection=Conexion.getConnection();
        ResultSet rs=null;
        CallableStatement as = connection.prepareCall(" {CALL PACKAGE_PROFESIONAL.buscar_profesional(?,?)}");
        as.setInt(1, Integer.parseInt(codigo));
        as.registerOutParameter(2, OracleTypes.CURSOR);
        as.execute();
        rs=((OracleCallableStatement)as).getCursor(2);
        return rs;
    }
    
}