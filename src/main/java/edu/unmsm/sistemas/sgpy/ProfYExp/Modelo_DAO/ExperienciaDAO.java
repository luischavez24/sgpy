
package edu.unmsm.sistemas.sgpy.ProfYExp.Modelo_DAO;

import edu.unmsm.sistemas.sgpy.ProfYExp.Conexion.Conexion;
import static edu.unmsm.sistemas.sgpy.ProfYExp.Conexion.Conexion.getConnection;
import edu.unmsm.sistemas.sgpy.ProfYExp.Modelo.Experiencia;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class ExperienciaDAO {
    
    Connection connection;

    public void Insertar(Experiencia ex) {
        try {
            CallableStatement csp = getConnection().prepareCall("{CALL PACKAGE_EXPERIENCIA.REGISTRAR_EXPERIENCIA(?,?,?,?,?,?,?,?,?,?)}");
            csp.setString(1,ex.getNompers());
            csp.setString(2, ex.getCorrexp());
            csp.setString(3, ex.getLugar_trabajo());
            csp.setString(4,ex.getFecIni());
            csp.setString(5,ex.getFecFin());
            csp.setString(6,ex.getDestrabaho());
            csp.setString(7,ex.getMotivoretiro());
            csp.setString(8,ex.getCargo());
            csp.setString(9,ex.getDescripcionprof());
            csp.setString(10,ex.getVigente());
            csp.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ProfesionDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void Modificar(Experiencia ex) {
        try {
            CallableStatement csp = getConnection().prepareCall("{CALL PACKAGE_EXPERIENCIA.MODIFICAR_EXPERIENCIA(?,?,?,?,?,?,?,?,?,?)}");
            csp.setString(1,ex.getNompers());
            csp.setString(2, ex.getCorrexp());
            csp.setString(3, ex.getLugar_trabajo());
            csp.setString(4,ex.getFecIni());
            csp.setString(5,ex.getFecFin());
            csp.setString(6,ex.getDestrabaho());
            csp.setString(7,ex.getMotivoretiro());
            csp.setString(8,ex.getCargo());
            csp.setString(9,ex.getDescripcionprof());
            csp.setString(10,ex.getVigente());
            csp.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ProfesionDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    
    public ResultSet BuscarExperiencia(int codigo,String corrExp) throws Exception{
        connection=Conexion.getConnection();
        ResultSet rs=null;
        CallableStatement as = connection.prepareCall(" {CALL PACKAGE_EXPERIENCIA.buscar_experiencia(?,?,?)}");
        as.setInt(1, codigo);
        as.setString(2,corrExp);
        as.registerOutParameter(3, OracleTypes.CURSOR);
        as.execute();
        rs=((OracleCallableStatement)as).getCursor(3);
        return rs;
    }
    
    
}
