package br.com.wesley.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.wesley.domain.Produto;

public class ProdutoRepository {

	// Criação do gerente de entidades
	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("vendasdb");
	protected static EntityManager em = emf.createEntityManager();

	
	public static void salvar(Produto p) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
