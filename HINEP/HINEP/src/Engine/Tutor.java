package Engine;

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
 * @author SySoft
 */
public class Tutor extends Persona{
    private String telefono;
    
    public Tutor(String nom1, String nom2, String ape1, String ape2, String dni, String tel, String domi){
        super(nom1, nom2, ape1, ape2, dni, null,null, domi);
        this.telefono = tel;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public void agregar(java.sql.Connection con){
        try {
            PreparedStatement ps = con.prepareStatement("insert into tutores (nom_1,nom_2,ape_1,ape_2,dni,telefono,domicilio) values (?,?,?,?,?,?,?)");
            ps.setString(1, this.getNombre1());
            ps.setString(2, this.getNombre2());
            ps.setString(3, this.getApellido1());
            ps.setString(4, this.getApellido2());
            ps.setString(5, this.getNroDni());
            ps.setString(6, telefono);
            ps.setString(7, this.getDomicilio());
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
