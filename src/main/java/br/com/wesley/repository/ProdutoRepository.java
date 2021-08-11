package br.com.wesley.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.wesley.domain.Cliente;
import br.com.wesley.domain.Endereco;
import br.com.wesley.domain.Produto;

public class ProdutoRepository {

	// Cria��o do gerente de entidades
	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
	protected static EntityManager em = emf.createEntityManager();

	public static void salvar(Produto p) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
//		em.close();
//		emf.close();
		System.out.println("Os dados foram persistidos com sucesso.  m�todo salvar do ProdutoRepository.");
	}

	public static Produto buscar(Integer id) {

		em.getTransaction().begin();
		Produto produto = em.find(Produto.class, id);
		em.getTransaction().commit();
//		em.close();
//		emf.close();
		return produto;
	}

//	No m�todo a seguir usamos algo chamado de JPQL; Basta citar o objeto a ser pesquisado.
	public static List<Produto> listarTudo() {
		List<Produto> produtos = null;

		produtos = em.createQuery("from Produto").getResultList();
// em.close();
		return produtos;
	}

	public static void atualizar(Produto p, Integer id) {

		Produto produto = buscar(id); // est� recebendo do banco de dados
		em.getTransaction().begin();
		produto.setNome(p.getNome());
		produto.setValor(p.getValor());
		produto.setDescricao(p.getDescricao());
		em.persist(produto);
		em.getTransaction().commit();
	}
	
public static void remover(Produto produto) {
		
		em.getTransaction().begin();
		em.remove(produto);
		em.getTransaction().commit();
	}

public static void remover(Integer id) {
	Produto produto = buscar(id);
	remover(produto);
}
}
