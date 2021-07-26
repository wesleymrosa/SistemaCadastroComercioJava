package br.com.wesley.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.wesley.domain.Vendedor;

public class VendedorRepository {
	
	// Criação do gerente de entidades
		protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
		protected static EntityManager em = emf.createEntityManager();
		
		public static void salvar(Vendedor vd) {
			em.getTransaction().begin();			
			em.persist(vd);
			em.getTransaction().commit();
//			em.close();
//			emf.close();
		}
		
		public static Vendedor busca(Integer id) {
			
			em.getTransaction().begin();
			Vendedor vendedor = em.find(Vendedor.class, id);
			em.getTransaction().commit();
			em.close();
			emf.close();
			
			return vendedor;
		}
}
