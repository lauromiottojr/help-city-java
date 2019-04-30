package br.com.helpcity.controller.ocorrencia;

import br.com.helpcity.DAO.GenericDAO;
import br.com.helpcity.DAO.OcorrenciaDAO;
import br.com.helpcity.model.Categoria;
import br.com.helpcity.model.Ocorrencia;
import br.com.helpcity.model.Secretaria;
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

@WebServlet(name = "AlterarOcorrencia", urlPatterns = {"/editoccurrence"})
public class AlterarOcorrencia extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        String mensagem = null;
        String tipoUsuario = (request.getSession().getAttribute("tipoUsuario").toString());
        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setStatusOcorrencia(request.getParameter("statusOcorrencia"));
        ocorrencia.setObservacaoOcorrencia(request.getParameter("observacaoOcorrencia"));
        if (tipoUsuario.equalsIgnoreCase("B")) {
            ocorrencia.setSecretariaOcorrencia(new Secretaria(Integer.parseInt(request.getParameter("secretariaOcorrencia"))));
            ocorrencia.setCategoriaOcorrencia(new Categoria(Integer.parseInt(request.getParameter("categoriaOcorrencia"))));
        } else if (tipoUsuario.equalsIgnoreCase("C")) {
            int idSecretaria = Integer.parseInt(request.getSession().getAttribute("secretariaFuncionario").toString());
            int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
            ocorrencia.setCategoriaOcorrencia(new Categoria(idCategoria));
            ocorrencia.setSecretariaOcorrencia(new Secretaria(idSecretaria));
        }
        ocorrencia.setIdOcorrencia(Integer.parseInt(request.getParameter("idOcorrencia")));
        if (request.getParameter("statusOcorrencia").equalsIgnoreCase("Nova")) {
            ocorrencia.setStatusOcorrencia("Encaminhada");
        }
        try {
            GenericDAO dao = new OcorrenciaDAO();
            if (dao.alterar(ocorrencia)) {
                mensagem = "<div class=\"alert alert-success alert-dismissible\" role=\"alert\">\n"
                        + "                                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n"
                        + "                                Ocorrência encaminhada com sucesso!\n"
                        + "                            </div>";
            } else {
                mensagem = "<div class=\"alert alert-danger alert-dismissible\" role=\"alert\">\n"
                        + "                                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n"
                        + "                                Problemas ao encaminhar Ocorrência. Verifique os dados informados e tente novamente!\n"
                        + "                            </div>";
            }
            request.setAttribute("mensagem", mensagem);
            if (tipoUsuario.equalsIgnoreCase("B")) {
                request.getRequestDispatcher("occurrencehistory").forward(request, response);
            } else if (tipoUsuario.equalsIgnoreCase("C")) {
                request.getRequestDispatcher("occurrencehistory").forward(request, response);
            }
        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao encaminhar Ocorrência! Erro: " + ex.getMessage());
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
            Logger.getLogger(AlterarOcorrencia.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AlterarOcorrencia.class.getName()).log(Level.SEVERE, null, ex);
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
