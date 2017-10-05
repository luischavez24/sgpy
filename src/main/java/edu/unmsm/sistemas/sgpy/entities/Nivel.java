/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.entities;

/**
 *
 * @author lucho
 */
public class Nivel {
        private int CodFase;
        private int CodNivel;
        private String DesNivel;
        private String Fase;
        private String Vigente;

    public Nivel(int CodFase, int CodNivel, String DesNivel, String Fase, String Vigente) {
        this.CodFase = CodFase;
        this.CodNivel = CodNivel;
        this.DesNivel = DesNivel;
        this.Fase = Fase;
        this.Vigente = Vigente;
    }
        
    public int getCodFase() {
        return CodFase;
    }

    public void setCodFase(int CodFase) {
        this.CodFase = CodFase;
    }

    public int getCodNivel() {
        return CodNivel;
    }

    public void setCodNivel(int CodNivel) {
        this.CodNivel = CodNivel;
    }

    public String getDesNivel() {
        return DesNivel;
    }

    public void setDesNivel(String DesNivel) {
        this.DesNivel = DesNivel;
    }

    public String getFase() {
        return Fase;
    }

    public void setFase(String Fase) {
        this.Fase = Fase;
    }

    public String getVigente() {
        return Vigente;
    }

    public void setVigente(String Vigente) {
        this.Vigente = Vigente;
    }

    @Override
    public String toString() {
        return DesNivel;
    }
        
}
