package com.rodrigo.loja.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodrigo.loja.springboot.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
