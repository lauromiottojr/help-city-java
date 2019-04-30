package br.com.helpcity.DAO;

import br.com.helpcity.model.Cidadao;
import br.com.helpcity.model.Estado;
import br.com.helpcity.model.Cidade;
import br.com.helpcity.util.ConnectionFactory;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadaoDAO implements GenericDAO {

    private Connection conn;

    public CidadaoDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Cidadao cidadao = (Cidadao) object;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO cidadao (id_usuario, id_cidade) VALUES (?, ?);";

        try {
            stmt = conn.prepareCall(sql);
            try {
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                stmt.setInt(1, usuarioDAO.cadastrar(cidadao));
            } catch (Exception ex) {
            }
            stmt.setInt(2, cidadao.getCidadeCidadao().getIdCidade());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar Cidadão(DAO). Erro: " + ex.getMessage());
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

    @Override
    public List<Object> listar() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> lista = new ArrayList<Object>();
        try {
            String sql = "select u.id_usuario, c.id_cidadao, u.nome_usuario, u.cpf_usuario, u.email_usuario, u.telefone_usuario, u.datacadastro_usuario, u.status_usuario, u.tipo_usuario, e.id_estado, e.uf_estado, ci.id_cidade, ci.nome_cidade from cidadao c inner join usuario u on u.id_usuario=c.id_usuario inner join cidade ci on ci.id_cidade = c.id_cidade inner join estado e on e.id_estado = ci.id_estado order by u.nome_usuario;";
            stmt = this.conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cidadao cidadao = new Cidadao();
                Estado estado = new Estado();
                Cidade cidade = new Cidade();
                cidadao.setIdUsuario(rs.getInt("id_usuario"));
                cidadao.setIdCidadao(rs.getInt("id_cidadao"));
                cidadao.setNomeUsuario(rs.getString("nome_usuario"));
                cidadao.setCpfUsuario(rs.getString("cpf_usuario"));
                cidadao.setEmailUsuario(rs.getString("email_usuario"));
                cidadao.setTelefoneUsuario(rs.getString("telefone_usuario"));
                cidadao.setDataCadastroUsuario(rs.getDate("datacadastro_usuario"));
                cidadao.setStatusUsuario(rs.getString("status_usuario"));
                cidadao.setTipoUsuario(rs.getString("tipo_usuario"));
                estado.setIdEstado(rs.getInt("id_estado"));
                estado.setUfEstado(rs.getString("uf_estado"));
                cidade.setIdCidade(rs.getInt("id_cidade"));
                cidade.setNomeCidade(rs.getString("nome_cidade"));
                cidade.setEstadoCidade(estado);
                cidadao.setCidadeCidadao(cidade);
                lista.add(cidadao);
            }
        } catch (Exception ex) {
            System.out.println("Erro ao listar Cidadão. Erro: " + ex.getMessage());
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
    public Object carregar(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cidadao cidadao = null;
        String sql = "select u.id_usuario, c.id_cidadao, u.nome_usuario, u.cpf_usuario, u.rg_usuario, u.email_usuario, u.telefone_usuario, u.datanascimento_usuario, u.status_usuario, u.sexo_usuario, e.id_estado, e.nome_estado, ci.id_cidade, ci.nome_cidade, ci.status_cidade from cidadao c inner join usuario u on c.id_usuario=u.id_usuario inner join cidade ci on c.id_cidade=ci.id_cidade inner join estado e on e.id_estado = ci.id_estado where c.id_usuario = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                cidadao = new Cidadao();
                Estado estado = new Estado();
                Cidade cidade = new Cidade();
                cidadao.setIdUsuario(rs.getInt("id_usuario"));
                cidadao.setIdCidadao(rs.getInt("id_cidadao"));
                cidadao.setNomeUsuario(rs.getString("nome_usuario"));
                cidadao.setCpfUsuario(rs.getString("cpf_usuario"));
                cidadao.setRgUsuario(rs.getString("rg_usuario"));
                cidadao.setEmailUsuario(rs.getString("email_usuario"));
                cidadao.setTelefoneUsuario(rs.getString("telefone_usuario"));
                cidadao.setDataNascimentoUsuario(rs.getDate("datanascimento_usuario"));
                cidadao.setStatusUsuario(rs.getString("status_usuario"));
                cidadao.setSexoUsuario(rs.getString("sexo_usuario"));
                estado.setIdEstado(rs.getInt("id_estado"));
                estado.setNomeEstado(rs.getString("nome_estado"));
                cidade.setIdCidade(rs.getInt("id_cidade"));
                cidade.setNomeCidade(rs.getString("nome_cidade"));
                cidade.setStatusCidade(rs.getString("status_cidade"));
                cidade.setEstadoCidade(estado);
                cidadao.setCidadeCidadao(cidade);
            }

        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar Cidadão! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return cidadao;
    }

    @Override
    public Boolean alterar(Object object) {
        Cidadao cidadao = (Cidadao) object;
        PreparedStatement stmt = null;
        String sql = "UPDATE cidadao set id_cidade = ? where id_cidadao = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            if (cidadao.getCidadeCidadao() != null) {
                stmt.setInt(1, cidadao.getCidadeCidadao().getIdCidade());
                stmt.setInt(2, cidadao.getIdCidadao());
            }
            try {
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                usuarioDAO.alterar(cidadao);
            } catch (Exception ex) {
            }
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar Cidadão! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return true;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Object> listarCidade(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cidadao cidadao = null;
        List<Object> lista = new ArrayList<Object>();
        try {
            String sql = "select u.id_usuario, c.id_cidadao, u.nome_usuario, u.cpf_usuario, u.email_usuario, u.telefone_usuario, u.datacadastro_usuario, u.status_usuario, u.tipo_usuario from cidadao c inner join usuario u on u.id_usuario=c.id_usuario inner join cidade ci on ci.id_cidade = c.id_cidade inner join estado e on e.id_estado = ci.id_estado where ci.id_cidade = ? order by u.nome_usuario;";
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();

            while (rs.next()) {
                cidadao = new Cidadao();
                cidadao.setIdUsuario(rs.getInt("id_usuario"));
                cidadao.setIdCidadao(rs.getInt("id_cidadao"));
                cidadao.setNomeUsuario(rs.getString("nome_usuario"));
                cidadao.setCpfUsuario(rs.getString("cpf_usuario"));
                cidadao.setEmailUsuario(rs.getString("email_usuario"));
                cidadao.setTelefoneUsuario(rs.getString("telefone_usuario"));
                cidadao.setDataCadastroUsuario(rs.getDate("datacadastro_usuario"));
                cidadao.setStatusUsuario(rs.getString("status_usuario"));
                cidadao.setTipoUsuario(rs.getString("tipo_usuario"));
                lista.add(cidadao);
            }
        } catch (Exception ex) {
            System.out.println("Erro ao listar Cidadão. Erro: " + ex.getMessage());
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

    public Boolean alterarPerfil(Object object) {
        Cidadao cidadao = (Cidadao) object;
        PreparedStatement stmt = null;
        String sql = "UPDATE cidadao set id_cidade = ? where id_cidadao = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            if (cidadao.getCidadeCidadao() != null) {
                stmt.setInt(1, cidadao.getCidadeCidadao().getIdCidade());
                stmt.setInt(2, cidadao.getIdCidadao());
            }
            try {
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                usuarioDAO.alterarPerfil(cidadao);
            } catch (Exception ex) {
            }
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar Cidadão! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return true;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Boolean alterarStatus(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
