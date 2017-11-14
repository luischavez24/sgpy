/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.repository.imple;

import edu.unmsm.sistemas.sgpy.entities.Fase;
import edu.unmsm.sistemas.sgpy.repository.DAOConnection;
import edu.unmsm.sistemas.sgpy.repository.ModeloIDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.*;

/**
 *
 * @author Alexander
 */
public class FaseDAOImple implements ModeloIDAO<Fase, Fase> {

    private static final FaseDAOImple FASEDAO = new FaseDAOImple();
    private final DAOConnection miDao = DAOConnection.getInstance(); 

    public static FaseDAOImple getInstance() {
        return FASEDAO;
    }

    @Override
    public List<Fase> listar() {
        List<Fase> miLista = new ArrayList<>();
        try {
            Connection conn = miDao.getConexion();
            try (CallableStatement consulta = conn.prepareCall("{ CALL LISTAR.SP_LIST_FASE (?) }")){
                consulta.registerOutParameter(1, OracleTypes.CURSOR);
                consulta.execute();
                try (ResultSet resultado = ((OracleCallableStatement)consulta).getCursor(1)){
                    while(resultado.next()){
                        Fase fase = new Fase();
                        fase.setCodFase(resultado.getInt("CODFASE"));
                        fase.setDesFase(resultado.getString("DESFASE"));
                        fase.setVigencia(resultado.getString("VIGENCIA"));
                        
                        miLista.add(fase);
                    }
                } 
            }
        } catch (SQLException ex) {
        } finally {
            miDao.close();
        }
        return miLista;
    }

    @Override
    public String insertar(Fase nuevo) {
        String rpta = "Insercion Completada";
        Connection conn = miDao.getConexion();
        
        try (CallableStatement consulta = conn.prepareCall("{ CALL INSERTAR.SP_INSERT_FASE (?,?,?) }")){

            consulta.setInt(1, nuevo.getCodFase());
            consulta.setString(2, nuevo.getDesFase());
            consulta.setString(3, nuevo.getVigencia());

            consulta.executeUpdate();

        } catch (SQLException ex) {
            rpta = ex.getMessage();
        } finally {
            miDao.close();
        }
        return rpta;
    }

    @Override
    public String actualizar(Fase actualizacion) {
        String rpta = "Actualización Completada";
        Connection conn = miDao.getConexion();
        
        try (CallableStatement comando = conn.prepareCall("{ CALL UPDATES.SP_UPDATE_FASE (?,?,?) }")){
            
            comando.setInt(1, actualizacion.getCodFase());
            comando.setString(2, actualizacion.getDesFase());
            comando.setString(3, actualizacion.getVigencia());
             
            comando.execute();

        } catch (SQLException ex) {
            rpta = ex.getMessage();
        } finally {
            miDao.close();
        }
        return rpta;
    }

    @Override
    public String eliminar(int codFase) {
        String rpta = "Eliminacion Completada";
        Connection conn = miDao.getConexion();
        
        try (CallableStatement consulta = conn.prepareCall("{ CALL DELETES.SP_DELETE_FASE (?) }")) {
            consulta.setInt(1, codFase);
            consulta.execute();
        } catch (SQLException ex) {
            rpta = ex.getMessage();
        } finally {
            miDao.close();
        }
        return rpta;
    }
}
