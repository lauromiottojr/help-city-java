package br.com.helpcity.DAO;

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

public class CidadeDAO implements GenericDAO {

    private Connection conn;

    public CidadeDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Cidade cidade = (Cidade) object;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO cidade(nome_cidade, datacadastro_cidade, status_cidade,  id_estado) VALUES (?,?,?,?);";

        try {
            stmt = conn.prepareCall(sql);
            stmt.setString(1, cidade.getNomeCidade());
            stmt.setDate(2, new java.sql.Date(cidade.getDataCadastroCidade().getTime()));
            stmt.setString(3, cidade.getStatusCidade());
            stmt.setInt(4, cidade.getEstadoCidade().getIdEstado());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar cidade(DAO). Erro: " + ex.getMessage());
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

    public List<Object> listar(String estadoUf) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> lista = new ArrayList<>();
        try {
            String sql = "select e.id_estado, e.nome_estado, c.id_cidade, c.nome_cidade, c.status_cidade from cidade c inner join estado e on e.id_estado = c.id_estado where e.uf_estado = ? order by e.nome_estado;";
            stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, estadoUf);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cidade cidade = new Cidade();
                Estado estado = new Estado();
                estado.setIdEstado(rs.getInt("id_estado"));
                estado.setNomeEstado(rs.getString("nome_estado"));
                cidade.setIdCidade(rs.getInt("id_cidade"));
                cidade.setNomeCidade(rs.getString("nome_cidade"));
                cidade.setStatusCidade(rs.getString("status_cidade"));
                cidade.setEstadoCidade(estado);
                lista.add(cidade);
            }
        } catch (Exception ex) {
            System.out.println("Erro ao listar CidadeDAO. Erro: " + ex.getMessage());
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
        Cidade cidade = null;
        String sql = "select c.id_cidade, c.nome_cidade, c.status_cidade, e.id_estado, e.nome_estado from cidade c inner join estado e on e.id_estado = c.id_estado where c.id_cidade = ?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                cidade = new Cidade();
                cidade.setIdCidade(rs.getInt("id_cidade"));
                cidade.setNomeCidade(rs.getString("nome_cidade"));
                cidade.setStatusCidade(rs.getString("status_cidade"));
                Estado estado = new Estado();
                estado.setIdEstado(rs.getInt("id_estado"));
                estado.setNomeEstado(rs.getString("nome_estado"));
                cidade.setEstadoCidade(estado);
            }

        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar Cidade! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return cidade;
    }

    @Override
    public Boolean alterar(Object object) {
        Cidade cidade = (Cidade) object;
        PreparedStatement stmt = null;
        String sql = "UPDATE cidade set nome_cidade = ?, status_cidade = ?, id_estado = ? where id_cidade = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cidade.getNomeCidade());
            stmt.setString(2, cidade.getStatusCidade());
            stmt.setInt(3, cidade.getEstadoCidade().getIdEstado());
            stmt.setInt(4, cidade.getIdCidade());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar CidadeDAO! Erro: " + ex.getMessage());
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
        Cidade cidade = (Cidade) object;
        PreparedStatement stmt = null;
        String sql = "UPDATE cidade set status_cidade = ? where id_cidade = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cidade.getStatusCidade());
            stmt.setInt(2, cidade.getIdCidade());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterarStatus CidadeDAO! Erro: " + ex.getMessage());
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

    public List<Object> listar() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> lista = new ArrayList<>();
        try {
            String sql = "select e.id_estado, e.nome_estado, c.id_cidade, c.nome_cidade, c.status_cidade, c.datacadastro_cidade from cidade c inner join estado e on e.id_estado = c.id_estado order by e.nome_estado;";
            stmt = this.conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cidade cidade = new Cidade();
                Estado estado = new Estado();
                estado.setIdEstado(rs.getInt("id_estado"));
                estado.setNomeEstado(rs.getString("nome_estado"));
                cidade.setIdCidade(rs.getInt("id_cidade"));
                cidade.setNomeCidade(rs.getString("nome_cidade"));
                cidade.setStatusCidade(rs.getString("status_cidade"));
                cidade.setDataCadastroCidade(rs.getDate("datacadastro_cidade"));
                cidade.setEstadoCidade(estado);
                lista.add(cidade);
            }
        } catch (Exception ex) {
            System.out.println("Erro ao listar CidadeDAO. Erro: " + ex.getMessage());
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

}
