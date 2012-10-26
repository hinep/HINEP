/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

/**
 *
 * @author SySoft
 */
public class Prescripciones {
    private int idPrescripcion;
    private String indicacion;
    
    public int getIdPrescripcion(){
        return this.idPrescripcion;
    }
    
    public String getIndicacion(){
        return this.indicacion;
    }
    
    public void setIdPresc(int id){
        this.idPrescripcion = id;
    }
    
    public void setIndicacion(String indica){
        this.indicacion = indica;
    }
    public void guardar(){
    }
    
    public Prescripciones buscar(){
        return null;
    }
}
