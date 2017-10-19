/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.repository.imple;

import edu.unmsm.sistemas.sgpy.entities.TipoDoc;
import edu.unmsm.sistemas.sgpy.repository.DAOConnection;
import edu.unmsm.sistemas.sgpy.repository.TipoDocDAO;
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
 * @author Lupita
 */
public class TipoDocDAOImple implements TipoDocDAO{
    private static final TipoDocDAOImple TIPODOCDAO = new TipoDocDAOImple();

    private final DAOConnection miDao = DAOConnection.getInstance();

    public static TipoDocDAOImple getInstance() {
        return TIPODOCDAO;
    }

    @Override
    public List<TipoDoc> listar() {
        List<TipoDoc> misProyectos = new ArrayList<>();

        try {
            // Obtener la conexion
            Connection conn = miDao.getConexion();

            // Se llama al procedimiento almacenado SP_LISTAR_PYTODOCS
            try (CallableStatement consulta = conn.prepareCall("{ CALL SP_LISTAR_TIPODOC (?) }")) {
                // Se pasa por parametro el cursor
                consulta.registerOutParameter(1, OracleTypes.CURSOR);
                // Se ejecuta la consulta
                consulta.execute();

                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(1)) {

                    TipoDoc temp;
                    int codDoc;
                    String desTDoc;
                    String vigente;

                    while (resultado.next()) {

                        codDoc = resultado.getInt("codDoc");
                        desTDoc = resultado.getString("desTDoc");
                        vigente = resultado.getString("vigente");
                      
                        temp = new TipoDoc(codDoc, desTDoc, vigente);

                        misProyectos.add(temp);
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            miDao.close();
        }
        return misProyectos;
    }

    @Override
    public String insertar(TipoDoc nuevo) {
        String msj = "Se insertaron los datos correctamente.";
        Connection conn = miDao.getConexion();

        try {
            conn.setAutoCommit(false);
            try (CallableStatement consulta = conn.prepareCall("{ CALL SP_INSERTAR_TIPODOC (?,?,?) }")) {
                consulta.setInt(1, nuevo.getCodDoc());
                consulta.setString(2, nuevo.getDesTDoc());
                consulta.setString(3, nuevo.getVigente());

                msj = (consulta.executeUpdate() == 0) ? "No se pudo ejecutar la inserción" : "Correcto";
            }

            conn.commit();
            miDao.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return msj;
    }

    @Override
    public String actualizar(TipoDoc modificacion) {
        String msj = "Se actualizaron los datos correctamente.";
        Connection conn = miDao.getConexion();
        String sql = "{ CALL SP_UPDATE_TIPODOC (?,?,?,?,?,?,?,?,?,?,?,?,?) }";

        try {
            conn.setAutoCommit(false);
            try (CallableStatement consulta = conn.prepareCall(sql)) {
                consulta.setInt(1, modificacion.getCodDoc());
                consulta.setString(2, modificacion.getDesTDoc());
                consulta.setString(3, modificacion.getVigente());

                msj = (consulta.executeUpdate() == 0) ? "No se pudo ejecutar la actualización de datos" : "Correcto";
            }
            conn.commit();
            conn.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return msj;
    }

    @Override
    public String eliminar(int cod_doc) {
        String msj = "Se eliminaron los datos correctamente.";
        Connection conn = miDao.getConexion();
        String sql = "{ CALL SP_DELETE_TIPODOC (?) }";

        try {
            conn.setAutoCommit(false);
            try (CallableStatement consulta = conn.prepareCall(sql)) {
                consulta.setInt(1, cod_doc);
            
                msj = (consulta.executeUpdate() == 0) ? "No se pudo ejecutar la eliminación de datos" : "Correcto";
            }
            conn.commit();
            conn.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return msj;
    }
}
