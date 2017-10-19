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
public class TipoDoc {

    private int codDoc;
    private String desTDoc;
    private String vigente;

    public TipoDoc(int codDoc, String desTDoc, String vigente) {
        this.codDoc = codDoc;
        this.desTDoc = desTDoc;
        this.vigente = vigente;
    }

    public int getCodDoc() {
        return codDoc;
    }

    public void setCodDoc(int codDoc) {
        this.codDoc = codDoc;
    }

    public String getDesTDoc() {
        return desTDoc;
    }

    public void setDesTDoc(String desTDoc) {
        this.desTDoc = desTDoc;
    }

    public String getVigente() {
        return vigente;
    }

    public void setVigente(String vigente) {
        this.vigente = vigente;
    }

    @Override
    public String toString() {
        return desTDoc;
    }
}
