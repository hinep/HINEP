package Engine;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Clase donde se representa a un tutor
 * 
 */

/**
 * 
 * @author Administrador
 */
public class Tutor extends Persona{
    private int telefono;
    
    public Tutor(String nom1, String nom2, String ape1, String ape2, String dni, String fecNac,String sexo, int tel){
        super(nom1, nom2, ape1, ape2, dni, fecNac, sexo);
        this.telefono = tel;
    }
    
    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    public void agregar(java.sql.Connection con){
        try {
            PreparedStatement ps = con.prepareStatement("insert into tutores (nom_1,nom_2,ape_1,ape_2,dni,fecha_nac,sexo) values (?,?,?,?,?,?,?)");
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
    void agregar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    Persona buscar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    void modificar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    
}
