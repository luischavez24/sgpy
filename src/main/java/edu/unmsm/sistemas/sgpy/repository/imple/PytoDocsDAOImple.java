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
            try (CallableStatement consulta = conn.prepareCall("{ CALL SP_LIST_PYTODOCS (?) }")) {
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
        String msj = "Inserción ralizada correctamente";
        Connection conn = miDao.getConexion();
        SimpleDateFormat format_fecha = new SimpleDateFormat("dd/MM/yy");
        try {
            conn.setAutoCommit(false);
            try (CallableStatement consulta = conn.prepareCall("{ CALL SP_INSERT_PYTODOCS (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }")) {
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

                consulta.execute();
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
        String msj = "Actualización realizada correctamente";
        Connection conn = miDao.getConexion();
        String sql = "{ CALL SP_UPDATE_PYTODOCS (?,?,?,?,?,?,?,?,?,?,?) }";
        SimpleDateFormat format_fecha = new SimpleDateFormat("dd/MM/yy");

        try {
            conn.setAutoCommit(false);
            try (CallableStatement consulta = conn.prepareCall(sql)) {
                consulta.setInt(1, modificacion.getCodPyto());
                consulta.setInt(2, modificacion.getCorrdocs());
                consulta.setString(3, format_fecha.format(modificacion.getFecFin()));
                consulta.setDouble(4, modificacion.getCostoEst());
                consulta.setString(5, modificacion.getRutaDoc());
                consulta.setInt(6, modificacion.getCodDoc());
                consulta.setString(7, modificacion.getVerDoc());
                consulta.setString(8, modificacion.getObservac());
                consulta.setInt(9, modificacion.getCodEsp());
                consulta.setInt(10, modificacion.getCodResp());
                consulta.setString(11, modificacion.getVigente());

                consulta.execute();
            }
            conn.commit();
            conn.close();

        } catch (SQLException ex) {
            msj = ex.getMessage();
            System.out.println(ex);
        }

        return msj;
    }

    @Override
    public String eliminar(int cod_pyto, int cod_doc) {
        String msj = "Eliminacion Correcta";
        Connection conn = miDao.getConexion();
        String sql = "{ CALL SP_DELETE_PYTODOCS (?,?) }";

        try {
            conn.setAutoCommit(false);
            try (CallableStatement consulta = conn.prepareCall(sql)) {
                consulta.setInt(1, cod_pyto);
                consulta.setInt(2, cod_doc);

                consulta.execute();
            }
            conn.commit();
        } catch (SQLException ex) {
            msj = ex.getMessage();
        } finally {
            miDao.close();
        }
        return msj;
    }

    @Override
    public PytoDocs buscar(int cod_pyto, int corr_docs) {
        PytoDocs pytoDocs = null;
        try {
            // Obtener la conexion
            Connection conn = miDao.getConexion();
            // Se llama al procedimiento almacenado SP_LISTAR_PYTODOCS
            try (CallableStatement consulta = conn.prepareCall("{ CALL SP_BUSCAR_PYTODOCS (?,?,?) }")) {
                // Se pasa por parametro el cursor
                consulta.setInt(1, cod_pyto);
                consulta.setInt(2, corr_docs);
                consulta.registerOutParameter(3, OracleTypes.CURSOR);
                // Se ejecuta la consulta
                consulta.execute();
                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(3)) {

                    while (resultado.next()) {
                        pytoDocs = new PytoDocs();
                        pytoDocs.setCodPyto(resultado.getInt("CODPYTO"));
                        pytoDocs.setCorrdocs(resultado.getInt("CORRDOCS"));
                        pytoDocs.setCodFase(resultado.getInt("CODFASE"));
                        pytoDocs.setCodNivel(resultado.getInt("CODNIVEL"));
                        pytoDocs.setFecIni(resultado.getDate("FECINI"));
                        pytoDocs.setFecIni(resultado.getDate("FECFIN"));
                        pytoDocs.setCostoEst(resultado.getDouble("COSTOEST"));
                        pytoDocs.setCodDoc(resultado.getInt("CODDOC"));
                        pytoDocs.setRutaDoc(resultado.getString("RUTADOC"));
                        pytoDocs.setVerDoc(resultado.getString("VERDOC"));
                        pytoDocs.setObservac(resultado.getString("OBSERVAC"));
                        pytoDocs.setEstPyto(resultado.getInt("ESTPYTO"));
                        pytoDocs.setTipoEntreg(resultado.getInt("TIPOENTREG"));
                        pytoDocs.setCodEsp(resultado.getInt("CODESP"));
                        pytoDocs.setCodResp(resultado.getInt("CODRESP"));
                        pytoDocs.setVigente(resultado.getString("VIGENTE"));
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            miDao.close();
        }

        return pytoDocs;
    }

}
