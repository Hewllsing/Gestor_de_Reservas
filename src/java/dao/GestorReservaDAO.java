package dao;

import model.Formador;
import model.Reserva;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestorReservaDAO {

    // =========================
    // FORMADOR
    // =========================

    public boolean inserirFormador(Formador formador) {
        String sql = "INSERT INTO formador (nome) VALUES (?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, formador.getNome());
            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Erro ao inserir formador: " + e.getMessage());
            return false;
        }
    }

    public List<Formador> listarFormadores() {
        List<Formador> lista = new ArrayList<>();
        String sql = "SELECT * FROM formador ORDER BY id";

        try (Connection conn = ConexaoBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Formador f = new Formador(
                        rs.getInt("id"),
                        rs.getString("nome")
                );
                lista.add(f);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar formadores: " + e.getMessage());
        }

        return lista;
    }

    public Formador buscarFormadorPorId(int id) {
        String sql = "SELECT * FROM formador WHERE id = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Formador(
                        rs.getInt("id"),
                        rs.getString("nome")
                );
            }

        } catch (Exception e) {
            System.out.println("Erro ao buscar formador por id: " + e.getMessage());
        }

        return null;
    }

    public boolean atualizarFormador(Formador formador) {
        String sql = "UPDATE formador SET nome = ? WHERE id = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, formador.getNome());
            stmt.setInt(2, formador.getId());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar formador: " + e.getMessage());
            return false;
        }
    }

    public boolean removerFormador(int id) {
        String sql = "DELETE FROM formador WHERE id = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Erro ao remover formador: " + e.getMessage());
            return false;
        }
    }

    // =========================
    // RESERVA
    // =========================

    public boolean inserirReserva(Reserva reserva) {
        String sql = "INSERT INTO reserva (dataInicio, dataFim, estado, sala_id, formador_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setTimestamp(1, new Timestamp(reserva.getDataInicio().getTime()));
            stmt.setTimestamp(2, new Timestamp(reserva.getDataFim().getTime()));
            stmt.setString(3, reserva.getEstado());
            stmt.setInt(4, reserva.getSala_id());
            stmt.setInt(5, reserva.getFormador_id());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Erro ao inserir reserva: " + e.getMessage());
            return false;
        }
    }

    public List<Reserva> listarReservas() {
        List<Reserva> lista = new ArrayList<>();
        String sql = "SELECT * FROM reserva ORDER BY id";

        try (Connection conn = ConexaoBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Reserva r = new Reserva(
                        rs.getInt("id"),
                        rs.getTimestamp("dataInicio"),
                        rs.getTimestamp("dataFim"),
                        rs.getString("estado"),
                        rs.getInt("sala_id"),
                        rs.getInt("formador_id")
                );
                lista.add(r);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar reservas: " + e.getMessage());
        }

        return lista;
    }

    public Reserva buscarReservaPorId(int id) {
        String sql = "SELECT * FROM reserva WHERE id = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Reserva(
                        rs.getInt("id"),
                        rs.getTimestamp("dataInicio"),
                        rs.getTimestamp("dataFim"),
                        rs.getString("estado"),
                        rs.getInt("sala_id"),
                        rs.getInt("formador_id")
                );
            }

        } catch (Exception e) {
            System.out.println("Erro ao buscar reserva por id: " + e.getMessage());
        }

        return null;
    }

    public boolean atualizarReserva(Reserva reserva) {
        String sql = "UPDATE reserva SET dataInicio = ?, dataFim = ?, estado = ?, sala_id = ?, formador_id = ? WHERE id = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setTimestamp(1, new Timestamp(reserva.getDataInicio().getTime()));
            stmt.setTimestamp(2, new Timestamp(reserva.getDataFim().getTime()));
            stmt.setString(3, reserva.getEstado());
            stmt.setInt(4, reserva.getSala_id());
            stmt.setInt(5, reserva.getFormador_id());
            stmt.setInt(6, reserva.getId());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar reserva: " + e.getMessage());
            return false;
        }
    }

    public boolean removerReserva(int id) {
        String sql = "DELETE FROM reserva WHERE id = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Erro ao remover reserva: " + e.getMessage());
            return false;
        }
    }

    // =========================
    // VALIDAR CONFLITO
    // =========================

    public boolean existeConflitoReserva(Reserva reserva) {
        String sql = """
                SELECT COUNT(*) 
                FROM reserva
                WHERE sala_id = ?
                AND dataInicio < ?
                AND dataFim > ?
                """;

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, reserva.getSala_id());
            stmt.setTimestamp(2, new Timestamp(reserva.getDataFim().getTime()));
            stmt.setTimestamp(3, new Timestamp(reserva.getDataInicio().getTime()));

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (Exception e) {
            System.out.println("Erro ao verificar conflito de reserva: " + e.getMessage());
        }

        return false;
    }

    public boolean existeConflitoReservaAoAtualizar(Reserva reserva) {
        String sql = """
                SELECT COUNT(*) 
                FROM reserva
                WHERE sala_id = ?
                AND dataInicio < ?
                AND dataFim > ?
                AND id <> ?
                """;

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, reserva.getSala_id());
            stmt.setTimestamp(2, new Timestamp(reserva.getDataFim().getTime()));
            stmt.setTimestamp(3, new Timestamp(reserva.getDataInicio().getTime()));
            stmt.setInt(4, reserva.getId());

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (Exception e) {
            System.out.println("Erro ao verificar conflito ao atualizar reserva: " + e.getMessage());
        }

        return false;
    }

    // =========================
    // JOIN DETALHADO
    // =========================

    public List<String> listarReservasDetalhadas() {
        List<String> lista = new ArrayList<>();

        String sql = """
                SELECT r.id, r.dataInicio, r.dataFim, r.estado,
                       s.designacao AS sala,
                       f.nome AS formador
                FROM reserva r
                JOIN sala s ON r.sala_id = s.id
                JOIN formador f ON r.formador_id = f.id
                ORDER BY r.id
                """;

        try (Connection conn = ConexaoBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String info = "Reserva #" + rs.getInt("id")
                        + " | Sala: " + rs.getString("sala")
                        + " | Formador: " + rs.getString("formador")
                        + " | Início: " + rs.getTimestamp("dataInicio")
                        + " | Fim: " + rs.getTimestamp("dataFim")
                        + " | Estado: " + rs.getString("estado");

                lista.add(info);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar reservas detalhadas: " + e.getMessage());
        }

        return lista;
    }
}