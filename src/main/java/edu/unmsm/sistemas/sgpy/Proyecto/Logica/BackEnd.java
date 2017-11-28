package edu.unmsm.sistemas.sgpy.Proyecto.Logica;

import java.sql.*;

import edu.unmsm.sistemas.sgpy.Proyecto.Vista.AgregarFrm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.internal.OracleTypes;

public class BackEnd {

    String user, pass, url,SID;
    Connection conex;
    Statement stm;

    public BackEnd() {
        user = edu.unmsm.sistemas.sgpy.Principal.DatosConexionPrincipal.usuario;
        pass = edu.unmsm.sistemas.sgpy.Principal.DatosConexionPrincipal.contra;
        SID = edu.unmsm.sistemas.sgpy.Principal.DatosConexionPrincipal.SID;
        url = "jdbc:oracle:thin:@localhost:1521:"+SID;    //El SID puede cambiar con orcl y xe
        conex = null;
        stm = null;
        conectar();
    }

    public int cantidadProyecto(String codDpto) throws SQLException {
        stm = conex.createStatement();
        String cadSQL = "";
        try {
            cadSQL = "SELECT count(*) FROM Proyecto where coddpto="+codDpto;
            ResultSet rs = stm.executeQuery(cadSQL);
            rs.next();
            int dato = rs.getInt(1);    
            return dato;
        } catch (Exception e) {
            System.out.println("Nada registrado para este departamento");
            return -1;
        }
    }
    
    public void conectar() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conex = DriverManager.getConnection(url, user, pass);
            System.out.println("Se conectó a la BD en Logica.BackEnd");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            System.out.println("No se conectó a la BD\n");
            System.out.println(e.getCause());
            Logger.getLogger(AgregarFrm.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void desactivarAutoCommit() throws SQLException {
        conex.setAutoCommit(false);
    }

    public void Commit() throws SQLException {
        conex.commit();
    }

    public int obtenerCodigoProyecto() throws SQLException {
        stm = conex.createStatement();
        String cadSQL = "";
        try {
            cadSQL = "SELECT count(*) FROM Proyecto";
            ResultSet rs = stm.executeQuery(cadSQL);
            rs.next();
            int dato = rs.getInt(1) + 1;    //Tiene que aumentar en uno para guardar el proyecto
            return dato;
        } catch (Exception e) {
            System.out.println("No existe la tabla de Proyectos");
            return -1;
        }
    }

    public String leerNiveles(int codfase) throws SQLException {
        stm = conex.createStatement();
        String cadSQL = "";
        try {
            cadSQL = "SELECT DESNIVEL, codNivel FROM NIVEL WHERE codFase="+codfase+" ORDER BY codNivel";
            ResultSet rs = stm.executeQuery(cadSQL);
            String niveles = "";
            while (rs.next()) {
                niveles += rs.getString(1) + "#";
            }
            return niveles;
        } catch (Exception e) {
            System.out.println("No existe la tabla de Niveles");
            return null;
        }
    }

    public String leerFunciones() throws SQLException {
        stm = conex.createStatement();
        String cadSQL = "";
        try {
            cadSQL = "SELECT desfuncion FROM FUNCION";
            ResultSet rs = stm.executeQuery(cadSQL);
            String funciones = "";
            while (rs.next()) {
                funciones += rs.getString(1) + "#";
            }
            return funciones;
        } catch (Exception e) {
            System.out.println("No existe la tabla de Funciones");
            return null;
        }
    }

    public String leerEstados() throws SQLException {
        stm = conex.createStatement();
        String cadSQL = "";
        try {
            cadSQL = "SELECT DISTINCT desestado, estPyto FROM ESTADO ORDER BY estPyto";
            ResultSet rs = stm.executeQuery(cadSQL);
            String estados = "";
            while (rs.next()) {
                estados += rs.getString(1) + "#";
            }
            return estados;
        } catch (Exception e) {
            System.out.println("No existe la tabla de Estados");
            return null;
        }
    }
    public String leerFases() throws SQLException {
        stm = conex.createStatement();
        String cadSQL = "";
        try {
            cadSQL = "SELECT DISTINCT desFase, codFase FROM FASE ORDER BY codFase";
            ResultSet rs = stm.executeQuery(cadSQL);
            String estados = "";
            while (rs.next()) {
                estados += rs.getString(1) + "#";
            }
            return estados;
        } catch (Exception e) {
            System.out.println("No existe la tabla de Fases");
            return null;
        }
    }

    public String leerDepartamentos() throws SQLException {
        stm = conex.createStatement();
        String cadSQL = "";
        try {
            cadSQL = "SELECT DISTINCT desdpto, codDpto FROM DEPARTAMENTO ORDER BY codDpto";
            ResultSet rs = stm.executeQuery(cadSQL);
            String departamentos = "";
            while (rs.next()) {
                departamentos += rs.getString(1) + "#";
            }
            return departamentos;
        } catch (Exception e) {
            System.out.println("No existe la tabla de Departamentos");
            return null;
        }
    }

    public String leerProvincias(String nombreDpto) throws SQLException {
        stm = conex.createStatement();
        String cadSQL = "";
        try {
            cadSQL = "SELECT P.desprov, P.codProv FROM PROVINCIA P "
                    + "JOIN DEPARTAMENTO D ON D.coddpto=P.coddpto "
                    + "WHERE D.desdpto='" + nombreDpto + "' ORDER BY P.codProv";
            ResultSet rs = stm.executeQuery(cadSQL);
            String provincias = "";
            while (rs.next()) {
                provincias += rs.getString(1) + "#";
            }
            return provincias;
        } catch (Exception e) {
            System.out.println("No existe la tabla de Provincias");
            return null;
        }
    }

    public String leerDistritos(String nombreProv, String nombreDept) throws SQLException {
        stm = conex.createStatement();
        String cadSQL = "";
        try {
            cadSQL = "SELECT D.desdist, D.codDist FROM DISTRITO D "
                    + "JOIN PROVINCIA P ON P.codprov=D.codprov "
                    + "JOIN DEPARTAMENTO DEP ON dep.coddpto=d.coddpto "
                    + "WHERE P.desProv='" + nombreProv + "' AND dep.desdpto='" + nombreDept + "' ORDER BY D.codDist";
            ResultSet rs = stm.executeQuery(cadSQL);
            String Distritos = "";
            while (rs.next()) {
                Distritos += rs.getString(1) + "#";
            }
            return Distritos;
        } catch (Exception e) {
            System.out.println("No existe la tabla de Distritos");
            return null;
        }
    }

    public String leerClientes() throws SQLException {
        stm = conex.createStatement();
        String cadSQL = "";
        try {
            cadSQL = "SELECT DesPliego FROM CLIENTE";   //No se sabe si es eso
            ResultSet rs = stm.executeQuery(cadSQL);
            String Clientes = "";
            while (rs.next()) {
                Clientes += rs.getString(1) + "#";
            }
            return Clientes;
        } catch (Exception e) {
            System.out.println("No existe la tabla de Clientes");
            return null;
        }
    }

    public String leerEspecialistas() throws SQLException {
        stm = conex.createStatement();
        String cadSQL = "";
        try {
            cadSQL = "SELECT DesPersona FROM PERSONA";
            ResultSet rs = stm.executeQuery(cadSQL);
            String Especialistas = "";
            while (rs.next()) {
                Especialistas += rs.getString(1) + "#";
            }
            return Especialistas;
        } catch (Exception e) {
            System.out.println("No existe la tabla de Especialistas");
            return null;
        }
    }

    public void guardarProyecto(String codPyto,int codFase, int codNivel, String codSNIP, String nombPyto, java.sql.Date fecReg, double costoPIP, double costoDIR, int codEstado, String codFuncion, String codDpto, String codProv, String codDist, String nombCliente, String nombEsp, String nombResp, String Observac, String Vigente) throws SQLException {
        String cadSQL;
        try {
            //Guardar el Proyecto
            cadSQL = "BEGIN "
                    + "packProyecto.InsertarProyecto(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); "
                    + "END;";
            CallableStatement cs= conex.prepareCall(cadSQL);
            cs.setObject(1, new oracle.sql.NUMBER(codPyto), OracleTypes.NUMBER);
            cs.setObject(2, new oracle.sql.NUMBER(codFase), OracleTypes.NUMBER);
            cs.setObject(3, new oracle.sql.NUMBER(codNivel), OracleTypes.NUMBER);
            cs.setString(4, codSNIP);
            cs.setString(5, nombPyto);
            cs.setDate(6, fecReg);
            cs.setObject(7, new oracle.sql.NUMBER(costoPIP), OracleTypes.NUMBER);
            cs.setObject(8, new oracle.sql.NUMBER(costoDIR), OracleTypes.NUMBER);
            cs.setObject(9, new oracle.sql.NUMBER(codEstado), OracleTypes.NUMBER);
            cs.setString(10, String.valueOf(codFuncion));
            cs.setString(11, codDpto);
            cs.setString(12, codProv);
            cs.setString(13, codDist);
            cs.setString(14, nombCliente);
            cs.setString(15, nombEsp);
            cs.setString(16, nombResp);
            cs.setString(17, Observac);
            cs.setString(18, Vigente);
            //System.out.println(" "+ codPyto+" "+ codFase+" "+ codNivel+" "+ codSNIP+" "+ nombPyto+" "+ fecReg+" "+ costoPIP+" "+ costoDIR+" "+ codEstado+" "+ codFuncion+" "+ codDpto+" "
            //        + codProv+" "+ codDist+" "+ codCli+" "+ codEsp+" "+ codResp+" "+ Observac+" "+ Vigente+" ");

            cs.executeUpdate();
            System.out.println("Proyecto ingresado");
        } catch (Exception e) {
            System.out.println("No se pudo ingresar el proyecto");
            Logger.getLogger(BackEnd.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public Object[] recuperarProyecto(String codPyto) throws SQLException {
        String cadSQL;
        Object[] Proyecto = new Object[18];   //Cantidad de atributos que tiene el proyecto
        try {

            cadSQL = "SELECT * FROM PROYECTO WHERE codPyto=?";
            PreparedStatement ps = conex.prepareStatement(cadSQL);
            ps.setString(1, codPyto);
            ResultSet rs = ps.executeQuery();
            rs.next();

            Proyecto[0] = rs.getObject(1);            //CodPyto
            String codFase =String.valueOf(rs.getObject(2));//codFase
            String codNivel =String.valueOf(rs.getObject(3));//codNivel
            Proyecto[3] = rs.getString(4);            //codSNIP
            Proyecto[4] = rs.getString(5);            //nombProyecto
            Proyecto[5] = rs.getDate(6).getTime();    //FecReg
            Proyecto[6] = rs.getObject(7);            //CostoPIP
            Proyecto[7] = rs.getObject(8);            //CostoDIR
            String codEstado =String.valueOf(rs.getObject(9));//CodEstado
            String codFuncion =String.valueOf(rs.getObject(10));//CodFuncion
            String codDpto = rs.getString(11);            //codDpto

            String codProv = rs.getString(12);   //CodProv
            String codDist = rs.getString(13);  //CodDist
            String codCli = String.valueOf(rs.getObject(14));  //CodCli
            String codEsp = String.valueOf(rs.getObject(15));  //CodEsp
            String codResp = String.valueOf(rs.getObject(16));  //CodEsp
            
            Proyecto[16] = rs.getString(17);            //Observac
            Proyecto[17] = rs.getString(18);            //Vigente

            
            //Conseguimos el nombre de la Fase
            cadSQL = "SELECT desFase FROM FASE "
                    + "WHERE codFase=?";
            ps = conex.prepareStatement(cadSQL);
            ps.setString(1, codFase);
            rs = ps.executeQuery();
            rs.next();
            Proyecto[1] = rs.getString(1);    //desFase
            
            //Conseguimos el nombre de la Nivel
            cadSQL = "SELECT desNivel FROM NIVEL "
                    + "WHERE codFase=? AND codNivel=?";
            ps = conex.prepareStatement(cadSQL);
            ps.setString(1, codFase);
            ps.setString(2, codNivel);
            rs = ps.executeQuery();
            rs.next();
            Proyecto[2] = rs.getString(1);    //desNivel
            
            //Conseguimos el nombre del Estado
            cadSQL = "SELECT desEstado FROM ESTADO "
                    + "WHERE codFase=? AND codNivel=? AND estPyto=?";
            ps = conex.prepareStatement(cadSQL);
            ps.setString(1, codFase);
            ps.setString(2, codNivel);
            ps.setString(3, codEstado);
            rs = ps.executeQuery();
            rs.next();
            Proyecto[8] = rs.getString(1);    //desEstado
            
            //Conseguimos el nombre de Función
            cadSQL = "SELECT desFuncion FROM Funcion "
                    + "WHERE codFuncion=?";
            ps = conex.prepareStatement(cadSQL);
            ps.setString(1, codFuncion);
            rs = ps.executeQuery();
            rs.next();
            Proyecto[9] = rs.getString(1);    //desFuncion
            
            //Conseguimos el nombre del Departamento
            cadSQL = "SELECT desDpto FROM Departamento "
                    + "WHERE codDpto=?";
            ps = conex.prepareStatement(cadSQL);
            ps.setString(1, codDpto);
            rs = ps.executeQuery();
            rs.next();
            Proyecto[10] = rs.getString(1);    //desFuncion
            
            //Conseguimos el nombre de Provincia
            cadSQL = "SELECT desprov FROM PROVINCIA "
                    + "WHERE codprov=? AND codDpto=?";
            ps = conex.prepareStatement(cadSQL);
            ps.setString(1, codProv);
            ps.setString(2, codDpto);
            rs = ps.executeQuery();
            rs.next();
            Proyecto[11] = rs.getString(1);    //NombProv

            //Conseguimos el nombre de distrito
            cadSQL = "SELECT desdist FROM DISTRITO "
                    + "WHERE coddist=? AND codProv=? AND codDpto=?";
            ps = conex.prepareStatement(cadSQL);
            ps.setString(1, codDist);
            ps.setString(2, codProv);
            ps.setString(3, codDpto);
            rs = ps.executeQuery();
            rs.next();
            Proyecto[12] = rs.getString(1);   //NombDist

            //Conseguimos el nombre de cliente
            cadSQL = "SELECT desPliego FROM CLIENTE WHERE codCli=?";
            ps = conex.prepareStatement(cadSQL);
            ps.setString(1, codCli);
            rs = ps.executeQuery();
            rs.next();
            Proyecto[13] = rs.getString(1);   //NombCli

            //Conseguimos el nombre de especialista
            cadSQL = "SELECT DesPersona FROM PERSONA WHERE codPers =?";
            ps = conex.prepareStatement(cadSQL);
            ps.setString(1, codEsp);
            rs = ps.executeQuery();
            rs.next();
            Proyecto[14] = rs.getString(1);   //NombEsp
            
            //Conseguimos el nombre de responsable
            cadSQL = "SELECT DesPersona FROM PERSONA WHERE codPers =?";
            ps = conex.prepareStatement(cadSQL);
            ps.setString(1, codResp);
            rs = ps.executeQuery();
            rs.next();
            Proyecto[15] = rs.getString(1);

            //for(Object obj : Proyecto)
            //    System.out.println(obj);
            return Proyecto;
        } catch (Exception e) {
            System.out.println("No se pudo recuperar  el proyecto");
            Logger.getLogger(BackEnd.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public void actualizarProyecto(String codPyto,int codFase, int codNivel, String codSNIP, String nombPyto, java.sql.Date fecReg, double costoPIP, double costoDIR, int codEstado, String codFuncion, String codDpto, String codProv, String codDist, String nombCliente, String nombEsp, String nombResp, String Observac, String Vigente) throws SQLException {
        String cadSQL;
        try {
            cadSQL = "BEGIN "
                    + "packProyecto.EditarProyecto(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); "
                    + "END;";
            CallableStatement cs= conex.prepareCall(cadSQL);
            cs.setObject(1, new oracle.sql.NUMBER(codPyto), OracleTypes.NUMBER);
            cs.setObject(2, new oracle.sql.NUMBER(codFase), OracleTypes.NUMBER);
            cs.setObject(3, new oracle.sql.NUMBER(codNivel), OracleTypes.NUMBER);
            cs.setString(4, codSNIP);
            cs.setString(5, nombPyto);
            cs.setDate(6, fecReg);
            cs.setObject(7, new oracle.sql.NUMBER(costoPIP), OracleTypes.NUMBER);
            cs.setObject(8, new oracle.sql.NUMBER(costoDIR), OracleTypes.NUMBER);
            cs.setObject(9, new oracle.sql.NUMBER(codEstado), OracleTypes.NUMBER);
            cs.setString(10, String.valueOf(codFuncion));
            cs.setString(11, codDpto);
            cs.setString(12, codProv);
            cs.setString(13, codDist);
            cs.setString(14, nombCliente);
            cs.setString(15, nombEsp);
            cs.setString(16, nombResp);
            cs.setString(17, Observac);
            cs.setString(18, Vigente);
            //System.out.println(" "+ codPyto+" "+ codFase+" "+ codNivel+" "+ codSNIP+" "+ nombPyto+" "+ fecReg+" "+ costoPIP+" "+ costoDIR+" "+ codEstado+" "+ codFuncion+" "+ codDpto+" "
            //        + codProv+" "+ codDist+" "+ nombCliente+" "+ nombEsp+" "+ nombResp+" "+ Observac+" "+ Vigente+" ");
            cs.executeUpdate();

            System.out.println("Proyecto ingresado");
        } catch (Exception e) {
            System.out.println("No se pudo ingresar el proyecto");
            Logger.getLogger(BackEnd.class.getName()).log(Level.SEVERE, null, e);
        }
    }

   //Agregados 18/10/2017 por Raúl
    public boolean verificarExistenciaProyecto(String codPyto){
        try{
            String cadSQL="SELECT codPyto FROM Proyecto WHERE codPyto='"+codPyto+"'";
            PreparedStatement ps=conex.prepareStatement(cadSQL);
            ResultSet rs=ps.executeQuery();
            rs.next();
            rs.getObject(1);    //Si no hay nada, entonces lanzará error
            return true;
        }catch(Exception e){
            System.out.println("No existe el Proyecto");
            //Logger.getLogger(BackEnd.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
    public Object[] buscarProyecto(String codPyto) throws SQLException{
        String cadSQL="SELECT codPyto, nomPyto, fecReg, costoPIP, costoDIR FROM Proyecto "
                + "WHERE codPyto='"+codPyto+"' AND Vigente='1'";
        PreparedStatement ps=conex.prepareStatement(cadSQL);
        ResultSet rs=ps.executeQuery();
        rs.next();
        Object[] Proyecto= new Object[5];
        Proyecto[0] = rs.getObject(1);            //CodPyto
        Proyecto[1] = rs.getString(2);            //NomPyto
        Proyecto[2] = rs.getDate(3).getTime();    //FecReg
        Proyecto[3] = rs.getObject(4);            //CostoPIP
        Proyecto[4] = rs.getObject(5);            //CostoDIR
        return Proyecto;
    }
    public Object[] buscarProyectoModificar(String codPyto) throws SQLException{
        String cadSQL="SELECT codPyto, nomPyto, fecReg, costoPIP, costoDIR FROM Proyecto "
                + "WHERE codPyto='"+codPyto+"'";
        PreparedStatement ps=conex.prepareStatement(cadSQL);
        ResultSet rs=ps.executeQuery();
        rs.next();
        Object[] Proyecto= new Object[5];
        Proyecto[0] = rs.getObject(1);            //CodPyto
        Proyecto[1] = rs.getString(2);            //NomPyto
        Proyecto[2] = rs.getDate(3).getTime();    //FecReg
        Proyecto[3] = rs.getObject(4);            //CostoPIP
        Proyecto[4] = rs.getObject(5);            //CostoDIR
        return Proyecto;
    }
    
    public String buscarProyectoNombre(String nombrePyto) throws SQLException{
        String cadSQL="SELECT codPyto, nomPyto, fecReg, costoPIP, costoDIR FROM Proyecto "
                + "WHERE nomPyto LIKE '%"+nombrePyto+"%' AND Vigente='1'";
        PreparedStatement ps=conex.prepareStatement(cadSQL);
        ResultSet rs=ps.executeQuery();
        String Proyectos="";
        while(rs.next()){
            Proyectos+=rs.getObject(1)+"#"+rs.getString(2)+"#"+rs.getDate(3).getTime()+"#"+rs.getObject(4)+"#"+rs.getObject(5)+"-";
        }
        return Proyectos;
    }    
    public String buscarProyectoNombreModificar(String nombrePyto) throws SQLException{
        String cadSQL="SELECT codPyto, nomPyto, fecReg, costoPIP, costoDIR FROM Proyecto "
                + "WHERE nomPyto LIKE '%"+nombrePyto+"%'";
        PreparedStatement ps=conex.prepareStatement(cadSQL);
        ResultSet rs=ps.executeQuery();
        String Proyectos="";
        while(rs.next()){
            Proyectos+=rs.getObject(1)+"#"+rs.getString(2)+"#"+rs.getDate(3).getTime()+"#"+rs.getObject(4)+"#"+rs.getObject(5)+"-";
        }
        return Proyectos;
    }

    public boolean borrarProyecto(String codPyto){
        
        String cadSQL = "BEGIN "
                    + "packProyecto.cancelarProyecto(?); "
                    + "END;";
        try {
            CallableStatement cs= conex.prepareCall(cadSQL);
            cs.setObject(1, new oracle.sql.NUMBER(codPyto), OracleTypes.NUMBER);
            cs.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BackEnd.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    //Agregados 19/10/2017 por Eduardo
    public String mostrarProyectosPorDepartamento(String codDpto) throws SQLException {
        stm = conex.createStatement();
        String cadSQL = "";
        try {
            cadSQL = "SELECT P.codpyto ,P.nompyto FROM PROYECTO P"

                    + " WHERE P.coddpto='" + codDpto + "'";
            ResultSet rs = stm.executeQuery(cadSQL);
            String datosProyecto = "";
            while (rs.next()) {
                datosProyecto += rs.getString(1) + "-" + rs.getString(2) + "#";
            }

            return datosProyecto;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String mostrarProyectosPorPrivincia(String codDpto,String codProv) throws SQLException {
        stm = conex.createStatement();
        String cadSQL = "";
        try {
            cadSQL = "SELECT P.codpyto ,P.nompyto FROM PROYECTO P"
                    + " WHERE P.coddpto='" + codDpto + "' AND P.codProv='"+codProv+"'";
            ResultSet rs = stm.executeQuery(cadSQL);
            String datosProyecto = "";
            while (rs.next()) {
                datosProyecto += rs.getString(1) + "-" + rs.getString(2) + "#";
            }

            return datosProyecto;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public String mostrarProyectosPorDistrito(String codDpto,String codProv,String codDist) throws SQLException {
        stm = conex.createStatement();
        String cadSQL = "";
        try {
            cadSQL = "SELECT codpyto, nompyto FROM PROYECTO WHERE coddpto='"+codDpto+"' and codprov='"+codProv+"'  and"
                    + " coddist='"+codDist+"'";
            ResultSet rs = stm.executeQuery(cadSQL);
            String datosProyecto = "";
            while (rs.next()) {
                datosProyecto += rs.getString(1) + "-" + rs.getString(2) + "#";
            }

            return datosProyecto;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public String obtenerCodigoDistrito(String nombreDistrito) throws SQLException {
        stm = conex.createStatement();
        String cadSQL = "";
        try {
            cadSQL = "SELECT coddist FROM DISTRITO WHERE desdist='" + nombreDistrito + "'";
            ResultSet rs = stm.executeQuery(cadSQL);
            String coddist = "";
            rs.next();
            coddist = rs.getString(1);

            return coddist;
        } catch (Exception e) {
            System.out.println("Error");
            return null;
        }
    }

    public String obtenerCodigoProvincia(String nombreProvincia) throws SQLException {
        stm = conex.createStatement();
        String cadSQL = "";
        try {
            cadSQL = "SELECT codprov FROM PROVINCIA WHERE desprov='" + nombreProvincia + "'";
            ResultSet rs = stm.executeQuery(cadSQL);
            String codprov = "";
            rs.next();
            codprov = rs.getString(1);

            return codprov;
        } catch (Exception e) {
            System.out.println("Error");
            return null;
        }
    }
    
    public String obtenerCodigoDepartamento(String nombreDepartamento) throws SQLException {
        stm = conex.createStatement();
        String cadSQL = "";
        try {
            cadSQL = "SELECT coddpto FROM DEPARTAMENTO WHERE desdpto='" + nombreDepartamento + "'";
            ResultSet rs = stm.executeQuery(cadSQL);
            String coddpto = "";
            rs.next();
            coddpto = rs.getString(1);

            return coddpto;
        } catch (Exception e) {
            System.out.println("Error");
            return null;
        }
    }
    
    public ArrayList<edu.unmsm.sistemas.sgpy.Proyecto.Clases.Proyecto> Buscar_por_nombre_proyecto(String cad) throws SQLException{
        stm = conex.createStatement();
        String cadSQL = "";
        
        try {
            cadSQL="select codpyto , nompyto from proyecto where NOMPYTO LIKE '%"+cad+"%'";
            ResultSet rs=stm.executeQuery(cadSQL);
            ArrayList<edu.unmsm.sistemas.sgpy.Proyecto.Clases.Proyecto> VP= new ArrayList<edu.unmsm.sistemas.sgpy.Proyecto.Clases.Proyecto>();
            VP.clear();
            edu.unmsm.sistemas.sgpy.Proyecto.Clases.Proyecto p;
            while (rs.next()) { 
                p=new edu.unmsm.sistemas.sgpy.Proyecto.Clases.Proyecto(rs.getString(1),rs.getString(2));
                VP.add(p);
            }
            return VP;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("11");
            return null;
        }
        finally{
            
        }
    }
    public ArrayList<edu.unmsm.sistemas.sgpy.Proyecto.Clases.Proyecto> Buscar_por_nombre_proyecto_Departamento(String cad,String codDpto) throws SQLException{
        stm = conex.createStatement();
        String cadSQL = "";
        
        try {
            cadSQL="select codpyto , nompyto from proyecto where NOMPYTO LIKE '%"+cad+"%' AND codDpto='"+codDpto+"'";
            ResultSet rs=stm.executeQuery(cadSQL);
            ArrayList<edu.unmsm.sistemas.sgpy.Proyecto.Clases.Proyecto> VP= new ArrayList<edu.unmsm.sistemas.sgpy.Proyecto.Clases.Proyecto>();
            VP.clear();
            edu.unmsm.sistemas.sgpy.Proyecto.Clases.Proyecto p;
            while (rs.next()) { 
                p=new edu.unmsm.sistemas.sgpy.Proyecto.Clases.Proyecto(rs.getString(1),rs.getString(2));
                VP.add(p);
            }
            return VP;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("11");
            return null;
        }
        finally{
            
        }
    }
    public ArrayList<edu.unmsm.sistemas.sgpy.Proyecto.Clases.Proyecto> Buscar_por_nombre_proyecto_Provincia(String cad,String codDpto, String codProv) throws SQLException{
        stm = conex.createStatement();
        String cadSQL = "";
        
        try {
            cadSQL="select codpyto , nompyto from proyecto where NOMPYTO LIKE '%"+cad+"%' AND codDpto='"+codDpto+"' AND codProv='"+codProv+"'";
            ResultSet rs=stm.executeQuery(cadSQL);
            ArrayList<edu.unmsm.sistemas.sgpy.Proyecto.Clases.Proyecto> VP= new ArrayList<edu.unmsm.sistemas.sgpy.Proyecto.Clases.Proyecto>();
            VP.clear();
            edu.unmsm.sistemas.sgpy.Proyecto.Clases.Proyecto p;
            while (rs.next()) { 
                p=new edu.unmsm.sistemas.sgpy.Proyecto.Clases.Proyecto(rs.getString(1),rs.getString(2));
                VP.add(p);
            }
            return VP;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("11");
            return null;
        }
        finally{
            
        }
    }
    
    public ArrayList<edu.unmsm.sistemas.sgpy.Proyecto.Clases.Proyecto> Buscar_por_nombre_proyecto_Distrito(String cad,String codDpto, String codProv, String codDist) throws SQLException{
        stm = conex.createStatement();
        String cadSQL = "";
        
        try {
            cadSQL="select codpyto , nompyto from proyecto where NOMPYTO LIKE '%"+cad+"%' AND coddpto='"+codDpto+"' and codprov='"+codProv+"'  and"
                    + " coddist='"+codDist+"'";
            ResultSet rs=stm.executeQuery(cadSQL);
            ArrayList<edu.unmsm.sistemas.sgpy.Proyecto.Clases.Proyecto> VP= new ArrayList<edu.unmsm.sistemas.sgpy.Proyecto.Clases.Proyecto>();
            VP.clear();
            edu.unmsm.sistemas.sgpy.Proyecto.Clases.Proyecto p;
            while (rs.next()) { 
                p=new edu.unmsm.sistemas.sgpy.Proyecto.Clases.Proyecto(rs.getString(1),rs.getString(2));
                VP.add(p);
            }
            return VP;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("11");
            return null;
        }
        finally{
            
        }
    }
    
    public static void main(String[] Args) throws SQLException {
        //BackEnd Oracle= new BackEnd();
    }
}
