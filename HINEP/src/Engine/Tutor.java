package Engine;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public class Tutor extends Persona{
    private int telefono;

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
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
