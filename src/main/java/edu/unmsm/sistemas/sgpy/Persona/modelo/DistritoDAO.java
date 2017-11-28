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
public class DistritoDAO {
    private Conexion conectar;
    
    public DistritoDAO (){
        conectar=new Conexion();
        conectar.Conectar();
    }
    
    public ArrayList<Distrito> listDistrito(){
        ArrayList<Distrito> listaDistrito = new ArrayList();
        Distrito dist;
        try{
            Connection acceBD = conectar.getConexion();
            String sql = "{call listar_Distrito(?) }";
            CallableStatement cs = acceBD.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = ((OracleCallableStatement)cs).getCursor(1);
            while(rs.next()){
                dist = new Distrito();
                dist.setCodDpto(rs.getString(1));
                dist.setCodProv(rs.getString(2));
                dist.setCodDist(rs.getString(3));
                dist.setDesDist(rs.getString(4));
                listaDistrito.add(dist);
            }
        }catch(Exception e){
            
        }
        return listaDistrito;
    }
    public String busquedaDistrito(String cod1,String cod2,String cod3){
        String resultado = new String();
        ArrayList<Distrito> aux = new ArrayList();
        aux = listDistrito();
        for (int i = 0; i < aux.size(); i++) {
            if(aux.get(i).getCodDpto().equals(cod1) && aux.get(i).getCodProv().equals(cod2) && aux.get(i).getCodDist().equals(cod3)){
                resultado = aux.get(i).getDesDist();
                break;
            }
        }
        return resultado;
    }
}
