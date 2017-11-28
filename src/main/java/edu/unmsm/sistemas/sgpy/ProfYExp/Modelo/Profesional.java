
package edu.unmsm.sistemas.sgpy.ProfYExp.Modelo;


public class Profesional {
    private String nomPers;
    private String nomEmpresa;
    private String desProf;
    private String nroCIP;
    private String universidad;
    private String vigente;

    public Profesional() {
    }

    public String getNomPers() {
        return nomPers;
    }

    public void setNomPers(String desPers) {
        this.nomPers = desPers;
    }

    public String getNomEmpresa() {
        return nomEmpresa;
    }

    public void setNomEmpresa(String nomEmpresa) {
        this.nomEmpresa = nomEmpresa;
    }

    public String getDesProf() {
        return desProf;
    }

    public void setDesProf(String nomProf) {
        this.desProf = nomProf;
    }

    public String getNroCIP() {
        return nroCIP;
    }

    public void setNroCIP(String nroCIP) {
        this.nroCIP = nroCIP;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getVigente() {
        return vigente;
    }

    public void setVigente(String vigente) {
        this.vigente = vigente;
    }

}