package taller_ultimo_arranque.vistas;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import taller_ultimo_arranque.dao.OrdenTrabajoDAO;
import taller_ultimo_arranque.modelos.OrdenTrabajo;

public class FrmOrdenTrabajo extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmOrdenTrabajo.class.getName());
    
    // 1. Instancia del DAO
    private final OrdenTrabajoDAO ordenDAO = new OrdenTrabajoDAO();
    private String idMecanico;

    public FrmOrdenTrabajo() {
        initComponents();
        this.setLocationRelativeTo(null); // Centrar en pantalla
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); // Evita cerrar toda la app
        
        // Agregar evento de selección a la tabla
        tblOrdenes.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrdenesMouseClicked(evt);
            }
        });

        cargarTablaOrdenes(); // Cargar datos en tblOrdenes
    }

    // ==========================================
    // MÉTODOS AUXILIARES DE LA VISTA
    // ==========================================
    public void cargarTablaOrdenes() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Orden");
        modelo.addColumn("Placa");
        modelo.addColumn("ID Mecánico");
        modelo.addColumn("Descripción Problema");
        modelo.addColumn("Estado");
        modelo.addColumn("Fecha");
        modelo.addColumn("Total (Q)");

        if (tblOrdenes != null) {
            for (OrdenTrabajo o : ordenDAO.listarOrdenes()) {
                modelo.addRow(new Object[]{
                    o.getIdOrden(),
                    o.getPlaca(),
                    o.getIdMecanico(),
                    o.getDescripcionProblema(),
                    o.getEstado(),
                    o.getFechaCreacion(),
                    o.getCostoTotal()
                });
            }
            tblOrdenes.setModel(modelo);
        }
    }

    private void limpiarCampos() {
        if (txtPlaca != null) txtPlaca.setText("");
        if (txtIdMecanico != null) txtIdMecanico.setText("");
        if (txtDescripcion != null) txtDescripcion.setText("");
        if (lblIdOrden != null) lblIdOrden.setText("---");
        if (lblEstado != null) lblEstado.setText("PENDIENTE");
        if (txtPlaca != null) txtPlaca.requestFocus();
        
        
    }

    private void tblOrdenesMouseClicked(java.awt.event.MouseEvent evt) {
        int fila = tblOrdenes.getSelectedRow();
        if (fila >= 0) {
            lblIdOrden.setText(tblOrdenes.getValueAt(fila, 0).toString());
            txtPlaca.setText(tblOrdenes.getValueAt(fila, 1).toString());
            txtIdMecanico.setText(tblOrdenes.getValueAt(fila, 2).toString());
            txtDescripcion.setText(tblOrdenes.getValueAt(fila, 3) != null ? tblOrdenes.getValueAt(fila, 3).toString() : "");
            lblEstado.setText(tblOrdenes.getValueAt(fila, 4).toString());
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblIdOrden = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        txtIdMecanico = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        btnIniciarProceso = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnAgregarServicio = new javax.swing.JButton();
        btnAgregarRepuesto = new javax.swing.JButton();
        btnAgregarComprobante = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrdenes = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblIdOrden.setText("ID Orden");

        lblEstado.setText("Estado");

        txtPlaca.setText("Placa");

        txtIdMecanico.setText("ID Mecanico");

        txtDescripcion.setText("Descripcion");

        btnCrear.setText("Crear Orden");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnIniciarProceso.setText("Iniciar Proceso");
        btnIniciarProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarProcesoActionPerformed(evt);
            }
        });

        btnFinalizar.setText("Finalizar Orden");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar Orden");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAgregarServicio.setText("Agregar Servicio");
        btnAgregarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarServicioActionPerformed(evt);
            }
        });

        btnAgregarRepuesto.setText("Agregar Repuesto");
        btnAgregarRepuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarRepuestoActionPerformed(evt);
            }
        });

        btnAgregarComprobante.setText("Imprimir Comprobante");
        btnAgregarComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarComprobanteActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar Campos");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        tblOrdenes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblOrdenes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblIdOrden))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdMecanico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCrear)
                            .addComponent(btnIniciarProceso)
                            .addComponent(btnFinalizar)
                            .addComponent(btnCancelar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarServicio)
                    .addComponent(lblEstado)
                    .addComponent(btnAgregarRepuesto)
                    .addComponent(btnAgregarComprobante)
                    .addComponent(btnLimpiar))
                .addGap(76, 76, 76))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdOrden)
                    .addComponent(lblEstado))
                .addGap(27, 27, 27)
                .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdMecanico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear)
                    .addComponent(btnAgregarServicio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciarProceso)
                    .addComponent(btnAgregarRepuesto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinalizar)
                    .addComponent(btnAgregarComprobante))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnLimpiar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
if (txtPlaca.getText().trim().isEmpty() || txtIdMecanico.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar la Placa y el ID del Mecánico.", "Campos Requeridos", JOptionPane.WARNING_MESSAGE);
            return;
        }

       OrdenTrabajo nuevaOrden = new OrdenTrabajo();
    nuevaOrden.setPlaca(txtPlaca.getText().trim().toUpperCase());
    nuevaOrden.setIdMecanico(idMecanico);
    nuevaOrden.setDescripcionProblema(txtDescripcion.getText().trim());
    nuevaOrden.setEstado("PENDIENTE");

        if (ordenDAO.crearOrden(nuevaOrden)) {
            JOptionPane.showMessageDialog(this, "Orden creada exitosamente.");
            cargarTablaOrdenes();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar la orden en la base de datos.", "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
        }//GEN-LAST:event_btnCrearActionPerformed

    private void btnIniciarProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarProcesoActionPerformed
if (lblIdOrden.getText().equals("---")) {
            JOptionPane.showMessageDialog(this, "Seleccione una orden de la tabla primero.");
            return;
        }
        int idOrden = Integer.parseInt(lblIdOrden.getText());
        if (ordenDAO.actualizarEstado(idOrden, "EN PROCESO")) {
            JOptionPane.showMessageDialog(this, "La orden #" + idOrden + " ahora está EN PROCESO.");
            cargarTablaOrdenes();
            lblEstado.setText("EN PROCESO");
        }
        }//GEN-LAST:event_btnIniciarProcesoActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
if (lblIdOrden.getText().equals("---")) {
            JOptionPane.showMessageDialog(this, "Seleccione una orden de la tabla primero.");
            return;
        }
        int idOrden = Integer.parseInt(lblIdOrden.getText());
        if (ordenDAO.actualizarEstado(idOrden, "FINALIZADA")) {
            JOptionPane.showMessageDialog(this, "La orden #" + idOrden + " ha sido FINALIZADA.");
            cargarTablaOrdenes();
            lblEstado.setText("FINALIZADA");
        }
        }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
if (lblIdOrden.getText().equals("---")) {
            JOptionPane.showMessageDialog(this, "Seleccione una orden de la tabla primero.");
            return;
        }
        int idOrden = Integer.parseInt(lblIdOrden.getText());
        if (ordenDAO.actualizarEstado(idOrden, "CANCELADA")) {
            JOptionPane.showMessageDialog(this, "Orden #" + idOrden + " CANCELADA. Los repuestos han sido devueltos al inventario.");
            cargarTablaOrdenes();
            lblEstado.setText("CANCELADA");
        }
        }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarServicioActionPerformed
if (lblIdOrden.getText().equals("---")) {
            JOptionPane.showMessageDialog(this, "Seleccione una orden activa.");
            return;
        }
        JOptionPane.showMessageDialog(this, "Abriendo módulo de selección de Mano de Obra / Servicios...");
        // FrmAgregarServicio frm = new FrmAgregarServicio(Integer.parseInt(lblIdOrden.getText()));
        // frm.setVisible(true);
        }//GEN-LAST:event_btnAgregarServicioActionPerformed

    private void btnAgregarRepuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarRepuestoActionPerformed
if (lblIdOrden.getText().equals("---")) {
            JOptionPane.showMessageDialog(this, "Seleccione una orden activa.");
            return;
        }
        JOptionPane.showMessageDialog(this, "Abriendo catálogo de Repuestos e Inventario...");
        // FrmAgregarRepuesto frm = new FrmAgregarRepuesto(Integer.parseInt(lblIdOrden.getText()));
        // frm.setVisible(true);
        }//GEN-LAST:event_btnAgregarRepuestoActionPerformed

    private void btnAgregarComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarComprobanteActionPerformed
if (lblIdOrden.getText().equals("---")) {
            JOptionPane.showMessageDialog(this, "Seleccione una orden finalizada.");
            return;
        }
        JOptionPane.showMessageDialog(this, "Generando comprobante de pago para la Orden #" + lblIdOrden.getText());
        }//GEN-LAST:event_btnAgregarComprobanteActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
limpiarCampos();
        }//GEN-LAST:event_btnLimpiarActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FrmOrdenTrabajo().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarComprobante;
    private javax.swing.JButton btnAgregarRepuesto;
    private javax.swing.JButton btnAgregarServicio;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnIniciarProceso;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblIdOrden;
    private javax.swing.JTable tblOrdenes;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtIdMecanico;
    private javax.swing.JTextField txtPlaca;
    // End of variables declaration//GEN-END:variables

}