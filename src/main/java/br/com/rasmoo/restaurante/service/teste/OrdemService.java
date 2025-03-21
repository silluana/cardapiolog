package br.com.rasmoo.restaurante.service.teste;

import br.com.rasmoo.restaurante.dao.CardapioDao;
import br.com.rasmoo.restaurante.dao.ClienteDao;
import br.com.rasmoo.restaurante.dao.EnderecoDao;
import br.com.rasmoo.restaurante.dao.OrdemDao;
import br.com.rasmoo.restaurante.entity.*;
import br.com.rasmoo.restaurante.util.CargaDeDadosUtil;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;

public class OrdemService {

    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerCardapioLog();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastrarCategorias(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);
        CargaDeDadosUtil.cadastrarClientes(entityManager);
        CargaDeDadosUtil.cadastrarOrdensClientes(entityManager);

        //OrdemDao ordemDao = new OrdemDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);
        EnderecoDao enderecoDao = new EnderecoDao(entityManager);
        //System.out.println(ordemDao.consultarItensMaisVendidos());
        //System.out.println(clienteDao.consultarTodos());

        System.out.println(enderecoDao.consultarClientes(null, null, "Lapa"));
        System.out.println(enderecoDao.consultarClientesCriteria(null, null, "Lapa"));

        System.out.println(clienteDao.consultarPorId(new ClienteId("claudia@email.com", "111111111345")));

        //Ordem ordem  =  ordemDao.joinFetchCliente(2);
        //Ordem ordem  =  ordemDao.consultarPorId(2);

        entityManager.getTransaction().commit();
        entityManager.close();

        //System.out.println(ordem.getCliente().getNome());
    }
}
