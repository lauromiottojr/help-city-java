package br.com.helpcity.controller.admpref;

import br.com.helpcity.DAO.AdmPrefDAO;
import br.com.helpcity.DAO.CidadeDAO;
import br.com.helpcity.DAO.EstadoDAO;
import br.com.helpcity.DAO.GenericDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CarregarAdmPref", urlPatterns = {"/admpref"})
public class CarregarAdmPref extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        String tipoUsuario = (request.getSession().getAttribute("tipoUsuario").toString());
        try {
            GenericDAO dao = new AdmPrefDAO();
            if (tipoUsuario.equalsIgnoreCase("A")) {
                GenericDAO daoe = new EstadoDAO();
                GenericDAO daoc = new CidadeDAO();
                request.setAttribute("admpref", dao.carregar(idUsuario));
                request.setAttribute("estados", daoe.listar());
                request.setAttribute("cidades", daoc.listar());
            } else if (tipoUsuario.equalsIgnoreCase("B")) {
                request.setAttribute("admpref", dao.carregar(idUsuario));
            }
            request.getRequestDispatcher("edit/admpref.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas ao carregar dados do ADMPREF! Erro: " + ex.getMessage());
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
