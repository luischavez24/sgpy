/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.Persona.vista;

import java.util.ArrayList;
import edu.unmsm.sistemas.sgpy.Persona.menuPrincipales.OpcionesFrmPersona;
import edu.unmsm.sistemas.sgpy.Persona.modelo.Persona;
import edu.unmsm.sistemas.sgpy.Persona.modelo.PersonaDAO;
import edu.unmsm.sistemas.sgpy.Persona.modelo.Tics;

/**
 *
 * @author Halion
 */
public class JFAgregarCliente extends javax.swing.JFrame {

    /**
     * Creates new form JFInsertarCliente
     */
    public JFAgregarCliente() {
        initComponents();
        inicializarCombos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblGerInfraest = new javax.swing.JLabel();
        lblDescrpPliego = new javax.swing.JLabel();
        lblGerGener = new javax.swing.JLabel();
        lblRuc = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        jspDescripPliego = new javax.swing.JScrollPane();
        txtAreaDescripPliego = new javax.swing.JTextArea();
        btnRegistrarCliente = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        comboGerenteGeneral = new javax.swing.JComboBox<>();
        comboGerenteInfraestructura = new javax.swing.JComboBox<>();
        lblDescrpPliego1 = new javax.swing.JLabel();
        comboCliente = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(550, 350));
        setResizable(false);

        lblGerInfraest.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblGerInfraest.setText("Gerente Infraestructura:");

        lblDescrpPliego.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblDescrpPliego.setText("Descripcion Pliego ");

        lblGerGener.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblGerGener.setText("Gerente General:");

        lblRuc.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblRuc.setText("R.U.C. :");

        txtAreaDescripPliego.setColumns(20);
        txtAreaDescripPliego.setRows(5);
        jspDescripPliego.setViewportView(txtAreaDescripPliego);

        btnRegistrarCliente.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnRegistrarCliente.setText("Registrar");

        jLabel6.setFont(new java.awt.Font("Dialog", 2, 24)); // NOI18N
        jLabel6.setText("Registrar Cliente");

        lblDescrpPliego1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblDescrpPliego1.setText("Cliente:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescrpPliego, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGerGener, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGerInfraest, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDescrpPliego1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jspDescripPliego, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(comboGerenteInfraestructura, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboGerenteGeneral, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtRuc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                            .addComponent(comboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel6)
                    .addComponent(btnRegistrarCliente))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDescrpPliego1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jspDescripPliego, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblDescrpPliego, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(67, 67, 67))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblRuc)))
                                .addGap(70, 70, 70))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblGerGener)
                                .addComponent(comboGerenteGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGerInfraest)
                            .addComponent(comboGerenteInfraestructura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public int codigo;
    public int corEmp;
    public ArrayList<String> desGerGeneral = new ArrayList<>();
    public ArrayList<String> desGerInfraes = new ArrayList<>();
    public PersonaDAO per = new PersonaDAO();
    public void inicio(int cod, int corE){
        codigo=cod;
        corEmp=corE;
    }    
    public ArrayList<Tics> auxiliarTics;
    public ArrayList<Persona> personaJuridica;
    public void inicializarCombos(){
        desGerGeneral = per.listGerenteGeneral();
        desGerInfraes = per.listGerenteInfraestructura();
        personaJuridica = per.listPersonaJuridica();
        comboGerenteGeneral.removeAllItems();
        comboGerenteInfraestructura.removeAllItems();
        comboCliente.removeAllItems();
        for (int i = 0; i < desGerGeneral.size(); i++) {
            comboGerenteGeneral.addItem(desGerGeneral.get(i));
        }
        for (int i = 0; i < desGerInfraes.size(); i++) {
            comboGerenteInfraestructura.addItem(desGerInfraes.get(i));
        }
        for (int i = 0; i < personaJuridica.size(); i++) {
            comboCliente.addItem(personaJuridica.get(i).getDesPersona());
        }
    }
    
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
            java.util.logging.Logger.getLogger(JFAgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFAgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFAgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFAgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFAgregarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnRegistrarCliente;
    public javax.swing.JComboBox<String> comboCliente;
    public javax.swing.JComboBox<String> comboGerenteGeneral;
    public javax.swing.JComboBox<String> comboGerenteInfraestructura;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jspDescripPliego;
    private javax.swing.JLabel lblDescrpPliego;
    private javax.swing.JLabel lblDescrpPliego1;
    private javax.swing.JLabel lblGerGener;
    private javax.swing.JLabel lblGerInfraest;
    private javax.swing.JLabel lblRuc;
    public javax.swing.JTextArea txtAreaDescripPliego;
    public javax.swing.JTextField txtRuc;
    // End of variables declaration//GEN-END:variables
}