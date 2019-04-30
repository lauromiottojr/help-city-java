package br.com.helpcity.controller.cidadao;

import br.com.helpcity.DAO.GenericDAO;
import br.com.helpcity.DAO.CidadaoDAO;
import br.com.helpcity.model.Cidadao;
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

@WebServlet(name = "CadastrarCidadao", urlPatterns = {"/newuser"})
public class CadastrarCidadao extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        String mensagem = null;
        Cidadao cidadao = new Cidadao();
        Date data = new Date();
        cidadao.setNomeUsuario(request.getParameter("nomeUsuario"));
        cidadao.setCpfUsuario(request.getParameter("cpfUsuario"));
        cidadao.setRgUsuario(request.getParameter("rgUsuario"));
        cidadao.setEmailUsuario(request.getParameter("emailUsuario"));
        cidadao.setTelefoneUsuario(request.getParameter("telefoneUsuario"));
        cidadao.setDataNascimentoUsuario(Conversoes.converterData(request.getParameter("dataNascimentoUsuario")));
        cidadao.setSexoUsuario(request.getParameter("sexoUsuario"));
        cidadao.setLoginUsuario(request.getParameter("loginUsuario"));
        cidadao.setSenhaUsuario(request.getParameter("senhaUsuario"));
        cidadao.setDataCadastroUsuario(data);
        cidadao.setStatusUsuario("A");
        cidadao.setTipoUsuario("D");
        cidadao.setCidadeCidadao(new Cidade(Integer.parseInt(request.getParameter("cidadeUsuario"))));
        try {
            GenericDAO dao = new CidadaoDAO();
            if (dao.cadastrar(cidadao)) {
                mensagem = "Cadastrado com sucesso!";
            } else {
                mensagem = "Problemas ao cadastrar. Verifique os dados informados e tente novamente!";
            }
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
            Logger.getLogger(CadastrarCidadao.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CadastrarCidadao.class.getName()).log(Level.SEVERE, null, ex);
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
