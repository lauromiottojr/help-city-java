package br.com.helpcity.DAO;

import br.com.helpcity.model.Cidadao;
import br.com.helpcity.model.Estado;
import br.com.helpcity.model.Ocorrencia;
import br.com.helpcity.model.Cidade;
import br.com.helpcity.model.Imagem;
import br.com.helpcity.model.Secretaria;
import br.com.helpcity.util.ConnectionFactory;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImagemDAO implements GenericDAO {

    private Connection conn;

    public ImagemDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public Boolean cadastrarImagem(Object object) throws Exception {
        Imagem imagem = (Imagem) object;
        PreparedStatement stmt = null;
        String sql;
        sql = "INSERT INTO imagem (id_ocorrencia, nome_imagem) VALUES (?, ?);";
        try {
            stmt = conn.prepareCall(sql);
            stmt.setInt(1, imagem.getOcorrenciaImagem().getIdOcorrencia());
            stmt.setString(2, imagem.getNomeImagem());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar Imagem(DAO). Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão(DAO). Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    public List<Object> listarImagem(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Imagem imagem = null;
        List<Object> lista = new ArrayList<Object>();
        try {
            String sql = "select i.id_imagem, i.nome_imagem from imagem i inner join ocorrencia o on o.id_ocorrencia = i.id_ocorrencia where o.id_ocorrencia = ?;";
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                imagem = new Imagem();
                imagem.setIdImagem(rs.getInt("id_imagem"));
                imagem.setNomeImagem(rs.getString("nome_imagem"));
                lista.add(imagem);
            }
        } catch (Exception ex) {
            System.out.println("Erro ao listar Ocorrência. Erro: " + ex.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão(DAO). Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return lista;
    }
    
    public List<Object> listarImagemUsuario(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Imagem imagem = null;
        List<Object> lista = new ArrayList<Object>();
        try {
            String sql = "select o.id_ocorrencia, i.id_imagem, i.nome_imagem from imagem i inner join ocorrencia o on o.id_ocorrencia = i.id_ocorrencia where o.id_usuario = ?;";
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                imagem = new Imagem();
                Ocorrencia ocorrencia = new Ocorrencia();
                ocorrencia.setIdOcorrencia(rs.getInt("id_ocorrencia"));
                imagem.setIdImagem(rs.getInt("id_imagem"));
                imagem.setNomeImagem(rs.getString("nome_imagem"));
                imagem.setOcorrenciaImagem(ocorrencia);
                lista.add(imagem);
            }
        } catch (Exception ex) {
            System.out.println("Erro ao listar Ocorrência. Erro: " + ex.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão(DAO). Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return lista;
    }

    @Override
    public List<Object> listar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object carregar(int idObject) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean alterar(Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean alterarStatus(Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Object> listarCidade(int idObject) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean cadastrar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
