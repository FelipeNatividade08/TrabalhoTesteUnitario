package br.com.FelipeN.tabelaProdutos.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Produto {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeProduto;
	private String Descricao;
	private Float valor;
	
	//@ManyToOne
	private Integer estoque;
	
	public Produto() {
		
	}
			
	public Produto(Long id, String nomeProduto, String descricao, float valor, int estoque) {
		super();
		this.id = id;
		this.nomeProduto = nomeProduto;
		Descricao = descricao;
		this.valor = valor;
		this.estoque = estoque;
	}


	public Integer getEstoque() {
		return estoque;
	}
	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
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
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
		
}
