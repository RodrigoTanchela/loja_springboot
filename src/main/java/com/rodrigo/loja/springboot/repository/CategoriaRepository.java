package com.rodrigo.loja.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodrigo.loja.springboot.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
