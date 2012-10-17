/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

/**
 *
 * @author Administrador
 */
public class HistoriaClinica {
    private int idHC;
    private float peso;
    private float talla;
    private String diagnostico;
    private String patologia;
    
    public void setId(int id){
        this.idHC = id;
    }
    
    public void setPeso(float peso){
        this.peso = peso;
    }
    
    public void setTalla(float talla){
        this.talla = talla;
    }
    
    public void setDiagnostico(String diag){
        this.diagnostico = diag;
    }
    
    public void setPatologia(String pato){
        this.patologia = pato;
    }
    public int getId(){
        return this.idHC;
    }
    
    public float getPeso(){
        return this.peso;
    }
    
    public float getTalla(){
        return this.talla;
    }
    
    public String getDiagnostico(){
        return this.diagnostico;
    }
    
    public String getPatologia(){
        return this.patologia;
    }
    
    public void guardar(){
    }
}
