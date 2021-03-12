package br.com.FelipeN.tabelaProdutos.Controller.Form;

import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import br.com.FelipeN.tabelaProdutos.modelo.Produto;
import br.com.FelipeN.tabelaProdutos.repository.ProdutoRepository;

public class AtualizacaoProdutoForm {
	
	@NotNull
	private Integer estoque;
	
	@NotNull
	private Float valor;

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}
	
	public Produto atualizar (Long id, ProdutoRepository produtoRepository) {
		Produto produto = produtoRepository.getOne(id);
		produto.setValor(this.valor);
		produto.setEstoque(this.estoque);
		return produto;
	}
	

}
