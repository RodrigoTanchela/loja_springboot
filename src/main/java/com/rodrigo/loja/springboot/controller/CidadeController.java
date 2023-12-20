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

import com.rodrigo.loja.springboot.model.vo.v1.CidadeVO;
import com.rodrigo.loja.springboot.service.CidadeServices;

@RestController
@RequestMapping("/api/cidade/v1")
public class CidadeController {
	
	@Autowired
	private CidadeServices service;
	
	@GetMapping
	public List<CidadeVO> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public CidadeVO findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public CidadeVO create(@RequestBody CidadeVO cidade) {
		return service.create(cidade);
	}
	
	@PutMapping
	public CidadeVO update(@RequestBody CidadeVO cidade) {
		return service.update(cidade);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
