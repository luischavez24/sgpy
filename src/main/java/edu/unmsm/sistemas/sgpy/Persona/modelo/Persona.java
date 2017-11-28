/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.Persona.modelo;

import java.sql.Blob;
import java.util.Date;

/**
 *
 * @author Halion
 */
public class Persona {
    private int CodPers;
    private String TipPersona;
    private String DesPersona;
    private String DesCorta;
    private String FlagCli;
    private String FlagEsp;
    private String FlagProf;
    private String Direcc;
    private String Hobby;
    //Foto
    private byte[] bytesLeidos;
    private Blob foto;
    //
    private Date FecNac;
    private String CodDpto;
    private String CodProv;
    private String CodDist;
    private String DNI;
    private String NroCIP;
    private Date FecCIPVig;
    private int CentroTrabajo;
    private String Cargo;
    private String LicCond;
    private String Observac;
    private String Vigente;

    public Persona(){
        
    }


    public int getCodPers() {
        return CodPers;
    }

    public void setCodPers(int CodPers) {
        this.CodPers = CodPers;
    }

    public String getTipPersona() {
        return TipPersona;
    }

    public void setTipPersona(String TipPersona) {
        this.TipPersona = TipPersona;
    }

    public String getDesPersona() {
        return DesPersona;
    }

    public void setDesPersona(String DesPersona) {
        this.DesPersona = DesPersona;
    }

    public String getDesCorta() {
        return DesCorta;
    }

    public void setDesCorta(String DesCorta) {
        this.DesCorta = DesCorta;
    }

    public String getFlagCli() {
        return FlagCli;
    }

    public void setFlagCli(String FlagCli) {
        this.FlagCli = FlagCli;
    }

    public String getFlagEsp() {
        return FlagEsp;
    }

    public void setFlagEsp(String FlagEsp) {
        this.FlagEsp = FlagEsp;
    }

    public String getFlagProf() {
        return FlagProf;
    }

    public void setFlagProf(String FlagProf) {
        this.FlagProf = FlagProf;
    }

    public String getDirecc() {
        return Direcc;
    }

    public void setDirecc(String Direcc) {
        this.Direcc = Direcc;
    }

    public String getHobby() {
        return Hobby;
    }

    public void setHobby(String Hobby) {
        this.Hobby = Hobby;
    }

    public byte[] getBytesLeidos() {
        return bytesLeidos;
    }

    public void setBytesLeidos(byte[] bytesLeidos) {
        this.bytesLeidos = bytesLeidos;
    }

    public Date getFecNac() {
        return FecNac;
    }

    public void setFecNac(Date FecNac) {
        this.FecNac = FecNac;
    }

    public String getCodDpto() {
        return CodDpto;
    }

    public void setCodDpto(String CodDpto) {
        this.CodDpto = CodDpto;
    }

    public String getCodProv() {
        return CodProv;
    }

    public void setCodProv(String CodProv) {
        this.CodProv = CodProv;
    }

    public String getCodDist() {
        return CodDist;
    }

    public void setCodDist(String CodDist) {
        this.CodDist = CodDist;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNroCIP() {
        return NroCIP;
    }

    public void setNroCIP(String NroCIP) {
        this.NroCIP = NroCIP;
    }

    public Date getFecCIPVig() {
        return FecCIPVig;
    }

    public void setFecCIPVig(Date FecCIPVig) {
        this.FecCIPVig = FecCIPVig;
    }

    public int getCentroTrabajo() {
        return CentroTrabajo;
    }

    public void setCentroTrabajo(int CentroTrabajo) {
        this.CentroTrabajo = CentroTrabajo;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getLicCond() {
        return LicCond;
    }

    public void setLicCond(String LicCond) {
        this.LicCond = LicCond;
    }

    public String getObservac() {
        return Observac;
    }

    public void setObservac(String Observac) {
        this.Observac = Observac;
    }

    public String getVigente() {
        return Vigente;
    }

    public void setVigente(String Vigente) {
        this.Vigente = Vigente;
    }

    public Blob getFoto() {
        return foto;
    }

    public void setFoto(Blob foto) {
        this.foto = foto;
    }
    
}
