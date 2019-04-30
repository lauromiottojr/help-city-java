package br.com.helpcity.controller.usuario;

import br.com.helpcity.DAO.GenericDAO;
import br.com.helpcity.DAO.AdmDAO;
import br.com.helpcity.DAO.AdmPrefDAO;
import br.com.helpcity.DAO.CidadaoDAO;
import br.com.helpcity.DAO.FuncionarioDAO;
import br.com.helpcity.DAO.UsuarioDAO;
import br.com.helpcity.model.Adm;
import br.com.helpcity.model.AdmPref;
import br.com.helpcity.model.Cidadao;
import br.com.helpcity.model.Funcionario;
import br.com.helpcity.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LogarUsuario", urlPatterns = {"/login", "/logout"})
public class LogarUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (request.getParameter("acao").equals("logar")) {
            if (!request.getParameter("loginUsuario").equals("") && !request.getParameter("senhaUsuario").equals("")) {
                try {
                    Usuario usuario = new Usuario();
                    usuario.setLoginUsuario(request.getParameter("loginUsuario"));
                    usuario.setSenhaUsuario(request.getParameter("senhaUsuario"));
                    String mensagem = "Login ou senha inválidos!";
                    UsuarioDAO dao = new UsuarioDAO();
                    usuario = dao.logar(usuario);
                    if (usuario.getIdUsuario() != null) {
                        HttpSession sessao = request.getSession(true);
                        sessao.setAttribute("idUsuario", usuario.getIdUsuario());
                        sessao.setAttribute("nomeUsuario", usuario.getNomeUsuario());
                        sessao.setAttribute("tipoUsuario", usuario.getTipoUsuario());
                        sessao.setAttribute("sexoUsuario", usuario.getSexoUsuario());
                        sessao.setAttribute("statusUsuario", usuario.getStatusUsuario());
                        if (usuario.getTipoUsuario().equalsIgnoreCase("A")) {
                            GenericDAO daoADM = new AdmDAO();
                            Adm adm = (Adm) daoADM.carregar(usuario.getIdUsuario());
                            sessao.setAttribute("idAdm", adm.getIdAdm());
                            request.getRequestDispatcher("dashboard").forward(request, response);
                        } else if (usuario.getTipoUsuario().equalsIgnoreCase("B")) {
                            GenericDAO daoAdmPref = new AdmPrefDAO();
                            AdmPref admPref = (AdmPref) daoAdmPref.carregar(usuario.getIdUsuario());
                            sessao.setAttribute("idAdmPref", admPref.getIdAdmPref());
                            sessao.setAttribute("idCidade", admPref.getCidadeAdmPref().getIdCidade());
                            sessao.setAttribute("nomeCidade", admPref.getCidadeAdmPref().getNomeCidade());
                            sessao.setAttribute("statusCidade", admPref.getCidadeAdmPref().getStatusCidade());
                            request.getRequestDispatcher("dashboard").forward(request, response);
                        } else if (usuario.getTipoUsuario().equalsIgnoreCase("C")) {
                            GenericDAO daoFuncionario = new FuncionarioDAO();
                            Funcionario funcionario = (Funcionario) daoFuncionario.carregar(usuario.getIdUsuario());
                            sessao.setAttribute("idFuncionario", funcionario.getIdFuncionario());
                            sessao.setAttribute("idCidade", funcionario.getSecretariaFuncionario().getCidadeSecretaria().getIdCidade());
                            sessao.setAttribute("nomeCidade", funcionario.getSecretariaFuncionario().getCidadeSecretaria().getNomeCidade());
                            sessao.setAttribute("secretariaFuncionario", funcionario.getSecretariaFuncionario().getIdSecretaria());
                            sessao.setAttribute("nomeSecretariaFuncionario", funcionario.getSecretariaFuncionario().getNomeSecretaria());
                            sessao.setAttribute("statusCidade", funcionario.getSecretariaFuncionario().getCidadeSecretaria().getStatusCidade());
                            request.getRequestDispatcher("dashboard").forward(request, response);
                        } else if (usuario.getTipoUsuario().equalsIgnoreCase("D")) {
                            GenericDAO daoCidadao = new CidadaoDAO();
                            Cidadao cidadao = (Cidadao) daoCidadao.carregar(usuario.getIdUsuario());
                            sessao.setAttribute("idCidadao", cidadao.getIdCidadao());
                            sessao.setAttribute("idCidade", cidadao.getCidadeCidadao().getIdCidade());
                            sessao.setAttribute("nomeCidade", cidadao.getCidadeCidadao().getNomeCidade());
                            sessao.setAttribute("statusCidade", cidadao.getCidadeCidadao().getStatusCidade());
                            request.getRequestDispatcher("dashboard").forward(request, response);
                        } else {
                            request.getRequestDispatcher("index.jsp").forward(request, response);
                        }
                    } else {
                        request.setAttribute("mensagem", mensagem);
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                } catch (Exception ex) {
                    System.out.println("Problemas no servlet ao Logar. Erro: " + ex.getMessage());
                    ex.printStackTrace();
                }
            } else {
                request.setAttribute("mensagem", "Preencha login e senha para iniciar!");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else if (request.getParameter("acao").equals("logout")) {
            try {
                HttpSession sessao = request.getSession(true);
                // encerrar a sessão
                sessao.invalidate();
                String mensagem = "";
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } catch (Exception ex) {
                System.out.println("Erro ao realizar logout no LogarUsuario. Erro: " + ex.getMessage());
            }
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
