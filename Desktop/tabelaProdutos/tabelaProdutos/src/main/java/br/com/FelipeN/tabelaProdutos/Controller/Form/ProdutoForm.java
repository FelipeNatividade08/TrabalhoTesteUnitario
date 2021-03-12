package br.com.FelipeN.tabelaProdutos.Controller.Form;

import com.sun.istack.NotNull;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.FelipeN.tabelaProdutos.modelo.Produto;

public class ProdutoForm {
	
	@NotNull@Length(min = 2)
	private String nomeProduto;
	
	@NotNull
	private Float valor;
	
	@NotNull
	private Long id;
	
	@NotNull@Length(min = 2)
	private String Descricao;
	
	@NotNull
	private Integer estoque;
	
	
	public String getProduto() {
		return nomeProduto;
	}
	public void setProduto(String produto) {
		this.nomeProduto = produto;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	public Integer getEstoque() {
		return estoque;
	}
	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}
	public Produto converter() {
		
		return new Produto(id, nomeProduto, Descricao, valor, estoque);
	}
	
	

}
