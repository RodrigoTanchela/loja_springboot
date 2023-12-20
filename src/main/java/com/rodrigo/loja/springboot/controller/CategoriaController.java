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

import com.rodrigo.loja.springboot.model.vo.v1.CategoriaVO;
import com.rodrigo.loja.springboot.service.CategoriaServices;

@RestController
@RequestMapping("/api/categoria/v1")
public class CategoriaController {
	
	@Autowired
	private CategoriaServices service;
	
	@GetMapping
	public List<CategoriaVO> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public CategoriaVO findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public CategoriaVO create(@RequestBody CategoriaVO categoria) {
		return service.create(categoria);
	}
	
	@PutMapping
	public CategoriaVO update(@RequestBody CategoriaVO categoria) {
		return service.update(categoria);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
