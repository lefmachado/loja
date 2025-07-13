package br.com.estudo.loja.testes;

import br.com.estudo.loja.dao.CategoriaDao;
import br.com.estudo.loja.dao.ProdutoDao;
import br.com.estudo.loja.modelo.Categoria;
import br.com.estudo.loja.modelo.Produto;
import br.com.estudo.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroDeProduto {

    public static void main(String[] args) {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Xiaomi Redmi",
                "Muito legal",
                new BigDecimal("800"),
                celulares);

        EntityManager em  = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);

        em.getTransaction().commit();
        em.close();
    }
}
