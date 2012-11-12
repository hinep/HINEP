package Interfaces;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Principal.java
 *
 * Created on 11/10/2012, 20:41:53
 */
/**
 *
 * @author SySoft
 */
public class Principal extends javax.swing.JFrame {

    private Connection conexion;
    private Statement st;
    private String usuario;
    private String pass;
    private int permiso;
    private int id_personal;

    public Principal() throws ClassNotFoundException, SQLException {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        noError();
        iniciarConBD();
        jbIniciar.addKeyListener(new PresionarTecla());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jbIniciar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfUsuario = new javax.swing.JTextField();
        jtfPass = new javax.swing.JPasswordField();
        jlbAsterisco1 = new javax.swing.JLabel();
        jlbAsterisco2 = new javax.swing.JLabel();
        jlbError1 = new javax.swing.JLabel();
        jlbError2 = new javax.swing.JLabel();
        jlbError3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");

        jLabel1.setFont(new java.awt.Font("SansSerif", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestión De Servicio de Guardia  ");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbIniciar.setText("Iniciar Sesión");
        jbIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbIniciarActionPerformed(evt);
            }
        });

        jLabel3.setText("Usuario:");

        jLabel2.setText("Contraseña:");

        jtfUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfUsuarioActionPerformed(evt);
            }
        });

        jlbAsterisco1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jlbAsterisco1.setForeground(new java.awt.Color(204, 0, 0));
        jlbAsterisco1.setText("*");

        jlbAsterisco2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jlbAsterisco2.setForeground(new java.awt.Color(204, 0, 0));
        jlbAsterisco2.setText("*");

        jlbError1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jlbError1.setForeground(new java.awt.Color(204, 0, 0));
        jlbError1.setText("* Campo obligatorio");

        jlbError2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jlbError2.setForeground(new java.awt.Color(204, 0, 0));
        jlbError2.setText(" USUARIO O CONTRASEÑA NO VALIDOS");

        jlbError3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jlbError3.setForeground(new java.awt.Color(204, 0, 0));
        jlbError3.setText("HORARIO NO VALIDO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jlbError2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jlbError3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(53, 53, 53)))
                .addGap(71, 71, 71))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlbError1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(163, 163, 163))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(jbIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfPass)
                                    .addComponent(jtfUsuario))))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlbAsterisco1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlbAsterisco2))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbError3, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(jlbError2, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jlbAsterisco1, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfUsuario)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jlbAsterisco2, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfPass)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(30, 30, 30)
                .addComponent(jbIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbError1, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbIniciarActionPerformed

        this.usuario = jtfUsuario.getText();
        this.pass = new String(jtfPass.getPassword());
        noError();

        // Si el usuario o la contraseña están vacias
        if (usuario.equals("") || pass.equals("")) {
            // Si el usuario y la contraseña están vacias
            if (usuario.equals("") && pass.equals("")) {
                jlbAsterisco1.setVisible(true);
                jlbAsterisco2.setVisible(true);

            } else if (usuario.equals("")) {
                // Si el usuario está vacio
                jlbAsterisco1.setVisible(true);

            } else {
                // Si la contraseña está vacia
                jlbAsterisco2.setVisible(true);

            }
            jlbError1.setVisible(true);
        } else {
            try {
                ResultSet rs;
                rs = st.executeQuery("SELECT * FROM usuarios WHERE usuario = '" + usuario + "' and pass = '" + pass + "'");
                // Es un usuario existente
                if (rs.next()) {
                    // Formato de la fecha
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    // Obtengo la fecha del sistema (hoy)
                    Date fechaSistema = new Date();
                    String fecha = sdf.format(fechaSistema);
                    // Obtengo el id_permiso del usuario
                    permiso = rs.getInt(3);
                    // Obtengo el id_personal del usuario
                    id_personal = rs.getInt(2);
                    rs = st.executeQuery("SELECT * FROM guardias WHERE id_personal = '" + id_personal + "' and fecha = '" + fecha + "'");
                    // Verifico que ese usuario est{e de guardia hoy
                    if (rs.next()) {
                        // Si está de guardia, ingresa
                        ingresar();
                    } else {
                        rs = st.executeQuery("SELECT * FROM personal WHERE id_personal = '" + id_personal + "' and id_cargo = 9");
                        if (rs.next()) {
                            // Si es el jefe de guardia, puede ingresar en cualquier momento
                            ingresar();
                        } else {
                            // Si no, es un usuario en HORARIO NO PERMITIDO
                            jlbError3.setVisible(true);
                        }
                    }

                } else {
                    // Error en el ingreso de usuario / contraseña
                    jlbError2.setVisible(true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_jbIniciarActionPerformed

    private void jtfUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfUsuarioActionPerformed

    private void iniciarConBD() throws ClassNotFoundException, SQLException {
        // Conexión a la base de datos
        Class.forName("org.postgresql.Driver");
        conexion = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/hinep", "postgres", "admin");
        st = conexion.createStatement();
    }

    private void ingresar() {
        // Según el permiso de usuario, podrá acceder al sector correspondiente
        switch (permiso) {
            case 0:
                // Usuario Administrador
                Menu menu = new Menu(conexion, id_personal, this);
                menu.setVisible(true);
                break;
            case 1:
                // Usuario del sector de admisión de la guardia
                Busqueda ingPaciente = new Busqueda(this, conexion);
                ingPaciente.setVisible(true);
                break;
            case 2:
                // Usuario del sector de atención en consultorio
                SelecciondePaciente atenPaciente;
                try {
                    atenPaciente = new SelecciondePaciente(this, conexion, id_personal);
                    atenPaciente.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 3:
                // Usuario de enfermería
                Medicar admMedicacion = new Medicar(this, conexion, id_personal);
                admMedicacion.setVisible(true);
                break;
            case 4:
                // Usuario de internaciones transitorias de la guardia
                AdministrarInternaciones internacion = new AdministrarInternaciones(this, conexion, id_personal);
                internacion.setVisible(true);
                break;
            case 5:
                // Jefe de guardia
                OpcionesJefeGuardia opJefeGuardia = new OpcionesJefeGuardia(this, conexion);
                opJefeGuardia.setVisible(true);
                break;
            case 6:
                // Jefe de Servicio
                InformeDiario infoDiario = new InformeDiario(this, conexion);
                infoDiario.setVisible(true);
                break;
        }
        this.setVisible(false);
    }

    protected void blanquear() {
        jtfUsuario.setText("");
        jtfPass.setText("");
    }

    private void noError() {
        jlbAsterisco1.setVisible(false);
        jlbAsterisco2.setVisible(false);
        jlbError1.setVisible(false);
        jlbError2.setVisible(false);
        jlbError3.setVisible(false);
    }

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Principal().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    public class PresionarTecla extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent ke) {
            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                jbIniciarActionPerformed(null);
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbIniciar;
    private javax.swing.JLabel jlbAsterisco1;
    private javax.swing.JLabel jlbAsterisco2;
    private javax.swing.JLabel jlbError1;
    private javax.swing.JLabel jlbError2;
    private javax.swing.JLabel jlbError3;
    private javax.swing.JPasswordField jtfPass;
    private javax.swing.JTextField jtfUsuario;
    // End of variables declaration//GEN-END:variables
}
