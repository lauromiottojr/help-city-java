package br.com.helpcity.controller.ocorrencia;

import br.com.helpcity.DAO.ImagemDAO;
import br.com.helpcity.DAO.OcorrenciaDAO;
import br.com.helpcity.model.Ocorrencia;
import br.com.helpcity.model.Cidade;
import br.com.helpcity.model.Imagem;
import br.com.helpcity.model.Usuario;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(name = "CadastrarOcorrencia", urlPatterns = {"/newoccurrence"})
public class CadastrarOcorrencia extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, FileUploadException, Exception {
        OcorrenciaDAO ocorrenciaDAO = null;
        try {
            ocorrenciaDAO = new OcorrenciaDAO();
        } catch (Exception ex) {
        }
        Imagem imagem = new Imagem();
        Date data = new Date();
        Boolean img = false;
        String tipoUsuario = "";
        String caminho_imagem = "";
        Integer idUsuario = null;
        Integer idCidade = null;
        String mensagem = null;
        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setDataCriacaoOcorrencia(data);
        ocorrencia.setStatusOcorrencia("Nova");
        Integer id = (ocorrenciaDAO.retornarId()) + 1;
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setSizeMax(50 * 1024 * 1024);
            List items = upload.parseRequest(request);
            Iterator it = items.iterator();
            while (it.hasNext()) {
                FileItem fileitem = (FileItem) it.next();
                if (!fileitem.isFormField() && (!fileitem.getName().equals(""))) {
                    try {
                        img = true;
                        fileitem.write(new File("C:/Users/JR/Documents/FATEC/TG/HelpCity/web/imgOcr/" + id + "_" + fileitem.getName()));
                        caminho_imagem = "imgOcr/" + id + "_" + fileitem.getName();
                        imagem.setNomeImagem(caminho_imagem);
                        imagem.setOcorrenciaImagem(new Ocorrencia(id));
                        ImagemDAO imagemDAO = new ImagemDAO();
                        imagemDAO.cadastrarImagem(imagem);
                    } catch (Exception ex) {
                        System.out.println("Problemas ao pegar o nome do arquivo! Erro:" + ex.getMessage());
                        ex.printStackTrace();
                    }
                } else {
                    String dados = fileitem.getFieldName();
                    if (dados.equals("tipoUsuario")) {
                        tipoUsuario = fileitem.getString();
                    } else if (dados.equals("idUsuario")) {
                        idUsuario = Integer.parseInt(fileitem.getString());
                        ocorrencia.setUsuarioOcorrencia(new Usuario(idUsuario));
                    } else if (dados.equals("idCidade")) {
                        idCidade = Integer.parseInt(fileitem.getString());
                        ocorrencia.setCidadeOcorrencia(new Cidade(idCidade));
                    } else if (dados.equals("txtEndereco")) {
                        ocorrencia.setLocalizacaoOcorrencia(fileitem.getString());
                    } else if (dados.equals("txtLatitude")) {
                        ocorrencia.setLatitudeOcorrencia(fileitem.getString());
                    } else if (dados.equals("txtLongitude")) {
                        ocorrencia.setLongitudeOcorrencia(fileitem.getString());
                        try {
                            if (ocorrenciaDAO.cadastrarOcorrencia(ocorrencia)) {
                                mensagem = "<div class=\"alert alert-success alert-dismissible\" role=\"alert\">\n"
                                        + "                                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n"
                                        + "                                Ocorrência criada com sucesso!\n"
                                        + "                            </div>";
                            } else {
                                mensagem = "<div class=\"alert alert-danger alert-dismissible\" role=\"alert\">\n"
                                        + "                                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n"
                                        + "                                Problemas ao criar Ocorrência. Verifique os dados informados e tente novamente!\n"
                                        + "                            </div>";
                            }
                            request.setAttribute("mensagem", mensagem);
                            if (tipoUsuario.equalsIgnoreCase("B")) {
                                request.getRequestDispatcher("dashboard").forward(request, response);
                            } else if (tipoUsuario.equalsIgnoreCase("C")) {
                                request.getRequestDispatcher("dashboard").forward(request, response);
                            } else if (tipoUsuario.equalsIgnoreCase("D")) {
                                request.getRequestDispatcher("dashboard").forward(request, response);
                            }
                        } catch (Exception ex) {
                            System.out.println("Problemas no Servlet ao cadastrar Ocorrência. Erro: " + ex.getMessage());
                            ex.printStackTrace();
                        }
                    } else if (dados.equals("descricaoOcorrencia")) {
                        ocorrencia.setDescricaoOcorrencia(fileitem.getString());
                    } else if (dados.equals("tituloOcorrencia")) {
                        ocorrencia.setTituloOcorrencia(fileitem.getString());
                    }
                }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(CadastrarOcorrencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CadastrarOcorrencia.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CadastrarOcorrencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CadastrarOcorrencia.class.getName()).log(Level.SEVERE, null, ex);
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
