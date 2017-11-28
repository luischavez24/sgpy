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
public class ClienteDAO {
    private Conexion conectar;

    public ClienteDAO() {
        conectar = new Conexion();
        conectar.Conectar();
    }
    public String insertarCliente(int CodCli, int corEmp,String DesPliego, String NroRuc, int GerGener, int GerInfraest){
        String rptaRegistro=null;
        try{
            Connection accesoBD = conectar.getConexion();
            //System.out.println(CodCli+" "+corEmp+" "+DesPliego+" "+NroRuc+" "+GerGener+" "+GerInfraest);
            String sql = "{call ClienteDAO.sp_insertarCliente(?,?,?,?,?,?) }";
            CallableStatement cs = accesoBD.prepareCall(sql);
            cs.setInt(1,CodCli);
            cs.setInt(2, corEmp);
            cs.setString(3,DesPliego);
            cs.setString(4,NroRuc);
            cs.setInt(5,GerGener);
            cs.setInt(6,GerInfraest);
            int numFAfectas = cs.executeUpdate();
            if(numFAfectas>0){
                rptaRegistro = "Registro exitoso";
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return rptaRegistro;
    }
    
    public ArrayList<Cliente> listCliente(){
        ArrayList<Cliente> listaCliente = new ArrayList();
        ArrayList<Persona> listaPersona = new ArrayList();
        PersonaDAO perDao = new PersonaDAO();
        Cliente cli;
        try{
            Connection acceBD = conectar.getConexion();
            String sql = "{call ClienteDAO.listar_Clientes(?) }";
            CallableStatement cs = acceBD.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = ((OracleCallableStatement)cs).getCursor(1);
            listaPersona = perDao.listPersona();
            while(rs.next()){
                cli=new Cliente();
                cli.setCodCli(rs.getInt(1));
                cli.setCorEmp(rs.getInt(2));
                cli.setDesPliego(rs.getString(3));
                cli.setNroRuc(rs.getString(4));
                cli.setGerGener(rs.getInt(5));
                cli.setGerInfraest(rs.getInt(6));
                listaCliente.add(cli);
            }
            for (int i = 0; i < listaPersona.size(); i++) {
                for (int j = 0; j < listaCliente.size(); j++) {
                    if(listaPersona.get(i).getCodPers() == listaCliente.get(j).getCodCli()){
                        listaCliente.get(j).setCodPers(listaPersona.get(i).getCodPers());
                        listaCliente.get(j).setTipPersona(listaPersona.get(i).getTipPersona());
                        listaCliente.get(j).setDesPersona(listaPersona.get(i).getDesPersona());
                        listaCliente.get(j).setDesCorta(listaPersona.get(i).getDesCorta());
                        listaCliente.get(j).setFlagCli(listaPersona.get(i).getFlagCli());
                        listaCliente.get(j).setFlagEsp(listaPersona.get(i).getFlagEsp());
                        listaCliente.get(j).setFlagProf(listaPersona.get(i).getFlagProf());
                        listaCliente.get(j).setDirecc(listaPersona.get(i).getDirecc());
                        listaCliente.get(j).setHobby(listaPersona.get(i).getHobby());
                        listaCliente.get(j).setBytesLeidos(listaPersona.get(i).getBytesLeidos());
                        listaCliente.get(j).setFecNac(listaPersona.get(i).getFecNac());
                        listaCliente.get(j).setCodDpto(listaPersona.get(i).getCodDpto());
                        listaCliente.get(j).setCodProv(listaPersona.get(i).getCodProv());
                        listaCliente.get(j).setCodDist(listaPersona.get(i).getCodDist());
                        listaCliente.get(j).setDNI(listaPersona.get(i).getDNI());
                        listaCliente.get(j).setNroCIP(listaPersona.get(i).getNroCIP());
                        listaCliente.get(j).setFecCIPVig(listaPersona.get(i).getFecCIPVig());
                        listaCliente.get(j).setCentroTrabajo(listaPersona.get(i).getCentroTrabajo());
                        listaCliente.get(j).setCargo(listaPersona.get(i).getCargo());
                        listaCliente.get(j).setLicCond(listaPersona.get(i).getLicCond());
                        listaCliente.get(j).setObservac(listaPersona.get(i).getObservac());
                        listaCliente.get(j).setVigente(listaPersona.get(i).getLicCond());
                    }
                }               
            }
        }catch(Exception e){
            
        }
        return listaCliente;
    }
    
    public String modificarCliente(int CodCli, int corEmp,String DesPliego, String NroRuc, int GerGener, int GerInfraest){
        String rptaModificar=null;
        try{
            Connection accesoBD = conectar.getConexion();
            String sql = "{call ClienteDAO.sp_modificarCliente(?,?,?,?,?,?) }";
            CallableStatement cs = accesoBD.prepareCall(sql);
            cs.setInt(1,CodCli);
            cs.setInt(2, corEmp);
            cs.setString(3,DesPliego);
            cs.setString(4,NroRuc);
            cs.setInt(5,GerGener);
            cs.setInt(6,GerInfraest);
            int numFAfectas = cs.executeUpdate();
            if(numFAfectas>0){
                rptaModificar = "Modificación exitosa";
            }
        }catch(Exception e){
            
        }
        
        return rptaModificar;
    }
    
    public String eliminarCliente(int codCliente) {
        String rptaEliminar = null;
        try {
            Connection accesoBD = conectar.getConexion();
            String sql = "{call ClienteDAO.sp_eliminarCliente(?) }";
            CallableStatement cs = accesoBD.prepareCall(sql);
            cs.setInt(1, codCliente);
            int numFAfectas = cs.executeUpdate();
            if (numFAfectas > 0) {
                rptaEliminar = "Eliminación exitosa";
            }
        } catch (Exception e) {

        }

        return rptaEliminar;
    }
}

