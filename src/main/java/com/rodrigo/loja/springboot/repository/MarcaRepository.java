package com.rodrigo.loja.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodrigo.loja.springboot.model.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long> {

}
