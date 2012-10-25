package Engine;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public class Paciente extends Persona{  
    private String nomObraSocial;
    private int nroObraSocial;
    
    public Paciente(String nom1, String nom2, String ape1, String ape2, String dni, String fecNac,String sexo,int obra,String nSoc){
        super(nom1, nom2, ape1, ape2, dni, fecNac, sexo);
        this.nroObraSocial = obra;
        this.nomObraSocial = nSoc;
    }
    public String getNomObraSocial() {
        return nomObraSocial;
    }

    public void setNomObraSocial(String nomObraSocial) {
        this.nomObraSocial = nomObraSocial;
    }

    public int getNroObraSocial() {
        return nroObraSocial;
    }

    public void setNroObraSocial(int nroObraSocial) {
        this.nroObraSocial = nroObraSocial;
    }
            
    public void agregar(Connection con) {
        try {
            PreparedStatement ps = con.prepareStatement("insert into pacientes (id_os,numero_os,nom_1,nom_2,ape_1,ape_2,dni,fecha_nac,sexo) values (?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, this.getNroObraSocial());
            ps.setString(2, this.getNomObraSocial());
            ps.setString(3, this.getNombre1());
            ps.setString(4, this.getNombre2());
            ps.setString(5, this.getApellido1());
            ps.setString(6, this.getApellido2());
            ps.setString(7, this.getNroDni());
            ps.setDate(8, Date.valueOf(this.getFechaNac()));
            ps.setString(9, this.getSexo());
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public Persona buscar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void modificar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    void agregar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
