package br.com.helpcity.controller.usuario;

import br.com.helpcity.DAO.CidadaoDAO;
import br.com.helpcity.DAO.CidadeDAO;
import br.com.helpcity.DAO.EstadoDAO;
import br.com.helpcity.DAO.GenericDAO;
import br.com.helpcity.DAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CarregarPerfilUsuario", urlPatterns = {"/userprofile"})
public class CarregarPerfilUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idUsuario = Integer.parseInt(request.getSession().getAttribute("idUsuario").toString());
        String tipoUsuario = (request.getSession().getAttribute("tipoUsuario").toString());
        try {
            if (!tipoUsuario.equalsIgnoreCase("D")) {
                UsuarioDAO dao = new UsuarioDAO();
                request.setAttribute("usuario", dao.carregar(idUsuario));
            } else {
                GenericDAO dao = new CidadaoDAO();
                GenericDAO daoe = new EstadoDAO();
                GenericDAO daoc = new CidadeDAO();
                request.setAttribute("usuario", dao.carregar(idUsuario));
                request.setAttribute("estados", daoe.listar());
                request.setAttribute("cidades", daoc.listar());
            }
            request.getRequestDispatcher("edit/perfil_usuario.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas ao carregar dados do Usuário! Erro: " + ex.getMessage());
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
