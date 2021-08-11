package br.com.wesley.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.wesley.domain.Cliente;

public class ClienteRepository {

	// Cria��o do gerente de entidades
	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
	protected static EntityManager em = emf.createEntityManager();

	public static void salvar(Cliente c) {

		em.getTransaction().begin();
		EnderecoRepository.salvar(c.getEndereco());
		em.persist(c);
		em.getTransaction().commit();
//			em.close();
//			emf.close();
	}

	public static Cliente buscar(Integer id) {
		// Assistir e analisar o seguinte link https://youtu.be/8hXlmji2Mcw

		em.getTransaction().begin();
		Cliente cliente = em.find(Cliente.class, id);
		em.getTransaction().commit();
//			em.close();
//			emf.close();
		return cliente;
	}

//		No m�todo a seguir usamos algo chamado de JPQL; Basta citar o objeto a ser pesquisado.
	public static List<Cliente> listarTudo() {
		List<Cliente> clientes = null;
		clientes = em.createQuery("from Cliente").getResultList();
		// em.close();
		return clientes;
	}

	public static void atualizar(Cliente c, Integer id) {

		Cliente cliente = buscar(id); // est� recebendo do banco de dados
		em.getTransaction().begin();
		cliente.setNome(c.getNome());
		cliente.setRg(c.getRg());
		cliente.setEmail(c.getEmail());
		cliente.setTelefone(c.getTelefone());
		cliente.setEndereco(c.getEndereco());
		em.persist(cliente);
		em.getTransaction().commit();
	}

	public static Cliente remover(Integer id) {

		Cliente cliente = buscar(id);
//		if (cliente.getEndereco() != null) {
//			cliente.setEndereco(null);
//		}
//		atualizar(cliente, id);
		EnderecoRepository.remover(cliente.getEndereco().getId());
		em.getTransaction().begin();
		em.remove(cliente.getEndereco());
		em.remove(cliente);
		em.getTransaction().commit();
		return cliente;
	}

	public static void remover(Cliente cliente) {
		
		em.getTransaction().begin();
		em.remove(cliente);
		em.getTransaction().commit();
	}
}
