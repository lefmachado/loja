package br.com.estudo.loja.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory FACTORY = Persistence
            .createEntityManagerFactory("loja");

    private JPAUtil() {
        throw new UnsupportedOperationException("Esta é uma classe utilitária e não pode ser instanciada.");
    }

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }
}