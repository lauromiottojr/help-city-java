package br.com.helpcity.controller.admpref;

import br.com.helpcity.DAO.GenericDAO;
import br.com.helpcity.DAO.AdmPrefDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListarAdmPref", urlPatterns = {"/admprefs"})
public class ListarAdmPref extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String tipoUsuario = (request.getSession().getAttribute("tipoUsuario").toString());
        try {
            GenericDAO dao = new AdmPrefDAO();
            if (tipoUsuario.equalsIgnoreCase("A")) {
                request.setAttribute("admprefs", dao.listar());
            } else if (tipoUsuario.equalsIgnoreCase("B")) {
                int idCidade = Integer.parseInt(request.getSession().getAttribute("idCidade").toString());
                request.setAttribute("admprefs", dao.listarCidade(idCidade));
            }
            request.getRequestDispatcher("consult/admpref.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao listar ADMPREF! Erro: " + ex.getMessage());
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
