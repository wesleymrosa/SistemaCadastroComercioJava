package br.com.wesley.main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.wesley.domain.Cliente;
import br.com.wesley.domain.Endereco;
import br.com.wesley.domain.Produto;
import br.com.wesley.domain.Venda;
import br.com.wesley.domain.Vendedor;
import br.com.wesley.repository.ProdutoRepository;

public class Main {

	public static void main(String[] args) {
		
		Produto p1 = new Produto(null, "Carro", "sedan", 10000.00); // criando o objeto sem atributos no construtor.
		Produto p2 = new Produto(null, "Bike", "Crossn", 2000.00); // criando o objeto sem atributos no construtor.
		Produto p3 = new Produto(null, "Sof�", "poltrona", 500.00); // criando o objeto sem atributos no construtor.
		Produto p4 = new Produto(null, "mesa", "redonda", 200.00); // criando o objeto sem atributos no construtor.

		List<Produto> produtos1 = new ArrayList<Produto>();
		produtos1.add(p1);
		produtos1.add(p2);
		
		List<Produto> produtos2 = new ArrayList<Produto>();
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

		Endereco e1 = new Endereco(null, "Rua 01", "111", "bairo imperador", "Tangamand�pio", "72345-678");
		Cliente c1 = new Cliente(null, "Bia", "bia@email.com", "3356-8521", "123456", e1);

		Endereco e2 = new Endereco(null, "Rua 02", "222", "bairo do lago", "Vandolandia", "71345-987");
		Cliente c2 = new Cliente(null, "cid", "cid@email.com", "2345-6789", "987654", e2);

		v1.setCliente(c1);
		v2.setCliente(c2);
		v3.setCliente(c1);
		v4.setCliente(c2);

		vendas2.add(v1);
		vendas2.add(v2);
		vendas2.add(v3);
		vendas2.add(v4);
		
		vd1.setVendas(vendas1);
		vd2.setVendas(vendas2);
		
		ProdutoRepository.salvar(p2);
	}
}
