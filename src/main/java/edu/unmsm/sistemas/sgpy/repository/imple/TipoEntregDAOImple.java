/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.repository.imple;

import edu.unmsm.sistemas.sgpy.entities.TipoEntreg;
import edu.unmsm.sistemas.sgpy.repository.DAOConnection;
import edu.unmsm.sistemas.sgpy.repository.TipoEntregDAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import org.apache.commons.logging.*;

/**
 *
 * @author lucho
 */
public class TipoEntregDAOImple implements TipoEntregDAO{
 private static final TipoEntregDAO TIPOENTREGDAO = new TipoEntregDAOImple();
    // Recoge el objeto DAOConnection
    private final DAOConnection miDao = DAOConnection.getInstance();
    private static final Log LOG = LogFactory.getLog(TipoEntregDAOImple.class);

    public static TipoEntregDAO getInstance() {
        return TIPOENTREGDAO;
    }
    @Override
    public List<TipoEntreg> listarEntity() {
         // ArrayList donde se guardan los documentos
        List<TipoEntreg> misTipoEntreg = new ArrayList<>();
        try {
            // Obtener la conexion
            Connection conn = miDao.getConexion();

            // Se llama al procedimiento almacenado SP_LISTAR_ESTADOE
            try (CallableStatement consulta = conn.prepareCall("{ CALL LISTAR.SP_LIST_TIPOENTREG (?) }")) {
                // Se pasa por parametro el cursor
                consulta.registerOutParameter(1, OracleTypes.CURSOR);
                // Se ejecuta la consulta
                consulta.execute();

                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(1)) {

                    while (resultado.next()) {
                        TipoEntreg tipoEntreg = new TipoEntreg();
                        
                        tipoEntreg.setTipoEntreg(resultado.getInt("TIPOENTREG"));
                        tipoEntreg.setDeEntreg(resultado.getString("DESENTREG"));
                        tipoEntreg.setVigencia(resultado.getString("VIGENCIA"));
                        
                        misTipoEntreg.add(tipoEntreg);
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            miDao.close();
        }
        LOG.info("Esta es la lista " + misTipoEntreg);
        return misTipoEntreg;
    }

    @Override
    public String insertar(TipoEntreg nuevo) {
        String msj = "Se insertaron los datos correctamente.";
        Connection conn = miDao.getConexion();

        try {
            conn.setAutoCommit(false);
            try (CallableStatement consulta = conn.prepareCall("{ CALL INSERTAR.SP_INSERT_TIPOENTREG (?,?,?) }")) {
                consulta.setInt(1, nuevo.getTipoEntreg());
                consulta.setString(2, nuevo.getDeEntreg());
                consulta.setString(3, nuevo.getVigencia());

                consulta.execute();
            } 
            conn.commit();  
        } catch (SQLException ex) {
            msj = ex.getMessage();
        } finally{
            miDao.close();
        }
        return msj;
    }

    @Override
    public String actualizar(TipoEntreg modificacion) {
        String msj = "Se actualizaron los datos correctamente.";
        Connection conn = miDao.getConexion();
        String sql = "{ CALL UPDATES.SP_UPDATE_TIPOENTREG (?,?,?) }";

        try {
            conn.setAutoCommit(false);
            try (CallableStatement consulta = conn.prepareCall(sql)) {
                consulta.setInt(1, modificacion.getTipoEntreg());
                consulta.setString(2, modificacion.getDeEntreg());
                consulta.setString(3, modificacion.getVigencia());

                consulta.execute();
            } 
            conn.commit();  
        } catch (SQLException ex) {
            msj = ex.getMessage();
        } finally{
            miDao.close();
        }
        return msj;
    }

    @Override
    public String eliminar(int tipoEntreg) {
        String msj = "Se eliminaron los datos correctamente.";
        Connection conn = miDao.getConexion();
        String sql = "{ CALL DELETES.SP_DELETE_TIPOENTREG (?) }";

        try {
            conn.setAutoCommit(false);
            try (CallableStatement consulta = conn.prepareCall(sql)) {
                consulta.setInt(1, tipoEntreg);
                consulta.execute();
            } 
            conn.commit();  
        } catch (SQLException ex) {
            msj = ex.getMessage();
        } finally{
            miDao.close();
        }
        return msj;
    }
    
}
