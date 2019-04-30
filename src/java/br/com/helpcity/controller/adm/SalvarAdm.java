package br.com.helpcity.controller.adm;

import br.com.helpcity.DAO.GenericDAO;
import br.com.helpcity.DAO.AdmDAO;
import br.com.helpcity.model.Adm;
import br.com.helpcity.util.Conversoes;
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

@WebServlet(name = "SalvarAdm", urlPatterns = {"/newadm", "/editadm"})
public class SalvarAdm extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {

        String mensagem = null;
        Adm adm = new Adm();
        adm.setNomeUsuario(request.getParameter("nomeUsuario"));
        adm.setCpfUsuario(request.getParameter("cpfUsuario"));
        adm.setRgUsuario(request.getParameter("rgUsuario"));
        adm.setEmailUsuario(request.getParameter("emailUsuario"));
        adm.setTelefoneUsuario(request.getParameter("telefoneUsuario"));
        adm.setDataNascimentoUsuario(Conversoes.converterData(request.getParameter("dataNascimentoUsuario")));
        adm.setSexoUsuario(request.getParameter("sexoUsuario"));
        try {
            GenericDAO dao = new AdmDAO();
            if (request.getParameter("idUsuario") == null) {
                adm.setLoginUsuario(request.getParameter("loginUsuario"));
                adm.setSenhaUsuario(request.getParameter("senhaUsuario"));
                Date data = new Date();
                adm.setDataCadastroUsuario(data);
                adm.setStatusUsuario("A");
                adm.setTipoUsuario("A");
                if (dao.cadastrar(adm)) {
                    mensagem = "<div class=\"alert alert-success alert-dismissible\" role=\"alert\">\n"
                            + "                                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n"
                            + "                                ADM cadastrado com sucesso!\n"
                            + "                            </div>";
                } else {
                    mensagem = "<div class=\"alert alert-danger alert-dismissible\" role=\"alert\">\n"
                            + "                                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n"
                            + "                                Problemas ao cadastrar ADM. Verifique os dados informados e tente novamente!\n"
                            + "                            </div>";
                }
            } else {
                adm.setStatusUsuario(request.getParameter("statusUsuario"));
                adm.setIdAdm(Integer.parseInt(request.getParameter("idAdm")));
                adm.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));
                if (dao.alterar(adm)) {
                    mensagem = "<div class=\"alert alert-success alert-dismissible\" role=\"alert\">\n"
                            + "                                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n"
                            + "                                ADM alterado com sucesso!\n"
                            + "                            </div>";
                } else {
                    mensagem = "<div class=\"alert alert-danger alert-dismissible\" role=\"alert\">\n"
                            + "                                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n"
                            + "                                Problemas ao alterar ADM. Verifique os dados informados e tente novamente!\n"
                            + "                            </div>";
                }
            }
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("adms").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao cadastrar alterar ADM! Erro: " + ex.getMessage());
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
            Logger.getLogger(SalvarAdm.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SalvarAdm.class.getName()).log(Level.SEVERE, null, ex);
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
