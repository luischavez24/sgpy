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
public class Tics {
    private int codTics;
    private String desTics;
    private String vigencia;
    //Foto
    private byte[] bytesLeidos;

    public int getCodTics() {
        return codTics;
    }

    public void setCodTics(int codTics) {
        this.codTics = codTics;
    }

    public String getDesTics() {
        return desTics;
    }

    public void setDesTics(String desTics) {
        this.desTics = desTics;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public byte[] getBytesLeidos() {
        return bytesLeidos;
    }

    public void setBytesLeidos(byte[] bytesLeidos) {
        this.bytesLeidos = bytesLeidos;
    }
    
    

}
