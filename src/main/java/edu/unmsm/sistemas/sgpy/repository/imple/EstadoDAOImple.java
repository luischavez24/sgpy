/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.repository.imple;

import edu.unmsm.sistemas.sgpy.entities.Estado;
import edu.unmsm.sistemas.sgpy.entities.EstadoView;
import edu.unmsm.sistemas.sgpy.entities.PytoDocsView;
import edu.unmsm.sistemas.sgpy.repository.DAOConnection;
import edu.unmsm.sistemas.sgpy.repository.EstadoDAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Lupita
 */
public class EstadoDAOImple implements EstadoDAO{

    // Crea una instancia de la clase al momento de lanzar la apliacion
    private static final EstadoDAOImple ESTADODAO = new EstadoDAOImple();
    // Recoge el objeto DAOConnection
    private final DAOConnection miDao = DAOConnection.getInstance();

    public static EstadoDAOImple getInstance() {
        return ESTADODAO;
    }

    @Override
    public List<EstadoView> listar() {
        // ArrayList donde se guardan los documentos
        List<EstadoView> misEstados = new ArrayList<>();
        try {
            // Obtener la conexion
            Connection conn = miDao.getConexion();

            // Se llama al procedimiento almacenado SP_LISTAR_ESTADOPYTO
            try (CallableStatement consulta = conn.prepareCall("{ CALL SP_LISTAR_ESTADOPYTO (?) }")) {
                // Se pasa por parametro el cursor
                consulta.registerOutParameter(1, OracleTypes.CURSOR);
                // Se ejecuta la consulta
                consulta.execute();

                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(1)) {

                    EstadoView estado = new EstadoView();

                    while (resultado.next()) {
                        estado.setDesEstado(resultado.getString("DESESTADO"));
                        estado.setDesFase(resultado.getString("DESFASE"));
                        estado.setDesNivel(resultado.getString("DESNIVEL"));
                        estado.setEstPyto(resultado.getInt("ESTPYTO"));
                        misEstados.add(estado);
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            miDao.close();
        }
        return misEstados;
    }
    
    @Override
    public List<Estado> listarEntity() {
        // ArrayList donde se guardan los documentos
        List<Estado> misEstados = new ArrayList<>();
        try {
            // Obtener la conexion
            Connection conn = miDao.getConexion();

            // Se llama al procedimiento almacenado SP_LISTAR_ESTADOE
            try (CallableStatement consulta = conn.prepareCall("{ CALL SP_LISTAR_ESTADOE (?) }")) {
                // Se pasa por parametro el cursor
                consulta.registerOutParameter(1, OracleTypes.CURSOR);
                // Se ejecuta la consulta
                consulta.execute();

                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(1)) {

                    

                    while (resultado.next()) {
                        Estado estado = new Estado();
                        estado.setEstPyto(resultado.getInt("ESTPYTO"));
                        estado.setCodFase(resultado.getInt("CODFASE"));
                        estado.setCodNivel(resultado.getInt("CODNIVEL"));
                        estado.setDesEstado(resultado.getString("DESESTADO"));
                        estado.setVigente(resultado.getString("VIGENTE"));
                        misEstados.add(estado);
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            miDao.close();
        }
        return misEstados;
    }

    @Override
    public String insertar(Estado nuevo) {
        String msj = "Se insertaron los datos correctamente.";
        Connection conn = miDao.getConexion();
        SimpleDateFormat format_fecha = new SimpleDateFormat("dd/MM/yy");

        try {
            conn.setAutoCommit(false);
            try (CallableStatement consulta = conn.prepareCall("{ CALL SP_INSERTAR_estadopyto (?,?,?,?,?) }")) {

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
    public String actualizar(Estado modificacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String eliminar(int cod_fase, int cod_nivel, int est_pyto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
