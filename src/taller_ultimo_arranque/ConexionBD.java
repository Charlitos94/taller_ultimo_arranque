package taller_ultimo_arranque;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    
  
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USUARIO = "SYSTEM";
    private static final String CLAVE = "abc12345"; 

    public static Connection obtenerConexion() {
        Connection conexion = null;
        try {
            // Cargar el driver JDBC de Oracle
            Class.forName("oracle.jdbc.OracleDriver");
            
            // Establecer la conexión
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("¡Conexión exitosa a la base de datos de Oracle!");
            
        } catch (ClassNotFoundException e) {
            System.err.println("Error: No se encontró el driver JDBC de Oracle.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error al conectar con Oracle Database: " + e.getMessage());
            e.printStackTrace();
        }
        return conexion;
    }
}