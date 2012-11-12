
package Interfaces;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.SimpleTimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Recetar extends javax.swing.JDialog {
    private Connection con;
     private Statement st;
     private int idpaciente,idpersonal;
     private PreparedStatement ps;
     private  ResultSet res;
     private DefaultTableModel temp;
     
    /** Creates new form Recetar */
    public Recetar(java.awt.Frame parent, boolean modal,Connection con,int idpac, int idper) {
        super(parent, modal);
        this.con=con;
        this.idpaciente=idpac;
        this.idpersonal=idper;
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/Iconos/grafico.png"));
        this.temp=(DefaultTableModel) tablar.getModel();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablar = new javax.swing.JTable();
        jbBorrar = new javax.swing.JButton();
        jbGenerarReceta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jbAgregar.setText("Agregar Indicación");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        tablar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Remedio", "Tipo Remedio", "Indicación"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablar);

        jbBorrar.setText("Borrar Indicación");
        jbBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBorrarActionPerformed(evt);
            }
        });

        jbGenerarReceta.setText("Generar Receta");
        jbGenerarReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGenerarRecetaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                        .addComponent(jbBorrar)
                        .addGap(4, 4, 4))
                    .addComponent(jbGenerarReceta, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAgregar)
                    .addComponent(jbBorrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbGenerarReceta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        Indicacion in= new Indicacion(null, rootPaneCheckingEnabled,this.con);                
        int idremedio=in.devolverSeleccion();
        String ind;
        ind=in.devolverIndicacion();
                    
        try {            
            ps = con.prepareStatement("select * from remedios where id_remedio=?");            
            ps.setInt(1, idremedio);            
            res = ps.executeQuery();
            
            if(res.next()){
                
                
                String idrem = String.valueOf(res.getInt("id_remedio"));
                String desc = res.getString("desc_remedio");
                String tiporem= res.getString("tipo_remedio");
                
                Object o[] = {idrem,desc,tiporem,ind};
                temp.addRow(o);                             
          }
             
        } catch (SQLException ex) {
            Logger.getLogger(Recetar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbAgregarActionPerformed

    private void jbGenerarRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGenerarRecetaActionPerformed
        int i=JOptionPane.showConfirmDialog(rootPane, "¿Desea guardar los datos de la receta?", null, WIDTH);
        int id_receta;
        String indicacion,idremedio,fecha=null,fecha1 = null,tiempo=null;
        Time t1=null;
        
        if(i==0 && this.tablar.getRowCount()+1>0)
        {
            try {                
                PreparedStatement pss;
                    try {
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
                        
                        
                        tiempo=hora+":"+min+":"+seg;
                        
                        t1=Time.valueOf(tiempo);
                        
                        System.out.println("Hora: "+tiempo);
                        
                        pss = con.prepareStatement("INSERT INTO recetas( id_personal, id_paciente,fecha,hora)VALUES ('"+idpersonal+"','"+idpaciente+"','" +fecha+"','"+t1+"')");
                        pss.execute();
                    } catch (SQLException ex) {
                        Logger.getLogger(Recetar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                int fila;
                fila=0;
                
                pss = con.prepareStatement("select * from recetas where id_personal=? and id_paciente=? and fecha='"+fecha+"' and hora='"+t1+"'");            
                pss.setInt(1, idpersonal);
                pss.setInt(2, idpaciente);                 
                res = pss.executeQuery();
                
                if(res.next()){
                id_receta=res.getInt("id_receta");
                
                while (fila<tablar.getRowCount()){
                
                //Agrego a la tabla Prescripciones cada fila de los remedios recetados
                    
                    idremedio = tablar.getValueAt(fila, 0).toString();                
                    indicacion=tablar.getValueAt(fila, 3).toString().toUpperCase();             
                    pss = con.prepareStatement("INSERT INTO prescripciones(id_receta, id_remedio, indicacion)VALUES (?, ?, ?)");
                    pss.setInt(1, id_receta);
                    pss.setInt(2, Integer.parseInt(idremedio));                  
                    pss.setString(3, indicacion);
                    pss.execute();
                    fila=fila+1;
                 }
                 this.setVisible(false);
                }
               
            } catch (SQLException ex) {
                Logger.getLogger(Recetar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jbGenerarRecetaActionPerformed

    private void jbBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarActionPerformed
        // TODO add your handling code here:
         
        //Borro la fila seleccionada de la tabla
        if(tablar.getSelectedRow()+1>0){                        
             int fila=tablar.getSelectedRow();
             temp.removeRow(fila);                
        }
    }//GEN-LAST:event_jbBorrarActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbBorrar;
    private javax.swing.JButton jbGenerarReceta;
    private javax.swing.JTable tablar;
    // End of variables declaration//GEN-END:variables
}
