package br.com.helpcity.DAO;

import br.com.helpcity.model.Usuario;
import br.com.helpcity.util.ConnectionFactory;
import br.com.helpcity.util.Conversoes;
import java.lang.reflect.Array;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    private Connection conn;

    public UsuarioDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Integer cadastrar(Object object) throws Exception {
        Integer id = null;
        ResultSet rs = null;
        Usuario usuario = (Usuario) object;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO usuario(nome_usuario, cpf_usuario, rg_usuario, email_usuario, telefone_usuario, datanascimento_usuario, datacadastro_usuario, status_usuario, sexo_usuario, tipo_usuario, login_usuario, senha_usuario) VALUES (?,?,?,?,?,?,?,?,?,?,?,?) returning id_usuario;";
        try {
            stmt = conn.prepareCall(sql);
            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setString(2, usuario.getCpfUsuario());
            stmt.setString(3, usuario.getRgUsuario());
            stmt.setString(4, usuario.getEmailUsuario());
            stmt.setString(5, usuario.getTelefoneUsuario());
            stmt.setDate(6, new java.sql.Date(usuario.getDataNascimentoUsuario().getTime()));
            stmt.setDate(7, new java.sql.Date(usuario.getDataCadastroUsuario().getTime()));
            stmt.setString(8, usuario.getStatusUsuario());
            stmt.setString(9, usuario.getSexoUsuario());
            stmt.setString(10, usuario.getTipoUsuario());
            stmt.setString(11, usuario.getLoginUsuario());
            stmt.setString(12, Conversoes.converterSHA(usuario.getSenhaUsuario()));
            rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id_usuario");
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar usuário(DAO). Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão(DAO). Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return id;
    }

    public Object carregar(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        String sql = "select id_usuario, nome_usuario, email_usuario, datanascimento_usuario, rg_usuario, cpf_usuario, telefone_usuario, sexo_usuario, tipo_usuario from usuario where id_usuario = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNomeUsuario(rs.getString("nome_usuario"));
                usuario.setEmailUsuario(rs.getString("email_usuario"));
                usuario.setDataNascimentoUsuario(rs.getDate("datanascimento_usuario"));
                usuario.setRgUsuario(rs.getString("rg_usuario"));
                usuario.setCpfUsuario(rs.getString("cpf_usuario"));
                usuario.setTelefoneUsuario(rs.getString("telefone_usuario"));
                usuario.setSexoUsuario(rs.getString("sexo_usuario"));
                usuario.setTipoUsuario(rs.getString("tipo_usuario"));
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar Usuário! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return usuario;
    }

    public Boolean alterar(Object object) throws Exception {
        Usuario usuario = (Usuario) object;
        PreparedStatement stmt = null;
        String sql = "UPDATE usuario set nome_usuario = ?, cpf_usuario = ?, rg_usuario = ?, "
                + "email_usuario = ?, telefone_usuario = ?, status_usuario = ?, datanascimento_usuario = ?,"
                + " sexo_usuario = ? where id_usuario = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setString(2, usuario.getCpfUsuario());
            stmt.setString(3, usuario.getRgUsuario());
            stmt.setString(4, usuario.getEmailUsuario());
            stmt.setString(5, usuario.getTelefoneUsuario());
            stmt.setString(6, usuario.getStatusUsuario());
            stmt.setDate(7, new java.sql.Date(usuario.getDataNascimentoUsuario().getTime()));
            stmt.setString(8, usuario.getSexoUsuario());
            stmt.setInt(9, usuario.getIdUsuario());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar Usuário! Erro: " + ex.getMessage());
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

    public Boolean alterarStatus(Object object) {
        Usuario usuario = (Usuario) object;
        PreparedStatement stmt = null;
        String sql = "UPDATE usuario set status_usuario = ? where id_usuario = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getStatusUsuario());
            stmt.setInt(2, usuario.getIdUsuario());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar Usuário! Erro: " + ex.getMessage());
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

    public Usuario logar(Usuario usuario) throws Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "select u.id_usuario, u.nome_usuario, u.tipo_usuario, u.status_usuario, u.sexo_usuario from usuario u where u.login_usuario = ? and u.senha_usuario = ?";
            stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, usuario.getLoginUsuario());
            stmt.setString(2, Conversoes.converterSHA(usuario.getSenhaUsuario()));
            rs = stmt.executeQuery();
            if (rs.next()) {
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNomeUsuario(rs.getString("nome_usuario"));
                usuario.setTipoUsuario(rs.getString("tipo_usuario"));
                usuario.setStatusUsuario(rs.getString("status_usuario"));
                usuario.setSexoUsuario(rs.getString("sexo_usuario"));
            }
        } catch (Exception e) {
            System.out.println("Erro ao logar UsuarioDAO " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return usuario;
    }

    public Boolean checaCpf(String cpf) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from usuario u where (u.cpf_usuario = ?);";
        try {
            stmt = conn.prepareStatement(sql.toString());
            stmt.setString(1, cpf);
            rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            System.out.println("Problemas ao checar CPF(DAO)! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar parametros de conexão! Erro:" + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    public Boolean checaEmail(String email) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from usuario u where LOWER(u.email_usuario) = LOWER(?);";
        try {
            stmt = conn.prepareStatement(sql.toString());
            stmt.setString(1, email);
            rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            System.out.println("Problemas ao checar EMAIL(DAO)! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar parametros de conexão! Erro:" + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    public Boolean checaLogin(String login) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from usuario u where LOWER(u.login_usuario) = LOWER(?);";
        try {
            stmt = conn.prepareStatement(sql.toString());
            stmt.setString(1, login);
            rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            System.out.println("Problemas ao checar LOGIN(DAO)! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar parametros de conexão! Erro:" + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    public Boolean alterarSenha(Object object) throws NoSuchAlgorithmException {
        Usuario usuario = (Usuario) object;
        PreparedStatement stmt = null;
        String sql = "UPDATE usuario set senha_usuario = ? where id_usuario = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, Conversoes.converterSHA(usuario.getSenhaUsuario()));
            stmt.setInt(2, usuario.getIdUsuario());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar Usuário! Erro: " + ex.getMessage());
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

    public Boolean alterarPerfil(Object object) throws Exception {
        Usuario usuario = (Usuario) object;
        PreparedStatement stmt = null;
        String sql = "UPDATE usuario set nome_usuario = ?, cpf_usuario = ?, rg_usuario = ?, "
                + "email_usuario = ?, telefone_usuario = ?, datanascimento_usuario = ?,"
                + " sexo_usuario = ? where id_usuario = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setString(2, usuario.getCpfUsuario());
            stmt.setString(3, usuario.getRgUsuario());
            stmt.setString(4, usuario.getEmailUsuario());
            stmt.setString(5, usuario.getTelefoneUsuario());
            stmt.setDate(6, new java.sql.Date(usuario.getDataNascimentoUsuario().getTime()));
            stmt.setString(7, usuario.getSexoUsuario());
            stmt.setInt(8, usuario.getIdUsuario());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar perfil do Usuário! Erro: " + ex.getMessage());
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
}
