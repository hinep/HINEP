package Engine;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SySoft
 */
public class Medico extends Persona{
    private int matricula;
    private String cargo;
    
    public Medico(String nom1, String nom2, String ape1, String ape2, String dni, String fecNac,String sexo, int tel, String domi){
        super(nom1, nom2, ape1, ape2, dni, fecNac, sexo, domi);
    }
    
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
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
