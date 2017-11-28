
package edu.unmsm.sistemas.sgpy.ProfYExp.Modelo;

import java.sql.Date;


public class Experiencia {
    
    String NombPersona;
    String correxp;
    String lugar_trabajo;
    String fecIni;
    String fecFin;
    String destrabaho;
    String motivoretiro;
    String cargo;
    String nonmbreProfesion;
    String vigente;

    public String getNompers() {
        return NombPersona;
    }

    public void setNompers(String codpers) {
        this.NombPersona = codpers;
    }

    public String getCorrexp() {
        return correxp;
    }

    public void setCorrexp(String correxp) {
        this.correxp = correxp;
    }

    public String getLugar_trabajo() {
        return lugar_trabajo;
    }

    public void setLugar_trabajo(String lugar_trabajo) {
        this.lugar_trabajo = lugar_trabajo;
    }

    public String getFecIni() {
        return fecIni;
    }

    public void setFecIni(String fecIni) {
        this.fecIni = fecIni;
    }

    public String getFecFin() {
        return fecFin;
    }

    public void setFecFin(String fecFin) {
        this.fecFin = fecFin;
    }

    public String getDestrabaho() {
        return destrabaho;
    }

    public void setDestrabaho(String destrabaho) {
        this.destrabaho = destrabaho;
    }

    public String getMotivoretiro() {
        return motivoretiro;
    }

    public void setMotivoretiro(String motivoretiro) {
        this.motivoretiro = motivoretiro;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDescripcionprof() {
        return nonmbreProfesion;
    }

    public void setDescripcionprof(String codprof) {
        this.nonmbreProfesion = codprof;
    }

    public String getVigente() {
        return vigente;
    }

    public void setVigente(String vigente) {
        this.vigente = vigente;
    }
    
    
    
}
