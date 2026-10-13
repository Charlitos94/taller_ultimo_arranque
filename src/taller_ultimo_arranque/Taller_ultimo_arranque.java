package taller_ultimo_arranque;

import java.sql.Connection;

public class Taller_ultimo_arranque {

    public static void main(String[] args) {
        
        Connection cn = ConexionBD.obtenerConexion();
        
        if (cn != null) {
            System.out.println("¡Conexión verificada exitosamente!");
        } else {
            System.out.println("Error: No se pudo conectar a la base de datos.");
        }    }
    
}
