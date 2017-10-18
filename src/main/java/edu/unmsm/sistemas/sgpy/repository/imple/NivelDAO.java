/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.repository.imple;

import edu.unmsm.sistemas.sgpy.entities.Nivel;
import edu.unmsm.sistemas.sgpy.repository.DAOConnection;
import edu.unmsm.sistemas.sgpy.repository.ModeloIDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexander
 */
public class NivelDAO implements ModeloIDAO<Nivel, Nivel> {

    private static final NivelDAO NIVELDAO = new NivelDAO();

    public static NivelDAO getInstance() {
        return NIVELDAO;
    }

    @Override
    public List<Nivel> listar() {
        List<Nivel> miLista = new ArrayList<>(); //Indica implementar todos sus métodos
        DAOConnection acceso = DAOConnection.getInstance();
        String sql = "SELECT * FROM Nivel", DesNivel, Fase, Vigente;
        Integer CodFase, CodNivel;
        try {
            PreparedStatement comando = acceso.getConexion().prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                CodFase = resultado.getInt(1);
                CodNivel = resultado.getInt(2);
                DesNivel = resultado.getString(3);
                Fase = resultado.getString(4);
                Vigente = resultado.getString(4);
                miLista.add(new Nivel(CodFase, CodNivel, DesNivel, Fase, Vigente));
            }
        } catch (SQLException ex) {
        } finally {
            acceso.close();
        }
        return miLista;
    }

    @Override
    public String insertar(Nivel nuevo) {
        String rpta = "Insercion Completada";
        DAOConnection acceso = DAOConnection.getInstance();
        String sql = "INSERT INTO Nivel VALUES (?,?,?,?,?)";
        try {
            PreparedStatement comando = acceso.getConexion().prepareStatement(sql);

            comando.setString(1, String.valueOf(nuevo.getCodFase()));
            comando.setString(2, String.valueOf(nuevo.getCodNivel()));
            comando.setString(3, nuevo.getDesNivel());
            comando.setString(4, nuevo.getFase());
            comando.setString(5, nuevo.getVigente());

            int insertado = comando.executeUpdate();

            if (insertado == 0) {
                rpta = "Error al Insertar";
            }

        } catch (SQLException ex) {
            rpta = ex.getMessage();
        } finally {
            acceso.close();
        }
        return rpta;
    }

    @Override
    public String actualizar(Nivel actualizacion) {
        String rpta = "Actualizacion Completada";
        DAOConnection acceso = DAOConnection.getInstance();
        String sql = "UPDATE Nivel SET CodFase=?,CodNivel=?,DesNivel=?,Fase=?,Vigente=?  WHERE CodFase = '"
                + actualizacion.getCodFase() + "'";//Lucho revisa ese where si esta bien pq no entiendo la BD del profe :v
        try {

            PreparedStatement comando = acceso.getConexion().prepareStatement(sql);
            comando.setString(1, String.valueOf(actualizacion.getCodFase()));
            comando.setString(2, String.valueOf(actualizacion.getCodNivel()));
            comando.setString(3, actualizacion.getDesNivel());
            comando.setString(4, actualizacion.getFase());
            comando.setString(5, actualizacion.getVigente());
            int actualizar = comando.executeUpdate();
            if (actualizar == 0) {
                rpta = "Error al actualizar";
            }

        } catch (SQLException ex) {
            rpta = ex.getMessage();
        } finally {
            acceso.close();
        }
        return rpta;
    }

    @Override
    public String eliminar(int CodFase) {
        String rpta = "Eliminacion Completada";
        DAOConnection acceso = DAOConnection.getInstance();
        String sql = "DELETE FROM Nivel WHERE CodFase = ?";//Lucho revisa este where si esta bien pq no entiendo la BD del profe :v

        try {

            PreparedStatement comando = acceso.getConexion().prepareStatement(sql);
            comando.setInt(1, CodFase);
            int eliminar = comando.executeUpdate();
            if (eliminar == 0) {
                rpta = "Error Eliminar";
            }
        } catch (SQLException ex) {
            rpta = ex.getMessage();
        } finally {
            acceso.close();
        }
        return rpta;
    }

}
