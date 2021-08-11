package br.com.wesley.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.wesley.domain.Cliente;
import br.com.wesley.domain.Endereco;

public class EnderecoRepository {

	// Cria��o do gerente de entidades
	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
	protected static EntityManager em = emf.createEntityManager();

	public static void salvar(Endereco e) {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
//				se n�o fechar ent�o funciona tudo.
//				em.close();
//				emf.close();
	}

	public static Endereco buscar(Integer id) {
		// Assistir e analisar o seguinte link https://youtu.be/8hXlmji2Mcw

		em.getTransaction().begin();
		Endereco endereco = em.find(Endereco.class, id);
		em.getTransaction().commit();
//				em.close();
//				emf.close();
		return endereco;
	}

//			No m�todo a seguir usamos algo chamado de JPQL; Basta citar o objeto a ser pesquisado.
	public static List<Endereco> listarTudo() {
		List<Endereco> enderecos = null;

		enderecos = em.createQuery("from Endereco").getResultList();
		// em.close();
		return enderecos;
	}

	public static void atualizar(Endereco e, Integer id) {

		Endereco endereco = buscar(id); // est� recebendo do banco de dados
		em.getTransaction().begin();
		endereco.setRua(e.getRua());
		endereco.setNumero(e.getNumero());
		endereco.setCidade(e.getCidade());
		endereco.setBairro(e.getBairro());
		endereco.setCep(e.getCep());
		em.persist(endereco);
		em.getTransaction().commit();
	}

	public static Endereco remover(Integer id) {

		Endereco endereco = em.find(Endereco.class, id);
		em.getTransaction().begin();
		em.flush();
		em.remove(endereco);
		em.getTransaction().commit();
		return endereco;
	}
	
	public static void remover(Endereco endereco) {
		em.getTransaction().begin();
		em.remove(endereco);
		em.getTransaction().commit();
	}
}
