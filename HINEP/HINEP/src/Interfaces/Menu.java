/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SySoft
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu(Connection cn, int id, Principal in) {
        initComponents();
        setLocationRelativeTo(null);
        conexion = cn;
        id_personal = id;
        inicio = in;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jbAtención = new javax.swing.JButton();
        jbInternaciones = new javax.swing.JButton();
        jbMedicar = new javax.swing.JButton();
        jbGuardias = new javax.swing.JButton();
        jbEstadisticas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Ingresar Paciente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jbAtención.setText("Atención");
        jbAtención.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtenciónActionPerformed(evt);
            }
        });

        jbInternaciones.setText("Internaciones");
        jbInternaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInternacionesActionPerformed(evt);
            }
        });

        jbMedicar.setText("Medicar");
        jbMedicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMedicarActionPerformed(evt);
            }
        });

        jbGuardias.setText("Jefe de Guardia");
        jbGuardias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardiasActionPerformed(evt);
            }
        });

        jbEstadisticas.setText("Info Diara");
        jbEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEstadisticasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jbInternaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbAtención, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbGuardias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbEstadisticas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbMedicar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addContainerGap(235, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbAtención, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jbInternaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jbMedicar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jbGuardias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jbEstadisticas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Busqueda ingPaciente = new Busqueda(this, conexion);
        ingPaciente.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbAtenciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAtenciónActionPerformed
        try {
            SelecciondePaciente atenPaciente = new SelecciondePaciente(this, conexion, id_personal);
            atenPaciente.setVisible(true);
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbAtenciónActionPerformed

    private void jbInternacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInternacionesActionPerformed
        AdministrarInternaciones internacion = new AdministrarInternaciones(this, rootPaneCheckingEnabled, conexion);
        internacion.setVisible(true);
    }//GEN-LAST:event_jbInternacionesActionPerformed

    private void jbMedicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMedicarActionPerformed
        Medicar admMedicacion = new Medicar(this, conexion);
        admMedicacion.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jbMedicarActionPerformed

    private void jbGuardiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardiasActionPerformed
        OpcionesJefeGuardia opJefeGuardia = new OpcionesJefeGuardia(inicio,conexion);
                opJefeGuardia.setVisible(true);
                this.setVisible(false);
    }//GEN-LAST:event_jbGuardiasActionPerformed

    private void jbEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEstadisticasActionPerformed
InformeDiario infoDiario = new InformeDiario(inicio, conexion);
                infoDiario.setVisible(true);
                this.setVisible(false);
    }//GEN-LAST:event_jbEstadisticasActionPerformed
    private Connection conexion;
    private int id_personal;
    private Principal inicio;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jbAtención;
    private javax.swing.JButton jbEstadisticas;
    private javax.swing.JButton jbGuardias;
    private javax.swing.JButton jbInternaciones;
    private javax.swing.JButton jbMedicar;
    // End of variables declaration//GEN-END:variables
}
