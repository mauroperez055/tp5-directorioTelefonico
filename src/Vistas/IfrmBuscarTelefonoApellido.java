
package Vistas;

import Clases.Contacto;
import Clases.Directorio;
import java.util.TreeSet;
import javax.swing.DefaultListModel;

public class IfrmBuscarTelefonoApellido extends javax.swing.JInternalFrame {

    private Directorio directorio = FrmMenuPrincipal.getDirectorio();
    
    public IfrmBuscarTelefonoApellido() {
        initComponents();
        llenarListaApellidos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstApellidos = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();

        setResizable(true);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitulo.setText("Buscar Teléfono por Apellido");

        lblApellido.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblApellido.setText("Apellido:");

        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApellidoKeyReleased(evt);
            }
        });

        jScrollPane1.setViewportView(lstApellidos);

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "DNI", "Apellido", "Nombre", "Dirección", "Ciudad", "Teléfono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblCliente);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTitulo)
                        .addGap(230, 230, 230))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSalir)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblApellido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(15, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblApellido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyReleased
        // TODO add your handling code here:
        llenarListaApellidos();
    }//GEN-LAST:event_txtApellidoKeyReleased

    public void llenarListaApellidos() {
        DefaultListModel modelo = new DefaultListModel();

        for (Contacto cont : directorio.getContacto()) {
            if (cont.getApellido().contains(txtApellido.getText().toUpperCase())) {
                modelo.addElement(cont.getApellido());
            }
        }
        lstApellidos.setModel(modelo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList<String> lstApellidos;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTextField txtApellido;
    // End of variables declaration//GEN-END:variables
}
