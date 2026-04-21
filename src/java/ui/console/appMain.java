/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.console;
import dao.ConexaoBD;
import dao.GestorEstruturaDAO;
import dao.GestorReservaDAO;
import model.Pavilhao;

/**
 *
 * @author formando
 */
public class appMain {
    public static void main(String[] args) {

        GestorEstruturaDAO estrutura = new GestorEstruturaDAO();
        GestorReservaDAO reservaDAO = new GestorReservaDAO();

        // Testar conexão
        System.out.println(ConexaoBD.testarConexao());

        // Inserir pavilhão
        Pavilhao p = new Pavilhao(0, "Principal", "A");
        estrutura.inserirPavilhao(p);

        // Listar reservas com JOIN
        for (String r : reservaDAO.listarReservasDetalhadas()) {
            System.out.println(r);
        }
    }
}
