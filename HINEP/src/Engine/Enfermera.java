package Engine;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public class Enfermera extends Persona{
    private int licencia;
    private String puesto;

    public int getLicencia() {
        return licencia;
    }

    public void setLicencia(int licencia) {
        this.licencia = licencia;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
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
