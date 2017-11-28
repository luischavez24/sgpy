/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.Persona.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Halion
 */
public class PersonaTicsDAO {
    private Conexion conectar;
    
    public PersonaTicsDAO(){
        conectar=new Conexion();
        conectar.Conectar();
    }
    public String insertarPersonaTics(int codPersona, int codTics, String desMedio, String vigente){
        String rptaRegistro=null;
        try{
        Connection accesoBD = conectar.getConexion();
            String sql = "{call PersonaTicsDAO.sp_insertarPersonaTics(?,?,?,?) }";
            CallableStatement cs = accesoBD.prepareCall(sql);
            cs.setInt(1,codPersona);
            cs.setInt(2,codTics);
            cs.setString(3,desMedio);
            cs.setString(4,vigente);
            int numFAfectas = cs.executeUpdate();
            if(numFAfectas>0){
                rptaRegistro = "Registro exitoso";
            }
        }catch(Exception e){
            
        }
        
        return rptaRegistro;        
    }
    
    public ArrayList<PersonaTics> listPersonaTics(){
        ArrayList<PersonaTics> listaPersonaTics = new ArrayList();
        PersonaTics perTics;
        try{
            Connection acceBD = conectar.getConexion();
            String sql = "{call PersonaTicsDAO.listar_PersonaTics(?) }";
            CallableStatement cs = acceBD.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = ((OracleCallableStatement)cs).getCursor(1);
            while(rs.next()){
                perTics = new PersonaTics();
                perTics.setCodPersona(rs.getInt(1));
                perTics.setCodTics(rs.getInt(2));
                perTics.setDesMedio(rs.getString(3));
                perTics.setVigente(rs.getString(4));
                listaPersonaTics.add(perTics);
            }
        }catch(Exception e){
            
        }
        return listaPersonaTics;
    }
    public ArrayList<PersonaTics> busqueda(int codPersona){
        ArrayList<PersonaTics> listaPersonaTics = new ArrayList();
        ArrayList<PersonaTics> listaPersonaTics2 = new ArrayList();
        listaPersonaTics = listPersonaTics();
        for (int i = 0; i < listaPersonaTics.size(); i++) {
            PersonaTics aux = new PersonaTics();
            if(listaPersonaTics.get(i).getCodPersona()==codPersona){
                aux = listaPersonaTics.get(i);
                listaPersonaTics2.add(aux);
            }
        }
        return listaPersonaTics2;
    }
    public String modificarPersonaTics(int codPersona, int codTics, String desMedio, String vigente){
        String rptaRegistro=null;
        try{
        Connection accesoBD = conectar.getConexion();
            String sql = "{call PersonaTicsDAO.sp_modficarPersonaTics(?,?,?,?) }";
            CallableStatement cs = accesoBD.prepareCall(sql);
            cs.setInt(1,codPersona);
            cs.setInt(2,codTics);
            cs.setString(3,desMedio);
            cs.setString(4,vigente);
            int numFAfectas = cs.executeUpdate();
            if(numFAfectas>0){
                rptaRegistro = "Modificacion exitosa";
            }
        }catch(Exception e){
            
        }
        
        return rptaRegistro;        
    }
}
