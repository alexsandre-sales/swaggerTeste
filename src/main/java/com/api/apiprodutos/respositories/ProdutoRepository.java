package com.api.apiprodutos.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.apiprodutos.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
