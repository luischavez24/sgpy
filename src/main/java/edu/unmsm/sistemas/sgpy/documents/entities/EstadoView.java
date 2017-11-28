/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.documents.entities;

/**
 *
 * @author Lupita
 */
public class EstadoView {
    private int estPyto;
    private String desNivel;
    private String desFase;
    private String desEstado;
    private String vigente;

    public EstadoView() {
    }
   
    public EstadoView(int estPyto, String desNivel, String desFase, String desEstado, String vigente) {
        this.estPyto = estPyto;
        this.desNivel = desNivel;
        this.desFase = desFase;
        this.desEstado = desEstado;
        this.vigente = vigente;
    }

    public int getEstPyto() {
        return estPyto;
    }

    public void setEstPyto(int estPyto) {
        this.estPyto = estPyto;
    }

    public String getDesNivel() {
        return desNivel;
    }

    public void setDesNivel(String desNivel) {
        this.desNivel = desNivel;
    }

    public String getDesFase() {
        return desFase;
    }

    public void setDesFase(String desFase) {
        this.desFase = desFase;
    }

    public String getDesEstado() {
        return desEstado;
    }

    public void setDesEstado(String desEstado) {
        this.desEstado = desEstado;
    }

    public String getVigente() {
        return vigente;
    }

    public void setVigente(String vigente) {
        this.vigente = vigente;
    }
    
    
    
}
