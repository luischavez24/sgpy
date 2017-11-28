/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.Hitos.Models;

/**
 *
 * @author Axel
 */
public class HitosAlerta {
    private Integer CodPyto;
    private Integer CorrHitos;
    private Integer CodTICs;
    private String FecAlerta;
    private String AlertaOn;

    public HitosAlerta(Integer CodPyto, Integer CorrHitos, Integer CodTICs, String FecAlerta, String AlertaOn) {
        this.CodPyto = CodPyto;
        this.CorrHitos = CorrHitos;
        this.CodTICs = CodTICs;
        this.FecAlerta = FecAlerta;
        this.AlertaOn = AlertaOn;
    }

    
    public Integer getCodPyto() {
        return CodPyto;
    }

    public void setCodPyto(Integer CodPyto) {
        this.CodPyto = CodPyto;
    }

    public Integer getCorrHitos() {
        return CorrHitos;
    }

    public void setCorrHitos(Integer CorrHitos) {
        this.CorrHitos = CorrHitos;
    }

    public Integer getCodTICs() {
        return CodTICs;
    }

    public void setCodTICs(Integer CodTICs) {
        this.CodTICs = CodTICs;
    }

    public String getFecAlerta() {
        return FecAlerta;
    }

    public void setFecAlerta(String FecAlerta) {
        this.FecAlerta = FecAlerta;
    }

    public String getAlertaOn() {
        return AlertaOn;
    }

    public void setAlertaOn(String AlertaOn) {
        this.AlertaOn = AlertaOn;
    }
}
