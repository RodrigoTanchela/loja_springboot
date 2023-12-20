package com.rodrigo.loja.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodrigo.loja.springboot.model.Cidade;


public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
