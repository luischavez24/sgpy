/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.ProfYExp.Modelo_LN;

import edu.unmsm.sistemas.sgpy.ProfYExp.Modelo.Gerente;
import edu.unmsm.sistemas.sgpy.ProfYExp.Modelo_DAO.EmpresaDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Casa
 */
public class Gerente_LN {
    
    ResultSet rs;
    EmpresaDAO emDAO= new EmpresaDAO();
    
    public void llenarArregloCumple(ArrayList<Gerente> gerente) throws SQLException{
        rs=emDAO.gerenteCumple(obtenerFecha());
        while(rs.next()){
            Gerente gerCumple= new Gerente();
            gerCumple.setNombre(rs.getString(1));
            gerCumple.setDireccion(rs.getString(2));
            gerCumple.setEmpresa(rs.getString(5));
            gerCumple.setFotos(rs.getBlob(3));
            gerente.add(gerCumple);  
        }
    }
    
    public String obtenerFecha(){
        Calendar fecha = new GregorianCalendar();
        String cad_fecha;
        int año=fecha.get(Calendar.YEAR);
        int mes=fecha.get(Calendar.MONTH);
        int dia=fecha.get(Calendar.DAY_OF_MONTH);
        cad_fecha = dia+"/"+(mes+1)+"/"+Integer.parseInt(String.valueOf(año).substring(1));
        return cad_fecha;
    }
}
