package Engine;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SySoft
 */
public class Enfermera extends Persona{
    private int licencia;
    private String puesto;
    
    public Enfermera(String nom1, String nom2, String ape1, String ape2, String dni, String fecNac, String sexo, String domi){
        super(nom1, nom2, ape1, ape2, dni, fecNac, sexo, domi);
    }
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
