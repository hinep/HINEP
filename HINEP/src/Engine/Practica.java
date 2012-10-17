/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

/**
 *
 * @author Administrador
 */
public class Practica {
    private int idPractica;
    private int fecha;
    private String observacion;
    
    public void setId(int id){
        this.idPractica = id;
    }
    
    public void setFecha(int fec){
        this.fecha = fec;
    }
    
    public void setObservacion(String ob){
        this.observacion = ob;
    }
    
    public int getId(){
        return this.idPractica;
    }
    
    public int getFecha(int fec){
        return this.fecha;
    }
    
    public String getObservacion(String ob){
        return this.observacion;
    }
    
    public void guardar(){
    }
    
    public Practica buscar(){
        return null;
    }
}
