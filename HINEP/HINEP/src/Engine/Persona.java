package Engine;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SySoft
 */
public abstract class Persona {
    private int id;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String nroDni;
    private String domicilio;
    private String fechaNac;
    private String sexo;

    /** Crea una Persona
     *  Paciente/Tutor/Medico/Enfermera
     */
    public Persona(String nom1, String nom2, String ape1, String ape2, String dni, String fecNac,String sexo, String domi){
        this.apellido1 = ape1;
        this.apellido2 = ape2;
        this.fechaNac = fecNac;
        this.nombre1 = nom1;
        this.nombre2 = nom2;
        this.nroDni = dni;
        this.sexo = sexo;
        this.domicilio = domi;
    }
    
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getNroDni() {
        return nroDni;
    }

    public void setNroDni(String nroDni) {
        this.nroDni = nroDni;
    }
    
    abstract void agregar();
      
    abstract Persona buscar();
    
    abstract void modificar();
    
    public int calcularEdad() {
        String datetext = fechaNac;
        try {
        Calendar birth = new GregorianCalendar();
        Calendar today = new GregorianCalendar();
        int age=0;
        int factor=0;
        Date birthDate=new SimpleDateFormat(datetext).parse(datetext);
        Date currentDate=new Date(); //current date
        birth.setTime(birthDate);
        today.setTime(currentDate);
        if (today.get(Calendar.MONTH) <= birth.get(Calendar.MONTH)) {
            if (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH)) {
                if (today.get(Calendar.DATE) > birth.get(Calendar.DATE)) {
                    factor = -1; //Aun no celebra su cumpleaÃ±os
                }
            } else {
                factor = -1; //Aun no celebra su cumpleaÃ±os
            }
        }
        age = (today.get(Calendar.YEAR)-birth.get(Calendar.YEAR))+factor;
        return age;
        } catch (ParseException e) {
        return -1;
        }

    }
    
}
