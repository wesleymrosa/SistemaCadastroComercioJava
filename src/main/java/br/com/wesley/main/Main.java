package br.com.wesley.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.wesley.model.Cliente;
import br.com.wesley.model.Endereco;
import br.com.wesley.model.Produto;
import br.com.wesley.model.Venda;
import br.com.wesley.model.Vendedor;

public class Main {

	public static void main(String[] args) {
		//Marca m = new Marca(null, "BMW", "nacional"); 
		
		Produto p1 = new Produto(null, "Carro", "sedan", 10000.00); // criando o objeto sem atributos no construtor.
		Produto p2 = new Produto(null, "Bike", "Crossn", 2000.00); // criando o objeto sem atributos no construtor.
		Produto p3 = new Produto(null, "Sofá", "poltrona", 500.00); // criando o objeto sem atributos no construtor.
		Produto p4 = new Produto(null, "mesa", "redonda", 200.00); // criando o objeto sem atributos no construtor.

		List<Produto> produtos1 = new ArrayList<Produto>();
		//produtos1 = Arrays.asList(p1, p2);
		produtos1.add(p1);
		produtos1.add(p2);
		
		
		List<Produto> produtos2 = new ArrayList<Produto>();
		//produtos2 = Arrays.asList(p3, p4);
		produtos2.add(p3);
		produtos2.add(p4);

		Vendedor vd1 = new Vendedor(null, "Ana", null);
		Vendedor vd2 = new Vendedor(null, "Eva", null);

		List<Venda> vendas1 = new ArrayList<>();
		Venda v1 = new Venda(null, vd1, null, produtos2);
		Venda v2 = new Venda(null, vd1, null, produtos1);
		
		List<Venda> vendas2 = new ArrayList<>();
		Venda v3 = new Venda(null, vd2, null, null);
		Venda v4 = new Venda(null, vd2, null, null);

		Endereco e1 = new Endereco(null, "Rua 01", "111", "bairo imperador", "Tangamandápio", "72345-678");
		Cliente c1 = new Cliente(null, "Bia", "bia@email.com", "3356-8521", "123456", e1, null);

		Endereco e2 = new Endereco(null, "Rua 02", "222", "bairo do lago", "Vandolandia", "71345-987");
		Cliente c2 = new Cliente(null, "cid", "cid@email.com", "2345-6789", "987654", e2, null);

		v1.setCliente(c1);
		v2.setCliente(c2);
		v3.setCliente(c1);
		v4.setCliente(c2);

		vendas1 = Arrays.asList(v1,v2);
		vendas2.add(v3);
		vendas2.add(v4);
		
		vd1.setVendas(vendas1);
		vd2.setVendas(vendas2);


		//p1.setNome("moto");
		//p1.setDescricao("novo");
		//p1.setValor(15000.00);

		//p1.setMarca(m);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testedb");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		

		//em.persist(m); // persistência do conteúdo do atributo marca.
		
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.persist(p4);
		
		//em.persist(produtos1);
		//em.persist(produtos2);		
		
		em.persist(vd1);
		em.persist(vd2);
		
		//em.persist(vendas1);
		//em.persist(vendas2);
		
		em.persist(v1);
		em.persist(v2);
		em.persist(v3);
		em.persist(v4);
		
		
		em.persist(e1);
		em.persist(c1);
		
		em.persist(e2);
		em.persist(c2);
		
		
		em.getTransaction().commit();
		System.out.println("Transação com o BD concluída.");
		em.close(); // fecha o em
		emf.close(); // fecha o emf
	}
}
