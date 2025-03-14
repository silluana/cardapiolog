package br.com.rasmoo.restaurante.service.teste;

import br.com.rasmoo.restaurante.dao.PratoDao;
import br.com.rasmoo.restaurante.entity.Prato;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class PratoService {

    public static void main(String[] args) {

        Prato camaraoAbacaxi = new Prato();
        camaraoAbacaxi.setNome("CAMARÃO NO ABACAXI");
        camaraoAbacaxi.setDescricao("Abacaxi recheado com creme de catupiry, creem cheese e camarão. Coberto por " +
                "camarão VM e queijo parmesão. Acompanha batata palha, palmito, azeitona e arroz branco.");
        camaraoAbacaxi.setDisponivel(true);
        camaraoAbacaxi.setValor(BigDecimal.valueOf(160.00));

        Prato camaraoCoco = new Prato();
        camaraoCoco.setNome("CAMARÃO NO COCO");
        camaraoCoco.setDescricao("Coco verde recheado com creme de catupiry, creem cheese e camarão. Coberto por " +
                "camarão VM e queijo parmesão. Acompanha batata palha, palmito, azeitona e arroz branco.");
        camaraoCoco.setDisponivel(true);
        camaraoCoco.setValor(BigDecimal.valueOf(150.00));

        EntityManager entityManager = JPAUtil.getEntityManagerCardapioLog();
        PratoDao pratoDao = new PratoDao(entityManager);
        entityManager.getTransaction().begin();
        pratoDao.cadastrar(camaraoAbacaxi);
        entityManager.flush();
        pratoDao.cadastrar(camaraoCoco);
        entityManager.flush();
        System.out.println("O prato consultado: "+pratoDao.consultar(2));

        pratoDao.excluir(camaraoCoco);
        System.out.println("O prato consultado: "+pratoDao.consultar(2));
        //entityManager.getTransaction().commit();
        //entityManager.close();
        entityManager.clear();

        camaraoAbacaxi.setValor(BigDecimal.valueOf(125.50));
        pratoDao.atualizar(camaraoAbacaxi);
        System.out.println("O prato consultado: "+pratoDao.consultar(1));
    }

}
