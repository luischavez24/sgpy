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
 * @author CARLOS
 */
public class ProvinciaDAO {
    private Conexion conectar;
    
    public ProvinciaDAO (){
        conectar=new Conexion();
        conectar.Conectar();
    }
    
    public ArrayList<Provincia> listProvincia(){
        ArrayList<Provincia> listaProvincia = new ArrayList();
        Provincia prov;
        try{
            Connection acceBD = conectar.getConexion();
            String sql = "{call listar_Provincias(?) }";
            CallableStatement cs = acceBD.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = ((OracleCallableStatement)cs).getCursor(1);
            while(rs.next()){
                prov = new Provincia();
                prov.setCodDpto(rs.getString(1));
                prov.setCodProv(rs.getString(2));
                prov.setDesProv(rs.getString(3));
                listaProvincia.add(prov);
            }
        }catch(Exception e){
            
        }
        return listaProvincia;
    }
    public String busquedaProvincia(String cod1,String cod2){
        String resultado = new String();
        ArrayList<Provincia> aux = new ArrayList();
        aux = listProvincia();
        for (int i = 0; i < aux.size(); i++) {
            if(aux.get(i).getCodDpto().equals(cod1) && aux.get(i).getCodProv().equals(cod2)){
                resultado = aux.get(i).getDesProv();
                break;
            }
        }
        return resultado;
    }
    
}
