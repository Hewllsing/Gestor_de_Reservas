package dao;

import model.Pavilhao;
import model.Piso;
import model.Sala;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestorEstruturaDAO {

    // =========================
    // PAVILHAO
    // =========================

    public boolean inserirPavilhao(Pavilhao pavilhao) {
        String sql = "INSERT INTO pavilhao (designacao, numero) VALUES (?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pavilhao.getDesignacao());
            stmt.setString(2, pavilhao.getNumero());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Erro ao inserir pavilhão: " + e.getMessage());
            return false;
        }
    }

    public List<Pavilhao> listarPavilhoes() {
        List<Pavilhao> lista = new ArrayList<>();
        String sql = "SELECT * FROM pavilhao ORDER BY id";

        try (Connection conn = ConexaoBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Pavilhao p = new Pavilhao(
                        rs.getInt("id"),
                        rs.getString("designacao"),
                        rs.getString("numero")
                );
                lista.add(p);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar pavilhões: " + e.getMessage());
        }

        return lista;
    }

    public Pavilhao buscarPavilhaoPorId(int id) {
        String sql = "SELECT * FROM pavilhao WHERE id = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Pavilhao(
                        rs.getInt("id"),
                        rs.getString("designacao"),
                        rs.getString("numero")
                );
            }

        } catch (Exception e) {
            System.out.println("Erro ao buscar pavilhão por id: " + e.getMessage());
        }

        return null;
    }

    public boolean atualizarPavilhao(Pavilhao pavilhao) {
        String sql = "UPDATE pavilhao SET designacao = ?, numero = ? WHERE id = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pavilhao.getDesignacao());
            stmt.setString(2, pavilhao.getNumero());
            stmt.setInt(3, pavilhao.getId());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar pavilhão: " + e.getMessage());
            return false;
        }
    }

    public boolean removerPavilhao(int id) {
        String sql = "DELETE FROM pavilhao WHERE id = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Erro ao remover pavilhão: " + e.getMessage());
            return false;
        }
    }

    // =========================
    // PISO
    // =========================

    public boolean inserirPiso(Piso piso) {
        String sql = "INSERT INTO piso (numero, pavilhao_id) VALUES (?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, piso.getNumero());
            stmt.setInt(2, piso.getPavilhao_id());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Erro ao inserir piso: " + e.getMessage());
            return false;
        }
    }

    public List<Piso> listarPisos() {
        List<Piso> lista = new ArrayList<>();
        String sql = "SELECT * FROM piso ORDER BY id";

        try (Connection conn = ConexaoBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Piso p = new Piso(
                        rs.getInt("id"),
                        rs.getString("numero"),
                        rs.getInt("pavilhao_id")
                );
                lista.add(p);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar pisos: " + e.getMessage());
        }

        return lista;
    }

    public List<Piso> listarPisosPorPavilhao(int pavilhaoId) {
        List<Piso> lista = new ArrayList<>();
        String sql = "SELECT * FROM piso WHERE pavilhao_id = ? ORDER BY id";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pavilhaoId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Piso p = new Piso(
                        rs.getInt("id"),
                        rs.getString("numero"),
                        rs.getInt("pavilhao_id")
                );
                lista.add(p);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar pisos por pavilhão: " + e.getMessage());
        }

        return lista;
    }

    public Piso buscarPisoPorId(int id) {
        String sql = "SELECT * FROM piso WHERE id = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Piso(
                        rs.getInt("id"),
                        rs.getString("numero"),
                        rs.getInt("pavilhao_id")
                );
            }

        } catch (Exception e) {
            System.out.println("Erro ao buscar piso por id: " + e.getMessage());
        }

        return null;
    }

    public boolean atualizarPiso(Piso piso) {
        String sql = "UPDATE piso SET numero = ?, pavilhao_id = ? WHERE id = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, piso.getNumero());
            stmt.setInt(2, piso.getPavilhao_id());
            stmt.setInt(3, piso.getId());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar piso: " + e.getMessage());
            return false;
        }
    }

    public boolean removerPiso(int id) {
        String sql = "DELETE FROM piso WHERE id = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Erro ao remover piso: " + e.getMessage());
            return false;
        }
    }

    // =========================
    // SALA
    // =========================

    public boolean inserirSala(Sala sala) {
        String sql = "INSERT INTO sala (designacao, tipo, lotacao, numero, piso_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, sala.getDesignacao());
            stmt.setString(2, sala.getTipo());
            stmt.setInt(3, sala.getLotacao());
            stmt.setString(4, sala.getNumero());
            stmt.setInt(5, sala.getPiso_id());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Erro ao inserir sala: " + e.getMessage());
            return false;
        }
    }

    public List<Sala> listarSalas() {
        List<Sala> lista = new ArrayList<>();
        String sql = "SELECT * FROM sala ORDER BY id";

        try (Connection conn = ConexaoBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Sala s = new Sala(
                        rs.getInt("id"),
                        rs.getString("designacao"),
                        rs.getString("tipo"),
                        rs.getInt("lotacao"),
                        rs.getString("numero"),
                        rs.getInt("piso_id")
                );
                lista.add(s);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar salas: " + e.getMessage());
        }

        return lista;
    }

    public List<Sala> listarSalasPorPiso(int pisoId) {
        List<Sala> lista = new ArrayList<>();
        String sql = "SELECT * FROM sala WHERE piso_id = ? ORDER BY id";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pisoId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Sala s = new Sala(
                        rs.getInt("id"),
                        rs.getString("designacao"),
                        rs.getString("tipo"),
                        rs.getInt("lotacao"),
                        rs.getString("numero"),
                        rs.getInt("piso_id")
                );
                lista.add(s);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar salas por piso: " + e.getMessage());
        }

        return lista;
    }

    public Sala buscarSalaPorId(int id) {
        String sql = "SELECT * FROM sala WHERE id = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Sala(
                        rs.getInt("id"),
                        rs.getString("designacao"),
                        rs.getString("tipo"),
                        rs.getInt("lotacao"),
                        rs.getString("numero"),
                        rs.getInt("piso_id")
                );
            }

        } catch (Exception e) {
            System.out.println("Erro ao buscar sala por id: " + e.getMessage());
        }

        return null;
    }

    public boolean atualizarSala(Sala sala) {
        String sql = "UPDATE sala SET designacao = ?, tipo = ?, lotacao = ?, numero = ?, piso_id = ? WHERE id = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, sala.getDesignacao());
            stmt.setString(2, sala.getTipo());
            stmt.setInt(3, sala.getLotacao());
            stmt.setString(4, sala.getNumero());
            stmt.setInt(5, sala.getPiso_id());
            stmt.setInt(6, sala.getId());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar sala: " + e.getMessage());
            return false;
        }
    }

    public boolean removerSala(int id) {
        String sql = "DELETE FROM sala WHERE id = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Erro ao remover sala: " + e.getMessage());
            return false;
        }
    }
}