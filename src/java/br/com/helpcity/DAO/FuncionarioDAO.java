package br.com.helpcity.DAO;

import br.com.helpcity.model.Estado;
import br.com.helpcity.model.Funcionario;
import br.com.helpcity.model.Cidade;
import br.com.helpcity.model.Secretaria;
import br.com.helpcity.util.ConnectionFactory;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO implements GenericDAO {

    private Connection conn;

    public FuncionarioDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Funcionario funcionario = (Funcionario) object;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO funcionario (id_usuario, id_secretaria) VALUES (?, ?);";

        try {
            stmt = conn.prepareCall(sql);
            try {
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                stmt.setInt(1, usuarioDAO.cadastrar(funcionario));
            } catch (Exception ex) {
            }
            stmt.setInt(2, funcionario.getSecretariaFuncionario().getIdSecretaria());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar Funcionario(DAO). Erro: " + ex.getMessage());
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
            String sql = "select u.id_usuario, f.id_funcionario, u.nome_usuario, u.cpf_usuario, u.email_usuario, u.telefone_usuario, u.datacadastro_usuario, u.status_usuario, u.tipo_usuario, e.id_estado, e.uf_estado, c.id_cidade, c.nome_cidade, s.id_secretaria, s.nome_secretaria from funcionario f inner join usuario u on u.id_usuario=f.id_usuario inner join secretaria s on s.id_secretaria=f.id_secretaria inner join cidade c on c.id_cidade = s.id_cidade inner join estado e on e.id_estado = c.id_estado order by u.nome_usuario;";
            stmt = this.conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                Estado estado = new Estado();
                Cidade cidade = new Cidade();
                Secretaria secretaria = new Secretaria();
                funcionario.setIdUsuario(rs.getInt("id_usuario"));
                funcionario.setIdFuncionario(rs.getInt("id_funcionario"));
                funcionario.setNomeUsuario(rs.getString("nome_usuario"));
                funcionario.setCpfUsuario(rs.getString("cpf_usuario"));
                funcionario.setEmailUsuario(rs.getString("email_usuario"));
                funcionario.setTelefoneUsuario(rs.getString("telefone_usuario"));
                funcionario.setDataCadastroUsuario(rs.getDate("datacadastro_usuario"));
                funcionario.setStatusUsuario(rs.getString("status_usuario"));
                funcionario.setTipoUsuario(rs.getString("tipo_usuario"));
                estado.setIdEstado(rs.getInt("id_estado"));
                estado.setUfEstado(rs.getString("uf_estado"));
                cidade.setIdCidade(rs.getInt("id_cidade"));
                cidade.setNomeCidade(rs.getString("nome_cidade"));
                secretaria.setIdSecretaria(rs.getInt("id_secretaria"));
                secretaria.setNomeSecretaria(rs.getString("nome_secretaria"));
                cidade.setEstadoCidade(estado);
                secretaria.setCidadeSecretaria(cidade);
                funcionario.setSecretariaFuncionario(secretaria);
                lista.add(funcionario);
            }
        } catch (Exception ex) {
            System.out.println("Erro ao listar Funcionario. Erro: " + ex.getMessage());
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
        Funcionario funcionario = null;
        String sql = "select u.id_usuario, f.id_funcionario, u.nome_usuario, u.cpf_usuario, u.rg_usuario, u.email_usuario, u.telefone_usuario, u.datanascimento_usuario, u.status_usuario, u.sexo_usuario, e.id_estado, e.nome_estado, c.id_cidade, c.nome_cidade, c.status_cidade, s.id_secretaria, s.nome_secretaria from funcionario f inner join usuario u on f.id_usuario=u.id_usuario inner join secretaria s on s.id_secretaria=f.id_secretaria inner join cidade c on s.id_cidade=c.id_cidade inner join estado e on c.id_estado=e.id_estado where f.id_usuario = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                funcionario = new Funcionario();
                Estado estado = new Estado();
                Cidade cidade = new Cidade();
                Secretaria secretaria = new Secretaria();
                funcionario.setIdUsuario(rs.getInt("id_usuario"));
                funcionario.setIdFuncionario(rs.getInt("id_funcionario"));
                funcionario.setNomeUsuario(rs.getString("nome_usuario"));
                funcionario.setCpfUsuario(rs.getString("cpf_usuario"));
                funcionario.setRgUsuario(rs.getString("rg_usuario"));
                funcionario.setEmailUsuario(rs.getString("email_usuario"));
                funcionario.setTelefoneUsuario(rs.getString("telefone_usuario"));
                funcionario.setDataNascimentoUsuario(rs.getDate("datanascimento_usuario"));
                funcionario.setStatusUsuario(rs.getString("status_usuario"));
                funcionario.setSexoUsuario(rs.getString("sexo_usuario"));
                estado.setIdEstado(rs.getInt("id_estado"));
                estado.setNomeEstado(rs.getString("nome_estado"));
                cidade.setIdCidade(rs.getInt("id_cidade"));
                cidade.setNomeCidade(rs.getString("nome_cidade"));
                cidade.setStatusCidade(rs.getString("status_cidade"));
                secretaria.setIdSecretaria(rs.getInt("id_secretaria"));
                secretaria.setNomeSecretaria(rs.getString("nome_secretaria"));
                cidade.setEstadoCidade(estado);
                secretaria.setCidadeSecretaria(cidade);
                funcionario.setSecretariaFuncionario(secretaria);
            }

        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar Funcionario! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return funcionario;
    }

    @Override
    public Boolean alterar(Object object) {
        Funcionario funcionario = (Funcionario) object;
        PreparedStatement stmt = null;
        String sql = "UPDATE funcionario set id_secretaria = ? where id_funcionario = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, funcionario.getSecretariaFuncionario().getIdSecretaria());
            stmt.setInt(2, funcionario.getIdFuncionario());
            try {
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                usuarioDAO.alterar(funcionario);
            } catch (Exception ex) {
            }
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar Funcionario! Erro: " + ex.getMessage());
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
        Funcionario funcionario = null;
        List<Object> lista = new ArrayList<Object>();
        try {
            String sql = "select u.id_usuario, f.id_funcionario, u.nome_usuario, u.cpf_usuario, u.email_usuario, u.telefone_usuario, u.datacadastro_usuario, u.status_usuario, u.tipo_usuario, s.id_secretaria, s.nome_secretaria from funcionario f inner join usuario u on u.id_usuario=f.id_usuario inner join secretaria s on s.id_secretaria=f.id_secretaria inner join cidade c on c.id_cidade = s.id_cidade inner join estado e on e.id_estado = c.id_estado where c.id_cidade = ? order by u.nome_usuario;";
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();

            while (rs.next()) {
                funcionario = new Funcionario();
                Secretaria secretaria = new Secretaria();
                funcionario.setIdUsuario(rs.getInt("id_usuario"));
                funcionario.setIdFuncionario(rs.getInt("id_funcionario"));
                funcionario.setNomeUsuario(rs.getString("nome_usuario"));
                funcionario.setCpfUsuario(rs.getString("cpf_usuario"));
                funcionario.setEmailUsuario(rs.getString("email_usuario"));
                funcionario.setTelefoneUsuario(rs.getString("telefone_usuario"));
                funcionario.setDataCadastroUsuario(rs.getDate("datacadastro_usuario"));
                funcionario.setStatusUsuario(rs.getString("status_usuario"));
                funcionario.setTipoUsuario(rs.getString("tipo_usuario"));
                secretaria.setIdSecretaria(rs.getInt("id_secretaria"));
                secretaria.setNomeSecretaria(rs.getString("nome_secretaria"));
                funcionario.setSecretariaFuncionario(secretaria);
                lista.add(funcionario);
            }
        } catch (Exception ex) {
            System.out.println("Erro ao listar Funcionario. Erro: " + ex.getMessage());
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
    public Boolean alterarStatus(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
