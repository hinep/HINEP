package Interfaces;

import Engine.Paciente;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Atencion extends javax.swing.JFrame {

    private javax.swing.JFrame Menu, Selec;
    private int id_esperas,id_paciente,pos,controlespera;
    private Connection con;
    private PreparedStatement ps,pa,pe,pi,po,pu,ps2;
    private ResultSet res,res1,res2,res3,res4;
    private Paciente pac;
    private int id_personal;
    
    public Atencion(javax.swing.JFrame menu, javax.swing.JFrame selec,Connection cn, int id_esp, int id_per) throws SQLException {
        initComponents();
        Menu = menu;
        Selec=selec;
        id_esperas=id_esp;
        con=cn;
        id_personal=id_per;
        ps = con.prepareStatement("select * from esperas where id_esperas=?");
        ps.setInt(1, id_esperas);        
        res = ps.executeQuery();
        res.next();
        pa = con.prepareStatement("select * from pacientes where id_paciente=?");
        id_paciente = res.getInt("id_paciente");
        pa.setInt(1, id_paciente);
        res1 = pa.executeQuery();
        res1.next();
        
        pe = con.prepareStatement("select * from obras_sociales where id_os=?");
        pe.setInt(1, res1.getInt("id_os"));
        res2 = pe.executeQuery();
        res2.next();
        
        Paciente p = new Paciente(res1.getString("nom_1"), res1.getString("nom_2"), res1.getString("ape_1"), res1.getString("ape_2"), res1.getString("dni"), res1.getString("fecha_nac"), res1.getString("sexo"), res1.getInt("id_os"), res1.getString("numero_os"), res1.getString("domicilio"));
        pac=p;
        String fecha_nac=res1.getString("fecha_nac");
        
        
        jtfNombre.setText(pac.getNombre1()+" "+pac.getNombre2()+" "+pac.getApellido1()+" "+pac.getApellido2());
        jtfEdad.setText(String.valueOf(pac.calcularEdad()));
        jtfSexo.setText(pac.getSexo());
        jtfObraSocial.setText(res2.getString("nombre_os"));
        jtfNumSoc.setText(pac.getNomObraSocial());
        
        jtfNombre.setDisabledTextColor(Color.BLACK);
        jtfEdad.setDisabledTextColor(Color.BLACK);
        jtfSexo.setDisabledTextColor(Color.BLACK);
        jtfObraSocial.setDisabledTextColor(Color.BLACK);
        jtfNumSoc.setDisabledTextColor(Color.BLACK);
        jtfNombre.disable();
        jtfEdad.disable();
        jtfSexo.disable();
        jtfObraSocial.disable();
        jtfNumSoc.disable();
        
        pi = con.prepareStatement("select * from historias_clinicas where id_paciente=?");
        pi.setInt(1, id_paciente);
        res3 = pi.executeQuery();
        pos=0;       
        controlespera=0;
        
        while(res3.next())
        {
                Object[][] m=new Object[tabla.getRowCount()+1][tabla.getColumnCount()];
                for(int i=0;i<tabla.getColumnCount();i++)
                for(int j=0;j<tabla.getRowCount();j++)
                   m[j][i]=tabla.getValueAt(j, i);
                tabla.setModel(new DefaultTableModel(m,new String[]{"FECHA", "DIAGNOSTICO","PATOLOGÍA","TALLA","PESO"}));

                m[pos][0] = res3.getString("fecha");
                m[pos][1] = res3.getString("diagnostico");
                m[pos][2] = res3.getString("patologia");
                m[pos][3] = res3.getString("talla");
                m[pos][4] = res3.getString("peso");
                
                tabla.setModel(new DefaultTableModel(m,new String[]{"FECHA", "DIAGNOSTICO","PATOLOGÍA","TALLA","PESO"}));
                pos++;
                controlespera=1;
        }
            
        if(controlespera==0){
            JOptionPane.showMessageDialog(rootPane, "Este paciente no tiene diagnosticos previos");
        }
        
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfEdad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfSexo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfObraSocial = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfNumSoc = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jtfDiag = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfPat = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtfPeso = new javax.swing.JFormattedTextField();
        jtfTalla = new javax.swing.JFormattedTextField();
        jbRecetar = new javax.swing.JButton();
        jbPractica = new javax.swing.JButton();
        jbInternar = new javax.swing.JButton();
        jbTerminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Datos de paciente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel1.setText("Nombre y Apellido:");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel2.setText("Edad:");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel3.setText("Sexo:");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel4.setText("Obra Social:");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel5.setText("Numero de Socio:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfEdad, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfSexo, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                        .addGap(168, 168, 168))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfObraSocial, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfNumSoc, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)))
                        .addGap(16, 16, 16))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfNombre))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                        .addComponent(jtfEdad))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfSexo)))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(jtfObraSocial)
                    .addComponent(jtfNumSoc))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Historia Clinica", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FECHA", "DIAGNÓSTICO", "PATOLOGÍA", "TALLA", "PESO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 568, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Nuevo Diagnóstico", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel6.setText("Diagnóstico:");

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel7.setText("Patología");

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel8.setText("Peso:");

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel9.setText("Talla:");

        try {
            jtfPeso.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##,##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtfPeso.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfPeso.setToolTipText("Ingresar el valor en Kilogramos");

        try {
            jtfTalla.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtfTalla.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfTalla.setToolTipText("Ingresar el valor en centimentros");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfDiag, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfPat, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfPeso, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                        .addGap(176, 176, 176)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfTalla, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jtfDiag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jtfPat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfPeso, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtfTalla, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jbRecetar.setText("Receta");
        jbRecetar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRecetarActionPerformed(evt);
            }
        });

        jbPractica.setText("Práctica");
        jbPractica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPracticaActionPerformed(evt);
            }
        });

        jbInternar.setText("Internar");
        jbInternar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInternarActionPerformed(evt);
            }
        });

        jbTerminar.setText("Terminar");
        jbTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTerminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(427, 427, 427)
                        .addComponent(jbTerminar, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbRecetar, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jbPractica, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jbInternar, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addGap(153, 153, 153))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbRecetar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbPractica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbInternar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jbTerminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jbRecetarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRecetarActionPerformed
        Recetar rec = new Recetar(this,rootPaneCheckingEnabled);
        rec.setVisible(true);
    }//GEN-LAST:event_jbRecetarActionPerformed

    private void jbTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTerminarActionPerformed
        if(!(jtfDiag.getText().isEmpty())&&!(jtfPat.getText().isEmpty())&&!(jtfPeso.getText().isEmpty())&&!(jtfTalla.getText().isEmpty())){
            try {
                
                pu = con.prepareStatement("select * from historias_clinicas");
                res4 = pu.executeQuery();
                int id_hc=0;
                controlespera=0;
                while(res4.next()){
                    id_hc = res4.getInt("id_historia")+1;     
                    controlespera=1;
                }
                
                if(controlespera!=1){
                    id_hc=0;
                } 
                
                //configurar fecha
                SimpleDateFormat[] sdfs = {new SimpleDateFormat("yyyy-MM-dd")};
                Date d = new Date();
                d.getTime();
                //configurar hora
                SimpleDateFormat[] fhd = {new SimpleDateFormat("hh:mm")};
                Date hora = new Date();
                hora.getTime();
                for(SimpleDateFormat fhd2 : fhd)
                System.out.println(fhd2.format(hora));
                
                
                
               int conf = JOptionPane.showConfirmDialog(rootPane, "¿Esta seguro que desea terminar este diagnostico?", "Confirmación", 2);
               if(conf==0){
                   
                    for(SimpleDateFormat sdf : sdfs)
                    for(SimpleDateFormat fhd2 : fhd)
                    po = con.prepareStatement("insert into historias_clinicas(id_historia, id_personal, id_paciente, fecha, hora, peso, talla, diagnostico, patologia) values (?, ?, ?, '"+sdf.format(d)+"', '"+fhd2.format(hora)+"', ?, ?, ?, ?);");
                    
                    po.setInt(1, id_hc);
                    po.setInt(2, id_personal);
                    po.setInt(3, id_paciente);
                    po.setString(4, jtfPeso.getText());
                    po.setString(5, jtfTalla.getText());
                    po.setString(6, jtfDiag.getText());
                    po.setString(7, jtfPat.getText());


                    po.execute();
                    
                    ps2 = con.prepareStatement("update esperas set estado='Atendido' where id_esperas=?;");
                    ps2.setInt(1,id_esperas);
                    ps2.execute();
                    
                    JOptionPane.showMessageDialog(rootPane, "Los datos se guardaron exitosamente");
                    this.setVisible(false);
                    Menu.setVisible(true);
               }
                
            } catch (SQLException ex) {
                Logger.getLogger(Atencion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Debe completar el diagnistico actual, completando todos los campos vacios en 'Nuevo Diagnostico'");
        }
    }//GEN-LAST:event_jbTerminarActionPerformed

    private void jbPracticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPracticaActionPerformed
        IndicarPractica ip= new IndicarPractica(this, rootPaneCheckingEnabled);
        ip.setVisible(true);
    }//GEN-LAST:event_jbPracticaActionPerformed

    private void jbInternarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInternarActionPerformed
        IngresoInternacion ii = new IngresoInternacion(this, rootPaneCheckingEnabled);
        ii.setVisible(true);
    }//GEN-LAST:event_jbInternarActionPerformed

    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbInternar;
    private javax.swing.JButton jbPractica;
    private javax.swing.JButton jbRecetar;
    private javax.swing.JButton jbTerminar;
    private javax.swing.JTextField jtfDiag;
    private javax.swing.JTextField jtfEdad;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfNumSoc;
    private javax.swing.JTextField jtfObraSocial;
    private javax.swing.JTextField jtfPat;
    private javax.swing.JFormattedTextField jtfPeso;
    private javax.swing.JTextField jtfSexo;
    private javax.swing.JFormattedTextField jtfTalla;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
