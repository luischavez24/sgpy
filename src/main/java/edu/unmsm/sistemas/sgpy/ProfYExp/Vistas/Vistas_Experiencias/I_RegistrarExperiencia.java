
package edu.unmsm.sistemas.sgpy.ProfYExp.Vistas.Vistas_Experiencias;
import edu.unmsm.sistemas.sgpy.ProfYExp.Modelo.Experiencia;
import edu.unmsm.sistemas.sgpy.ProfYExp.Modelo.Profesional;
import edu.unmsm.sistemas.sgpy.ProfYExp.Modelo_DAO.ExperienciaDAO;
import edu.unmsm.sistemas.sgpy.ProfYExp.Modelo_DAO.PersonaDAO;
import edu.unmsm.sistemas.sgpy.ProfYExp.Modelo_DAO.ProfesionDAO;
import edu.unmsm.sistemas.sgpy.ProfYExp.Modelo_DAO.ProfesionalDAO;
import edu.unmsm.sistemas.sgpy.ProfYExp.Vistas.Principal.I_MenuProfesional;
import java.awt.Color;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

public class I_RegistrarExperiencia extends javax.swing.JFrame {

    Experiencia ex = new Experiencia();
    ExperienciaDAO exp = new ExperienciaDAO();
    ResultSet rs;
    ProfesionDAO prof=new ProfesionDAO();
    Profesional pr = new Profesional();
//    ProfesionalDAO prf = new ProfesionalDAO();
    ProfesionalDAO prf;
   // PersonaDAO per=new PersonaDAO()
    PersonaDAO per = new PersonaDAO();
    
    public I_RegistrarExperiencia() throws SQLException, Exception {
        initComponents();
        SpinnerNumberModel nm = new SpinnerNumberModel();
        nm.setMaximum(30);
        nm.setValue(1);
        jSpinner.setModel(nm);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        llenarComboPersona();
       llenarComboProfesion();
     
    }

     public void llenarComboPersona() throws Exception{
        rs=per.listarPersonaProfesional();
        while(rs.next()){
           jComboBoxPersona.addItem(rs.getString(1));
        }
    }
    
    public void llenarComboProfesion() throws Exception{
        rs=prof.listarPorVigencia("1");
        String descripcion;
        while(rs.next()){
            descripcion=rs.getString(3);
            jComboBoxProfesion.addItem(descripcion);
        }
    }
    
  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Grupo_Botones = new javax.swing.ButtonGroup();
        ModificaEliminar = new javax.swing.JPopupMenu();
        Modificar = new javax.swing.JMenuItem();
        Eliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCargo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtLugarTrabajo = new javax.swing.JTextField();
        txtFechaInicio = new javax.swing.JTextField();
        txtFechaFin = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jComboBoxPersona = new javax.swing.JComboBox<>();
        jComboBoxProfesion = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMotivoRetiro = new javax.swing.JTextArea();
        jSpinner = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        btnSalirM = new javax.swing.JButton();

        Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProfYExp/Imagenes/iconoiModificarProfesion.png"))); // NOI18N
        Modificar.setText("Modificar  Experiencia");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });
        ModificaEliminar.add(Modificar);

        Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProfYExp/Imagenes/iconoEliminarProfesion.png"))); // NOI18N
        Eliminar.setText("Eliminar Experiencia");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        ModificaEliminar.add(Eliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registrar Experiencia", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24))); // NOI18N
        jPanel1.setComponentPopupMenu(ModificaEliminar);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nombre de persona:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Lugar trabajo:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Fecha de Inicio:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Fecha de Fin:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Descripción del trabajo:");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Motivo de retiro:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Cargo:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Profesión:");

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProfYExp/Imagenes/icono_Experiencia.png"))); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProfYExp/Imagenes/iconoCancelar.png"))); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jComboBoxPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Persona" }));

        jComboBoxProfesion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Profesión" }));

        txtMotivoRetiro.setColumns(20);
        txtMotivoRetiro.setRows(5);
        jScrollPane2.setViewportView(txtMotivoRetiro);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Número de Experiencia:");

        btnSalirM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProfYExp/Imagenes/iconoSalir.png"))); // NOI18N
        btnSalirM.setText("SALIR");
        btnSalirM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtLugarTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxProfesion, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(btnRegistrar)
                .addGap(98, 98, 98)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalirM)
                .addGap(65, 65, 65))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtLugarTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jComboBoxProfesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalirM))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
          if(txtLugarTrabajo.getText().equals("")){
            txtLugarTrabajo.setBackground(Color.red);
        }else{
            txtLugarTrabajo.setBackground(Color.WHITE);
        }

        if(txtFechaInicio.getText().equals("")){
           txtFechaInicio.setBackground(Color.red);
        }else{
            txtFechaInicio.setBackground(Color.WHITE);
        }
        
        if(txtFechaFin.getText().equals("")){
           txtFechaFin.setBackground(Color.red);
        }else{
            txtFechaFin.setBackground(Color.WHITE);
        }
        
        if(txtCargo.getText().equals("")){
           txtCargo.setBackground(Color.red);
        }else{
            txtCargo.setBackground(Color.WHITE);
        }
         
        if(txtDescripcion.getText().equals("")){
           txtDescripcion.setBackground(Color.red);
        }else{
            txtDescripcion.setBackground(Color.WHITE);
        } 
        
        if(txtMotivoRetiro.getText().equals("")){
           txtMotivoRetiro.setBackground(Color.red);
        }else{
           txtMotivoRetiro.setBackground(Color.WHITE);
        } 

        if((jComboBoxProfesion.getSelectedIndex()==0 || jComboBoxProfesion.getSelectedIndex()==-1)){
            jComboBoxProfesion.setBackground(Color.red);
        }else{
            jComboBoxProfesion.setBackground(Color.WHITE);
        }

        if((jComboBoxPersona.getSelectedIndex()==0 || jComboBoxPersona.getSelectedIndex()==-1)){
            jComboBoxPersona.setBackground(Color.red);
        }else{
            jComboBoxPersona.setBackground(Color.WHITE);
        }


        if(txtLugarTrabajo.getText().equals("") || txtFechaInicio.getText().equals("") ||
            txtFechaFin.getText().equals("") || txtCargo.getText().equals("") ||
             txtDescripcion.getText().equals("") || txtMotivoRetiro.getText().equals("") ||
            (jComboBoxPersona.getSelectedIndex()==0 || jComboBoxPersona.getSelectedIndex()==-1) ||
            (jComboBoxProfesion.getSelectedIndex()==0 || jComboBoxProfesion.getSelectedIndex()==-1)
        ){
            JOptionPane.showMessageDialog(null,"Complete campos señalados","Advertencia",JOptionPane.WARNING_MESSAGE);
        }else{
            txtLugarTrabajo.setBackground(Color.WHITE);
            txtFechaInicio.setBackground(Color.WHITE);
            txtFechaFin.setBackground(Color.WHITE);
            txtDescripcion.setBackground(Color.WHITE);
            txtCargo.setBackground(Color.WHITE);
            txtMotivoRetiro.setBackground(Color.WHITE);
            jComboBoxPersona.setBackground(Color.WHITE);
            jComboBoxProfesion.setBackground(Color.WHITE);
            
            ex.setNompers(jComboBoxPersona.getSelectedItem().toString());
            ex.setDescripcionprof(jComboBoxProfesion.getSelectedItem().toString());
            ex.setCargo(txtCargo.getText());
            ex.setCorrexp(jSpinner.getValue().toString());
            ex.setLugar_trabajo(txtLugarTrabajo.getText());
            ex.setDestrabaho(txtDescripcion.getText());
            ex.setMotivoretiro(txtMotivoRetiro.getText());
            ex.setFecIni(txtFechaInicio.getText());
            ex.setFecFin(txtFechaFin.getText());
            ex.setVigente("1");
            exp.Insertar(ex);
            JOptionPane.showMessageDialog(null,"Experiencia Registrada","Registrar",JOptionPane.INFORMATION_MESSAGE);
            txtLugarTrabajo.setText("");
            txtFechaInicio.setText("");
            txtFechaFin.setText("");
            txtDescripcion.setText("");
            txtCargo.setText("");
            txtMotivoRetiro.setText("");
            jComboBoxPersona.setSelectedIndex(0);
            jComboBoxProfesion.setSelectedIndex(0);
        }
        
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int resultado = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro de cancelar esta operación?", "MENSAJE DE CONFIRMACIÓN", JOptionPane.CANCEL_OPTION);
        if(resultado==0){
                txtLugarTrabajo.setText("");
                txtFechaInicio.setText("");
                txtFechaFin.setText("");
                txtDescripcion.setText("");
                txtCargo.setText("");
                txtMotivoRetiro.setText("");
                jComboBoxPersona.setSelectedIndex(0);
                jComboBoxProfesion.setSelectedIndex(0);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        I_ModificarExperiencia a;
        try {
            a = new I_ModificarExperiencia();
            a.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(I_RegistrarExperiencia.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_ModificarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        I_EliminarExperiencia e;
        e=new I_EliminarExperiencia();
        e.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_EliminarActionPerformed

    private void btnSalirMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirMActionPerformed
        new I_MenuProfesional().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirMActionPerformed

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
            java.util.logging.Logger.getLogger(I_RegistrarExperiencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(I_RegistrarExperiencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(I_RegistrarExperiencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(I_RegistrarExperiencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new I_RegistrarExperiencia().setVisible(true);
            } catch (Exception ex1) {
                Logger.getLogger(I_RegistrarExperiencia.class.getName()).log(Level.SEVERE, null, ex1);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Eliminar;
    private javax.swing.ButtonGroup Grupo_Botones;
    private javax.swing.JPopupMenu ModificaEliminar;
    private javax.swing.JMenuItem Modificar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalirM;
    private javax.swing.JComboBox<String> jComboBoxPersona;
    private javax.swing.JComboBox<String> jComboBoxProfesion;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtFechaFin;
    private javax.swing.JTextField txtFechaInicio;
    private javax.swing.JTextField txtLugarTrabajo;
    private javax.swing.JTextArea txtMotivoRetiro;
    // End of variables declaration//GEN-END:variables
}
