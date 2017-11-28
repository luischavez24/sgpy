/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.documents.model;

/**
 *
 * @author lucho
 */
public class Progreso {
    
    private double progreso;
    
    private static final Progreso PROGRESO = new Progreso();
    
    private Progreso() { }
    
    public static Progreso getInstance() {
        return PROGRESO;
    }

    public double getProgreso() {
        return progreso;
    }

    public void setProgreso(double progreso) {
        this.progreso = progreso;
    }  
}
