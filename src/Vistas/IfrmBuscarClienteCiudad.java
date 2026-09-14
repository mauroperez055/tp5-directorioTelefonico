
package Vistas;

import Clases.Contacto;
import Clases.Directorio;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.table.DefaultTableModel;

public class IfrmBuscarClienteCiudad extends javax.swing.JInternalFrame {

    private ArrayList<String> ciudades = FrmMenuPrincipal.getCiudades();
    private Directorio directorio = FrmMenuPrincipal.getDirectorio();
    
    public IfrmBuscarClienteCiudad() {
        initComponents();
        
        for (String ciudad : ciudades){
            cboCiudades.addItem(ciudad);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblCiudades = new javax.swing.JLabel();
        cboCiudades = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();

        setResizable(true);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitulo.setText("Buscar Clientes de Directorio por Ciudad");

        lblCiudades.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCiudades.setText("Ciudades:");

        cboCiudades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        cboCiudades.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboCiudadesItemStateChanged(evt);
            }
        });

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblClientes);

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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCiudades)
                            .addComponent(cboCiudades, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTitulo)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCiudades)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboCiudades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void cboCiudadesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboCiudadesItemStateChanged
        // TODO add your handling code here:

        if (cboCiudades.getSelectedItem() == null) {
            return;
        }
        
        String ciudad = cboCiudades.getSelectedItem().toString();
        
        ArrayList<Contacto> contactos = directorio.buscarContactos(ciudad);
        
        DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
        
        modelo.setRowCount(0);
        
        for (Map.Entry<Long, Contacto> entry : directorio.getEntradas()) {
            Contacto cont = entry.getValue();
            
            if (cont.getCiudad().equals(ciudad)) {
                modelo.addRow(new Object[] {
                    cont.getDni(),
                    cont.getApellido(),
                    cont.getNombre(),
                    cont.getDireccion(),
                    cont.getCiudad(),
                    entry.getKey()
                });
            }
        }
        
//        for (Contacto cont : contactos) {
//                modelo.addRow(new Object[] {
//                    cont.getDni(),
//                    cont.getApellido(),
//                    cont.getNombre(),
//                    cont.getDireccion(),
//                    ciudad,
//                    
//                });
//        }
        
    }//GEN-LAST:event_cboCiudadesItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cboCiudades;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCiudades;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblClientes;
    // End of variables declaration//GEN-END:variables
}
