/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.Persona.vista;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import edu.unmsm.sistemas.sgpy.Persona.menuPrincipales.OpcionesFrmCliente;
import edu.unmsm.sistemas.sgpy.Persona.menuPrincipales.OpcionesFrmComunicaciones;
import edu.unmsm.sistemas.sgpy.Persona.modelo.Tics;

/**
 *
 * @author CARLOS
 */
public class JFModificarTics extends javax.swing.JFrame {

    /**
     * Creates new form JFVisualizarTics
     */
    public JFModificarTics() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        listaTics = new javax.swing.JList<>();
        btnMostrarTics = new javax.swing.JButton();
        labelBusqueda = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelIconoTics = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textCodigoTics = new javax.swing.JTextField();
        textDescripcionTics = new javax.swing.JTextField();
        textVigenciaTics = new javax.swing.JTextField();
        btnBusquedaTics = new javax.swing.JButton();
        btnGuardarTics = new javax.swing.JButton();
        radioPorNombre = new javax.swing.JRadioButton();
        radioPorCodigo = new javax.swing.JRadioButton();
        comboVigenciaTics = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tics");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listaTics.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaTicsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listaTics);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 101, 159, 320));

        btnMostrarTics.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnMostrarTics.setText("Mostrar");
        getContentPane().add(btnMostrarTics, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 452, -1, -1));

        labelBusqueda.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        labelBusqueda.setText("Código : ");
        getContentPane().add(labelBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 104, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Descripción :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 234, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Vigencia :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 293, -1, -1));
        getContentPane().add(labelIconoTics, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, 180, 180));

        jLabel5.setFont(new java.awt.Font("Dialog", 2, 24)); // NOI18N
        jLabel5.setText("Modificar Tics");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, -1, -1));
        getContentPane().add(textCodigoTics, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 210, 28));
        getContentPane().add(textDescripcionTics, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 210, 28));
        getContentPane().add(textVigenciaTics, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 100, 28));

        btnBusquedaTics.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnBusquedaTics.setText("Búsqueda");
        getContentPane().add(btnBusquedaTics, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, -1, -1));

        btnGuardarTics.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnGuardarTics.setText("<html><p>Guardar</p><p>cambios</p></html>");
        getContentPane().add(btnGuardarTics, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 350, -1, -1));

        radioPorNombre.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        radioPorNombre.setText("Por descripción");
        radioPorNombre.setOpaque(false);
        radioPorNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioPorNombreActionPerformed(evt);
            }
        });
        getContentPane().add(radioPorNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, -1, -1));

        radioPorCodigo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        radioPorCodigo.setText("Por código");
        radioPorCodigo.setOpaque(false);
        radioPorCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioPorCodigoActionPerformed(evt);
            }
        });
        getContentPane().add(radioPorCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, -1, -1));

        comboVigenciaTics.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        comboVigenciaTics.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No vigente", "Vigente" }));
        comboVigenciaTics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboVigenciaTicsActionPerformed(evt);
            }
        });
        getContentPane().add(comboVigenciaTics, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, -1, 28));

        jButton1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(678, 452, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public ArrayList<Tics>Tics;
    public DefaultListModel modelo;
    private void listaTicsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaTicsMouseClicked
        if(evt.getClickCount() == 1){
            textCodigoTics.setText(String.valueOf(Tics.get(listaTics.getSelectedIndex()).getCodTics()));
            textDescripcionTics.setText(Tics.get(listaTics.getSelectedIndex()).getDesTics());
            if(Tics.get(listaTics.getSelectedIndex()).getVigencia().equals("1")){
                textVigenciaTics.setText("Vigente");
            }
            else{
                textVigenciaTics.setText("No vigente");
            }
            ImageIcon promo = new ImageIcon(Tics.get(listaTics.getSelectedIndex()).getBytesLeidos());
            ImageIcon icono = new ImageIcon(promo.getImage().getScaledInstance(labelIconoTics.getWidth(), labelIconoTics.getHeight(), Image.SCALE_DEFAULT));
            labelIconoTics.setIcon(icono);
            posicion = listaTics.getSelectedIndex();
        }
    }//GEN-LAST:event_listaTicsMouseClicked

    private void comboVigenciaTicsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboVigenciaTicsActionPerformed
        textVigenciaTics.setEditable(true);
        if(comboVigenciaTics.getSelectedIndex()==0){
            textVigenciaTics.setText("No vigente");
        }
        else{
            textVigenciaTics.setText("Vigente");
        }
        textVigenciaTics.setEditable(false);
    }//GEN-LAST:event_comboVigenciaTicsActionPerformed
    public int posicion=-1;
    private void radioPorNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPorNombreActionPerformed
        if(radioPorNombre.isSelected()){
            radioPorCodigo.setSelected(false);
            labelBusqueda.setText("Nombre:");
        }
    }//GEN-LAST:event_radioPorNombreActionPerformed

    private void radioPorCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPorCodigoActionPerformed
        if(radioPorCodigo.isSelected()){
            radioPorNombre.setSelected(false);
            labelBusqueda.setText("Código:");
        }
    }//GEN-LAST:event_radioPorCodigoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        OpcionesFrmComunicaciones frame = new OpcionesFrmComunicaciones();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFModificarTics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFModificarTics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFModificarTics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFModificarTics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFModificarTics().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBusquedaTics;
    public javax.swing.JButton btnGuardarTics;
    public javax.swing.JButton btnMostrarTics;
    public javax.swing.JComboBox<String> comboVigenciaTics;
    public javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelBusqueda;
    public javax.swing.JLabel labelIconoTics;
    public javax.swing.JList<String> listaTics;
    public javax.swing.JRadioButton radioPorCodigo;
    public javax.swing.JRadioButton radioPorNombre;
    public javax.swing.JTextField textCodigoTics;
    public javax.swing.JTextField textDescripcionTics;
    public javax.swing.JTextField textVigenciaTics;
    // End of variables declaration//GEN-END:variables
}
