package br.com.rasmoo.restaurante.service.teste;

import br.com.rasmoo.restaurante.dao.CardapioDao;
import br.com.rasmoo.restaurante.util.CargaDeDadosUtil;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {

    public static void main(String[] args) {

        EntityManager entityManager = JPAUtil.getEntityManagerCardapioLog();
        entityManager.getTransaction().begin();

        CargaDeDadosUtil.cadastrarCategorias(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        System.out.println("Lista de produtos por valor: "+ cardapioDao.consultarPorValor(BigDecimal.valueOf(59.00)));

        System.out.println("O produto pesquisado por nome: "+ cardapioDao.consultarPorNome("Moqueca"));

        entityManager.close();
    }
}
