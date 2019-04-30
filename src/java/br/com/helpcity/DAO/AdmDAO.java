package br.com.helpcity.DAO;

import br.com.helpcity.model.Adm;
import br.com.helpcity.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdmDAO implements GenericDAO {

    private Connection conn;

    public AdmDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Adm adm = (Adm) object;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO adm (id_usuario) VALUES (?);";

        try {
            stmt = conn.prepareCall(sql);
            try {
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                stmt.setInt(1, usuarioDAO.cadastrar(adm));
            } catch (Exception ex) {
            }
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar ADM(DAO). Erro: " + ex.getMessage());
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
            String sql = "select u.id_usuario, a.id_adm, u.nome_usuario, u.cpf_usuario, u.email_usuario, u.telefone_usuario, u.datacadastro_usuario, u.status_usuario, u.tipo_usuario from adm a inner join usuario u on u.id_usuario=a.id_usuario order by u.nome_usuario;";
            stmt = this.conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Adm adm = new Adm();
                adm.setIdUsuario(rs.getInt("id_usuario"));
                adm.setIdAdm(rs.getInt("id_adm"));
                adm.setNomeUsuario(rs.getString("nome_usuario"));
                adm.setCpfUsuario(rs.getString("cpf_usuario"));
                adm.setEmailUsuario(rs.getString("email_usuario"));
                adm.setTelefoneUsuario(rs.getString("telefone_usuario"));
                adm.setDataCadastroUsuario(rs.getDate("datacadastro_usuario"));
                adm.setStatusUsuario(rs.getString("status_usuario"));
                adm.setTipoUsuario(rs.getString("tipo_usuario"));
                lista.add(adm);
            }
        } catch (Exception ex) {
            System.out.println("Erro ao listar AdmDAO. Erro: " + ex.getMessage());
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
        Adm adm = null;
        String sql = "select u.id_usuario, a.id_adm, u.nome_usuario, u.cpf_usuario, u.rg_usuario, u.email_usuario, u.telefone_usuario, u.datanascimento_usuario, u.status_usuario, u.sexo_usuario from adm a inner join usuario u on a.id_usuario=u.id_usuario where a.id_usuario = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                adm = new Adm();
                adm.setIdUsuario(rs.getInt("id_usuario"));
                adm.setIdAdm(rs.getInt("id_adm"));
                adm.setNomeUsuario(rs.getString("nome_usuario"));
                adm.setCpfUsuario(rs.getString("cpf_usuario"));
                adm.setRgUsuario(rs.getString("rg_usuario"));
                adm.setEmailUsuario(rs.getString("email_usuario"));
                adm.setTelefoneUsuario(rs.getString("telefone_usuario"));
                adm.setDataNascimentoUsuario(rs.getDate("datanascimento_usuario"));
                adm.setStatusUsuario(rs.getString("status_usuario"));
                adm.setSexoUsuario(rs.getString("sexo_usuario"));
            }

        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar ADM! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return adm;
    }

    @Override
    public Boolean alterar(Object object) {
        Adm adm = (Adm) object;
        PreparedStatement stmt = null;
        String sql = "UPDATE adm where id_adm = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, adm.getIdAdm());
            try {
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                usuarioDAO.alterar(adm);
            } catch (Exception ex) {
            }
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar ADM! Erro: " + ex.getMessage());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean alterarStatus(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
