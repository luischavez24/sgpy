package edu.unmsm.sistemas.sgpy.entities;

import java.util.Date;

public class PytoDocsView {
   
    private int codPyto;
    private int corrdocs;
    private Date fecIni;
    private Date fecFin;
    private double costoEst;
    private String verDoc;
    private String vigente;
    private String desFase;
    private String desNivel;
    private String desTDoc;
    private String desentreg;
    
    public PytoDocsView(){}

    public PytoDocsView(int codPyto, int corrdocs, Date fecIni, Date fecFin, double costoEst, String verDoc, String vigente, String desFase, String desNivel, String desTDoc, String desentreg) {
        this.codPyto = codPyto;
        this.corrdocs = corrdocs;
        this.fecIni = fecIni;
        this.fecFin = fecFin;
        this.costoEst = costoEst;
        this.verDoc = verDoc;
        this.vigente = vigente;
        this.desFase = desFase;
        this.desNivel = desNivel;
        this.desTDoc = desTDoc;
        this.desentreg = desentreg;
    }
   
    public int getCodPyto() {
        return codPyto;
    }

    public void setCodPyto(int codPyto) {
        this.codPyto = codPyto;
    }

    public int getCorrdocs() {
        return corrdocs;
    }

    public void setCorrdocs(int corrdocs) {
        this.corrdocs = corrdocs;
    }

    public Date getFecIni() {
        return fecIni;
    }

    public void setFecIni(Date fecIni) {
        this.fecIni = fecIni;
    }

    public Date getFecFin() {
        return fecFin;
    }

    public void setFecFin(Date fecFin) {
        this.fecFin = fecFin;
    }

    public double getCostoEst() {
        return costoEst;
    }

    public void setCostoEst(double costoEst) {
        this.costoEst = costoEst;
    }

    public String getVerDoc() {
        return verDoc;
    }

    public void setVerDoc(String verDoc) {
        this.verDoc = verDoc;
    }

    public String getVigente() {
        return vigente;
    }

    public void setVigente(String vigente) {
        this.vigente = vigente;
    }

    public String getDesFase() {
        return desFase;
    }

    public void setDesFase(String desFase) {
        this.desFase = desFase;
    }

    public String getDesNivel() {
        return desNivel;
    }

    public void setDesNivel(String desNivel) {
        this.desNivel = desNivel;
    }

    public String getDesTDoc() {
        return desTDoc;
    }

    public void setDesTDoc(String desTDoc) {
        this.desTDoc = desTDoc;
    }

    public String getDesentreg() {
        return desentreg;
    }

    public void setDesentreg(String desentreg) {
        this.desentreg = desentreg;
    }

    
   
}
