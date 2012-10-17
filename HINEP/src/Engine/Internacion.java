/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

/**
 *
 * @author Administrador
 */
public class Internacion {
    private int idInt;
    private int horaIng;
    private int horaAlta;
    private String motivoAlta;
    private int idServHINEP;
    
    public void setIdInt(int id){
        this.idInt = id;
    }
    
    public void setHoraIng(int hi){
        this.horaIng = hi;
    }
    
    public void setHoraAlta(int ha){
        this.horaAlta = ha;
    }
    
    public void setIdServ(int ids){
        this.idServHINEP = ids;
    }
    
    public void setMotivoAlta(String mot){
        this.motivoAlta = mot;
    }
    public int getIdInt(){
        return this.idInt;
    }
    
    public int getHoraIng(){
        return this.horaIng;
    }
    
    public int getHoraAlta(){
        return this.horaAlta;
    }
    
    public int getIdServ(){
        return this.idServHINEP;
    }
    
    public String getMotivoAlta(){
        return this.motivoAlta;
    }
    
    public Internacion Consultar(){
        return null;
    }
    
    public int calcularTiempo(){
        int tiempo = 0;
        return tiempo;
    }
    
    public void guardar(){
    }
    
    public int alta(){
        return 0;
    }
}
