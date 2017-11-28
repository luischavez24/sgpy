package edu.unmsm.sistemas.sgpy.documents.entities;

import java.util.Date;

public class PytoDocs {

    private int codPyto;
    private int corrdocs;
    private int codFase;
    private int codNivel;
    private Date fecIni;
    private Date fecFin;
    private double costoEst;
    private int codDoc;
    private String rutaDoc;
    private String verDoc;
    private String observac;
    private int estPyto;
    private int tipoEntreg;
    private int corrEntreg;
    private int codEsp;
    private int codResp;
    private String vigente;

    public PytoDocs() {
    }

    public PytoDocs(int codPyto, int corrdocs, int codFase, int codNivel, Date fecIni, Date fecFin, double costoEst, int codDoc, String rutaDoc, String verDoc, String observac, int estPyto, int tipoEntreg, int corrEntreg, int codEsp, int codResp, String vigente) {
        this.codPyto = codPyto;
        this.corrdocs = corrdocs;
        this.codFase = codFase;
        this.codNivel = codNivel;
        this.fecIni = fecIni;
        this.fecFin = fecFin;
        this.costoEst = costoEst;
        this.codDoc = codDoc;
        this.rutaDoc = rutaDoc;
        this.verDoc = verDoc;
        this.observac = observac;
        this.estPyto = estPyto;
        this.tipoEntreg = tipoEntreg;
        this.corrEntreg = corrEntreg;
        this.codEsp = codEsp;
        this.codResp = codResp;
        this.vigente = vigente;
    }

    public PytoDocs(int codPyto, int corrdocs, Date fecIni, Date fecFin, double costoEst, String verDoc,
            String vigente) {
        super();
        this.codPyto = codPyto;
        this.corrdocs = corrdocs;
        this.fecIni = fecIni;
        this.fecFin = fecFin;
        this.costoEst = costoEst;
        this.verDoc = verDoc;
        this.vigente = vigente;
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

    public int getCodFase() {
        return codFase;
    }

    public void setCodFase(int codFase) {
        this.codFase = codFase;
    }

    public int getCodNivel() {
        return codNivel;
    }

    public void setCodNivel(int codNivel) {
        this.codNivel = codNivel;
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

    public int getCodDoc() {
        return codDoc;
    }

    public void setCodDoc(int codDoc) {
        this.codDoc = codDoc;
    }

    public String getRutaDoc() {
        return rutaDoc;
    }

    public void setRutaDoc(String rutaDoc) {
        this.rutaDoc = rutaDoc;
    }

    public String getVerDoc() {
        return verDoc;
    }

    public void setVerDoc(String verDoc) {
        this.verDoc = verDoc;
    }

    public String getObservac() {
        return observac;
    }

    public void setObservac(String observac) {
        this.observac = observac;
    }

    public int getEstPyto() {
        return estPyto;
    }

    public void setEstPyto(int estPyto) {
        this.estPyto = estPyto;
    }

    public int getTipoEntreg() {
        return tipoEntreg;
    }

    public void setTipoEntreg(int tipoEntreg) {
        this.tipoEntreg = tipoEntreg;
    }

    public int getCorrEntreg() {
        return corrEntreg;
    }

    public void setCorrEntreg(int corrEntreg) {
        this.corrEntreg = corrEntreg;
    }

    public int getCodEsp() {
        return codEsp;
    }

    public void setCodEsp(int codEsp) {
        this.codEsp = codEsp;
    }

    public int getCodResp() {
        return codResp;
    }

    public void setCodResp(int codResp) {
        this.codResp = codResp;
    }

    public String getVigente() {
        return vigente;
    }

    public void setVigente(String vigente) {
        this.vigente = vigente;
    }

    @Override
    public String toString() {
        return "PytoDocs{" + "codPyto=" + codPyto + ", corrdocs=" + corrdocs + ", codFase=" + codFase + ", codNivel=" + codNivel + ", fecIni=" + fecIni + ", fecFin=" + fecFin + ", costoEst=" + costoEst + ", codDoc=" + codDoc + ", rutaDoc=" + rutaDoc + ", verDoc=" + verDoc + ", observac=" + observac + ", estPyto=" + estPyto + ", tipoEntreg=" + tipoEntreg + ", corrEntreg=" + corrEntreg + ", codEsp=" + codEsp + ", codResp=" + codResp + ", vigente=" + vigente + '}';
    }
}
