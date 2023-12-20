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

import com.rodrigo.loja.springboot.model.vo.v1.MarcaVO;
import com.rodrigo.loja.springboot.service.MarcaServices;

@RestController
@RequestMapping("/api/marca/v1")
public class MarcaController {
	
	@Autowired
	private MarcaServices service;
	
	@GetMapping
	public List<MarcaVO> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public MarcaVO findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public MarcaVO create(@RequestBody MarcaVO marca) {
		return service.create(marca);
	}
	
	@PutMapping
	public MarcaVO update(@RequestBody MarcaVO marca) {
		return service.update(marca);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
