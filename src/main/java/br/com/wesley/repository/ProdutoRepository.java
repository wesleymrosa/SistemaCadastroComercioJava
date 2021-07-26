package br.com.wesley.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.wesley.domain.Produto;

public class ProdutoRepository {

	// Criação do gerente de entidades
	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
	protected static EntityManager em = emf.createEntityManager();
	
	public static void salvar(Produto p) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
//		em.close();
//		emf.close();
		System.out.println("Os dados foram persistidos com sucesso.  método salvar do ProdutoRepository.");
	}

	public static Produto buscar(Integer id) {
		
		em.getTransaction().begin();
		Produto produto = em.find(Produto.class, id);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return produto;
	}
}


