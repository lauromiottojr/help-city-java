package br.com.helpcity.DAO;

import br.com.helpcity.util.ConnectionFactory;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class DadosDAO {

    private Connection conn;

    public DadosDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public ArrayList<Integer> countDados() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Integer> somas = new ArrayList();
        String sql = "select (select count(id_ocorrencia) as soma_ocorrencia from ocorrencia),(select count(id_cidade) as soma_cidade from cidade),(select count(id_admprefeitura) as soma_admprefeitura from admprefeitura),	(select count(id_funcionario) as soma_funcionario from funcionario),(select count(id_cidadao) as soma_cidadao from cidadao),(select count(id_ocorrencia) as soma_ocorrencia_nova from ocorrencia where status_ocorrencia = 'Nova'),(select count(id_ocorrencia) as soma_ocorrencia_encaminhada from ocorrencia where status_ocorrencia = 'Encaminhada'),(select count(id_ocorrencia) as soma_ocorrencia_finalizada from ocorrencia where status_ocorrencia = 'Finalizada'),(select count(id_ocorrencia) as soma_ocorrencia_cancelada from ocorrencia where status_ocorrencia = 'Cancelada');";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                somas.add(rs.getInt("soma_cidade"));
                somas.add(rs.getInt("soma_admprefeitura"));
                somas.add(rs.getInt("soma_funcionario"));
                somas.add(rs.getInt("soma_cidadao"));
                somas.add(rs.getInt("soma_ocorrencia"));
                somas.add(rs.getInt("soma_ocorrencia_nova"));
                somas.add(rs.getInt("soma_ocorrencia_encaminhada"));
                somas.add(rs.getInt("soma_ocorrencia_finalizada"));
                somas.add(rs.getInt("soma_ocorrencia_cancelada"));
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao retornarID! Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
        return somas;
    }

    public ArrayList<Integer> countDadosCidade(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Integer> somascidade = new ArrayList();
        String sqlone = "select (select count(id_ocorrencia) as soma_ocorrencia from ocorrencia where id_cidade = ?),(select count(id_admprefeitura) as soma_admprefeitura from admprefeitura where id_cidade = ?),(select count(id_funcionario) as soma_funcionario from funcionario f inner join secretaria s on s.id_secretaria = f.id_secretaria where s.id_cidade = ?),(select count(id_cidadao) as soma_cidadao from cidadao where id_cidade = ?),(select count(id_ocorrencia) as soma_ocorrencia_nova from ocorrencia where status_ocorrencia = 'Nova' and id_cidade = ?),(select count(id_ocorrencia) as soma_ocorrencia_encaminhada from ocorrencia where status_ocorrencia = 'Encaminhada' and id_cidade = ?),(select count(id_ocorrencia) as soma_ocorrencia_finalizada from ocorrencia where status_ocorrencia = 'Finalizada' and id_cidade = ?),(select count(id_ocorrencia) as soma_ocorrencia_cancelada from ocorrencia where status_ocorrencia = 'Cancelada' and id_cidade = ?);";
        try {
            stmt = conn.prepareStatement(sqlone);
            for (int i = 1; i <= 8; i++) {
                stmt.setInt(i, idObject);
            }
            rs = stmt.executeQuery();
            while (rs.next()) {
                somascidade.add(rs.getInt("soma_admprefeitura"));
                somascidade.add(rs.getInt("soma_funcionario"));
                somascidade.add(rs.getInt("soma_cidadao"));
                somascidade.add(rs.getInt("soma_ocorrencia"));
                somascidade.add(rs.getInt("soma_ocorrencia_nova"));
                somascidade.add(rs.getInt("soma_ocorrencia_encaminhada"));
                somascidade.add(rs.getInt("soma_ocorrencia_finalizada"));
                somascidade.add(rs.getInt("soma_ocorrencia_cancelada"));
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao retornarID! Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
        return somascidade;
    }

    public ArrayList<Object[]> countOcorrenciasCategorias(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Object[]> categorias = new ArrayList();
        String sql = "select c.nome_categoria, count(c.id_categoria) as quantidade from categoria c inner join ocorrencia o on o.id_categoria = c.id_categoria where c.id_cidade = ? group by c.nome_categoria;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Object[] values = {rs.getString("nome_categoria"), rs.getInt("quantidade")};
                categorias.add(values);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao retornar items! Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
        return categorias;
    }

    public ArrayList<Integer> countIdade() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Integer> idades = new ArrayList();
        String sql = "select (select count(date_part('year',current_date) - date_part('year',datanascimento_usuario)) as menores_idade from usuario where date_part('year',current_date) - date_part('year',datanascimento_usuario) < 18),(select count(date_part('year',current_date) - date_part('year',datanascimento_usuario)) as primeira_idade  from usuario   where date_part('year',current_date) - date_part('year',datanascimento_usuario) between 18 and 35),(select count(date_part('year',current_date) - date_part('year',datanascimento_usuario)) as segunda_idade from usuario where date_part('year',current_date) - date_part('year',datanascimento_usuario) between 36 and 50),(select count(date_part('year',current_date) - date_part('year',datanascimento_usuario)) as terceira_idade  from usuario  where date_part('year',current_date) - date_part('year',datanascimento_usuario) > 50);";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                idades.add(rs.getInt("menores_idade"));
                idades.add(rs.getInt("primeira_idade"));
                idades.add(rs.getInt("segunda_idade"));
                idades.add(rs.getInt("terceira_idade"));
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao retornar items! Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
        return idades;
    }

    public ArrayList<Object[]> countOcorrenciasSecretarias(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Object[]> secretarias = new ArrayList();
        String sql = "select s.nome_secretaria, count(o.id_secretaria) as quantidade from ocorrencia o inner join secretaria s on o.id_secretaria = s.id_secretaria where s.id_cidade = ? group by s.nome_secretaria;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Object[] values = {rs.getString("nome_secretaria"), rs.getInt("quantidade")};
                secretarias.add(values);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao retornar items! Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
        return secretarias;
    }

    public ArrayList<Object[]> ocorrenciaDataCidade(String startDate, String endDate, int idObject, String status) throws ParseException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Object[]> periodos = new ArrayList();
        System.out.println(status);
        if (status.equalsIgnoreCase("Todas")) {
            String sql = "select count(id_ocorrencia) as qnt, datacriacao_ocorrencia from ocorrencia where datacriacao_ocorrencia between to_date(?, 'dd/mm/yyyy') and to_date(?, 'dd/mm/yyyy') and id_cidade = ? group by datacriacao_ocorrencia order by datacriacao_ocorrencia;";
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, startDate);
                stmt.setString(2, endDate);
                stmt.setInt(3, idObject);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    Object[] values = {rs.getString("datacriacao_ocorrencia"), rs.getInt("qnt")};
                    periodos.add(values);
                }
            } catch (SQLException ex) {
                System.out.println("Problemas ao retornar items! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        } else {
            String sql = "select count(id_ocorrencia) as qnt, datacriacao_ocorrencia from ocorrencia where datacriacao_ocorrencia between to_date(?, 'dd/mm/yyyy') and to_date(?, 'dd/mm/yyyy') and id_cidade = ? and status_ocorrencia = ? group by datacriacao_ocorrencia order by datacriacao_ocorrencia;";
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, startDate);
                stmt.setString(2, endDate);
                stmt.setInt(3, idObject);
                stmt.setString(4, status);
                rs = stmt.executeQuery();
                while (rs.next()) {

                    Object[] values = {rs.getString("datacriacao_ocorrencia"), rs.getInt("qnt")};
                    periodos.add(values);
                }
            } catch (SQLException ex) {
                System.out.println("Problemas ao retornar items! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return periodos;
    }

}
