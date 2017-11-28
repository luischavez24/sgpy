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
public class Cliente extends Persona{
    private int CodCli;
    private int CorEmp;
    private String DesPliego;
    private String NroRuc;
    private int GerGener;
    private int GerInfraest;

    public Cliente(int CodCli, int CorEmp, String DesPliego, String NroRuc, int GerGener, int GerInfraest) {
        this.CodCli = CodCli;
        this.CorEmp = CorEmp;
        this.DesPliego = DesPliego;
        this.NroRuc = NroRuc;
        this.GerGener = GerGener;
        this.GerInfraest = GerInfraest;
    }

    public Cliente(){
        
    }
    public int getCodCli() {
        return CodCli;
    }

    public void setCodCli(int CodCli) {
        this.CodCli = CodCli;
    }

    public int getCorEmp() {
        return CorEmp;
    }

    public void setCorEmp(int CorEmp) {
        this.CorEmp = CorEmp;
    }

    public String getDesPliego() {
        return DesPliego;
    }

    public void setDesPliego(String DesPliego) {
        this.DesPliego = DesPliego;
    }

    public String getNroRuc() {
        return NroRuc;
    }

    public void setNroRuc(String NroRuc) {
        this.NroRuc = NroRuc;
    }

    public int getGerGener() {
        return GerGener;
    }

    public void setGerGener(int GerGener) {
        this.GerGener = GerGener;
    }

    public int getGerInfraest() {
        return GerInfraest;
    }

    public void setGerInfraest(int GerInfraest) {
        this.GerInfraest = GerInfraest;
    }
    
    
    
    
}
