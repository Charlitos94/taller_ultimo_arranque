package taller_ultimo_arranque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import taller_ultimo_arranque.modelos.Cliente;
import taller_ultimo_arranque.ConexionBD;

public class ClienteDAO {
    
    public boolean insertarCliente(Cliente cliente) {
        String sqlPersona = "INSERT INTO personas (id_persona, nombre, telefono, correo) VALUES (?, ?, ?, ?)";
        String sqlCliente = "INSERT INTO clientes (id_persona, nit, direccion) VALUES (?, ?, ?)";

        Connection cn = ConexionBD.obtenerConexion();
        if (cn == null) {
            System.err.println("Error: No hay conexión con la base de datos.");
            return false;
        }

        try {
            cn.setAutoCommit(false);

            try (PreparedStatement psPersona = cn.prepareStatement(sqlPersona)) {
                psPersona.setString(1, cliente.getIdpersona());
                psPersona.setString(2, cliente.getNombre());
                psPersona.setString(3, cliente.getTelefono());
                psPersona.setString(4, cliente.getCorreo());
                psPersona.executeUpdate();
            }

            try (PreparedStatement psCliente = cn.prepareStatement(sqlCliente)) {
                psCliente.setString(1, cliente.getIdpersona());
                psCliente.setString(2, cliente.getNit());
                psCliente.setString(3, cliente.getDireccion());
                psCliente.executeUpdate();
            }

            cn.commit();
            return true;

        } catch (SQLException e) {
            System.err.println("Error al insertar cliente: " + e.getMessage());
            try {
                cn.rollback(); 
            } catch (SQLException ex) {
                System.err.println("Error en rollback: " + ex.getMessage());
            }
            return false;
        }
    }
}