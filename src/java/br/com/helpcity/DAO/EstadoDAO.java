package br.com.helpcity.DAO;

import br.com.helpcity.model.Estado;
import br.com.helpcity.util.ConnectionFactory;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstadoDAO implements GenericDAO {

    private Connection conn;

    public EstadoDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Boolean cadastrar(Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public List<Object> listar() {
        List<Object> estados = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from estado order by nome_estado;";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Estado estado = new Estado();
                estado.setIdEstado(rs.getInt("id_estado"));
                estado.setNomeEstado(rs.getString("nome_estado"));
                estado.setUfEstado(rs.getString("uf_estado"));
                estados.add(estado);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar estado(DAO). Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão(DAO). Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return estados;
    }

    @Override
    public Object carregar(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean alterar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean alterarStatus(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Object> listarCidade(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
}
