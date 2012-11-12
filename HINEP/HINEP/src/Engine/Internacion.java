/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SySoft
 */
public class Internacion {

    private int idInt;
    private int horaIng;
    private int horaAlta;
    private String motivoAlta;
    private int idServHINEP;
    private int idCama;

    public void setIdInt(int id) {
        this.idInt = id;
    }

    public void setHoraIng(int hi) {
        this.horaIng = hi;
    }

    public void setHoraAlta(int ha) {
        this.horaAlta = ha;
    }

    public void setIdServ(int ids) {
        this.idServHINEP = ids;
    }

    public void setMotivoAlta(String mot) {
        this.motivoAlta = mot;
    }

    public int getIdCama() {
        return idCama;
    }

    public void setIdCama(int idCama) {
        this.idCama = idCama;
    }

    public int getIdInt() {
        return this.idInt;
    }

    public int getHoraIng() {
        return this.horaIng;
    }

    public int getHoraAlta() {
        return this.horaAlta;
    }

    public int getIdServ() {
        return this.idServHINEP;
    }

    public String getMotivoAlta() {
        return this.motivoAlta;
    }

    public Internacion Consultar() {
        return null;
    }

    public void guardar() {
    }

    public void alta(Statement st, int id, String motivo) {
       try {  
            st.execute("UPDATE internaciones_transitorias SET id_servicio = " + getIdServ() + ", id_pers_alta = " + id + ", fecha_alta = current_date, hora_alta = localtime, motivo_alta = '" + motivo + "' WHERE id_int = " + getIdInt()); 
            st.execute("UPDATE camas SET disponible = false where id_cama = " + getIdCama());
        } catch (SQLException ex) {
            Logger.getLogger(Internacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
;
}
