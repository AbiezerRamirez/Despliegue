package models;

import models.Conexion;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Consultas extends Conexion {
    public static final String PARAMETRO_NOMBRE = "nombre";
    public static final String PARAMETRO_CLAVE = "password";
    public static final String TABLA_USUARIOS = "usuarios";
    
    public boolean Auntentificacion(String nombre, String clave) throws SQLException {
        Connect();
        Statement st = conexionBaseDeDatos.createStatement();
        String consulta = "Select count(*) from " + TABLA_USUARIOS + " where " +  PARAMETRO_NOMBRE + " =\"" + nombre + "\" and " + PARAMETRO_CLAVE +  "=\"" + clave + "\"";
        ResultSet rs;
        rs = st.executeQuery(consulta);
        rs.next();
        
        int numeroResultado = rs.getInt("count(*)");
        disconnect();
        
        return (numeroResultado >= 1);
    }
}
