package br.com.helpcity.DAO;

import java.util.List;

public interface GenericDAO {

    public Boolean cadastrar(Object object);

    public List<Object> listar();

    public List<Object> listarCidade(int idObject);

    public Object carregar(int idObject);

    public Boolean alterar(Object object);
    
    public Boolean alterarStatus(Object object);
}
