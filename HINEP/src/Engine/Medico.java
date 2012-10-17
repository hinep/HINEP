package Engine;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public class Medico extends Persona{
    private int matricula;
    private String cargo;

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
