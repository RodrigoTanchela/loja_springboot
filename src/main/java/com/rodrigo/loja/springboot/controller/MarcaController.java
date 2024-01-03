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

import com.rodrigo.loja.springboot.model.vo.v1.MarcaVO;
import com.rodrigo.loja.springboot.service.MarcaServices;
import com.rodrigo.loja.springboot.utils.MediaType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = {"http://localhost:3000,http://localhost:8080,https://rodrigo.com.br"})
@RestController
@RequestMapping("/api/marca/v1")
@Tag(name = "Marca", description = "Endpoints for Managing Marca")
public class MarcaController {
	
	@Autowired
	private MarcaServices service;
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML})
	@Operation(summary = "Busca todas as marcas", description = "Busca as marcas cadastradas",
	tags = {"Marca"}, responses = {
			@ApiResponse(responseCode = "200", description = "Ok", content = @Content(schema = @Schema(implementation = MarcaVO.class))),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
	public List<MarcaVO> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML})
	@Operation(summary = "Busca marca por id", description = "Busca uma marca pelo id informado pela url",
	tags = {"Marca"}, responses = {
			@ApiResponse(responseCode = "200", description = "Ok", content = @Content(schema = @Schema(implementation = MarcaVO.class))),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
	public MarcaVO findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML},
			produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML})
	@Operation(summary = "Cria uma marca", description = "Cria uma marca",
	tags = {"Marca"}, responses = {
			@ApiResponse(responseCode = "200", description = "Ok", content = @Content(schema = @Schema(implementation = MarcaVO.class))),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
	public MarcaVO create(@RequestBody MarcaVO marca) {
		return service.create(marca);
	}
	
	@PutMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML},
			produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML})
	@Operation(summary = "atualiza marca por id", description = "Atualiza uma marca",
	tags = {"Marca"}, responses = {
			@ApiResponse(responseCode = "200", description = "Ok", content = @Content(schema = @Schema(implementation = MarcaVO.class))),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
	public MarcaVO update(@RequestBody MarcaVO marca) {
		return service.update(marca);
	}
	
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Deleta marca por id", description = "Deleta uma marca pelo id informado pela url",
	tags = {"Marca"}, responses = {
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
