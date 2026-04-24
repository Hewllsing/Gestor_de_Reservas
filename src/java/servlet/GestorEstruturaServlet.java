/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.GestorEstruturaService;
import model.Pavilhao;
import java.util.List;

/**
 *
 * @author formando
 */
@WebServlet(name = "GestorEstruturaServlet", urlPatterns = {"/GestorEstruturaServlet", "/listarPavilhoes", "/adicionarPavilhao"})
public class GestorEstruturaServlet extends HttpServlet {

    private GestorEstruturaService estruturaService;

    // Fiz um construtor para nao ter que inicializar dentro dos metodos
    @Override
    public void init() throws ServletException {
        estruturaService = new GestorEstruturaService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String servletPath = request.getServletPath();

        switch (servletPath) {
            case "/listarPavilhoes":
                listarPavilhoes(request, response);
                break;

            case "":
                break;

            default:
                listarPavilhoes(request, response);
        }
    }

    private void listarPavilhoes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Pavilhao> listaPavilhoes = estruturaService.listarPavilhoes();

        request.setAttribute("listaPavilhoes", listaPavilhoes);

        request.getRequestDispatcher("/listarPavilhoes.jsp").forward(request, response);
    }

    private void adicionarPavilhao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String designacao = request.getParameter("txtDesignacao");
        String num = request.getParameter("txtNumero");

        Pavilhao p = new Pavilhao(designacao, num);
        estruturaService.adicionarPavilhao(p);

        response.sendRedirect("listarPavilhoes");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                String servletPath = request.getServletPath();

        switch (servletPath) {
            case "/adicionarPavilhao":
                adicionarPavilhao(request, response);
                break;

            default:
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
