package br.com.wesley.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.wesley.domain.Cliente;

public class ClienteRepository {
	
	// Criação do gerente de entidades
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
			//Assistir e analisar o seguinte link https://youtu.be/8hXlmji2Mcw
			
			em.getTransaction().begin();
			Cliente cliente = em.find(Cliente.class, id);
			em.getTransaction().commit();
//			em.close();
//			emf.close();
			return cliente;
		}
		
		public  TypedQuery<Cliente> listarClientes(){
			
			em.getTransaction().begin();
			TypedQuery<Cliente> clientes = em.createQuery("select c from cliente", Cliente.class);
			em.getTransaction().commit();
			em.close();
			emf.close();
			
			return clientes;
		} 
}
