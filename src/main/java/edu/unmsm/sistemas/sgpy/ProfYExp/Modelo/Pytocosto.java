/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.ProfYExp.Modelo;

/**
 *
 * @author MiguelSC
 */
public class Pytocosto {
    private int codPyto;
    private int corrCosto;
    private int codNivel;
    private int costoDir;
    private int costoEquip;
    private int costoAdm;
    private int costoImp;
    private int costoOtros;
    private String observac;
    private int CostoPIP;
    private String vigente;
    private int codFase;

    public Pytocosto() {
    }

   
    public int getCodPyto() {
        return codPyto;
    }

    public void setCodPyto(int codPyto) {
        this.codPyto = codPyto;
    }

    public int getCorrCosto() {
        return corrCosto;
    }

    public void setCorrCosto(int corrCosto) {
        this.corrCosto = corrCosto;
    }

    public int getCodNivel() {
        return codNivel;
    }

    public void setCodNivel(int codNivel) {
        this.codNivel = codNivel;
    }

    public int getCostoDir() {
        return costoDir;
    }

    public void setCostoDir(int costoDir) {
        this.costoDir = costoDir;
    }

    public int getCostoEquip() {
        return costoEquip;
    }

    public void setCostoEquip(int costoEquip) {
        this.costoEquip = costoEquip;
    }

    public int getCostoAdm() {
        return costoAdm;
    }

    public void setCostoAdm(int costoAdm) {
        this.costoAdm = costoAdm;
    }

    public int getCostoImp() {
        return costoImp;
    }

    public void setCostoImp(int costoImp) {
        this.costoImp = costoImp;
    }

    public int getCostoOtros() {
        return costoOtros;
    }

    public void setCostoOtros(int costoOtros) {
        this.costoOtros = costoOtros;
    }

    public String getObservac() {
        return observac;
    }

    public void setObservac(String observac) {
        this.observac = observac;
    }

    public int getCostoPIP() {
        return CostoPIP;
    }

    public void setCostoPIP(int CostoPIP) {
        this.CostoPIP = CostoPIP;
    }

    public String getVigente() {
        return vigente;
    }

    public void setVigente(String vigente) {
        this.vigente = vigente;
    }

    public int getCodFase() {
        return codFase;
    }

    public void setCodFase(int codFase) {
        this.codFase = codFase;
    }
    
    
}
