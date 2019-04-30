package br.com.helpcity.controller.admpref;

import br.com.helpcity.DAO.GenericDAO;
import br.com.helpcity.DAO.AdmPrefDAO;
import br.com.helpcity.model.AdmPref;
import br.com.helpcity.model.Cidade;
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

@WebServlet(name = "SalvarAdmPref", urlPatterns = {"/newadmpref", "/editadmpref"})
public class SalvarAdmPref extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {

        String mensagem = null;
        String tipoUsuario = (request.getSession().getAttribute("tipoUsuario").toString());
        AdmPref admPref = new AdmPref();
        admPref.setNomeUsuario(request.getParameter("nomeUsuario"));
        admPref.setCpfUsuario(request.getParameter("cpfUsuario"));
        admPref.setRgUsuario(request.getParameter("rgUsuario"));
        admPref.setEmailUsuario(request.getParameter("emailUsuario"));
        admPref.setTelefoneUsuario(request.getParameter("telefoneUsuario"));
        admPref.setDataNascimentoUsuario(Conversoes.converterData(request.getParameter("dataNascimentoUsuario")));
        admPref.setSexoUsuario(request.getParameter("sexoUsuario"));
        if (tipoUsuario.equalsIgnoreCase("A")) {
            admPref.setCidadeAdmPref(new Cidade(Integer.parseInt(request.getParameter("cidadeUsuario"))));
        } else if (tipoUsuario.equalsIgnoreCase("B")) {
            int idCidade = Integer.parseInt(request.getSession().getAttribute("idCidade").toString());
            admPref.setCidadeAdmPref(new Cidade(idCidade));
        }
        try {
            GenericDAO dao = new AdmPrefDAO();
            if (request.getParameter("idUsuario") == null) {
                admPref.setLoginUsuario(request.getParameter("loginUsuario"));
                admPref.setSenhaUsuario(request.getParameter("senhaUsuario"));
                Date data = new Date();
                admPref.setDataCadastroUsuario(data);
                admPref.setStatusUsuario("A");
                admPref.setTipoUsuario("B");
                if (dao.cadastrar(admPref)) {
                    mensagem = "<div class=\"alert alert-success alert-dismissible\" role=\"alert\">\n"
                            + "                                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n"
                            + "                                ADMPREF cadastrado com sucesso!\n"
                            + "                            </div>";
                } else {
                    mensagem = "<div class=\"alert alert-danger alert-dismissible\" role=\"alert\">\n"
                            + "                                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n"
                            + "                                Problemas ao cadastrar ADMPREF. Verifique os dados informados e tente novamente!\n"
                            + "                            </div>";
                }
            } else {
                admPref.setStatusUsuario(request.getParameter("statusUsuario"));
                admPref.setIdAdmPref(Integer.parseInt(request.getParameter("idAdmPref")));
                admPref.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));
                admPref.setCidadeAdmPref(new Cidade(Integer.parseInt(request.getParameter("cidadeUsuario"))));
                if (dao.alterar(admPref)) {
                    mensagem = "<div class=\"alert alert-success alert-dismissible\" role=\"alert\">\n"
                            + "                                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n"
                            + "                                ADMPREF alterado com sucesso!\n"
                            + "                            </div>";
                } else {
                    mensagem = "<div class=\"alert alert-danger alert-dismissible\" role=\"alert\">\n"
                            + "                                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n"
                            + "                                Problemas ao alterar ADMPREF. Verifique os dados informados e tente novamente!\n"
                            + "                            </div>";
                }

            }
            request.setAttribute("mensagem", mensagem);
            if (tipoUsuario.equalsIgnoreCase("A")) {
                request.getRequestDispatcher("admprefs").forward(request, response);
            } else if (tipoUsuario.equalsIgnoreCase("B")) {
                request.getRequestDispatcher("admprefs").forward(request, response);
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
            Logger.getLogger(SalvarAdmPref.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SalvarAdmPref.class.getName()).log(Level.SEVERE, null, ex);
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
