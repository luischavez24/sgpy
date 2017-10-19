package edu.unmsm.sistemas.sgpy.entities;

public class Entregables {

    private int TipoEntreg;
    private int CorrEntreg;
    private String DesEntreg;
    private String DesCortaEntreg;

    public Entregables(int TipoEntreg, int CorrEntreg, String DesEntreg, String DesCortaEntreg) {
        this.TipoEntreg = TipoEntreg;
        this.CorrEntreg = CorrEntreg;
        this.DesEntreg = DesEntreg;
        this.DesCortaEntreg = DesCortaEntreg;
    }

    public int getTipoEntreg() {
        return TipoEntreg;
    }

    public void setTipoEntreg(int TipoEntreg) {
        this.TipoEntreg = TipoEntreg;
    }

    public int getCorrEntreg() {
        return CorrEntreg;
    }

    public void setCorrEntreg(int CorrEntreg) {
        this.CorrEntreg = CorrEntreg;
    }

    public String getDesEntreg() {
        return DesEntreg;
    }

    public void setDesEntreg(String DesEntreg) {
        this.DesEntreg = DesEntreg;
    }

    public String getDesCortaEntreg() {
        return DesCortaEntreg;
    }

    public void setDesCortaEntreg(String DesCortaEntreg) {
        this.DesCortaEntreg = DesCortaEntreg;
    }

    @Override
    public String toString() {
        return TipoEntreg + "-" + CorrEntreg;
    }

}
