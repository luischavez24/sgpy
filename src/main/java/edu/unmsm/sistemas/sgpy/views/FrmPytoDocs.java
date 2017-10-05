/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.views;

import edu.unmsm.sistemas.sgpy.entities.Fase;
import edu.unmsm.sistemas.sgpy.entities.Nivel;
import edu.unmsm.sistemas.sgpy.entities.PytoDocs_View;
import edu.unmsm.sistemas.sgpy.repository.imple.FaseDAO;
import edu.unmsm.sistemas.sgpy.repository.imple.NivelDAO;
import edu.unmsm.sistemas.sgpy.repository.imple.PytoDocsDAO;
import edu.unmsm.sistemas.sgpy.views.util.TableModelCreator;
import java.util.Date;
import java.util.List;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.table.TableModel;

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
        jMenuBar1 = new javax.swing.JMenuBar();
        jInsertarDocumento = new javax.swing.JMenu();
        btnBuscar = new javax.swing.JMenuItem();
        btnInsertar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

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

        lbObservaciones.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbObservaciones.setText("Observaciones");

        txtObs.setColumns(20);
        txtObs.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtObs.setRows(5);
        jScrollPane2.setViewportView(txtObs);

        javax.swing.GroupLayout panelSubidaLayout = new javax.swing.GroupLayout(panelSubida);
        panelSubida.setLayout(panelSubidaLayout);
        panelSubidaLayout.setHorizontalGroup(
            panelSubidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSubidaLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelSubidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(lbObservaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSubDoc, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSubidaLayout.setVerticalGroup(
            panelSubidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSubidaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSubDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143)
                .addComponent(lbObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        panelDatosPyto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información del documento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 13))); // NOI18N

        cmbProyecto.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

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
        cmbTEntregable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lbEspecialista.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbEspecialista.setText("Especialista");

        cmbEspecialista.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cmbEspecialista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbResponsable.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cmbResponsable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        javax.swing.GroupLayout panelInsertarLayout = new javax.swing.GroupLayout(panelInsertar);
        panelInsertar.setLayout(panelInsertarLayout);
        panelInsertarLayout.setHorizontalGroup(
            panelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInsertarLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInsertarLayout.createSequentialGroup()
                        .addComponent(panelDatosPyto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(42, 42, 42)
                        .addComponent(panelSubida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(33, 33, 33))
                    .addGroup(panelInsertarLayout.createSequentialGroup()
                        .addComponent(lbTituloInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 1004, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(23, Short.MAX_VALUE))))
        );
        panelInsertarLayout.setVerticalGroup(
            panelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInsertarLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbTituloInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    private javax.swing.JButton btnQuery;
    private javax.swing.JButton btnSubDoc;
    private javax.swing.JTextField caja_busqueda;
    private javax.swing.JCheckBox chkVigencia;
    private javax.swing.JComboBox<String> cmbEspecialista;
    private javax.swing.JComboBox<Fase> cmbFase;
    private javax.swing.JComboBox<Nivel> cmbNivel;
    private javax.swing.JComboBox<Fase> cmbProyecto;
    private javax.swing.JComboBox<String> cmbResponsable;
    private javax.swing.JComboBox<String> cmbTEntregable;
    private javax.swing.JMenu jInsertarDocumento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
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
    // End of variables declaration//GEN-END:variables
}
