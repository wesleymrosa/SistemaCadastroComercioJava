package br.com.wesley.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.wesley.domain.Endereco;
import br.com.wesley.domain.Produto;
import br.com.wesley.domain.Venda;

public class VendaRepository {
	// Cria��o do gerente de entidades
	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
	protected static EntityManager em = emf.createEntityManager();

	public static void salvar(Venda v) {

		VendedorRepository.salvar(v.getVendedor());
		ClienteRepository.salvar(v.getCliente());

		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
//			em.close();
//			emf.close();
	}

	public static Venda busca(Integer id) {

		em.getTransaction().begin();
		Venda venda = em.find(Venda.class, id);
		em.getTransaction().commit();
//		em.close();
//		emf.close();
		return venda;

	}

//	No m�todo a seguir usamos algo chamado de JPQL; Basta citar o objeto a ser pesquisado.
	public List<Venda> listarTudo() {
		List<Venda> vendas = null;

		vendas = em.createQuery("from Venda").getResultList();
// em.close();
		return vendas;
	}
	
public static void remover(Venda venda) {
		venda.setCliente(null);
		em.getTransaction().begin();
		em.remove(venda);
		em.getTransaction().commit();
	}

public static void remover(Integer id) {
	Venda venda = busca(id);
	remover(venda);
}
}