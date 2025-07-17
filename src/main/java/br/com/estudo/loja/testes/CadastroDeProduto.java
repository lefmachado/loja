package br.com.estudo.loja.testes;

import br.com.estudo.loja.dao.CategoriaDao;
import br.com.estudo.loja.dao.ProdutoDao;
import br.com.estudo.loja.modelo.Categoria;
import br.com.estudo.loja.modelo.Produto;
import br.com.estudo.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CadastroDeProduto {

    private static final Logger LOGGER = LoggerFactory.getLogger(CadastroDeProduto.class);

    public static void main(String[] args) {
        cadastrarProduto();
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        Produto p = produtoDao.burcarPorId(1L);
        LOGGER.info("Preço do produto encontrado: {}", p.getPreco());

        List<Produto> todos = produtoDao.buscarTodos();
        todos.forEach(produto -> LOGGER.info("Produto: {}", produto.getNome()));
    }

    private static void cadastrarProduto() {
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
