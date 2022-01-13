package models;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author abiezer
 */
public class Conexion {
    private static final String NOMBRE_DE_USUARIO = "abiezer";
    private static final String CLAVE = "1234";
    private static final String HOST = "localhost";
    private static final String PUERTO = "3306";
    private static final String BASE_DE_DATOS = "login";
    private static final String URL = "jdbc:mysql://"+HOST+":"+PUERTO +"/"+ BASE_DE_DATOS;
    
    protected java.sql.Connection conexionBaseDeDatos;
    
    public Conexion() {
        
    }
    
    public boolean Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexionBaseDeDatos = DriverManager.getConnection(URL, NOMBRE_DE_USUARIO, CLAVE);
            System.out.println("Conexion Exitosa");
            return true;
            
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean disconnect() {
        try {
            conexionBaseDeDatos.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
