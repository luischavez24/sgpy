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
public class Fase {
    private int CodFase;
    private String DesFase;
    private String Vigencia;

    public Fase(int CodFase, String DesFase, String Vigencia) {
        this.CodFase = CodFase;
        this.DesFase = DesFase;
        this.Vigencia = Vigencia;
    }
    
    
    public int getCodFase() {
        return CodFase;
    }

    public void setCodFase(int CodFase) {
        this.CodFase = CodFase;
    }

    public String getDesFase() {
        return DesFase;
    }

    public void setDesFase(String DesFase) {
        this.DesFase = DesFase;
    }

    public String getVigencia() {
        return Vigencia;
    }

    public void setVigencia(String Vigencia) {
        this.Vigencia = Vigencia;
    }

    @Override
    public String toString() {
        return "Fase{" + "CodFase=" + CodFase + ", DesFase=" + DesFase + ", Vigencia=" + Vigencia + '}';
    }
    
}
