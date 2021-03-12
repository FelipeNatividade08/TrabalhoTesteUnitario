package br.com.FelipeN.tabelaProdutos.Controller.Dto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.FelipeN.tabelaProdutos.modelo.Produto;

public class ProdutoDto {
	
	private Long id;
	private String Descricao;
	private float valor;
	
	public ProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.Descricao = produto.getDescricao();
		this.valor = produto.getValor();		
	}
	
	public Long getId() {
		return id;
	}
	public String getDescricao() {
		return Descricao;
	}
	public float getValor() {
		return valor;
	}
	public static List<ProdutoDto> converter(List<Produto> produtos){
		return produtos.stream().map(ProdutoDto::new).collect(Collectors.toList());
	}
}
