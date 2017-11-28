/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.Hitos.Controllers;

import edu.unmsm.sistemas.sgpy.Hitos.Models.HitosAlerta;
import java.util.ArrayList;

/**
 *
 * @author Axel
 */
public interface HitosDAO {
    //CRUD de la tabla HitosAlerta
    public void AgregarNuevaAlertaHito(HitosAlerta nuevoHito);
    public ArrayList<HitosAlerta> obtenerAlertasHito(Integer CodPyto);
    public ArrayList<HitosAlerta> getAlertasHitos();
    public void ActualizarAlertaHito(Integer CodPyto,String estado);
    public void EliminarAlertaHito(Integer CodPyto);
}
