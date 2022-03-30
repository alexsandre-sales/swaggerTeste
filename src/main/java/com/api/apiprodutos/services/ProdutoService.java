package com.api.apiprodutos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.apiprodutos.models.Produto;
import com.api.apiprodutos.respositories.ProdutoRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class ProdutoService.
 */
@Service
public class ProdutoService {

	/** The produto repository. */
	@Autowired
	private ProdutoRepository produtoRepository;
	
	/**
	 * Inserir produto.
	 *
	 * @param produto the produto
	 * @return the produto
	 */
	public Produto inserirProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	/**
	 * Buscar todos produtos.
	 *
	 * @return the list
	 */
	public List<Produto> buscarTodosProdutos(){
		return produtoRepository.findAll();
	}
	
	/**
	 * Buscar um produto.
	 *
	 * @param id the id
	 * @return the produto
	 */
	public Produto buscarUmProduto(Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto.orElseThrow();
	}
	
	/**
	 * Deletar produto.
	 *
	 * @param id the id
	 */
	public void deletarProduto(Long id) {
		produtoRepository.deleteById(id);
	}
	
	/**
	 * Editar produto.
	 *
	 * @param produto the produto
	 * @return the produto
	 */
	public Produto editarProduto(Produto produto) {
		buscarUmProduto(produto.getId());
		return produtoRepository.save(produto);
	}
	
}
