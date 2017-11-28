/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.FiltroDinamico;
/**
 *
 * @author Yshara
 */
public class Tabla {
    public String nom_tabla;
    public String[] columnas;
    private String alias;
    
    public Tabla (String nom_tabla, String alias){
        this.nom_tabla=nom_tabla;
        
        this.alias=alias;
    }

    public String getNom_tabla() {
        return nom_tabla;
    }

    public void setNom_tabla(String nom_tabla) {
        this.nom_tabla = nom_tabla;
    }

    public String[] getColumnas() {
        return columnas;
    }

    public void setColumnas(String[] columnas) {
        this.columnas = columnas;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
    
    
}
