package Engine;

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
