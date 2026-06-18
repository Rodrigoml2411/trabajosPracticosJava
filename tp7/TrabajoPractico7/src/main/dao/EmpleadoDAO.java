package main.dao;

import main.modelo.Empleado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    public void insertar(Empleado emp) {
        String sql = "INSERT INTO empleados (nombre, departamento_id, foto) VALUES (?, ?, ?)";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, emp.getNombre());
            pstmt.setInt(2, emp.getDepartamentoId());
            pstmt.setString(3, emp.getFoto());
            pstmt.executeUpdate();
            System.out.println("Empleado insertado.");
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    public void actualizar(Empleado emp) {
        String sql = "UPDATE empleados SET nombre = ?, departamento_id = ?, foto = ? WHERE id = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, emp.getNombre());
            pstmt.setInt(2, emp.getDepartamentoId());
            pstmt.setString(3, emp.getFoto());
            pstmt.setInt(4, emp.getId());
            int filas = pstmt.executeUpdate();
            if (filas > 0) System.out.println("Empleado actualizado.");
            else System.out.println("No se encontró empleado con ID " + emp.getId());
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM empleados WHERE id = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int filas = pstmt.executeUpdate();
            if (filas > 0) System.out.println("Empleado eliminado.");
            else System.out.println("No se encontró empleado con ID " + id);
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }

    public List<Empleado> consultarTodos() {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT e.id, e.nombre, e.foto, e.departamento_id, d.nombre_depto " +
                     "FROM empleados e LEFT JOIN departamentos d ON e.departamento_id = d.id_depto";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Empleado emp = new Empleado();
                emp.setId(rs.getInt("id"));
                emp.setNombre(rs.getString("nombre"));
                emp.setFoto(rs.getString("foto"));
                emp.setDepartamentoId(rs.getInt("departamento_id"));
                emp.setDepartamentoNombre(rs.getString("nombre_depto"));
                lista.add(emp);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }
        return lista;
    }
}
