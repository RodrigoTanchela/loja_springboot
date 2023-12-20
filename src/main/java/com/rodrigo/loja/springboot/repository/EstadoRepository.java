package com.rodrigo.loja.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodrigo.loja.springboot.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
