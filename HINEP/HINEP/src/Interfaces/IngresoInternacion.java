/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IngresoInternacion.java
 *
 * Created on 12/10/2012, 20:42:53
 */
package Interfaces;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SySoft
 */
public class IngresoInternacion extends javax.swing.JDialog {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet res;   
    private int idpaciente,idpersonal;
    
    /** Creates new form IngresoInternacion */
    public IngresoInternacion(java.awt.Frame parent, boolean modal,Connection con,int idpaciente,int idpersonal) {
        super(parent, modal);
        this.con=con;
        this.idpaciente=idpaciente;
        this.idpersonal=idpersonal;                              
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/Iconos/grafico.png"));
        jbInternar.setEnabled(false);
        
        try {            
            ps = con.prepareStatement("select * from camas where disponible='TRUE' order by id_cama");                    
            res = ps.executeQuery();
            if(res.next()==false){
                    JOptionPane.showMessageDialog(rootPane, "No hay camas disponibles");                
                }
            else{
                int idcama;
                String nrohab;
                ps = con.prepareStatement("select * from camas where disponible='TRUE'");                    
                res = ps.executeQuery();
                DefaultTableModel temp = (DefaultTableModel) tablar.getModel();
                while(res.next()){
                    idcama=res.getInt(1);
                    nrohab=res.getString(2);
                    Object o[] = {idcama,nrohab};
                    temp.addRow(o);
                }
                jbInternar.setEnabled(true);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(IngresoInternacion.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablar = new javax.swing.JTable();
        jbInternar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        tablar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo de cama", "Número de habitación"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablar);

        jbInternar.setText("Generar Internación");
        jbInternar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInternarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(jbInternar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jbInternar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jbInternarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInternarActionPerformed
        Time t1;
        String tiempo,fecha;
        int idserv=0;
        
        if(tablar.getSelectedRow()+1>0){           
            try {
                int pos1 = tablar.getSelectedRow();                
                String idcam = tablar.getValueAt(pos1, 0).toString();    
                
                int id_cama=Integer.parseInt(idcam);
                
                ps = con.prepareStatement("UPDATE camas SET disponible='FALSE' WHERE id_cama="+Integer.parseInt(idcam));                
                ps.execute();                               
                
                // Obtengo la fecha del sistema 
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");                       
                        java.util.Date fechaSistema = new java.util.Date();                                              
                        fecha = sdf.format(fechaSistema);
                                                
                        // Obtengo la hora del sistema (hoy)
                        Calendar calendario=Calendar.getInstance();
                        String hora,min,seg;
                        hora =String.valueOf(calendario.get(Calendar.HOUR_OF_DAY));
                        min = String.valueOf(calendario.get(Calendar.MINUTE));
                        seg = String.valueOf(calendario.get(Calendar.SECOND));
                        
                        //Obtengo el id del servicio
                        ps = con.prepareStatement("select * from ordenes_practicas where id_paciente="+idpaciente+" and fecha='"+fecha+"'");                    
                        res = ps.executeQuery();
                        
                        if(res.next()){
                            int idprac=res.getInt(2);
                            
                            ps = con.prepareStatement("select * from practicas_servicios where id_practica_servicio="+idprac);                    
                            res = ps.executeQuery();
                            
                            if(res.next()){
                                idserv=res.getInt(2);
                            }
                            System.out.println("Id Servicio en II: "+idserv);
                        }
                        
                        tiempo=hora+":"+min+":"+seg;
                        
                        t1=Time.valueOf(tiempo);
                        
                        ps = con.prepareStatement("INSERT INTO internaciones_transitorias(id_servicio, id_cama, id_paciente, id_pers_ing,fecha_ing, hora_ing)VALUES ("+idserv+","+id_cama+" ,"+this.idpaciente+","+this.idpersonal+",'"+fecha+"','"+t1+"')");
                        ps.execute();
                       
                        
                
            } catch (SQLException ex) {
                Logger.getLogger(IngresoInternacion.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Debe seleccionar al menos una cama, o no hay camas disponibles", null, WIDTH);
        }
        
        
        this.setVisible(false);
    }//GEN-LAST:event_jbInternarActionPerformed

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbInternar;
    private javax.swing.JTable tablar;
    // End of variables declaration//GEN-END:variables
}
