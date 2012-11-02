package Engine;

import Interfaces.AsignarGuardias;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SySoft
 */
public class Guardia {

    private int idGuardia;
    private String fecha;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdGuardia() {
        return idGuardia;
    }

    public void setIdGuardia(int idGuardia) {
        this.idGuardia = idGuardia;
    }

    public void guardar(Statement st, int id_personal) {
        try {
            st.execute("INSERT INTO guardias(id_personal, fecha)VALUES ( " + id_personal + " , '" + fecha + "')");
        } catch (SQLException ex) {
            Logger.getLogger(AsignarGuardias.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private int consultarId() {
        return 0;
    }
}
