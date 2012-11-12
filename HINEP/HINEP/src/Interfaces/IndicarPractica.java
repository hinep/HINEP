/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IndicarPractica.java
 *
 * Created on 12/10/2012, 20:33:53
 */
package Interfaces;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SySoft
 */
public class IndicarPractica extends javax.swing.JDialog {
    
    private Connection con;
    private PreparedStatement ps;
    private ResultSet res;    
    private int idpersonal,idpaciente;
    public int id_servicio;
    String tipopra,servicio;
    
    
    /** Creates new form IndicarPractica */
    public IndicarPractica(java.awt.Frame parent, boolean modal,Connection con,int idpaciente,int idpersonal) {
        super(parent, modal);
        this.con=con; 
        this.idpaciente=idpaciente;
        this.idpersonal=idpersonal;
        this.tipopra="";
        this.servicio=""; 
        this.id_servicio=0;
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/Iconos/grafico.png"));
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfTipopra = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablar = new javax.swing.JTable();
        jbGenerar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel1.setText("Tipo de Practica:");

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        tablar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo de Practica", "Servicio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablar);

        jbGenerar.setText("Generar Práctica");
        jbGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGenerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfTipopra, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(jbGenerar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfTipopra)
                    .addComponent(jbBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jbGenerar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jbGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGenerarActionPerformed
        int i=JOptionPane.showConfirmDialog(rootPane, "¿Desea guardar los datos de la practica a realizar al paciente?", null, WIDTH);
        String fecha;
        int idpractica=0;
        
        if(i==0 && this.tablar.getRowCount()+1>0)
        {
            try {
                // Obtengo la fecha del sistema 
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");                       
                java.util.Date fechaSistema = new java.util.Date();                                              
                fecha = sdf.format(fechaSistema);
                
                
                int pos1 = tablar.getSelectedRow();                
                tipopra = tablar.getValueAt(pos1, 0).toString().toUpperCase();                
                
                ps = con.prepareStatement("select * from practicas_servicios where tipo_practica=?");            
                ps.setString(1,tipopra);
                res = ps.executeQuery();
                
                if(res.next()){
                    idpractica=res.getInt(1);
                    
                }
                int ids=res.getInt(2);//Este anda bien id_servicio
                setServicio(ids);
                
                ps = con.prepareStatement("INSERT INTO ordenes_practicas(id_practica_servicio, id_personal, id_paciente, fecha)VALUES ("+idpractica+","+idpersonal+","+idpaciente+",'"+fecha+"')");
                ps.execute();
                
                
                /*ps = con.prepareStatement("select id_orden from ordenes_practicas where id_practica_servicio=? and id_personal=? and id_paciente=? and fecha=?");
                ps.setInt(1,idpractica);
                ps.setInt(2,idpersonal);
                ps.setInt(3,idpaciente);
                ps.setDate(4,Date.valueOf(fecha));
                res = ps.executeQuery();
                
                int idorden;
                
                if(res.next()){
                    idorden=res.getInt(1);
                }*/
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(IndicarPractica.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
            
            
        }
        
        
        this.setVisible(false);
        
    }//GEN-LAST:event_jbGenerarActionPerformed
    
    public void setServicio(int ids){
        this.id_servicio=ids;
    } 
    
    public int devolverServicio(){  
        System.out.println("Id del Servicio en devolverServicio(): "+this.id_servicio); 
        return this.id_servicio;        
    }
     
    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        // TODO add your handling code here:
        
        if(jtfTipopra.getText().equals("")){          
            JOptionPane.showMessageDialog(rootPane, "Ingrese el Tipo de Práctica a buscar", null, WIDTH);            
           }
        else{
            try {
                String practica=jtfTipopra.getText().toUpperCase();
                ps = con.prepareStatement("select * from practicas_servicios where tipo_practica like ?");            
                ps.setString(1, "%"+practica+"%");                
                res = ps.executeQuery();
            
            if(res.next()==false){
                JOptionPane.showMessageDialog(rootPane, "El remedio ingresado o el tipo no coinciden. Verifique los datos ingresados ");                
             }
            else{                
                ps = con.prepareStatement("select * from practicas_servicios where tipo_practica like ?");            
                ps.setString(1, "%"+practica+"%");                
                res = ps.executeQuery();
                        
                ResultSet res1; 
                DefaultTableModel temp = (DefaultTableModel) tablar.getModel();
                while(temp.getRowCount()-1>=0){
                        temp.removeRow(0);
                    }
                                          
                while(res.next())
               {                  
                ps = con.prepareStatement("select * from servicios where id_servicio=?");            
                int idserv=res.getInt("id_servicio");                              
                ps.setInt(1,idserv);                
                res1 = ps.executeQuery();
                
                
                tipopra = res.getString("tipo_practica");
                                                                           
                if(res1.next()){
                    servicio=res1.getString(2);
                }
                                
                                
                Object o[] = {tipopra,servicio};
                temp.addRow(o);
               } 
            }
            
            } catch (SQLException ex) {
                Logger.getLogger(IndicarPractica.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            }
    }//GEN-LAST:event_jbBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbGenerar;
    private javax.swing.JTextField jtfTipopra;
    private javax.swing.JTable tablar;
    // End of variables declaration//GEN-END:variables
}
