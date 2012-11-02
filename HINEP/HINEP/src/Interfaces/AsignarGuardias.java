package Interfaces;

import Engine.Guardia;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class AsignarGuardias extends javax.swing.JFrame {

    public AsignarGuardias(Connection con) {
        initComponents();
        guardia = new Guardia();
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        error(false);
        error1(false);
        // Columna invisible enel jtable para guardar el id del personal
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
        cn = con;
        try {
            st = cn.createStatement();
            rellenarCombo();
        } catch (SQLException ex) {
            Logger.getLogger(AsignarGuardias.class.getName()).log(Level.SEVERE, null, ex);
        }
        setLocationRelativeTo(null);
        // No se podr{an seleccionar fechas anteriores a la actual
        dateChooserCombo1.setMinDate(Calendar.getInstance());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jbGuardar = new javax.swing.JButton();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        jlbAsterisco1 = new javax.swing.JLabel();
        jlbError1 = new javax.swing.JLabel();
        jlbAsterisco2 = new javax.swing.JLabel();
        jlbError2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel1.setText("Fecha de Guardia:");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel2.setText("Cargo a cubrir:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Médico Consultorio", "Enfermero" }));
        jComboBox1.setSelectedItem(null);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id_personal", "Nombre y Apellido", "Profesión", "Matrícula"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTable1);

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        dateChooserCombo1.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
            public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
                jDataChooserActionPerformed(evt);
            }
        });

        jlbAsterisco1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jlbAsterisco1.setForeground(new java.awt.Color(204, 0, 0));
        jlbAsterisco1.setText("*");

        jlbError1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jlbError1.setForeground(new java.awt.Color(204, 0, 0));
        jlbError1.setText("* Debe seleccionar una fecha");

        jlbAsterisco2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jlbAsterisco2.setForeground(new java.awt.Color(204, 0, 0));
        jlbAsterisco2.setText("*");

        jlbError2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jlbError2.setForeground(new java.awt.Color(204, 0, 0));
        jlbError2.setText("* Debe seleccionar un empleado");

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jlbError1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlbAsterisco1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlbError2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlbAsterisco2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jComboBox1)
                        .addComponent(jlbAsterisco1))
                    .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jlbError1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jlbAsterisco2)))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbGuardar)
                        .addComponent(jButton1))
                    .addComponent(jlbError2))
                .addContainerGap(79, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        ResultSet rs;
        error1(false);
        // Si no eligió fecha
        if (fecha == null) {
            error(true);
        } else {
            try {
                rs = st.executeQuery("SELECT COUNT(*) FROM personal JOIN guardias ON personal.id_personal = guardias.id_personal WHERE personal.id_cargo = " + id_cargo + " AND guardias.fecha = '" + guardia.getFecha() + "'");
                if (rs.next()) {
                    int contar = rs.getInt("count");
                    if (contar > 0) {

                        if ((id_cargo == 11 || id_cargo == 17) && contar < 3) {
                            // Falta asignar guardia para Enfermería o Consultorio
                            insert();
                        } else {
                            if (id_cargo == 12 && contar < 2) {
                                // Falta asignar guardia para internación
                                insert();
                            } else {
                                // Si ya fué asignada la guardia para esa fecha en ese cargo
                                javax.swing.JOptionPane.showMessageDialog(null, "Ya se asignó personal para esa guardia", "Error al ingresar guardias", 0);
                                jComboBox1.setSelectedIndex(0);
                            }
                        }
                    } else {
                        // Agrega la guardia
                        insert();
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(AsignarGuardias.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void insert() {
        int fila = jTable1.getSelectedRow();
        
        if (fila == -1) {
            error1(true);
        } else {
            int id_personal = (Integer) jTable1.getValueAt(fila, 0);
                    guardia.guardar(st, id_personal);
            javax.swing.JOptionPane.showMessageDialog(null, "Operación realizada con exito", "Asignación de guardia", 0);
            jComboBox1.setSelectedIndex(0);
        }
    }

    private void rellenarCombo() throws SQLException {
        ResultSet rs;
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        rs = st.executeQuery("SELECT * FROM cargos WHERE id_cargo <> 9 order by cargo ");
        while (rs.next()) {
            modeloCombo.addElement(rs.getString(2));
        }
        jComboBox1.setModel(modeloCombo);
        rs.close();
    }

    private void cambioSeleccion() {
        ResultSet rs;
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        while (modelo.getRowCount() - 1 >= 0) {
            modelo.removeRow(0);
        }
        System.out.println(fecha);
        try {
            String itemSelecionado = (String) jComboBox1.getSelectedItem();
            rs = st.executeQuery("SELECT * FROM cargos WHERE cargo = '" + itemSelecionado + "'");
            if (rs.next()) {
                id_cargo = rs.getInt(1);
            }
            rs = st.executeQuery("SELECT distinct personal.id_personal, personal.nombre, personal.apellido, personal.matricula, personal.profesion FROM personal JOIN guardias ON personal.id_personal = guardias.id_personal WHERE personal.id_cargo = " + id_cargo + " AND personal.id_personal NOT IN (SELECT id_personal FROM guardias WHERE guardias.fecha <= '" + guardia.getFecha() + "' AND guardias.fecha > '" + fecha + "')");
            System.out.println(guardia.getFecha());
            while (rs.next()) {
                String nombre;
                String profesion;
                String matricula;
                int id;
                id = rs.getInt("id_personal");
                nombre = rs.getString("nombre") + " " + rs.getString("apellido");
                profesion = rs.getString("profesion");
                matricula = rs.getString("matricula");
                Object o[] = {id, nombre, profesion, matricula};
                modelo.addRow(o);
                System.out.println(id);
            }


        } catch (SQLException ex) {
            Logger.getLogger(AsignarGuardias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if (fecha == null) {
            // Si no ingresó fecha
            error(true);
        } else {
            cambioSeleccion();
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jDataChooserActionPerformed(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_jDataChooserActionPerformed
        error(false);
        Calendar fechaSel;
        //fechaSeleccionada();
        // obtengo la fecha seleccionada
        fechaSel = dateChooserCombo1.getSelectedDate();
        guardia.setFecha(sdf.format(fechaSel.getTime()));
        // le resto dos dias, el personal asignado a guardia
        // debe tener por lo menos dos dias de descanso
        fechaSel.add(Calendar.DAY_OF_YEAR, -3);
        fecha = sdf.format(fechaSel.getTime());
        cambioSeleccion();
        // TODO add your handling code here:
    }//GEN-LAST:event_jDataChooserActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int valor;
        valor = javax.swing.JOptionPane.showConfirmDialog(null, "¿Desea cancelar esta operación?", "Cancelar asignasión de guardias", 0);
        if (valor == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void error(boolean er) {
        jlbAsterisco1.setVisible(er);
        jlbError1.setVisible(er);
    }

    private void error1(boolean er) {
        jlbAsterisco2.setVisible(er);
        jlbError2.setVisible(er);
    }
    private int id_cargo;
    private String fecha;
    SimpleDateFormat sdf;
    private Guardia guardia;
    private Connection cn;
    private Statement st;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JLabel jlbAsterisco1;
    private javax.swing.JLabel jlbAsterisco2;
    private javax.swing.JLabel jlbError1;
    private javax.swing.JLabel jlbError2;
    // End of variables declaration//GEN-END:variables
}
