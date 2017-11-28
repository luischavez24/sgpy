/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.Persona.modelo;

import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Types;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Halion
 */
public class PersonaDAO {
    private Conexion conectar;
    private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
    public PersonaDAO(){
        conectar = new Conexion();
        conectar.Conectar();
    }
    
    public String insertarPersona(int CodPers, String TipPersona, String DesPersona, String DesCorta, String FlagCli, String FlagEsp,
                                  String FlagProf, String Direcc, String Hobby, FileInputStream file, int longBytes,
                                  String FecNac, String CodDpto, String CodProv,String CodDist, String DNI, String NroCIP, 
                                  String FecCIPVig, int CentroTrabajo, String Cargo, String LicCond, String Observac, 
                                  String Vigente){
        String rptaRegistro=null;
        try{
            Connection accesoBD = conectar.getConexion();
            String sql = "{call PersonaDAO.sp_insertarPersona(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
            CallableStatement cs = accesoBD.prepareCall(sql);
            cs.setInt(1,CodPers);
            cs.setString(2,TipPersona);
            cs.setString(3,DesPersona);
            cs.setString(4,DesCorta);
            cs.setString(5,FlagCli);
            cs.setString(6,FlagEsp);
            cs.setString(7,FlagProf);
            cs.setString(8,Direcc);
            cs.setString(9,Hobby);
            cs.setBlob(10, file, longBytes);
            java.util.Date date = formato.parse(FecNac);
            java.sql.Date sqlDate = new Date(date.getTime());
            cs.setDate(11, sqlDate);
            cs.setString(12,CodDpto);
            cs.setString(13,CodProv);
            cs.setString(14,CodDist);
            cs.setString(15,DNI);
            cs.setString(16,NroCIP);
            java.util.Date date2 = formato.parse(FecCIPVig);
            java.sql.Date sqlDate2 = new Date(date2.getTime());
            cs.setDate(17,sqlDate2);
            if(CentroTrabajo==0){
                cs.setNull(18, Types.NULL);
            }
            else{
                cs.setInt(18,CentroTrabajo);
            }
            cs.setString(19,Cargo);
            cs.setString(20,LicCond);
            cs.setString(21,Observac);
            cs.setString(22,Vigente);
            int numFAfectas = cs.executeUpdate();
            if(numFAfectas>0){
                rptaRegistro = "Registro exitoso";
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return rptaRegistro;
    }
    
    public ArrayList<Persona> listPersona(){
        ArrayList<Persona> listaPersona = new ArrayList();
        Persona per;
        try{
            Connection acceBD = conectar.getConexion();
            String sql = "{call PersonaDAO.listar_Personas(?) }";
            CallableStatement cs = acceBD.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = ((OracleCallableStatement)cs).getCursor(1);
            while(rs.next()){
                per = new Persona();
                per.setCodPers(rs.getInt(1));
                per.setTipPersona(rs.getString(2));
                per.setDesPersona(rs.getString(3));
                per.setDesCorta(rs.getString(4));
                per.setFlagCli(rs.getString(5));
                per.setFlagEsp(rs.getString(6));
                per.setFlagProf(rs.getString(7));
                per.setDirecc(rs.getString(8));
                per.setHobby(rs.getString(9));
                Blob auxiliar=rs.getBlob(10);
                if(auxiliar!=null){
                    per.setBytesLeidos(auxiliar.getBytes(1,(int)auxiliar.length()));
                    per.setFoto(auxiliar);
                }
                per.setFecNac(rs.getDate(11));
                per.setCodDpto(rs.getString(12));
                per.setCodProv(rs.getString(13));
                per.setCodDist(rs.getString(14));
                per.setDNI(rs.getString(15));
                per.setNroCIP(rs.getString(16));
                per.setFecCIPVig(rs.getDate(17));
                per.setCentroTrabajo(rs.getInt(18));
                per.setCargo(rs.getString(19));
                per.setLicCond(rs.getString(20));
                per.setObservac(rs.getString(21));
                per.setVigente(rs.getString(22));
                listaPersona.add(per);
            }
        }catch(Exception e){
            
        }
        return listaPersona;
    }
    public String modificarPersona(int CodPers, String TipPersona, String DesPersona, String DesCorta, String FlagCli, String FlagEsp,
                                  String FlagProf, String Direcc, String Hobby, FileInputStream file, int longBytes,
                                  String FecNac, String CodDpto, String CodProv,String CodDist, String DNI, String NroCIP, 
                                  String FecCIPVig, int CentroTrabajo, String Cargo, String LicCond, String Observac, 
                                  String Vigente){
        String rptaModificar=null;
        try{
            Connection accesoBD = conectar.getConexion();
            String sql = "{call PersonaDAO.sp_modificarPersona(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
            CallableStatement cs = accesoBD.prepareCall(sql);
            cs.setInt(1,CodPers);
            cs.setString(2,TipPersona);
            cs.setString(3,DesPersona);
            cs.setString(4,DesCorta);
            cs.setString(5,Direcc);
            cs.setString(6,Hobby);
            cs.setBlob(7, file, longBytes);
            java.util.Date date = formato.parse(FecNac);
            java.sql.Date sqlDate = new Date(date.getTime());
            cs.setDate(8, sqlDate);
            cs.setString(9,CodDpto);
            cs.setString(10,CodProv);
            cs.setString(11,CodDist);
            cs.setString(12,DNI);
            cs.setString(13,NroCIP);
            java.util.Date date2 = formato.parse(FecCIPVig);
            java.sql.Date sqlDate2 = new Date(date2.getTime());
            cs.setDate(14,sqlDate2);
            if(CentroTrabajo==0){
                cs.setNull(15, Types.NULL);
            }
            else{
                cs.setInt(15,CentroTrabajo);
            }
            cs.setString(16,Cargo);
            cs.setString(17,LicCond);
            cs.setString(18,Observac);
            cs.setString(19,Vigente);
            int numFAfectas = cs.executeUpdate();
            if(numFAfectas>0){
                rptaModificar = "Modificación exitosa";
            }
        }catch(Exception e){
            
        }
        
        return rptaModificar;
    }
    
    public String modificarPersona(int CodPers, String TipPersona, String DesPersona, String DesCorta, String FlagCli, String FlagEsp,
                                  String FlagProf, String Direcc, String Hobby, Blob foto,
                                  String FecNac, String CodDpto, String CodProv,String CodDist, String DNI, String NroCIP, 
                                  String FecCIPVig, int CentroTrabajo, String Cargo, String LicCond, String Observac, 
                                  String Vigente){
        String rptaModificar=null;
        try{
            Connection accesoBD = conectar.getConexion();
            String sql = "{call PersonaDAO.sp_modificarPersona(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
            CallableStatement cs = accesoBD.prepareCall(sql);
            cs.setInt(1,CodPers);
            cs.setString(2,TipPersona);
            cs.setString(3,DesPersona);
            cs.setString(4,DesCorta);
            cs.setString(5,Direcc);
            cs.setString(6,Hobby);
            cs.setBlob(7, foto);
            java.util.Date date = formato.parse(FecNac);
            java.sql.Date sqlDate = new Date(date.getTime());
            cs.setDate(8, sqlDate);
            cs.setString(9,CodDpto);
            cs.setString(10,CodProv);
            cs.setString(11,CodDist);
            cs.setString(12,DNI);
            cs.setString(13,NroCIP);
            java.util.Date date2 = formato.parse(FecCIPVig);
            java.sql.Date sqlDate2 = new Date(date2.getTime());
            cs.setDate(14,sqlDate2);
            if(CentroTrabajo==0){
                cs.setNull(15, Types.NULL);
            }
            else{
                cs.setInt(15,CentroTrabajo);
            }
            cs.setString(16,Cargo);
            cs.setString(17,LicCond);
            cs.setString(18,Observac);
            cs.setString(19,Vigente);
            int numFAfectas = cs.executeUpdate();
            if(numFAfectas>0){
                rptaModificar = "Modificación exitosa";
            }
        }catch(Exception e){
            
        }
        
        return rptaModificar;
    }
    
    public String eliminarPersona(int codPersona) {
        String rptaRegistro = null;
        try {
            Connection accesoBD = conectar.getConexion();
            String sql = "{call PersonaDAO.sp_eliminarPersona(?) }";
            CallableStatement cs = accesoBD.prepareCall(sql);
            cs.setInt(1, codPersona);
            int numFAfectas = cs.executeUpdate();
            if (numFAfectas > 0) {
                rptaRegistro = "Eliminación exitosa";
            }
        } catch (Exception e) {

        }

        return rptaRegistro;
    }
    
    public ArrayList<Persona> listPersonaJuridica(){
        ArrayList<Persona> listaPersona = new ArrayList();
        Persona per;
        try{
            Connection acceBD = conectar.getConexion();
            String sql = "{call PersonaDAO.listar_Persona_Juridica(?) }";
            CallableStatement cs = acceBD.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = ((OracleCallableStatement)cs).getCursor(1);
            while(rs.next()){
                per = new Persona();
                per.setCodPers(rs.getInt(1));
                per.setTipPersona(rs.getString(2));
                per.setDesPersona(rs.getString(3));
                per.setDesCorta(rs.getString(4));
                per.setFlagCli(rs.getString(5));
                per.setFlagEsp(rs.getString(6));
                per.setFlagProf(rs.getString(7));
                per.setDirecc(rs.getString(8));
                per.setHobby(rs.getString(9));
                Blob auxiliar=rs.getBlob(10);
                if(auxiliar!=null){
                    per.setBytesLeidos(auxiliar.getBytes(1,(int)auxiliar.length()));
                    per.setFoto(auxiliar);
                }
                per.setFecNac(rs.getDate(11));
                per.setCodDpto(rs.getString(12));
                per.setCodProv(rs.getString(13));
                per.setCodDist(rs.getString(14));
                per.setDNI(rs.getString(15));
                per.setNroCIP(rs.getString(16));
                per.setFecCIPVig(rs.getDate(17));
                per.setCentroTrabajo(rs.getInt(18));
                per.setCargo(rs.getString(19));
                per.setLicCond(rs.getString(20));
                per.setObservac(rs.getString(21));
                per.setVigente(rs.getString(22));
                listaPersona.add(per);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaPersona;
    }
    
    public int codPersona() {
        int codigo=0;
        try {
            Connection accesoBD = conectar.getConexion();
            String sql = "{?=call PersonaDAO.obtener_codPersona()}";
            CallableStatement cs = accesoBD.prepareCall(sql);
            cs.registerOutParameter(1,Types.NUMERIC);
            cs.execute();
            codigo=cs.getInt(1);          
        } catch (Exception e) {

        }
        return codigo;
    }
    
    public String descripcion(int codPersona){
        String des = " ";
        try {
            Connection accesoBD = conectar.getConexion();
            String sql = "{?=call PersonaDAO.obtener_Descripcion_Persona(?)}";
            CallableStatement cs = accesoBD.prepareCall(sql);
            cs.registerOutParameter(1,Types.VARCHAR);
            cs.setInt(2, codPersona);
            cs.execute();
            des=cs.getString(1);          
        } catch (Exception e) {

        }
        return des;
    }
    
    public int codPersonaJuridica(String descripcion){
        int codigo=0;
        try {
            Connection accesoBD = conectar.getConexion();
            String sql = "{?=call PersonaDAO.obtener_Codigo_PersonaJuridica(?)}";
            CallableStatement cs = accesoBD.prepareCall(sql);
            cs.registerOutParameter(1,Types.NUMERIC);
            cs.setString(2, descripcion);
            cs.execute();
            codigo=cs.getInt(1);          
        } catch (Exception e) {

        }
        return codigo;
    }
    
    public String Departamento(String descripcion){
        String codigo=null;
        try {
            Connection accesoBD = conectar.getConexion();
            String sql = "{?=call obtener_codDepartamento(?)}";
            CallableStatement cs = accesoBD.prepareCall(sql);
            cs.registerOutParameter(1,Types.VARCHAR);
            cs.setString(2, descripcion);
            cs.execute();
            codigo=cs.getString(1);          
        } catch (Exception e) {

        }
        return codigo;
    }
    
    public String Provincia(String codigoDept,String descripcion){
        String codigo=null;
        try {
            Connection accesoBD = conectar.getConexion();
            String sql = "{?=call obtener_codPronvincia(?,?)}";
            CallableStatement cs = accesoBD.prepareCall(sql);
            cs.registerOutParameter(1,Types.VARCHAR);
            cs.setString(2, codigoDept);
            cs.setString(3, descripcion);
            cs.execute();
            codigo=cs.getString(1);          
        } catch (Exception e) {

        }
        return codigo;
    }
    
    public String Distrito(String codigoDept,String codigoProv,String descripcion){
        String codigo=null;
        try {
            Connection accesoBD = conectar.getConexion();
            String sql = "{?=call obtener_codDistrito(?,?,?)}";
            CallableStatement cs = accesoBD.prepareCall(sql);
            cs.registerOutParameter(1,Types.VARCHAR);
            cs.setString(2, codigoDept);
            cs.setString(3, codigoProv);
            cs.setString(4, descripcion);
            cs.execute();
            codigo=cs.getString(1);          
        } catch (Exception e) {

        }
        return codigo;
    }
    
    public ArrayList<String> listGerenteGeneral(){
        ArrayList<String> lista = new ArrayList();
        try{
            Connection acceBD = conectar.getConexion();
            String sql = "{call PersonaDAO.listar_Gerente_General(?) }";
            CallableStatement cs = acceBD.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = ((OracleCallableStatement)cs).getCursor(1);
            while(rs.next()){
                lista.add(rs.getString(1));
            }
        }catch(Exception e){
            
        }
        return lista;
    }
    
    public ArrayList<String> listGerenteInfraestructura(){
        ArrayList<String> lista = new ArrayList();
        try{
            Connection acceBD = conectar.getConexion();
            String sql = "{call PersonaDAO.listar_Gerente_Infraestructura(?) }";
            CallableStatement cs = acceBD.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = ((OracleCallableStatement)cs).getCursor(1);
            while(rs.next()){
                lista.add(rs.getString(1));
            }
        }catch(Exception e){
            
        }
        return lista;
    }
    
    public int codPersona2(String descripcion) {
        int codigo=0;
        try {
            Connection accesoBD = conectar.getConexion();
            String sql = "{?=call PersonaDAO.obtener_codPersona2(?)}";
            CallableStatement cs = accesoBD.prepareCall(sql);
            cs.registerOutParameter(1,Types.NUMERIC);
            cs.setString(2, descripcion);
            cs.execute();
            codigo=cs.getInt(1);          
        } catch (Exception e) {

        }
        return codigo;
    }
    
    public String descripcion2(int codPersona){
        String des = " ";
        try {
            Connection accesoBD = conectar.getConexion();
            String sql = "{?=call PersonaDAO.obtener_Descripcion_Persona2(?)}";
            CallableStatement cs = accesoBD.prepareCall(sql);
            cs.registerOutParameter(1,Types.VARCHAR);
            cs.setInt(2, codPersona);
            cs.execute();
            des=cs.getString(1);          
        } catch (Exception e) {

        }
        return des;
    }
}
