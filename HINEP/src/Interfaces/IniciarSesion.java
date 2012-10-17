package Interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class IniciarSesion extends javax.swing.JDialog {

    int i;
    Connection con;
    javax.swing.JFrame menu;
    
    public IniciarSesion(javax.swing.JFrame parent, boolean modal, Connection cn) {
        super(parent, modal);
        menu=parent;
        
        initComponents();
        
         /* int i=JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea cerrar el programa?", "Confirmación", 2);
          if(i==0){
              this.setVisible(false);
              menu.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
          }else{
              this.setVisible(true);
          }*/
          
        con=cn;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbIniciar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfUsuario = new javax.swing.JTextField();
        jtfContraseña = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jbIniciar.setText("Iniciar Sesión");
        jbIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbIniciarActionPerformed(evt);
            }
        });

        jLabel1.setText("Usuario:");

        jLabel2.setText("Contraseña:");

        jtfUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jbIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                            .addComponent(jtfUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))))
                .addGap(105, 105, 105))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jtfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jtfContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(106, 106, 106))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfUsuarioActionPerformed

    private void jbIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbIniciarActionPerformed
        String usuario,contraseña;
        if((!(jtfContraseña.getText().isEmpty()))&&(!(jtfUsuario.getText().isEmpty()))) {
                
                usuario=jtfUsuario.getText();
                contraseña=jtfContraseña.getText();
            
                
            try {
                
                PreparedStatement ps = con.prepareStatement("select id_usuario, id_personal, id_permiso, usuario, pass from usuarios where usuario=? and pass=?");
                
                ps.setString(1,usuario);
                ps.setString(2,contraseña);
                boolean encontrado;
                        encontrado = ps.execute();

                if(encontrado) {
                    
                    ResultSet res= ps.executeQuery();
                    if(res.next())
                    {
                        int id_per = res.getInt("id_personal");
                        int id_permiso = res.getInt("id_permiso");
                        PreparedStatement rec = con.prepareStatement("select * from personal where id_personal=?");
                        rec.setInt(1,id_per);
                        ResultSet recresp = rec.executeQuery();
                        recresp.next();
                        String nombre = recresp.getString("nombre");
                        String apellido = recresp.getString("apellido");
                        JOptionPane.showMessageDialog(rootPane, "Bienvenido "+nombre+" "+apellido+", puede comenzar su trabajo");
                        this.setVisible(false);
                        
                        
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "Nombre de usuario o contraseña invalido");
                    }
                    
                     
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Nombre de usuario o contraseña invalido");
                }
                } catch (SQLException ex) {
                Logger.getLogger(IniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }else{
            JOptionPane.showMessageDialog(rootPane, "Nombre de usuario o contraseña invalido");
        }
        
        
    }//GEN-LAST:event_jbIniciarActionPerformed

    
    
    
    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbIniciar;
    private javax.swing.JPasswordField jtfContraseña;
    private javax.swing.JTextField jtfUsuario;
    // End of variables declaration//GEN-END:variables
}