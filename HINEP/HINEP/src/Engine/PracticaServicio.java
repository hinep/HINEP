/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

/**
 *
 * @author SySoft
 */
public class PracticaServicio {
    private int idPractServ;
    private String servicio;
    private String tipoPractica;
    
    public void setId(int id){
        this.idPractServ = id;
    }
    
    public void setServicio(String serv){
        this.servicio = serv;
    }
    
    public void setTipoPractica(String tp){
        this.tipoPractica = tp;
    }
    
    public int getId(){
        return this.idPractServ;
    }
    
    public String getServicio(){
        return this.servicio;
    }
    
    public String getTipoPractica(){
        return this.tipoPractica;
    }
    
    public PracticaServicio buscar(){
        return null;
    }
}
