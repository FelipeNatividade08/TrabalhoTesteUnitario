package br.com.FelipeN.tabelaProdutos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.FelipeN.tabelaProdutos.modelo.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
		
	List<Produto> findBynomeProduto(String nomeProduto);
	

}
