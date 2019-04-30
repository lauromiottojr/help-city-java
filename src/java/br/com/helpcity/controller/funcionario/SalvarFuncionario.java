package br.com.helpcity.controller.funcionario;

import br.com.helpcity.DAO.GenericDAO;
import br.com.helpcity.DAO.FuncionarioDAO;
import br.com.helpcity.model.Funcionario;
import br.com.helpcity.model.Secretaria;
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

@WebServlet(name = "SalvarFuncionario", urlPatterns = {"/newemployee", "/editemployee"})
public class SalvarFuncionario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {

        String mensagem = null;
        String tipoUsuario = request.getSession().getAttribute("tipoUsuario").toString();
        Funcionario funcionario = new Funcionario();
        funcionario.setNomeUsuario(request.getParameter("nomeUsuario"));
        funcionario.setCpfUsuario(request.getParameter("cpfUsuario"));
        funcionario.setRgUsuario(request.getParameter("rgUsuario"));
        funcionario.setEmailUsuario(request.getParameter("emailUsuario"));
        funcionario.setTelefoneUsuario(request.getParameter("telefoneUsuario"));
        funcionario.setDataNascimentoUsuario(Conversoes.converterData(request.getParameter("dataNascimentoUsuario")));
        funcionario.setSexoUsuario(request.getParameter("sexoUsuario"));
        funcionario.setSecretariaFuncionario(new Secretaria(Integer.parseInt(request.getParameter("secretariaFuncionario"))));
        try {
            GenericDAO dao = new FuncionarioDAO();
            if (request.getParameter("idUsuario") == null) {
                funcionario.setLoginUsuario(request.getParameter("loginUsuario"));
                funcionario.setSenhaUsuario(request.getParameter("senhaUsuario"));
                Date data = new Date();
                funcionario.setDataCadastroUsuario(data);
                funcionario.setStatusUsuario("A");
                funcionario.setTipoUsuario("C");
                if (dao.cadastrar(funcionario)) {
                    mensagem = "<div class=\"alert alert-success alert-dismissible\" role=\"alert\">\n"
                            + "                                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n"
                            + "                                Funcionário cadastrado com sucesso!\n"
                            + "                            </div>";
                } else {
                    mensagem = "<div class=\"alert alert-danger alert-dismissible\" role=\"alert\">\n"
                            + "                                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n"
                            + "                                Problemas ao cadastrar Funcionário. Verifique os dados informados e tente novamente!\n"
                            + "                            </div>";
                }
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("employees").forward(request, response);
            } else {
                funcionario.setIdFuncionario(Integer.parseInt(request.getParameter("idFuncionario")));
                funcionario.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));
                funcionario.setStatusUsuario(request.getParameter("statusUsuario"));
                if (dao.alterar(funcionario)) {
                    mensagem = "<div class=\"alert alert-success alert-dismissible\" role=\"alert\">\n"
                            + "                                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n"
                            + "                                Funcionário alterado com sucesso!\n"
                            + "                            </div>";
                } else {
                    mensagem = "<div class=\"alert alert-danger alert-dismissible\" role=\"alert\">\n"
                            + "                                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n"
                            + "                                Problemas ao alterar Funcionário. Verifique os dados informados e tente novamente!\n"
                            + "                            </div>";
                }
                request.setAttribute("mensagem", mensagem);
                if (tipoUsuario.equalsIgnoreCase("A")) {
                    request.getRequestDispatcher("employees").forward(request, response);
                } else {
                    request.getRequestDispatcher("employees").forward(request, response);
                }
            }
        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao cadastrar Funcionário. Erro:" + ex.getMessage());
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
            Logger.getLogger(SalvarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SalvarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
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
