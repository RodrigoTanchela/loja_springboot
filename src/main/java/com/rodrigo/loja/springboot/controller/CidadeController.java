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

import com.rodrigo.loja.springboot.model.vo.v1.CidadeVO;
import com.rodrigo.loja.springboot.service.CidadeServices;
import com.rodrigo.loja.springboot.utils.MediaType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/cidade/v1")
@CrossOrigin(origins = {"http://localhost:3000,http://localhost:8080,https://rodrigo.com.br"})
@Tag(name = "Cidade", description = "Endpoints for Managing Cidade")
public class CidadeController {
	
	@Autowired
	private CidadeServices service;
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML})
	@Operation(summary = "Busca todas as cidades", description = "Busca as cidades cadastradas",
	tags = {"Cidade"}, responses = {
			@ApiResponse(responseCode = "200", description = "Ok", content = @Content(schema = @Schema(implementation = CidadeVO.class))),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
	public List<CidadeVO> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML})
	@Operation(summary = "Busca cidade por id", description = "Busca uma cidade pelo id informado pela url",
	tags = {"Cidade"}, responses = {
			@ApiResponse(responseCode = "200", description = "Ok", content = @Content(schema = @Schema(implementation = CidadeVO.class))),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
	public CidadeVO findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML},
			produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML})
	@Operation(summary = "Cria uma cidade", description = "Busca uma cidade pelo id informado pela url",
	tags = {"Cidade"}, responses = {
			@ApiResponse(responseCode = "200", description = "Ok", content = @Content(schema = @Schema(implementation = CidadeVO.class))),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
	public CidadeVO create(@RequestBody CidadeVO cidade) {
		return service.create(cidade);
	}
	
	@PutMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML},
			produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML})
	@Operation(summary = "atualiza os dados cidade", description = "Busca uma cidade pelo id informado pela url",
	tags = {"Cidade"}, responses = {
			@ApiResponse(responseCode = "200", description = "Ok", content = @Content(schema = @Schema(implementation = CidadeVO.class))),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
	public CidadeVO update(@RequestBody CidadeVO cidade) {
		return service.update(cidade);
	}
	
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Deleta cidade por id", description = "Deleta uma cidade pelo id informado pela url",
	tags = {"Cidade"}, responses = {
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
