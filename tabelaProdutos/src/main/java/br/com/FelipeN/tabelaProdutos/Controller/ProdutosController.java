package br.com.FelipeN.tabelaProdutos.Controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.FelipeN.tabelaProdutos.Controller.Dto.ProdutoDto;
import br.com.FelipeN.tabelaProdutos.Controller.Form.AtualizacaoProdutoForm;
import br.com.FelipeN.tabelaProdutos.Controller.Form.ProdutoForm;
import br.com.FelipeN.tabelaProdutos.modelo.Produto;
import br.com.FelipeN.tabelaProdutos.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public List<ProdutoDto> lista(String nomeProduto){
		
		if(nomeProduto == null) {
			List<Produto> Produtos = produtoRepository.findAll();
			return ProdutoDto.converter(Produtos);
		}else {
			List<Produto> Produtos = produtoRepository.findBynomeProduto(nomeProduto);
			return ProdutoDto.converter(Produtos);			
		}				
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<ProdutoDto> cadastrar(@RequestBody @Valid ProdutoForm form, UriComponentsBuilder uriBuilder) {
		Produto produto = form.converter();
		produtoRepository.save(produto);
		
		URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProdutoDto(produto));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <ProdutoDto> detalhar(@PathVariable Long id) {
	Optional<Produto> produto =produtoRepository.findById(id);
	 if (produto.isPresent()) {
		 
		 return ResponseEntity.ok(new ProdutoDto(produto.get()));		
	 }
	 return ResponseEntity.notFound().build();
	
}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProdutoDto> atualizar(@PathVariable Long id,@RequestBody @Valid AtualizacaoProdutoForm form){
		Optional<Produto> optional =produtoRepository.findById(id);
		 if (optional.isPresent()) {
			 
			 Produto produto =form.atualizar(id, produtoRepository);
			 
			 return ResponseEntity.ok(new ProdutoDto(produto));		
		 }
		 
		 return ResponseEntity.notFound().build();				 		
	}
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<Produto> optional =produtoRepository.findById(id);
		if (optional.isPresent()) {
			 
			produtoRepository.deleteById(id);
			 return ResponseEntity.ok().build();
	}
		 return ResponseEntity.notFound().build();	
}}