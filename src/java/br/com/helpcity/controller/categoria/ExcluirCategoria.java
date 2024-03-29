package br.com.helpcity.controller.categoria;

import br.com.helpcity.DAO.CategoriaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ExcluirCategoria", urlPatterns = {"/deletecategory"})
public class ExcluirCategoria extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
        String mensagem = null;
        try {
            CategoriaDAO dao = new CategoriaDAO();
            if (dao.excluir(idCategoria)) {
                mensagem = "<div class=\"alert alert-success alert-dismissible\" role=\"alert\">\n"
                        + "                                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n"
                        + "                                Categoria excluida com sucesso!\n"
                        + "                            </div>";
            } else {
                mensagem = "<div class=\"alert alert-danger alert-dismissible\" role=\"alert\">\n"
                        + "                                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n"
                        + "                                Problemas ao excluir Categoria!\n"
                        + "                            </div>";
            }
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("categories").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas ao excluir Categoria! Erro: " + ex.getMessage());
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
