/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.FiltroDinamico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author MIGUEL
 */
public class G_filtro {
    Connection cone = Conexion.conectarbd();
    ArrayList<String> lista = new ArrayList<String>();
    ArrayList<String> listaProv = new ArrayList<String>();
    ArrayList<String> listaDist = new ArrayList<String>();
    String Cod_departamento="", Cod_provincia="", Cod_distrito="";

    public Connection getCone() {
        return cone;
    }

    public void setCone(Connection cone) {
        this.cone = cone;
    }

    
    public String getCod_departamento() {
        return Cod_departamento;
    }

    public void setCod_departamento(String Cod_departamento) {
        this.Cod_departamento = Cod_departamento;
    }

    public String getCod_provincia() {
        return Cod_provincia;
    }

    public void setCod_provincia(String Cod_provincia) {
        this.Cod_provincia = Cod_provincia;
    }

    public String getCod_distrito() {
        return Cod_distrito;
    }

    public void setCod_distrito(String Cod_distrito) {
        this.Cod_distrito = Cod_distrito;
    }

    
    
    
    
    public G_filtro(){
        
    }
    public ArrayList<String> cargar_departamento(){
        
        try { 
            String codigo = "select *from departamento";
            PreparedStatement pst = cone.prepareStatement(codigo);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
//                combo.addItem(rs.getString("nom_pais"));
                  lista.add(rs.getString("desdpto"));
//                    System.out.println(rs.getString("desdpto"));
                    
                  
            }
        } catch(Exception err){err.printStackTrace();}
        System.out.println(lista.size());
        return lista;
    }
    public void actualizar_departamento(String nomDep) throws SQLException{
        //funcion para guardar codigo de departamento
        String consulta = "select coddpto from departamento where desdpto=?";
        PreparedStatement pst = cone.prepareStatement(consulta);
        pst.setString(1, nomDep);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            Cod_departamento = rs.getString("coddpto");
        }
        System.out.println(Cod_departamento);
        
    }
    public void reiniciar_lista(){
        lista = new ArrayList<String>();
        lista.clear();
    }
    public ArrayList<String> cargar_provincia(){
        listaProv.clear();
        try { 
            String codigo = "select DesProv from provincia where codDpto=?";
            PreparedStatement pst = cone.prepareStatement(codigo);
            pst.setString(1, Cod_departamento);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){

                  listaProv.add(rs.getString("DesProv"));
                  
            }
        } catch(Exception err){err.printStackTrace();}
        
        return listaProv;
    }
    public ArrayList<String> cargar_distrito(){
        listaDist.clear();
        
        try { 
            String codigo = "select desdist from distrito where codprov=? and coddpto=?";
            PreparedStatement pst = cone.prepareStatement(codigo);
            pst.setString(1, Cod_provincia);
            pst.setString(2, Cod_departamento);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){

//                  System.out.println(rs.getString("DesDist"));
                  listaDist.add(rs.getString("desdist"));
                  
            }
        } catch(Exception err){err.printStackTrace();}
        return listaDist;
    }
    public void actualizar_provincia(String nomProv) throws SQLException{
        //funcion p¿ara guardar codigo de provincia
        try{
        String consulta = "select codprov from provincia where desprov=?";
        PreparedStatement pst = cone.prepareStatement(consulta);
        pst.setString(1, nomProv);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            Cod_provincia = rs.getString("codprov");
        }
        System.out.println(Cod_provincia);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void actualiza_distrito(String nomDist) throws SQLException{
        //funcion p¿ara guardar codigo de provincia
        
        String consulta = "select coddist from distrito where desdist=?";
        PreparedStatement pst = cone.prepareStatement(consulta);
        pst.setString(1, nomDist);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            Cod_distrito = rs.getString("coddist");
        }
        
    }
    
    
}
