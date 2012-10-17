package Engine;

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
            
    @Override
    void Agregar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    Persona Buscar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    void Modificar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
