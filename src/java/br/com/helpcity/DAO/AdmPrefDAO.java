package br.com.helpcity.DAO;

import br.com.helpcity.model.AdmPref;
import br.com.helpcity.model.Estado;
import br.com.helpcity.model.Cidade;
import br.com.helpcity.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdmPrefDAO implements GenericDAO {

    private Connection conn;

    public AdmPrefDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        AdmPref admPref = (AdmPref) object;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO admprefeitura (id_usuario, id_cidade) VALUES (?, ?);";

        try {
            stmt = conn.prepareCall(sql);
            try {
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                stmt.setInt(1, usuarioDAO.cadastrar(admPref));
            } catch (Exception ex) {
            }
            stmt.setInt(2, admPref.getCidadeAdmPref().getIdCidade());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar ADMPREF(DAO). Erro: " + ex.getMessage());
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
            String sql = "select u.id_usuario, a.id_admprefeitura, u.nome_usuario, u.cpf_usuario, u.email_usuario, u.telefone_usuario, u.datacadastro_usuario, u.status_usuario, u.tipo_usuario, e.id_estado, e.uf_estado, c.id_cidade, c.nome_cidade from admprefeitura a inner join usuario u on u.id_usuario=a.id_usuario inner join cidade c on c.id_cidade = a.id_cidade inner join estado e on e.id_estado = c.id_estado order by u.nome_usuario;";
            stmt = this.conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                AdmPref admPref = new AdmPref();
                Estado estado = new Estado();
                Cidade cidade = new Cidade();
                admPref.setIdUsuario(rs.getInt("id_usuario"));
                admPref.setIdAdmPref(rs.getInt("id_admprefeitura"));
                admPref.setNomeUsuario(rs.getString("nome_usuario"));
                admPref.setCpfUsuario(rs.getString("cpf_usuario"));
                admPref.setEmailUsuario(rs.getString("email_usuario"));
                admPref.setTelefoneUsuario(rs.getString("telefone_usuario"));
                admPref.setDataCadastroUsuario(rs.getDate("datacadastro_usuario"));
                admPref.setStatusUsuario(rs.getString("status_usuario"));
                admPref.setTipoUsuario(rs.getString("tipo_usuario"));
                estado.setIdEstado(rs.getInt("id_estado"));
                estado.setUfEstado(rs.getString("uf_estado"));
                cidade.setIdCidade(rs.getInt("id_cidade"));
                cidade.setNomeCidade(rs.getString("nome_cidade"));
                cidade.setEstadoCidade(estado);
                admPref.setCidadeAdmPref(cidade);
                lista.add(admPref);
            }
        } catch (Exception ex) {
            System.out.println("Erro ao listar AdmPrefDAO. Erro: " + ex.getMessage());
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
    public List<Object> listarCidade(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> lista = new ArrayList<Object>();
        try {
            String sql = "select u.id_usuario, a.id_admprefeitura, u.nome_usuario, u.cpf_usuario, u.email_usuario, u.telefone_usuario, u.datacadastro_usuario, u.status_usuario, u.tipo_usuario from admprefeitura a inner join usuario u on u.id_usuario=a.id_usuario inner join cidade c on c.id_cidade = a.id_cidade inner join estado e on e.id_estado = c.id_estado where c.id_cidade = ? order by u.nome_usuario;";
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();

            while (rs.next()) {
                AdmPref admPref = new AdmPref();
                admPref.setIdUsuario(rs.getInt("id_usuario"));
                admPref.setIdAdmPref(rs.getInt("id_admprefeitura"));
                admPref.setNomeUsuario(rs.getString("nome_usuario"));
                admPref.setCpfUsuario(rs.getString("cpf_usuario"));
                admPref.setEmailUsuario(rs.getString("email_usuario"));
                admPref.setTelefoneUsuario(rs.getString("telefone_usuario"));
                admPref.setDataCadastroUsuario(rs.getDate("datacadastro_usuario"));
                admPref.setStatusUsuario(rs.getString("status_usuario"));
                admPref.setTipoUsuario(rs.getString("tipo_usuario"));
                lista.add(admPref);
            }
        } catch (Exception ex) {
            System.out.println("Erro ao listar AdmPrefDAO. Erro: " + ex.getMessage());
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
        AdmPref admPref = null;
        String sql = "select u.id_usuario, a.id_admprefeitura, u.nome_usuario, u.cpf_usuario, u.rg_usuario, u.email_usuario, u.telefone_usuario, u.datanascimento_usuario, u.status_usuario, u.sexo_usuario, c.id_cidade, c.nome_cidade, c.status_cidade, e.id_estado, e.nome_estado from admprefeitura a inner join usuario u on a.id_usuario=u.id_usuario inner join cidade c on a.id_cidade=c.id_cidade inner join estado e on c.id_estado = e.id_estado where a.id_usuario = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                admPref = new AdmPref();
                Cidade cidade = new Cidade();
                Estado estado = new Estado();
                admPref.setIdUsuario(rs.getInt("id_usuario"));
                admPref.setIdAdmPref(rs.getInt("id_admprefeitura"));
                admPref.setNomeUsuario(rs.getString("nome_usuario"));
                admPref.setCpfUsuario(rs.getString("cpf_usuario"));
                admPref.setRgUsuario(rs.getString("rg_usuario"));
                admPref.setEmailUsuario(rs.getString("email_usuario"));
                admPref.setTelefoneUsuario(rs.getString("telefone_usuario"));
                admPref.setDataNascimentoUsuario(rs.getDate("datanascimento_usuario"));
                admPref.setStatusUsuario(rs.getString("status_usuario"));
                admPref.setSexoUsuario(rs.getString("sexo_usuario"));
                cidade.setIdCidade(rs.getInt("id_cidade"));
                cidade.setNomeCidade(rs.getString("nome_cidade"));
                cidade.setStatusCidade(rs.getString("status_cidade"));
                estado.setIdEstado(rs.getInt("id_estado"));
                estado.setNomeEstado(rs.getString("nome_estado"));
                cidade.setEstadoCidade(estado);
                admPref.setCidadeAdmPref(cidade);
            }

        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar ADMPREF! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return admPref;
    }

    @Override
    public Boolean alterar(Object object) {
        AdmPref admPref = (AdmPref) object;
        PreparedStatement stmt = null;
        String sql = "UPDATE admprefeitura set id_cidade = ? where id_admprefeitura = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, admPref.getCidadeAdmPref().getIdCidade());
            stmt.setInt(2, admPref.getIdAdmPref());
            try {
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                usuarioDAO.alterar(admPref);
            } catch (Exception ex) {
            }
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar ADMPREF! Erro: " + ex.getMessage());
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
