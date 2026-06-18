package main.dao;

import main.modelo.Departamento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO {

    public List<Departamento> obtenerTodos() {
        List<Departamento> lista = new ArrayList<>();
        String sql = "SELECT id_depto, nombre_depto FROM departamentos ORDER BY nombre_depto";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Departamento d = new Departamento();
                d.setId(rs.getInt("id_depto"));
                d.setNombre(rs.getString("nombre_depto"));
                lista.add(d);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener departamentos: " + e.getMessage());
        }
        return lista;
    }

    public int obtenerIdPorNombre(String nombre) {
        String sql = "SELECT id_depto FROM departamentos WHERE nombre_depto = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id_depto");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener ID de departamento: " + e.getMessage());
        }
        return -1;
    }
}