package Interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SelecciondePaciente extends javax.swing.JFrame {

    javax.swing.JFrame Menu;
    Connection con;
    String nombre,apellido,fecha,prioridad;
    int dni,id_paciente,id_espera;
    int i,controlespera;
    ResultSet res;
    PreparedStatement ps;
    
    public SelecciondePaciente(javax.swing.JFrame menu, Connection cn) throws SQLException {
        initComponents();
        Menu=menu;
        con=cn;
        i=0;
        controlespera=0;
        ps = con.prepareStatement("select * from esperas where estado='No Atendido' order by nivel_imp");
        
        res = ps.executeQuery();
        while(res.next())
        {
                PreparedStatement pa = con.prepareStatement("select * from pacientes where id_paciente=?");
                id_paciente = res.getInt("id_paciente");
                pa.setInt(1, id_paciente);
                ResultSet res1 = pa.executeQuery();
                res1.next();

                Object[][] m=new Object[tabla.getRowCount()+1][tabla.getColumnCount()];
                for(int i=0;i<tabla.getColumnCount();i++)
                for(int j=0;j<tabla.getRowCount();j++)
                   m[j][i]=tabla.getValueAt(j, i);
                tabla.setModel(new DefaultTableModel(m,new String[]{"Nombre", "Apellido","DNI","Edad","Prioridad"}));

                nombre = res1.getString("nom_1")+" "+res1.getString("nom_2");
                apellido = res1.getString("ape_1")+" "+res1.getString("ape_2");
                dni = res1.getInt("dni");
                fecha = res1.getString("fecha_nac");
                prioridad = res.getString("nivel_imp");
                
                m[i][0] = nombre;
                m[i][1] = apellido;
                m[i][2] = dni;
                m[i][3] = fecha;
                m[i][4] = prioridad;
                
                tabla.setModel(new DefaultTableModel(m,new String[]{"Nombre", "Apellido","DNI","Edad","Prioridad"}));
                i++;
                controlespera=1;
                jbAtender.setEnabled(true);
        }
        
        if(controlespera==0)
        {
            JOptionPane.showMessageDialog(rootPane, "No hay esperas pendientes");
            jbAtender.setEnabled(false);
            jbBorrar.setEnabled(false);
        }
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jbAtender = new javax.swing.JButton();
        jbBorrar = new javax.swing.JButton();
        jbAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "DNI", "Edad", "Prioridad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        jbAtender.setText("Atender");
        jbAtender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtenderActionPerformed(evt);
            }
        });

        jbBorrar.setText("Borrar");

        jbAtras.setText("Atras");
        jbAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jbAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbAtender, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAtender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbAtras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
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

    private void jbAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAtrasActionPerformed
        Menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jbAtrasActionPerformed

    private void jbAtenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAtenderActionPerformed
        
        if(tabla.getSelectedRow()+1>0)
        {
            int[] j = tabla.getSelectedRows();
            if(j.length==1)
            {
                int pos = tabla.getSelectedRow();
                nombre = (String)tabla.getValueAt(pos, 0);
                try {
                    res = ps.executeQuery();
                    res.next();
                    int cont=0;
                    while(cont!=pos)
                    {
                        res.next();
                        cont++;
                    }
                
                int id = res.getInt("id_esperas");
                Atencion at= new Atencion(Menu,this,con,id);
                at.setVisible(true);
                this.setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(SelecciondePaciente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Debe seleccionar solo una fila, de lo contrario no podra continuar");
            }
        }else{
                JOptionPane.showMessageDialog(rootPane, "Debe seleccionar una fila, de lo contrario no podra continuar");
        
        }
        
        
        
    }//GEN-LAST:event_jbAtenderActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAtender;
    private javax.swing.JButton jbAtras;
    private javax.swing.JButton jbBorrar;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
