/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.Persona.controlador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import edu.unmsm.sistemas.sgpy.Persona.vista.*;
import edu.unmsm.sistemas.sgpy.Persona.modelo.*;
/**
 *
 * @author CARLOS
 */
public class ControladorCrudCliente implements ActionListener{
    JFAgregarCliente vistaCRUD1 = new JFAgregarCliente();
    JFModificarCliente vistaCRUD2 = new JFModificarCliente();
    JFEliminarCliente vistaCRUD3 = new JFEliminarCliente();
    JFVisualizarCliente vistaCRUD4 = new JFVisualizarCliente();
    ClienteDAO modeloCRUD =new ClienteDAO();

    public ControladorCrudCliente(JFAgregarCliente vistaCRUD1 , ClienteDAO modeloCRUD) {
        this.modeloCRUD = modeloCRUD;
        this.vistaCRUD1 = vistaCRUD1;
        this.vistaCRUD1.btnRegistrarCliente.addActionListener(this);
    }
    
    public ControladorCrudCliente(JFModificarCliente vistaCRUD2 , ClienteDAO modeloCRUD) {
        this.modeloCRUD = modeloCRUD;
        this.vistaCRUD2 = vistaCRUD2;
        this.vistaCRUD2.textBusqueda.addActionListener(this);
        this.vistaCRUD2.btnBusquedaCliente.addActionListener(this);
        this.vistaCRUD2.btnVisualizarCliente.addActionListener(this);
        this.vistaCRUD2.btnGuardarCambio.addActionListener(this);
    }
    
    public ControladorCrudCliente(JFEliminarCliente vistaCRUD3 , ClienteDAO modeloCRUD) {
        this.modeloCRUD = modeloCRUD;
        this.vistaCRUD3 = vistaCRUD3;
        this.vistaCRUD3.textBusqueda.addActionListener(this);
        this.vistaCRUD3.btnBusquedaCliente.addActionListener(this);
        this.vistaCRUD3.btnVisualizarCliente.addActionListener(this);
        this.vistaCRUD3.btnEliminarCliente.addActionListener(this);
    }
    
    public ControladorCrudCliente(JFVisualizarCliente vistaCRUD4 , ClienteDAO modeloCRUD) {
        this.modeloCRUD = modeloCRUD;
        this.vistaCRUD4 = vistaCRUD4;
        this.vistaCRUD4.textBusqueda.addActionListener(this);
        this.vistaCRUD4.btnBusquedaCliente.addActionListener(this);
        this.vistaCRUD4.btnVisualizarCliente.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vistaCRUD1.btnRegistrarCliente){
            
            String descripDes = vistaCRUD1.txtAreaDescripPliego.getText().trim();
            String RUC = vistaCRUD1.txtRuc.getText().trim();
            int GerGener = vistaCRUD1.per.codPersona2(String.valueOf(vistaCRUD1.comboGerenteGeneral.getSelectedItem()));
            System.out.println(String.valueOf(vistaCRUD1.comboGerenteGeneral.getSelectedItem()));
            System.out.println(GerGener);
            int GerInfraest = vistaCRUD1.per.codPersona2(String.valueOf(vistaCRUD1.comboGerenteInfraestructura.getSelectedItem()));
            vistaCRUD1.codigo=new PersonaDAO().codPersona2(vistaCRUD1.comboCliente.getSelectedItem().toString());
            String respuesta = modeloCRUD.insertarCliente(vistaCRUD1.codigo, vistaCRUD1.corEmp, descripDes, RUC, GerGener, GerInfraest);
            if (respuesta != null) {
                JOptionPane.showMessageDialog(null, respuesta);
            } else {
                JOptionPane.showMessageDialog(null, "Registro erroneo. ");
            }
        }
        if(e.getSource() == vistaCRUD2.btnVisualizarCliente){
            vistaCRUD2.listaCliente = modeloCRUD.listCliente();
            vistaCRUD2.modelo1 = new DefaultTableModel();
            String[] cabecera = {"Código", "RUC", "Fecha de nacimiento"};
            String[][] datos = new String[vistaCRUD2.listaCliente.size()][3];
            for (int i = 0; i < vistaCRUD2.listaCliente.size(); i++) {
                datos[i][0] = String.valueOf(vistaCRUD2.listaCliente.get(i).getCodCli());
                datos[i][1] = String.valueOf(vistaCRUD2.listaCliente.get(i).getNroRuc());
                datos[i][2] = String.valueOf(vistaCRUD2.listaCliente.get(i).getFecNac());
            }
            vistaCRUD2.modelo1 = new DefaultTableModel(datos, cabecera);
            vistaCRUD2.tablaCliente.setModel(vistaCRUD2.modelo1);        
        }
        if(e.getSource() == vistaCRUD2.btnBusquedaCliente || e.getSource()==vistaCRUD2.textBusqueda){
            vistaCRUD2.listaCliente = modeloCRUD.listCliente();
            for (int i = 0; i < vistaCRUD2.listaCliente.size(); i++) {
                if(vistaCRUD2.radioPorCodigo.isSelected()){
                    if(vistaCRUD2.listaCliente.get(i).getNroRuc().toUpperCase().equals(vistaCRUD2.textBusqueda.getText().toUpperCase())){
                        ImageIcon promo = new ImageIcon(vistaCRUD2.listaCliente.get(i).getBytesLeidos());
                        ImageIcon icono = new ImageIcon(promo.getImage().getScaledInstance(vistaCRUD2.labelFotoCliente.getWidth(), vistaCRUD2.labelFotoCliente.getHeight(), Image.SCALE_DEFAULT));
                        vistaCRUD2.labelFotoCliente.setIcon(icono);
                        vistaCRUD2.codCliente = vistaCRUD2.listaCliente.get(i).getCodCli();
                        vistaCRUD2.corEmp = vistaCRUD2.listaCliente.get(i).getCorEmp();
                        vistaCRUD2.textAreaDescripPliego.setText(vistaCRUD2.listaCliente.get(i).getDesPliego());
                        vistaCRUD2.textRuc.setText(vistaCRUD2.listaCliente.get(i).getNroRuc());
                        vistaCRUD2.textGerGener.setText(vistaCRUD2.per.descripcion2(vistaCRUD2.listaCliente.get(i).getGerGener()));
                        vistaCRUD2.textGerInfraet.setText(vistaCRUD2.per.descripcion2(vistaCRUD2.listaCliente.get(i).getGerInfraest()));
                        vistaCRUD2.listaPersonaTics = vistaCRUD2.perTics.listPersonaTics();
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
                            vistaCRUD2.tablaClienteTics.setModel(vistaCRUD2.modelo2);
                        }
                    }
                }
                if(vistaCRUD2.radioPorNombre.isSelected()){
                    if(vistaCRUD2.listaCliente.get(i).getDesPersona().toUpperCase().equals(vistaCRUD2.textBusqueda.getText().toUpperCase())){
                        ImageIcon promo = new ImageIcon(vistaCRUD2.listaCliente.get(i).getBytesLeidos());
                        ImageIcon icono = new ImageIcon(promo.getImage().getScaledInstance(vistaCRUD2.labelFotoCliente.getWidth(), vistaCRUD2.labelFotoCliente.getHeight(), Image.SCALE_DEFAULT));
                        vistaCRUD2.labelFotoCliente.setIcon(icono);
                        vistaCRUD2.codCliente = vistaCRUD2.listaCliente.get(i).getCodCli();
                        vistaCRUD2.corEmp = vistaCRUD2.listaCliente.get(i).getCorEmp();
                        vistaCRUD2.textAreaDescripPliego.setText(vistaCRUD2.listaCliente.get(i).getDesPliego());
                        vistaCRUD2.textRuc.setText(vistaCRUD2.listaCliente.get(i).getNroRuc());
                        vistaCRUD2.textGerGener.setText(vistaCRUD2.per.descripcion2(vistaCRUD2.listaCliente.get(i).getGerGener()));
                        vistaCRUD2.textGerInfraet.setText(vistaCRUD2.per.descripcion2(vistaCRUD2.listaCliente.get(i).getGerInfraest()));
                        vistaCRUD2.listaPersonaTics = vistaCRUD2.perTics.listPersonaTics();
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
                            vistaCRUD2.tablaClienteTics.setModel(vistaCRUD2.modelo2);
                        }
                    }
                }
            }
        }
        if(e.getSource() == vistaCRUD2.btnGuardarCambio){
            try{
                if(!vistaCRUD2.textAreaDescripPliego.getText().isEmpty() && !vistaCRUD2.textRuc.getText().isEmpty() && !vistaCRUD2.textGerGener.getText().isEmpty() && !vistaCRUD2.textGerInfraet.getText().isEmpty()){
                    int codCliente = vistaCRUD2.codCliente;
                    int corEmp = vistaCRUD2.corEmp;
                    String desPliego = vistaCRUD2.textAreaDescripPliego.getText();
                    String nroRUC = vistaCRUD2.textRuc.getText();
                    int gerenteGeneral = vistaCRUD2.per.codPersona2(vistaCRUD2.textGerGener.getText());
                    int gerenteInfraestructura = vistaCRUD2.per.codPersona2(vistaCRUD2.textGerInfraet.getText());
                    String rptaModificar = modeloCRUD.modificarCliente(codCliente, corEmp, desPliego, nroRUC, gerenteGeneral, gerenteInfraestructura);
                    if (rptaModificar != null) {
                        JOptionPane.showMessageDialog(null, rptaModificar);
                    } else {
                        JOptionPane.showMessageDialog(null, "Modificación erronea. ");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Falta llenar algún campo. ");
                }
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Datos mal ingresados.");
            }
        }
        if(e.getSource() == vistaCRUD3.btnVisualizarCliente){
            vistaCRUD3.listaCliente = modeloCRUD.listCliente();
            vistaCRUD3.modelo1 = new DefaultTableModel();
            String[] cabecera = {"Código", "RUC", "Fecha de nacimiento"};
            String[][] datos = new String[vistaCRUD3.listaCliente.size()][3];
            for (int i = 0; i < vistaCRUD3.listaCliente.size(); i++) {
                datos[i][0] = String.valueOf(vistaCRUD3.listaCliente.get(i).getCodCli());
                datos[i][1] = String.valueOf(vistaCRUD3.listaCliente.get(i).getNroRuc());
                datos[i][2] = String.valueOf(vistaCRUD3.listaCliente.get(i).getFecNac());
            }
            vistaCRUD3.modelo1 = new DefaultTableModel(datos, cabecera);
            vistaCRUD3.tablaCliente.setModel(vistaCRUD3.modelo1);        
        }
        if(e.getSource() == vistaCRUD3.btnBusquedaCliente || e.getSource()==vistaCRUD3.textBusqueda){
            vistaCRUD3.listaCliente = modeloCRUD.listCliente();
            for (int i = 0; i < vistaCRUD3.listaCliente.size(); i++) {
                if(vistaCRUD3.radioPorCodigo.isSelected()){
                    if(vistaCRUD3.listaCliente.get(i).getNroRuc().toUpperCase().equals(vistaCRUD3.textBusqueda.getText().toUpperCase())){
                        ImageIcon promo = new ImageIcon(vistaCRUD3.listaCliente.get(i).getBytesLeidos());
                        ImageIcon icono = new ImageIcon(promo.getImage().getScaledInstance(vistaCRUD3.labelFotoCliente.getWidth(), vistaCRUD3.labelFotoCliente.getHeight(), Image.SCALE_DEFAULT));
                        vistaCRUD3.labelFotoCliente.setIcon(icono);
                        vistaCRUD3.codCliente = vistaCRUD3.listaCliente.get(i).getCodCli();
                        vistaCRUD3.corEmp = vistaCRUD3.listaCliente.get(i).getCorEmp();
                        vistaCRUD3.textAreaDescripPliego.setEditable(true);
                        vistaCRUD3.textRuc.setEditable(true);
                        vistaCRUD3.textGerGener.setEditable(true);
                        vistaCRUD3.textGerInfraet.setEditable(true);
                        vistaCRUD3.textAreaDescripPliego.setText(vistaCRUD3.listaCliente.get(i).getDesPliego());
                        vistaCRUD3.textRuc.setText(vistaCRUD3.listaCliente.get(i).getNroRuc());
                        vistaCRUD3.textGerGener.setText(vistaCRUD3.per.descripcion2(vistaCRUD3.listaCliente.get(i).getGerGener()));
                        vistaCRUD3.textGerInfraet.setText(vistaCRUD3.per.descripcion2(vistaCRUD3.listaCliente.get(i).getGerInfraest()));
                        vistaCRUD3.textAreaDescripPliego.setEditable(false);
                        vistaCRUD3.textRuc.setEditable(false);
                        vistaCRUD3.textGerGener.setEditable(false);
                        vistaCRUD3.textGerInfraet.setEditable(false);
                        vistaCRUD3.listaPersonaTics = vistaCRUD3.perTics.listPersonaTics();
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
                            vistaCRUD3.tablaClienteTics.setModel(vistaCRUD3.modelo2);
                        }
                    }
                }
                if(vistaCRUD3.radioPorNombre.isSelected()){
                    if(vistaCRUD3.listaCliente.get(i).getDesPersona().toUpperCase().equals(vistaCRUD3.textBusqueda.getText().toUpperCase())){
                        ImageIcon promo = new ImageIcon(vistaCRUD3.listaCliente.get(i).getBytesLeidos());
                        ImageIcon icono = new ImageIcon(promo.getImage().getScaledInstance(vistaCRUD3.labelFotoCliente.getWidth(), vistaCRUD3.labelFotoCliente.getHeight(), Image.SCALE_DEFAULT));
                        vistaCRUD3.labelFotoCliente.setIcon(icono);
                        vistaCRUD3.codCliente = vistaCRUD3.listaCliente.get(i).getCodCli();
                        vistaCRUD3.corEmp = vistaCRUD3.listaCliente.get(i).getCorEmp();
                        vistaCRUD3.textAreaDescripPliego.setEditable(true);
                        vistaCRUD3.textRuc.setEditable(true);
                        vistaCRUD3.textGerGener.setEditable(true);
                        vistaCRUD3.textGerInfraet.setEditable(true);
                        vistaCRUD3.textAreaDescripPliego.setText(vistaCRUD3.listaCliente.get(i).getDesPliego());
                        vistaCRUD3.textRuc.setText(vistaCRUD3.listaCliente.get(i).getNroRuc());
                        vistaCRUD3.textGerGener.setText(vistaCRUD3.per.descripcion2(vistaCRUD3.listaCliente.get(i).getGerGener()));
                        vistaCRUD3.textGerInfraet.setText(vistaCRUD3.per.descripcion2(vistaCRUD3.listaCliente.get(i).getGerInfraest()));
                        vistaCRUD3.textAreaDescripPliego.setEditable(false);
                        vistaCRUD3.textRuc.setEditable(false);
                        vistaCRUD3.textGerGener.setEditable(false);
                        vistaCRUD3.textGerInfraet.setEditable(false);
                        vistaCRUD3.listaPersonaTics = vistaCRUD3.perTics.listPersonaTics();
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
                            vistaCRUD3.tablaClienteTics.setModel(vistaCRUD3.modelo2);
                        }
                    }
                }
            }
        }
        if(e.getSource() == vistaCRUD3.btnEliminarCliente){
            if(vistaCRUD3.codCliente!=-1){
                int codigo = vistaCRUD3.codCliente;
                String rptaEliminar = modeloCRUD.eliminarCliente(codigo);
                if (rptaEliminar != null) {
                    JOptionPane.showMessageDialog(null, rptaEliminar);
                } else {
                    JOptionPane.showMessageDialog(null, "Eliminación erronea. ");
                }
            }
        }
        if(e.getSource() == vistaCRUD4.btnVisualizarCliente){
            vistaCRUD4.listaCliente = modeloCRUD.listCliente();
            vistaCRUD4.modelo1 = new DefaultTableModel();
            String[] cabecera = {"Código", "RUC", "Fecha de nacimiento"};
            String[][] datos = new String[vistaCRUD4.listaCliente.size()][3];
            for (int i = 0; i < vistaCRUD4.listaCliente.size(); i++) {
                datos[i][0] = String.valueOf(vistaCRUD4.listaCliente.get(i).getCodCli());
                datos[i][1] = String.valueOf(vistaCRUD4.listaCliente.get(i).getNroRuc());
                datos[i][2] = String.valueOf(vistaCRUD4.listaCliente.get(i).getFecNac());
            }
            vistaCRUD4.modelo1 = new DefaultTableModel(datos, cabecera);
            vistaCRUD4.tablaCliente.setModel(vistaCRUD4.modelo1);        
        }
        if(e.getSource() == vistaCRUD4.btnBusquedaCliente || e.getSource()==vistaCRUD4.textBusqueda){
            vistaCRUD4.listaCliente = modeloCRUD.listCliente();
            for (int i = 0; i < vistaCRUD4.listaCliente.size(); i++) {
                if(vistaCRUD4.radioPorCodigo.isSelected()){
                    if(vistaCRUD4.listaCliente.get(i).getNroRuc().toUpperCase().equals(vistaCRUD4.textBusqueda.getText().toUpperCase())){
                        ImageIcon promo = new ImageIcon(vistaCRUD4.listaCliente.get(i).getBytesLeidos());
                        ImageIcon icono = new ImageIcon(promo.getImage().getScaledInstance(vistaCRUD4.labelFotoCliente.getWidth(), vistaCRUD4.labelFotoCliente.getHeight(), Image.SCALE_DEFAULT));
                        vistaCRUD4.labelFotoCliente.setIcon(icono);
                        vistaCRUD4.textAreaDescripPliego.setEditable(true);
                        vistaCRUD4.textRuc.setEditable(true);
                        vistaCRUD4.textGerGener.setEditable(true);
                        vistaCRUD4.textGerInfraet.setEditable(true);
                        vistaCRUD4.textAreaDescripPliego.setText(vistaCRUD4.listaCliente.get(i).getDesPliego());
                        vistaCRUD4.textRuc.setText(vistaCRUD4.listaCliente.get(i).getNroRuc());
                        vistaCRUD4.textGerGener.setText(vistaCRUD4.per.descripcion2(vistaCRUD4.listaCliente.get(i).getGerGener()));
                        vistaCRUD4.textGerInfraet.setText(vistaCRUD4.per.descripcion2(vistaCRUD4.listaCliente.get(i).getGerInfraest()));
                        vistaCRUD4.textAreaDescripPliego.setEditable(false);
                        vistaCRUD4.textRuc.setEditable(false);
                        vistaCRUD4.textGerGener.setEditable(false);
                        vistaCRUD4.textGerInfraet.setEditable(false);
                        vistaCRUD4.listaPersonaTics = vistaCRUD4.perTics.listPersonaTics();
                        vistaCRUD4.listaTics = vistaCRUD4.tics.listTics();
                        if (vistaCRUD4.listaPersonaTics != null) {
                            vistaCRUD4.modelo2 = new DefaultTableModel();
                            String[] cabecera = {"Código TIC", "Nombre", "Descripción"};
                            String[][] datos = new String[vistaCRUD4.listaPersonaTics.size()][3];
                            for (int j = 0; j < vistaCRUD4.listaPersonaTics.size(); j++) {
                                datos[j][0] = String.valueOf(vistaCRUD4.listaPersonaTics.get(j).getCodTics());
                                for (int k = 0; k < vistaCRUD4.listaTics.size(); k++) {
                                    if (vistaCRUD4.listaTics.get(k).getCodTics() == vistaCRUD4.listaPersonaTics.get(j).getCodTics()) {
                                        datos[j][1] = String.valueOf(vistaCRUD4.listaTics.get(k).getDesTics());
                                    }
                                }
                                datos[j][2] = String.valueOf(vistaCRUD4.listaPersonaTics.get(j).getDesMedio());
                            }
                            vistaCRUD4.modelo2 = new DefaultTableModel(datos, cabecera);
                            vistaCRUD4.tablaClienteTics.setModel(vistaCRUD4.modelo2);
                        }
                    }
                }
                if(vistaCRUD4.radioPorNombre.isSelected()){
                    if(vistaCRUD4.listaCliente.get(i).getDesPersona().toUpperCase().equals(vistaCRUD4.textBusqueda.getText().toUpperCase())){
                        ImageIcon promo = new ImageIcon(vistaCRUD4.listaCliente.get(i).getBytesLeidos());
                        ImageIcon icono = new ImageIcon(promo.getImage().getScaledInstance(vistaCRUD4.labelFotoCliente.getWidth(), vistaCRUD4.labelFotoCliente.getHeight(), Image.SCALE_DEFAULT));
                        vistaCRUD4.labelFotoCliente.setIcon(icono);
                        vistaCRUD4.textAreaDescripPliego.setEditable(true);
                        vistaCRUD4.textRuc.setEditable(true);
                        vistaCRUD4.textGerGener.setEditable(true);
                        vistaCRUD4.textGerInfraet.setEditable(true);
                        vistaCRUD4.textAreaDescripPliego.setText(vistaCRUD4.listaCliente.get(i).getDesPliego());
                        vistaCRUD4.textRuc.setText(vistaCRUD4.listaCliente.get(i).getNroRuc());
                        vistaCRUD4.textGerGener.setText(vistaCRUD4.per.descripcion2(vistaCRUD4.listaCliente.get(i).getGerGener()));
                        vistaCRUD4.textGerInfraet.setText(vistaCRUD4.per.descripcion2(vistaCRUD4.listaCliente.get(i).getGerInfraest()));
                        vistaCRUD4.textAreaDescripPliego.setEditable(false);
                        vistaCRUD4.textRuc.setEditable(false);
                        vistaCRUD4.textGerGener.setEditable(false);
                        vistaCRUD4.textGerInfraet.setEditable(false);
                        vistaCRUD4.listaPersonaTics = vistaCRUD4.perTics.listPersonaTics();
                        vistaCRUD4.listaTics = vistaCRUD4.tics.listTics();
                        if (vistaCRUD4.listaPersonaTics != null) {
                            vistaCRUD4.modelo2 = new DefaultTableModel();
                            String[] cabecera = {"Código TIC", "Nombre", "Descripción"};
                            String[][] datos = new String[vistaCRUD4.listaPersonaTics.size()][3];
                            for (int j = 0; j < vistaCRUD4.listaPersonaTics.size(); j++) {
                                datos[j][0] = String.valueOf(vistaCRUD4.listaPersonaTics.get(j).getCodTics());
                                for (int k = 0; k < vistaCRUD4.listaTics.size(); k++) {
                                    if (vistaCRUD4.listaTics.get(k).getCodTics() == vistaCRUD4.listaPersonaTics.get(j).getCodTics()) {
                                        datos[j][1] = String.valueOf(vistaCRUD4.listaTics.get(k).getDesTics());
                                    }
                                }
                                datos[j][2] = String.valueOf(vistaCRUD4.listaPersonaTics.get(j).getDesMedio());
                            }
                            vistaCRUD4.modelo2 = new DefaultTableModel(datos, cabecera);
                            vistaCRUD4.tablaClienteTics.setModel(vistaCRUD4.modelo2);
                        }
                    }
                }
            }
        }
    }
}
