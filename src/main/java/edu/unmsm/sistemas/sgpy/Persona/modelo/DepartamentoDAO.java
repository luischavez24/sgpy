/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.Persona.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author CARLOS
 */
public class DepartamentoDAO {
    private Conexion conectar;
    
    public DepartamentoDAO(){
        conectar=new Conexion();
        conectar.Conectar();
    }
    
    public ArrayList<Departamento> listDepartamento(){
        ArrayList<Departamento> listaDepartamento = new ArrayList();
        Departamento dep;
        try{
            Connection acceBD = conectar.getConexion();
            String sql = "{call listar_Departamentos(?) }";
            CallableStatement cs = acceBD.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = ((OracleCallableStatement)cs).getCursor(1);
            while(rs.next()){
                dep = new Departamento();
                dep.setCodDpto(rs.getString(1));
                dep.setDesDpto(rs.getString(2));
                listaDepartamento.add(dep);
            }
        }catch(Exception e){
            
        }
        return listaDepartamento;
    }
    
    public String busquedaDepartamento(String cod){
        String resultado = new String();
        ArrayList<Departamento> aux = listDepartamento();
        for (int i = 0; i < aux.size(); i++) {
            if(aux.get(i).getCodDpto().equals(cod)){
                resultado = aux.get(i).getDesDpto();
                System.out.println(resultado);
            }
        }
        return resultado;
    }
}
