/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

/**
 * 
 * @author SySoft
 */
public class Cama {
    private int idCama;
    private int nroCama;
    
    public void setIdCama(int id){
        this.idCama = id;
    }
    
    public void setNroCama(int nro){
        this.nroCama = nro;
    }
    
    public int getIdCama(){
        return this.idCama;
    }
    
    public int getNroCama(){
        return this.nroCama;
    }
    
    public boolean consultar(){
        boolean b=false;
        return b;
    }
    
    public void cambiarCondicion(){
    }
}
