package edu.unmsm.sistemas.sgpy.entities;

public class Estado {
    private int codFase;
    private int codNivel;
    private int estPyto;
    
    private String desEstado;
    private String vigente;

    public Estado(int codFase, int codNivel, int estPyto, String desEstado, String vigente) {
        this.codFase = codFase;
        this.codNivel = codNivel;
        this.estPyto = estPyto;
        this.desEstado = desEstado;
        this.vigente = vigente;
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

    public int getEstPyto() {
        return estPyto;
    }

    public void setEstPyto(int estPyto) {
        this.estPyto = estPyto;
    }

    public String getDesEstado() {
        return desEstado;
    }

    public void setDesEstado(String desEstado) {
        this.desEstado = desEstado;
    }

    public String getVigente() {
        return vigente;
    }

    public void setVigente(String vigente) {
        this.vigente = vigente;
    }
    
    @Override
    public String toString()
    {
        return "Estado={CodFase:" + codFase + " CodNivel: " + codNivel + " EstPyto: " + estPyto + " DesEstado: " + desEstado + " Vigente: " + vigente +"}";    }
}