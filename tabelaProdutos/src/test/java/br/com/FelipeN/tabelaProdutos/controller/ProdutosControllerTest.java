package br.com.FelipeN.tabelaProdutos.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.mockito.Mockito;

import br.com.FelipeN.tabelaProdutos.Controller.ProdutosController;
import br.com.FelipeN.tabelaProdutos.Controller.Dto.ProdutoDto;
import br.com.FelipeN.tabelaProdutos.modelo.Produto;
import br.com.FelipeN.tabelaProdutos.repository.ProdutoRepository;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

@WebMvcTest
public class ProdutosControllerTest {
	
	@Autowired
	private ProdutosController produtoController;
	
	@MockBean
	private ProdutoRepository produtoRepository;
	
	@BeforeEach
	public void setup() {
		standaloneSetup(this.produtoController);
		
	}
	
	@Test
	public void deveBuscarProduto() {
		when(this.produtoRepository.save(null)).thenReturn(new ProdutoDto(null));
		
		given().accept(ContentType.JSON).when().get("/produtos/{id}",123456789)
		.then().statusCode(HttpStatus.OK.value());
	}
}
