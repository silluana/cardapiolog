package br.com.rasmoo.restaurante.service.teste;

import br.com.rasmoo.restaurante.dao.CardapioDao;
import br.com.rasmoo.restaurante.dao.CategoriaDao;
import br.com.rasmoo.restaurante.entity.Cardapio;
import br.com.rasmoo.restaurante.entity.Categoria;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {

    public static void main(String[] args) {

        EntityManager entityManager = JPAUtil.getEntityManagerCardapioLog();
        cadastrarProdutoCardapio(entityManager, cadastrarCategoria(entityManager));
    }

    private static  Categoria cadastrarCategoria(EntityManager entityManager) {
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        Categoria pratoPrincipal = new Categoria("Prato Principal");

        entityManager.getTransaction().begin();
        categoriaDao.cadastrar(pratoPrincipal);
        entityManager.getTransaction().commit();
        entityManager.clear();

        return pratoPrincipal;
    }

    private static void cadastrarProdutoCardapio(EntityManager entityManager, Categoria categoria) {
        Cardapio camaraoAbacaxi = new Cardapio();
        camaraoAbacaxi.setNome("CAMARÃO NO ABACAXI");
        camaraoAbacaxi.setDescricao("Abacaxi recheado com creme de catupiry, creem cheese e camarão. Coberto por " +
                "camarão VM e queijo parmesão. Acompanha batata palha, palmito, azeitona e arroz branco.");
        camaraoAbacaxi.setDisponivel(true);
        camaraoAbacaxi.setValor(BigDecimal.valueOf(160.00));
        camaraoAbacaxi.setCategoria(categoria);

        Cardapio camaraoCoco = new Cardapio();
        camaraoCoco.setNome("CAMARÃO NO COCO");
        camaraoCoco.setDescricao("Coco verde recheado com creme de catupiry, creem cheese e camarão. Coberto por " +
                "camarão VM e queijo parmesão. Acompanha batata palha, palmito, azeitona e arroz branco.");
        camaraoCoco.setDisponivel(true);
        camaraoCoco.setValor(BigDecimal.valueOf(150.00));
        camaraoCoco.setCategoria(categoria);

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        entityManager.getTransaction().begin();

        cardapioDao.cadastrar(camaraoAbacaxi);
        entityManager.flush();
        cardapioDao.cadastrar(camaraoCoco);
        entityManager.flush();
        //System.out.println("O prato consultado: "+ cardapioDao.consultarPorId(2));

        cardapioDao.consultarTodos().forEach(elemento->System.out.println("O prato consultado foi: "+elemento));

        //cardapioDao.excluir(camaraoCoco);
        //System.out.println("O prato consultado: "+ cardapioDao.consultar(2));
        //entityManager.getTransaction().commit();
        entityManager.close();
        //entityManager.clear();

        //camaraoAbacaxi.setValor(BigDecimal.valueOf(125.50));
        //cardapioDao.atualizar(camaraoAbacaxi);
        //System.out.println("O prato consultado: "+ cardapioDao.consultarPorId(1));
    }

}
