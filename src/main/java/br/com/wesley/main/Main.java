package br.com.wesley.main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.wesley.domain.Cliente;
import br.com.wesley.domain.Endereco;
import br.com.wesley.domain.Produto;
import br.com.wesley.domain.Venda;
import br.com.wesley.domain.Vendedor;
import br.com.wesley.repository.ClienteRepository;
import br.com.wesley.repository.EnderecoRepository;
import br.com.wesley.repository.ProdutoRepository;
import br.com.wesley.repository.VendaRepository;
import br.com.wesley.repository.VendedorRepository;

public class Main {

	public static void main(String[] args) {
		
		Produto p1 = new Produto(null, "Carro", "sedan", 10000.00); // criando o objeto sem atributos no construtor.
		Produto p2 = new Produto(null, "Bike", "Crossn", 2000.00); // criando o objeto sem atributos no construtor.
		Produto p3 = new Produto(null, "Sofï¿½", "poltrona", 500.00); // criando o objeto sem atributos no construtor.
		Produto p4 = new Produto(null, "mesa", "redonda", 200.00); // criando o objeto sem atributos no construtor.

		List<Produto> produtos1 = new ArrayList<Produto>();
		produtos1.add(p1);
		produtos1.add(p2);
		
		List<Produto> produtos2 = new ArrayList<Produto>();
		produtos2.add(p3);
		produtos2.add(p4);

		Endereco e1 = new Endereco(null, "Rua 01", "111", "bairo imperador", "Tangamandï¿½pio", "72345-678");
		Cliente c1 = new Cliente(null, "Bia", "bia@email.com", "3356-8521", "123456", e1);
		
		Endereco e2 = new Endereco(null, "Rua 02", "222", "bairo do lago", "Vandolandia", "71345-987");
		Cliente c2 = new Cliente(null, "cid", "cid@email.com", "2345-6789", "987654", e2);

		Vendedor vd1 = new Vendedor(null, "Ana");
		Vendedor vd2 = new Vendedor(null, "Eva");

		
		Venda v1 = new Venda(null, vd1, c1);
		Venda v2 = new Venda(null, vd1, c2);
		
		
		Venda v3 = new Venda(null, vd2, c1);
		Venda v4 = new Venda(null, vd2, c2);


		
		ProdutoRepository.salvar(p1);
		//ClienteRepository.salvar(c1);
		VendaRepository.salvar(v4);
		//EnderecoRepository.buscar(2);
		
//		1) Fiz o dever de casa, mas por algum motivo que não sei explicar,
//		tive que fazer umas gambiarras para conseguir fazer rodar. 
		
//		2) Nas classes repository, o método salvar, só funciona mais 
//		de uma vez se não fechar o em e o emf. 
		
//		3) Em alguns casos o método toString estava meio bagunçado e eu ajustei
//		ao meu estilo.
		
//		4) Procurando respostas às minhas dúvidas e na busca pela solução, 
//		no google, ví uns lances legais no Persistence.xml , daí emplementei no meu código. 
		
		EnderecoRepository er = new EnderecoRepository ();
		Endereco endereco = er.buscar(2);		
		System.out.println(endereco);
		
		ClienteRepository cr = new ClienteRepository();
		Cliente cliente = cr.buscar(2);		
		System.out.println(cliente);
		
		ProdutoRepository pr = new ProdutoRepository();
		Produto produto = pr.buscar(1);
		System.out.println(produto);
		
		VendaRepository vr = new VendaRepository();
		Venda venda = vr.busca(6);
		System.out.println(venda);
		
		VendedorRepository vddr = new VendedorRepository();
		Vendedor vendedor = vddr.busca(5);
		System.out.println(vendedor);
		 ///////////////////////////////////////////////////////
		
		List<Cliente> clientes = (List<Cliente>) cr.listarClientes();	
		for (Cliente c : clientes) {
			System.out.println(c);
		}
		
	}
}
