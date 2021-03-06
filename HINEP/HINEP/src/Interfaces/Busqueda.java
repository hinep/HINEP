/*
 * Busqueda.java
 *
 * Created on 11/10/2012, 21:02:17
 */
package Interfaces;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SySoft
 */
public class Busqueda extends javax.swing.JFrame {

    javax.swing.JFrame Menu;
    private boolean esPa;
    private int idPac;
    
    /** Creates new form Busqueda 
     *  para Paciente
     */
    public Busqueda(javax.swing.JFrame menu, Connection cn) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/Iconos/grafico.png"));
        this.conexion = cn;
        this.Menu = menu;
        this.esPa = true;
        jlRelleno.setVisible(false);
        jlDni.setVisible(false);
        jlNa.setVisible(false);
        jlSele.setVisible(false);
        grupodebotones.add(jrbDni);
        grupodebotones.add(jrbNombre);
        jrbDni.setSelected(true);
        jtfApellido.setDisabledTextColor(Color.red);
        jtfNombre.setDisabledTextColor(Color.red);
        jtfApellido.setEnabled(false);
        jtfNombre.setEnabled(false);
    }
    
    /** Creates new form Busqueda 
     *  para Tutor
     */
     public Busqueda(javax.swing.JFrame menu, Connection cn, int idPa) {
        initComponents();
        this.conexion = cn;
        this.Menu = menu;
        this.esPa = false;
        this.idPac = idPa;
        jlRelleno.setVisible(false);
        jlDni.setVisible(false);
        jlNa.setVisible(false);
        jlSele.setVisible(false);
        grupodebotones.add(jrbDni);
        grupodebotones.add(jrbNombre);
        jLabel1.setText("Buscar tutor por:");
        jrbDni.setSelected(true);
        jtfApellido.setDisabledTextColor(Color.red);
        jtfNombre.setDisabledTextColor(Color.red);
        jtfApellido.setEnabled(false);
        jtfNombre.setEnabled(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupodebotones = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jrbDni = new javax.swing.JRadioButton();
        jrbNombre = new javax.swing.JRadioButton();
        jtfDni = new javax.swing.JTextField();
        jtfNombre = new javax.swing.JTextField();
        jtfApellido = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabla = new javax.swing.JTable();
        jbSiguiente = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jbNuevo = new javax.swing.JButton();
        jlDni = new javax.swing.JLabel();
        jlRelleno = new javax.swing.JLabel();
        jlNa = new javax.swing.JLabel();
        jlSele = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setText("Buscar paciente por:");

        grupodebotones.add(jrbDni);
        jrbDni.setSelected(true);
        jrbDni.setText("DNI");
        jrbDni.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jrbDniStateChanged(evt);
            }
        });
        jrbDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbDniActionPerformed(evt);
            }
        });
        jrbDni.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jrbDniPropertyChange(evt);
            }
        });

        grupodebotones.add(jrbNombre);
        jrbNombre.setText("Nombre y Apellido");
        jrbNombre.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jrbNombreStateChanged(evt);
            }
        });
        jrbNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbNombreActionPerformed(evt);
            }
        });

        jtfDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfDniKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfDniKeyReleased(evt);
            }
        });

        jtfNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfNombreKeyReleased(evt);
            }
        });

        jtfApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfApellidoKeyReleased(evt);
            }
        });

        jbBuscar.setText("Buscar");
        jbBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbBuscarMouseClicked(evt);
            }
        });
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jtTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "DNI"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtTabla);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
        );

        jbSiguiente.setText("Siguiente");
        jbSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSiguienteActionPerformed(evt);
            }
        });

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jlDni.setForeground(new java.awt.Color(204, 0, 0));
        jlDni.setText(" *");

        jlRelleno.setForeground(new java.awt.Color(204, 0, 0));
        jlRelleno.setText("Rellene el campo marcado con *");

        jlNa.setForeground(new java.awt.Color(204, 0, 0));
        jlNa.setText(" *");

        jlSele.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlSele.setForeground(new java.awt.Color(204, 0, 0));
        jlSele.setText("* DEBE SELECCIONAR UN PACIENTE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(31, 31, 31)
                                .addComponent(jlRelleno)
                                .addGap(238, 238, 238))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(172, 172, 172)
                                .addComponent(jbCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jbSiguiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jlDni, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jrbDni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(69, 69, 69))
                            .addComponent(jtfDni))
                        .addGap(60, 60, 60)
                        .addComponent(jlNa, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfNombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jrbNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(1, 1, 1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfApellido, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(27, 27, 27))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jlSele)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlRelleno))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbDni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jrbNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDni)
                    .addComponent(jtfNombre)
                    .addComponent(jtfApellido)
                    .addComponent(jlDni)
                    .addComponent(jlNa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSiguiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jlSele)
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSiguienteActionPerformed
        jlSele.setVisible(false);
        //Controla si hay una fila seleccionada
        if(jtTabla.getSelectedRow()!= -1){
            //Controla si es busqueda de paciente
            if(esPa){
                //Toma el dni de la fila seleccionada y lo busca en la tabla paciente,
                //para obtener el id_paciente y pasarlo a la busqueda de tutor
                int indice = jtTabla.getSelectedRow();
                String dni = (String) jtTabla.getValueAt(indice, 2);
                PreparedStatement ps;
                try {
                    ps = conexion.prepareStatement("select id_paciente from pacientes where dni=?");
                    ps.setString(1, dni);
                    ResultSet res= ps.executeQuery();
                    if(res.next()){
                        this.idPac = res.getInt("id_paciente");
                        new Busqueda(this, conexion, idPac).setVisible(true);
                        this.setVisible(false);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Busqueda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                //En caso de ser Tutor pasa a la siguiente interfaz
                GenerarEspera ge = new GenerarEspera(Menu, this, conexion, this.idPac);
                ge.setVisible(true);
                this.setVisible(false);
            }
        }else{
            jlSele.setVisible(true);
        }
    }//GEN-LAST:event_jbSiguienteActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        int i = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que desea cancelar el ingreso de un nuevo paciente?", "Confirmación", WIDTH);
        //Si cancela el ingreso del paciente vuelve al menu
        if(esPa){
            if(i == 0){
                jtfDni.setText("");
                jtfApellido.setText("");
                jtfNombre.setText("");
                //Se eliminan las posibles filas de una búsqueda anterior
                DefaultTableModel temp = (DefaultTableModel) jtTabla.getModel();
                while(temp.getRowCount()-1>=0){
                    temp.removeRow(0);
                }
            }
        }else{
            if(i == 0){
                new Busqueda(Menu, conexion).setVisible(true);
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        //Comprueba si se desea ingresar un nuevo paciente o un nuevo tutor
        if(esPa){
            NuevoPaciente nu = new NuevoPaciente(this, rootPaneCheckingEnabled,conexion);
            nu.setVisible(true);
        }else{
            NuevoTutor nt = new NuevoTutor(this, rootPaneCheckingEnabled, conexion);
            nt.setVisible(true);
        }
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jrbNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbNombreActionPerformed
        jtfDni.setEnabled(false);
        jtfNombre.setEnabled(true);
        jtfApellido.setEnabled(true);
        this.repaint();
    }//GEN-LAST:event_jrbNombreActionPerformed

    private void jrbDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbDniActionPerformed
        jtfDni.setEnabled(true);
        jtfNombre.setEnabled(false);
        jtfApellido.setEnabled(false);
        this.repaint();
    }//GEN-LAST:event_jrbDniActionPerformed

    private void jbBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbBuscarMouseClicked
         buscar();
    }//GEN-LAST:event_jbBuscarMouseClicked

    private void jrbDniPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jrbDniPropertyChange

    }//GEN-LAST:event_jrbDniPropertyChange

    private void jrbDniStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jrbDniStateChanged
        //Si no esta seleccionado DNI se borra lo que haya en el campo de texto
        if(!jrbDni.isSelected()) {
            jtfDni.setText(null);
        }
    }//GEN-LAST:event_jrbDniStateChanged

    private void jrbNombreStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jrbNombreStateChanged
       // Si no esta seleccionado Nombre y Apellido se borra el contenido
       // de los campos de texto
        if(!jrbNombre.isSelected()) {
            jtfNombre.setText(null);
            jtfApellido.setText(null);
        }
    }//GEN-LAST:event_jrbNombreStateChanged

    private void jtfDniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDniKeyPressed
    }//GEN-LAST:event_jtfDniKeyPressed

    private void jtfDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDniKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            buscar();
        }
    }//GEN-LAST:event_jtfDniKeyReleased

    private void jtfNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNombreKeyReleased
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            buscar();
        }
    }//GEN-LAST:event_jtfNombreKeyReleased

    private void jtfApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfApellidoKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            buscar();
        }
    }//GEN-LAST:event_jtfApellidoKeyReleased

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbBuscarActionPerformed

    private Connection conexion;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup grupodebotones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbSiguiente;
    private javax.swing.JLabel jlDni;
    private javax.swing.JLabel jlNa;
    private javax.swing.JLabel jlRelleno;
    private javax.swing.JLabel jlSele;
    private javax.swing.JRadioButton jrbDni;
    private javax.swing.JRadioButton jrbNombre;
    private javax.swing.JTable jtTabla;
    private javax.swing.JTextField jtfApellido;
    private javax.swing.JTextField jtfDni;
    private javax.swing.JTextField jtfNombre;
    // End of variables declaration//GEN-END:variables

    private void buscar() {
        jlRelleno.setVisible(false);
        jlDni.setVisible(false);
        jlNa.setVisible(false);
        //Se eliminan las posibles filas de una búsqueda anterior
        DefaultTableModel temp = (DefaultTableModel) jtTabla.getModel();
        while(temp.getRowCount()-1>=0){
            temp.removeRow(0);
        }
        //Comprueba si está seleccionada la busqueda por DNI o Nombre y Apellido
        if(jrbDni.isSelected()){
            //Comprueba que el campo de texto no sea vacio
            if(!jtfDni.getText().equals("")){
                //Comprueba si se busca un paciente o un tutor
                if(esPa){
                    buscarPacienteDni();
                }else{
                    buscarTutorDni();
                }
            }else{
                jlRelleno.setVisible(true);
                jlDni.setVisible(true);
            }
        }else{
            //Comprueba que por lo menos un campo de texto no sea vacio
            if(!jtfNombre.getText().equals("") || !jtfApellido.getText().equals("")){
                //Comprueba si se busca un paciente o un tutor
                if(esPa){
                    buscarPacienteNa();
                }else{
                    buscarTutorNa();
                }                    
            }else{
                jlRelleno.setVisible(true);
                jlNa.setVisible(true);
            }
        }
    }

    private void buscarPacienteDni() {
        try {
            //Se hace una consulta a la BBDD buscando al paciente
            DefaultTableModel temp = (DefaultTableModel) jtTabla.getModel();
            PreparedStatement ps;
            String doc = jtfDni.getText();
            ps = conexion.prepareStatement("select nom_1, nom_2, ape_1, ape_2, dni from pacientes where dni=?");
            ps.setString(1, doc);
            //Si la consulta se ejecuta correctamente se agregan los resultados a la tabla
            if(ps.execute()){
                ResultSet res= ps.executeQuery();
                while(res.next()){
                    String nombre;
                    String apellido;
                    nombre = res.getString("nom_1")+" "+res.getString("nom_2");
                    apellido = res.getString("ape_1")+" "+res.getString("ape_2");
                    String dni = res.getString("dni");
                    Object o[] = {nombre,apellido,dni};
                    temp.addRow(o);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Busqueda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void buscarTutorDni() {
        try {
            //Se hace una consulta a la BBDD buscando al tutor
            DefaultTableModel temp = (DefaultTableModel) jtTabla.getModel();
            PreparedStatement ps;
            String doc = jtfDni.getText();
            ps = conexion.prepareStatement("select nom_1, nom_2, ape_1, ape_2, dni from tutores where dni=?");
            ps.setString(1, doc);
            //Si la consulta se ejecuta correctamente se agregan los resultados a la tabla
            if(ps.execute()){
                ResultSet res= ps.executeQuery();
                while(res.next()){
                    String nombre;
                    String apellido;
                    nombre = res.getString("nom_1")+" "+res.getString("nom_2");
                    apellido = res.getString("ape_1")+" "+res.getString("ape_2");
                    String dni = res.getString("dni");
                    Object o[] = {nombre,apellido,dni};
                    temp.addRow(o);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Busqueda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void buscarPacienteNa() {
        try {
            //Crea vectores con nombres y apelldios
            String[] nombres = jtfNombre.getText().split(" ");
            String[] apellidos = jtfApellido.getText().split(" ");
            PreparedStatement ps = null;
            DefaultTableModel temp = (DefaultTableModel) jtTabla.getModel();
            //Se comprueba si los vectores tienen longitud 1
            if(nombres.length == 1 && apellidos.length == 1){
                if(!nombres[0].equals("") && !apellidos[0].equals("")){
                    ps = conexion.prepareStatement("select nom_1, nom_2, ape_1, ape_2, dni from pacientes where nom_1 like ? and ape_1 like ?");
                    ps.setString(1, "%"+nombres[0].toUpperCase()+"%");
                    ps.setString(2, apellidos[0].toUpperCase());
                }
                if(!nombres[0].equals("")){
                    ps = conexion.prepareStatement("select nom_1, nom_2, ape_1, ape_2, dni from pacientes where nom_1 like ?");
                    ps.setString(1, "%"+nombres[0].toUpperCase()+"%");
                }
                if(!apellidos[0].equals("")){
                    ps = conexion.prepareStatement("select nom_1, nom_2, ape_1, ape_2, dni from pacientes where ape_1 like ?");
                    ps.setString(1, apellidos[0].toUpperCase());
                }
            }else{
                //Se comprueba si los vectores tienen longitud mayor a 1
                if(nombres.length > 1 && apellidos.length > 1){
                    if(!nombres[0].equals("") && !apellidos[0].equals("") && !nombres[1].equals("") && !apellidos[1].equals("")){
                        ps = conexion.prepareStatement("select nom_1, nom_2, ape_1, ape_2, dni from pacientes where nom_1 like ? and ape_1 like ? and nom_2 like ? and ape_2 like ?");
                        ps.setString(1, "%"+nombres[0].toUpperCase()+"%");
                        ps.setString(2, apellidos[0].toUpperCase());
                        ps.setString(3, "%"+nombres[1].toUpperCase()+"%");
                        ps.setString(4, apellidos[1].toUpperCase());
                    }
                }
                    //Se comprueba si el vector nombres tiene más de un elemento
                    if(nombres.length > 1){
                        if(!nombres[0].equals("") && !nombres[1].equals("")){
                            ps = conexion.prepareStatement("select nom_1, nom_2, ape_1, ape_2, dni from pacientes where nom_1 like ? and nom_2 like ?");
                            ps.setString(1, "%"+nombres[0].toUpperCase()+"%");
                            ps.setString(2, "%"+nombres[1].toUpperCase()+"%");
                        }
                    }
                    if(apellidos.length > 1){
                        if(!apellidos[0].equals("") && !apellidos[1].equals("")){
                            ps = conexion.prepareStatement("select nom_1, nom_2, ape_1, ape_2, dni from pacientes where ape_1 like ? and ape_2 like ?");
                            ps.setString(1, apellidos[0].toUpperCase());
                            ps.setString(2, apellidos[1].toUpperCase());
                        }
                    }
            }
            //Si la consulta no es null se agregan los resultados a la tabla
            if(!(ps == null)){
                ResultSet res= ps.executeQuery();
                while(res.next()){
                    String nombre;
                    String apellido;
                    nombre = res.getString("nom_1")+" "+res.getString("nom_2");
                    apellido = res.getString("ape_1")+" "+res.getString("ape_2");
                    String dni = res.getString("dni");
                    Object o[] = {nombre,apellido,dni};
                    temp.addRow(o);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Busqueda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void buscarTutorNa() {
        try {
            //Crea vectores con nombres y apelldios
            String[] nombres = jtfNombre.getText().split(" ");
            String[] apellidos = jtfApellido.getText().split(" ");
            PreparedStatement ps = null;
            DefaultTableModel temp = (DefaultTableModel) jtTabla.getModel();
            //Se comprueba si los vectores tienen longitud 1
            if(nombres.length == 1 && apellidos.length == 1){
                if(!nombres[0].equals("") && !apellidos[0].equals("")){
                    ps = conexion.prepareStatement("select nom_1, nom_2, ape_1, ape_2, dni from tutores where nom_1 like ? and ape_1 like ?");
                    ps.setString(1, "%"+nombres[0].toUpperCase()+"%");
                    ps.setString(2, apellidos[0].toUpperCase());
                }
                if(!nombres[0].equals("")){
                    ps = conexion.prepareStatement("select nom_1, nom_2, ape_1, ape_2, dni from tutores where nom_1 like ?");
                    ps.setString(1, "%"+nombres[0].toUpperCase()+"%");
                }
                if(!apellidos[0].equals("")){
                    ps = conexion.prepareStatement("select nom_1, nom_2, ape_1, ape_2, dni from tutores where ape_1 like ?");
                    ps.setString(1, apellidos[0].toUpperCase());
                }
            }else{
                //Se comprueba si los vectores tienen longitud mayor a 1
                if(nombres.length > 1 && apellidos.length > 1){
                    if(!nombres[0].equals("") && !apellidos[0].equals("") && !nombres[1].equals("") && !apellidos[1].equals("")){
                        ps = conexion.prepareStatement("select nom_1, nom_2, ape_1, ape_2, dni from tutores where nom_1 like ? and ape_1 like ? and nom_2 like ? and ape_2 like ?");
                        ps.setString(1, "%"+nombres[0].toUpperCase()+"%");
                        ps.setString(2, apellidos[0].toUpperCase());
                        ps.setString(3, "%"+nombres[1].toUpperCase()+"%");
                        ps.setString(4, apellidos[1].toUpperCase());
                    }
                }
                    //Se comprueba si el vector nombres tiene más de un elemento
                    if(nombres.length > 1){
                        if(!nombres[0].equals("") && !nombres[1].equals("")){
                            ps = conexion.prepareStatement("select nom_1, nom_2, ape_1, ape_2, dni from tutores where nom_1 like ? and nom_2 like ?");
                            ps.setString(1, "%"+nombres[0].toUpperCase()+"%");
                            ps.setString(2, "%"+nombres[1].toUpperCase()+"%");
                        }
                    }
                    if(apellidos.length > 1){
                        if(!apellidos[0].equals("") && !apellidos[1].equals("")){
                            ps = conexion.prepareStatement("select nom_1, nom_2, ape_1, ape_2, dni from tutores where ape_1 like ? and ape_2 like ?");
                            ps.setString(1, apellidos[0].toUpperCase());
                            ps.setString(2, apellidos[1].toUpperCase());
                        }
                    }
            }
            //Si la consulta no es null se agregan los resultados a la tabla
            if(!(ps == null)){
                ResultSet res= ps.executeQuery();
                while(res.next()){
                    String nombre;
                    String apellido;
                    nombre = res.getString("nom_1")+" "+res.getString("nom_2");
                    apellido = res.getString("ape_1")+" "+res.getString("ape_2");
                    String dni = res.getString("dni");
                    Object o[] = {nombre,apellido,dni};
                    temp.addRow(o);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Busqueda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
