/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.views;

import edu.unmsm.sistemas.sgpy.entities.Estado;
import edu.unmsm.sistemas.sgpy.entities.Fase;
import edu.unmsm.sistemas.sgpy.entities.Nivel;
import edu.unmsm.sistemas.sgpy.entities.PytoDocs;
import edu.unmsm.sistemas.sgpy.entities.PytoDocsView;
import edu.unmsm.sistemas.sgpy.entities.TipoDoc;
import edu.unmsm.sistemas.sgpy.entities.TipoEntreg;
import edu.unmsm.sistemas.sgpy.repository.imple.FaseDAO;
import edu.unmsm.sistemas.sgpy.repository.imple.NivelDAO;
import edu.unmsm.sistemas.sgpy.repository.imple.PytoDocsDAOImple;
import edu.unmsm.sistemas.sgpy.views.util.TableModelCreator;
import java.awt.Font;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.awt.Color;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;

/**
 *
 * @author lucho
 */
public class FrmPytoDocs extends javax.swing.JFrame {

    private String rutaDocumento;

    public FrmPytoDocs() {
        initComponents();

        llenarTabla(PytoDocsDAOImple.getInstance().listar());
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
        background = new javax.swing.JPanel();
        sideBar = new javax.swing.JPanel();
        btnInsertarDoc = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnBuscarDocs = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnMantenimiento = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        mainPane = new javax.swing.JLayeredPane();
        panelBuscar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDocs = new javax.swing.JTable();
        header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        caja_busqueda = new javax.swing.JTextField();
        btnQuery = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        panelInsertar = new javax.swing.JPanel();
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
        cmbEstado = new javax.swing.JComboBox<>();
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
        lbTEntregable1 = new javax.swing.JLabel();
        spnCorrEntregable = new javax.swing.JSpinner();
        lbCostoEstimado1 = new javax.swing.JLabel();
        cmbTDoc = new javax.swing.JComboBox<>();
        header1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        btnActualizarDocs.setText("Actualizar");
        menuOps.add(btnActualizarDocs);

        btnEliminarDocs.setText("Eliminar");
        menuOps.add(btnEliminarDocs);

        menuOps.getAccessibleContext().setAccessibleDescription("");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Documentos del Proyecto");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sideBar.setBackground(new java.awt.Color(57, 73, 171));
        sideBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnInsertarDoc.setBackground(new java.awt.Color(57, 73, 171));
        btnInsertarDoc.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnInsertarDoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsertarDocMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInsertarDocMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInsertarDocMouseExited(evt);
            }
        });
        btnInsertarDoc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnInsertarDoc.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 30, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingresar Documento");
        btnInsertarDoc.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 140, 48));

        sideBar.add(btnInsertarDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 260, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("SGPY");
        sideBar.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 200, 48));
        sideBar.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 180, 10));

        btnBuscarDocs.setBackground(new java.awt.Color(57, 73, 171));
        btnBuscarDocs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarDocsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuscarDocsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuscarDocsMouseExited(evt);
            }
        });
        btnBuscarDocs.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBuscarDocs.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 30, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Buscar Documento");
        btnBuscarDocs.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 140, 48));

        sideBar.add(btnBuscarDocs, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 260, -1));

        btnMantenimiento.setBackground(new java.awt.Color(57, 73, 171));
        btnMantenimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnMantenimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMantenimientoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMantenimientoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMantenimientoMouseExited(evt);
            }
        });
        btnMantenimiento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMantenimiento.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 30, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Mantenimiento");
        btnMantenimiento.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 140, 48));

        sideBar.add(btnMantenimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 260, -1));

        background.add(sideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 600));

        mainPane.setBackground(new java.awt.Color(255, 255, 255));
        mainPane.setLayout(new java.awt.CardLayout());

        panelBuscar.setBackground(new java.awt.Color(255, 255, 255));
        panelBuscar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        tablaDocs.setAutoCreateRowSorter(true);
        tablaDocs.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaDocs.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        tablaDocs.setColumnSelectionAllowed(true);
        tablaDocs.setComponentPopupMenu(menuOps);
        tablaDocs.setGridColor(new java.awt.Color(255, 255, 255));
        tablaDocs.setRowHeight(25);
        tablaDocs.setSelectionBackground(new java.awt.Color(92, 107, 192));
        tablaDocs.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaDocs.setSurrendersFocusOnKeystroke(true);
        tablaDocs.getTableHeader().setResizingAllowed(false);
        tablaDocs.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaDocs);
        tablaDocs.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tablaDocs.getColumnModel().getColumnCount() > 0) {
            tablaDocs.getColumnModel().getColumn(3).setResizable(false);
        }

        panelBuscar.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 920, 340));

        header.setBackground(new java.awt.Color(159, 168, 218));
        header.setForeground(new java.awt.Color(255, 255, 255));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar Documentos");
        header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, 36));

        caja_busqueda.setBackground(new java.awt.Color(159, 168, 218));
        caja_busqueda.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        caja_busqueda.setForeground(new java.awt.Color(255, 255, 255));
        caja_busqueda.setBorder(null);
        header.add(caja_busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 620, 29));

        btnQuery.setBackground(new java.awt.Color(92, 107, 192));
        btnQuery.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnQuery.setForeground(new java.awt.Color(255, 255, 255));
        btnQuery.setText("Buscar");
        btnQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQueryActionPerformed(evt);
            }
        });
        header.add(btnQuery, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 90, 180, 40));
        header.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 620, 10));

        panelBuscar.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 170));

        mainPane.add(panelBuscar, "card3");

        panelInsertar.setBackground(new java.awt.Color(255, 255, 255));
        panelInsertar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelSubida.setBackground(new java.awt.Color(255, 255, 255));
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
                .addContainerGap()
                .addGroup(panelSubidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSubidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelSubidaLayout.createSequentialGroup()
                            .addComponent(lbVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnSubDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        panelSubidaLayout.setVerticalGroup(
            panelSubidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSubidaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSubDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelSubidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(lbObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        panelInsertar.add(panelSubida, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 450, 390));

        panelDatosPyto.setBackground(new java.awt.Color(255, 255, 255));
        panelDatosPyto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información del documento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 13))); // NOI18N

        cmbProyecto.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cmbProyecto.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {1}));

        lbProyecto.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbProyecto.setText("Proyecto");

        lbFase.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbFase.setText("Estado Proyecto");

        cmbEstado.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

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

        chkVigencia.setBackground(new java.awt.Color(255, 255, 255));
        chkVigencia.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        chkVigencia.setText("¿Esta vigente?");
        chkVigencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkVigenciaActionPerformed(evt);
            }
        });

        spnFInicio.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        spnFFin.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        lbTEntregable1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbTEntregable1.setText("Corr. Entregable");

        lbCostoEstimado1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbCostoEstimado1.setText("Tipo");

        cmbTDoc.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cmbTDoc.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {1}));

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
                            .addComponent(lbFase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbProyecto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDatosPytoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spnFInicio)
                            .addGroup(panelDatosPytoLayout.createSequentialGroup()
                                .addComponent(cmbProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cmbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelDatosPytoLayout.createSequentialGroup()
                        .addGroup(panelDatosPytoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDatosPytoLayout.createSequentialGroup()
                                .addComponent(lbCostoEstimado, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCostoEstimado))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDatosPytoLayout.createSequentialGroup()
                                .addComponent(lbTEntregable, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbTEntregable, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDatosPytoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosPytoLayout.createSequentialGroup()
                                .addComponent(lbTEntregable1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnCorrEntregable))
                            .addGroup(panelDatosPytoLayout.createSequentialGroup()
                                .addComponent(lbCostoEstimado1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbTDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
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
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosPytoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spnFInicio)
                    .addComponent(lbFInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosPytoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbFFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spnFFin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosPytoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbCostoEstimado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelDatosPytoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCostoEstimado)
                        .addComponent(lbCostoEstimado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbTDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelDatosPytoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTEntregable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelDatosPytoLayout.createSequentialGroup()
                        .addGroup(panelDatosPytoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTEntregable, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelDatosPytoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(spnCorrEntregable, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbTEntregable1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosPytoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbEspecialista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbEspecialista, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosPytoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbResponsable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkVigencia)
                .addContainerGap())
        );

        panelInsertar.add(panelDatosPyto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, 390));

        header1.setBackground(new java.awt.Color(159, 168, 218));
        header1.setForeground(new java.awt.Color(255, 255, 255));
        header1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ingresar Documentos");
        header1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, 36));

        btnIngresar.setBackground(new java.awt.Color(57, 73, 171));
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIngresarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIngresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIngresarMouseExited(evt);
            }
        });
        btnIngresar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ic_donut_small_white_24dp.png"))); // NOI18N
        btnIngresar.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 30, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Ingresar");
        btnIngresar.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 110, 48));

        header1.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 70, 200, -1));

        panelInsertar.add(header1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 170));

        mainPane.add(panelInsertar, "card2");

        background.add(mainPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 0, 980, 600));

        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            rutaDocumento = archivoSeleccionado.getAbsolutePath();
        }
    }//GEN-LAST:event_btnSubDocActionPerformed

    private void txtVersionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVersionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVersionActionPerformed

    private void btnInsertarDocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertarDocMouseClicked
        // TODO add your handling code here:
        panelInsertar.setVisible(true);
        panelBuscar.setVisible(false);
    }//GEN-LAST:event_btnInsertarDocMouseClicked

    private void btnBuscarDocsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarDocsMouseClicked
        // TODO add your handling code here:
        panelInsertar.setVisible(false);
        panelBuscar.setVisible(true);
    }//GEN-LAST:event_btnBuscarDocsMouseClicked

    private void btnQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQueryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQueryActionPerformed
    //new java.awt.Color(26, 35, 126)
    //new java.awt.Color(57, 73, 171)
    private void btnBuscarDocsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarDocsMouseEntered
        hoverOn((JPanel) evt.getSource(), new java.awt.Color(26, 35, 126));
    }//GEN-LAST:event_btnBuscarDocsMouseEntered

    private void btnBuscarDocsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarDocsMouseExited
        hoverOff((JPanel) evt.getSource(), new java.awt.Color(57, 73, 171));
    }//GEN-LAST:event_btnBuscarDocsMouseExited

    private void btnInsertarDocMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertarDocMouseEntered
        hoverOn((JPanel) evt.getSource(), new java.awt.Color(26, 35, 126));
    }//GEN-LAST:event_btnInsertarDocMouseEntered

    private void btnInsertarDocMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertarDocMouseExited
        hoverOff((JPanel) evt.getSource(), new java.awt.Color(57, 73, 171));
    }//GEN-LAST:event_btnInsertarDocMouseExited

    private void btnMantenimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMantenimientoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMantenimientoMouseClicked

    private void btnMantenimientoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMantenimientoMouseEntered
        // TODO add your handling code here:
        hoverOff((JPanel) evt.getSource(), new java.awt.Color(26, 35, 126));
    }//GEN-LAST:event_btnMantenimientoMouseEntered

    private void btnMantenimientoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMantenimientoMouseExited
        // TODO add your handling code here:
        hoverOn((JPanel) evt.getSource(), new java.awt.Color(57, 73, 171));
    }//GEN-LAST:event_btnMantenimientoMouseExited

    private void btnIngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseClicked
        // TODO add your handling code here:
        if (rutaDocumento != null) {
            PytoDocs pytoDocs = new PytoDocs();
            pytoDocs.setCodPyto((int) cmbProyecto.getSelectedItem());
            Estado estado = (Estado) cmbEstado.getSelectedItem();
            pytoDocs.setCodFase(estado.getCodFase());
            pytoDocs.setCodNivel(estado.getCodNivel());
            pytoDocs.setEstPyto(estado.getEstPyto());
            pytoDocs.setFecIni((Date) spnFInicio.getModel().getValue());
            pytoDocs.setFecFin((Date) spnFFin.getModel().getValue());
            pytoDocs.setCostoEst(Double.parseDouble(txtCostoEstimado.getText()));
            pytoDocs.setCodDoc(((TipoDoc) cmbTDoc.getSelectedItem()).getCodDoc());
            pytoDocs.setRutaDoc(rutaDocumento);
            pytoDocs.setVerDoc(txtVersion.getText());
            pytoDocs.setObservac(txtObs.getText());
            pytoDocs.setTipoEntreg(((TipoEntreg) cmbTEntregable.getSelectedItem()).getTipoEntreg());
            pytoDocs.setCorrEntreg((int) spnCorrEntregable.getValue());
            pytoDocs.setCodEsp(1);
            pytoDocs.setCodResp(1);
            pytoDocs.setVigente((chkVigencia.isSelected()) ? "1" : "0");
            
        }

    }//GEN-LAST:event_btnIngresarMouseClicked

    private void btnIngresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseEntered
        // TODO add your handling code here:
        hoverOff((JPanel) evt.getSource(), new java.awt.Color(26, 35, 126));
    }//GEN-LAST:event_btnIngresarMouseEntered

    private void btnIngresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseExited
        hoverOn((JPanel) evt.getSource(), new java.awt.Color(57, 73, 171));
    }//GEN-LAST:event_btnIngresarMouseExited

    private void hoverOn(JPanel boton, Color color) {
        boton.setBackground(color);
    }

    private void hoverOff(JPanel boton, Color color) {

        boton.setBackground(color);
    }

    private void configurarSpinners(JSpinner timeSpinner, String dateFormat) {
        timeSpinner.setModel(new SpinnerDateModel());
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, dateFormat);
        timeSpinner.setEditor(timeEditor);
        timeSpinner.setValue(new Date()); // will only show the current time
    }

    private void llenarTabla(List<PytoDocsView> listaDocs) {
        TableModel modeloTabla = TableModelCreator.createTableModel(PytoDocsView.class, listaDocs);
        tablaDocs.setModel(modeloTabla);
    }

    private void llenarCombos() {
        FaseDAO.getInstance().listar().forEach((item) -> cmbEstado.addItem(item));
        NivelDAO.getInstance().listar().forEach((Nivel item) -> cmbNivel.addItem(item));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JMenuItem btnActualizarDocs;
    private javax.swing.JPanel btnBuscarDocs;
    private javax.swing.JMenuItem btnEliminarDocs;
    private javax.swing.JPanel btnIngresar;
    private javax.swing.JPanel btnInsertarDoc;
    private javax.swing.JPanel btnMantenimiento;
    private javax.swing.JButton btnQuery;
    private javax.swing.JButton btnSubDoc;
    private javax.swing.JTextField caja_busqueda;
    private javax.swing.JCheckBox chkVigencia;
    private javax.swing.JComboBox<Integer> cmbEspecialista;
    private javax.swing.JComboBox<Estado> cmbEstado;
    private javax.swing.JComboBox<Integer> cmbProyecto;
    private javax.swing.JComboBox<Integer> cmbResponsable;
    private javax.swing.JComboBox<Integer> cmbTDoc;
    private javax.swing.JComboBox<Integer> cmbTEntregable;
    private javax.swing.JPanel header;
    private javax.swing.JPanel header1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbCostoEstimado;
    private javax.swing.JLabel lbCostoEstimado1;
    private javax.swing.JLabel lbEspecialista;
    private javax.swing.JLabel lbFFin;
    private javax.swing.JLabel lbFInicio;
    private javax.swing.JLabel lbFase;
    private javax.swing.JLabel lbObservaciones;
    private javax.swing.JLabel lbProyecto;
    private javax.swing.JLabel lbResponsable;
    private javax.swing.JLabel lbTEntregable;
    private javax.swing.JLabel lbTEntregable1;
    private javax.swing.JLabel lbVersion;
    private javax.swing.JLayeredPane mainPane;
    private javax.swing.JPopupMenu menuOps;
    private javax.swing.JPanel panelBuscar;
    private javax.swing.JPanel panelDatosPyto;
    private javax.swing.JPanel panelInsertar;
    private javax.swing.JPanel panelSubida;
    private javax.swing.JPanel sideBar;
    private javax.swing.JSpinner spnCorrEntregable;
    private javax.swing.JSpinner spnFFin;
    private javax.swing.JSpinner spnFInicio;
    private javax.swing.JTable tablaDocs;
    private javax.swing.JTextField txtCostoEstimado;
    private javax.swing.JTextArea txtObs;
    private javax.swing.JTextField txtVersion;
    // End of variables declaration//GEN-END:variables
}
