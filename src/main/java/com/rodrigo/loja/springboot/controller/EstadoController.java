package com.rodrigo.loja.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigo.loja.springboot.model.vo.v1.EstadoVO;
import com.rodrigo.loja.springboot.service.EstadoServices;

@RestController
@RequestMapping("/api/estado/v1")
public class EstadoController {
	
	@Autowired
	private EstadoServices service;
	
	@GetMapping
	public List<EstadoVO> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public EstadoVO findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public EstadoVO create(@RequestBody EstadoVO estado) {
		return service.create(estado);
	}
	
	@PutMapping
	public EstadoVO update(@RequestBody EstadoVO estado) {
		return service.update(estado);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
