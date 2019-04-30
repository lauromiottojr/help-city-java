package br.com.helpcity.controller.secretaria;

import br.com.helpcity.DAO.GenericDAO;
import br.com.helpcity.DAO.SecretariaDAO;
import br.com.helpcity.model.Secretaria;
import br.com.helpcity.model.Cidade;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SalvarSecretaria", urlPatterns = {"/newdepartament", "/editdepartament"})
public class SalvarSecretaria extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        String mensagem = null;
        Secretaria secretaria = new Secretaria();
        secretaria.setNomeSecretaria(request.getParameter("nomeSecretaria"));
        secretaria.setEmailSecretaria(request.getParameter("emailSecretaria"));
        secretaria.setTelefoneSecretaria(request.getParameter("telefoneSecretaria"));
        try {
            GenericDAO dao = new SecretariaDAO();
            if (request.getParameter("idSecretaria") == null) {
                int idCidade = Integer.parseInt(request.getSession().getAttribute("idCidade").toString());
                Date data = new Date();
                secretaria.setDataCadastroSecretaria(data);
                secretaria.setCidadeSecretaria(new Cidade(idCidade));
                if (dao.cadastrar(secretaria)) {
                    mensagem = "<div class=\"alert alert-success alert-dismissible\" role=\"alert\">\n"
                            + "                                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n"
                            + "                                Secretaria cadastrada com sucesso!\n"
                            + "                            </div>";
                } else {
                    mensagem = "<div class=\"alert alert-danger alert-dismissible\" role=\"alert\">\n"
                            + "                                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n"
                            + "                                Problemas ao cadastrar Secretaria. Verifique os dados informados e tente novamente!\n"
                            + "                            </div>";
                }
            } else {
                secretaria.setIdSecretaria(Integer.parseInt(request.getParameter("idSecretaria")));
                if (dao.alterar(secretaria)) {
                    mensagem = "<div class=\"alert alert-success alert-dismissible\" role=\"alert\">\n"
                            + "                                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n"
                            + "                                Secretaria alterada com sucesso!\n"
                            + "                            </div>";
                } else {
                    mensagem = "<div class=\"alert alert-danger alert-dismissible\" role=\"alert\">\n"
                            + "                                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n"
                            + "                                Problemas ao alterar Secretaria. Verifique os dados informados e tente novamente!\n"
                            + "                            </div>";
                }
            }
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("departments").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao cadastrar Cidadão. Erro:" + ex.getMessage());
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
            Logger.getLogger(SalvarSecretaria.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SalvarSecretaria.class.getName()).log(Level.SEVERE, null, ex);
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
