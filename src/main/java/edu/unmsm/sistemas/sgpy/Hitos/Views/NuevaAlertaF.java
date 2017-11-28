/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.Hitos.Views;

import edu.unmsm.sistemas.sgpy.Hitos.Controllers.HitosDaoImpl;
import edu.unmsm.sistemas.sgpy.Hitos.Models.HitosAlerta;
import edu.unmsm.sistemas.sgpy.Hitos.Service.EmailServiceObserver;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Axel
 */
public class NuevaAlertaF extends javax.swing.JFrame {

    HitosDaoImpl hdi;
    public NuevaAlertaF() throws ClassNotFoundException {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        hdi=HitosDaoImpl.getInstance();
        SimpleDateFormat sm = new SimpleDateFormat("dd/MM/yyyy");
        Date dt = new Date();
        String hoy=sm.format(dt);
        txt_fecha.setText(hoy);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_cp = new javax.swing.JTextField();
        txt_cc = new javax.swing.JTextField();
        txt_tic = new javax.swing.JTextField();
        txt_fecha = new javax.swing.JTextField();
        check_estado = new javax.swing.JCheckBox();
        save = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Nueva Alerta");

        jLabel2.setText("Codigo Proyecto");

        jLabel3.setText("Codigo Correo");

        jLabel4.setText("Codigo TIC");

        jLabel5.setText("Fecha Actual");

        txt_fecha.setEditable(false);

        check_estado.setText("Encender Alerta");

        save.setText("Guardar Alerta");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_cp, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(txt_cc)
                            .addComponent(txt_tic)
                            .addComponent(txt_fecha)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(check_estado)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_cp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_cc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_tic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(check_estado)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(jButton1))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        if(validarForm()){
            int text_cp=Integer.parseInt(txt_cp.getText());
            int text_cc=Integer.parseInt(txt_cc.getText());
            int text_tic=Integer.parseInt(txt_tic.getText());
            String fecha=txt_fecha.getText();
            String estado;
            if(check_estado.isSelected()){
                estado="E";
            }
            else{
                estado="A";
            }
            HitosAlerta ha=new HitosAlerta(text_cp, text_cc, text_tic, fecha, estado);
            hdi.AgregarNuevaAlertaHito(ha);
            JOptionPane.showMessageDialog(null, "Alerta Guardada");
            EmailServiceObserver emailServiceObserver=EmailServiceObserver.getInstance();
            emailServiceObserver.ActivarAlerta();
            emailServiceObserver.execute();
            limpiar();
        }
        else{
           JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios"); 
        }
    }//GEN-LAST:event_saveActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MenuF menu=new MenuF();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    private boolean validarForm(){
        return !"".equals(txt_cp.getText()) && !"".equals(txt_cc.getText()) && !"".equals(txt_tic.getText()) && !"".equals(txt_fecha.getText());
    }
    
    private void limpiar(){
        txt_cp.setText("");
        txt_cc.setText("");
        txt_tic.setText("");
        txt_fecha.setText("");
        check_estado.setSelected(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox check_estado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton save;
    private javax.swing.JTextField txt_cc;
    private javax.swing.JTextField txt_cp;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_tic;
    // End of variables declaration//GEN-END:variables
}
