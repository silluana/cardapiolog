package br.com.rasmoo.restaurante.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory CARDAPIOLOG = Persistence.createEntityManagerFactory("cardapiolog");

    public static EntityManager getEntityManagerCardapioLog(){
        return CARDAPIOLOG.createEntityManager();
    }
}
