/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.Hitos.Views;

import edu.unmsm.sistemas.sgpy.Hitos.Controllers.HitosDaoImpl;
import edu.unmsm.sistemas.sgpy.Hitos.Models.HitosAlerta;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Axel
 */
public class VerAlertasF extends javax.swing.JFrame {
    
    DefaultTableModel modelo;
    String cabecera[]={"CodProyecto","CodCorreo","CodTICs","Fecha","Estado_Alerta"};
    String datos[][]={};
    HitosDaoImpl hai;
    public VerAlertasF() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        hai=HitosDaoImpl.getInstance();
        modelo=new DefaultTableModel(datos,cabecera);
        table.setModel(modelo);
        
        
        
    }

    public void MostrarDatosTabla(ArrayList<HitosAlerta> ha){
            int dim=ha.size();
            Object dat[][]=new Object[dim][5];
            for (int i = 0; i < dim; i++) {
                HitosAlerta hitos=ha.get(i);
                Object o[]={hitos.getCodPyto(),hitos.getCorrHitos(),hitos.getCodTICs(),hitos.getFecAlerta(),hitos.getAlertaOn()};
                System.arraycopy(o, 0, dat[i], 0, o.length);    
            }
          if(ha.isEmpty()){
              JOptionPane.showMessageDialog(null, "No existen Alertas para este codigo");
              modelo.setDataVector(dat, cabecera);
          }
          else{
             modelo.setDataVector(dat, cabecera); 
          }
          ajustar();
    }
    
    public ArrayList<HitosAlerta> ListaAlertas(){
       
        ArrayList<HitosAlerta> alertas=null;
        hai = HitosDaoImpl.getInstance();
        if(cod_pyto.getText().isEmpty()){
            alertas=hai.getAlertasHitos();
        }
        else{
            alertas=hai.obtenerAlertasHito(Integer.parseInt(cod_pyto.getText()));
        }
        return alertas;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cod_pyto = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("ALERTAS");

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Codigo Proyecto: ");

        jButton2.setBackground(new java.awt.Color(0, 0, 255));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Ver Alertas");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Actualizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Eliminar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hitos/Imagenes/rotacion.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(121, 121, 121)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4)
                                .addGap(12, 12, 12)))
                        .addContainerGap(53, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cod_pyto, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))))
            .addGroup(layout.createSequentialGroup()
                .addGap(259, 259, 259)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cod_pyto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         MenuF menu=new MenuF();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        MostrarDatosTabla(ListaAlertas());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(table.getSelectedRow()==-1 || table.getSelectedColumn()==-1){
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna alerta");
        } 
        else{
            Object o=table.getValueAt(table.getSelectedRow(), table.getSelectedColumn());
            ArrayList<HitosAlerta> ha=hai.obtenerAlertasHito(Integer.parseInt(o.toString()));
            if(ha.size()>0){
                new UpdateAlerta(ha.get(0)).setVisible(true);
            }else{
                JOptionPane.showMessageDialog(this,"Error","ALERTA NO ENCONTRADA",JOptionPane.ERROR_MESSAGE);
            } 
         }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(table.getSelectedRow()==-1 || table.getSelectedColumn()==-1){
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna alerta");
        } 
        else{
            Object o=table.getValueAt(table.getSelectedRow(), table.getSelectedColumn());
            ArrayList<HitosAlerta> ha=hai.obtenerAlertasHito(Integer.parseInt(o.toString()));
            if(ha.size()>0){
                HitosAlerta alerta=ha.get(0);
                int respuesta=JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar la Alerta?");
                if(respuesta==0){
                  hai.EliminarAlertaHito(alerta.getCodPyto());
                  JOptionPane.showMessageDialog(null, "Alerta Elminada");
               }
            }else{
                JOptionPane.showMessageDialog(this,"El producto no existe","ALERTA NO ENCONTRADA",JOptionPane.ERROR_MESSAGE);
            } 
         }
       MostrarDatosTabla(ListaAlertas());
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        MostrarDatosTabla(ListaAlertas());
    }//GEN-LAST:event_jButton5ActionPerformed
    public void ajustar(){
            TableColumnModel columnModel = table.getColumnModel();
            columnModel.getColumn(3).setPreferredWidth(150);
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cod_pyto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
