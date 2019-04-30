package br.com.helpcity.DAO;

import br.com.helpcity.model.Secretaria;
import br.com.helpcity.util.ConnectionFactory;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SecretariaDAO implements GenericDAO {

    private Connection conn;

    public SecretariaDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Secretaria secretaria = (Secretaria) object;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO secretaria (nome_secretaria, telefone_secretaria, email_secretaria, datacadastro_secretaria, id_cidade) VALUES (?, ?, ?, ?, ?);";

        try {
            stmt = conn.prepareCall(sql);
            stmt.setString(1, secretaria.getNomeSecretaria());
            stmt.setString(2, secretaria.getTelefoneSecretaria());
            stmt.setString(3, secretaria.getEmailSecretaria());
            stmt.setDate(4, new java.sql.Date(secretaria.getDataCadastroSecretaria().getTime()));
            stmt.setInt(5, secretaria.getCidadeSecretaria().getIdCidade());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar Secretaria(DAO). Erro: " + ex.getMessage());
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
        List<Object> secretarias = new ArrayList<Object>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select s.id_secretaria, s.nome_secretaria from secretaria s order by s.nome_secretaria;";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Secretaria secretaria = new Secretaria();
                secretaria.setIdSecretaria(rs.getInt("id_secretaria"));
                secretaria.setNomeSecretaria(rs.getString("nome_secretaria"));
                secretarias.add(secretaria);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Secretaria(DAO). Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão(DAO). Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return secretarias;
    }

    @Override
    public Object carregar(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Secretaria secretaria = null;
        String sql = "select s.id_secretaria, s.nome_secretaria, s.telefone_secretaria, s.email_secretaria from secretaria s inner join cidade c on s.id_cidade=c.id_cidade where s.id_secretaria = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                secretaria = new Secretaria();
                secretaria.setIdSecretaria(rs.getInt("id_secretaria"));
                secretaria.setNomeSecretaria(rs.getString("nome_secretaria"));
                secretaria.setTelefoneSecretaria(rs.getString("telefone_secretaria"));
                secretaria.setEmailSecretaria(rs.getString("email_secretaria"));
            }

        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar Secretaria! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return secretaria;
    }

    @Override
    public Boolean alterar(Object object) {
        Secretaria secretaria = (Secretaria) object;
        PreparedStatement stmt = null;
        String sql = "UPDATE secretaria set nome_secretaria = ?, telefone_secretaria = ?, email_secretaria = ? where id_secretaria = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, secretaria.getNomeSecretaria());
            stmt.setString(2, secretaria.getTelefoneSecretaria());
            stmt.setString(3, secretaria.getEmailSecretaria());
            stmt.setInt(4, secretaria.getIdSecretaria());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar Secretaria! Erro: " + ex.getMessage());
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Object> listarCidade(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Secretaria secretaria = null;
        List<Object> lista = new ArrayList<Object>();
        try {
            String sql = "select s.id_secretaria, s.nome_secretaria, s.telefone_secretaria, s.email_secretaria, s.datacadastro_secretaria from secretaria s inner join cidade c on s.id_cidade=c.id_cidade inner join estado e on e.id_estado=c.id_estado where c.id_cidade = ?;";
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();

            while (rs.next()) {
                secretaria = new Secretaria();
                secretaria.setIdSecretaria(rs.getInt("id_secretaria"));
                secretaria.setNomeSecretaria(rs.getString("nome_secretaria"));
                secretaria.setEmailSecretaria(rs.getString("telefone_secretaria"));
                secretaria.setTelefoneSecretaria(rs.getString("email_secretaria"));
                secretaria.setDataCadastroSecretaria(rs.getDate("datacadastro_secretaria"));
                lista.add(secretaria);
            }
        } catch (Exception ex) {
            System.out.println("Erro ao listar Secretaria. Erro: " + ex.getMessage());
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
    
    public Boolean excluir(int idObject) {
        PreparedStatement stmt = null;
        String sql = "delete from secretaria where id_secretaria = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir SecretariaDAO! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

}
