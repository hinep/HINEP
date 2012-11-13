/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package paq_adjunto_2;

import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class ajVarios {
    /**
    * Recibe un string y lo convierte en vector de una dimension incluyendo con los espacios. Ej.: "brahian paul, vera florentin" a String[]{"brahian paul"," vera florentin"}. El metodo va separando en vector cuando detecta una coma dentro de la cadena de texto
    * @param StringEnComa
    * @return
    */
   public static String[]getStringToVectorWithSpace(String StringEnComa)
   {
        ArrayList lista = new ArrayList();
        int c=0;
        for (int i = 0; i < StringEnComa.length(); i++)
        {
            if (StringEnComa.substring(i, i+1).equals(","))
            {
                c+=1;
                continue;
            }
            try {
                lista.get(c);
            } catch (Exception e) {
                lista.add("");
            }
            lista.set(c, lista.get(c)+StringEnComa.substring(i, i+1));
        }
        String[]veSQLaux=new String[c+1];
        for (int i = 0; i < veSQLaux.length; i++)
            veSQLaux[i]=lista.get(i).toString();
        return veSQLaux;
   }

    /**
     * De una cadena de texto entre comas lo va colocando entre comillas simples para que pueda ser reconocido (segun el caso) por una base de datos.
     * @param ve_aux
     * @return
     */
    public static String ChangeToPostgres(String StringEnComa)
    {
        return ChangeToPostgres(getStringToVectorWithSpace(StringEnComa));
    }
	/**
     * Cambia un vector de string a datos que puede reconocer el postgres
     * @param ve_aux
     * @return
     */
    public static String ChangeToPostgres(String[] ve_aux)
    {
        //Sirve para crear agrupar los cuadro de texto y construirlos en un todo y retornarlo como una sola cadena
        String str_aux="'";
        for(int x=0;x<ve_aux.length;x++)
        {
            str_aux=str_aux+ve_aux[x];

            if(x+1<ve_aux.length)
                str_aux=str_aux+"','";
            else
                str_aux=str_aux+"'";
        }
        return str_aux;
    }
}
