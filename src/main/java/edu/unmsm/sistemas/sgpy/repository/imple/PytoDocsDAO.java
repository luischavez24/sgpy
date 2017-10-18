package edu.unmsm.sistemas.sgpy.repository.imple;

import edu.unmsm.sistemas.sgpy.constants.BDConstants;
import edu.unmsm.sistemas.sgpy.entities.PytoDocs;
import edu.unmsm.sistemas.sgpy.entities.PytoDocs_View;
import edu.unmsm.sistemas.sgpy.repository.DAOConnection;
import edu.unmsm.sistemas.sgpy.repository.ModeloIDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.*;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;

public class PytoDocsDAO implements ModeloIDAO<PytoDocs, PytoDocs_View> {

    // Crea una instancia de la clase al momento de lanzar la apliacion
    private static final PytoDocsDAO PYTODOCSDAO = new PytoDocsDAO();
    // Recoge el objeto DAOConnection
    private final DAOConnection miDao = DAOConnection.getInstance();

    public static PytoDocsDAO getInstance() {
        return PYTODOCSDAO;
    }

    @Override
    public List<PytoDocs_View> listar() {

        // ArrayList donde se guardan los documentos
        ArrayList<PytoDocs_View> misProyectos = new ArrayList<>();

        try {
            // Obtener la conexion
            Connection conn = miDao.getConexion(BDConstants.SID, BDConstants.USER, BDConstants.PASSWORD);

            // Se llama al procedimiento almacenado SP_LISTAR_PYTODOCS
            try (CallableStatement consulta = conn.prepareCall("{ CALL SP_LISTAR_PYTODOCS (?) }")) {
                // Se pasa por parametro el cursor
                consulta.registerOutParameter(1, OracleTypes.CURSOR);
                // Se ejecuta la consulta
                consulta.execute();

                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(1)) {

                    PytoDocs_View temp;
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

                        temp = new PytoDocs_View(codPyto, corrdocs, fecIni, fecFin, costoEst,
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
        Connection conn = miDao.getConexion(BDConstants.SID, BDConstants.USER, BDConstants.PASSWORD);
        SimpleDateFormat format_fecha = new SimpleDateFormat("dd/MM/yy");

        try {
            conn.setAutoCommit(false);
            try (CallableStatement consulta = conn.prepareCall("{ CALL SP_INSERTAR_PYDOCS (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }")) {
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
    public String actualizar(PytoDocs modificacion) {
        String msj = "Se actualizaron los datos correctamente.";
        Connection conn = miDao.getConexion(BDConstants.SID, BDConstants.USER, BDConstants.PASSWORD);
        String sql = "UPDATE proyecto SET Vigente=?, CostoEst=? WHERE cod_tesis = '"
                + modificacion.getCodDoc() + "'";

        try {
            conn.setAutoCommit(false);
            try (PreparedStatement consulta = conn.prepareStatement(sql)) {
                consulta.setString(1, modificacion.getVigente());
                consulta.setDouble(2, modificacion.getCostoEst());

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
    public String eliminar(int codigo) {
        // TODO Auto-generated method stub
        return null;
    }
}
