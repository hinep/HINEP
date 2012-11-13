package Interfaces;

import Engine.Internacion;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class AltaPaciente extends javax.swing.JFrame {

    public AltaPaciente(AdministrarInternaciones ai, int id, Connection con) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/Iconos/grafico.png"));
        adminInter = ai;
        cn = con;
        id_personal = id;
        altaIntern = new Internacion();
        // Columna invisible en el jtable para guardar el id de internacion
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
        // Columna invisible en el jtable para guardar el id de cama
        jTable1.getColumnModel().getColumn(1).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(1).setMinWidth(0);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(0);
        try {
            st = cn.createStatement();
            rellenarCombo();
            rellenarTabla();
        } catch (SQLException ex) {
            Logger.getLogger(AsignarGuardias.class.getName()).log(Level.SEVERE, null, ex);
        }
        error1(false);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jbGuardar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jlbError2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_int", "id_cama", "Nombre", "Apellido", "Fecha de Ingreso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel1.setText("Servicio al que será derivado:");

        jComboBox1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ninguno", "Cuidados Intensivos" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel2.setText("Motivo de Alta:");

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jlbError2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jlbError2.setForeground(new java.awt.Color(204, 0, 0));
        jlbError2.setText("* Debe seleccionar un paciente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(232, 232, 232))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(414, 414, 414)
                        .addComponent(jbCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jbGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlbError2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(jlbError2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        error1(false);
        int fila = jTable1.getSelectedRow();
        String motivo = "";
        try {
            ResultSet rs;
            String itemSelecionado = (String) jComboBox1.getSelectedItem();
            rs = st.executeQuery("SELECT * FROM servicios WHERE desc_servicio = '" + itemSelecionado + "'");
            if (rs.next()) {
                altaIntern.setIdServ(rs.getInt(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(AltaPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (fila == -1) {
            error1(true);
        } else {
            altaIntern.setIdInt((Integer) jTable1.getValueAt(fila, 0));
            altaIntern.setIdCama((Integer) jTable1.getValueAt(fila, 1));
            motivo = motivo.concat(jTextField1.getText());
            altaIntern.alta(st, id_personal, motivo);
            System.out.println(motivo);
            System.out.println(altaIntern.getIdCama());
            System.out.println(altaIntern.getIdInt());
            javax.swing.JOptionPane.showMessageDialog(null, "Operación realizada con exito", "Alta de paciente", 0);
            this.dispose();
            adminInter.setVisible(true);
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        // TODO add your handling code here:int valor;
        int valor;
        valor = javax.swing.JOptionPane.showConfirmDialog(null, "¿Desea cancelar esta operación?", "Cancelar alta de paciente", 0);
        if (valor == 0) {
            this.dispose();
            adminInter.setVisible(true);
        }
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void rellenarTabla() {
        ResultSet rs;
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        // Para vaciar la tabla
        while (modelo.getRowCount() - 1 >= 0) {
            modelo.removeRow(0);
        }
        try {
            rs = st.executeQuery("SELECT internaciones_transitorias.id_int,internaciones_transitorias.id_cama, pacientes.nom_1, pacientes.nom_2, pacientes.ape_1, pacientes.ape_2, internaciones_transitorias.fecha_ing FROM internaciones_transitorias join pacientes on internaciones_transitorias.id_paciente = pacientes.id_paciente where internaciones_transitorias.fecha_alta is null");
            while (rs.next()) {
                String nombre, apellido, fecha_ing;
                int id_cama, id_internacion;
                id_internacion = rs.getInt("id_int");
                id_cama = rs.getInt("id_cama");
                fecha_ing = rs.getString("fecha_ing");
                nombre = rs.getString("nom_1") + " " + rs.getString("nom_2");
                apellido = rs.getString("ape_1") + " " + rs.getString("ape_2");
                Object o[] = {id_internacion, id_cama, nombre, apellido, fecha_ing};
                modelo.addRow(o);
                //System.out.println();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void rellenarCombo() throws SQLException {
        ResultSet rs;
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        rs = st.executeQuery("SELECT * FROM servicios order by desc_servicio");
        while (rs.next()) {
            modeloCombo.addElement(rs.getString(2));
        }
        jComboBox1.setModel(modeloCombo);
        jComboBox1.setSelectedIndex(0);
        rs.close();
    }
    private int id_personal;
    private Internacion altaIntern;
    private AdministrarInternaciones adminInter;
    private Connection cn;
    private Statement st;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JLabel jlbError2;
    // End of variables declaration//GEN-END:variables

    private void error1(boolean b) {
        jlbError2.setVisible(b);
    }
}
