package Engine;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public class Medicacion {
    private int idMedicacion;
    private int fechaAdmin;
    private int horaAdmin;
    private float dosis;

    public float getDosis() {
        return dosis;
    }

    public void setDosis(float dosis) {
        this.dosis = dosis;
    }

    public int getFechaAdmin() {
        return fechaAdmin;
    }

    public void setFechaAdmin(int fechaAdmin) {
        this.fechaAdmin = fechaAdmin;
    }

    public int getHoraAdmin() {
        return horaAdmin;
    }

    public void setHoraAdmin(int horaAdmin) {
        this.horaAdmin = horaAdmin;
    }

    public int getIdMedicacion() {
        return idMedicacion;
    }

    public void setIdMedicacion(int idMedicacion) {
        this.idMedicacion = idMedicacion;
    }
    
    private void guardar(){
    }
    
    private Medicacion buscar(){
        return null;        
    }
}
