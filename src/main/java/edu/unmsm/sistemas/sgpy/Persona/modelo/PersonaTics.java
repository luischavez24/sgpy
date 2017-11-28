/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.Persona.modelo;

/**
 *
 * @author Halion
 */
public class PersonaTics {
    int codPersona;
    int codTics;
    String desMedio;
    String vigente;

    public PersonaTics(int codPersona, int codTics, String desMedio, String vigente) {
        this.codPersona = codPersona;
        this.codTics = codTics;
        this.desMedio = desMedio;
        this.vigente = vigente;
    }

    public PersonaTics() {
    }

    
    public int getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(int codPersona) {
        this.codPersona = codPersona;
    }

    public int getCodTics() {
        return codTics;
    }

    public void setCodTics(int codTics) {
        this.codTics = codTics;
    }

    public String getDesMedio() {
        return desMedio;
    }

    public void setDesMedio(String desMedio) {
        this.desMedio = desMedio;
    }

    public String getVigente() {
        return vigente;
    }

    public void setVigente(String vigente) {
        this.vigente = vigente;
    }
    
    
    
}
