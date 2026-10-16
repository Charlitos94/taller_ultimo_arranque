package taller_ultimo_arranque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import taller_ultimo_arranque.ConexionBD;
import taller_ultimo_arranque.modelos.Mecanico;

public class MecanicoDAO {

    public boolean insertarMecanico(Mecanico mecanico) {
        String sqlPersona = "INSERT INTO personas (id_persona, nombre, telefono, correo) VALUES (?, ?, ?, ?)";
        String sqlMecanico = "INSERT INTO mecanicos (id_persona, especialidad) VALUES (?, ?)";

        Connection cn = ConexionBD.obtenerConexion();
        if (cn == null) return false;

        try {
            cn.setAutoCommit(false); // Transacción para insertar en ambas tablas

            // 1. Insertar en PERSONAS
            try (PreparedStatement psPersona = cn.prepareStatement(sqlPersona)) {
                psPersona.setString(1, mecanico.getIdpersona());
                psPersona.setString(2, mecanico.getNombre());
                psPersona.setString(3, mecanico.getTelefono());
                psPersona.setString(4, mecanico.getCorreo());
                psPersona.executeUpdate();
            }

            // 2. Insertar en MECANICOS
            try (PreparedStatement psMecanico = cn.prepareStatement(sqlMecanico)) {
                psMecanico.setString(1, mecanico.getIdpersona());
                psMecanico.setString(2, mecanico.getEspecialidad());
                psMecanico.executeUpdate();
            }

            cn.commit();
            return true;

        } catch (SQLException e) {
            try {
                if (cn != null) cn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (cn != null) {
                    cn.setAutoCommit(true);
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Mecanico> listarMecanicos() {
        List<Mecanico> lista = new ArrayList<>();
        String sql = "SELECT p.id_persona, p.nombre, p.telefono, p.correo, m.especialidad " +
                     "FROM personas p " +
                     "INNER JOIN mecanicos m ON p.id_persona = m.id_persona";

        try (Connection cn = ConexionBD.obtenerConexion();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Mecanico m = new Mecanico();
                m.setIdpersona(rs.getString("id_persona"));
                m.setNombre(rs.getString("nombre"));
                m.setTelefono(rs.getString("telefono"));
                m.setCorreo(rs.getString("correo"));
                m.setEspecialidad(rs.getString("especialidad"));
                lista.add(m);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean actualizarMecanico(Mecanico mecanico) {
        String sqlPersona = "UPDATE personas SET nombre = ?, telefono = ?, correo = ? WHERE id_persona = ?";
        String sqlMecanico = "UPDATE mecanicos SET especialidad = ? WHERE id_persona = ?";

        Connection cn = ConexionBD.obtenerConexion();
        if (cn == null) return false;

        try {
            cn.setAutoCommit(false);

            try (PreparedStatement psPersona = cn.prepareStatement(sqlPersona)) {
                psPersona.setString(1, mecanico.getNombre());
                psPersona.setString(2, mecanico.getTelefono());
                psPersona.setString(3, mecanico.getCorreo());
                psPersona.setString(4, mecanico.getIdpersona());
                psPersona.executeUpdate();
            }

            try (PreparedStatement psMecanico = cn.prepareStatement(sqlMecanico)) {
                psMecanico.setString(1, mecanico.getEspecialidad());
                psMecanico.setString(2, mecanico.getIdpersona());
                psMecanico.executeUpdate();
            }

            cn.commit();
            return true;

        } catch (SQLException e) {
            try {
                if (cn != null) cn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (cn != null) {
                    cn.setAutoCommit(true);
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean eliminarMecanico(String idPersona) {
        String sqlMecanico = "DELETE FROM mecanicos WHERE id_persona = ?";
        String sqlPersona = "DELETE FROM personas WHERE id_persona = ?";

        Connection cn = ConexionBD.obtenerConexion();
        if (cn == null) return false;

        try {
            cn.setAutoCommit(false);

            // Se elimina primero de la tabla hija por la Foreign Key
            try (PreparedStatement psMecanico = cn.prepareStatement(sqlMecanico)) {
                psMecanico.setString(1, idPersona);
                psMecanico.executeUpdate();
            }

            // Se elimina luego de la tabla base
            try (PreparedStatement psPersona = cn.prepareStatement(sqlPersona)) {
                psPersona.setString(1, idPersona);
                psPersona.executeUpdate();
            }

            cn.commit();
            return true;

        } catch (SQLException e) {
            try {
                if (cn != null) cn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (cn != null) {
                    cn.setAutoCommit(true);
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}