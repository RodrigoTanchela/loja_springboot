package com.rodrigo.loja.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigo.loja.springboot.model.vo.v1.ProdutoVO;
import com.rodrigo.loja.springboot.service.ProdutoServices;
import com.rodrigo.loja.springboot.utils.MediaType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/produto/v1")
@Tag(name = "Produto", description = "Endpoints for Managing Produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoServices service;
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML})
	@CrossOrigin(origins = {"http://localhost:3000,http://localhost:8080,https://rodrigo.com.br"})
	@Operation(summary = "Busca todas as produtos", description = "Busca as produtos cadastradas",
	tags = {"Produto"}, responses = {
			@ApiResponse(responseCode = "200", description = "Ok", content = @Content(schema = @Schema(implementation = ProdutoVO.class))),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
	public List<ProdutoVO> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML})
	@CrossOrigin(origins = {"http://localhost:3000,http://localhost:8080,https://rodrigo.com.br"})
	@Operation(summary = "Busca produto por id", description = "Busca uma produto pelo id informado pela url",
	tags = {"Produto"}, responses = {
			@ApiResponse(responseCode = "200", description = "Ok", content = @Content(schema = @Schema(implementation = ProdutoVO.class))),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
	public ProdutoVO findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML},
			produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML})
	@CrossOrigin(origins = {"http://localhost:3000,http://localhost:8080,https://rodrigo.com.br"})
	@Operation(summary = "Cria uma produto", description = "Cria uma produto",
	tags = {"Produto"}, responses = {
			@ApiResponse(responseCode = "200", description = "Ok", content = @Content(schema = @Schema(implementation = ProdutoVO.class))),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
	public ProdutoVO create(@RequestBody ProdutoVO produto) {
		return service.create(produto);
	}
	
	@PutMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML},
			produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML})
	@Operation(summary = "atualiza produto por id", description = "Atualiza uma produto",
	tags = {"Produto"}, responses = {
			@ApiResponse(responseCode = "200", description = "Ok", content = @Content(schema = @Schema(implementation = ProdutoVO.class))),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
	public ProdutoVO update(@RequestBody ProdutoVO produto) {
		return service.update(produto);
	}
	
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Deleta produto por id", description = "Deleta uma produto pelo id informado pela url",
	tags = {"Produto"}, responses = {
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
