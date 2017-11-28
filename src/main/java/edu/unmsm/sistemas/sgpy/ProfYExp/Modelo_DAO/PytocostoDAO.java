/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.ProfYExp.Modelo_DAO;

import edu.unmsm.sistemas.sgpy.ProfYExp.Conexion.Conexion;
import static edu.unmsm.sistemas.sgpy.ProfYExp.Conexion.Conexion.getConnection;
import edu.unmsm.sistemas.sgpy.ProfYExp.Modelo.Pytocosto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MiguelSC
 */
public class PytocostoDAO {
    Connection connection;

    public void Insertar(Pytocosto pr) {
        try {
            CallableStatement csp = getConnection().prepareCall("{CALL  PACKAGE_COSTO.registrar_pytocosto(?,?,?,?,?,?,?,?,?,?,?,?)}");
            System.out.println("csp "+pr.getCodPyto());
            csp.setInt(1, pr.getCodPyto());
            System.out.println("csp "+pr.getCorrCosto());
            csp.setInt(2, pr.getCorrCosto());
            System.out.println("csp "+pr.getCodNivel());
            csp.setInt(3, pr.getCodNivel());
            System.out.println("csp "+pr.getCostoDir());
            csp.setInt(4, pr.getCostoDir());
            System.out.println("csp "+pr.getCostoEquip());
            csp.setInt(5, pr.getCostoEquip());
            System.out.println("csp "+pr.getCostoAdm());
            csp.setInt(6, pr.getCostoAdm());
            System.out.println("csp "+pr.getCostoImp());
            csp.setInt(7, pr.getCostoImp());
            System.out.println("csp "+pr.getCostoOtros());
            csp.setInt(8, pr.getCostoOtros());
            System.out.println("csp "+pr.getObservac());
            csp.setString(9, pr.getObservac());
            System.out.println("csp "+pr.getCostoPIP());
            csp.setInt(10, pr.getCostoPIP());
            System.out.println("csp "+pr.getVigente());
            csp.setString(11, pr.getVigente());
            System.out.println("csp "+pr.getCodFase());
            csp.setInt(12, pr.getCodFase());
            csp.executeUpdate();
            System.out.println("Pase");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(PytocostoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
    public ResultSet ListarPytocosto() throws Exception{
          connection=Conexion.getConnection();
          PreparedStatement ps = connection.prepareStatement("Select * from PYTOCOSTO");
          ResultSet rs= ps.executeQuery();
          return rs;
    }  
    
    
    public void Modificar(Pytocosto pr) {
        try {
            CallableStatement csp = getConnection().prepareCall("{CALL PACKAGE_COSTO.modificar_pytocosto(?,?,?,?,?,?,?,?,?,?,?,?)}");
            csp.setInt(1,pr.getCodPyto());
            csp.setInt(2, pr.getCorrCosto());
            csp.setInt(3, pr.getCodNivel());
            csp.setInt(4, pr.getCostoDir());
            csp.setInt(5, pr.getCostoEquip());
            csp.setInt(6, pr.getCostoAdm());
            csp.setInt(7, pr.getCostoImp());
            csp.setInt(8, pr.getCostoOtros());
            csp.setString(9, pr.getObservac());
            csp.setInt(10, pr.getCostoPIP());
            csp.setString(11, pr.getVigente());
            csp.setInt(12, pr.getCodFase());
            csp.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PytocostoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
