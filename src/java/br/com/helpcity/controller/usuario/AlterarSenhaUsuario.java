package br.com.helpcity.controller.usuario;

import br.com.helpcity.DAO.UsuarioDAO;
import br.com.helpcity.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlterarSenhaUsuario", urlPatterns = {"/edituserpass"})
public class AlterarSenhaUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {

        String mensagem = null;
        String tipoUsuario = (request.getSession().getAttribute("tipoUsuario").toString());
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        usuario.setSenhaUsuario(request.getParameter("senhaUsuario"));
        try {
            UsuarioDAO dao = new UsuarioDAO();
            if (dao.alterarSenha(usuario)) {
                mensagem = "<div class=\"alert alert-success alert-dismissible\" role=\"alert\">\n"
                        + "                                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n"
                        + "                                Senha alterada com sucesso!\n"
                        + "                            </div>";
            } else {
                mensagem = "<div class=\"alert alert-danger alert-dismissible\" role=\"alert\">\n"
                        + "                                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n"
                        + "                                Problemas ao alterar senha. Verifique os dados informados e tente novamente!\n"
                        + "                            </div>";
            }
            request.setAttribute("mensagem", mensagem);
            if (tipoUsuario.equalsIgnoreCase("A")) {
                request.getRequestDispatcher("dashboard").forward(request, response);
            } else if (tipoUsuario.equalsIgnoreCase("B")) {
                request.getRequestDispatcher("dashboard").forward(request, response);
            } else if (tipoUsuario.equalsIgnoreCase("C")) {
                request.getRequestDispatcher("dashboard").forward(request, response);
            } else if (tipoUsuario.equalsIgnoreCase("D")) {
                request.getRequestDispatcher("dashboard").forward(request, response);
            }
        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao cadastrar ADMPREF. Erro:" + ex.getMessage());
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
            Logger.getLogger(AlterarSenhaUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AlterarSenhaUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
