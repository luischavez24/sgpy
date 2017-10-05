/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.views;

import edu.unmsm.sistemas.sgpy.entities.Fase;
import edu.unmsm.sistemas.sgpy.entities.Nivel;
import edu.unmsm.sistemas.sgpy.entities.PytoDocs;
import edu.unmsm.sistemas.sgpy.entities.PytoDocs_View;
import edu.unmsm.sistemas.sgpy.repository.imple.FaseDAO;
import edu.unmsm.sistemas.sgpy.repository.imple.NivelDAO;
import edu.unmsm.sistemas.sgpy.repository.imple.PytoDocsDAO;
import edu.unmsm.sistemas.sgpy.views.util.TableModelCreator;
import java.awt.Font;
import java.io.File;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author lucho
 */
public class FrmPytoDocs extends javax.swing.JFrame {

    public FrmPytoDocs() {
        initComponents();

        llenarTabla(PytoDocsDAO.getInstance().listar());
        configurarSpinners(spnFInicio, "dd/MM/yy");
        configurarSpinners(spnFFin, "dd/MM/yy");
        llenarCombos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuOps = new javax.swing.JPopupMenu();
        btnActualizarDocs = new javax.swing.JMenuItem();
        btnEliminarDocs = new javax.swing.JMenuItem();
        panelFondo = new javax.swing.JLayeredPane();
        panelBuscar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        caja_busqueda = new javax.swing.JTextField();
        btnQuery = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDocs = new javax.swing.JTable();
        panelInsertar = new javax.swing.JPanel();
        lbTituloInsertar = new javax.swing.JLabel();
        panelSubida = new javax.swing.JPanel();
        btnSubDoc = new javax.swing.JButton();
        lbObservaciones = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObs = new javax.swing.JTextArea();
        lbVersion = new javax.swing.JLabel();
        txtVersion = new javax.swing.JTextField();
        panelDatosPyto = new javax.swing.JPanel();
        cmbProyecto = new javax.swing.JComboBox<>();
        lbProyecto = new javax.swing.JLabel();
        lbFase = new javax.swing.JLabel();
        cmbFase = new javax.swing.JComboBox<>();
        lbNivel = new javax.swing.JLabel();
        cmbNivel = new javax.swing.JComboBox<>();
        lbFInicio = new javax.swing.JLabel();
        lbFFin = new javax.swing.JLabel();
        lbCostoEstimado = new javax.swing.JLabel();
        txtCostoEstimado = new javax.swing.JTextField();
        lbTEntregable = new javax.swing.JLabel();
        cmbTEntregable = new javax.swing.JComboBox<>();
        lbEspecialista = new javax.swing.JLabel();
        cmbEspecialista = new javax.swing.JComboBox<>();
        cmbResponsable = new javax.swing.JComboBox<>();
        lbResponsable = new javax.swing.JLabel();
        chkVigencia = new javax.swing.JCheckBox();
        spnFInicio = new javax.swing.JSpinner();
        spnFFin = new javax.swing.JSpinner();
        btnInsertarDocs = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jInsertarDocumento = new javax.swing.JMenu();
        btnBuscar = new javax.swing.JMenuItem();
        btnInsertar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        btnActualizarDocs.setText("Actualizar");
        menuOps.add(btnActualizarDocs);

        btnEliminarDocs.setText("Eliminar");
        menuOps.add(btnEliminarDocs);

        menuOps.getAccessibleContext().setAccessibleDescription("");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Documentos del Proyecto");

        panelFondo.setLayout(new java.awt.CardLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Buscar Documentos");

        caja_busqueda.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        btnQuery.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnQuery.setText("Buscar");

        tablaDocs.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tablaDocs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaDocs.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        tablaDocs.setComponentPopupMenu(menuOps);
        jScrollPane1.setViewportView(tablaDocs);

        javax.swing.GroupLayout panelBuscarLayout = new javax.swing.GroupLayout(panelBuscar);
        panelBuscar.setLayout(panelBuscarLayout);
        panelBuscarLayout.setHorizontalGroup(
            panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBuscarLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
                    .addGroup(panelBuscarLayout.createSequentialGroup()
                        .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(caja_busqueda))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        panelBuscarLayout.setVerticalGroup(
            panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscarLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(caja_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuery, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        panelFondo.add(panelBuscar, "card3");

        lbTituloInsertar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbTituloInsertar.setText("Insertar Documentos");

        panelSubida.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones de subida", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 13))); // NOI18N

        btnSubDoc.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnSubDoc.setText("Seleccione el documento para subirlo");
        btnSubDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubDocActionPerformed(evt);
            }
        });

        lbObservaciones.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbObservaciones.setText("Observaciones");

        txtObs.setColumns(20);
        txtObs.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtObs.setRows(5);
        jScrollPane2.setViewportView(txtObs);

        lbVersion.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbVersion.setText("Version");

        txtVersion.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtVersion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVersionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSubidaLayout = new javax.swing.GroupLayout(panelSubida);
        panelSubida.setLayout(panelSubidaLayout);
        panelSubidaLayout.setHorizontalGroup(
            panelSubidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSubidaLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelSubidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelSubidaLayout.createSequentialGroup()
                        .addComponent(lbVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVersion))
                    .addComponent(jScrollPane2)
                    .addComponent(lbObservaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSubDoc, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        panelSubidaLayout.setVerticalGroup(
            panelSubidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSubidaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSubDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(panelSubidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbVersion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(lbObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        panelDatosPyto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información del documento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 13))); // NOI18N

        cmbProyecto.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cmbProyecto.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {1}));

        lbProyecto.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbProyecto.setText("Proyecto");

        lbFase.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbFase.setText("Fase");

        cmbFase.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        lbNivel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbNivel.setText("Nivel");

        cmbNivel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        lbFInicio.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbFInicio.setText("Fecha de Inicio");

        lbFFin.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbFFin.setText("Fecha de Fin");

        lbCostoEstimado.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbCostoEstimado.setText("Costo Estimado");

        txtCostoEstimado.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtCostoEstimado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoEstimadoActionPerformed(evt);
            }
        });

        lbTEntregable.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbTEntregable.setText("Tipo de entregable");

        cmbTEntregable.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cmbTEntregable.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {1}));

        lbEspecialista.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbEspecialista.setText("Especialista");

        cmbEspecialista.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cmbEspecialista.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {1}));

        cmbResponsable.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cmbResponsable.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {1}));

        lbResponsable.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbResponsable.setText("Responsable");

        chkVigencia.setText("¿Esta vigente?");
        chkVigencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkVigenciaActionPerformed(evt);
            }
        });

        spnFInicio.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        spnFFin.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        javax.swing.GroupLayout panelDatosPytoLayout = new javax.swing.GroupLayout(panelDatosPyto);
        panelDatosPyto.setLayout(panelDatosPytoLayout);
        panelDatosPytoLayout.setHorizontalGroup(
            panelDatosPytoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosPytoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosPytoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelDatosPytoLayout.createSequentialGroup()
                        .addComponent(lbFFin, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnFFin))
                    .addGroup(panelDatosPytoLayout.createSequentialGroup()
                        .addComponent(lbCostoEstimado, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCostoEstimado))
                    .addGroup(panelDatosPytoLayout.createSequentialGroup()
                        .addComponent(lbTEntregable, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTEntregable, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDatosPytoLayout.createSequentialGroup()
                        .addComponent(lbEspecialista, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbEspecialista, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDatosPytoLayout.createSequentialGroup()
                        .addComponent(lbResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDatosPytoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(chkVigencia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbResponsable, javax.swing.GroupLayout.Alignment.TRAILING, 0, 312, Short.MAX_VALUE)))
                    .addGroup(panelDatosPytoLayout.createSequentialGroup()
                        .addGroup(panelDatosPytoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbFInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(lbNivel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbFase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbProyecto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDatosPytoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosPytoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelDatosPytoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbFase, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(cmbNivel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(spnFInicio))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDatosPytoLayout.setVerticalGroup(
            panelDatosPytoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosPytoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosPytoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbProyecto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbProyecto, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosPytoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbFase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbFase, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosPytoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbNivel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosPytoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spnFInicio)
                    .addComponent(lbFInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosPytoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbFFin, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(spnFFin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosPytoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbCostoEstimado, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(txtCostoEstimado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosPytoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbTEntregable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbTEntregable, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosPytoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbEspecialista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbEspecialista, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosPytoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbResponsable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnInsertarDocs.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnInsertarDocs.setText("Insertar");
        btnInsertarDocs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarDocsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInsertarLayout = new javax.swing.GroupLayout(panelInsertar);
        panelInsertar.setLayout(panelInsertarLayout);
        panelInsertarLayout.setHorizontalGroup(
            panelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInsertarLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInsertarLayout.createSequentialGroup()
                        .addComponent(lbTituloInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 851, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnInsertarDocs, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                    .addGroup(panelInsertarLayout.createSequentialGroup()
                        .addComponent(panelDatosPyto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(42, 42, 42)
                        .addComponent(panelSubida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(33, 33, 33))
        );
        panelInsertarLayout.setVerticalGroup(
            panelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInsertarLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbTituloInsertar, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(btnInsertarDocs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDatosPyto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSubida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );

        panelFondo.add(panelInsertar, "card2");

        jInsertarDocumento.setText("Operaciones");
        jInsertarDocumento.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnBuscar.setText("Buscar Documento");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jInsertarDocumento.add(btnBuscar);

        btnInsertar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnInsertar.setText("Insertar Documento");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });
        jInsertarDocumento.add(btnInsertar);

        jMenuBar1.add(jInsertarDocumento);

        jMenu2.setText("Tablas de Soporte");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jMenuItem1.setText("Entregrables");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem3.setText("Estado");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem2.setText("Fases");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem4.setText("Niveles");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Tipos de documento");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Tipo de entregable");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        panelInsertar.setVisible(false);
        panelBuscar.setVisible(true);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        // TODO add your handling code here:
        panelInsertar.setVisible(true);
        panelBuscar.setVisible(false);
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void txtCostoEstimadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoEstimadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoEstimadoActionPerformed

    private void chkVigenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkVigenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkVigenciaActionPerformed

    private void btnSubDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubDocActionPerformed
        // TODO add your handling code here:
        JFileChooser exploradorArchivos = new JFileChooser(System.getProperty("user.desktop"));
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("PDF", "pdf");
        exploradorArchivos.setFileFilter(filtro);
        exploradorArchivos.setMultiSelectionEnabled(false);
        exploradorArchivos.setFileSelectionMode(JFileChooser.FILES_ONLY);
        exploradorArchivos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        int opcion = exploradorArchivos.showOpenDialog(this);
        File archivoSeleccionado = exploradorArchivos.getSelectedFile();
        if (archivoSeleccionado != null && opcion == JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(rootPane, "La ruta seleccionada es: " + archivoSeleccionado.getAbsolutePath());
        }
    }//GEN-LAST:event_btnSubDocActionPerformed

    private void txtVersionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVersionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVersionActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
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
            java.util.logging.Logger.getLogger(TSNivel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TSNivel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TSNivel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TSNivel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TSNivel().setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(TSEntregables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TSEntregables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TSEntregables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TSEntregables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TSEntregables().setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:    }                                          
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
            java.util.logging.Logger.getLogger(TSEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TSEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TSEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TSEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TSEstado().setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
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
            java.util.logging.Logger.getLogger(TSFase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TSFase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TSFase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TSFase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TSFase().setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
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
            java.util.logging.Logger.getLogger(TSTipoDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TSTipoDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TSTipoDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TSTipoDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TSTipoDoc().setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
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
            java.util.logging.Logger.getLogger(TSTipoEntreg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TSTipoEntreg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TSTipoEntreg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TSTipoEntreg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TSTipoEntreg().setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void btnInsertarDocsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarDocsActionPerformed
        // TODO add your handling code here:
        PytoDocs pytoDocs = new PytoDocs();
        pytoDocs.setCodPyto((int) cmbProyecto.getSelectedItem());
        pytoDocs.setCodFase(((Fase) cmbFase.getSelectedItem()).getCodFase());
        //pytoDocs.setCodNivel(((Nivel) cmbNivel.getSelectedItem()).getCodNivel());
    }//GEN-LAST:event_btnInsertarDocsActionPerformed

    private void configurarSpinners(JSpinner timeSpinner, String dateFormat) {
        timeSpinner.setModel(new SpinnerDateModel());
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, dateFormat);
        timeSpinner.setEditor(timeEditor);
        timeSpinner.setValue(new Date()); // will only show the current time
    }

    private void llenarTabla(List<PytoDocs_View> listaDocs) {
        TableModel modeloTabla = TableModelCreator.createTableModel(PytoDocs_View.class, listaDocs);
        tablaDocs.setModel(modeloTabla);
    }

    private void llenarCombos() {
        FaseDAO.getInstance().listar().forEach((item) -> cmbFase.addItem(item));
        NivelDAO.getInstance().listar().forEach((Nivel item) -> cmbNivel.addItem(item));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnActualizarDocs;
    private javax.swing.JMenuItem btnBuscar;
    private javax.swing.JMenuItem btnEliminarDocs;
    private javax.swing.JMenuItem btnInsertar;
    private javax.swing.JButton btnInsertarDocs;
    private javax.swing.JButton btnQuery;
    private javax.swing.JButton btnSubDoc;
    private javax.swing.JTextField caja_busqueda;
    private javax.swing.JCheckBox chkVigencia;
    private javax.swing.JComboBox<Integer> cmbEspecialista;
    private javax.swing.JComboBox<Fase> cmbFase;
    private javax.swing.JComboBox<Nivel> cmbNivel;
    private javax.swing.JComboBox<Integer> cmbProyecto;
    private javax.swing.JComboBox<Integer> cmbResponsable;
    private javax.swing.JComboBox<Integer> cmbTEntregable;
    private javax.swing.JMenu jInsertarDocumento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbCostoEstimado;
    private javax.swing.JLabel lbEspecialista;
    private javax.swing.JLabel lbFFin;
    private javax.swing.JLabel lbFInicio;
    private javax.swing.JLabel lbFase;
    private javax.swing.JLabel lbNivel;
    private javax.swing.JLabel lbObservaciones;
    private javax.swing.JLabel lbProyecto;
    private javax.swing.JLabel lbResponsable;
    private javax.swing.JLabel lbTEntregable;
    private javax.swing.JLabel lbTituloInsertar;
    private javax.swing.JLabel lbVersion;
    private javax.swing.JPopupMenu menuOps;
    private javax.swing.JPanel panelBuscar;
    private javax.swing.JPanel panelDatosPyto;
    private javax.swing.JLayeredPane panelFondo;
    private javax.swing.JPanel panelInsertar;
    private javax.swing.JPanel panelSubida;
    private javax.swing.JSpinner spnFFin;
    private javax.swing.JSpinner spnFInicio;
    private javax.swing.JTable tablaDocs;
    private javax.swing.JTextField txtCostoEstimado;
    private javax.swing.JTextArea txtObs;
    private javax.swing.JTextField txtVersion;
    // End of variables declaration//GEN-END:variables
}
