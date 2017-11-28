/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.ProfYExp.Modelo;

/**
 *
 * @author Casa
 */
public class Profesion {
    private int codigo_Profesion;
    private String nombre_Profesion;
    private String grado_Profesion;
    private String area;
    private String vigente;

    public Profesion() {
    }

    public int getCodigo_Profesion() {
        return codigo_Profesion;
    }

    public void setCodigo_Profesion(int codigo_Profesion) {
        this.codigo_Profesion = codigo_Profesion;
    }

    
    public String getNombre_Profesion() {
        return nombre_Profesion;
    }

    public void setNombre_Profesion(String nombre_Profesion) {
        this.nombre_Profesion = nombre_Profesion;
    }

    public String getGrado_Profesion() {
        return grado_Profesion;
    }

    public void setGrado_Profesion(String grado_Profesion) {
        this.grado_Profesion = grado_Profesion;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getVigente() {
        return vigente;
    }

    public void setVigente(String vigente) {
        this.vigente = vigente;
    }
    
    
}
