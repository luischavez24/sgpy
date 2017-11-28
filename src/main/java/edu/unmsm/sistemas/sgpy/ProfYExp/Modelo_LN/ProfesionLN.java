/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.ProfYExp.Modelo_LN;

import edu.unmsm.sistemas.sgpy.ProfYExp.Modelo.Profesion;
import edu.unmsm.sistemas.sgpy.ProfYExp.Modelo_DAO.ProfesionDAO;
import java.sql.ResultSet;

/**
 *
 * @author VIDEOTECA
 */
public class ProfesionLN {
    
      ResultSet rs;
      ProfesionDAO prd = new ProfesionDAO(); 
      public String retornarNombre(String descripcion){
        String nombre = "";
        for(int i=0;i<descripcion.length();i++){
            if(descripcion.charAt(i)== '/'){
                break;
            }
            nombre=nombre + descripcion.charAt(i);
        }
        return nombre;
    }
    
    public String retornarArea(String descripcion){
        String area = "";
        for(int i=0;i<descripcion.length();i++){
            if(descripcion.charAt(i)== '/'){
               for(int j=i+1;j<descripcion.length();j++){
                   area=area+ descripcion.charAt(j);
               }
               break;
            }
        }
        return area;
    }
    
    public Profesion buscarProfesion(String codigo) throws Exception{
            System.out.println("Entro a buscar");
          boolean bandera=false;
          String nombre,area;
          Profesion pf=new Profesion();
          rs=prd.listarPorVigencia("1");
          System.out.println("Listo");
          while(rs.next()){
                if(rs.getInt(1)== Integer.parseInt(codigo) ){
                    System.out.println("Estoy entrando a la compración");
                    pf.setCodigo_Profesion(rs.getInt(1));
                    pf.setGrado_Profesion(rs.getString(2));
                    nombre=retornarNombre(rs.getString(3));
                    area=retornarArea(rs.getString(3));
                    pf.setNombre_Profesion(nombre);
                    pf.setArea(area);
                    bandera=true;
                }
           }
           
           if(!bandera){
               return null;
           }
           else{
               return pf;
           }   
     }
     
    public int retornarIndiceGrado(String nomGrado){
        int index=0;
        switch(nomGrado){
            case "T": index=1;
                                    break;
            case "B": index=2;
                                    break;
            case "P": index=3;
                                    break;
            case "M": index=4;
                                    break;
            case "D": index=5;
                                    break;
            case "H": index=6;
                                    break;
       }
        return index;
    }
    
    public int retornarIndiceArea(String nomArea){
        int index=0;
       switch(nomArea){
            case "Ciencias Básicas": index=1;
                                    break;
            case "Ingenierías": index=2;
                                    break;
            case "Económico Empresarial": index=3;
                                          break;
       }
        
        return index;
    }
    
    public String retornarNombreGrado(String grado){
        String nomGrado="";
        switch(grado){
            case "Técnico" : nomGrado="T";
                              break; 
            case "Bachiller":nomGrado="B";
                              break; 
            case "Título Profesional":nomGrado="P";
                                      break; 
            case "Maestría":nomGrado="M";
                                      break; 
            case "Doctorado":nomGrado="D";
                                      break; 
            case "Post-Doctorado":nomGrado="H";
                                      break; 
        }
        return nomGrado;
    }
}
