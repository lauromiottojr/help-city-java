package br.com.helpcity.DAO;

import br.com.helpcity.model.Categoria;
import br.com.helpcity.util.ConnectionFactory;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO implements GenericDAO {

    private Connection conn;

    public CategoriaDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Categoria categoria = (Categoria) object;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO categoria(nome_categoria, id_cidade) VALUES (?,?);";

        try {
            stmt = conn.prepareCall(sql);
            stmt.setString(1, categoria.getNomeCategoria());
            stmt.setInt(2, categoria.getCidadeCategoria().getIdCidade());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar categoria(DAO). Erro: " + ex.getMessage());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object carregar(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Categoria categoria = null;
        String sql = "select c.id_categoria, c.nome_categoria from categoria c where c.id_categoria = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNomeCategoria(rs.getString("nome_categoria"));
            }

        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar CategoriaDAO! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return categoria;
    }

    @Override
    public Boolean alterar(Object object) {
        Categoria categoria = (Categoria) object;
        PreparedStatement stmt = null;
        String sql = "UPDATE categoria set nome_categoria = ? where id_categoria = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, categoria.getNomeCategoria());
            stmt.setInt(2, categoria.getIdCategoria());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar CategoriaDAO! Erro: " + ex.getMessage());
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

    @Override
    public List<Object> listarCidade(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Categoria categoria = null;
        List<Object> lista = new ArrayList<Object>();
        try {
            String sql = "select c.id_categoria, c.nome_categoria from categoria c where c.id_cidade = ? order by nome_categoria;";
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNomeCategoria(rs.getString("nome_categoria"));
                lista.add(categoria);
            }
        } catch (Exception ex) {
            System.out.println("Erro ao listar Categoria. Erro: " + ex.getMessage());
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

    public Boolean checaNomeCategoria(String nome_categoria, Integer cidade_categoria) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from categoria c where LOWER(c.nome_categoria) = LOWER(?) and id_cidade = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome_categoria);
            stmt.setInt(2, cidade_categoria);
            rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            System.out.println("Problemas ao checar NOMECATEGORIA(DAO)! Erro: " + ex.getMessage());
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
    
    public Boolean excluir(int idObject) {
        PreparedStatement stmt = null;
        String sql = "delete  from categoria where id_categoria = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir CategoriaDAO! Erro: " + ex.getMessage());
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
