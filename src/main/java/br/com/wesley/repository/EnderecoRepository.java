package br.com.wesley.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.wesley.domain.Endereco;

public class EnderecoRepository {
	
	// Criação do gerente de entidades
			protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
			protected static EntityManager em = emf.createEntityManager();
			
			public static void salvar(Endereco e) {
				em.getTransaction().begin();				
				em.persist(e);
				em.getTransaction().commit();
//				se não fechar então funciona tudo.
//				em.close();
//				emf.close();
			}
			
			public static Endereco buscar(Integer id) {
				//Assistir e analisar o seguinte link https://youtu.be/8hXlmji2Mcw
				
				em.getTransaction().begin();
				Endereco endereco = em.find(Endereco.class, id);
				em.getTransaction().commit();
				em.close();
				emf.close();
				return endereco;
			}
}
