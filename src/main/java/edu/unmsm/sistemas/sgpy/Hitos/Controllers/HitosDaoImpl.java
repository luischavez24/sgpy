/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.Hitos.Controllers;

import edu.unmsm.sistemas.sgpy.Hitos.Database.conexion;
import edu.unmsm.sistemas.sgpy.Hitos.Models.HitosAlerta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Axel
 */
public class HitosDaoImpl implements HitosDAO{

    private static HitosDaoImpl hitos_dao_impl;
    
    public static HitosDaoImpl getInstance(){
        if(hitos_dao_impl==null){
            hitos_dao_impl=new HitosDaoImpl();
        }
        return hitos_dao_impl;
    }
    
    
    
    Connection cnn=conexion.getInstance().getConnection();;

    private HitosDaoImpl() {
    }
    
    
    @Override
    public void AgregarNuevaAlertaHito(HitosAlerta nuevoHito) {
        int cod_pyto=nuevoHito.getCodPyto();
        int cod_corr=nuevoHito.getCorrHitos();
        int cod_tics=nuevoHito.getCodTICs();
        String date=nuevoHito.getFecAlerta();
        String alerta_on=nuevoHito.getAlertaOn();
        String queryproc="{call crearAlertaHito("+cod_pyto+","+cod_corr+","+cod_tics+",'"+date+"','"+alerta_on+"')}";
        try {
            CallableStatement cs=cnn.prepareCall(queryproc);
            cs.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    @Override
    public ArrayList<HitosAlerta> obtenerAlertasHito(Integer CodPyto) {
        ArrayList<HitosAlerta> alertas=null;
        String query="SELECT * FROM hitosalerta WHERE codPyto= " + CodPyto;
        String queryproc="{call MOSTRARALERTAS("+CodPyto+")}";
        try {
            Statement st=cnn.createStatement();
            //CallableStatement cs=cnn.prepareCall(queryproc);
            ResultSet rs=st.executeQuery(query);
            alertas=new ArrayList<>();
            while(rs.next()){
                int cod_pyto=rs.getInt(1);
                int cod_corr=rs.getInt(2);
                int cod_tics=rs.getInt(3);
                String fecha=rs.getString(4);
                String alerta_on=rs.getString(5);
                HitosAlerta ha=new HitosAlerta(CodPyto, cod_corr, cod_tics, fecha, alerta_on);
                alertas.add(ha);
            }
        } 
        catch (SQLException e) {
            System.out.println(e.toString());
        }
        return alertas;
    }

    @Override
    public void ActualizarAlertaHito(Integer CodPyto,String estado) {
        String query="UPDATE hitosalerta set alertaon=? where codPyto= "+CodPyto;
        try {
            PreparedStatement ps=cnn.prepareStatement(query);
            ps.setString(1, estado);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        
    }

    @Override
    public void EliminarAlertaHito(Integer CodPyto) {
        String query="DELETE FROM hitosalerta WHERE codPyto= " + CodPyto;
        try {
            PreparedStatement ps=cnn.prepareStatement(query);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }


    @Override
    public ArrayList<HitosAlerta> getAlertasHitos() {
        ArrayList<HitosAlerta> alertas=null;
        String query="SELECT * FROM hitosalerta";
        try {
            Statement st=cnn.createStatement();
            ResultSet rs=st.executeQuery(query);
            alertas=new ArrayList<>();
            while(rs.next()){
                int cod_pyto=rs.getInt(1);
                int cod_corr=rs.getInt(2);
                int cod_tics=rs.getInt(3);
                String fecha=rs.getString(4);
                String alerta_on=rs.getString(5);
                HitosAlerta ha=new HitosAlerta(cod_pyto, cod_tics, cod_tics, fecha, alerta_on);
                alertas.add(ha);
            }
        } 
        catch (SQLException e) {
            System.out.println(e.toString());
        }
        return alertas;
    }


}
