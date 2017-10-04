package edu.unmsm.sistemas.sgpy.entities;

public class TipoEntreg {
    private int tipoEntreg;
    private String deEntreg;
    private String vigencia;

    public TipoEntreg(int tipoEntreg, String deEntreg, String vigencia) {
        this.tipoEntreg = tipoEntreg;
        this.deEntreg = deEntreg;
        this.vigencia = vigencia;
    }

    public int getTipoEntreg() {
        return tipoEntreg;
    }

    public void setTipoEntreg(int tipoEntreg) {
        this.tipoEntreg = tipoEntreg;
    }

    public String getDeEntreg() {
        return deEntreg;
    }

    public void setDeEntreg(String deEntreg) {
        this.deEntreg = deEntreg;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    @Override
    public String toString() {
        return "TipoEntreg{" + "tipoEntreg=" + tipoEntreg + ", deEntreg=" + deEntreg + ", vigencia=" + vigencia + '}';
    }
    
}
