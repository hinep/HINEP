package Interfaces;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class TiempoInternacion extends javax.swing.JDialog {

    public TiempoInternacion(AdministrarInternaciones ai, Connection con) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/Iconos/grafico.png"));
        cn = con;
        adminInter = ai;
        try {
            st = cn.createStatement();
            rellenarTabla();
        } catch (SQLException ex) {
            Logger.getLogger(AsignarGuardias.class.getName()).log(Level.SEVERE, null, ex);
        }
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tiempo (Horas)", "Habitación - Cama", "Nombre y Apellido", "Fecha de Ingreso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Aceptar");
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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        adminInter.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rellenarTabla() {
        ResultSet rs;
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        // Para vaciar la tabla
        while (modelo.getRowCount() - 1 >= 0) {
            modelo.removeRow(0);
        }
        try {
            rs = st.executeQuery("SELECT (current_date - internaciones_transitorias.fecha_ing) as dif_fecha, (localtime - internaciones_transitorias.hora_ing) as dif_hora,camas.nro_habitacion, camas.desc_cama, pacientes.nom_1, pacientes.ape_1, internaciones_transitorias.fecha_ing FROM internaciones_transitorias join camas on internaciones_transitorias.id_cama = camas.id_cama join pacientes on internaciones_transitorias.id_paciente = pacientes.id_paciente where internaciones_transitorias.fecha_alta is null");
            while (rs.next()) {
                String nombre, dif_hora, habitacion, fecha_ing;
                int dif_fecha, tiempo;
                dif_fecha = rs.getInt("dif_fecha");
                dif_hora = rs.getString("dif_hora");
                fecha_ing = rs.getString("fecha_ing");
                habitacion = rs.getString("nro_habitacion") + " " + rs.getString("desc_cama");
                nombre = rs.getString("ape_1") + " " + rs.getString("nom_1");
                tiempo = calcularTiempo(dif_fecha, dif_hora);
                Object o[] = {tiempo, habitacion, nombre, fecha_ing};
                modelo.addRow(o);
                //System.out.println();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private int calcularTiempo(int dif_fecha, String dif_hora) {
        int indice, tiempo, diasEnHoras = 0;
        System.out.println(dif_hora);
        indice = dif_hora.indexOf(":");
        dif_hora = dif_hora.substring(0, indice);
        System.out.println(dif_hora);
        tiempo = Integer.parseInt(dif_hora);

        if (dif_fecha > 0) {
            // expreso los días en horas
            diasEnHoras = dif_fecha * 24;
        }
        tiempo = tiempo + diasEnHoras;
        return tiempo;
    }
    private AdministrarInternaciones adminInter;
    private Statement st;
    private Connection cn;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
