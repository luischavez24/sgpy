package edu.unmsm.sistemas.sgpy.repository.imple;

import edu.unmsm.sistemas.sgpy.entities.PytoDocs;
import edu.unmsm.sistemas.sgpy.entities.PytoDocsView;
import edu.unmsm.sistemas.sgpy.repository.DAOConnection;
import edu.unmsm.sistemas.sgpy.repository.PytoDocsDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.*;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;

public class PytoDocsDAOImple implements PytoDocsDAO {

    // Crea una instancia de la clase al momento de lanzar la apliacion
    private static final PytoDocsDAOImple PYTODOCSDAO = new PytoDocsDAOImple();
    // Recoge el objeto DAOConnection
    private final DAOConnection miDao = DAOConnection.getInstance();

    public static PytoDocsDAOImple getInstance() {
        return PYTODOCSDAO;
    }

    @Override
    public List<PytoDocsView> listar() {

        // ArrayList donde se guardan los documentos
        ArrayList<PytoDocsView> misProyectos = new ArrayList<>();

        try {
            // Obtener la conexion
            Connection conn = miDao.getConexion();

            // Se llama al procedimiento almacenado SP_LISTAR_PYTODOCS
            try (CallableStatement consulta = conn.prepareCall("{ CALL SP_LISTAR_PYTODOCS (?) }")) {
                // Se pasa por parametro el cursor
                consulta.registerOutParameter(1, OracleTypes.CURSOR);
                // Se ejecuta la consulta
                consulta.execute();

                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(1)) {

                    PytoDocsView temp;
                    String verDoc, vigente, desFase, desNivel, desTDoc, desEntreg;
                    int codPyto, corrdocs;
                    Date fecIni, fecFin;
                    double costoEst;

                    while (resultado.next()) {

                        codPyto = resultado.getInt("CodPyto");
                        corrdocs = resultado.getInt("Corrdocs");
                        fecIni = resultado.getDate("FecIni");
                        fecFin = resultado.getDate("FecFin");
                        costoEst = resultado.getDouble("CostoEst");  //
                        verDoc = resultado.getString("VerDoc");   //version documentos
                        vigente = resultado.getString("Vigente");
                        desFase = resultado.getString("DesFase");
                        desNivel = resultado.getString("DesNivel");
                        desTDoc = resultado.getString("DesTDoc");
                        desEntreg = resultado.getString("DesEntreg");

                        temp = new PytoDocsView(codPyto, corrdocs, fecIni, fecFin, costoEst,
                                verDoc, vigente, desFase, desNivel, desTDoc, desEntreg);

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
    public String insertar(PytoDocs nuevo) {

        String msj = "Se insertaron los datos correctamente.";
        Connection conn = miDao.getConexion();
        SimpleDateFormat format_fecha = new SimpleDateFormat("dd/MM/yy");

        try {
            conn.setAutoCommit(false);
            try (CallableStatement consulta = conn.prepareCall("{ CALL SP_INSERTAR_PYDOCS (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }")) {
                consulta.setInt(1, nuevo.getCodPyto());
                consulta.setInt(2, nuevo.getCodFase());
                consulta.setInt(3, nuevo.getCodNivel());
                consulta.setString(4, format_fecha.format(nuevo.getFecIni()));
                consulta.setString(5, format_fecha.format(nuevo.getFecFin()));
                consulta.setDouble(6, nuevo.getCostoEst());
                consulta.setInt(7, nuevo.getCodDoc());
                consulta.setString(8, nuevo.getRutaDoc());
                consulta.setString(9, nuevo.getVerDoc());
                consulta.setString(10, nuevo.getObservac());
                consulta.setInt(11, nuevo.getEstPyto());
                consulta.setInt(12, nuevo.getTipoEntreg());
                consulta.setInt(13, nuevo.getCorrEntreg());
                consulta.setInt(14, nuevo.getCodEsp());
                consulta.setInt(15, nuevo.getCodResp());
                consulta.setString(16, nuevo.getVigente());

                msj = (consulta.execute()) ? "No se pudo ejecutar la inserción" : "Correcto";
            }

            conn.commit();
            miDao.close();

        } catch (SQLException ex) {
            msj = ex.getMessage();
            System.out.println(ex);
        }

        return msj;
    }

    @Override
    public String actualizar(PytoDocs modificacion) {
        String msj = "Se actualizaron los datos correctamente.";
        Connection conn = miDao.getConexion();
        String sql = "{ CALL SP_UPDATE_PYTODOCS (?,?,?,?,?,?,?,?,?,?,?,?,?) }";
        SimpleDateFormat format_fecha = new SimpleDateFormat("dd/MM/yy");

        try {
            conn.setAutoCommit(false);
            try (CallableStatement consulta = conn.prepareCall(sql)) {
                consulta.setInt(1, modificacion.getCodPyto());
                consulta.setInt(2, modificacion.getCorrdocs());
                consulta.setInt(3, modificacion.getCodFase());
                consulta.setInt(4, modificacion.getCodNivel());
                consulta.setInt(5, modificacion.getEstPyto());
                consulta.setString(6, format_fecha.format(modificacion.getFecFin()));
                consulta.setDouble(7, modificacion.getCostoEst());
                consulta.setString(8, modificacion.getRutaDoc());
                consulta.setString(9, modificacion.getVerDoc());
                consulta.setString(10, modificacion.getObservac());
                consulta.setInt(11, modificacion.getCodEsp());
                consulta.setInt(12, modificacion.getCodResp());
                consulta.setString(13, modificacion.getVigente());

                msj = (consulta.executeUpdate() == 0) ? "No se pudo ejecutar la actualizaron de datos" : "Correcto";
            }
            conn.commit();
            conn.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return msj;
    }

    @Override
    public String eliminar(int cod_pyto, int cod_doc) {
        String msj = "Se actualizaron los datos correctamente.";
        Connection conn = miDao.getConexion();
        String sql = "{ CALL SP_DELETE_PYTODOCS (?,?) }";

        try {
            conn.setAutoCommit(false);
            try (CallableStatement consulta = conn.prepareCall(sql)) {
                consulta.setInt(1, cod_pyto);
                consulta.setInt(2, cod_doc);
            
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
