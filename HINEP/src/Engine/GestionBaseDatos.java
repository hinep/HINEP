/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author carolina
 */
public class GestionBaseDatos {

    private Connection cx;
    private Statement st;

    public Connection getCx() {
        return cx;
    }

    public Statement getSt() {
        return st;
    }

    public GestionBaseDatos() throws SQLException {
        cx = DriverManager.getConnection("jdbc:postgresql:hinep", "postgres", "admin");
        st = cx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }
}
