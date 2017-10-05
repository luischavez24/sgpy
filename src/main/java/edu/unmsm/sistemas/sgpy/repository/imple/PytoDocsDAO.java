package edu.unmsm.sistemas.sgpy.repository.imple;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import edu.unmsm.sistemas.sgpy.entities.PytoDocs;
import edu.unmsm.sistemas.sgpy.entities.PytoDocs_View;
import edu.unmsm.sistemas.sgpy.repository.DAOConnection;
import edu.unmsm.sistemas.sgpy.repository.ModeloIDAO;
import java.sql.CallableStatement;

public class PytoDocsDAO implements ModeloIDAO<PytoDocs,PytoDocs_View> {
    public static final PytoDocsDAO PYTODOCSDAO;
    
    static {
        PYTODOCSDAO = new PytoDocsDAO();
    }
    
    DAOConnection miDao = DAOConnection.getInstance();
    private String nomb_bd = "basedatos1";
    private String user = "sgpy";
    private String pass = "Prueba$1";
    
    public static PytoDocsDAO getInstance(){
        return PYTODOCSDAO;
    }
    
    @Override
    public List<PytoDocs_View> listar() {
        // TODO Auto-generated method stub

        ArrayList<PytoDocs_View> misProyectos = new ArrayList<>();

        try {
            Connection conn = miDao.getConexion(nomb_bd, user, pass);

            PreparedStatement consulta = conn.prepareStatement("SELECT * FROM LISTAR_PYTODOCS");
            ResultSet resultado = consulta.executeQuery();

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
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            miDao.close();
        }
        return misProyectos;
    }

    @Override
    public String insertar(PytoDocs nuevo) {
        // TODO Auto-generated method stub
        String msj = "Se insertaron los datos correctamente.";
        Connection conn = miDao.getConexion(nomb_bd, user, pass);
        SimpleDateFormat format_fecha = new SimpleDateFormat("dd/MM/yy");

        try {
            conn.setAutoCommit(false);

            try ( //PreparedStatement consulta = conn.prepareStatement("INSERT INTO PYTODOCS VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    CallableStatement consulta = conn.prepareCall("{ CALL SP_INSERTAR_PYDOCS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }")) {
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
            conn.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return msj;
    }

    @Override
    public String actualizar(PytoDocs modificacion) {
        // TODO Auto-generated method stub
        String msj = "Se actualizaron los datos correctamente.";
        /*Connection conn = miDao.getConexion(nomb_bd, user, pass);
		SimpleDateFormat format_fecha = new SimpleDateFormat("dd/MM/yy");
		insertar(nuevo);
		
		try {
            conn.setAutoCommit(false);
            
            PreparedStatement consulta = conn.prepareStatement("INSERT INTO PYTODOCS VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            consulta.setInt(1, nuevo.getCodPyto());
            consulta.setInt(2, nuevo.getCorrdocs());
            consulta.setInt(3, nuevo.getCodFase());
            consulta.setInt(4, nuevo.getCodNivel());
            consulta.setString(5, format_fecha.format(nuevo.getFecIni()));
            consulta.setString(6, format_fecha.format(nuevo.getFecFin()));
            consulta.setDouble(7, nuevo.getCostoEst());   
            consulta.setInt(8, nuevo.getCodDoc());
            consulta.setString(9, nuevo.getRutaDoc());
            consulta.setString(10, nuevo.getVerDoc());
            consulta.setString(11, nuevo.getObservac());
            consulta.setInt(12, nuevo.getEstPyto());
            consulta.setInt(13, nuevo.getTipoEntreg());
            consulta.setInt(14, nuevo.getCorrEntreg());
            consulta.setInt(15, nuevo.getCodEsp());
            consulta.setInt(16, nuevo.getCodResp());
            consulta.setString(17, nuevo.getVigente());
           
            msj = (consulta.executeUpdate() == 0) ? "No se pudo ejecutar la inserción" : "Correcto";

            consulta.close();
            conn.commit();
            conn.close();

        } catch (SQLException ex) {
        	System.out.println(ex);
        }
         */
        return msj;
    }

    @Override
    public String eliminar(int codigo) {
        // TODO Auto-generated method stub
        return null;
    }

}
