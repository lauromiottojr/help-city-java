package br.com.helpcity.controller.funcionario;

import br.com.helpcity.DAO.CidadeDAO;
import br.com.helpcity.DAO.EstadoDAO;
import br.com.helpcity.DAO.FuncionarioDAO;
import br.com.helpcity.DAO.GenericDAO;
import br.com.helpcity.DAO.SecretariaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CarregarFuncionario", urlPatterns = {"/employee"})
public class CarregarFuncionario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        String tipoUsuario = request.getSession().getAttribute("tipoUsuario").toString();
        try {
            GenericDAO dao = new FuncionarioDAO();
            request.setAttribute("funcionario", dao.carregar(idUsuario));
            if (tipoUsuario.equalsIgnoreCase("A")) {
                GenericDAO daoe = new EstadoDAO();
                request.setAttribute("estados", daoe.listar());
                GenericDAO daoc = new CidadeDAO();
                request.setAttribute("cidades", daoc.listar());
                GenericDAO daos = new SecretariaDAO();
                request.setAttribute("secretarias", daos.listar());
            } else {
                int idCidade = Integer.parseInt(request.getSession().getAttribute("idCidade").toString());
                GenericDAO daof = new SecretariaDAO();
                request.setAttribute("secretarias", daof.listarCidade(idCidade));
            }
            request.getRequestDispatcher("edit/funcionario.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas ao carregar dados do Funcionário! Erro: " + ex.getMessage());
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
