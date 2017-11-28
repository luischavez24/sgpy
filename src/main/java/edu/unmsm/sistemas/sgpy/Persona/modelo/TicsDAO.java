
package edu.unmsm.sistemas.sgpy.Persona.modelo;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
/**
 *
 * @author Halion
 */
public class TicsDAO {
    private Conexion conectar;
    
    public TicsDAO(){
        conectar=new Conexion();
        conectar.Conectar();
    }
    
    public String insertarTics(String desTics, String vigencia, FileInputStream file, int longBytes) {
        String rptaRegistro = null;
        try {
            Connection accesoBD = conectar.getConexion();
            String sql = "{call TicsDAO.sp_insertarTics(?,?,?) }";
            CallableStatement cs = accesoBD.prepareCall(sql);
            cs.setString(1, desTics);
            cs.setString(2, vigencia);
            cs.setBlob(3, file, longBytes);
            int numFAfectas = cs.executeUpdate();
            if (numFAfectas > 0) {
                rptaRegistro = "Registro exitoso";
            }
        } catch (Exception e) {

        }

        return rptaRegistro;
    }

    public ArrayList<Tics> listTics() {
        ArrayList<Tics> listaTics = new ArrayList();
        Tics tics;
        try {
            Connection acceBD = conectar.getConexion();
            String sql = "{call TicsDAO.listar_Tics(?) }";
            CallableStatement cs = acceBD.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = ((OracleCallableStatement)cs).getCursor(1);
            while (rs.next()) {
                tics = new Tics();
                tics.setCodTics(rs.getInt(1));
                tics.setDesTics(rs.getString(2));
                tics.setVigencia(rs.getString(3));
                Blob auxiliar = rs.getBlob(4);
                tics.setBytesLeidos(auxiliar.getBytes(1, (int) auxiliar.length()));
                listaTics.add(tics);
            }
        } catch (Exception e) {

        }
        return listaTics;
    }

    public String modificarTics(int codTics, String desTics, String vigencia) {
        String rptaModificar = null;
        try {
            Connection accesoBD = conectar.getConexion();
            String sql = "{call TicsDAO.sp_modificarTICS(?,?,?) }";
            CallableStatement cs = accesoBD.prepareCall(sql);
            cs.setInt(1, codTics);
            cs.setString(2, desTics);
            cs.setString(3, vigencia);
            int numFAfectas = cs.executeUpdate();
            if (numFAfectas > 0) {
                rptaModificar = "Modificación exitosa";
            }
        } catch (Exception e) {

        }

        return rptaModificar;
    }

    public String eliminarTics(int codTics) {
        String rptaRegistro = null;
        try {
            Connection accesoBD = conectar.getConexion();
            String sql = "{call TicsDAO.sp_eliminarTics(?) }";
            CallableStatement cs = accesoBD.prepareCall(sql);
            cs.setInt(1, codTics);
            int numFAfectas = cs.executeUpdate();
            if (numFAfectas > 0) {
                rptaRegistro = "Eliminación exitosa";
            }
        } catch (Exception e) {

        }

        return rptaRegistro;
    }
}
