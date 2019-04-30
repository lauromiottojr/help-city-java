package br.com.helpcity.controller.ocorrencia;

import br.com.helpcity.DAO.GenericDAO;
import br.com.helpcity.DAO.OcorrenciaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListarOcorrenciaCidade", urlPatterns = {"/occurrencehistory"})
public class ListarOcorrenciaCidade extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String tipoUsuario = request.getSession().getAttribute("tipoUsuario").toString();
        try {
            if (tipoUsuario.equalsIgnoreCase("B")) {
                GenericDAO dao = new OcorrenciaDAO();
                int idCidade = Integer.parseInt(request.getSession().getAttribute("idCidade").toString());
                request.setAttribute("ocorrencias", dao.listarCidade(idCidade));
            } else if (tipoUsuario.equalsIgnoreCase("C")) {
                OcorrenciaDAO dao = new OcorrenciaDAO();
                int idSecretaria = Integer.parseInt(request.getSession().getAttribute("secretariaFuncionario").toString());
                request.setAttribute("ocorrencias", dao.listarSecretaria(idSecretaria));
            }
            request.getRequestDispatcher("occurrences/historico.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao listar Ocorrência! Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
