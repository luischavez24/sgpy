/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.repository.imple;

import edu.unmsm.sistemas.sgpy.entities.Entregables;
import edu.unmsm.sistemas.sgpy.repository.DAOConnection;
import edu.unmsm.sistemas.sgpy.repository.EntregablesDAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.*;

/**
 *
 * @author Alexander
 */
public class EntregablesDAOImple implements EntregablesDAO{

    private static final EntregablesDAOImple ENTREGABLESDAO = new EntregablesDAOImple();

    public static EntregablesDAOImple getInstance() {
        return ENTREGABLESDAO;
    }
    DAOConnection acceso = DAOConnection.getInstance();
    
    @Override
    public List<Entregables> listar() {
        
        ArrayList<Entregables> miLista = new ArrayList<>();
        try {
            Connection conn = acceso.getConexion();
            
            try(CallableStatement consulta = conn.prepareCall("{ CALL LISTAR.SP_LIST_ENTREGABLES (?) }")){
                consulta.registerOutParameter(1, OracleTypes.CURSOR);
                consulta.execute();
                try(ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(1)){
                    Entregables temp;
                    int TipoEntreg, CorrEntreg;
                    String DesEntreg, DesCortaEntreg;
                    
                    while (resultado.next()) {
                        TipoEntreg = resultado.getInt(1);
                        CorrEntreg = resultado.getInt(2);
                        DesEntreg = resultado.getString(3);
                        DesCortaEntreg = resultado.getString(4);
                        temp = new Entregables(TipoEntreg,CorrEntreg,DesEntreg,DesCortaEntreg);
                        
                        miLista.add(temp);
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            acceso.close();
        }
        return miLista;
    }

    @Override
    public String insertar(Entregables nuevo) {
        String rpta = "Insercion Completada";
        Connection conn = acceso.getConexion();
        try {
            conn.setAutoCommit(false);
            try(CallableStatement consulta = conn.prepareCall("{CALL INSERTAR.SP_INSERT_ENTREGABLES (?,?,?,?)}")){
                consulta.setInt(1, nuevo.getTipoEntreg());
                consulta.setInt(2, nuevo.getCorrEntreg());
                consulta.setString(3, nuevo.getDesEntreg());
                consulta.setString(4, nuevo.getDesCortaEntreg());
                
                consulta.execute();
            }
                
            conn.commit();
        } catch (SQLException ex) {
            rpta = ex.getMessage();
        }finally{
            acceso.close();
        }
        return rpta;
    }

    @Override
    public String actualizar(Entregables actualizacion) {
        String rpta = "Actualizacion Completada";
        Connection conn = acceso.getConexion();
        try{
            conn.setAutoCommit(false);
             try (CallableStatement consulta = conn.prepareCall("{CALL UPDATES.SP_UPDATE_ENTREGABLES (?,?,?,?) }")){
                consulta.setInt(1, actualizacion.getTipoEntreg());
                consulta.setInt(2, actualizacion.getCorrEntreg());
                consulta.setString(3, actualizacion.getDesEntreg());
                consulta.setString(4, actualizacion.getDesCortaEntreg());
                
                consulta.execute();
            } 
             
            conn.commit();
        }
       catch (SQLException ex) {
            rpta = ex.getMessage();
        }
        finally{
            acceso.close();
        }
        return rpta;
    }

    @Override
    public String eliminar(int TipoEntreg, int CorrEntreg){
        String rpta = "Eliminacion Completada";
        Connection conn = acceso.getConexion();
        try{
            conn.setAutoCommit(false);
            try(CallableStatement consulta = conn.prepareCall("{ CALL DELETES.SP_DELETE_ENTREGABLES (?,?)}")){
                consulta.setInt(1, TipoEntreg);
                consulta.setInt(2, CorrEntreg);
                consulta.execute();
            }
            conn.commit();
            
        }catch (SQLException ex) {
            rpta = ex.getMessage();
        }finally{
            acceso.close();
        }
        return rpta;
    }
}
