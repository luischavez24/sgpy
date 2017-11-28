/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.Persona.controlador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.Blob;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import edu.unmsm.sistemas.sgpy.Persona.vista.*;
import edu.unmsm.sistemas.sgpy.Persona.modelo.*;
/**
 *
 * @author CARLOS
 */
public class ControladorCrudPersona implements ActionListener{
    JFAgregarPersona vistaCRUD1 = new JFAgregarPersona();
    JFModificarPersona vistaCRUD2 = new JFModificarPersona();
    JFEliminarPersona vistaCRUD3 = new JFEliminarPersona();
    JFVisualizarPersona vistaCRUD4 = new JFVisualizarPersona();    
    PersonaDAO modeloCRUD =new PersonaDAO();

    public ControladorCrudPersona(JFAgregarPersona vistaCRUD1, PersonaDAO modeloCRUD) {
        this.modeloCRUD = modeloCRUD;
        this.vistaCRUD1 = vistaCRUD1;
        this.vistaCRUD1.btnRegistrar.addActionListener(this);
    }
    
    public ControladorCrudPersona(JFModificarPersona vistaCRUD2, PersonaDAO modeloCRUD) {
        this.modeloCRUD = modeloCRUD;
        this.vistaCRUD2 = vistaCRUD2;
        this.vistaCRUD2.textBusqueda.addActionListener(this);
        this.vistaCRUD2.btnVisualizarPersona.addActionListener(this);
        this.vistaCRUD2.btnBusquedaPersona.addActionListener(this);
        this.vistaCRUD2.btnGuardarCambios.addActionListener(this);
        this.vistaCRUD2.radioPorCodigo.setSelected(true);
    }
    
    public ControladorCrudPersona(JFEliminarPersona vistaCRUD3, PersonaDAO modeloCRUD) {
        this.modeloCRUD = modeloCRUD;
        this.vistaCRUD3 = vistaCRUD3;
        this.vistaCRUD3.textBusqueda.addActionListener(this);
        this.vistaCRUD3.btnVisualizarPersona.addActionListener(this);
        this.vistaCRUD3.btnBusquedaPersona.addActionListener(this);
        this.vistaCRUD3.btnEliminar.addActionListener(this);
        this.vistaCRUD3.radioPorCodigo.setSelected(true);
    }
    
    public ControladorCrudPersona(JFVisualizarPersona vistaCRUD4, PersonaDAO modeloCRUD) {
        this.modeloCRUD = modeloCRUD;
        this.vistaCRUD4 = vistaCRUD4;
        this.vistaCRUD4.btnVisualizarPersona.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaCRUD1.btnRegistrar) {
            int CodPers = modeloCRUD.codPersona();
            int corEmp = Integer.parseInt(String.valueOf(CodPers).substring(0, 2));
            String TipPersona = String.valueOf(vistaCRUD1.comboTipoPersona.getSelectedIndex());
            String DesPersona = vistaCRUD1.textDescripcion.getText().trim();
            String DesCorta = vistaCRUD1.textDescripcion2.getText().trim();
            String FlagCli = vistaCRUD1.radioBotton();
            String FlagEsp = vistaCRUD1.radioBotton2();
            String FlagProf = vistaCRUD1.radioBotton3();
            String Direcc = vistaCRUD1.textDireccion.getText().trim();
            String Hobby = vistaCRUD1.textHobby.getText().trim();
            FileInputStream archivo = vistaCRUD1.archivo;
            int longitudBytes = vistaCRUD1.longitudBytes;
            String FecNac = vistaCRUD1.devolverFecha(vistaCRUD1.fecNac);
            String CodDpto = String.valueOf(vistaCRUD1.dep.get(vistaCRUD1.comboDepartamento.getSelectedIndex()).getCodDpto());
            String CodProv = vistaCRUD1.codProvincia();
            String CodDist = vistaCRUD1.codDistrito();
            String DNI = vistaCRUD1.textDNI.getText().trim();
            String NroCIP = vistaCRUD1.textNROCIP.getText().trim();
            String FecCIPVig=vistaCRUD1.devolverFecha(vistaCRUD1.fecVigente);
            int CentroTrabajo = 0;
            if (vistaCRUD1.comboTipoPersona.getSelectedIndex() == 0) {
                CentroTrabajo = vistaCRUD1.personaJuridica.get(vistaCRUD1.comboCentroTrabajo.getSelectedIndex()).getCodPers();
            }
            String Cargo;
            if(vistaCRUD1.comboTipoPersona.getSelectedIndex()== 1){
                Cargo="";
            }
            else{
                if (vistaCRUD1.comboCargo.getSelectedIndex() == 2) {
                    Cargo = vistaCRUD1.textCargo.getText().trim();
                } else {
                    Cargo = String.valueOf(vistaCRUD1.comboCargo.getSelectedItem());
                }
            }
            String LicCond = String.valueOf(vistaCRUD1.comboLicencia.getSelectedIndex());
            String Observac = vistaCRUD1.textObservaciones.getText().trim();
            String Vigente;
            if(vistaCRUD1.comboLicencia.getSelectedIndex()==0){
                Vigente="";
            }
            else{
                Vigente = String.valueOf(vistaCRUD1.comboVigencia.getSelectedIndex());
            }
            String rptaRegistro = modeloCRUD.insertarPersona(CodPers, TipPersona, DesPersona, DesCorta, FlagCli, FlagEsp,
                    FlagProf, Direcc, Hobby, archivo, longitudBytes, FecNac, CodDpto, CodProv, CodDist,
                    DNI, NroCIP, FecCIPVig, CentroTrabajo, Cargo, LicCond, Observac,
                    Vigente);
            if (vistaCRUD1.radioCliente.isSelected()) {
                ClienteDAO modelo = new ClienteDAO();
                JFAgregarCliente frame = new JFAgregarCliente();
                ControladorCrudCliente cliente = new ControladorCrudCliente(frame, modelo);
                frame.inicio(CodPers, corEmp);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                vistaCRUD1.dispose();
            } else if (rptaRegistro != null) {
                JOptionPane.showMessageDialog(null, rptaRegistro);
            } else {
                JOptionPane.showMessageDialog(null, "Registro erroneo. ");
            }
        }
        if (e.getSource() == vistaCRUD2.btnVisualizarPersona) {
            vistaCRUD2.aux = modeloCRUD.listPersona();
            vistaCRUD2.modelo1 = new DefaultTableModel();
            String[] cabecera = {"Código", "DNI", "Fecha de nacimiento"};
            String[][] datos = new String[vistaCRUD2.aux.size()][3];
            for (int i = 0; i < vistaCRUD2.aux.size(); i++) {
                datos[i][0] = String.valueOf(vistaCRUD2.aux.get(i).getCodPers());
                datos[i][1] = String.valueOf(vistaCRUD2.aux.get(i).getDNI());
                datos[i][2] = String.valueOf(vistaCRUD2.aux.get(i).getFecNac());
            }
            vistaCRUD2.modelo1 = new DefaultTableModel(datos, cabecera);
            vistaCRUD2.tablaPersona.setModel(vistaCRUD2.modelo1);
        }
        if (e.getSource() == vistaCRUD2.btnBusquedaPersona || e.getSource() == vistaCRUD2.textBusqueda) {
            vistaCRUD2.aux = modeloCRUD.listPersona();
            for (int i = 0; i < vistaCRUD2.aux.size(); i++) {
                if (vistaCRUD2.radioPorCodigo.isSelected()) {
                    if (String.valueOf(vistaCRUD2.aux.get(i).getDNI()).toUpperCase().equals(vistaCRUD2.textBusqueda.getText().toUpperCase())) {
                        ImageIcon promo = new ImageIcon(vistaCRUD2.aux.get(i).getBytesLeidos());
                        ImageIcon icono = new ImageIcon(promo.getImage().getScaledInstance(vistaCRUD2.lblMostrarFoto.getWidth(), vistaCRUD2.lblMostrarFoto.getHeight(), Image.SCALE_DEFAULT));
                        vistaCRUD2.foto = vistaCRUD2.aux.get(i).getFoto();
                        vistaCRUD2.codPersona = vistaCRUD2.aux.get(i).getCodPers();
                        vistaCRUD2.lblMostrarFoto.setIcon(icono);
                        vistaCRUD2.textTipoPersona.setEditable(true);
                        vistaCRUD2.textDepartamento.setEditable(true);
                        vistaCRUD2.textProvincia.setEditable(true);
                        vistaCRUD2.textDistrito.setEditable(true);
                        vistaCRUD2.textVigenciaLicencia.setEditable(true);
                        vistaCRUD2.textAreaDescripcion.setText(vistaCRUD2.aux.get(i).getDesPersona());
                        vistaCRUD2.textAreaDescripcion2.setText(vistaCRUD2.aux.get(i).getDesCorta());
                        vistaCRUD2.textAreaHobby.setText(vistaCRUD2.aux.get(i).getHobby());
                        vistaCRUD2.textAreaObservaciones.setText(vistaCRUD2.aux.get(i).getObservac());
                        vistaCRUD2.textCargo.setText(vistaCRUD2.aux.get(i).getCargo());
                        vistaCRUD2.textCentroTrabajo.setText(modeloCRUD.descripcion(vistaCRUD2.aux.get(i).getCentroTrabajo()));
                        vistaCRUD2.textDNI.setText(vistaCRUD2.aux.get(i).getDNI());
                        vistaCRUD2.textDepartamento.setText(vistaCRUD2.dep.busquedaDepartamento(vistaCRUD2.aux.get(i).getCodDpto()));
                        vistaCRUD2.textDireccion.setText(vistaCRUD2.aux.get(i).getDirecc());
                        vistaCRUD2.textDistrito.setText(vistaCRUD2.dist.busquedaDistrito(vistaCRUD2.aux.get(i).getCodDpto(), vistaCRUD2.aux.get(i).getCodProv(), vistaCRUD2.aux.get(i).getCodDist()));
                        vistaCRUD2.dateFechaVigente.setDate(vistaCRUD2.aux.get(i).getFecCIPVig());
                        if(vistaCRUD2.aux.get(i).getLicCond().equals("0")){
                            vistaCRUD2.textLicencia.setText("No posee");
                            vistaCRUD2.comboLicenciaConducir.setSelectedIndex(0);
                            vistaCRUD2.comboVigenciaLicencia.setEnabled(false);
                            vistaCRUD2.textVigenciaLicencia.setEnabled(false);
                        }
                        else{
                            vistaCRUD2.textLicencia.setText("Posee");
                            vistaCRUD2.comboLicenciaConducir.setSelectedIndex(1);
                            vistaCRUD2.comboVigenciaLicencia.setEnabled(true);
                        }   
                        if(vistaCRUD2.aux.get(i).getVigente()==null){
                            vistaCRUD2.textVigenciaLicencia.setText("");
                        }
                        else{
                            if (vistaCRUD2.aux.get(i).getVigente().equals("1")) {
                                vistaCRUD2.textVigenciaLicencia.setText("Vigente");
                            } else {
                                vistaCRUD2.textVigenciaLicencia.setText("No vigente");
                            }
                        }
                        vistaCRUD2.dateFecNacimiento.setDate(vistaCRUD2.aux.get(i).getFecNac());
                        vistaCRUD2.textNroCIP.setText(vistaCRUD2.aux.get(i).getNroCIP());
                        vistaCRUD2.textProvincia.setText(vistaCRUD2.prov.busquedaProvincia(vistaCRUD2.aux.get(i).getCodDpto(), vistaCRUD2.aux.get(i).getCodProv()));
                        if (vistaCRUD2.aux.get(i).getTipPersona().equals("1")) {
                            vistaCRUD2.textTipoPersona.setText("Jurídica");
                            vistaCRUD2.comboTipoDePersona.setSelectedIndex(1);
                            vistaCRUD2.comboTipoDePersona.setEnabled(false);
                            vistaCRUD2.comboCentroTrabajo.setEnabled(false);
                            vistaCRUD2.comboCargo.setEnabled(false);
                            vistaCRUD2.textCentroTrabajo.setEnabled(false);
                            vistaCRUD2.textCargo.setEnabled(false);
                        } else {
                            vistaCRUD2.textTipoPersona.setText("Natural");
                        }
                        vistaCRUD2.textTipoPersona.setEditable(false);
                        vistaCRUD2.textDepartamento.setEditable(false);
                        vistaCRUD2.textProvincia.setEditable(false);
                        vistaCRUD2.textDistrito.setEditable(false);
                        vistaCRUD2.textVigenciaLicencia.setEditable(true);
                        vistaCRUD2.listaPersonaTics = vistaCRUD2.perTics.busqueda(vistaCRUD2.aux.get(i).getCodPers());
                        vistaCRUD2.listaTics = vistaCRUD2.tics.listTics();
                        if (vistaCRUD2.listaPersonaTics != null) {
                            vistaCRUD2.modelo2 = new DefaultTableModel();
                            String[] cabecera = {"Código TIC", "Nombre", "Descripción"};
                            String[][] datos = new String[vistaCRUD2.listaPersonaTics.size()][3];
                            for (int j = 0; j < vistaCRUD2.listaPersonaTics.size(); j++) {
                                datos[j][0] = String.valueOf(vistaCRUD2.listaPersonaTics.get(j).getCodTics());
                                for (int k = 0; k < vistaCRUD2.listaTics.size(); k++) {
                                    if (vistaCRUD2.listaTics.get(k).getCodTics() == vistaCRUD2.listaPersonaTics.get(j).getCodTics()) {
                                        datos[j][1] = String.valueOf(vistaCRUD2.listaTics.get(k).getDesTics());
                                    }
                                }
                                datos[j][2] = String.valueOf(vistaCRUD2.listaPersonaTics.get(j).getDesMedio());
                            }
                            vistaCRUD2.modelo2 = new DefaultTableModel(datos, cabecera);
                            vistaCRUD2.tablaPersonaTics.setModel(vistaCRUD2.modelo2);
                        }
                    }
                }
                if(vistaCRUD2.radioPorNombre.isSelected()){
                    if (vistaCRUD2.aux.get(i).getDesPersona().toUpperCase().equals(vistaCRUD2.textBusqueda.getText().toUpperCase())) {
                        ImageIcon promo = new ImageIcon(vistaCRUD2.aux.get(i).getBytesLeidos());
                        ImageIcon icono = new ImageIcon(promo.getImage().getScaledInstance(vistaCRUD2.lblMostrarFoto.getWidth(), vistaCRUD2.lblMostrarFoto.getHeight(), Image.SCALE_DEFAULT));
                        vistaCRUD2.foto = vistaCRUD2.aux.get(i).getFoto();
                        vistaCRUD2.codPersona = vistaCRUD2.aux.get(i).getCodPers();
                        vistaCRUD2.lblMostrarFoto.setIcon(icono);
                        vistaCRUD2.textTipoPersona.setEditable(true);
                        vistaCRUD2.textDepartamento.setEditable(true);
                        vistaCRUD2.textProvincia.setEditable(true);
                        vistaCRUD2.textDistrito.setEditable(true);
                        vistaCRUD2.textVigenciaLicencia.setEditable(true);
                        vistaCRUD2.textAreaDescripcion.setText(vistaCRUD2.aux.get(i).getDesPersona());
                        vistaCRUD2.textAreaDescripcion2.setText(vistaCRUD2.aux.get(i).getDesCorta());
                        vistaCRUD2.textAreaHobby.setText(vistaCRUD2.aux.get(i).getHobby());
                        vistaCRUD2.textAreaObservaciones.setText(vistaCRUD2.aux.get(i).getObservac());
                        vistaCRUD2.textCargo.setText(vistaCRUD2.aux.get(i).getCargo());
                        vistaCRUD2.textCentroTrabajo.setText(modeloCRUD.descripcion(vistaCRUD2.aux.get(i).getCentroTrabajo()));
                        vistaCRUD2.textDNI.setText(vistaCRUD2.aux.get(i).getDNI());
                        vistaCRUD2.textDepartamento.setText(vistaCRUD2.dep.busquedaDepartamento(vistaCRUD2.aux.get(i).getCodDpto()));
                        vistaCRUD2.textDireccion.setText(vistaCRUD2.aux.get(i).getDirecc());
                        vistaCRUD2.textDistrito.setText(vistaCRUD2.dist.busquedaDistrito(vistaCRUD2.aux.get(i).getCodDpto(), vistaCRUD2.aux.get(i).getCodProv(), vistaCRUD2.aux.get(i).getCodDist()));
                        vistaCRUD2.dateFechaVigente.setDate(vistaCRUD2.aux.get(i).getFecCIPVig());
                        if(vistaCRUD2.aux.get(i).getLicCond().equals("0")){
                            vistaCRUD2.textLicencia.setText("No posee");
                            vistaCRUD2.comboLicenciaConducir.setSelectedIndex(0);
                            vistaCRUD2.comboVigenciaLicencia.setEnabled(false);
                            vistaCRUD2.textVigenciaLicencia.setEnabled(false);
                        }
                        else{
                            vistaCRUD2.textLicencia.setText("Posee");
                            vistaCRUD2.comboLicenciaConducir.setSelectedIndex(1);
                            vistaCRUD2.comboVigenciaLicencia.setEnabled(true);
                        }                       
                        if(vistaCRUD2.aux.get(i).getVigente()==null){
                            vistaCRUD2.textVigenciaLicencia.setText("");
                        }
                        else{
                            if (vistaCRUD2.aux.get(i).getVigente().equals("1")) {
                                vistaCRUD2.textVigenciaLicencia.setText("Vigente");
                            } else {
                                vistaCRUD2.textVigenciaLicencia.setText("No vigente");
                            }
                        }                       
                        vistaCRUD2.dateFecNacimiento.setDate(vistaCRUD2.aux.get(i).getFecNac());
                        vistaCRUD2.textNroCIP.setText(vistaCRUD2.aux.get(i).getNroCIP());
                        vistaCRUD2.textProvincia.setText(vistaCRUD2.prov.busquedaProvincia(vistaCRUD2.aux.get(i).getCodDpto(), vistaCRUD2.aux.get(i).getCodProv()));
                        if (vistaCRUD2.aux.get(i).getTipPersona().equals("1")) {
                            vistaCRUD2.textTipoPersona.setText("Jurídica");
                            vistaCRUD2.comboTipoDePersona.setSelectedIndex(1);
                            vistaCRUD2.comboTipoDePersona.setEnabled(false);
                            vistaCRUD2.comboCentroTrabajo.setEnabled(false);
                            vistaCRUD2.comboCargo.setEnabled(false);
                            vistaCRUD2.textCentroTrabajo.setEnabled(false);
                            vistaCRUD2.textCargo.setEnabled(false);
                        } else {
                            vistaCRUD2.textTipoPersona.setText("Natural");
                        }
                        vistaCRUD2.textTipoPersona.setEditable(false);
                        vistaCRUD2.textDepartamento.setEditable(false);
                        vistaCRUD2.textProvincia.setEditable(false);
                        vistaCRUD2.textDistrito.setEditable(false);
                        vistaCRUD2.textVigenciaLicencia.setEditable(true);
                        vistaCRUD2.listaPersonaTics = vistaCRUD2.perTics.busqueda(vistaCRUD2.aux.get(i).getCodPers());
                        vistaCRUD2.listaTics = vistaCRUD2.tics.listTics();
                        if (vistaCRUD2.listaPersonaTics != null) {
                            vistaCRUD2.modelo2 = new DefaultTableModel();
                            String[] cabecera = {"Código TIC", "Nombre", "Descripción"};
                            String[][] datos = new String[vistaCRUD2.listaPersonaTics.size()][3];
                            for (int j = 0; j < vistaCRUD2.listaPersonaTics.size(); j++) {
                                datos[j][0] = String.valueOf(vistaCRUD2.listaPersonaTics.get(j).getCodTics());
                                for (int k = 0; k < vistaCRUD2.listaTics.size(); k++) {
                                    if (vistaCRUD2.listaTics.get(k).getCodTics() == vistaCRUD2.listaPersonaTics.get(j).getCodTics()) {
                                        datos[j][1] = String.valueOf(vistaCRUD2.listaTics.get(k).getDesTics());
                                    }
                                }
                                datos[j][2] = String.valueOf(vistaCRUD2.listaPersonaTics.get(j).getDesMedio());
                            }
                            vistaCRUD2.modelo2 = new DefaultTableModel(datos, cabecera);
                            vistaCRUD2.tablaPersonaTics.setModel(vistaCRUD2.modelo2);
                        }
                    }
                }
            }
        }
        if (e.getSource() == vistaCRUD2.btnGuardarCambios) {
            int CodPers = vistaCRUD2.codPersona;
            String TipPersona = String.valueOf(vistaCRUD2.comboTipoDePersona.getSelectedIndex());
            String DesPersona = vistaCRUD2.textAreaDescripcion.getText().trim();
            String DesCorta = vistaCRUD2.textAreaDescripcion2.getText().trim();
            String Direcc = vistaCRUD2.textDireccion.getText().trim();
            String Hobby = vistaCRUD2.textAreaHobby.getText().trim();
            FileInputStream archivo = vistaCRUD2.archivo;
            Blob foto = vistaCRUD2.foto;
            int longitudBytes = vistaCRUD2.longitudBytes;
            String FecNac = vistaCRUD2.devolverFecha(vistaCRUD2.dateFecNacimiento);
            String CodDpto = modeloCRUD.Departamento(vistaCRUD2.textDepartamento.getText());
            String CodProv = modeloCRUD.Provincia(CodDpto, vistaCRUD2.textProvincia.getText());
            String CodDist = modeloCRUD.Distrito(CodDpto, CodProv, vistaCRUD2.textDistrito.getText().trim());
            String DNI = vistaCRUD2.textDNI.getText().trim();
            String NroCIP = vistaCRUD2.textNroCIP.getText().trim();
            String FecCIPVig = vistaCRUD2.devolverFecha(vistaCRUD2.dateFechaVigente);
            int CentroTrabajo = 0;
            if(vistaCRUD2.comboTipoDePersona.getSelectedIndex()==0 && vistaCRUD2.comboTipoDePersona.isEnabled()){
                CentroTrabajo = modeloCRUD.codPersonaJuridica(vistaCRUD2.textCentroTrabajo.getText().trim());
            }
            String Cargo;
            if(vistaCRUD2.comboTipoDePersona.getSelectedIndex()==1){
                Cargo="";
            }
            else{
                Cargo = vistaCRUD2.textCargo.getText().trim();
            }
            String LicCond = String.valueOf(vistaCRUD2.comboLicenciaConducir.getSelectedIndex());
            String Observac = vistaCRUD2.textAreaObservaciones.getText().trim();
            String Vigente;
            if(vistaCRUD2.comboLicenciaConducir.getSelectedIndex()==0){
                Vigente="";
            }
            else{
                Vigente = String.valueOf(vistaCRUD2.comboVigenciaLicencia.getSelectedIndex());
            }
            String rptaModificar;
            if (vistaCRUD2.archivo != null) {
                rptaModificar = modeloCRUD.modificarPersona(CodPers, TipPersona, DesPersona, DesCorta, LicCond, Vigente, CodProv, Direcc, Hobby, archivo, longitudBytes, FecNac, CodDpto, CodProv, CodDist, DNI, NroCIP, FecCIPVig, CentroTrabajo, Cargo, LicCond, Observac, Vigente);
            } else {
                rptaModificar = modeloCRUD.modificarPersona(CodPers, TipPersona, DesPersona, DesCorta, LicCond, Vigente, CodProv, Direcc, Hobby, foto, FecNac, CodDpto, CodProv, CodDist, DNI, NroCIP, FecCIPVig, CentroTrabajo, Cargo, LicCond, Observac, Vigente);
            }
            if (rptaModificar != null) {
                JOptionPane.showMessageDialog(null, rptaModificar);
            } else {
                JOptionPane.showMessageDialog(null, "Modificación erronea. ");
            }
        }
        if (e.getSource() == vistaCRUD3.btnVisualizarPersona) {
            vistaCRUD3.aux = modeloCRUD.listPersona();
            vistaCRUD3.modelo1 = new DefaultTableModel();
            String[] cabecera = {"Código", "DNI", "Fecha de nacimiento"};
            String[][] datos = new String[vistaCRUD3.aux.size()][3];
            for (int i = 0; i < vistaCRUD3.aux.size(); i++) {
                datos[i][0] = String.valueOf(vistaCRUD3.aux.get(i).getCodPers());
                datos[i][1] = String.valueOf(vistaCRUD3.aux.get(i).getDNI());
                datos[i][2] = String.valueOf(vistaCRUD3.aux.get(i).getFecNac());
            }
            vistaCRUD3.modelo1 = new DefaultTableModel(datos, cabecera);
            vistaCRUD3.tablaPersona.setModel(vistaCRUD3.modelo1);
        }
        if (e.getSource() == vistaCRUD3.btnBusquedaPersona || e.getSource() == vistaCRUD3.textBusqueda) {
            vistaCRUD3.aux = modeloCRUD.listPersona();
            for (int i = 0; i < vistaCRUD3.aux.size(); i++) {
                if (vistaCRUD3.radioPorCodigo.isSelected()) {
                    if (String.valueOf(vistaCRUD3.aux.get(i).getDNI()).toUpperCase().equals(vistaCRUD3.textBusqueda.getText().toUpperCase())) {
                        ImageIcon promo = new ImageIcon(vistaCRUD3.aux.get(i).getBytesLeidos());
                        ImageIcon icono = new ImageIcon(promo.getImage().getScaledInstance(vistaCRUD3.lblMostrarFoto.getWidth(), vistaCRUD3.lblMostrarFoto.getHeight(), Image.SCALE_DEFAULT));
                        vistaCRUD3.codPersona = vistaCRUD3.aux.get(i).getCodPers();
                        vistaCRUD3.lblMostrarFoto.setIcon(icono);
                        vistaCRUD3.textTipoPersona.setEditable(true);
                        vistaCRUD3.textDepartamento.setEditable(true);
                        vistaCRUD3.textProvincia.setEditable(true);
                        vistaCRUD3.textDistrito.setEditable(true);
                        vistaCRUD3.textVigenciaLicencia.setEditable(true);
                        vistaCRUD3.textAreaDescripcion.setText(vistaCRUD3.aux.get(i).getDesPersona());
                        vistaCRUD3.textAreaDescripcion2.setText(vistaCRUD3.aux.get(i).getDesCorta());
                        vistaCRUD3.textAreaHobby.setText(vistaCRUD3.aux.get(i).getHobby());
                        vistaCRUD3.textAreaObservaciones.setText(vistaCRUD3.aux.get(i).getObservac());
                        vistaCRUD3.textCargo.setText(vistaCRUD3.aux.get(i).getCargo());
                        vistaCRUD3.textCentroTrabajo.setText(modeloCRUD.descripcion(vistaCRUD3.aux.get(i).getCentroTrabajo()));
                        vistaCRUD3.textDNI.setText(vistaCRUD3.aux.get(i).getDNI());
                        vistaCRUD3.textDepartamento.setText(vistaCRUD3.dep.busquedaDepartamento(vistaCRUD3.aux.get(i).getCodDpto()));
                        vistaCRUD3.textDireccion.setText(vistaCRUD3.aux.get(i).getDirecc());
                        vistaCRUD3.textDistrito.setText(vistaCRUD3.dist.busquedaDistrito(vistaCRUD3.aux.get(i).getCodDpto(), vistaCRUD3.aux.get(i).getCodProv(), vistaCRUD3.aux.get(i).getCodDist()));
                        vistaCRUD3.textFechaVigencia.setText(vistaCRUD3.devolverFecha(vistaCRUD3.aux.get(i).getFecCIPVig()));
                        vistaCRUD3.textLicencia.setText(vistaCRUD3.aux.get(i).getLicCond());
                        if(vistaCRUD3.aux.get(i).getVigente() == null){
                            vistaCRUD3.textVigenciaLicencia.setText("");
                        }
                        else{
                            if (vistaCRUD3.aux.get(i).getVigente().equals("1")) {
                                vistaCRUD3.textVigenciaLicencia.setText("Vigente");
                            } else {
                                vistaCRUD3.textVigenciaLicencia.setText("No vigente");
                            }
                        }
                        vistaCRUD3.textFechaNacimiento.setText(vistaCRUD3.devolverFecha(vistaCRUD3.aux.get(i).getFecNac()));
                        vistaCRUD3.textNroCIP.setText(vistaCRUD3.aux.get(i).getNroCIP());
                        vistaCRUD3.textProvincia.setText(vistaCRUD3.prov.busquedaProvincia(vistaCRUD3.aux.get(i).getCodDpto(), vistaCRUD3.aux.get(i).getCodProv()));
                        if (vistaCRUD3.aux.get(i).getTipPersona().equals("1")) {
                            vistaCRUD3.textTipoPersona.setText("Jurídica");
                        } else {
                            vistaCRUD3.textTipoPersona.setText("Natural");
                        }
                        vistaCRUD3.textTipoPersona.setEditable(false);
                        vistaCRUD3.textDepartamento.setEditable(false);
                        vistaCRUD3.textProvincia.setEditable(false);
                        vistaCRUD3.textDistrito.setEditable(false);
                        vistaCRUD3.textVigenciaLicencia.setEditable(true);
                        vistaCRUD3.listaPersonaTics = vistaCRUD3.perTics.busqueda(vistaCRUD3.aux.get(i).getCodPers());
                        vistaCRUD3.listaTics = vistaCRUD3.tics.listTics();
                        if (vistaCRUD3.listaPersonaTics != null) {
                            vistaCRUD3.modelo2 = new DefaultTableModel();
                            String[] cabecera = {"Código TIC", "Nombre", "Descripción"};
                            String[][] datos = new String[vistaCRUD3.listaPersonaTics.size()][3];
                            for (int j = 0; j < vistaCRUD3.listaPersonaTics.size(); j++) {
                                datos[j][0] = String.valueOf(vistaCRUD3.listaPersonaTics.get(j).getCodTics());
                                for (int k = 0; k < vistaCRUD3.listaTics.size(); k++) {
                                    if (vistaCRUD3.listaTics.get(k).getCodTics() == vistaCRUD3.listaPersonaTics.get(j).getCodTics()) {
                                        datos[j][1] = String.valueOf(vistaCRUD3.listaTics.get(k).getDesTics());
                                    }
                                }
                                datos[j][2] = String.valueOf(vistaCRUD3.listaPersonaTics.get(j).getDesMedio());
                            }
                            vistaCRUD3.modelo2 = new DefaultTableModel(datos, cabecera);
                            vistaCRUD3.tablaPersonaTics.setModel(vistaCRUD3.modelo2);
                        }
                    }
                }
                if(vistaCRUD3.radioPorNombre.isSelected()){
                    if (vistaCRUD3.aux.get(i).getDesPersona().toUpperCase().equals(vistaCRUD3.textBusqueda.getText().toUpperCase())) {
                        ImageIcon promo = new ImageIcon(vistaCRUD3.aux.get(i).getBytesLeidos());
                        ImageIcon icono = new ImageIcon(promo.getImage().getScaledInstance(vistaCRUD3.lblMostrarFoto.getWidth(), vistaCRUD3.lblMostrarFoto.getHeight(), Image.SCALE_DEFAULT));
                        vistaCRUD3.codPersona = vistaCRUD3.aux.get(i).getCodPers();
                        vistaCRUD3.lblMostrarFoto.setIcon(icono);
                        vistaCRUD3.textTipoPersona.setEditable(true);
                        vistaCRUD3.textDepartamento.setEditable(true);
                        vistaCRUD3.textProvincia.setEditable(true);
                        vistaCRUD3.textDistrito.setEditable(true);
                        vistaCRUD3.textVigenciaLicencia.setEditable(true);
                        vistaCRUD3.textAreaDescripcion.setText(vistaCRUD3.aux.get(i).getDesPersona());
                        vistaCRUD3.textAreaDescripcion2.setText(vistaCRUD3.aux.get(i).getDesCorta());
                        vistaCRUD3.textAreaHobby.setText(vistaCRUD3.aux.get(i).getHobby());
                        vistaCRUD3.textAreaObservaciones.setText(vistaCRUD3.aux.get(i).getObservac());
                        vistaCRUD3.textCargo.setText(vistaCRUD3.aux.get(i).getCargo());
                        vistaCRUD3.textCentroTrabajo.setText(modeloCRUD.descripcion(vistaCRUD3.aux.get(i).getCentroTrabajo()));
                        vistaCRUD3.textDNI.setText(vistaCRUD3.aux.get(i).getDNI());
                        vistaCRUD3.textDepartamento.setText(vistaCRUD3.dep.busquedaDepartamento(vistaCRUD3.aux.get(i).getCodDpto()));
                        vistaCRUD3.textDireccion.setText(vistaCRUD3.aux.get(i).getDirecc());
                        vistaCRUD3.textDistrito.setText(vistaCRUD3.dist.busquedaDistrito(vistaCRUD3.aux.get(i).getCodDpto(), vistaCRUD3.aux.get(i).getCodProv(), vistaCRUD3.aux.get(i).getCodDist()));
                        vistaCRUD3.textFechaVigencia.setText(vistaCRUD3.devolverFecha(vistaCRUD3.aux.get(i).getFecCIPVig()));
                        vistaCRUD3.textLicencia.setText(vistaCRUD3.aux.get(i).getLicCond());
                        if(vistaCRUD3.aux.get(i).getVigente() == null){
                            vistaCRUD3.textVigenciaLicencia.setText("");
                        }
                        else{
                            if (vistaCRUD3.aux.get(i).getVigente().equals("1")) {
                                vistaCRUD3.textVigenciaLicencia.setText("Vigente");
                            } else {
                                vistaCRUD3.textVigenciaLicencia.setText("No vigente");
                            }
                        }
                        vistaCRUD3.textFechaNacimiento.setText(vistaCRUD3.devolverFecha(vistaCRUD3.aux.get(i).getFecNac()));
                        vistaCRUD3.textNroCIP.setText(vistaCRUD3.aux.get(i).getNroCIP());
                        vistaCRUD3.textProvincia.setText(vistaCRUD3.prov.busquedaProvincia(vistaCRUD3.aux.get(i).getCodDpto(), vistaCRUD3.aux.get(i).getCodProv()));
                        if (vistaCRUD3.aux.get(i).getTipPersona().equals("1")) {
                            vistaCRUD3.textTipoPersona.setText("Jurídica");
                        } else {
                            vistaCRUD3.textTipoPersona.setText("Natural");
                        }
                        vistaCRUD3.textTipoPersona.setEditable(false);
                        vistaCRUD3.textDepartamento.setEditable(false);
                        vistaCRUD3.textProvincia.setEditable(false);
                        vistaCRUD3.textDistrito.setEditable(false);
                        vistaCRUD3.textVigenciaLicencia.setEditable(true);
                        vistaCRUD3.listaPersonaTics = vistaCRUD3.perTics.busqueda(vistaCRUD3.aux.get(i).getCodPers());
                        vistaCRUD3.listaTics = vistaCRUD3.tics.listTics();
                        if (vistaCRUD3.listaPersonaTics != null) {
                            vistaCRUD3.modelo2 = new DefaultTableModel();
                            String[] cabecera = {"Código TIC", "Nombre", "Descripción"};
                            String[][] datos = new String[vistaCRUD3.listaPersonaTics.size()][3];
                            for (int j = 0; j < vistaCRUD3.listaPersonaTics.size(); j++) {
                                datos[j][0] = String.valueOf(vistaCRUD3.listaPersonaTics.get(j).getCodTics());
                                for (int k = 0; k < vistaCRUD3.listaTics.size(); k++) {
                                    if (vistaCRUD3.listaTics.get(k).getCodTics() == vistaCRUD3.listaPersonaTics.get(j).getCodTics()) {
                                        datos[j][1] = String.valueOf(vistaCRUD3.listaTics.get(k).getDesTics());
                                    }
                                }
                                datos[j][2] = String.valueOf(vistaCRUD3.listaPersonaTics.get(j).getDesMedio());
                            }
                            vistaCRUD3.modelo2 = new DefaultTableModel(datos, cabecera);
                            vistaCRUD3.tablaPersonaTics.setModel(vistaCRUD3.modelo2);
                        }
                    }
                }
            }
        }
        if (e.getSource() == vistaCRUD3.btnEliminar) {
            if (!vistaCRUD3.textDNI.getText().isEmpty()) {
                int codigo = vistaCRUD3.codPersona;
                String rptaEliminar = modeloCRUD.eliminarPersona(codigo);
                if (rptaEliminar != null) {
                    JOptionPane.showMessageDialog(null, rptaEliminar);
                } else {
                    JOptionPane.showMessageDialog(null, "Eliminación erronea. ");
                }
            }
        }
        if (e.getSource() == vistaCRUD4.btnVisualizarPersona) {
            vistaCRUD4.aux = modeloCRUD.listPersona();
            vistaCRUD4.modelo1 = new DefaultTableModel();
            String[] cabecera = {"Código", "DNI", "Fecha de nacimiento"};
            String[][] datos = new String[vistaCRUD4.aux.size()][3];
            for (int i = 0; i < vistaCRUD4.aux.size(); i++) {
                datos[i][0] = String.valueOf(vistaCRUD4.aux.get(i).getCodPers());
                datos[i][1] = String.valueOf(vistaCRUD4.aux.get(i).getDNI());
                datos[i][2] = String.valueOf(vistaCRUD4.aux.get(i).getFecNac());
            }
            vistaCRUD4.modelo1 = new DefaultTableModel(datos, cabecera);
            vistaCRUD4.tablaPersona.setModel(vistaCRUD4.modelo1);
        }
    }
}
