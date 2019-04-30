package br.com.helpcity.DAO;

import br.com.helpcity.model.Categoria;
import br.com.helpcity.model.Estado;
import br.com.helpcity.model.Ocorrencia;
import br.com.helpcity.model.Cidade;
import br.com.helpcity.model.Secretaria;
import br.com.helpcity.model.Usuario;
import br.com.helpcity.util.ConnectionFactory;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OcorrenciaDAO implements GenericDAO {

    private Connection conn;

    public OcorrenciaDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Boolean cadastrarOcorrencia(Object object) throws Exception {
        Ocorrencia ocorrencia = (Ocorrencia) object;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO ocorrencia (localizacao_ocorrencia, latitude_ocorrencia, longitude_ocorrencia, descricao_ocorrencia, datacriacao_ocorrencia, titulo_ocorrencia, status_ocorrencia, id_usuario, id_cidade) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            stmt = conn.prepareCall(sql);
            stmt.setString(1, ocorrencia.getLocalizacaoOcorrencia());
            stmt.setString(2, ocorrencia.getLatitudeOcorrencia());
            stmt.setString(3, ocorrencia.getLongitudeOcorrencia());
            stmt.setString(4, ocorrencia.getDescricaoOcorrencia());
            stmt.setDate(5, new java.sql.Date(ocorrencia.getDataCriacaoOcorrencia().getTime()));
            stmt.setString(6, ocorrencia.getTituloOcorrencia());
            stmt.setString(7, ocorrencia.getStatusOcorrencia());
            stmt.setInt(8, ocorrencia.getUsuarioOcorrencia().getIdUsuario());
            stmt.setInt(9, ocorrencia.getCidadeOcorrencia().getIdCidade());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar Ocorrência(DAO). Erro: " + ex.getMessage());
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object carregar(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Ocorrencia ocorrencia = null;
        String sql = "select s.id_secretaria, s.nome_secretaria, ca.id_categoria, ca.nome_categoria, o.id_ocorrencia, o.localizacao_ocorrencia, o.latitude_ocorrencia, o.longitude_ocorrencia, o.descricao_ocorrencia, o.datacriacao_ocorrencia, o.titulo_ocorrencia, o.status_ocorrencia, o.observacao_ocorrencia from ocorrencia o inner join usuario u on u.id_usuario=o.id_usuario left join categoria ca on ca.id_categoria = o.id_categoria left join secretaria s on s.id_secretaria=o.id_secretaria where o.id_ocorrencia = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Secretaria secretaria = new Secretaria();
                Categoria categoria = new Categoria();
                ocorrencia = new Ocorrencia();
                secretaria.setIdSecretaria(rs.getInt("id_secretaria"));
                secretaria.setNomeSecretaria(rs.getString("nome_secretaria"));
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNomeCategoria(rs.getString("nome_categoria"));
                ocorrencia.setIdOcorrencia(rs.getInt("id_ocorrencia"));
                ocorrencia.setLocalizacaoOcorrencia(rs.getString("localizacao_ocorrencia"));
                ocorrencia.setLatitudeOcorrencia(rs.getString("latitude_ocorrencia"));
                ocorrencia.setLongitudeOcorrencia(rs.getString("longitude_ocorrencia"));
                ocorrencia.setDescricaoOcorrencia(rs.getString("descricao_ocorrencia"));
                ocorrencia.setDataCriacaoOcorrencia(rs.getDate("datacriacao_ocorrencia"));
                ocorrencia.setTituloOcorrencia(rs.getString("titulo_ocorrencia"));
                ocorrencia.setStatusOcorrencia(rs.getString("status_ocorrencia"));
                ocorrencia.setObservacaoOcorrencia(rs.getString("observacao_ocorrencia"));
                ocorrencia.setSecretariaOcorrencia(secretaria);
                ocorrencia.setCategoriaOcorrencia(categoria);
            }

        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar OCORRENCIA! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return ocorrencia;
    }

    @Override
    public Boolean alterar(Object object) {
        Ocorrencia ocorrencia = (Ocorrencia) object;
        PreparedStatement stmt = null;
        String sql = "UPDATE ocorrencia set status_ocorrencia = ?, observacao_ocorrencia = ?, id_secretaria = ?, id_categoria = ? where id_ocorrencia = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, ocorrencia.getStatusOcorrencia());
            stmt.setString(2, ocorrencia.getObservacaoOcorrencia());
            stmt.setInt(3, ocorrencia.getSecretariaOcorrencia().getIdSecretaria());
            stmt.setInt(4, ocorrencia.getCategoriaOcorrencia().getIdCategoria());
            stmt.setInt(5, ocorrencia.getIdOcorrencia());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar Ocorrência! Erro: " + ex.getMessage());
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
        Ocorrencia ocorrencia = (Ocorrencia) object;
        PreparedStatement stmt = null;
        String sql = "UPDATE ocorrencia set status_ocorrencia = ? where id_ocorrencia = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, ocorrencia.getStatusOcorrencia());
            stmt.setInt(2, ocorrencia.getIdOcorrencia());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar Ocorrência! Erro: " + ex.getMessage());
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
        Ocorrencia ocorrencia = null;
        List<Object> lista = new ArrayList<Object>();
        try {
            String sql = "select u.id_usuario, u.nome_usuario, s.id_secretaria, s.nome_secretaria, ca.id_categoria, ca.nome_categoria, o.id_ocorrencia, o.datacriacao_ocorrencia, o.titulo_ocorrencia, o.status_ocorrencia from ocorrencia o inner join usuario u on u.id_usuario=o.id_usuario left join secretaria s on s.id_secretaria=o.id_secretaria left join categoria ca on ca.id_categoria = o.id_categoria where o.id_cidade = ? order by o.id_ocorrencia desc;";
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                Secretaria secretaria = new Secretaria();
                Categoria categoria = new Categoria();
                ocorrencia = new Ocorrencia();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNomeUsuario(rs.getString("nome_usuario"));
                secretaria.setIdSecretaria(rs.getInt("id_secretaria"));
                secretaria.setNomeSecretaria(rs.getString("nome_secretaria"));
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNomeCategoria(rs.getString("nome_categoria"));
                ocorrencia.setIdOcorrencia(rs.getInt("id_ocorrencia"));
                ocorrencia.setDataCriacaoOcorrencia(rs.getDate("datacriacao_ocorrencia"));
                ocorrencia.setTituloOcorrencia(rs.getString("titulo_ocorrencia"));
                ocorrencia.setStatusOcorrencia(rs.getString("status_ocorrencia"));
                ocorrencia.setUsuarioOcorrencia(usuario);
                ocorrencia.setSecretariaOcorrencia(secretaria);
                ocorrencia.setCategoriaOcorrencia(categoria);
                lista.add(ocorrencia);
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

    public List<Object> listarPendentes(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Ocorrencia ocorrencia = null;
        List<Object> lista = new ArrayList<Object>();
        try {
            String sql = "select u.id_usuario, u.nome_usuario, o.id_ocorrencia, o.datacriacao_ocorrencia, o.titulo_ocorrencia, o.status_ocorrencia from ocorrencia o inner join usuario u on u.id_usuario=o.id_usuario where o.id_secretaria is null and o.id_cidade = ? order by o.id_ocorrencia desc;";
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                ocorrencia = new Ocorrencia();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNomeUsuario(rs.getString("nome_usuario"));
                ocorrencia.setIdOcorrencia(rs.getInt("id_ocorrencia"));
                ocorrencia.setDataCriacaoOcorrencia(rs.getDate("datacriacao_ocorrencia"));
                ocorrencia.setTituloOcorrencia(rs.getString("titulo_ocorrencia"));
                ocorrencia.setStatusOcorrencia(rs.getString("status_ocorrencia"));
                ocorrencia.setUsuarioOcorrencia(usuario);
                lista.add(ocorrencia);
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

    public List<Object> listarSecretaria(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Ocorrencia ocorrencia = null;
        List<Object> lista = new ArrayList<Object>();
        try {
            String sql = "select u.id_usuario, u.nome_usuario, ca.id_categoria, ca.nome_categoria, o.id_ocorrencia, o.datacriacao_ocorrencia, o.titulo_ocorrencia, o.status_ocorrencia from ocorrencia o inner join usuario u on u.id_usuario=o.id_usuario inner join categoria ca on ca.id_categoria = o.id_categoria where o.id_secretaria = ? order by o.id_ocorrencia desc;";
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                Categoria categoria = new Categoria();
                ocorrencia = new Ocorrencia();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNomeUsuario(rs.getString("nome_usuario"));
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNomeCategoria(rs.getString("nome_categoria"));
                ocorrencia.setIdOcorrencia(rs.getInt("id_ocorrencia"));
                ocorrencia.setDataCriacaoOcorrencia(rs.getDate("datacriacao_ocorrencia"));
                ocorrencia.setTituloOcorrencia(rs.getString("titulo_ocorrencia"));
                ocorrencia.setStatusOcorrencia(rs.getString("status_ocorrencia"));
                ocorrencia.setCategoriaOcorrencia(categoria);
                ocorrencia.setUsuarioOcorrencia(usuario);
                lista.add(ocorrencia);
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

    public List<Object> listarPendentesSec(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Ocorrencia ocorrencia = null;
        List<Object> lista = new ArrayList<Object>();
        try {
            String sql = "select u.id_usuario, u.nome_usuario, ca.id_categoria, ca.nome_categoria, o.id_ocorrencia, o.datacriacao_ocorrencia, o.titulo_ocorrencia, o.status_ocorrencia from ocorrencia o inner join usuario u on u.id_usuario=o.id_usuario inner join categoria ca on ca.id_categoria = o.id_ocorrencia where o.id_secretaria is not null and o.id_secretaria = ? and (o.status_ocorrencia = 'Nova' or o.status_ocorrencia = 'Encaminhada') order by o.id_ocorrencia desc;";
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                Categoria categoria = new Categoria();
                ocorrencia = new Ocorrencia();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNomeUsuario(rs.getString("nome_usuario"));
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNomeCategoria(rs.getString("nome_categoria"));
                ocorrencia.setIdOcorrencia(rs.getInt("id_ocorrencia"));
                ocorrencia.setDataCriacaoOcorrencia(rs.getDate("datacriacao_ocorrencia"));
                ocorrencia.setTituloOcorrencia(rs.getString("titulo_ocorrencia"));
                ocorrencia.setStatusOcorrencia(rs.getString("status_ocorrencia"));
                ocorrencia.setCategoriaOcorrencia(categoria);
                ocorrencia.setUsuarioOcorrencia(usuario);
                lista.add(ocorrencia);
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

    public List<Object> listarMinha(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Ocorrencia ocorrencia = null;
        List<Object> lista = new ArrayList<Object>();
        try {
            String sql = "select e.id_estado, e.uf_estado, c.id_cidade, c.nome_cidade, s.id_secretaria, s.nome_secretaria, o.id_ocorrencia, o.localizacao_ocorrencia, o.descricao_ocorrencia, o.datacriacao_ocorrencia, o.titulo_ocorrencia, o.status_ocorrencia from ocorrencia o inner join cidade c on c.id_cidade = o.id_cidade inner join estado e on e.id_estado=c.id_estado left join secretaria s on s.id_secretaria=o.id_secretaria where o.id_usuario = ? order by o.id_ocorrencia desc;";
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Estado estado = new Estado();
                Cidade cidade = new Cidade();
                Secretaria secretaria = new Secretaria();
                ocorrencia = new Ocorrencia();
                estado.setIdEstado(rs.getInt("id_estado"));
                estado.setUfEstado(rs.getString("uf_estado"));
                cidade.setIdCidade(rs.getInt("id_cidade"));
                cidade.setNomeCidade(rs.getString("nome_cidade"));
                cidade.setEstadoCidade(estado);
                secretaria.setIdSecretaria(rs.getInt("id_secretaria"));
                secretaria.setNomeSecretaria(rs.getString("nome_secretaria"));
                secretaria.setCidadeSecretaria(cidade);
                ocorrencia.setIdOcorrencia(rs.getInt("id_ocorrencia"));
                ocorrencia.setLocalizacaoOcorrencia(rs.getString("localizacao_ocorrencia"));
                ocorrencia.setDescricaoOcorrencia(rs.getString("descricao_ocorrencia"));
                ocorrencia.setDataCriacaoOcorrencia(rs.getDate("datacriacao_ocorrencia"));
                ocorrencia.setTituloOcorrencia(rs.getString("titulo_ocorrencia"));
                ocorrencia.setStatusOcorrencia(rs.getString("status_ocorrencia"));
                ocorrencia.setCidadeOcorrencia(cidade);
                ocorrencia.setSecretariaOcorrencia(secretaria);
                lista.add(ocorrencia);
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

    public Integer retornarId() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer id = null;
        String sql = "select max(id_ocorrencia) as id from ocorrencia;";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao retornarID! Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
        return id;
    }

}
