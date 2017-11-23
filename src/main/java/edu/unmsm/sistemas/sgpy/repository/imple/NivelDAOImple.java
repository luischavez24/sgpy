/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.repository.imple;

import edu.unmsm.sistemas.sgpy.entities.Nivel;
import edu.unmsm.sistemas.sgpy.repository.DAOConnection;
import edu.unmsm.sistemas.sgpy.repository.NivelDAO;
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
 * @author Alexander
 */
public class NivelDAOImple implements NivelDAO {

    private static final NivelDAOImple NIVELDAO = new NivelDAOImple();

    public static NivelDAOImple getInstance() {
        return NIVELDAO;
    }
    DAOConnection acceso = DAOConnection.getInstance();
    
    @Override
    public List<Nivel> listar() {
        ArrayList<Nivel> miLista = new ArrayList<>(); //Indica implementar todos sus métodos
        try{
            Connection conn = acceso.getConexion();
            
            try(CallableStatement consulta = conn.prepareCall(" { CALL LISTAR.SP_LIST_NIVEL (?) } ")){
                consulta.registerOutParameter(1, OracleTypes.CURSOR);
                consulta.execute();
                
                try(ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(1)){
                    Nivel temp;
                    int CodFase,CodNivel;
                    String DesNivel,Fase,Vigente;
                    
                    while (resultado.next()) {
                        CodFase = resultado.getInt(1);
                        CodNivel = resultado.getInt(2);
                        DesNivel = resultado.getString(3);
                        Fase = resultado.getString(4);
                        Vigente = resultado.getString(5);
                        temp= new Nivel(CodFase,CodNivel,DesNivel,Fase,Vigente);
                        miLista.add(temp);                    }
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
    public String insertar(Nivel nuevo) {
        String rpta = "Insercion Completada";
        Connection conn = acceso.getConexion();
        try {
            conn.setAutoCommit(false);
            try(CallableStatement consulta = conn.prepareCall("{CALL INSERTAR.SP_INSERT_NIVEL (?,?,?,?,?)}")){
                consulta.setInt(1, nuevo.getCodFase());
                consulta.setInt(2, nuevo.getCodNivel());
                consulta.setString(3, nuevo.getDesNivel());
                consulta.setString(4, nuevo.getFase());
                consulta.setString(5, nuevo.getVigente());
                
                consulta.execute();
            } 
            conn.commit();  
        } catch (SQLException ex) {
            rpta = ex.getMessage();
        } finally{
            acceso.close();
        }
        return rpta;
    }

    @Override
    public String actualizar(Nivel actualizacion) {
        String rpta = "Actualizacion Completada";
        Connection conn = acceso.getConexion();
        try {
            conn.setAutoCommit(false);
            try(CallableStatement consulta = conn.prepareCall("{CALL UPDATES.SP_UPDATE_NIVEL (?,?,?,?,?) }")){
            consulta.setInt(1, actualizacion.getCodFase());
            consulta.setInt(2, actualizacion.getCodNivel());
            consulta.setString(3, actualizacion.getDesNivel());
            consulta.setString(4, actualizacion.getFase());
            consulta.setString(5, actualizacion.getVigente());
            
            consulta.execute();
            }
            conn.commit();
        } catch (SQLException ex) {
            rpta = ex.getMessage();
        } finally{
            acceso.close();
        }
        return rpta;
    }

    @Override
    public String eliminar(int CodFase, int CodNivel) {
        String rpta = "Eliminacion Completada";
        Connection conn = acceso.getConexion();
        try {
            conn.setAutoCommit(false);
            try(CallableStatement consulta = conn.prepareCall("{CALL DELETES.SP_DELETE_NIVEL (?,?)}")){
                consulta.setInt(1, CodFase);
                consulta.setInt(2, CodNivel);
                consulta.execute();
            }
            conn.commit();
        } catch (SQLException ex) {
            rpta = ex.getMessage();
        } finally {
            acceso.close();
        }
        return rpta;
    }
}
