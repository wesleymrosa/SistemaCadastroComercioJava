package br.com.wesley.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.wesley.domain.Venda;

public class VendaRepository {
	// Criação do gerente de entidades
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
			em.close();
			emf.close();
			return venda;
			
		}
}