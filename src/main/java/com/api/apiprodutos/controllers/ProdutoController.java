package com.api.apiprodutos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.api.apiprodutos.models.Produto;
import com.api.apiprodutos.services.ProdutoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

// TODO: Auto-generated Javadoc
/**
 * The Class ProdutoController.
 */
@Controller
@RequestMapping("/api/v1")
public class ProdutoController {

	/** The produto service. */
	@Autowired
	private ProdutoService produtoService;
	
	/**
	 * Inseri um produto.
	 *
	 * @param produto the produto
	 * @return the response entity
	 */
	@PostMapping("/produto/novo")
	@ApiOperation("Cadastra um novo produto no BD")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Produto criado com sucesso!"),
			@ApiResponse(code = 400, message = "Erro ao enviar os dados para o servidor!"),
			@ApiResponse(code = 500, message = "Erro no retorno do servidor!")
	})
	public ResponseEntity<Produto> inseriUmProduto(@RequestBody Produto produto){
		produto = produtoService.inserirProduto(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(produto);
	}
	
	/**
	 * Listar produtos.
	 *
	 * @return the response entity
	 */
	@GetMapping("/produtos")
	@ApiOperation("Lista todos os produtos")
	public ResponseEntity<List<Produto>> listarProdutos(){
		List<Produto> produto = produtoService.buscarTodosProdutos();
		return ResponseEntity.status(HttpStatus.OK).body(produto);
	}
	
	/**
	 * Buscar um produto.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@GetMapping("/produto/{id}")
	@ApiOperation("Busca apenas um produto")
	public ResponseEntity<Produto> buscarUmProduto(@PathVariable Long id){
		Produto produto = produtoService.buscarUmProduto(id);
		return ResponseEntity.status(HttpStatus.OK).body(produto);
	}
	
	/**
	 * Editar um produto.
	 *
	 * @param id the id
	 * @param produto the produto
	 * @return the response entity
	 */
	@PutMapping("/produto/{id}")
	@ApiOperation("Edita um produto")
	public ResponseEntity<Produto> editarUmProduto(@PathVariable Long id, @RequestBody Produto produto){
		produto.setId(id);
		produto = produtoService.editarProduto(produto);
		return ResponseEntity.status(HttpStatus.OK).body(produto);
	}
	
	/**
	 * Deletar um produto.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping("/produto/{id}")
	@ApiOperation("Deleta um produto")
	public ResponseEntity<Void> deletarUmProduto(@PathVariable Long id){
		produtoService.deletarProduto(id);
		return ResponseEntity.noContent().build();
	}
	
}
