package service;

import dao.GestorEstruturaDAO;
import model.Pavilhao;
import model.Piso;
import model.Sala;

import java.util.List;

public class GestorEstruturaService {

    private GestorEstruturaDAO estruturaDAO;

    public GestorEstruturaService() {
        this.estruturaDAO = new GestorEstruturaDAO();
    }

    // =========================
    // PAVILHAO
    // =========================

    public boolean adicionarPavilhao(Pavilhao pavilhao) {
        if (pavilhao == null) {
            return false;
        }

        if (pavilhao.getDesignacao() == null || pavilhao.getDesignacao().trim().isEmpty()) {
            System.out.println("A designação do pavilhão é obrigatória.");
            return false;
        }

        if (pavilhao.getNumero() == null || pavilhao.getNumero().trim().isEmpty()) {
            System.out.println("O número do pavilhão é obrigatório.");
            return false;
        }

        return estruturaDAO.inserirPavilhao(pavilhao);
    }

    public List<Pavilhao> listarPavilhoes() {
        return estruturaDAO.listarPavilhoes();
    }

    public Pavilhao obterPavilhaoPorId(int id) {
        if (id <= 0) {
            return null;
        }

        return estruturaDAO.buscarPavilhaoPorId(id);
    }

    public boolean atualizarPavilhao(Pavilhao pavilhao) {
        if (pavilhao == null || pavilhao.getId() <= 0) {
            return false;
        }

        if (pavilhao.getDesignacao() == null || pavilhao.getDesignacao().trim().isEmpty()) {
            System.out.println("A designação do pavilhão é obrigatória.");
            return false;
        }

        if (pavilhao.getNumero() == null || pavilhao.getNumero().trim().isEmpty()) {
            System.out.println("O número do pavilhão é obrigatório.");
            return false;
        }

        return estruturaDAO.atualizarPavilhao(pavilhao);
    }

    public boolean removerPavilhao(int id) {
        if (id <= 0) {
            return false;
        }

        return estruturaDAO.removerPavilhao(id);
    }

    // =========================
    // PISO
    // =========================

    public boolean adicionarPiso(Piso piso) {
        if (piso == null) {
            return false;
        }

        if (piso.getNumero() == null || piso.getNumero().trim().isEmpty()) {
            System.out.println("O número do piso é obrigatório.");
            return false;
        }

        if (piso.getPavilhao_id() <= 0) {
            System.out.println("O piso tem de estar associado a um pavilhão válido.");
            return false;
        }

        return estruturaDAO.inserirPiso(piso);
    }

    public List<Piso> listarPisos() {
        return estruturaDAO.listarPisos();
    }

    public List<Piso> listarPisosPorPavilhao(int pavilhaoId) {
        if (pavilhaoId <= 0) {
            return null;
        }

        return estruturaDAO.listarPisosPorPavilhao(pavilhaoId);
    }

    public Piso obterPisoPorId(int id) {
        if (id <= 0) {
            return null;
        }

        return estruturaDAO.buscarPisoPorId(id);
    }

    public boolean atualizarPiso(Piso piso) {
        if (piso == null || piso.getId() <= 0) {
            return false;
        }

        if (piso.getNumero() == null || piso.getNumero().trim().isEmpty()) {
            System.out.println("O número do piso é obrigatório.");
            return false;
        }

        if (piso.getPavilhao_id() <= 0) {
            System.out.println("O piso tem de estar associado a um pavilhão válido.");
            return false;
        }

        return estruturaDAO.atualizarPiso(piso);
    }

    public boolean removerPiso(int id) {
        if (id <= 0) {
            return false;
        }

        return estruturaDAO.removerPiso(id);
    }

    // =========================
    // SALA
    // =========================

    public boolean adicionarSala(Sala sala) {
        if (sala == null) {
            return false;
        }

        if (sala.getDesignacao() == null || sala.getDesignacao().trim().isEmpty()) {
            System.out.println("A designação da sala é obrigatória.");
            return false;
        }

        if (sala.getTipo() == null || sala.getTipo().trim().isEmpty()) {
            System.out.println("O tipo da sala é obrigatório.");
            return false;
        }

        if (sala.getLotacao() <= 0) {
            System.out.println("A lotação deve ser maior que zero.");
            return false;
        }

        if (sala.getNumero() == null || sala.getNumero().trim().isEmpty()) {
            System.out.println("O número da sala é obrigatório.");
            return false;
        }

        if (sala.getPiso_id() <= 0) {
            System.out.println("A sala tem de estar associada a um piso válido.");
            return false;
        }

        return estruturaDAO.inserirSala(sala);
    }

    public List<Sala> listarSalas() {
        return estruturaDAO.listarSalas();
    }

    public List<Sala> listarSalasPorPiso(int pisoId) {
        if (pisoId <= 0) {
            return null;
        }

        return estruturaDAO.listarSalasPorPiso(pisoId);
    }

    public Sala obterSalaPorId(int id) {
        if (id <= 0) {
            return null;
        }

        return estruturaDAO.buscarSalaPorId(id);
    }

    public boolean atualizarSala(Sala sala) {
        if (sala == null || sala.getId() <= 0) {
            return false;
        }

        if (sala.getDesignacao() == null || sala.getDesignacao().trim().isEmpty()) {
            System.out.println("A designação da sala é obrigatória.");
            return false;
        }

        if (sala.getTipo() == null || sala.getTipo().trim().isEmpty()) {
            System.out.println("O tipo da sala é obrigatório.");
            return false;
        }

        if (sala.getLotacao() <= 0) {
            System.out.println("A lotação deve ser maior que zero.");
            return false;
        }

        if (sala.getNumero() == null || sala.getNumero().trim().isEmpty()) {
            System.out.println("O número da sala é obrigatório.");
            return false;
        }

        if (sala.getPiso_id() <= 0) {
            System.out.println("A sala tem de estar associada a um piso válido.");
            return false;
        }

        return estruturaDAO.atualizarSala(sala);
    }

    public boolean removerSala(int id) {
        if (id <= 0) {
            return false;
        }

        return estruturaDAO.removerSala(id);
    }
}