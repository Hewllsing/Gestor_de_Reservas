package service;

import dao.GestorReservaDAO;
import model.Formador;
import model.Reserva;

import java.util.List;

public class GestorReservaService {

    private GestorReservaDAO reservaDAO;

    public GestorReservaService() {
        this.reservaDAO = new GestorReservaDAO();
    }

    // =========================
    // FORMADOR
    // =========================

    public boolean adicionarFormador(Formador formador) {
        if (formador == null) {
            return false;
        }

        if (formador.getNome() == null || formador.getNome().trim().isEmpty()) {
            System.out.println("O nome do formador é obrigatório.");
            return false;
        }

        return reservaDAO.inserirFormador(formador);
    }

    public List<Formador> listarFormadores() {
        return reservaDAO.listarFormadores();
    }

    public Formador obterFormadorPorId(int id) {
        if (id <= 0) {
            return null;
        }

        return reservaDAO.buscarFormadorPorId(id);
    }

    public boolean atualizarFormador(Formador formador) {
        if (formador == null || formador.getId() <= 0) {
            return false;
        }

        if (formador.getNome() == null || formador.getNome().trim().isEmpty()) {
            System.out.println("O nome do formador é obrigatório.");
            return false;
        }

        return reservaDAO.atualizarFormador(formador);
    }

    public boolean removerFormador(int id) {
        if (id <= 0) {
            return false;
        }

        return reservaDAO.removerFormador(id);
    }

    // =========================
    // RESERVA
    // =========================

    public boolean adicionarReserva(Reserva reserva) {
        if (reserva == null) {
            return false;
        }

        if (reserva.getDataInicio() == null) {
            System.out.println("A data de início é obrigatória.");
            return false;
        }

        if (reserva.getDataFim() == null) {
            System.out.println("A data de fim é obrigatória.");
            return false;
        }

        if (!reserva.getDataFim().after(reserva.getDataInicio())) {
            System.out.println("A data de fim tem de ser posterior à data de início.");
            return false;
        }

        if (reserva.getEstado() == null || reserva.getEstado().trim().isEmpty()) {
            System.out.println("O estado da reserva é obrigatório.");
            return false;
        }

        if (reserva.getSala_id() <= 0) {
            System.out.println("A reserva tem de estar associada a uma sala válida.");
            return false;
        }

        if (reserva.getFormador_id() <= 0) {
            System.out.println("A reserva tem de estar associada a um formador válido.");
            return false;
        }

        if (reservaDAO.existeConflitoReserva(reserva)) {
            System.out.println("Já existe uma reserva para esta sala no horário indicado.");
            return false;
        }

        return reservaDAO.inserirReserva(reserva);
    }

    public List<Reserva> listarReservas() {
        return reservaDAO.listarReservas();
    }

    public Reserva obterReservaPorId(int id) {
        if (id <= 0) {
            return null;
        }

        return reservaDAO.buscarReservaPorId(id);
    }

    public boolean atualizarReserva(Reserva reserva) {
        if (reserva == null || reserva.getId() <= 0) {
            return false;
        }

        if (reserva.getDataInicio() == null) {
            System.out.println("A data de início é obrigatória.");
            return false;
        }

        if (reserva.getDataFim() == null) {
            System.out.println("A data de fim é obrigatória.");
            return false;
        }

        if (!reserva.getDataFim().after(reserva.getDataInicio())) {
            System.out.println("A data de fim tem de ser posterior à data de início.");
            return false;
        }

        if (reserva.getEstado() == null || reserva.getEstado().trim().isEmpty()) {
            System.out.println("O estado da reserva é obrigatório.");
            return false;
        }

        if (reserva.getSala_id() <= 0) {
            System.out.println("A reserva tem de estar associada a uma sala válida.");
            return false;
        }

        if (reserva.getFormador_id() <= 0) {
            System.out.println("A reserva tem de estar associada a um formador válido.");
            return false;
        }

        if (reservaDAO.existeConflitoReservaAoAtualizar(reserva)) {
            System.out.println("Já existe outra reserva para esta sala no horário indicado.");
            return false;
        }

        return reservaDAO.atualizarReserva(reserva);
    }

    public boolean removerReserva(int id) {
        if (id <= 0) {
            return false;
        }

        return reservaDAO.removerReserva(id);
    }

    public List<String> listarReservasDetalhadas() {
        return reservaDAO.listarReservasDetalhadas();
    }
}