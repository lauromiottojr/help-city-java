package br.com.helpcity.controller.usuario;

import br.com.helpcity.DAO.UsuarioDAO;
import br.com.helpcity.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlterarStatusUsuario", urlPatterns = {"/userstatus"})
public class AlterarStatusUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {

        String tipoUsuarioAlter = request.getParameter("tipoUsuarioAlter");
        String mensagem = null;
        Usuario usuario = new Usuario();
        usuario.setStatusUsuario("I");
        usuario.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));
        try {
            UsuarioDAO dao = new UsuarioDAO();
            if (dao.alterarStatus(usuario)) {
                mensagem = "<div class=\"alert alert-success alert-dismissible\" role=\"alert\">\n"
                        + "                                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n"
                        + "                                ADM desativado com sucesso!\n"
                        + "                            </div>";
            } else {
                mensagem = "<div class=\"alert alert-danger alert-dismissible\" role=\"alert\">\n"
                        + "                                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n"
                        + "                                Problemas ao desativar ADM!\n"
                        + "                            </div>";
            }
            request.setAttribute("mensagem", mensagem);
            if (tipoUsuarioAlter.equalsIgnoreCase("A")) {
                request.getRequestDispatcher("adms").forward(request, response);
            } else if (tipoUsuarioAlter.equalsIgnoreCase("B")) {
                request.getRequestDispatcher("admprefs").forward(request, response);

            } else if (tipoUsuarioAlter.equalsIgnoreCase("C")) {
                request.getRequestDispatcher("employees").forward(request, response);
            } else if (tipoUsuarioAlter.equalsIgnoreCase("D")) {
                request.getRequestDispatcher("citizens").forward(request, response);
            }
        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao alterar Usuário! Erro: " + ex.getMessage());
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(AlterarStatusUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(AlterarStatusUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
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
