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

/**
 *
 * @author lucho
 */
public class TipoEntregDAOImple implements TipoEntregDAO{
 private static final TipoEntregDAO TIPOENTREGDAO = new TipoEntregDAOImple();
    // Recoge el objeto DAOConnection
    private final DAOConnection miDao = DAOConnection.getInstance();

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
            try (CallableStatement consulta = conn.prepareCall("{ CALL SP_LIST_TIPOENTREG (?) }")) {
                // Se pasa por parametro el cursor
                consulta.registerOutParameter(1, OracleTypes.CURSOR);
                // Se ejecuta la consulta
                consulta.execute();

                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(1)) {

                    TipoEntreg tipoEntreg = new TipoEntreg();

                    while (resultado.next()) {
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
        return misTipoEntreg;
    }

    @Override
    public String insertar(TipoEntreg nuevo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String actualizar(TipoEntreg modificacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String eliminar(int tipoEntreg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
